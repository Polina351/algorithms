package home_work_3_exc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static home_work_3_exc.DataValidate.dataValidate;

public class LoginFrame extends JFrame implements ActionListener{
    Container container = getContentPane();
    JLabel userLabel = new JLabel("LOGIN");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel confirmPasswordLabel = new JLabel("CONFIRM  PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JPasswordField confirmPasswordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        setColor();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
        container.setBackground(Color.darkGray);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(20, 20, 100, 30);
        passwordLabel.setBounds(20, 75, 100, 30);
        confirmPasswordLabel.setBounds(20, 140, 140, 30);
        confirmPasswordLabel.setFont(new Font("Serif", Font.BOLD, 10));
        userTextField.setBounds(150, 20, 150, 30);
        passwordField.setBounds(150, 75, 150, 30);
        confirmPasswordField.setBounds(150, 140, 150, 30);
        showPassword.setBounds(185, 110, 150, 10);
        loginButton.setBounds(50, 200, 100, 30);
        resetButton.setBounds(180, 200, 100, 30);
    }
    public void setColor() {
        userLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        confirmPasswordLabel.setForeground(Color.WHITE);
        showPassword.setForeground(Color.WHITE);
        showPassword.setBackground(Color.darkGray);
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(confirmPasswordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(confirmPasswordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            String confPwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            confPwdText = confirmPasswordField.getText();
            if (dataValidate(userText, pwdText, confPwdText).getBool()) {
                JOptionPane.showMessageDialog(this, "       Logged in Successfully !");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, dataValidate
                        (userText, pwdText, confPwdText).getS());
            }
        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            confirmPasswordField.setText("");
            showPassword.setSelected(false);
            passwordField.setEchoChar('*');
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }
    }
}
