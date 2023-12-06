package main;

import java.awt.EventQueue;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import component.Login;
import component.Main1;
import entities.Book;
import entities.Employee;
import entities.Issued;
import models.BookModel;
import models.DepartmentModels;
import models.EmployeeModel;
import models.IssuedModel;

import java.awt.Cursor;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.sql.Date;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DropMode;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class jFrameCheckOut extends JFrame {

	private JPanel contentPane;
	private Map<Integer, String> data = new HashMap<Integer, String>();
	private JTable jtableBooks;
	private JTextField jtextFieldIdFind;
	private JLabel jlabelFound;
	
	private Date date = new Date();
	private JLabel jlabelIssueDate;
	private JLabel jlabelDueDate;
	private int employee_id = 0;
	private int row = 0;
	private JButton jbtnSave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameCheckOut frame = new jFrameCheckOut();
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
	public jFrameCheckOut() {
		setUndecorated(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Confirming the book rental");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setHgap(45);
		panel.add(panel_2);

		jbtnSave = new JButton("SAVE");
		jbtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSave_actionPerformed(e);
			}
		});
		panel.add(jbtnSave);

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_2 = new JLabel("ID");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtextFieldIdFind = new JTextField();
		jtextFieldIdFind.setColumns(10);
		GridBagConstraints gbc_jtextFieldIdFind = new GridBagConstraints();
		gbc_jtextFieldIdFind.insets = new Insets(0, 0, 5, 5);
		gbc_jtextFieldIdFind.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldIdFind.gridx = 1;
		gbc_jtextFieldIdFind.gridy = 0;
		panel_1.add(jtextFieldIdFind, gbc_jtextFieldIdFind);

		JButton jbtnFind = new JButton("Find");
		jbtnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnFind_actionPerformed(e);
			}
		});
		GridBagConstraints gbc_jbtnFind = new GridBagConstraints();
		gbc_jbtnFind.insets = new Insets(0, 0, 5, 5);
		gbc_jbtnFind.gridx = 2;
		gbc_jbtnFind.gridy = 0;
		panel_1.add(jbtnFind, gbc_jbtnFind);

		jlabelFound = new JLabel("");
		GridBagConstraints gbc_jlabelFound = new GridBagConstraints();
		gbc_jlabelFound.insets = new Insets(0, 0, 5, 5);
		gbc_jlabelFound.gridx = 1;
		gbc_jlabelFound.gridy = 1;
		panel_1.add(jlabelFound, gbc_jlabelFound);

		JLabel lblNewLabel_3 = new JLabel("Issue Date");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jlabelIssueDate = new JLabel("9/18/2023");
		GridBagConstraints gbc_jlabelIssueDate = new GridBagConstraints();
		gbc_jlabelIssueDate.anchor = GridBagConstraints.WEST;
		gbc_jlabelIssueDate.insets = new Insets(0, 0, 5, 5);
		gbc_jlabelIssueDate.gridx = 1;
		gbc_jlabelIssueDate.gridy = 2;
		panel_1.add(jlabelIssueDate, gbc_jlabelIssueDate);

		JLabel lblNewLabel_4 = new JLabel("Due Date");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jlabelDueDate = new JLabel("9/18/2023");
		GridBagConstraints gbc_jlabelDueDate = new GridBagConstraints();
		gbc_jlabelDueDate.anchor = GridBagConstraints.WEST;
		gbc_jlabelDueDate.insets = new Insets(0, 0, 5, 5);
		gbc_jlabelDueDate.gridx = 1;
		gbc_jlabelDueDate.gridy = 3;
		panel_1.add(jlabelDueDate, gbc_jlabelDueDate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		panel_1.add(scrollPane, gbc_scrollPane);

		jtableBooks = new JTable();
		scrollPane.setViewportView(jtableBooks);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_3);

		JButton jbtnClose = new JButton("Close");
		jbtnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnClose_actionPerformed(e);
			}
		});
		panel_3.add(jbtnClose);
	}

	public jFrameCheckOut(Map<Integer, String> data) {
		this();
		this.data = data;
		initFrame();
	}

	private void initFrame() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Call number");
		model.addColumn("ISBN number");
		model.addColumn("Title");
		model.addColumn("Author");

		for (String i : data.values()) {
			BookModel bookModel = new BookModel();
			Book book = bookModel.findISBN(i);
			model.addRow(
					new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(), book.getAuthor_name() });
		}

		jtableBooks.setModel(model);
		
		LocalDate currentDate = LocalDate.now(); 
		jlabelIssueDate.setText(currentDate.toString());
		jlabelDueDate.setText(currentDate.plus(5, ChronoUnit.DAYS).toString());
		
		jbtnSave.setEnabled(false);
	}
	public void jbtnClose_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
	
	public void jbtnFind_actionPerformed(ActionEvent e) {
		if (!jtextFieldIdFind.getText().equals("")) {
			int finId = Integer.parseInt(jtextFieldIdFind.getText());
			EmployeeModel employeeModel = new EmployeeModel();
			Employee employee = employeeModel.findId(finId);
			if (employee.getName() != null) {
				employee_id = employee.getId();
				DepartmentModels departmentModels = new DepartmentModels();
				jlabelFound.setText(employee.getName() + ", " + departmentModels.find(employee.getDepartmentid()));
				IssuedModel issuedModel = new IssuedModel();
				row = issuedModel.CountIssued_Idemployee(employee.getId());
//				System.out.println(row);
				if(row>5) {
					System.out.println("Da muon qua so sach quy dinh > 5");
				} else {
					jbtnSave.setEnabled(true);
				}
				
			} else {
				jlabelFound.setText("User not found");
			}
		}
	}
	
	public void jbtnSave_actionPerformed(ActionEvent e) {
		
		int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm book borrowing", JOptionPane.YES_NO_OPTION);
        
        if (dialogResult == JOptionPane.YES_OPTION) {
//    		Date date = new Date();
//    		LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
//    		Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    		int rowTableBooks = jtableBooks.getRowCount();
//    		System.out.println(rowTableBooks);
    		if(rowTableBooks+row > 5) {
    			System.out.println("Chi duoc muon them " + (5 - row) + "cuon sach");
    			JOptionPane.showMessageDialog(this, "Only allowed to borrow " + (5 - row) +  " more books", "Notification", JOptionPane.WARNING_MESSAGE);
    		} else {
    			IssuedModel issuedModel = new IssuedModel();
    			for (String i : data.values()) {
    				BookModel bookModel = new BookModel();
    				Book book = bookModel.findISBN(i);
    				int id_book = book.getId();
    				issuedModel.create(employee_id, id_book, false);
    				bookModel.update_status(true, id_book);
    			}
    			this.setVisible(false);
    		}
        }
	}
}
