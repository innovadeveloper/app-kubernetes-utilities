package com.innovaappstar.kubernetes.utility.constants;

public enum FileResourcesEnum {
    PV_DEFINITION("kubernetes/pv_definition.yaml"),
    POD_DEFINITION("kubernetes/not_found.yaml"),
    PVC_DEFINITION("kubernetes/pvc_definition.yaml"),
    DEPLOYMENT_DEFINITION("kubernetes/deployment_definition.yaml"),
    EMPTY_DEFINITION("kubernetes/empty.yaml"),
    CLUSTER_ROLE_DEFINITION("kubernetes/cluster_role.yaml"),
    CLUSTER_ROLE_BINDING_DEFINITION("kubernetes/cluster_role_binding.yaml"),
    SECRETS_DEFINITION("kubernetes/secrets.yaml"),

    SECRET_DEFINITION_EXAMPLE("kubernetes/examples/create_secret_with_cli.yaml"),
    DEPLOYMENT_DEFINITION_EXAMPLE("kubernetes/examples/deployment.yaml"),
    POD_DEFINITION_EXAMPLE("kubernetes/examples/pod.yaml"),
    PV_DEFINITION_EXAMPLE("kubernetes/examples/pv.yaml"),
    PVC_DEFINITION_EXAMPLE("kubernetes/examples/pvc.yaml"),
    SERVICE_DEFINITION_EXAMPLE("kubernetes/examples/service.yaml")

    ;
    // Agrega más rutas según tus necesidades

    private final String path;

    private FileResourcesEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

