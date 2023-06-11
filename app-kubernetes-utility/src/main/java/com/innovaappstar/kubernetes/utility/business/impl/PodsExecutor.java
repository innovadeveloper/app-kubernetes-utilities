package com.innovaappstar.kubernetes.utility.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.innovaappstar.kubernetes.utility.business.Executor;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;
import com.innovaappstar.kubernetes.utility.constants.NodePropertyEnum;
import com.innovaappstar.kubernetes.utility.utils.JsonUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import io.fabric8.kubernetes.api.model.PodList;


public class PodsExecutor extends BaseExecutor implements Executor {
    @Override
    public List<String[]> process() {
        PodList podList = new KubernetesApiFacade().getPods();
        JsonNode jsonNode = JsonUtils.convertToJsonNode(new KubernetesApiFacade().getPods());
        return super.toConvertToListString(jsonNode);
    }

    @Override
    public String[] getPathItemList(){
        String[] extraValues = {"items.status.hostIP",
        "items.status.podIP",
        "items.status.startTime"};
        return JsonUtils.mergeArrays(extraValues, super.getPathItemList());
    }



}
