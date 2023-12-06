package main;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

import entities.Department;

import entities.Employee;
import models.DepartmentModels;

import models.EmployeeModels;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.TreeSelectionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JPanelListEmployee extends JPanel {
	private JTable jtableList;
	private JTextField jtextFieldKeyword;
	private Map<String, Object> data = new HashMap<String, Object>();
	private Object emoloyee;
	private Employee[] employees;
	private JPopupMenu popupMenu;
	private JButton jbtnNewButtonSearch;
	private Object jcomboBoxDepartment;
	private JTable jtableLList;
	private int name;
	private JPanel jpanelShowInfo;

	/**
	 * Create the panel.
	 */
	public JPanelListEmployee() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 128, 192));
		add(panel);

		JLabel lblNewLabel = new JLabel("List Employee");
		lblNewLabel.setIcon(new ImageIcon(JPanelListEmployee.class.getResource("/resources/Checklist.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		panel.add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		add(panel_3);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_3.add(lblNewLabel_2);

		jtextFieldKeyword = new JTextField();
		jtextFieldKeyword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				jtextFieldKeyword_keyReleased(e);
			}
		});
		panel_3.add(jtextFieldKeyword);
		jtextFieldKeyword.setColumns(30);

		jbtnNewButtonSearch = new JButton("Search");
		jbtnNewButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnNewButtonSearch_actionPerformed(e);
			}
		});

		jbtnNewButtonSearch.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_3.add(jbtnNewButtonSearch);

		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		JPopupMenu popupMenu_1 = new JPopupMenu();
		addPopup(scrollPane, popupMenu_1);

		JMenuItem JmenuItemDetails = new JMenuItem("Details");
		popupMenu_1.add(JmenuItemDetails);

		JMenuItem JmenuItemDelete = new JMenuItem("Delete");
		popupMenu_1.add(JmenuItemDelete);

		jtableList = new JTable();
		scrollPane.setViewportView(jtableList);

		jpanelShowInfo = new JPanel();
		add(jpanelShowInfo);
		jpanelShowInfo.setLayout(new BorderLayout(0, 0));

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_4);

		JButton jbtnNewButtonDelete = new JButton("Delete");
		jbtnNewButtonDelete.setIcon(new ImageIcon(JPanelListEmployee.class.getResource("/resources/Delete.png")));
		jbtnNewButtonDelete.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jbtnNewButtonDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnNewButtonDelete_actionPerformed(e);
			}
		});
		panel_4.add(jbtnNewButtonDelete);

		JButton jbtnNewButtonEdit = new JButton("Edit");
		jbtnNewButtonEdit.setIcon(new ImageIcon(JPanelListEmployee.class.getResource("/resources/Profile.png")));
		jbtnNewButtonEdit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		jbtnNewButtonEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnNewButtonDetails_actionPerformed(e);
			}
		});
		panel_4.add(jbtnNewButtonEdit);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		initFrame();

	}

	public void jbtnNewButtonDetails_actionPerformed(ActionEvent e) {
		int selectRow = jtableList.getSelectedRow();
		int id = Integer.parseInt(jtableList.getValueAt(selectRow, 0).toString());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);
	
		JFrameEditEmployee jFrameEditEmployee = new JFrameEditEmployee(data);
		jFrameEditEmployee.setLocationRelativeTo(null);
		jFrameEditEmployee.setVisible(true);
		

	}

	public void jbtnNewButtonDelete_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int seletedRow = jtableList.getSelectedRow();
			int id = Integer.parseInt(jtableList.getValueAt(seletedRow, 0).toString());
			EmployeeModels employeeModels = new EmployeeModels();
			if (employeeModels.delete(id)) {
				JOptionPane.showMessageDialog(null, "Done!");
			} else {
				JOptionPane.showMessageDialog(null, "An employee is borrowing a book, it cannot be deleted!");
			}

		}
		DepartmentModels departmentModels = new DepartmentModels();
		EmployeeModels employeeModels = new EmployeeModels();
		DefaultTableModel modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Name");
		modelTable.addColumn("Address");
		modelTable.addColumn("Phone number");
		modelTable.addColumn("Department");

		for (Employee employee : employeeModels.findAll()) {
			modelTable.addRow(new Object[] { employee.getId(), employee.getName(), employee.getAddress(),
					employee.getPhonenumber(), departmentModels.find(employee.getDepartmentid()) });
		}

		jtableList.setModel(modelTable);
	}

// nut search
	public void jtextFieldKeyword_keyReleased(KeyEvent e) {
		String keyword = jtextFieldKeyword.getText().trim();

		EmployeeModels employeeModels = new EmployeeModels();
		System.out.println(keyword);

		fillDataToJTable(employeeModels.searchByKeyword(keyword));

	}

	protected void jbtnNewButtonSearch_actionPerformed(ActionEvent e) {

		String keyword = jtextFieldKeyword.getText().trim();

		EmployeeModels employeeModels = new EmployeeModels();
		System.out.println(keyword);

		fillDataToJTable(employeeModels.searchByKeyword(keyword));

	}

	private void fillDataToJTable(List<Employee> employees) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		DepartmentModels departmentModels = new DepartmentModels();
		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Address");
		model.addColumn("Phone number");
		model.addColumn("Department");
		for (Employee employee : employees) {
			model.addRow(new Object[] { employee.getId(),  employee.getName(), employee.getAddress(),
					employee.getPhonenumber(), departmentModels.find(employee.getDepartmentid()) });
		}
		jtableList.setModel(model);
		jtableList.getTableHeader().setReorderingAllowed(false);
	}

	private void addPopup(JScrollPane scrollPane, JPopupMenu popupMenu_1) {
		// TODO Auto-generated method stub

	}

/////

	public JPanelListEmployee(Map<String, Object> data) {
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

		EmployeeModels employeeModels = new EmployeeModels();
		DefaultTableModel modelTable = new DefaultTableModel();
		modelTable.addColumn("Id");
		modelTable.addColumn("Name");
		modelTable.addColumn("Address");
		modelTable.addColumn("Phone number");
		modelTable.addColumn("Department");
		// dong boi den ben duoi
		for (Employee employee : employeeModels.findAll()) {
			modelTable.addRow(new Object[] { employee.getId(), employee.getName(), employee.getAddress(),
					employee.getPhonenumber(), departmentModels.find(employee.getDepartmentid()) });
		}

		jtableList.setModel(modelTable);

		jtableList.setComponentPopupMenu(popupMenu);
	}

	private class CategoryCellRender extends DefaultListCellRenderer {

//		private Object id;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department doUuTien = (Department) value;
			return super.getListCellRendererComponent(list, doUuTien.getName_department(), index, isSelected,
					cellHasFocus);
		}

//		
		private void clearScreen() {
			jpanelShowInfo.revalidate();
			jpanelShowInfo.removeAll();
		}

		// popup menu

		private static void addPopup(Component component, final JPopupMenu popup) {
			component.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}

				public void mouseReleased(MouseEvent e) {
					if (e.isPopupTrigger()) {
						showMenu(e);
					}
				}

				private void showMenu(MouseEvent e) {
					popup.show(e.getComponent(), e.getX(), e.getY());
				}
			});
		}
	}
}
