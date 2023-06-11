package com.innovaappstar.kubernetes.utility.forms;


import com.innovaappstar.kubernetes.utility.business.ProcessorMediator;

import javax.swing.*;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class YamlEditor extends JFrame {

    public YamlEditor(String resourcePath, ProcessorMediator processorMediator) {
        setTitle("Editor de YAML");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 800);
        setLocationRelativeTo(null);

        RSyntaxTextArea yamlTextArea = new RSyntaxTextArea();
        yamlTextArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_YAML);
        yamlTextArea.setCodeFoldingEnabled(true);
        yamlTextArea.setAntiAliasingEnabled(true);

        // Configurar tema oscuro
        try {
            Theme theme = Theme.load(getClass().getResourceAsStream("/org/fife/ui/rsyntaxtextarea/themes/dark.xml"));
            theme.apply(yamlTextArea);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Configurar tamaño de fuente
        Font font = yamlTextArea.getFont();
        yamlTextArea.setFont(font.deriveFont(16f)); // Tamaño de fuente: 16
        yamlTextArea.setText(readFileFromResources(resourcePath));
        // Configurar indentación
        yamlTextArea.setTabsEmulated(true); // Emular tabulaciones con espacios
        yamlTextArea.setTabSize(4); // Tamaño de la tabulación: 4 espacios
        yamlTextArea.setAutoIndentEnabled(true); // Habilitar indentación automática

        JScrollPane scrollPane = new JScrollPane(yamlTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        // Botón Guardar
        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optional<File> fileCreated = saveFile(yamlTextArea.getText());
                processorMediator.save(fileCreated.map(File::getAbsolutePath).orElse(null));
                dispose();
            }
        });
        buttonPanel.add(saveButton);

        // Botón Guardar y Aplicar
        JButton saveAndApplyButton = new JButton("Guardar y Aplicar");
        saveAndApplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optional<File> fileCreated = saveFile(yamlTextArea.getText());
                processorMediator.saveAndApply(fileCreated.map(File::getAbsolutePath).orElse(null));
                dispose();
            }
        });
        buttonPanel.add(saveAndApplyButton);

        // Botón Salir
        JButton exitButton = new JButton("Salir");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.exit(0);
                dispose();
            }
        });
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private Optional<File> saveFile(String text) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        Optional<File> pathFile = Optional.empty();
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                pathFile = Optional.of(fileChooser.getSelectedFile());
                BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile.get()));
                writer.write(text);
                writer.close();
                JOptionPane.showMessageDialog(this, "Archivo guardado correctamente.");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return pathFile;
    }

    public static String readFileFromResources(String fileName) {
        StringBuilder content = new StringBuilder();

        // Obtener la referencia del ClassLoader
        ClassLoader classLoader = YamlEditor.class.getClassLoader();

        // Obtener el InputStream del archivo
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append(System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Archivo no encontrado: " + fileName);
        }

        return content.toString();
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new YamlEditor("", new BiConsumer<String, Boolean>() {
//                    @Override
//                    public void accept(String s, Boolean aBoolean) {
//
//                    }
//                });
//            }
//        });
//    }
}


