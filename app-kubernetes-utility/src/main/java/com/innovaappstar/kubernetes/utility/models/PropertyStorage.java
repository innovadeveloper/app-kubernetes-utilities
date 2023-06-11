package com.innovaappstar.kubernetes.utility.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyStorage {
    String privateKeyPath;
    String certificatePath;
    String hostname;

}
