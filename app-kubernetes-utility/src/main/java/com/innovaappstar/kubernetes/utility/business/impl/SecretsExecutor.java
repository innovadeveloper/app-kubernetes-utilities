package com.innovaappstar.kubernetes.utility.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.innovaappstar.kubernetes.utility.business.Executor;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;
import com.innovaappstar.kubernetes.utility.utils.JsonUtils;

import java.util.List;


public class SecretsExecutor extends BaseExecutor implements Executor {
    @Override
    public List<String[]> process() {
//        Object data = new KubernetesApiFacade().getClusterRoleBindingList();
        JsonNode jsonNode = JsonUtils.convertToJsonNode(new KubernetesApiFacade().getSecrets());
        return super.toConvertToListString(jsonNode);
    }
}
