package com.innovaappstar.groovy.utility.utils

import javax.swing.JFileChooser
import java.awt.Component
import java.nio.file.Files
import java.nio.file.Paths

import io.kubernetes.client.ApiClient
import io.kubernetes.client.ApiException
import io.kubernetes.client.Configuration
import io.kubernetes.client.apis.CoreV1Api
import io.kubernetes.client.models.V1Pod
import io.kubernetes.client.models.V1PodList
import io.kubernetes.client.util.Config
import io.kubernetes.client.util.KubeConfig
import io.kubernetes.client.util.authenticators.GCPAuthenticator


class FileUtils {
    static String getMessage(String message){
        def pwdCommand = "pwd".execute().text
        def lsCommand = "ls".execute().text.split("\n")
        println(pwdCommand)
        println("___________")
        println(lsCommand)

        def a= Paths.get(pwdCommand)toAbsolutePath()
        def currentDir = Paths.get(pwdCommand).toAbsolutePath().toString()
        def files2 = Files.list(Paths.get(currentDir))

        def files = Files.list(Paths.get(currentDir))
                .filter { Files.isRegularFile(it) }
                .map { it.getFileName().toString() }
                .toList()

        files.each { fileName ->
            println(fileName)
        }
        return "hola " + message
    }

    static String choosePath(Component parent){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int result = fileChooser.showOpenDialog(parent);
        if (result == JFileChooser.APPROVE_OPTION) {
            String selectedFilePath = fileChooser.getSelectedFile().getPath();
            return selectedFilePath
//            etOutputFilePath.setText(selectedFilePath);
//            // Hacer algo con la ruta seleccionada
//            System.out.println("Selected file/directory: " + selectedFilePath);
        }
        return null
    }

    static def printKubernetes(){

        KubeConfig.registerAuthenticator(new GCPAuthenticator());
        ApiClient apiClient = Config.defaultClient();
//    apiClient.setUsername("admin");
        apiClient.setVerifyingSsl(false)
        apiClient.setBasePath("https://192.168.64.3:16443")
        apiClient.setApiKey("cnpFNFVlUTRESjNleTg4M0ZwYlFOSlQwczUrSVJXK1ZBejl6NWRhZXRaST0K")
        Configuration.setDefaultApiClient(apiClient);

        CoreV1Api api = new CoreV1Api();
        try {
            V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null,
                    null, null);
            for (V1Pod item : list.getItems()) {
                System.out.println(item.getMetadata().getName());
            }
        } catch (ApiException e) {
            System.out.println(e);
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
        }
    }
}
