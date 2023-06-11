package com.innovaappstar.kubernetes.utility.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.innovaappstar.kubernetes.utility.business.Executor;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



public class PodsExecutor extends BaseExecutor implements Executor {
    @Override
    public List<String[]> process() {
//        PodList podList = new KubernetesApiFacade().getPods();
        JsonNode jsonNode = JsonUtils.convertToJsonNode(new KubernetesApiFacade().getPods());
        return super.toConvertToListString(jsonNode);
    }

}
