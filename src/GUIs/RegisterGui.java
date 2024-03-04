package GUIs;

import javax.swing.*;
import java.awt.*;

public class RegisterGui extends BaseFrame{
    public RegisterGui(){
        super("Light Bank Register");
    }

    @Override
    protected void addGuiComponents() {
        JLabel bankAppLabel = new JLabel("Bank Register");
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
        passwordLabel.setBounds(20, 220, getWidth() - 50, 24);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(passwordLabel);

        //Password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 260, getWidth() - 50, 40);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 28));
        add(passwordField);

        //repassword label
        JLabel rePasswordLabel = new JLabel("Re-Type Password: ");
        rePasswordLabel.setBounds(20, 320, getWidth() - 50, 40);
        rePasswordLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(rePasswordLabel);

        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(20, 360, getWidth() - 50, 40);
        rePasswordField.setFont(new Font("Arial", Font.PLAIN, 28));
        add(rePasswordField);

        //register Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 420, getWidth() - 50, 40);
        registerButton.setFont(new Font("Arial", Font.BOLD, 28));
        add(registerButton);

        //loginlabel
        JLabel loginLabel = new JLabel("<html>Have an Account? <a href=\"#\">Sign in Here</a></html>");
        loginLabel.setBounds(0, 480, getWidth() - 10, 30);
        loginLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(loginLabel);
    }
}
