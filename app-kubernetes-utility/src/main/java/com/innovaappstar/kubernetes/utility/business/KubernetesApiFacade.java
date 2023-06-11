package com.innovaappstar.kubernetes.utility.business;

import java.util.ArrayList;
import java.util.List;

import io.fabric8.kubernetes.api.model.PersistentVolumeClaimList;
import io.fabric8.kubernetes.api.model.PersistentVolumeList;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.api.model.SecretList;
import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleBindingList;
import io.fabric8.kubernetes.api.model.rbac.ClusterRoleList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class KubernetesApiFacade {

    private static Config config;

    private static Config getConfigClient(){
        String url = "https://192.168.64.3:16443";
        if(config == null){
            config = new ConfigBuilder()
                    .withMasterUrl(url)
                    .withTrustCerts(true)  // Configurar si se debe confiar en los certificados del servidor
                    .withClientCertFile("/Users/kennybaltazaralanoca/Files/certificates/baltazar.crt")
                    .withClientKeyFile("/Users/kennybaltazaralanoca/Files/certificates/baltazar.key")
                    .build();
        }
        return config;
    }

    public PodList getPods(){
        KubernetesClient client = new DefaultKubernetesClient(KubernetesApiFacade.getConfigClient());
        return client.pods().inAnyNamespace().list();
    }

    public DeploymentList getDeployments(){
        KubernetesClient client = new DefaultKubernetesClient(KubernetesApiFacade.getConfigClient());
        return client.apps().deployments().inAnyNamespace().list();
    }

    public SecretList getSecrets(){
        KubernetesClient client = new DefaultKubernetesClient(KubernetesApiFacade.getConfigClient());
        return client.secrets().list();
    }

    public PersistentVolumeList getPersistentVolumeList(){
        KubernetesClient client = new DefaultKubernetesClient(KubernetesApiFacade.getConfigClient());
        return client.persistentVolumes().list();
    }

    public PersistentVolumeClaimList getPersistentVolumeClaimList(){
        KubernetesClient client = new DefaultKubernetesClient(KubernetesApiFacade.getConfigClient());
        return client.persistentVolumeClaims().list();
    }

    public ClusterRoleList getClusterRoleList(){
        KubernetesClient client = new DefaultKubernetesClient(KubernetesApiFacade.getConfigClient());
        return client.rbac().clusterRoles().list();
    }

    public ClusterRoleBindingList getClusterRoleBindingList(){
        KubernetesClient client = new DefaultKubernetesClient(KubernetesApiFacade.getConfigClient());
        return client.rbac().clusterRoleBindings().list();
    }



//
//    public List<ArrayList<String>> getKubernetesElements(FormPropertyEnum formPropertyEnum){
//        return new ArrayList<>();
////
////        if(formPropertyEnum == FormPropertyEnum.PV){
//////            Object data = new KubernetesController.Builder().build().listAllPV();
////            return new KubernetesController.Builder().build().listAllPV();
////        }else if(formPropertyEnum == FormPropertyEnum.PVC){
////            return new KubernetesController.Builder().build().listAllPVC();
////        }
////        throw new UnsupportedOperationException("method unsupported");
//    }

}
