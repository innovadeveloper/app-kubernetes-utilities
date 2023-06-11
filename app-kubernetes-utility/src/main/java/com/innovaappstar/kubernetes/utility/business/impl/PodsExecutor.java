package com.innovaappstar.kubernetes.utility.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.innovaappstar.kubernetes.utility.business.Executor;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.fabric8.kubernetes.api.model.PodList;


public class PodsExecutor implements Executor {
    @Override
    public List<String[]> process() {
//        PodList podList = new KubernetesApiFacade().getPods();
        JsonNode jsonNode = JsonUtils.convertToJsonNode(new KubernetesApiFacade().getPods());
        List<List<String>> itemList = Arrays.stream(getPathItemList()).map((pathItem) -> JsonUtils.getNodeValues(jsonNode, pathItem)).collect(Collectors.toList());
        return JsonUtils.mergeLists(itemList);
//
//        return new KubernetesApiFacade().getPods().getItems().stream()
//                .map((item) -> new String[]{
//                        item.getMetadata().getName(), item.getMetadata().getNamespace()
//                }).collect(Collectors.toList());
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
