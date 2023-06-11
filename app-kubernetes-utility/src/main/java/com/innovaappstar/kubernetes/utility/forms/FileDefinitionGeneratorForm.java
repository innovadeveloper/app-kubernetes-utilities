/*
 * Created by JFormDesigner on Tue Jun 06 22:32:01 PET 2023
 */

package com.innovaappstar.kubernetes.utility.forms;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.innovaappstar.groovy.utility.business.kubectl.KubernetesController;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;
import com.innovaappstar.kubernetes.utility.business.ProcessorMediator;
import com.innovaappstar.kubernetes.utility.business.impl.DeploymentsExecutor;
import com.innovaappstar.kubernetes.utility.business.impl.PersistentVolumeClaimExecutor;
import com.innovaappstar.kubernetes.utility.business.impl.PersistentVolumeExecutor;
import com.innovaappstar.kubernetes.utility.business.impl.PodsExecutor;
import com.innovaappstar.kubernetes.utility.constants.FileResourcesEnum;
import com.innovaappstar.kubernetes.utility.constants.FormPropertyEnum;
import com.innovaappstar.kubernetes.utility.models.FormProperty;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import io.fabric8.kubernetes.api.model.AuthProviderConfig;
import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.api.model.PodList;
import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

/**
 * @author kennybaltazaralanoca
 */
public class FileDefinitionGeneratorForm extends JPanel implements ProcessorMediator {

    public FileDefinitionGeneratorForm() {
        initComponents();
        tbPanelForm.add("PV" ,
                new ViewerForm(this, FormProperty.builder()
                        .resourcePath(FileResourcesEnum.PV_DEFINITION.getPath())
                        .formDescription("some description of PV")
                        .formPropertyEnum(FormPropertyEnum.PV)
                        .build(), new PersistentVolumeExecutor())
        );

        tbPanelForm.add("PVC" ,
                new ViewerForm(this, FormProperty.builder()
                        .resourcePath(FileResourcesEnum.PVC_DEFINITION.getPath())
                        .formDescription("some description of PCX")
                        .formPropertyEnum(FormPropertyEnum.PVC)
                        .build(), new PersistentVolumeClaimExecutor())
        );
//
        tbPanelForm.add("PODS" ,
                new ViewerForm(this, FormProperty.builder()
                        .resourcePath(FileResourcesEnum.POD_DEFINITION.getPath())
                        .formDescription("some description pods")
                        .formPropertyEnum(FormPropertyEnum.PV)
                        .build(), new PodsExecutor())
        );
//
        tbPanelForm.add("DEPLOYMENTS" ,
                new ViewerForm(this, FormProperty.builder()
                        .resourcePath(FileResourcesEnum.POD_DEFINITION.getPath())
                        .formDescription("some description deployments")
                        .formPropertyEnum(FormPropertyEnum.PV)
                        .build(), new DeploymentsExecutor())
        );


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - kane baltazar alanoca
        tbPanelForm = new JTabbedPane();

        //======== this ========
        setPreferredSize(new Dimension(800, 465));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(tbPanelForm, GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(tbPanelForm, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - kane baltazar alanoca
    private JTabbedPane tbPanelForm;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String args[]){
        FlatMacDarkLaf.setup();

//        test();

        JFrame frame = new JFrame("File Definition Generator Form");
        frame.setContentPane(new FileDefinitionGeneratorForm());
        frame.pack();
        frame.setVisible(true);
    }

    private static void test(){
        String url = "https://192.168.64.3:16443";
        // Configurar la autenticación
        Config config = new ConfigBuilder()
                .withMasterUrl(url)
                .withTrustCerts(true)  // Configurar si se debe confiar en los certificados del servidor
//                .withClientCertFile("/Users/kennybaltazaralanoca/Files/certificates/gaby.crt")
//                .withClientKeyFile("/Users/kennybaltazaralanoca/Files/certificates/gaby.key")

//                .withOauthToken("cnpFNFVlUTRESjNleTg4M0ZwYlFOSlQwczUrSVJXK1ZBejl6NWRhZXRaST0K")
                .withOauthToken("Eijqt7R95LzSRW5udebkQUNhiYZ5+WYE8DPbQX/Epsk=")
//                .withOauthToken("<YOUR API KEY>")
                .build();

        // Crear el cliente de Kubernetes
        try (KubernetesClient client = new DefaultKubernetesClient(config)) {
            // Obtener la lista de Pods
            PodList podList = client.pods().inAnyNamespace().list();

            // Iterar sobre los Pods y mostrar información
            for (Pod pod : podList.getItems()) {
                System.out.println("Name: " + pod.getMetadata().getName());
                System.out.println("Namespace: " + pod.getMetadata().getNamespace());
                System.out.println("Status: " + pod.getStatus().getPhase());
                System.out.println("----------------------");
            }
        }
    }

    @Override
    public void saveAndApply(String path) {

    }

    @Override
    public void save(String path) {

    }

    @Override
    public void openEditor(String resource) {

    }
}
