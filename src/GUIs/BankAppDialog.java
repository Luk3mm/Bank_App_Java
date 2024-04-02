package GUIs;

import dbobjects.User;

import javax.swing.*;
import java.awt.*;

public class BankAppDialog extends JDialog {
    private User user;
    private BankAppGui bankAppGui;
    private JLabel balanceLabel, enterAmountLabel, enterUserLabel;
    private JTextField enterAmountField, enterUserField;
    private JButton actionButton;

    public BankAppDialog(BankAppGui bankAppGui, User user){
        setSize(400, 400);

        setModal(true);

        setLocationRelativeTo(bankAppGui);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setResizable(false);

        setLayout(null);

        this.bankAppGui = bankAppGui;
        this.user = user;
    }

    public void addCurrentBalanceAndAmount(){
        balanceLabel = new JLabel("Balance: $" + user.getCurrentBalance());
        balanceLabel.setBounds(0, 10, getWidth() - 20, 20);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 16));
        balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(balanceLabel);

        enterAmountLabel = new JLabel("Enter Amount:");
        enterAmountLabel.setBounds(0, 50, getWidth() - 20, 20);
        enterAmountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        enterAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterAmountLabel);

        enterAmountField = new JTextField();
        enterAmountField.setBounds(15, 80, getWidth() - 50, 40);
        enterAmountField.setFont(new Font("Arial", Font.BOLD, 20));
        enterAmountField.setHorizontalAlignment(SwingConstants.RIGHT);
        add(enterAmountField);
    }

    public void addActionButton(String actionButtonType){
        actionButton = new JButton(actionButtonType);
        actionButton.setBounds(15, 300, getWidth() - 50, 40);
        actionButton.setFont(new Font("Arial", Font.BOLD, 20));
        add(actionButton);
    }

    public void addUserField(){
        enterUserLabel = new JLabel("Enter User:");
        enterUserLabel.setBounds(0, 160, getWidth() - 20, 20);
        enterUserLabel.setFont(new Font("Arial", Font.BOLD, 16));
        enterUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterUserLabel);

        enterUserField = new JTextField();
        enterUserField.setBounds(15, 190, getWidth() - 50, 20);
        enterUserField.setFont(new Font("Arial", Font.BOLD, 20));
        add(enterUserField);
    }
}
