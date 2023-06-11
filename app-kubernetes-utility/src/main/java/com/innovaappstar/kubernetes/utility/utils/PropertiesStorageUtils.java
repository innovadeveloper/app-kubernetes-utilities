package com.innovaappstar.kubernetes.utility.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.innovaappstar.kubernetes.utility.models.PropertyStorage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import lombok.SneakyThrows;

public class PropertiesStorageUtils {
    static String configPath = "config.properties";
    static String propertyStorageKey = "property.storage";

    public static void writeProperties(PropertyStorage propertyStorage) {
        Properties properties = new Properties();

        try (FileOutputStream fos = new FileOutputStream(configPath)) {
            properties.setProperty(propertyStorageKey, new ObjectMapper().writeValueAsString(propertyStorage));
            // Guardar propiedades en el archivo
            properties.store(fos, "Configuración de la base de datos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static PropertyStorage readProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(configPath)) {
            properties.load(fis);
            String propertyStorage = properties.getProperty(propertyStorageKey);
            return new ObjectMapper().readValue(propertyStorage, PropertyStorage.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
