package demo;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Book;
import entities.DDC;
import models.BookModel;
import models.DDCModel;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFrameBookDetail extends JFrame {

	private JPanel contentPane;
	private JLabel jlabelDDC;
	private JLabel jlabelDisplay;
	private JLabel jlabelIssuedStatus;
	private JLabel jlabelBookFee;
	private JLabel jlabelAuthor;
	private JLabel jlabelTitle;
	private Map<String, Object> data = new HashMap<String, Object>();
	private Book book;
	private JButton jbuttonBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameBookDetail frame = new JFrameBookDetail();
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
	public JFrameBookDetail() {
		setTitle("Book Detail");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.PAGE_AXIS));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);

		JLabel lblNewLabel = new JLabel("Title: ");
		panel_4.add(lblNewLabel);

		jlabelTitle = new JLabel("");
		panel_4.add(jlabelTitle);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);

		JLabel lblNewLabel_2 = new JLabel("Author: ");
		panel_5.add(lblNewLabel_2);

		jlabelAuthor = new JLabel("");
		panel_5.add(jlabelAuthor);

		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);

		JLabel lblNewLabel_4 = new JLabel("Book Fee: ");
		panel_6.add(lblNewLabel_4);

		jlabelBookFee = new JLabel("");
		panel_6.add(jlabelBookFee);

		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);

		JLabel lblNewLabel_6 = new JLabel("Issued Status: ");
		panel_7.add(lblNewLabel_6);

		jlabelIssuedStatus = new JLabel("");
		panel_7.add(jlabelIssuedStatus);

		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);

		JLabel lblNewLabel_7 = new JLabel("Display");
		panel_8.add(lblNewLabel_7);

		jlabelDisplay = new JLabel("");
		panel_8.add(jlabelDisplay);

		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);

		JLabel lblNewLabel_8 = new JLabel("DDC: ");
		panel_9.add(lblNewLabel_8);

		jlabelDDC = new JLabel("");
		panel_9.add(jlabelDDC);

		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);

		jbuttonBack = new JButton("Back");
		jbuttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBack_actionPerformed(e);
			}
		});
		panel_11.add(jbuttonBack);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
	// back to main page

	public void jbuttonBack_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	// send data
	public JFrameBookDetail(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}

	// init JFrame
	private void initJFrame() {
		DDCModel ddcModel = new DDCModel();
		BookModel bookModel = new BookModel();

		int id = Integer.parseInt(data.get("id").toString());
		book = bookModel.find(id);
		jlabelTitle.setText(book.getTitle());
		jlabelAuthor.setText(book.getAuthor_name());
		jlabelBookFee.setText(String.valueOf(book.getBook_fee()));
		jlabelIssuedStatus.setText(String.valueOf(book.isIssue_status()));
		jlabelDisplay.setText(String.valueOf(book.isDisplay()));
		jlabelDDC.setText((ddcModel.find(book.getDdc_id()).getGroup_name()));
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
