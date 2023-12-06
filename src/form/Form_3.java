/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import main.JPanelBook;
import main.JPanelListEmployee;

/**
 *
 * @author RAVEN
 */
public class Form_3 extends javax.swing.JPanel {

	/**
	 * Creates new form Form_1
	 */
	public Form_3() {
//        initComponents();
//    	jPanelBookManagement = new JpanelBookMagenement();
//      jPanelBookManagement.setPreferredSize(new java.awt.Dimension(960, 610));
//      add(jPanelBookManagement);       
		JPanelBook jpanelBook = new JPanelBook();
//		jpanelContent.add(jpanelBook);
//		jpanelBook.setVisible(true);
		jpanelBook.setPreferredSize(new java.awt.Dimension(960, 610));
		add(jpanelBook);
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
		jLabel1.setText("Form 3");

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
	// End of variables declaration//GEN-END:variables
}
