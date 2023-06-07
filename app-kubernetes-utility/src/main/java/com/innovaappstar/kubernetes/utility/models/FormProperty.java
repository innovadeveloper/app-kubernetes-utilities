package com.innovaappstar.kubernetes.utility.models;

import com.innovaappstar.kubernetes.utility.constants.FormPropertyEnum;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FormProperty {
    String resourcePath;
    String formDescription;
    FormPropertyEnum formPropertyEnum;
}
