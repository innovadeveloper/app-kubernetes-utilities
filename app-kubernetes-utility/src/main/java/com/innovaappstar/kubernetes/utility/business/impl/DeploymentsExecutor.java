package com.innovaappstar.kubernetes.utility.business.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.javaparser.utils.Pair;
import com.innovaappstar.kubernetes.utility.business.Executor;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;
import com.innovaappstar.kubernetes.utility.utils.JsonUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.fabric8.kubernetes.api.model.apps.DeploymentList;


public class DeploymentsExecutor extends BaseExecutor implements Executor {
    @Override
    public List<String[]> process() {
        JsonNode jsonNode = JsonUtils.convertToJsonNode(new KubernetesApiFacade().getDeployments());
        return super.toConvertToListString(jsonNode);
    }

    // todo : CONSTRUIR CONSTANTE DE NODE_PATH (LISTO)
    // todo : Construir COMBOBOX QUE LISTE LOS TIPOS (LIST)
    // TODO : REFACTORIZAR Y MOVER EL UTILS A UN PACKAGE UTILS (Listo)
    // TODO : IMPLEMENTAR EVENTOS DE OPEN EDITOR
    // TODO : MODIFICAR LA UI PARA Q NO SALGA MODO EVALUACION  (OMITOR)
}
