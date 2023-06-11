package com.innovaappstar.kubernetes.utility.utils;

import com.innovaappstar.kubernetes.utility.forms.FileDefinitionGeneratorForm;

import java.awt.Component;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import lombok.SneakyThrows;

public class FormUtils {

    public static void addCloseDialogBeforeFinish(Component component){
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(1000);

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(component);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        int option = JOptionPane.showConfirmDialog(component,
                                "¿Desea cerrar la aplicación?", "Confirmar cierre",
                                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (option == JOptionPane.YES_OPTION) {
                            frame.dispose();
                        } else {
                            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                        }
                    }
                });
            }
        }).start();
    }
}
