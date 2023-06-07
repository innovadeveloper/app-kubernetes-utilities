package com.innovaappstar.kubernetes.utility.business;

// Interfaz ProcessorMediator
public interface ProcessorMediator {
    void saveAndApply(String path);
    void save(String path);
    void openEditor(String resource);   // abre editor yaml con un recurso específico
}
