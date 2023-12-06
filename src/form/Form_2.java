/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import demo.JpanelBookMagenement;
import main.JPanelAddEmployee;
import main.JPanelBook;
import main.JPanelListEmployee;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Font;

/**
 *
 * @author RAVEN
 */
public class Form_2 extends javax.swing.JPanel {

	/**
	 * Creates new form Form_1
	 */
	public Form_2() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(panel);
		
		JButton btnNewButton = new JButton("List");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setIcon(new ImageIcon(Form_2.class.getResource("/resources/employeelist.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JButton btnNewButton_1 = new JButton("New button");
//				panel.add(btnNewButton_1);
//				JPanelListEmployee jPanelListEmployee = new JPanelListEmployee();
//				jPanelListEmployee.setPreferredSize(new java.awt.Dimension(960, 610));
//				add(jPanelListEmployee);
				clearScreen();
				JPanelListEmployee jPanelListEmployee = new JPanelListEmployee();
				jpanelContent.add(jPanelListEmployee);
				jPanelListEmployee.setVisible(true);
				jPanelListEmployee.setPreferredSize(new java.awt.Dimension(960, 610));
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setIcon(new ImageIcon(Form_2.class.getResource("/resources/Add.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearScreen();
				JPanelAddEmployee jPanelAddEmployee = new JPanelAddEmployee();
				jpanelContent.add(jPanelAddEmployee);
				jPanelAddEmployee.setVisible(true);
				jPanelAddEmployee.setPreferredSize(new java.awt.Dimension(950, 600));
			}
		});
		panel.add(btnNewButton_1);
		
		jpanelContent = new JPanel();
		add(jpanelContent);
		
		
		
		clearScreen();
		JPanelListEmployee jPanelListEmployee = new JPanelListEmployee();
		jpanelContent.add(jPanelListEmployee);
		jPanelListEmployee.setVisible(true);
		jPanelListEmployee.setPreferredSize(new java.awt.Dimension(950, 600));
	}
	
	private void clearScreen() {
		jpanelContent.removeAll();
		jpanelContent.revalidate();
	}
	
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();

		setBackground(new java.awt.Color(242, 242, 242));

		jLabel1.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(106, 106, 106));
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Form 2");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addGap(128, 128, 128).addComponent(jLabel1,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGap(125, 125, 125)));
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel jLabel1;
	private JPanel jpanelContent;
	// End of variables declaration//GEN-END:variables
}
