package demo;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import entities.DDC;
import models.DDCModel;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class JPanelEditDDC extends JPanel {
	private JTextField jtextFieldName;
	private JTextField jtextFieldNumericCode;
	private JButton jbuttonSave;
	private Map<String, Object> data = new HashMap<String, Object>();
	private DDC ddc;
	private JButton jbuttonCancel;

	/**
	 * Create the panel.
	 */
	public JPanelEditDDC() {
		setBorder(new TitledBorder(null, "DDC Edit", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.PAGE_AXIS));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		JPanel panel_2 = new JPanel();
		panel_3.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_4);

		JLabel lblNewLabel = new JLabel("Name");
		panel_4.add(lblNewLabel);

		jtextFieldName = new JTextField();
		panel_4.add(jtextFieldName);
		jtextFieldName.setColumns(18);

		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_6.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel_2.add(panel_6);

		JLabel lblNewLabel_1 = new JLabel("Numeric Code");
		panel_6.add(lblNewLabel_1);

		jtextFieldNumericCode = new JTextField();
		panel_6.add(jtextFieldNumericCode);
		jtextFieldNumericCode.setColumns(18);

		JPanel panel_10 = new JPanel();
		panel_3.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_5);

		jbuttonSave = new JButton("Save");
		jbuttonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonSave_actionPerformed(e);
			}
		});
		panel_5.add(jbuttonSave);

		jbuttonCancel = new JButton("Cancel");
		jbuttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbuttonCancel_actionPerformed(e);
			}
		});
		panel_5.add(jbuttonCancel);

		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));

	}

//Cancel button
	public void jbuttonCancel_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

//set data
	public JPanelEditDDC(Map<String, Object> data) {
		this();
		this.data = data;
		initJFrame();
	}

	private void initJFrame() {
		DDCModel ddcModel = new DDCModel();
		int id = Integer.parseInt(data.get("id").toString());
		ddc = ddcModel.find(id);
		jtextFieldName.setText(ddc.getGroup_name());
		jtextFieldNumericCode.setText(ddc.getNumeric_code());
	}

// Save change
	public void jbuttonSave_actionPerformed(ActionEvent e) {
		try {
			int id = Integer.parseInt(data.get("id").toString());
			DDCModel ddcModel = new DDCModel();
			DDC ddc = ddcModel.find(id);
			ddc.setGroup_name(jtextFieldName.getText().trim());
			ddc.setNumeric_code(jtextFieldNumericCode.getText().trim());

			if (ddcModel.edit(ddc)) {
				JOptionPane.showMessageDialog(null, "Done");

			} else {
				JOptionPane.showMessageDialog(null, "Bad");

			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		}
	}
}
