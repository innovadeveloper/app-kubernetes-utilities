package com.innovaappstar.groovy.utility.utils

import javax.swing.JFileChooser
import java.awt.Component
import java.nio.file.Files
import java.nio.file.Paths

class FileUtils {
    static String getMessage(String message){
        def pwdCommand = "pwd".execute().text
        def lsCommand = "ls".execute().text.split("\n")
        println(pwdCommand)
        println("___________")
        println(lsCommand)

        def a= Paths.get(pwdCommand)toAbsolutePath()
        def currentDir = Paths.get(pwdCommand).toAbsolutePath().toString()
        def files2 = Files.list(Paths.get(currentDir))

        def files = Files.list(Paths.get(currentDir))
                .filter { Files.isRegularFile(it) }
                .map { it.getFileName().toString() }
                .toList()

        files.each { fileName ->
            println(fileName)
        }
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
