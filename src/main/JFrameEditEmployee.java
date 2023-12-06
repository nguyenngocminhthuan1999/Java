package main;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import entities.Department;
import entities.Employee;

import models.DepartmentModels;
import models.EmployeeModels;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class JFrameEditEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField jtextFieldName1;
	private JTextField jtextFieldAddress1;
	private JTextField jtextFieldPhoneNumber1;
	private JComboBox jcomboBoxDepartment1;
	private Map<String, Object> data = new HashMap<String, Object>();
	private Employee employee;
	private JComboBox comboBox;
	private AbstractButton jtableList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameEditEmployee frame = new JFrameEditEmployee();
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
	public JFrameEditEmployee() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 192));
		contentPane.add(panel_1);

		JLabel lblNewLabel = new JLabel("Edit Employee");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
		panel_1.add(lblNewLabel);

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);

		jtextFieldName1 = new JTextField();
		panel.add(jtextFieldName1);
		jtextFieldName1.setColumns(30);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);

		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_1_1);

		jtextFieldAddress1 = new JTextField();
		jtextFieldAddress1.setColumns(30);
		panel_2.add(jtextFieldAddress1);

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_8.getLayout();
		flowLayout.setHgap(8);
		panel_2.add(panel_8);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);

		JLabel lblNewLabel_1_1_1 = new JLabel("Phone Number");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_3.add(lblNewLabel_1_1_1);

		jtextFieldPhoneNumber1 = new JTextField();
		jtextFieldPhoneNumber1.setColumns(30);
		panel_3.add(jtextFieldPhoneNumber1);

		JPanel panel_9 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_9.getLayout();
		flowLayout_1.setHgap(32);
		panel_3.add(panel_9);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);

		JLabel lblNewLabel_1_1_2 = new JLabel("Department");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_1_1_2);

		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		comboBox = new JComboBox();
		panel_4.add(comboBox);

		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);

		JButton btnNewButtonSave = new JButton("Save");
		btnNewButtonSave.setSelected(true);
		btnNewButtonSave.setIcon(new ImageIcon(JFrameEditEmployee.class.getResource("/resources/Save.png")));
		btnNewButtonSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButtonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonSave_actionPerformed(e);
			}
		});
		panel_5.add(btnNewButtonSave);

		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_10.getLayout();
		flowLayout_2.setHgap(10);
		panel_5.add(panel_10);

		JButton jbtnBack = new JButton("Back");
		jbtnBack.setSelected(true);
		jbtnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnBack_actionPerformed(e);
			}
		});
		jbtnBack.setIcon(new ImageIcon(JFrameEditEmployee.class.getResource("/resources/Back.png")));
		jbtnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_5.add(jbtnBack);

		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
	}

	public void jbtnBack_actionPerformed(ActionEvent e) {
//		JFrameEditEmployee jFrameEditEmployee = new JFrameEditEmployee(data);
//		jFrameEditEmployee.setVisible(false);
		this.setVisible(false);
	}

	public JFrameEditEmployee(Map<String, Object> data) {
		this();
		this.data = data;
		initFrame();
	}

	private void initFrame() {
		DepartmentModels departmentModels = new DepartmentModels();
		DefaultComboBoxModel<Department> model = new DefaultComboBoxModel<Department>();
		for (Department department : departmentModels.findAll()) {
			model.addElement(department);
		}

		comboBox.setModel(model);
		comboBox.setRenderer(new DepartmentCellRender());
		int id = Integer.parseInt(data.get("id").toString());

		EmployeeModels employeeModels = new EmployeeModels();
		employee = employeeModels.find(id);
		jtextFieldName1.setText(employee.getName());
		jtextFieldAddress1.setText(employee.getAddress());
		jtextFieldPhoneNumber1.setText(employee.getPhonenumber());

	}

	public void btnNewButtonSave_actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(data.get("id").toString());
			
			EmployeeModels employeeModels = new EmployeeModels();
			Employee employee = employeeModels.find(id);

			employee.setName(jtextFieldName1.getText());
			employee.setAddress(jtextFieldAddress1.getText());
			employee.setPhonenumber(jtextFieldPhoneNumber1.getText());
			Department department = (Department) comboBox.getSelectedItem();
			employee.setDepartmentid(department.getId());

			if (employeeModels.update(employee)) {
				JOptionPane.showMessageDialog(null, "Edited information successfully");
				this.setVisible(false);
				JPanelListEmployee jPanelListEmployee = new JPanelListEmployee();
				jPanelListEmployee.setVisible(true);
				
//				Load();
//				JPanelListEmployee jPanelListEmployee = new JPanelListEmployee();
//				jPanelListEmployee.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(null, "Editing information failed");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
		
	}
//	private void Load() {
//	JPanelListEmployee jPanelListEmployee = new JPanelListEmployee();
//	jPanelListEmployee.removeAll();
//	jPanelListEmployee.add(jPanelListEmployee);
//	jPanelListEmployee.revalidate();
//	jPanelListEmployee.repaint();
//	}

	private class DepartmentCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department department = (Department) value;
			return super.getListCellRendererComponent(list, department.getName_department(), index, isSelected,
					cellHasFocus);
		}
	}
}
