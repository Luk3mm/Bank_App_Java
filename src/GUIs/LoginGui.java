package GUIs;

import javax.swing.*;
import java.awt.*;

public class LoginGui extends BaseFrame{
    public LoginGui(){
        super("Light Bank Login");
    }

    @Override
    protected void addGuiComponents() {
        JLabel bankAppLabel = new JLabel("Light Bank Login");
        bankAppLabel.setBounds(0, 20, super.getWidth(), 40);
        bankAppLabel.setFont(new Font("Arial", Font.BOLD, 32));
        bankAppLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(bankAppLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 120, getWidth() - 30, 24);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(usernameLabel);

        //username field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(20, 160, getWidth() - 50, 40);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 28));
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 250, getWidth() - 50, 24);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(passwordLabel);

        //Password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 290, getWidth() - 50, 40);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 28));
        add(passwordField);

        //Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 400, getWidth() - 50, 40);
        loginButton.setFont(new Font("Arial", Font.BOLD, 28));
        add(loginButton);

        //Register
        JLabel registerLabel = new JLabel("<html>Don't have an Account? <a href=\"#\">Register Here</a></html>");
        registerLabel.setBounds(0, 460, getWidth() - 10, 30);
        registerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);
    }
}
