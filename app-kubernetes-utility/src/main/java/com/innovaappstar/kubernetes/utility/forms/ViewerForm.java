/*
 * Created by JFormDesigner on Tue Jun 06 22:09:37 PET 2023
 */

package com.innovaappstar.kubernetes.utility.forms;

import com.innovaappstar.kubernetes.utility.business.Executor;
import com.innovaappstar.kubernetes.utility.business.ProcessorMediator;
import com.innovaappstar.kubernetes.utility.business.ViewForm;
import com.innovaappstar.kubernetes.utility.models.FormProperty;
import com.innovaappstar.kubernetes.utility.models.PersistentVolumeTableModel;
import com.innovaappstar.kubernetes.utility.utils.FormUtils;
import com.innovaappstar.kubernetes.utility.utils.JsonUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;

import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

/**
 * @author kennybaltazaralanoca
 */
@Setter
@Getter
public class ViewerForm extends JPanel implements ViewForm {

    @Singular
    private ProcessorMediator processorMediator;
    @Singular
    private FormProperty formProperty;
    @Singular
    PersistentVolumeTableModel persistentVolumeTableModel;
    Executor executor;

    public ViewerForm(ProcessorMediator processorMediator, FormProperty formProperty, Executor executor) {
        this.processorMediator = processorMediator;
        this.formProperty = formProperty;
        this.persistentVolumeTableModel = new PersistentVolumeTableModel(executor);
        this.executor = executor;
        initComponents();
        onStart();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - kane baltazar alanoca
        panel1 = new JPanel();
        etFilterInput = new JTextField();
        cbFilter = new JComboBox();
        panel2 = new JPanel();
        tvDescription = new JLabel();
        btnOpenEditor = new JButton();
        scrollPane1 = new JScrollPane();
        tbItems = new JTable();

        //======== this ========

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Search"));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(etFilterInput, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                            .addComponent(cbFilter, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(etFilterInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
            );
        }

        //======== panel2 ========
        {
            panel2.setBorder(new TitledBorder("Create"));

            //---- tvDescription ----
            tvDescription.setText("description.....");
            tvDescription.setHorizontalAlignment(SwingConstants.LEFT);
            tvDescription.setVerticalAlignment(SwingConstants.TOP);

            //---- btnOpenEditor ----
            btnOpenEditor.setText("Open editor and create");

            GroupLayout panel2Layout = new GroupLayout(panel2);
            panel2.setLayout(panel2Layout);
            panel2Layout.setHorizontalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel2Layout.createParallelGroup()
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(tvDescription, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                                .addContainerGap())
                            .addComponent(btnOpenEditor, GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)))
            );
            panel2Layout.setVerticalGroup(
                panel2Layout.createParallelGroup()
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tvDescription, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(btnOpenEditor))
            );
        }

        //======== scrollPane1 ========
        {

            //---- tbItems ----
            tbItems.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null},
                    {null, null},
                },
                new String[] {
                    "name", "namespace"
                }
            ));
            scrollPane1.setViewportView(tbItems);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 998, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addContainerGap())
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - kane baltazar alanoca
    private JPanel panel1;
    private JTextField etFilterInput;
    private JComboBox cbFilter;
    private JPanel panel2;
    private JLabel tvDescription;
    private JButton btnOpenEditor;
    private JScrollPane scrollPane1;
    private JTable tbItems;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    @Override
    public void onStart() {
        tbItems.setModel(persistentVolumeTableModel);
        tvDescription.setText(this.formProperty.getFormDescription());
        btnOpenEditor.addActionListener((ev) -> this.processorMediator.openEditor(this.formProperty.getResourcePath()));

        DefaultComboBoxModel<String> cbFilterModel = new DefaultComboBoxModel<>();
        cbFilterModel.addAll(Arrays.stream(executor.getPathItemList()).collect(Collectors.toList()));
        cbFilter.setModel(cbFilterModel);
        cbFilter.setSelectedIndex(0);

        persistentVolumeTableModel.clear();
        executor.process().forEach((item) -> {
            persistentVolumeTableModel.addRow(item);
//            onApplyFilter();
        });

        for (int i = 0; i < executor.getPathItemList().length; i++) {
            String pathItem = executor.getPathItemList()[i];
            pathItem = JsonUtils.getLastWordAfterLastDot(pathItem);
            tbItems.getColumnModel().getColumn(i).setHeaderValue(pathItem);
        }
        tbItems.repaint();


        etFilterInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                onApplyFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                onApplyFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                onApplyFilter();
            }
        });
        onApplyFilter();
    }

    @Override
    public void onApplyFilter() {
        String filterText = etFilterInput.getText();
        String cbFilterText = (String) cbFilter.getSelectedItem();
        persistentVolumeTableModel.filterData(filterText, cbFilterText, executor.onFilterByColumnAndValue());
    }


}
