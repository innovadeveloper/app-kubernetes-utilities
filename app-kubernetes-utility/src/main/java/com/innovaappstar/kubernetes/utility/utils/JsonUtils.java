package com.innovaappstar.kubernetes.utility.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.fabric8.kubernetes.api.model.apps.DeploymentList;
import lombok.SneakyThrows;

public class JsonUtils {


    @SneakyThrows
    public static void main(String[] args) {
        DeploymentList deploymentTotalList = new KubernetesApiFacade().getDeployments();
        JsonNode deploymentTotalListJson = convertToJsonNode(deploymentTotalList);
        String kindTypePath = "items.kind";
        String nameDeploymentPath = "items.metadata.name";
        String nameSpaceDeploymentPath = "items.metadata.namespace";
        String uidDeploymentPath = "items.metadata.uid";
        String creationTimestampPath = "items.metadata.creationTimestamp";
        List<String> kindType = getNodeValues(deploymentTotalListJson, kindTypePath);
        List<String> nameDeployment = getNodeValues(deploymentTotalListJson, nameDeploymentPath);
        List<String> nameSpaceDeployment = getNodeValues(deploymentTotalListJson, nameSpaceDeploymentPath);
        List<String> uidDeployment = getNodeValues(deploymentTotalListJson, uidDeploymentPath);
        List<String> creationTimestamp = getNodeValues(deploymentTotalListJson, creationTimestampPath);


        System.out.println("Dificultades: ");
    }

    private static JsonNode mergeJsonNodes(List<JsonNode> nodes) {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode mergedNode = objectMapper.createArrayNode();
        for (JsonNode node : nodes) {
            if (node.isArray()) {
                mergedNode.addAll((ArrayNode) node);
            } else {
                mergedNode.add(node);
            }
        }
        return mergedNode;
    }

    public static List<String> getNodeValues(JsonNode jsonNode, String path) {
        String[] pathSegments = path.split("\\.");

        JsonNode currentNode = jsonNode;
        for (String segment : pathSegments) {
            if (currentNode.isArray()) {
                List<JsonNode> nodes = new ArrayList<>();
                for (JsonNode arrayNode : currentNode) {
                    if (arrayNode.has(segment)) {
                        nodes.add(arrayNode.get(segment));
                    }
                }
                if (nodes.isEmpty()) {
                    return null;
                }
                currentNode = mergeJsonNodes(nodes);
            } else {
                if (currentNode.has(segment)) {
                    currentNode = currentNode.get(segment);
                } else {
                    return null;
                }
            }
        }

        List<String> values = new ArrayList<>();
        if (currentNode.isArray()) {
            for (JsonNode node : currentNode) {
                if (node.isValueNode()) {
                    values.add(node.asText());
                }
            }
        }

        return values;
    }

    private static JsonNode parseJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(json);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JsonNode convertToJsonNode(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        return objectMapper.valueToTree(object);
    }


    public static List<String[]> mergeLists(List<List<String>> lists) {
        List<String[]> mergedList = new ArrayList<>();

        // Verificar si las listas están vacías o tienen tamaños diferentes
        if (lists.isEmpty() || lists.get(0).isEmpty()) {
            return mergedList;
        }

        int listSize = lists.get(0).size();

        // Iterar sobre el tamaño de las listas
        for (int i = 0; i < listSize; i++) {
            String[] mergedArray = new String[lists.size()];

            // Fusionar los elementos en la posición actual
            for (int j = 0; j < lists.size(); j++) {
                List<String> currentList = lists.get(j);
                if(currentList == null)
                    mergedArray[j] = "null";
                else
                    mergedArray[j] = currentList.get(i);
            }

            // Agregar el arreglo fusionado a la lista resultante
            mergedList.add(mergedArray);
        }

        return mergedList;
    }

    public static int indexOf(String[] array, String valorBuscado) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(valorBuscado)) {
                return i;
            }
        }
        return -1; // Valor de retorno si no se encuentra el elemento
    }

    public static String getLastWordAfterLastDot(String input) {
        int lastDotIndex = input.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return input;
        }
        return input.substring(lastDotIndex + 1);
    }
}
