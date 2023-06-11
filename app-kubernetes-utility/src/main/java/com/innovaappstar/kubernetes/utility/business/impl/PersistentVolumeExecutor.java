package com.innovaappstar.kubernetes.utility.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.innovaappstar.kubernetes.utility.business.Executor;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class PersistentVolumeExecutor extends BaseExecutor implements Executor {
    @Override
    public List<String[]> process() {
//        Object data = new KubernetesApiFacade().getPersistentVolumeList();
        JsonNode jsonNode = JsonUtils.convertToJsonNode(new KubernetesApiFacade().getPersistentVolumeList());
        return super.toConvertToListString(jsonNode);
    }


}
