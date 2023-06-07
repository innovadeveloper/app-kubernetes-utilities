package com.innovaappstar.kubernetes.utility.business;

import com.innovaappstar.groovy.utility.business.kubectl.KubernetesController;
import com.innovaappstar.kubernetes.utility.constants.FileResourcesEnum;
import com.innovaappstar.kubernetes.utility.constants.FormPropertyEnum;

import java.util.ArrayList;
import java.util.List;

public class KubernetesApiFacade {

    public List<ArrayList<String>> getKubernetesElements(FormPropertyEnum formPropertyEnum){
        if(formPropertyEnum == FormPropertyEnum.PV){
//            Object data = new KubernetesController.Builder().build().listAllPV();
            return new KubernetesController.Builder().build().listAllPV();
        }else if(formPropertyEnum == FormPropertyEnum.PVC){
            return new KubernetesController.Builder().build().listAllPVC();
        }
        throw new UnsupportedOperationException("method unsupported");
    }

}
