/*
 * Created by JFormDesigner on Tue Jun 06 22:32:01 PET 2023
 */

package com.innovaappstar.kubernetes.utility.forms;

import com.innovaappstar.kubernetes.utility.business.KubernetesApiFacade;
import com.innovaappstar.kubernetes.utility.business.ProcessorMediator;
import com.innovaappstar.kubernetes.utility.constants.FileResourcesEnum;
import com.innovaappstar.kubernetes.utility.constants.FormPropertyEnum;
import com.innovaappstar.kubernetes.utility.models.FormProperty;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author kennybaltazaralanoca
 */
public class FileDefinitionGeneratorForm extends JPanel implements ProcessorMediator {
    KubernetesApiFacade kubernetesApiFacade = new KubernetesApiFacade();

    public FileDefinitionGeneratorForm() {
        initComponents();
        tbPanelForm.add("PV" ,
                new ViewerForm(this, FormProperty.builder()
                        .resourcePath(FileResourcesEnum.PV_DEFINITION.getPath())
                        .formDescription("some description pv")
                        .formPropertyEnum(FormPropertyEnum.PV)
                        .build(), kubernetesApiFacade)
        );

        tbPanelForm.add("PVC" ,
                new ViewerForm(this, FormProperty.builder()
                        .resourcePath(FileResourcesEnum.PVC_DEFINITION.getPath())
                        .formDescription("some description of pvc")
                        .formPropertyEnum(FormPropertyEnum.PVC)
                        .build(), kubernetesApiFacade)
        );
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kane Baltazar Alanoca
        tbPanelForm = new JTabbedPane();

        //======== this ========
        setPreferredSize(new Dimension(800, 465));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(tbPanelForm, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(tbPanelForm, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kane Baltazar Alanoca
    private JTabbedPane tbPanelForm;

    @Override
    public void saveAndApply(String path) {

    }

    @Override
    public void save(String path) {

    }

    @Override
    public void openEditor(String resource) {
        JOptionPane.showMessageDialog(null, "open editor -> " + resource);
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String args[]){
        JFrame frame = new JFrame("File Definition Generator Form");
        frame.setContentPane(new FileDefinitionGeneratorForm());
        frame.pack();
        frame.setVisible(true);
    }
}
