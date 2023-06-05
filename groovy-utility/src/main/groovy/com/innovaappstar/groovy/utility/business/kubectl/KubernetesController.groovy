package com.innovaappstar.groovy.utility.business.kubectl


import io.kubernetes.client.ApiClient
import io.kubernetes.client.ApiException
import io.kubernetes.client.Configuration
import io.kubernetes.client.apis.CoreV1Api
import io.kubernetes.client.models.V1PersistentVolume
import io.kubernetes.client.models.V1PersistentVolumeClaimList
import io.kubernetes.client.models.V1PersistentVolumeList
import io.kubernetes.client.models.V1Pod
import io.kubernetes.client.models.V1PodList
import io.kubernetes.client.util.Config
import io.kubernetes.client.util.KubeConfig
import io.kubernetes.client.util.authenticators.GCPAuthenticator

import io.kubernetes.client.util.Config
import io.kubernetes.client.util.KubeConfig
import io.kubernetes.client.util.authenticators.GCPAuthenticator


class KubernetesController {
    ApiClient apiClient
    private KubernetesController() {
        KubeConfig.registerAuthenticator(new GCPAuthenticator())
        apiClient = Config.defaultClient()
        apiClient.setVerifyingSsl(false)
        apiClient.setBasePath("https://192.168.64.3:16443")
        apiClient.setApiKey("cnpFNFVlUTRESjNleTg4M0ZwYlFOSlQwczUrSVJXK1ZBejl6NWRhZXRaST0K")
        Configuration.setDefaultApiClient(apiClient)
    }

    static class Builder {
        KubernetesController build() {
            new KubernetesController()
        }
    }


//  ----------------------------

//    def startShell() {
//        def processBuilder = new ProcessBuilder("zsh", "-i")
//        Process process = processBuilder.start()
//
//        // Obtener el flujo de entrada de la shell
//        InputStream inputStream = process.getInputStream()
//
//        // Obtener el flujo de salida de la shell
//        OutputStream outputStream = process.getOutputStream()
//
//        // Obtener el flujo de error de la shell
//        InputStream errorStream = process.getErrorStream()
//
//        // Crear un lector para leer la salida de la shell
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
//
//        // Crear un escritor para enviar comandos a la shell
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))
//
//        // Crear un hilo para leer la salida de la shell
//        Thread readerThread = new Thread({
//            String line
//            while ((line = reader.readLine()) != null) {
//                println("Respuesta general: ${line}")
//                try {
//                    def readerObj = reader
//                    def currentValue= reader.readLine()
//                    println(currentValue)
//                }catch (Exception e){
//                    e.printStackTrace()
//                }
//            }
//            reader.close()  // Cerrar el flujo de lectura
//        })
//
//        readerThread.start()
//
//        sendCommand("kubectl apply -f \$HOME/Downloads/custom_pv.yaml", writer)
//
////        // Esperar a que el hilo de lectura de la salida de la shell termine
//        readerThread.join()
//
//        // Cerrar los flujos y esperar a que finalice la shell
//        inputStream.close()
//        outputStream.close()
//        errorStream.close()
//        process.waitFor()
//    }
//
//    def sendCommand(command, writer) {
//        try {
//            // Enviar el comando a la shell
//            writer.write(command + "\n")
//            writer.flush()
//        } catch (IOException e) {
//            println("Error al enviar el comando: ${e.getMessage()}")
//        }
//    }


    def startShell(command) {
//        def command = "kubectl apply -f \$HOME/Downloads/custom_pv.yaml"
        def processBuilder = new ProcessBuilder("zsh", "-i", "-c", command)
        Process process = processBuilder.start()

        // Obtener el flujo de entrada de la shell
        InputStream inputStream = process.getInputStream()

        // Obtener el flujo de error de la shell
        InputStream errorStream = process.getErrorStream()

        // Crear un lector para leer la salida de la shell
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))

        // Crear un lector para leer el flujo de error de la shell
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorStream))

        // Crear un hilo para leer la salida de la shell
        Thread readerThread = new Thread({
            String line
            while ((line = reader.readLine()) != null) {
                println("Respuesta general: ${line}")
            }
        })
        readerThread.start()

        // Crear un hilo para leer el flujo de error de la shell
        Thread errorReaderThread = new Thread({
            String line
            while ((line = errorReader.readLine()) != null) {
                println("Error de la shell: ${line}")
            }
        })
        errorReaderThread.start()

        // Esperar a que finalice el proceso de la shell
        process.waitFor()

        // Esperar a que el hilo de lectura de la salida de la shell termine
        readerThread.join()

        // Esperar a que el hilo de lectura del flujo de error de la shell termine
        errorReaderThread.join()

        // Cerrar los flujos
        inputStream.close()
        errorStream.close()
    }


//    ----------------



    def executeKubectlCommands(){
        try {
            def command = "kubectl apply -f \$HOME/Downloads/custom_pv.yaml"
            startShell(command)
            println("___")
        }catch (Exception e){
            e.printStackTrace()
        }
//        try {
//            println(System.getProperty("user.name"))
//
//            def processOne = "kubectl -h".execute()
//            processOne.waitFor()
//            def responseCommandOne = processOne.text
//
//            def processTwo = "sudo kubectl get pods".execute()
//            processTwo.waitFor()
//            def responseCommandTwo = processTwo.text
//
//            def processThree = "kubectl apply -f /Users/kennybaltazaralanoca/Downloads/custom_pv.yaml".execute()
//            processThree.waitFor()
//            def responseCommandThree = processThree.text
//
//            println("___")
//        } catch (Exception e) {
//            e.printStackTrace()
//        }
    }

    def listPods() {
        try {
            CoreV1Api api = new CoreV1Api();
            V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null,
                    null, null)
            return list.items.collect { pod -> return new String[]{pod.metadata.namespace, pod.metadata.name} }
        } catch (ApiException e) {
            System.out.println(e);
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
            return null
        }
    }
    def listAllPV() {
        try {
            CoreV1Api api = new CoreV1Api();
            V1PersistentVolumeList list = api.listPersistentVolume(null, null, null, null, null, null, null,
                    null, null)
            return list.items.collect { pod -> return new String[]{pod.metadata.namespace != null? pod.metadata.namespace : "" , pod.metadata.name} }
        } catch (ApiException e) {
            System.out.println(e);
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
            return null
        }
    }


    def listAllPVC() {
        try {
            CoreV1Api api = new CoreV1Api();
            V1PersistentVolumeClaimList list = api.listPersistentVolumeClaimForAllNamespaces(null, null, null, null, null, null, null,
                    null, null)
            return list.items.collect { pod -> return new String[]{pod.metadata.namespace != null? pod.metadata.namespace : "", pod.metadata.name} }
        } catch (ApiException e) {
            System.out.println(e);
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
            return null
        }
    }

    String executeDefinitionFile(String path){
//        String filePath = '/Users/kennybaltazaralanoca/Downloads/custom_pv.yaml'
        def command = "kubectl apply -f $path"
        startShell(command)
    }

    String createPersistentVolumeFromFile(String filePath) {
        try {
            // Cargar la configuración de KubeConfig
//            ApiClient apiClient = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfigFromDefaultLocation()).build()
//            Configuration.setDefaultApiClient(apiClient)

            // Crear una instancia de la API de CoreV1Api
            CoreV1Api coreV1Api = new CoreV1Api(apiClient)

            // Leer el contenido del archivo YAML
            String yamlContent = new File(filePath).text

            // Convertir el contenido YAML a un objeto V1PersistentVolume
            V1PersistentVolume pv = (V1PersistentVolume) Yaml.load(yamlContent)

            // Crear el Persistent Volume
            coreV1Api.createNamespacePersistentVolume(pv.getMetadata().getNamespace(), pv, null, null, null)

            return "Persistent Volume creado exitosamente."
        } catch (Exception e) {
            return "Error al crear el Persistent Volume: ${e.getMessage()}"
        }
    }






    def listDeployments() {
        try {
            // Crear el cliente de la API

            // Crear una instancia de la API de AppsV1Api para trabajar con deployments
//            AppsV1Api appsV1Api = new AppsV1Api(apiClient)

            // Obtener la lista de deployments
            def deployments = appsV1Api.listDeploymentForAllNamespaces(null, null, null, null, null, null, null, null, null)
            return deployments.items.collect { pod -> return new String[]{pod.metadata.namespace, pod.metadata.name} }
        } catch (ApiException e) {
            System.out.println(e);
            System.out.println(e.getCode());
            System.out.println(e.getResponseBody());
            return null
        }
    }
}
