package com.innovaappstar.kubernetes.utility.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.javaparser.utils.Pair;
import com.innovaappstar.kubernetes.utility.business.Executor;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.fabric8.kubernetes.api.model.apps.DeploymentList;


public class DeploymentsExecutor implements Executor {
    @Override
    public List<String[]> process() {
        JsonNode jsonNode = JsonUtils.convertToJsonNode(new KubernetesApiFacade().getDeployments());
        List<List<String>> itemList = Arrays.stream(getPathItemList()).map((pathItem) -> JsonUtils.getNodeValues(jsonNode, pathItem)).collect(Collectors.toList());
        return JsonUtils.mergeLists(itemList);
    }

    @Override
    public String[] getPathItemList(){
        return new String[]{
            "items.kind",
            "items.metadata.name",
            "items.metadata.namespace",
            "items.metadata.uid",
            "items.metadata.creationTimestamp"
        };
    }

}
