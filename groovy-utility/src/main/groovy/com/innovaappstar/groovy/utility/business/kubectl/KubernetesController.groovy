package com.innovaappstar.groovy.utility.business.kubectl

//import io.kubernetes.client.openapi.ApiClient
//import io.kubernetes.client.openapi.ApiException
//import io.kubernetes.client.openapi.apis.CoreV1Api
//import io.kubernetes.client.openapi.models.V1PersistentVolume
//import io.kubernetes.client.openapi.models.V1Pod
//import io.kubernetes.client.openapi.models.V1PodList
//import io.kubernetes.client.openapi.Configuration
//import io.kubernetes.client.util.ClientBuilder
//
//import io.kubernetes.client.ApiClient
//import io.kubernetes.client.ApiException
//import io.kubernetes.client.Configuration
//import io.kubernetes.client.apis.CoreV1Api
//import io.kubernetes.client.models.V1PersistentVolume
//import io.kubernetes.client.models.V1PersistentVolumeClaimList
//import io.kubernetes.client.models.V1PersistentVolumeList
//import io.kubernetes.client.models.V1Pod
//import io.kubernetes.client.models.V1PodList
//import io.kubernetes.client.util.ClientBuilder;
//import io.kubernetes.client.util.Config
//import io.kubernetes.client.util.KubeConfig
//import io.kubernetes.client.util.authenticators.GCPAuthenticator
//
//import io.kubernetes.client.util.Config
//import io.kubernetes.client.util.KubeConfig
//import io.kubernetes.client.util.authenticators.GCPAuthenticator


class KubernetesController {
//    ApiClient apiClient

    private KubernetesController() {
//        startConnect()

//        def token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkthbmUgQmFsdGF6YXIgQWxhbm9jYSIsImlhdCI6MTUxNjIzOTAyMn0.B4UGbH4SmIJhceuSoDxugRWOT0q4_9rjfJErfOWqZKM"
        def token = "cnpFNFVlUTRESjNleTg4M0ZwYlFOSlQwczUrSVJXK1ZBejl6NWRhZXRaST0K"
        String kubeConfigPath = System.getenv("HOME") + "/.kube/config";

//        // Configura el objeto ApiClient con el token de acceso
//        ApiClient apiClient = Config.fromToken(kubeConfigPath, token)
//        apiClient.setVerifyingSsl(false)
//        Configuration.setDefaultApiClient(apiClient);



//        String kubeConfigPath = System.getenv("HOME") + "/.kube/config";
//        // Cargar la configuración del archivo de kubeconfig
//        apiClient = ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();
//        apiClient.setVerifyingSsl(false)
//        // Establecer el ApiClient global predeterminado
//        Configuration.setDefaultApiClient(apiClient);
//        def token = "bWljbGF2ZWVzZGlmaWNpbA==".decodeBase64().toString()
//        def token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkthbmUgQmFsdGF6YXIgQWxhbm9jYSIsImlhdCI6MTUxNjIzOTAyMn0.B4UGbH4SmIJhceuSoDxugRWOT0q4_9rjfJErfOWqZKM"
        String url = "https://192.168.64.3:16443";
        boolean isSSL = false;
//        apiClient = Config.fromToken(url, token, isSSL)
//        Configuration.setDefaultApiClient(apiClient);


//        apiClient = ClientBuilder.standard()
//                .setBasePath(url)
//                .setVerifyingSsl(false)
//                .setAuthentication {it ->
//                    it.setApiKey(token)
////                    it.setApiKeyPrefix("Bearer")
//                }
//                .build();
//
//        Configuration.setDefaultApiClient(apiClient);

//      START OK
//        KubeConfig.registerAuthenticator(new GCPAuthenticator())
//        apiClient = Config.defaultClient()
//        apiClient.setVerifyingSsl(false)
////        apiClient.setApiKey("cnpFNFVlUTRESjNleTg4M0ZwYlFOSlQwczUrSVJXK1ZBejl6NWRhZXRaST0K")
//        apiClient.setApiKey("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkthbmUgQmFsdGF6YXIgQWxhbm9jYSIsImlhdCI6MTUxNjIzOTAyMn0.B4UGbH4SmIJhceuSoDxugRWOT0q4_9rjfJErfOWqZKM")
//        apiClient.setBasePath("https://192.168.64.3:16443")
//        Configuration.setDefaultApiClient(apiClient)

//        FIN OK

//        ApiClient client = ClientBuilder.cluster().build();
        apiClient = Config.defaultClient()
        apiClient.setBasePath("https://192.168.64.3:16443")
        apiClient.setVerifyingSsl(false)
//        apiClient.setApiKeyPrefix("Bearer")
//        apiClient.setApiKey("cnpFNFVlUTRESjNleTg4M0ZwYlFOSlQwczUrSVJXK1ZBejl6NWRhZXRaST0K")
//        apiClient.setApiKey("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IktiYSIsImlhdCI6MTUxNjIzOTAyMn0.57YHvMugOVf6F_rJ9lUWPVtmYUmzEXgSp7iWOD4TZPw")
//        apiClient.setApiKey("ZXlKaGJHY2lPaUpJVXpJMU5pSXNJblI1Y0NJNklrcFhWQ0o5LmV5SnpkV0lpT2lJeE1qTTBOVFkzT0Rrd0lpd2libUZ0WlNJNklrdGlZU0lzSW1saGRDSTZNVFV4TmpJek9UQXlNbjAuNTdZSHZNdWdPVmY2Rl9ySjlsVVdQVnRtWVVtekVYZ1NwN2lXT0Q0VFpQdw==")

        apiClient.setApiKey("ZXlKaGJHY2lPaUpJVXpJMU5pSXNJblI1Y0NJNklrcFhWQ0o5LmV5SnpkV0lpT2lJeE1qTTBOVFkzT0Rrd0lpd2libUZ0WlNJNklrdGlZU0lzSW1saGRDSTZNVFV4TmpJek9UQXlNbjAuNTdZSHZNdWdPVmY2Rl9ySjlsVVdQVnRtWVVtekVYZ1NwN2lXT0Q0VFpQdw==")
        Configuration.setDefaultApiClient(apiClient);


//        startConnect()
    }

    static class Builder {
        KubernetesController build() {
            new KubernetesController()
        }
    }

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
    }

    def listPods() {
//        try {
////            ApiClient client = Config.defaultClient();
////            Configuration.setDefaultApiClient(client);
//
//            CoreV1Api api2 = new CoreV1Api();
//            V1PodList list2 = api2.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
//            for (V1Pod item : list2.getItems()) {
//                System.out.println(item.getMetadata().getName());
//            }
//
//            CoreV1Api api = new CoreV1Api();
//            V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null,
//                    null, null)
//            return list.items.collect { pod -> return new String[]{pod.metadata.namespace, pod.metadata.name} }
//        } catch (ApiException e) {
//            System.out.println(e);
//            System.out.println(e.getCode());
//            System.out.println(e.getResponseBody());
//            return null
//        } catch (Exception e){
//            e.printStackTrace()
//        }
    }

    def listResources(listFunction) {
//        try {
//            def list = listFunction.call()
//            return list.items.collect { item ->
//                def namespace = item.metadata.namespace ?: ""
//                def name = item.metadata.name
//                [name, namespace]
//            }
//        } catch (ApiException e) {
//            println(e)
//            println(e.getCode())
//            println(e.getResponseBody())
//            return null
//        }
    }

    List<ArrayList<String>> listAllPV() {
        listPods()
//        return listResources { new CoreV1Api().listPersistentVolume(null, null, null, null, null, null, null, null, null) }
    }

    List<ArrayList<String>> listAllPVC() {
//        return listResources { new CoreV1Api().listPersistentVolumeClaimForAllNamespaces(null, null, null, null, null, null, null, null, null) }
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
//            CoreV1Api coreV1Api = new CoreV1Api(apiClient)
//
//            // Leer el contenido del archivo YAML
//            String yamlContent = new File(filePath).text
//
//            // Convertir el contenido YAML a un objeto V1PersistentVolume
//            V1PersistentVolume pv = (V1PersistentVolume) Yaml.load(yamlContent)
//
//            // Crear el Persistent Volume
//            coreV1Api.createNamespacePersistentVolume(pv.getMetadata().getNamespace(), pv, null, null, null)

            return "Persistent Volume creado exitosamente."
        } catch (Exception e) {
            return "Error al crear el Persistent Volume: ${e.getMessage()}"
        }
    }






    def listDeployments() {
//        try {
//            // Crear el cliente de la API
//
//            // Crear una instancia de la API de AppsV1Api para trabajar con deployments
////            AppsV1Api appsV1Api = new AppsV1Api(apiClient)
//
//            // Obtener la lista de deployments
//            def deployments = appsV1Api.listDeploymentForAllNamespaces(null, null, null, null, null, null, null, null, null)
//            return deployments.items.collect { pod -> return new String[]{pod.metadata.namespace, pod.metadata.name} }
//        } catch (ApiException e) {
//            System.out.println(e);
//            System.out.println(e.getCode());
//            System.out.println(e.getResponseBody());
//            return null
//        }
    }
}
