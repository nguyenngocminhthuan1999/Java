package main;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import component.Login;
import component.Main1;
import entities.Book;
//import entities.Employee;
import entities.Issued;
import models.BookModel;
//import models.EmployeeModel;
import models.IssuedModel;

import java.awt.Cursor;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;

public class jFrameCheckIn extends JFrame {

	private JPanel contentPane;
	private Map<Integer, String> data = new HashMap<Integer, String>();
	private JTable jtableContent;
	private JButton jbtnSave;
	private JTextField jtextFieldTotal;
	
	private Map<Integer, Integer> id_issued = new HashMap<Integer, Integer>();
	private Map<Integer, Integer> id_book = new HashMap<Integer, Integer>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jFrameCheckIn frame = new jFrameCheckIn();
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
	public jFrameCheckIn() {
		setUndecorated(true);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_2);

		JLabel lblConfirmingTheBook = new JLabel("Confirming the book return");
		lblConfirmingTheBook.setFont(new Font("Arial", Font.BOLD, 20));
		panel_2.add(lblConfirmingTheBook);

		JPanel panel_2_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2_1.getLayout();
		flowLayout_1.setHgap(80);
		panel_2.add(panel_2_1);

		jbtnSave = new JButton("SAVE");
		jbtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSave_actionPerformed(e);
			}
		});
		panel_2.add(jbtnSave);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_1_1 = new JPanel();
		contentPane.add(panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0 };
		gbl_panel_1_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
		panel_1_1.setLayout(gbl_panel_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new LineBorder(new Color(130, 135, 144)));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1_1.add(scrollPane, gbc_scrollPane);

		jtableContent = new JTable();
		scrollPane.setViewportView(jtableContent);

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel lblTotal = new JLabel("Total:");
		panel.add(lblTotal);

		jtextFieldTotal = new JTextField();
		jtextFieldTotal.setEditable(false);
		panel.add(jtextFieldTotal);
		jtextFieldTotal.setColumns(25);

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

	public jFrameCheckIn(Map<Integer, String> data) {
		this();
		this.data = data;
		initFrame();
	}

	private void initFrame() {
//		int id_employee = Integer.parseInt(data.get(0));
//		jtextFieldId.setText(data.get(0));
//		EmployeeModel employeeModel = new EmployeeModel();
//		Employee employee = employeeModel.findId(Integer.parseInt(data.get(0)));
//		jtextFieldName.setText(employee.getName());
//		jtextFieldPhone.setText(employee.getPhone());

//		DefaultTableModel model = new DefaultTableModel() {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Call number");
		model.addColumn("ISBN number");
		model.addColumn("Title");
		model.addColumn("Author");
		model.addColumn("Issue date");
		model.addColumn("Late fee");
		data.remove(0);
		int count = 0;
		long total = 0;
		for (String i : data.values()) {
			BookModel bookModel = new BookModel();
			Book book = bookModel.findISBN(i);
			IssuedModel issuedModel = new IssuedModel();
//			Issued issued = issuedModel.findIssued_Idbook_Idemployee_Status(book.getId(), id_employee);
			Issued issued = issuedModel.findIssued_Idbook_Idemployee_Status(book.getId(), 1);
			
			System.out.println(issued.getId_book());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date inputDate = issued.getIssue_date();

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(inputDate);
			calendar.add(Calendar.DAY_OF_MONTH, 5); // Cộng thêm 5 ngày

			Date newSqlDate = new Date(calendar.getTimeInMillis());

			Date startDate = newSqlDate;
			
			java.util.Date currentDate = new java.util.Date();

	        // Chuyển đổi thành java.sql.Date
	        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
	        
			Date endDate = sqlDate;

			Calendar calendar1 = Calendar.getInstance();
			calendar1.setTime(startDate);

			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(endDate);

			long milliseconds1 = calendar1.getTimeInMillis();
			long milliseconds2 = calendar2.getTimeInMillis();

			long diff = milliseconds2 - milliseconds1;
			long diffDays = diff / (24 * 60 * 60 * 1000);
			
			long late_fee = 0;
			
			if(diffDays>0) {
				late_fee = 10*diffDays;
			}
			id_issued.put(count ,issued.getId());
			id_book.put(issued.getId() ,book.getId());
			count++;
			
			total += late_fee;
			
			model.addRow(new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(), book.getAuthor_name(),
					issued.getIssue_date(), late_fee + " cents" });
		}
		jtableContent.setModel(model);
		
		jtextFieldTotal.setText(total + " cents");
		jbtnSave.setEnabled(true);
	}

	public void jbtnClose_actionPerformed(ActionEvent e) {
		JPanelBook jPanelBook = new JPanelBook();
		jPanelBook.revalidate();
		jPanelBook.repaint();
//		JFrameMain jFrameMain = new JFrameMain();
//		jFrameMain.initFrame();
		this.setVisible(false);
	}

	public void jbtnSave_actionPerformed(ActionEvent e) {
		
		int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm book return", JOptionPane.YES_NO_OPTION);
        
        if (dialogResult == JOptionPane.YES_OPTION) {
        	java.util.Date currentDate = new java.util.Date();

            // Chuyển đổi thành java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
            
    		for (int i : id_issued.values()) {
    			
    			IssuedModel issuedModel = new IssuedModel();
    			issuedModel.update_status(true, i, sqlDate);
    			
    			Issued issued = issuedModel.findID(i);
    			int id_book = issued.getId_book();
    			
    			BookModel bookModel = new BookModel();
    			bookModel.update_status(false, id_book);
    		}
    		this.setVisible(false);
        }
	}
}
