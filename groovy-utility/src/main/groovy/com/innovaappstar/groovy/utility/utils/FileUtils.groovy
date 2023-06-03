package com.innovaappstar.groovy.utility.utils

import javax.swing.JFileChooser
import java.awt.Component

class FileUtils {
    static String getMessage(String message){
        def pwdCommand = "pwd".execute().text
        def lsCommand = "ls -l".execute().text
        println(pwdCommand)
        println("___________")
        println(lsCommand)
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
}
