/*
 * Created by JFormDesigner on Tue Jun 06 11:44:48 PET 2023
 */

package com.innovaappstar.kubernetes.utility.forms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author kennybaltazaralanoca
 */
public class TrainingForm extends JPanel {
    public TrainingForm() {
        initComponents();
    }

    private void savePath(ActionEvent e) {
        String message = textField1.getText();
        JOptionPane.showMessageDialog(null,"Hola " + message);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Kane Baltazar Alanoca
        panel1 = new JPanel();
        textField1 = new JTextField();
        button1 = new JButton();
        borderlayout = new JPanel();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        tabbedPane1 = new JTabbedPane();
        panel2 = new JPanel();
        label1 = new JLabel();
        panel3 = new JPanel();
        button3 = new JButton();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
        ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
        .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
        ;} } );

        //======== panel1 ========
        {
            panel1.setBorder(new TitledBorder("Load"));

            //---- button1 ----
            button1.setText("Save");
            button1.addActionListener(e -> savePath(e));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button1)
                        .addContainerGap(15, Short.MAX_VALUE))
            );
        }

        //======== borderlayout ========
        {
            borderlayout.setBorder(new TitledBorder("Create"));
            borderlayout.setLayout(new BorderLayout());

            //---- button2 ----
            button2.setText("Save");
            borderlayout.add(button2, BorderLayout.SOUTH);

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null},
                        {null, null},
                    },
                    new String[] {
                        "key", "prop"
                    }
                ));
                scrollPane1.setViewportView(table1);
            }
            borderlayout.add(scrollPane1, BorderLayout.CENTER);
        }

        //======== tabbedPane1 ========
        {
            tabbedPane1.setBorder(new TitledBorder("Options"));

            //======== panel2 ========
            {

                //---- label1 ----
                label1.setText("text");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(label1)
                            .addContainerGap(544, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(label1)
                            .addContainerGap(124, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("text", panel2);

            //======== panel3 ========
            {

                //---- button3 ----
                button3.setText("text");

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(button3)
                            .addContainerGap(476, Short.MAX_VALUE))
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addComponent(button3)
                            .addContainerGap(69, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("text", panel3);

            tabbedPane1.setSelectedIndex(0);
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(borderlayout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tabbedPane1))
                    .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addComponent(borderlayout, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Kane Baltazar Alanoca
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;
    private JPanel borderlayout;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JTabbedPane tabbedPane1;
    private JPanel panel2;
    private JLabel label1;
    private JPanel panel3;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public static void main(String args[]){
        JFrame frame = new JFrame("Title custom");
        frame.setContentPane(new TrainingForm());
//        frame.setSize(300, 400);
        frame.pack();
        frame.setVisible(true);
    }
}
