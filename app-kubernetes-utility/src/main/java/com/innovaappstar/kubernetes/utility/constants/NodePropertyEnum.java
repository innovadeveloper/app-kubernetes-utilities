package com.innovaappstar.kubernetes.utility.constants;

public enum NodePropertyEnum {
    KIND("items.kind"),
    METADATA_NAME("items.metadata.name"),
    METADATA_NAMESPACE("items.metadata.namespace"),
    METADATA_UID("items.metadata.uid"),
    METADATA_CREATION_TIMESTAMP("items.metadata.creationTimestamp")
    ;

    String value;

    NodePropertyEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

