package demo;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import entities.Book;
import entities.DDC;
import models.BookModel;
import models.DDCModel;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionListener;

public class JpanelEditBook2 extends JPanel {
	private JTextField jtextFieldTitle;
	private JTextField jtextFieldAuthor;
	private JTextField jtextFieldBookFee;
	private JButton jbuttonSave;
	private JButton jbuttonCancel;
	private JComboBox jcomboBoxDDC;
	private JCheckBox jcheckboxDisplay;
	private JCheckBox jcheckboxIssueStatus;
	private Map<String, Object> data = new HashMap<String, Object>();
	private Book book;

	/**
	 * Create the panel.
	 */
	public JpanelEditBook2() {
		setBorder(new TitledBorder(null, "Edit Book", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_4);

		JLabel lblNewLabel = new JLabel("Title");
		panel_4.add(lblNewLabel);

		jtextFieldTitle = new JTextField();
		panel_4.add(jtextFieldTitle);
		jtextFieldTitle.setColumns(18);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_5);

		JLabel lblNewLabel_1 = new JLabel("Author");
		panel_5.add(lblNewLabel_1);

		jtextFieldAuthor = new JTextField();
		panel_5.add(jtextFieldAuthor);
		jtextFieldAuthor.setColumns(18);

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_6);

		JLabel lblNewLabel_2 = new JLabel("Book Fee");
		panel_6.add(lblNewLabel_2);

		jtextFieldBookFee = new JTextField();
		panel_6.add(jtextFieldBookFee);
		jtextFieldBookFee.setColumns(18);

		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_7);

		jcheckboxIssueStatus = new JCheckBox("Issued Status");
		jcheckboxIssueStatus.setEnabled(false);
		panel_7.add(jcheckboxIssueStatus);

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_8.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_8);

		jcheckboxDisplay = new JCheckBox("Display");
		panel_8.add(jcheckboxDisplay);

		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

		JLabel lblNewLabel_3 = new JLabel("DDC ");
		panel_9.add(lblNewLabel_3);

		jcomboBoxDDC = new JComboBox();
		panel_9.add(jcomboBoxDDC);

		JPanel panel_10 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_10.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_10);

		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		panel_10.add(jbuttonSave);

		jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancel_actionPerformed(e);
			}
		});
		panel_10.add(jbuttonCancel);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

	}

// Cancel button
	public void jbuttonCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

//send data
	public JpanelEditBook2(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
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

	// Save button
	public void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			String title = jtextFieldTitle.getText().trim();
			String author = jtextFieldAuthor.getText().trim();
			int id = Integer.parseInt(data.get("id").toString());
			BookModel bookModel = new BookModel();
			Book book = bookModel.find(id);
			book.setCall_number(createCallNumber(title, author));
			DDC ddc = (DDC) jcomboBoxDDC.getSelectedItem();

//					book.setIsbn(creatISBN(ddc.getNumeric_code()));
			book.setTitle(title);
			book.setAuthor_name(author);
			book.setBook_fee(Double.parseDouble(jtextFieldBookFee.getText().trim()));
			book.setIssue_status(jcheckboxIssueStatus.isSelected());
			book.setDisplay(jcheckboxDisplay.isSelected());
			book.setDdc_id(ddc.getId());

			if (bookModel.edit(book)) {
				JOptionPane.showMessageDialog(null, "Done");

			} else {
				JOptionPane.showMessageDialog(null, "Bad");

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());

		}
	}

	// init JFrame
	private void initJFrame() {
		DDCModel ddcModel = new DDCModel();
		BookModel bookModel = new BookModel();
		DefaultComboBoxModel<DDC> model = new DefaultComboBoxModel<DDC>();
		for (DDC ddc : ddcModel.findAll()) {
			model.addElement(ddc);
		}
		jcomboBoxDDC.setModel(model);
		jcomboBoxDDC.setRenderer(new DdcCellRender());
		int id = Integer.parseInt(data.get("id").toString());
		book = bookModel.find(id);
		jtextFieldTitle.setText(book.getTitle());
		jtextFieldAuthor.setText(book.getAuthor_name());
		jtextFieldBookFee.setText(String.valueOf(book.getBook_fee()));
		jcheckboxIssueStatus.setSelected(book.isIssue_status());
		jcheckboxDisplay.setSelected(book.isDisplay());
		jcomboBoxDDC.getModel().setSelectedItem(ddcModel.find(book.getDdc_id()));
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
