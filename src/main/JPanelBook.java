package main;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import entities.Book;
import entities.Issued;
import models.BookModel;
import models.IssuedModel;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class JPanelBook extends JPanel {
	private final int itemsPerPage = 20;

	private int maxPageIndex;

	private int currentPageIndex = 1;

	private String[] columnNames = { "Call number", "ISBN number", "Title", "Author" };

	private DefaultTableModel model = new DefaultTableModel(null, columnNames) {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	private DefaultTableModel modelSelected = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};

	private final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);

	private boolean checkin = true;
	private JTextField jtextKeyWord;
	private JTable jtableContent;
	private JTable jtableSelected;
	private JTextField jtextFieldPage;
	private JButton jbtnFirst;
	private JButton jbtnPrev;
	private JLabel jlabelPage;
	private JButton jbtnNext;
	private JButton jbtnLast;
	private JPopupMenu popupMenu;
	private JPopupMenu popupMenuDelete;
	private JCheckBox jcheckboxCheckInOut;
	private JButton jbtnSave;
	private JLabel jlabelKeyword;

	/**
	 * Create the panel.
	 */
	public JPanelBook() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_1);

		jlabelKeyword = new JLabel("Keyword (ISBN number/Title/Author)");
		panel_1.add(jlabelKeyword);

		jtextKeyWord = new JTextField();
		panel_1.add(jtextKeyWord);
		jtextKeyWord.setColumns(25);

		JButton jbtnSearchAll = new JButton("Search");
		panel_1.add(jbtnSearchAll);

		jcheckboxCheckInOut = new JCheckBox("Check In");
		jcheckboxCheckInOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jcheckboxCheckInOut.setSelected(true);
		jcheckboxCheckInOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcheckboxCheckInOut_actionPerformed(e);
			}
		});

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setHgap(20);
		panel_1.add(panel_3);
		panel_1.add(jcheckboxCheckInOut);
		jbtnSearchAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSearchAll_actionPerformed(e);
			}
		});

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		popupMenu = new JPopupMenu();
		panel.add(popupMenu);

		JMenuItem jmenuItemSelect = new JMenuItem("Select");
		jmenuItemSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmenuItemSelect_actionPerformed(e);
			}
		});
		popupMenu.add(jmenuItemSelect);

		JMenuItem jmenuItemDetail = new JMenuItem("Detail");
		jmenuItemDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmenuItemDetail_actionPerformed(e);
			}
		});
		popupMenu.add(jmenuItemDetail);

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);

		jtableContent = new JTable();
		jtableContent.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(jtableContent);

		JPanel panel_7 = new JPanel();
		add(panel_7);

		jbtnFirst = new JButton("|<");
		jbtnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnfirst_actionPerformed(e);
			}
		});
		panel_7.add(jbtnFirst);

		jbtnPrev = new JButton("<");
		jbtnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnprev_actionPerformed(e);
			}
		});
		panel_7.add(jbtnPrev);

		jtextFieldPage = new JTextField();
		jtextFieldPage.setText("1");
		panel_7.add(jtextFieldPage);
		jtextFieldPage.setColumns(10);

		jlabelPage = new JLabel("/0");
		panel_7.add(jlabelPage);

		jbtnNext = new JButton(">");
		jbtnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnNext_actionPerformed(e);
			}
		});
		panel_7.add(jbtnNext);

		jbtnLast = new JButton(">|");
		jbtnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnLast_actionPerformed(e);
			}
		});
		panel_7.add(jbtnLast);

		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel_8);

		JLabel lblNewLabel = new JLabel("LIST OF SELECTED BOOKS");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel.setAlignmentY(1.0f);
		panel_8.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(187, 214, 254));
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 10));

		jbtnSave = new JButton("Check In ");
		jbtnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnSave_actionPerformed(e);
			}
		});
		jbtnSave.setAlignmentY(0.0f);
		jbtnSave.setAlignmentX(1.0f);
		jbtnSave.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		jbtnSave.setHorizontalTextPosition(SwingConstants.CENTER);
		jbtnSave.setPreferredSize(new Dimension(100, 29));
		panel_2.add(jbtnSave);

		JPanel panel_4 = new JPanel();
		add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		popupMenuDelete = new JPopupMenu();
		panel_4.add(popupMenuDelete);

		JMenuItem jmenuItemDelete = new JMenuItem("Delete");
		jmenuItemDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jmenuItemDelete_actionPerformed(e);
			}
		});
		popupMenuDelete.add(jmenuItemDelete);

		JScrollPane scrollPane_1 = new JScrollPane();

		jtableSelected = new JTable();
		scrollPane_1.setViewportView(jtableSelected);
		panel_4.add(scrollPane_1);

		JPanel panel_6 = new JPanel();
		add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		initJPanel();
	}

	private void initJPanel() {
//		jlabelKeyword.setText("Id ");
		jtableContent.setModel(model);
		listSelected();
		showBook();
//		listAll();
	}

	public void jbtnSearchAll_actionPerformed(ActionEvent e) {
		showBook();
	}

	private void showBook() {
		String keyword = jtextKeyWord.getText();

		if (!keyword.equals("")) {
			deleteList();
			search(keyword);
		} else {
			deleteList();
			listAll();
		}
	}

	private void deleteList() {
		model.setRowCount(0);
	}
//	private void listAll() {
//		DefaultTableModel model = new DefaultTableModel() {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
////		DefaultTableModel model = new DefaultTableModel();
//		model.addColumn("Call number");
//		model.addColumn("ISBN number");
//		model.addColumn("Title");
//		model.addColumn("Author");
//		model.addColumn("Action");
//		
//		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(JPanelBook.class.getResource("/resources/eye-24x24.png")).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
//		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(JPanelBook.class.getResource("/resources/pen-67x67.png")).getImage().getScaledInstance(24, 24, Image.SCALE_DEFAULT));
//		
//		ImageIcon[] images = {imageIcon1, imageIcon2};
//		
//		BookModel bookModel = new BookModel();
//		
//		for (Book book : bookModel.findAll()) {
//			model.addRow(new Object[] {
//				book.getCall_number(), book.getIsbn(), book.getTitle(), book.getAuthor_name(), images
//			});
//		}
//		jtableContent.setModel(model);
////		jtableContent.getTableHeader().setReorderingAllowed(false);
//		jtableContent.setRowHeight(35);
////		jtableContent.getColumnModel().getColumn(4).setCellRenderer(new ImageCellRender());
////		jtableContent.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
//		jtableContent.setEnabled(true);
//		jtableContent.setRowSelectionAllowed(true);
//		jtableContent.setColumnSelectionAllowed(true);
//	}

	private void listAll() {
//		jtableContent.setModel(model);
		BookModel bookModel = new BookModel();
		jtableContent.setRowSorter(sorter);

		for (Book book : bookModel.findAll()) {
			if (checkin) {
				if (book.isDisplay() && book.isIssue_status()) {
					model.addRow(new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(),
							book.getAuthor_name() });
				}
			} else {
				if (book.isDisplay() && !book.isIssue_status()) {
					model.addRow(new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(),
							book.getAuthor_name() });
				}
			}
		}

		int rowCount = model.getRowCount();
		int v = rowCount % itemsPerPage == 0 ? 0 : 1;
		maxPageIndex = rowCount / itemsPerPage + v;
		initFilterAndButton();
		jlabelPage.setText(String.format("/ %d", maxPageIndex));
		jtableContent.setComponentPopupMenu(popupMenu);

	}

	private void search(String keyword) {
//		jtableContent.setModel(model);
		BookModel bookModel = new BookModel();
		jtableContent.setRowSorter(sorter);
		
		for (Book book : bookModel.find(keyword)) {
			if (checkin) {
				if (book.isDisplay() && book.isIssue_status()) {
					model.addRow(new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(),
							book.getAuthor_name() });
				}
			} else {
				if (book.isDisplay() && !book.isIssue_status()) {
					model.addRow(new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(),
							book.getAuthor_name() });
				}
			}
		}
//		if (checkin) {
//				if (book.isDisplay() && book.isIssue_status()) {
//					model.addRow(new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(),
//							book.getAuthor_name() });
//				}
//			IssuedModel issuedModel = new IssuedModel();
//			for (Issued issued : issuedModel.findIssued_Idemployee(Integer.parseInt(keyword.trim()))) {
////					System.out.println(issued.getId_book());
//				Book book = bookModel.findBook_Issued_Idbook(issued.getId_book());
//				model.addRow(
//						new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(), book.getAuthor_name() });
//			}
//
//		} else {
//			for (Book book : bookModel.find(keyword)) {
//				if (book.isDisplay() && !book.isIssue_status()) {
//					model.addRow(new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(),
//							book.getAuthor_name() });
//				}
//			}
//		}

		int rowCount = model.getRowCount();
		int v = rowCount % itemsPerPage == 0 ? 0 : 1;
		maxPageIndex = rowCount / itemsPerPage + v;
		initFilterAndButton();
		jlabelPage.setText(String.format("/ %d", maxPageIndex));
		jtableContent.setComponentPopupMenu(popupMenu);
//		DefaultTableModel model = new DefaultTableModel() {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
//		model.addColumn("Call number");
//		model.addColumn("ISBN number");
//		model.addColumn("Title");
//		model.addColumn("Author");
//		model.addColumn("Action");
//		
//		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(JPanelBook.class.getResource("/resources/eye-24x24.png")).getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT));
//		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(JPanelBook.class.getResource("/resources/pen-67x67.png")).getImage().getScaledInstance(12, 12, Image.SCALE_DEFAULT));
//		
//		ImageIcon[] images = {imageIcon1, imageIcon2};
//		
//		BookModel bookModel = new BookModel();
//		
//		for (Book book : bookModel.find(keyword)) {
//			model.addRow(new Object[] {
//				book.getCall_number(), book.getIsbn(), book.getTitle(), book.getAuthor_name(), images
//			});
//		}
//		jtableContent.setModel(model);
//		jtableContent.getTableHeader().setReorderingAllowed(false);
//		jtableContent.setRowHeight(20);
//		jtableContent.getColumnModel().getColumn(4).setCellRenderer(new ImageCellRender());
//		jtableContent.setDefaultRenderer(Object.class, new CustomTableCellRenderer());
	}

//	private class ImageCellRender extends DefaultTableCellRenderer {
//		public ImageCellRender() {
//            setOpaque(true);
//        }
//		@Override
//		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
//				int row, int column) {
//			JPanel panel = new JPanel();
//	        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
//	        if (row % 2 == 0) {
//	            panel.setBackground(Color.LIGHT_GRAY);
//	        } else {
//	            panel.setBackground(Color.WHITE);
//	        }
//	        ImageIcon[] icons = (ImageIcon[]) value;
//	        for (ImageIcon icon : icons) {
//                JLabel label = new JLabel(icon);
//                panel.add(label);
//            }
//			return panel;
//		}
//	}
//	
//	class CustomTableCellRenderer extends DefaultTableCellRenderer {
//	    @Override
//	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//	        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//
//	        boolean isEvenRow = (row % 2 == 0);
//
//	        if (isEvenRow) {
//	            cell.setBackground(Color.LIGHT_GRAY);
//	        } else {
//	            cell.setBackground(Color.WHITE);
//	        }
//	        return cell;
//	    }
//	}

	public void jbtnfirst_actionPerformed(ActionEvent e) {
		currentPageIndex = 1;
		initFilterAndButton();
	}

	public void jbtnprev_actionPerformed(ActionEvent e) {
		currentPageIndex -= 1;
		initFilterAndButton();
	}

	public void jbtnNext_actionPerformed(ActionEvent e) {
		currentPageIndex += 1;
		initFilterAndButton();
	}

	public void jbtnLast_actionPerformed(ActionEvent e) {
		currentPageIndex = maxPageIndex;
		initFilterAndButton();
	}

	public void field_actionPerformed(ActionEvent arg0) {
		try {
			int v = Integer.parseInt(jtextFieldPage.getText());
			if (v > 0 && v <= maxPageIndex) {
				currentPageIndex = v;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		initFilterAndButton();
	}

	private void initFilterAndButton() {
		sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
			@Override
			public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
				int ti = currentPageIndex - 1;
				int ei = entry.getIdentifier();
				return ti * itemsPerPage <= ei && ei < ti * itemsPerPage + itemsPerPage;
			}

		});
		jbtnFirst.setEnabled(currentPageIndex > 1);
		jbtnPrev.setEnabled(currentPageIndex > 1);
		jbtnNext.setEnabled(currentPageIndex < maxPageIndex);
		jbtnLast.setEnabled(currentPageIndex < maxPageIndex);
		jtextFieldPage.setText(Integer.toString(currentPageIndex));
	}

	public void jmenuItemSelect_actionPerformed(ActionEvent e) {
		if(jtableSelected.getRowCount() > 4 && !checkin) {
//			System.out.println("Da qua so sach duoc phep muon");
			JOptionPane.showMessageDialog(null, "You have exceeded the allowed number of books to borrow, which is less than 5");
		} else {
			int selectedRow = jtableContent.getSelectedRow();
			String ISBN = jtableContent.getValueAt(selectedRow, 1).toString();
			boolean flag = true;
			for (int i = 0; i < jtableSelected.getRowCount(); i++) {
				if (ISBN.equals(jtableSelected.getValueAt(i, 1))) {
					flag = false;
					JOptionPane.showMessageDialog(null, "The book has been selected");
					break;
				}
			}
			if (flag) {

				BookModel bookModel = new BookModel();
				Book book = bookModel.findISBN(ISBN);
				modelSelected.addRow(
						new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(), book.getAuthor_name() });
				jtableSelected.setModel(modelSelected);
//				for (Book book : bookModel.findISBN(ISBN)) {
//					modelSelected.addRow(
//							new Object[] { book.getCall_number(), book.getIsbn(), book.getTitle(), book.getAuthor_name() });
//							jtableSelected.setModel(modelSelected);
//				}
			}
		}
	}

	public void jmenuItemDetail_actionPerformed(ActionEvent e) {
		int selectedRow = jtableContent.getSelectedRow();
		String ISBN = jtableContent.getValueAt(selectedRow, 1).toString();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("isbn", ISBN);
		jFrameDetailViewBook jFrameDetailViewBook = new jFrameDetailViewBook(data);
		jFrameDetailViewBook.setLocationRelativeTo(null);
		jFrameDetailViewBook.setVisible(true);
	}

	private void listSelected() {

		modelSelected.addColumn("Call number");
		modelSelected.addColumn("ISBN number");
		modelSelected.addColumn("Title");
		modelSelected.addColumn("Author");

		jtableSelected.setModel(modelSelected);
		jtableSelected.setComponentPopupMenu(popupMenuDelete);
	}

	public void jmenuItemDelete_actionPerformed(ActionEvent e) {
		modelSelected.removeRow(jtableSelected.getSelectedRow());
		JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
	}

	public void jcheckboxCheckInOut_actionPerformed(ActionEvent e) {
		model.setRowCount(0);
		modelSelected.setRowCount(0);
		currentPageIndex = 1;
		if (jcheckboxCheckInOut.isSelected()) {
			jcheckboxCheckInOut.setText("Check In");
			jbtnSave.setText("Check In ");
			checkin = true;
//			jlabelKeyword.setText("Id ");
//			jbtnAll.setVisible(true);
			jtextKeyWord.setText("");
			showBook();
//			deleteList();
		} else {
			jcheckboxCheckInOut.setText("Check Out");
			jbtnSave.setText("Check Out");
			checkin = false;
//			jlabelKeyword.setText("Keyword ");
//			jbtnAll.setVisible(false);
			jtextKeyWord.setText("");
			showBook();
		}
	}

	public void jbtnSave_actionPerformed(ActionEvent e) {
//		String[] books = null;
//		for(int i=0; i < jtableSelected.getRowCount(); i++) {
//			System.out.println(jtableSelected.getValueAt(i, 1));
//			books[i] = jtableSelected.getValueAt(i, 1).toString();
//		}
		if (checkin) {
			Map<Integer, String> data_books = new HashMap<Integer, String>();
			data_books.put(0, jtextKeyWord.getText());
			data_books.put(0, "");
			for (int i = 1; i < jtableSelected.getRowCount()+1; i++) {
				data_books.put(i, jtableSelected.getValueAt(i-1, 1).toString());
			}
			jFrameCheckIn jFrameCheckIn = new jFrameCheckIn(data_books);
			jFrameCheckIn.setLocationRelativeTo(null);
			jFrameCheckIn.setVisible(true);
		} else {
			Map<Integer, String> data_books = new HashMap<Integer, String>();
			for (int i = 0; i < jtableSelected.getRowCount(); i++) {
//				System.out.println(jtableSelected.getValueAt(i, 1));
//				books[i] = jtableSelected.getValueAt(i, 1).toString();
				data_books.put(i, jtableSelected.getValueAt(i, 1).toString());
			}
			jFrameCheckOut jFrameCheckOut = new jFrameCheckOut(data_books);
			jFrameCheckOut.setLocationRelativeTo(null);
			jFrameCheckOut.setVisible(true);

		}
	}

//	public void jbtnAll_actionPerformed(ActionEvent e) {
//		modelSelected.setRowCount(0);
//
//		for (int i = 0; i < jtableContent.getRowCount(); i++) {
//			modelSelected.addRow(new Object[] { jtableContent.getValueAt(i, 0), jtableContent.getValueAt(i, 1),
//					jtableContent.getValueAt(i, 2), jtableContent.getValueAt(i, 3) });
//		}
//		jtableSelected.setModel(modelSelected);
//	}
}
