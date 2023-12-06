package form;

import connection.DatabaseConnection;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChangePasswordUI extends JPanel {

    private JTextField UsernameField;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;
    private JButton changePasswordButton;

    public ChangePasswordUI() {
        setPreferredSize(new Dimension(300, 200));
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        UsernameField = new JTextField(15);
        oldPasswordField = new JPasswordField(15);
        newPasswordField = new JPasswordField(15);
        confirmPasswordField = new JPasswordField(15);
        changePasswordButton = new JButton("Change password");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Username:"), gbc);
        gbc.gridx = 1;
        add(UsernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Old password:"), gbc);
        gbc.gridx = 1;
        add(oldPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("New password:"), gbc);
        gbc.gridx = 1;
        add(newPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Re-enter new password:"), gbc);
        gbc.gridx = 1;
        add(confirmPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(changePasswordButton, gbc);

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = UsernameField.getText();
                String oldPassword = new String(oldPasswordField.getPassword());
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(ChangePasswordUI.this, "The new password and the confirmed new password do not match.");
                    return;
                }

                boolean result = changePassword(Username, oldPassword, newPassword);

                if (result) {
                    JOptionPane.showMessageDialog(ChangePasswordUI.this, "Password changed successfully.");
                } else {
                    JOptionPane.showMessageDialog(ChangePasswordUI.this, "Password change failed.");
                }
            }
        });
    }

    private boolean changePassword(String Username, String oldPassword, String newPassword) {
        try {
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            dbConnection.connectToDatabase();
            Connection connection = dbConnection.getConnection();

            String selectPasswordQuery = "SELECT Password FROM user WHERE UserName = ?";
            PreparedStatement selectPasswordStatement = connection.prepareStatement(selectPasswordQuery);
            selectPasswordStatement.setString(1, Username);
            String hashedPassword = null;
            boolean userExists = false;

            if (selectPasswordStatement.execute()) {
                var resultSet = selectPasswordStatement.getResultSet();
                if (resultSet.next()) {
                    hashedPassword = resultSet.getString("Password");
                    userExists = true;
                }
            }

            if (!userExists) {
                JOptionPane.showMessageDialog(this, "The username does not exist.");
                return false;
            }

            if (!BCrypt.checkpw(oldPassword, hashedPassword)) {
                JOptionPane.showMessageDialog(this, "The old password is incorrect.");
                return false;
            }

            String updatePasswordQuery = "UPDATE user SET Password = ? WHERE UserName = ?";
            PreparedStatement updatePasswordStatement = connection.prepareStatement(updatePasswordQuery);

            String hashedNewPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

            updatePasswordStatement.setString(1, hashedNewPassword);
            updatePasswordStatement.setString(2, Username);

            int rowsUpdated = updatePasswordStatement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Change password");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new ChangePasswordUI());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
