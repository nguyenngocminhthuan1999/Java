package main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Cursor;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import entities.Book;
import entities.Employee;
import entities.Issued;
import models.BookModel;
import models.DepartmentModels;
import models.EmployeeModel;
import models.IssuedModel;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;

public class jFrameDetailViewBook extends JFrame {

	private JPanel contentPane;
	private Map<String, Object> data = new HashMap<String, Object>();
	private JTable jtableDetail;
	private JTextField jtextFieldCallNumber;
	private JTextField jtextFieldISBN;
	private JTextField jtextFieldTitle;
	private JTextField jtextFieldAuthor;
	private JTextField jtextFieldFee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameDetailViewBook frame = new jFrameDetailViewBook();
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
	public jFrameDetailViewBook() {
		setUndecorated(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("The Information and Status of the book");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel_1 = new JLabel("Call Number");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtextFieldCallNumber = new JTextField();
		jtextFieldCallNumber.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		jtextFieldCallNumber.setEditable(false);
		jtextFieldCallNumber.setCaretColor(Color.getHSBColor(HEIGHT, ALLBITS, ABORT));
		GridBagConstraints gbc_jtextFieldCallNumber = new GridBagConstraints();
		gbc_jtextFieldCallNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldCallNumber.insets = new Insets(0, 0, 5, 0);
		gbc_jtextFieldCallNumber.gridx = 1;
		gbc_jtextFieldCallNumber.gridy = 0;
		panel_2.add(jtextFieldCallNumber, gbc_jtextFieldCallNumber);
		jtextFieldCallNumber.setColumns(30);

		JLabel lblNewLabel_2 = new JLabel("ISBN");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 1;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtextFieldISBN = new JTextField();
		jtextFieldISBN.setEditable(false);
		GridBagConstraints gbc_jtextFieldISBN = new GridBagConstraints();
		gbc_jtextFieldISBN.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldISBN.insets = new Insets(0, 0, 5, 0);
		gbc_jtextFieldISBN.gridx = 1;
		gbc_jtextFieldISBN.gridy = 1;
		panel_2.add(jtextFieldISBN, gbc_jtextFieldISBN);
		jtextFieldISBN.setColumns(30);

		JLabel lblNewLabel_3 = new JLabel("Title");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtextFieldTitle = new JTextField();
		jtextFieldTitle.setEditable(false);
		GridBagConstraints gbc_jtextFieldTitle = new GridBagConstraints();
		gbc_jtextFieldTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldTitle.insets = new Insets(0, 0, 5, 0);
		gbc_jtextFieldTitle.gridx = 1;
		gbc_jtextFieldTitle.gridy = 2;
		panel_2.add(jtextFieldTitle, gbc_jtextFieldTitle);
		jtextFieldTitle.setColumns(70);

		JLabel lblNewLabel_4 = new JLabel("Author");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 3;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtextFieldAuthor = new JTextField();
		jtextFieldAuthor.setEditable(false);
		GridBagConstraints gbc_jtextFieldAuthor = new GridBagConstraints();
		gbc_jtextFieldAuthor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldAuthor.insets = new Insets(0, 0, 5, 0);
		gbc_jtextFieldAuthor.gridx = 1;
		gbc_jtextFieldAuthor.gridy = 3;
		panel_2.add(jtextFieldAuthor, gbc_jtextFieldAuthor);
		jtextFieldAuthor.setColumns(30);

		JLabel lblNewLabel_5 = new JLabel("Book Price");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 4;
		panel_2.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtextFieldFee = new JTextField();
		jtextFieldFee.setEditable(false);
		GridBagConstraints gbc_jtextFieldFee = new GridBagConstraints();
		gbc_jtextFieldFee.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextFieldFee.gridx = 1;
		gbc_jtextFieldFee.gridy = 4;
		panel_2.add(jtextFieldFee, gbc_jtextFieldFee);
		jtextFieldFee.setColumns(30);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);

		jtableDetail = new JTable();
		scrollPane.setViewportView(jtableDetail);

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

	public jFrameDetailViewBook(Map<String, Object> data) {
		this();
		this.data = data;
		initFrame();
	}

	private void initFrame() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Employee ID");
		model.addColumn("Name");
		model.addColumn("Department");
		model.addColumn("Borrow date");
		model.addColumn("Due date");
		model.addColumn("Return date");
		model.addColumn("Status");
		BookModel bookModel = new BookModel();
		Book book = bookModel.findISBN(data.get("isbn").toString());
		jtextFieldCallNumber.setText(book.getCall_number());
		jtextFieldISBN.setText(book.getIsbn());
		jtextFieldTitle.setText(book.getTitle());
		jtextFieldAuthor.setText(book.getAuthor_name());
//		System.out.println(book.getBook_fee.toString());
		jtextFieldFee.setText(book.getBook_fee().toString());
		IssuedModel issuedModel = new IssuedModel();
		for (Issued issued : issuedModel.findIssued_Idbook(book.getId())) {

			EmployeeModel employeeModel = new EmployeeModel();
			Employee employee = employeeModel.findId(issued.getId_employee());

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(issued.getIssue_date());
			calendar.add(Calendar.DAY_OF_MONTH, 5);
			Date newDate = calendar.getTime();
			String due_date = dateFormat.format(newDate);
			DepartmentModels departmentModels = new DepartmentModels();
//			System.out.println(departmentModels.find(employee.getDepartmentid()));
//			System.out.println(departmentModels.find(1));
			model.addRow(new Object[] { employee.getId(), employee.getName(), departmentModels.find(employee.getDepartmentid()),
					issued.getIssue_date(), due_date, issued.getReturn_date(), issued.isStatus() ? "Returned" : "Borrow" });
		}

		jtableDetail.setModel(model);
	}

	public void jbtnClose_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
