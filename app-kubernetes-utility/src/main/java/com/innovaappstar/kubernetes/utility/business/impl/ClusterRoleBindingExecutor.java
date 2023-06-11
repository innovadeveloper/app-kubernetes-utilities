package com.innovaappstar.kubernetes.utility.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.innovaappstar.kubernetes.utility.business.Executor;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class ClusterRoleBindingExecutor implements Executor {
    @Override
    public List<String[]> process() {
//        Object data = new KubernetesApiFacade().getClusterRoleBindingList();
        JsonNode jsonNode = JsonUtils.convertToJsonNode(new KubernetesApiFacade().getClusterRoleBindingList());
        List<List<String>> itemList = Arrays.stream(getPathItemList()).map((pathItem) -> JsonUtils.getNodeValues(jsonNode, pathItem)).collect(Collectors.toList());
        return JsonUtils.mergeLists(itemList);
    }

    @Override
    public String[] getPathItemList() {
        return new String[]{
                "items.kind",
                "items.metadata.name",
                "items.metadata.namespace",
                "items.metadata.uid",
                "items.metadata.creationTimestamp"
        };
    }
}
