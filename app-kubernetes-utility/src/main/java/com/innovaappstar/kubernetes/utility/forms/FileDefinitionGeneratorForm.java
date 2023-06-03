package com.innovaappstar.kubernetes.utility.forms;

import com.innovaappstar.groovy.AppGroovy;
import com.innovaappstar.groovy.utility.utils.FileUtils;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class FileDefinitionGeneratorForm extends JFrame {

	private JPanel contentPane;
	private JTextField etAllTemplatesOutputDirectory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileDefinitionGeneratorForm frame = new FileDefinitionGeneratorForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FileDefinitionGeneratorForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 612);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 631, 317);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Create all templates", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnAllTemplateOutputDirectoryChoose = new JButton("Create all files");
		btnAllTemplateOutputDirectoryChoose.setBounds(6, 118, 407, 26);
		panel_1.add(btnAllTemplateOutputDirectoryChoose);
		
		etAllTemplatesOutputDirectory = new JTextField();
		etAllTemplatesOutputDirectory.setBounds(6, 80, 407, 26);
		panel_1.add(etAllTemplatesOutputDirectory);
		etAllTemplatesOutputDirectory.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Output directory");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setBounds(6, 19, 230, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Create all yaml templates by default (pv, pvc, deployment, service)");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(6, 47, 598, 16);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(6, 5, 230, 27);
		panel_2.add(comboBox);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);

		btnAllTemplateOutputDirectoryChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = FileUtils.choosePath(FileDefinitionGeneratorForm.this);
				etAllTemplatesOutputDirectory.setText(path);
				String message = FileUtils.getMessage("hola mundo");
				System.out.println(message);
			}
		});
	}
	
}
