package form;

import demo.JFrameMain;
import demo.JpanelBookMagenement;
import java.awt.*;

public class Form_1 extends javax.swing.JPanel {

    private JpanelBookMagenement jPanelBookManagement; // Thêm một biến thể hiện của JPanelBookMagenement

    public Form_1() {
        initComponents();
        jPanelBookManagement = new JpanelBookMagenement();
        jPanelBookManagement.setPreferredSize(new java.awt.Dimension(970, 620));
        add(jPanelBookManagement);       
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
    }
    
}

