package main;

import javax.swing.JPanel;

import entities.Department;
import entities.Employee;
import models.DepartmentModels;
import models.EmployeeModels;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class JPanelAddEmployee extends JPanel {
	private JTextField jtextFieldName;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldPhonenumber;
	private JComboBox jcomboBoxDepartment;
	private Map<String, Object> data = new HashMap<String, Object>();

	/**
	 * Create the panel.
	 */
	public JPanelAddEmployee() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		add(panel);

		JLabel lblNewLabel = new JLabel("Create Employee");
		lblNewLabel.setIcon(new ImageIcon(JPanelAddEmployee.class.getResource("/resources/Add.png")));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		add(panel_2);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setHgap(50);
		panel_2.add(panel_3);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(lblNewLabel_1);

		jtextFieldName = new JTextField();
		jtextFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_2.add(jtextFieldName);
		jtextFieldName.setColumns(25);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		add(panel_1);

		JPanel panel_3_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3_1.getLayout();
		flowLayout_3.setHgap(40);
		panel_1.add(panel_3_1);

		JLabel lblNewLabel_1_1 = new JLabel("Address");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1.add(lblNewLabel_1_1);

		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtextFieldAddress.setColumns(25);
		panel_1.add(jtextFieldAddress);
		
		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);

		JPanel panel_1_1 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_1_1.getLayout();
		add(panel_1_1);

		JPanel panel_3_1_1 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_3_1_1.getLayout();
		flowLayout_5.setHgap(15);
		panel_1_1.add(panel_3_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Phone Number");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1_1.add(lblNewLabel_1_1_1);

		jtextFieldPhonenumber = new JTextField();
		jtextFieldPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jtextFieldPhonenumber.setColumns(25);
		panel_1_1.add(jtextFieldPhonenumber);
		
		JPanel panel_7 = new JPanel();
		panel_1_1.add(panel_7);

		JPanel panel_1_2 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_1_2.getLayout();
		add(panel_1_2);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Department");
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_1_2.add(lblNewLabel_1_1_1_1);

		jcomboBoxDepartment = new JComboBox();
		jcomboBoxDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_4.getLayout();
		flowLayout_7.setHgap(20);
		panel_1_2.add(panel_4);
		panel_1_2.add(jcomboBoxDepartment);

		JPanel panel_1_3 = new JPanel();
		add(panel_1_3);

		JButton jbtnNewButtonSave = new JButton("Save");
		jbtnNewButtonSave.setIcon(new ImageIcon(JPanelAddEmployee.class.getResource("/resources/Save.png")));
		jbtnNewButtonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnNewButtonSave_actionPerformed(e);
			}
		});
		jbtnNewButtonSave.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel_1_3.add(jbtnNewButtonSave);

		JPanel panel_1_7 = new JPanel();
		add(panel_1_7);
		panel_1_7.setLayout(new BorderLayout(0, 0));
		
		initFrame();

	}

	public JPanelAddEmployee(Map<String, Object> data) {
		this();
		this.data = data;
//		initFrame();
	}

	private void initFrame() {
		DepartmentModels departmentModels = new DepartmentModels();
		DefaultComboBoxModel<Department> model = new DefaultComboBoxModel<Department>();
		for (Department department : departmentModels.findAll()) {
			model.addElement(department);
		}
		jcomboBoxDepartment.setModel(model);
		jcomboBoxDepartment.setRenderer(new CategoryCellRender());
//		comboBox.setModel(model);
//		comboBox.setRenderer(new CategoryCellRender());
//		comboBox.getEditor().setItem("");
	}

	private class CategoryCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department doUuTien = (Department) value;
			return super.getListCellRendererComponent(list, doUuTien.getName_department(), index, isSelected,
					cellHasFocus);
		}
	}

	public void jbtnNewButtonSave_actionPerformed(ActionEvent e) {
		try {
			Employee employee = new Employee();
			employee.setName(jtextFieldName.getText());
			employee.setAddress(jtextFieldAddress.getText());
			employee.setPhonenumber(jtextFieldPhonenumber.getText());			
			Department category = (Department) jcomboBoxDepartment.getSelectedItem();
			employee.setDepartmentid(category.getId());
//			employee.setDepartmentid(1);

			EmployeeModels employeeModels = new EmployeeModels();
			if (employeeModels.create(employee)) {
				JOptionPane.showMessageDialog(null, "Add employees successfully");
				EmployeeModels employeeModelsSaved = new EmployeeModels();
				int idEmployeeSaved = employeeModelsSaved.findId(jtextFieldName.getText());
				JOptionPane.showMessageDialog(null, "Your ID is: " + idEmployeeSaved);
			} else {
				JOptionPane.showMessageDialog(null, "More employees fail");
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
		
	}
	
}
