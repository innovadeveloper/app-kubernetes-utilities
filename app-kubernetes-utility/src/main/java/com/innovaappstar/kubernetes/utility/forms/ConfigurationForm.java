/*
 * Created by JFormDesigner on Sun Jun 11 12:16:35 PET 2023
 */

package com.innovaappstar.kubernetes.utility.forms;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;
import com.innovaappstar.kubernetes.utility.models.PropertyStorage;
import com.innovaappstar.kubernetes.utility.utils.FormUtils;
import com.innovaappstar.kubernetes.utility.utils.PropertiesStorageUtils;

import java.util.List;
import java.util.function.Consumer;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author kennybaltazaralanoca
 */
public class ConfigurationForm extends JPanel {
    public ConfigurationForm() {
        initComponents();
        onStart();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - kane baltazar alanoca
        panel1 = new JPanel();
        etPrivateKey = new JTextField();
        btnChoosePrivateKey = new JButton();
        btnChooseCertificate = new JButton();
        etCertificate = new JTextField();
        etHostname = new JTextField();
        btnSaveConfiguration = new JButton();
        label1 = new JLabel();
        btnTestConnection = new JButton();
        btnContinue = new JButton();

        //======== this ========

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Configuration"));

            //---- btnChoosePrivateKey ----
            btnChoosePrivateKey.setText("Choose Private Key");

            //---- btnChooseCertificate ----
            btnChooseCertificate.setText("Choose Certificate");

            //---- btnSaveConfiguration ----
            btnSaveConfiguration.setText("Save");

            //---- label1 ----
            label1.setText("Hostname : ");

            //---- btnTestConnection ----
            btnTestConnection.setText("Save and TestConnection");

            //---- btnContinue ----
            btnContinue.setText("Continue");

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(etPrivateKey)
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(btnChoosePrivateKey, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etCertificate, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnChooseCertificate, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etHostname, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(btnTestConnection, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSaveConfiguration, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(etPrivateKey, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChoosePrivateKey)
                        .addGap(13, 13, 13)
                        .addComponent(etCertificate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChooseCertificate)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label1)
                        .addGap(18, 18, 18)
                        .addComponent(etHostname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTestConnection)
                            .addComponent(btnSaveConfiguration))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(btnContinue))
            );
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private JTextField etPrivateKey;
    private JButton btnChoosePrivateKey;
    private JButton btnChooseCertificate;
    private JTextField etCertificate;
    private JTextField etHostname;
    private JButton btnSaveConfiguration;
    private JLabel label1;
    private JButton btnTestConnection;
    private JButton btnContinue;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void onStart(){
        PropertyStorage propertyStorageLoaded = PropertiesStorageUtils.readProperties();
        etCertificate.setText(propertyStorageLoaded.getCertificatePath());
        etPrivateKey.setText(propertyStorageLoaded.getPrivateKeyPath());
        etHostname.setText(propertyStorageLoaded.getHostname());

        btnChooseCertificate.addActionListener((e) -> {
            FormUtils.chooseFile(ConfigurationForm.this, s -> {
                etCertificate.setText(s);
//                JOptionPane.showMessageDialog(this, "Archivo recuperado " + s);
            });
        });
        btnChoosePrivateKey.addActionListener((e) -> {
            FormUtils.chooseFile(ConfigurationForm.this, s -> {
                etPrivateKey.setText(s);
            });
        });

        btnSaveConfiguration.addActionListener((e) -> {
            saveConfiguration();
            JOptionPane.showMessageDialog(this, "Configuración guardada con éxito ");
        });

        btnTestConnection.addActionListener((e) -> {
            saveConfiguration();
            boolean isConnected = new KubernetesApiFacade().testConnection();
            JOptionPane.showMessageDialog(this, "Resultado de la conexión " + isConnected);
        });

        btnContinue.addActionListener((e) -> {
            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(ConfigurationForm.this);
            mainFrame.dispose();

            FileDefinitionGeneratorForm.main(new String[]{});
//            boolean isConnected = new KubernetesApiFacade().testConnection();
//            JOptionPane.showMessageDialog(this, "Resultado de la conexión " + isConnected);
        });
    }


    public void saveConfiguration(){
        if(etHostname.getText().isEmpty())return;

        PropertyStorage propertyStorage = new PropertyStorage();
        propertyStorage.setHostname(etHostname.getText());
        propertyStorage.setPrivateKeyPath(etPrivateKey.getText());
        propertyStorage.setCertificatePath(etCertificate.getText());

        PropertiesStorageUtils.writeProperties(propertyStorage);
    }


    public static void main(String args[]){
        FlatMacDarkLaf.setup();
        JFrame frame = new JFrame("Login and configuration v1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new ConfigurationForm());
        frame.pack();
        frame.setVisible(true);
    }
}
