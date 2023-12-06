package demo;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import entities.DDC;
import models.BookModel;
import models.DDCModel;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JToggleButton;

public class JpanelBookMagenement extends JPanel {
	private final ButtonGroup buttonGroupBook = new ButtonGroup();
	private JTable jtableBook;
	private JTextField jtextFieldKeyWord;
	private JButton jbuttonAdd;
	private JButton jbuttonSearch;
	private JPanel jpanelShowInfo;
	private JTable jtableDDC;
	private JButton jbuttonBookDelete;
	private JButton jbuttonBookEdit;
	private JButton jbuttonDDCDelete;
	private JButton jbuttonDDCEdit;
	private JPanel jpanelBookButton;
	private JPanel jpanelDDCButton;
	private JButton jbuttonAddCancel;
	private JButton jbuttonBookDetail;
	private JToggleButton jtooglebuttonBookSort;
	private JRadioButton jradiochekISBN;

	/**
	 * Create the panel.
	 */
	public JpanelBookMagenement() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setLayout(new BorderLayout(0, 0));

		JPanel jpanelBottom = new JPanel();
		add(jpanelBottom, BorderLayout.SOUTH);

		JPanel jpanelBookTop = new JPanel();
		jpanelBookTop.setBackground(new Color(255, 255, 255));
		add(jpanelBookTop, BorderLayout.NORTH);
		jpanelBookTop.setLayout(new BoxLayout(jpanelBookTop, BoxLayout.PAGE_AXIS));

		JPanel jpanelTitle = new JPanel();
		jpanelTitle.setBackground(new Color(65, 105, 225));
		jpanelBookTop.add(jpanelTitle);

		JLabel lblNewLabel = new JLabel("Book Magenement");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 18));
		jpanelTitle.add(lblNewLabel);

		JPanel jpanelButton = new JPanel();
		jpanelBookTop.add(jpanelButton);
		jpanelButton.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JRadioButton jradiocheckTitle = new JRadioButton("Title");
		buttonGroupBook.add(jradiocheckTitle);
		jpanelButton.add(jradiocheckTitle);

		JRadioButton jradiocheckAuthor = new JRadioButton("Author");
		buttonGroupBook.add(jradiocheckAuthor);
		jpanelButton.add(jradiocheckAuthor);

		jtextFieldKeyWord = new JTextField();
		jtextFieldKeyWord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				jtextFieldKeyWord_keyReleased(e);
			}
		});

		jradiochekISBN = new JRadioButton("ISBN");
		buttonGroupBook.add(jradiochekISBN);
		jpanelButton.add(jradiochekISBN);
		jpanelButton.add(jtextFieldKeyWord);
		jtextFieldKeyWord.setColumns(15);

		jbuttonSearch = new JButton("");
		jbuttonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSearch_actionPerformed(e);
			}
		});
		jbuttonSearch.setIcon(new ImageIcon(JpanelBookMagenement.class.getResource("/resources/Search.png")));
		jpanelButton.add(jbuttonSearch);

		jbuttonAdd = new JButton("");
		jbuttonAdd.setIcon(new ImageIcon(JpanelBookMagenement.class.getResource("/resources/Bookadd3.png")));
		jbuttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAdd_actionPerformed(e);
			}
		});

		jtooglebuttonBookSort = new JToggleButton("");
		jtooglebuttonBookSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtooglebuttonBookSort_actionPerformed(e);
			}
		});
		jtooglebuttonBookSort.setIcon(new ImageIcon(JpanelBookMagenement.class.getResource("/resources/Sort.png")));
		jpanelButton.add(jtooglebuttonBookSort);
		jpanelButton.add(jbuttonAdd);

		jbuttonAddCancel = new JButton("");
		jbuttonAddCancel.setIcon(new ImageIcon(JpanelBookMagenement.class.getResource("/resources/Back.png")));
		jbuttonAddCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonAddCancel_actionPerformed(e);
			}
		});
		jpanelButton.add(jbuttonAddCancel);

		JPanel jpanelCenter = new JPanel();
		add(jpanelCenter);
		jpanelCenter.setLayout(new BoxLayout(jpanelCenter, BoxLayout.PAGE_AXIS));

		JPanel panel_2 = new JPanel();
		jpanelCenter.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtableBook = new JTable();
		jtableBook.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtableBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableBook_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableBook);

		jpanelBookButton = new JPanel();
		FlowLayout fl_jpanelBookButton = (FlowLayout) jpanelBookButton.getLayout();
		fl_jpanelBookButton.setAlignment(FlowLayout.RIGHT);
		panel_2.add(jpanelBookButton, BorderLayout.SOUTH);

		jbuttonBookDelete = new JButton("Delete");
		jbuttonBookDelete.setIcon(new ImageIcon(JpanelBookMagenement.class.getResource("/resources/Delete.png")));
		jbuttonBookDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBookDelete_actionPerformed(e);
			}
		});
		jpanelBookButton.add(jbuttonBookDelete);

		jbuttonBookEdit = new JButton("Edit");
		jbuttonBookEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBookEdit_actionPerformed(e);
			}
		});
		jbuttonBookEdit.setIcon(new ImageIcon(JpanelBookMagenement.class.getResource("/resources/Modify.png")));
		jpanelBookButton.add(jbuttonBookEdit);

		jbuttonBookDetail = new JButton("Detail");
		jbuttonBookDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonBookDetail_actionPerformed(e);
			}
		});
		jbuttonBookDetail.setIcon(new ImageIcon(JpanelBookMagenement.class.getResource("/resources/Info.png")));
		jpanelBookButton.add(jbuttonBookDetail);

		JPanel panel = new JPanel();
		jpanelCenter.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, BorderLayout.CENTER);

		jtableDDC = new JTable();
		jtableDDC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableDDC_mouseClicked(e);
			}
		});
		jtableDDC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(jtableDDC);

		jpanelDDCButton = new JPanel();
		FlowLayout fl_jpanelDDCButton = (FlowLayout) jpanelDDCButton.getLayout();
		fl_jpanelDDCButton.setAlignment(FlowLayout.RIGHT);
		panel.add(jpanelDDCButton, BorderLayout.SOUTH);

		jbuttonDDCDelete = new JButton("Delete");
		jbuttonDDCDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDDCDelete_actionPerformed(e);
			}
		});
		jbuttonDDCDelete.setIcon(new ImageIcon(JpanelBookMagenement.class.getResource("/resources/Delete.png")));
		jpanelDDCButton.add(jbuttonDDCDelete);

		jbuttonDDCEdit = new JButton("Edit");
		jbuttonDDCEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonDDCEdit_actionPerformed(e);
			}
		});
		jbuttonDDCEdit.setIcon(new ImageIcon(JpanelBookMagenement.class.getResource("/resources/Modify.png")));
		jpanelDDCButton.add(jbuttonDDCEdit);

		jpanelShowInfo = new JPanel();
		jpanelCenter.add(jpanelShowInfo);
		jpanelShowInfo.setLayout(new BorderLayout(0, 0));
		initJFrame();
	}

	// =====Book Control=====//
//------------------------------------//
	// fill data to Book table
	private void fillDataToTable(List<Book> books) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		DDCModel ddcModel = new DDCModel();
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("calnumber");
		defaultTableModel.addColumn("isbn");
		defaultTableModel.addColumn("title");
		defaultTableModel.addColumn("author_name");
		defaultTableModel.addColumn("book_fee");
		defaultTableModel.addColumn("issue_status");
		defaultTableModel.addColumn("display");
		defaultTableModel.addColumn("ddc_name");

		for (Book book : books) {
			defaultTableModel.addRow(new Object[] { book.getId(), book.getCall_number(), book.getIsbn(),
					book.getTitle(), book.getAuthor_name(), book.getBook_fee(), book.isIssue_status(), book.isDisplay(),
					ddcModel.find(book.getDdc_id()).getGroup_name() });
		}
		jtableBook.setModel(defaultTableModel);
		jtableBook.getTableHeader().setReorderingAllowed(false);
	}

//------------------------------------//
	// Edit Book Setup
	public void editBook() {
		int selectedRow = jtableBook.getSelectedRow();
		int id = Integer.parseInt(jtableBook.getValueAt(selectedRow, 0).toString());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);
		JpanelEditBook2 jpanelEditBook2 = new JpanelEditBook2(data);
		jpanelShowInfo.add(jpanelEditBook2);

	}

	// Edit book
	public void jbuttonBookEdit_actionPerformed(ActionEvent e) {
		clearScreen();
		editBook();

	}

// ------------------------------------//
	// Delete Book Setup
	public void deleteBook() {
		int result = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int selectedRow = jtableBook.getSelectedRow();
			int id = Integer.parseInt(jtableBook.getValueAt(selectedRow, 0).toString());

			BookModel bookModel = new BookModel();
			Book book = bookModel.find(id);
			book.setDisplay(false);
			if (book.isIssue_status() == false) {
				if (bookModel.delete(book)) {
					JOptionPane.showMessageDialog(null, "Succes");
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Cannot delete");
			}

		}
	}

	// delete book button
	public void jbuttonBookDelete_actionPerformed(ActionEvent e) {
		deleteBook();
	}
//------------------------------------//

	// =====DDC Control=====//
//------------------------------------//
// fill data to DDC table
	private void fillDataToDDCTable(List<DDC> ddcs) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		DDCModel ddcModel = new DDCModel();
		defaultTableModel.addColumn("id");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Numeric Code");
		for (DDC ddc : ddcs) {
			defaultTableModel.addRow(new Object[] { ddc.getId(), ddc.getGroup_name(), ddc.getNumeric_code() });
		}
		jtableDDC.setModel(defaultTableModel);
		jtableDDC.getTableHeader().setReorderingAllowed(false);
	}

//------------------------------------//
	// delete DDC
	public void jbuttonDDCDelete_actionPerformed(ActionEvent e) {
		deleteDDC();
	}

	// >>>DDC<<<
	public void deleteDDC() {
		int result = JOptionPane.showConfirmDialog(null, "Are You Sure?", "Confirm", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			int selectedRow = jtableDDC.getSelectedRow();
			int id = Integer.parseInt(jtableDDC.getValueAt(selectedRow, 0).toString());
			DDCModel ddcModel = new DDCModel();

			if (ddcModel.delete(id)) {
				JOptionPane.showMessageDialog(null, "Succes");
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}

		}
	}
//------------------------------------//

//Edit DDC
	public void jbuttonDDCEdit_actionPerformed(ActionEvent e) {
		clearScreen();
		editDDC();
	}

	// DDC Edit Setup
	public void editDDC() {
		int selectedRow = jtableDDC.getSelectedRow();
		int id = Integer.parseInt(jtableDDC.getValueAt(selectedRow, 0).toString());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);
		JPanelEditDDC jPanelEditDDC = new JPanelEditDDC(data);
		jpanelShowInfo.add(jPanelEditDDC);

	}
//------------------------------------//
	// =====Search=====//

	// Search by title, author, ISBN
	// Search button
	public void jbuttonSearch_actionPerformed(ActionEvent e) {
		String keyword = jtextFieldKeyWord.getText().trim();
		String selected = getRadioSelected(buttonGroupBook);
		BookModel bookModel = new BookModel();
		if (selected == "Title") {
			fillDataToTable(bookModel.searchByTitle(keyword));
		} else if (selected == "Author") {
			fillDataToTable(bookModel.searchByAuthor(keyword));
		} else if (selected == "ISBN") {
			fillDataToTable(bookModel.searchByISBN(keyword));
		}
	}

	// Type Key
	public void jtextFieldKeyWord_keyReleased(KeyEvent e) {
		String keyword = jtextFieldKeyWord.getText().trim();
		String selected = getRadioSelected(buttonGroupBook);
		BookModel bookModel = new BookModel();
		if (selected == "Title") {
			fillDataToTable(bookModel.searchByTitle(keyword));
		} else if (selected == "Author") {
			fillDataToTable(bookModel.searchByAuthor(keyword));
		}else if (selected == "ISBN") {
			fillDataToTable(bookModel.searchByISBN(keyword));
		}
	}
//------------------------------------//
	// =====Sort Book=====//

	public void jtooglebuttonBookSort_actionPerformed(ActionEvent e) {
		String selected = getRadioSelected(buttonGroupBook);

		BookModel bookModel = new BookModel();
		if (selected == "Title") {
			if (jtooglebuttonBookSort.isSelected()) {
				fillDataToTable(bookModel.sortByTitleASC());
			} else {
				fillDataToTable(bookModel.sortByTitleDESC());
			}
		} else if (selected == "Author") {
			if (jtooglebuttonBookSort.isSelected()) {
				fillDataToTable(bookModel.sortByAuthorASC());
			} else {
				fillDataToTable(bookModel.sortByAuthorDESC());
			}
		}

	}
//------------------------------------//

//Radio Setup
	private String getRadioSelected(ButtonGroup buttonGroup) {
		Enumeration<AbstractButton> buttons = buttonGroup.getElements();
		while (buttons.hasMoreElements()) {
			JRadioButton radioButton = (JRadioButton) buttons.nextElement();
			if (radioButton.isSelected()) {
				return radioButton.getText();
			}
		}
		return null;
	}

	// set delete, edit button enable
	public void jtableBook_mouseClicked(MouseEvent e) {
		jpanelBookButton.setVisible(true);
	}

	public void jtableDDC_mouseClicked(MouseEvent e) {
		jpanelDDCButton.setVisible(true);
	}

//------------------------------------//
	// =====Add New Book=====//

	// ADD button
	public void jbuttonAdd_actionPerformed(ActionEvent e) {
		clearScreen();
		JpanelAddBook2 jpanelAddBook2 = new JpanelAddBook2();
		jpanelShowInfo.add(jpanelAddBook2);
		jbuttonAddCancel.setVisible(true);
		jpanelBookButton.setVisible(false);
		jpanelDDCButton.setVisible(false);
	}

	// Add Cancel
	public void jbuttonAddCancel_actionPerformed(ActionEvent e) {
		clearScreen();
		initJFrame();
	}

	public void jmenuitemBookDetail_actionPerformed(ActionEvent e) {
		int selectedRow = jtableBook.getSelectedRow();
		int id = Integer.parseInt(jtableBook.getValueAt(selectedRow, 0).toString());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);
		JFrameBookDetail jFrameBookDetail = new JFrameBookDetail(data);
		jFrameBookDetail.setVisible(true);
	}

	public void jbuttonBookDetail_actionPerformed(ActionEvent e) {
		int selectedRow = jtableBook.getSelectedRow();
		int id = Integer.parseInt(jtableBook.getValueAt(selectedRow, 0).toString());
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);
		JFrameBookDetail jFrameBookDetail = new JFrameBookDetail(data);
		jFrameBookDetail.setVisible(true);
	}
//------------------------------------//

	// initjFrame
	private void initJFrame() {
		DDCModel ddcModel = new DDCModel();
		BookModel bookModel = new BookModel();
		fillDataToDDCTable(ddcModel.findAll());
		fillDataToTable(bookModel.findAll());
		jbuttonAddCancel.setVisible(false);
		jpanelBookButton.setVisible(false);
		jpanelDDCButton.setVisible(false);

	}

	// CLEARSCREEN
	private void clearScreen() {
		jpanelShowInfo.revalidate();
		jpanelShowInfo.removeAll();
	}

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
