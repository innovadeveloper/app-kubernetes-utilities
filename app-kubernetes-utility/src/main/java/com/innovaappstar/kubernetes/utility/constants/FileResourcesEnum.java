package com.innovaappstar.kubernetes.utility.constants;

public enum FileResourcesEnum {
    PV_DEFINITION("kubernetes/pv_definition.yaml"),
    PVC_DEFINITION("kubernetes/pvc_definition.yaml"),
    DEPLOYMENT_DEFINITION("kubernetes/deployment_definition.yaml"),
    EMPTY_DEFINITION("kubernetes/empty.yaml");
    // Agrega más rutas según tus necesidades

    private final String path;

    private FileResourcesEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

