/*
 * Created by JFormDesigner on Sun Jun 11 11:36:37 PET 2023
 */

package com.innovaappstar.kubernetes.utility.forms;

import com.innovaappstar.kubernetes.utility.business.ProcessorMediator;
import com.innovaappstar.kubernetes.utility.constants.FileResourcesEnum;
import com.innovaappstar.kubernetes.utility.utils.FormUtils;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author kennybaltazaralanoca
 */
public class AnotherScriptsForm extends JPanel {
    ProcessorMediator processorMediator;

    public AnotherScriptsForm(ProcessorMediator processorMediator) {
        this.processorMediator = processorMediator;
        initComponents();
        onStart();
//        FormUtils.addCloseDialogBeforeFinish(AnotherScriptsForm.this);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - kane baltazar alanoca
        panel1 = new JPanel();
        panel2 = new JPanel();
        btnViewDefinitionDeployment = new JButton();
        btnViewDefinitionService = new JButton();
        btnViewDefinitionPVC = new JButton();
        btnViewDefinitionPV = new JButton();
        panel3 = new JPanel();
        btnCreateGitlabRegistrySecret = new JButton();

        //======== this ========

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Another Scripts"));

            //======== panel2 ========
            {
                panel2.setBorder(new TitledBorder("Definition Examples"));

                //---- btnViewDefinitionDeployment ----
                btnViewDefinitionDeployment.setText("View Deployment");

                //---- btnViewDefinitionService ----
                btnViewDefinitionService.setText("View Service");

                //---- btnViewDefinitionPVC ----
                btnViewDefinitionPVC.setText("View PVC");

                //---- btnViewDefinitionPV ----
                btnViewDefinitionPV.setText("View PV");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(btnViewDefinitionPV, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewDefinitionPVC, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewDefinitionService, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnViewDefinitionDeployment, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(8, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnViewDefinitionPV)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnViewDefinitionPVC)
                            .addGap(12, 12, 12)
                            .addComponent(btnViewDefinitionDeployment)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnViewDefinitionService)
                            .addContainerGap(149, Short.MAX_VALUE))
                );
            }

            //======== panel3 ========
            {
                panel3.setBorder(new TitledBorder("Scripts"));

                //---- btnCreateGitlabRegistrySecret ----
                btnCreateGitlabRegistrySecret.setText("Create Secret For Gitlab Registry");

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnCreateGitlabRegistrySecret, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(16, Short.MAX_VALUE))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnCreateGitlabRegistrySecret)
                            .addContainerGap(275, Short.MAX_VALUE))
                );
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - kane baltazar alanoca
    private JPanel panel1;
    private JPanel panel2;
    private JButton btnViewDefinitionDeployment;
    private JButton btnViewDefinitionService;
    private JButton btnViewDefinitionPVC;
    private JButton btnViewDefinitionPV;
    private JPanel panel3;
    private JButton btnCreateGitlabRegistrySecret;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void onStart(){
        btnCreateGitlabRegistrySecret.addActionListener((e) -> processorMediator.openEditor(FileResourcesEnum.SECRET_DEFINITION_EXAMPLE.getPath()));
        btnViewDefinitionPV.addActionListener((e) -> processorMediator.openEditor(FileResourcesEnum.PV_DEFINITION_EXAMPLE.getPath()));
        btnViewDefinitionPVC.addActionListener((e) -> processorMediator.openEditor(FileResourcesEnum.PVC_DEFINITION_EXAMPLE.getPath()));
        btnViewDefinitionService.addActionListener((e) -> processorMediator.openEditor(FileResourcesEnum.SERVICE_DEFINITION_EXAMPLE.getPath()));
        btnViewDefinitionDeployment.addActionListener((e) -> processorMediator.openEditor(FileResourcesEnum.DEPLOYMENT_DEFINITION_EXAMPLE.getPath()));

    }
}
