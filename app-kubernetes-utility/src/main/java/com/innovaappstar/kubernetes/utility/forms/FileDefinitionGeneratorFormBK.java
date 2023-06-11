package com.innovaappstar.kubernetes.utility.forms;

import com.innovaappstar.groovy.utility.business.kubectl.KubernetesController;
import com.innovaappstar.kubernetes.utility.constants.FileResourcesEnum;
import com.innovaappstar.kubernetes.utility.models.PersistentVolumeTableModel;

import java.awt.EventQueue;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;

public class FileDefinitionGeneratorFormBK extends JFrame {

	private JPanel contentPane;
	private JTextField etAllTemplatesOutputDirectory;
	private JTable table;
	private JTextField etArgFilter;
	JRadioButton rbFilterByName;
	JRadioButton rbFilterByNamespace;

	PersistentVolumeTableModel persistentVolumeTableModel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileDefinitionGeneratorFormBK frame = new FileDefinitionGeneratorFormBK();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	private void runAllData(boolean isPVList){
//		persistentVolumeTableModel.clear();
//		if(isPVList){
//			(new KubernetesController.Builder().build().listAllPV()).forEach((item )->{
//				persistentVolumeTableModel.addRow(item);
//			});
//		}else{
//			persistentVolumeTableModel.clear();
//			(new KubernetesController.Builder().build().listAllPVC()).forEach((item )->{
//				persistentVolumeTableModel.addRow(item);
//			});
//		}
//		applyFilter();
	}

	/**
	 * Create the frame.
	 */
	public FileDefinitionGeneratorFormBK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 893, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 6, 881, 519);
		contentPane.add(tabbedPane);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("PV & PVC", null, panel_2, null);
		panel_2.setLayout(null);
//		persistentVolumeTableModel = new PersistentVolumeTableModel();
		table = new JTable(persistentVolumeTableModel);

		TableColumn column1 = table.getColumnModel().getColumn(0);
		column1.setHeaderValue("namespace");
		TableColumn column2 = table.getColumnModel().getColumn(1);
		column2.setHeaderValue("names");
		table.repaint();

		table.setBounds(6, 117, 848, 288);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 167, 848, 288);
		panel_2.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 6, 509, 149);
		panel_2.add(panel);
		panel.setLayout(null);

		etArgFilter = new JTextField();
		etArgFilter.setBounds(6, 67, 486, 26);
		panel.add(etArgFilter);
		etArgFilter.setToolTipText("Buscar por");
		etArgFilter.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(6, 28, 497, 27);
		panel.add(comboBox);

		// Agregar los valores al JComboBox
		comboBox.addItem("PV");
		comboBox.addItem("PVC");

		// Agregar ActionListener al JComboBox
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedValue = (String) comboBox.getSelectedItem();
				if(selectedValue.equals("PV")){
					runAllData(true);
					applyFilter();
				}else if (selectedValue.equals("PVC")){
					runAllData(false);
				}
				System.out.println("Elemento seleccionado: " + selectedValue);
			}
		});
//		comboBox.setSelectedIndex(0);

		rbFilterByName = new JRadioButton("name");
		rbFilterByName.setBounds(6, 98, 66, 23);
		panel.add(rbFilterByName);

		rbFilterByNamespace = new JRadioButton("namespace");
		rbFilterByNamespace.setBounds(77, 98, 102, 23);
		panel.add(rbFilterByNamespace);

		ButtonGroup buttonGroup1 = new ButtonGroup();
		buttonGroup1.add(rbFilterByName);
		buttonGroup1.add(rbFilterByNamespace);
		rbFilterByName.setSelected(true);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Create", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(527, 6, 327, 149);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JButton btnOpenEditor = new JButton("Open Editor And Create");
		btnOpenEditor.setBounds(6, 92, 304, 29);
		panel_4.add(btnOpenEditor);

		JRadioButton rbCreatePV = new JRadioButton("Persistent Volume");
		rbCreatePV.setBounds(6, 20, 179, 23);
		panel_4.add(rbCreatePV);

		JRadioButton rbCreatePVC = new JRadioButton("Persistent Volume Claim");
		rbCreatePVC.setBounds(6, 57, 197, 23);
		panel_4.add(rbCreatePVC);
		rbCreatePV.setSelected(true);

		btnOpenEditor.addActionListener(e -> {
//			new KubernetesController.Builder().build().executeKubectlCommands();
			String definitionPath = FileResourcesEnum.EMPTY_DEFINITION.getPath();
			if(rbCreatePV.isSelected())
				definitionPath = FileResourcesEnum.PV_DEFINITION.getPath();
			else if(rbCreatePVC.isSelected())
				definitionPath = FileResourcesEnum.PVC_DEFINITION.getPath();

			new YamlEditor(definitionPath, (path, isExecute) -> {
				String response = "";
				if(isExecute)
					response = new KubernetesController.Builder().build().executeDefinitionFile(path);
				JOptionPane.showMessageDialog(this, "Archivo recibido " + path + " con ejecución " + isExecute + " response " + response);
				runAllData(rbCreatePV.isSelected());
			}).setVisible(true);
		});



		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rbCreatePV);
		buttonGroup.add(rbCreatePVC);

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

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_3, null);
		comboBox.setSelectedIndex(0);
		init();
	}

	private void applyFilter() {
		String filterText = etArgFilter.getText();
		persistentVolumeTableModel.filterData(filterText, rbFilterByNamespace.isSelected());
	}

	private void init(){
		etArgFilter.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				applyFilter();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				applyFilter();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				applyFilter();
			}
		});
		applyFilter();

	}


}
