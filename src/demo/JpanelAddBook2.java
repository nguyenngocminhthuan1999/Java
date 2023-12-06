package demo;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.border.TitledBorder;

import entities.Book;
import entities.DDC;
import models.BookModel;
import models.DDCModel;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JSplitPane;

public class JpanelAddBook2 extends JPanel {
	private JTextField jtextFieldTitle;
	private JTextField jtextFieldAuthor;
	private JTextField jtextFieldBookFee;
	private JTextField jtextFieldDDCName;
	private JTextField jtextFieldNumericCode;
	private JComboBox jcomboBoxDDC;
	private JButton jbuttonSave;
	private JCheckBox jcheckboxDisplay;
	private JCheckBox jcheckboxIssueStatus;
	private JButton jbuttonSaveDDC;

	/**
	 * Create the panel.
	 */
	public JpanelAddBook2() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel jpanelAddBook = new JPanel();
		jpanelAddBook.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), " Add Book", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(jpanelAddBook);
		jpanelAddBook.setLayout(new BorderLayout(0, 0));

		JPanel jpanelMain = new JPanel();
		jpanelAddBook.add(jpanelMain);
		jpanelMain.setLayout(new BoxLayout(jpanelMain, BoxLayout.X_AXIS));

		JPanel panel_2 = new JPanel();
		jpanelMain.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));

		JPanel panel_4_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_4_1);

		JLabel lblTitle = new JLabel("Title");
		panel_4_1.add(lblTitle);

		jtextFieldTitle = new JTextField();
		panel_4_1.add(jtextFieldTitle);
		jtextFieldTitle.setColumns(15);

		JPanel panel_5_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_5_1);

		JLabel lblNewLabel_2_1 = new JLabel("Author");
		panel_5_1.add(lblNewLabel_2_1);

		jtextFieldAuthor = new JTextField();
		jtextFieldAuthor.setColumns(15);
		panel_5_1.add(jtextFieldAuthor);

		JPanel panel_6_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6_1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_6_1);

		JLabel lblNewLabel_2_2 = new JLabel("Book Fee");
		panel_6_1.add(lblNewLabel_2_2);

		jtextFieldBookFee = new JTextField();
		jtextFieldBookFee.setColumns(15);
		panel_6_1.add(jtextFieldBookFee);

		JPanel panel_7_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7_1.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_7_1);

		JLabel lblNewLabel = new JLabel("Issue Status");
		lblNewLabel.setEnabled(false);
		panel_7_1.add(lblNewLabel);

		jcheckboxIssueStatus = new JCheckBox("");
		jcheckboxIssueStatus.setEnabled(false);
		panel_7_1.add(jcheckboxIssueStatus);

		JPanel panel_8_1 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_8_1.getLayout();
		flowLayout_4.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_8_1);

		JLabel lblNewLabel_1 = new JLabel("Display");
		panel_8_1.add(lblNewLabel_1);

		jcheckboxDisplay = new JCheckBox("");
		jcheckboxDisplay.setSelected(true);
		panel_8_1.add(jcheckboxDisplay);

		JPanel panel_9_1 = new JPanel();
		panel_2.add(panel_9_1);
		panel_9_1.setLayout(new BoxLayout(panel_9_1, BoxLayout.X_AXIS));

		JLabel lblNewLabel_3 = new JLabel("  DDC  ");
		panel_9_1.add(lblNewLabel_3);

		jcomboBoxDDC = new JComboBox();
		panel_9_1.add(jcomboBoxDDC);

		JPanel panel_10_1 = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) panel_10_1.getLayout();
		flowLayout_8.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_10_1);

		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		panel_10_1.add(jbuttonSave);

		JPanel panel_3 = new JPanel();
		jpanelMain.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel jpanelAddDDC = new JPanel();
		jpanelAddDDC.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add DDC",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(jpanelAddDDC);
		jpanelAddDDC.setLayout(new BorderLayout(0, 0));

		JPanel jpanelMainDDC = new JPanel();
		jpanelAddDDC.add(jpanelMainDDC);
		jpanelMainDDC.setLayout(new BoxLayout(jpanelMainDDC, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		jpanelMainDDC.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_5);

		JLabel lblNewLabel_2 = new JLabel("Name");
		panel_5.add(lblNewLabel_2);

		jtextFieldDDCName = new JTextField();
		panel_5.add(jtextFieldDDCName);
		jtextFieldDDCName.setColumns(15);

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_6);

		JLabel lblNewLabel_2_3 = new JLabel("Numeric Code");
		panel_6.add(lblNewLabel_2_3);

		jtextFieldNumericCode = new JTextField();
		jtextFieldNumericCode.setColumns(15);
		panel_6.add(jtextFieldNumericCode);

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setAlignment(FlowLayout.RIGHT);
		panel_1.add(panel_7);

		jbuttonSaveDDC = new JButton("Save");
		jbuttonSaveDDC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSaveDDC_actionPerformed(e);
			}
		});
		panel_7.add(jbuttonSaveDDC);
		
		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_4 = new JPanel();
		jpanelMainDDC.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		initJFrame();
	}

	// create isbn
	public String creatISBN(String numericCode) {
		DDC ddc = (DDC) jcomboBoxDDC.getSelectedItem();
		numericCode = ddc.getNumeric_code();
		return String.format("%s-%04d", numericCode, sequenceNumber);
	}

	// Create CallNumber
	public String createCallNumber(String title, String author) {
		String firstTwoLettersOfTitle = title.substring(0, 2).toLowerCase();
		String firstTwoLettersOfAuthor = author.substring(0, 2).toLowerCase();
		return String.format("%s-%s-%03d", firstTwoLettersOfTitle, firstTwoLettersOfAuthor, sequenceNumber);
	}

	// Creat sequenceNumber
	private static int sequenceNumber = 1;
	

	public static int getNextSequenceNumber() {
		return sequenceNumber++;
	}

	// init JFrame
	private void initJFrame() {
		DDCModel ddcModel = new DDCModel();
		DefaultComboBoxModel<DDC> model = new DefaultComboBoxModel<DDC>();
		for (DDC ddc : ddcModel.findAll()) {
			model.addElement(ddc);
		}
		jcomboBoxDDC.setModel(model);
		jcomboBoxDDC.setRenderer(new DdcCellRender());
	}

	// Save Book button
	public void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			Book book = new Book();
			String title = jtextFieldTitle.getText().trim();
			String author = jtextFieldAuthor.getText().trim();
			BookModel bookModel = new BookModel();
			book.setCall_number(createCallNumber(title, author));
			DDC ddc = (DDC) jcomboBoxDDC.getSelectedItem();

			book.setIsbn(creatISBN(ddc.getNumeric_code()));
			book.setTitle(title);
			book.setAuthor_name(author);
			book.setBook_fee(Double.parseDouble(jtextFieldBookFee.getText().trim()));
			book.setIssue_status(jcheckboxIssueStatus.isSelected());
			book.setDisplay(jcheckboxDisplay.isSelected());
			book.setDdc_id(ddc.getId());

			if (bookModel.create(book)) {
				JOptionPane.showMessageDialog(null, "Done");
				getNextSequenceNumber();
				JpanelBookMagenement jpanelBookMagenement = new JpanelBookMagenement();
				jpanelBookMagenement.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Bad");

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());

		}
	}

	// ADD new DDC
	public void jbuttonSaveDDC_actionPerformed(ActionEvent e) {
		DDC ddc = new DDC();
		ddc.setNumeric_code(jtextFieldNumericCode.getText().trim());
		ddc.setGroup_name(jtextFieldDDCName.getText().trim());
		DDCModel ddcModel = new DDCModel();
		if (ddcModel.create(ddc)) {
			JOptionPane.showMessageDialog(null, "Done");

		} else {
			JOptionPane.showMessageDialog(null, "Failed");

		}
	}

	// DDC CellRender
	private class DdcCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			DDC ddc = (DDC) value;
			return super.getListCellRendererComponent(list, ddc.getGroup_name(), index, isSelected, cellHasFocus);
		}
	}
}
