package component;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelLogout extends JPanel {

    public PanelLogout() {
        initComponents();
    }

    private void initComponents() {
        // Sử dụng sự kiện MouseListener để bắt sự kiện click vào PanelLogout
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Xử lý khi click vào PanelLogout, ví dụ: chuyển về màn hình đăng nhập
                PanelLogin loginPanel = new PanelLogin(); // Tạo mới PanelLogin
                JFrame mainFrame = (JFrame) SwingUtilities.getRoot(PanelLogout.this); // Lấy JFrame chứa PanelLogout
                mainFrame.setContentPane(loginPanel); // Đặt nội dung JFrame thành PanelLogin
                mainFrame.pack(); // Cập nhật kích thước JFrame
            }
        });
    }
}
