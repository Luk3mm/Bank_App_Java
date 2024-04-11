package GUIs;

import dbobjects.DbJDBC;
import dbobjects.Transaction;
import dbobjects.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class BankAppDialog extends JDialog implements ActionListener {
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
        enterAmountField.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterAmountField);
    }

    public void addActionButton(String actionButtonType){
        actionButton = new JButton(actionButtonType);
        actionButton.setBounds(15, 300, getWidth() - 50, 40);
        actionButton.setFont(new Font("Arial", Font.BOLD, 20));
        actionButton.addActionListener(this);
        add(actionButton);
    }

    public void addUserField(){
        enterUserLabel = new JLabel("Enter User:");
        enterUserLabel.setBounds(0, 160, getWidth() - 20, 20);
        enterUserLabel.setFont(new Font("Arial", Font.BOLD, 16));
        enterUserLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterUserLabel);

        enterUserField = new JTextField();
        enterUserField.setBounds(15, 190, getWidth() - 50, 30);
        enterUserField.setFont(new Font("Arial", Font.BOLD, 20));
        enterUserField.setHorizontalAlignment(SwingConstants.CENTER);
        add(enterUserField);
    }

    private void handleTransaction(String transactionType, float amountVal){
        Transaction transaction;

        if(transactionType.equalsIgnoreCase("Deposit")){
            user.setCurrentBalance(user.getCurrentBalance().add(new BigDecimal(amountVal)));

            transaction = new Transaction(user.getId(), transactionType, new BigDecimal(amountVal), null);
        }
        else{
            user.setCurrentBalance(user.getCurrentBalance().subtract(new BigDecimal(amountVal)));

            transaction = new Transaction(user.getId(), transactionType, new BigDecimal(-amountVal), null);
        }

        if(DbJDBC.addTransactionToDatabase(transaction) && DbJDBC.updateCurrentBalance(user)){
            JOptionPane.showMessageDialog(this, transactionType + " Successfully!");
            resetFieldsUpdateCurrentBalance();
        }
        else{
            JOptionPane.showMessageDialog(this, transactionType + " Failed...");
        }
    }

    private void resetFieldsUpdateCurrentBalance(){
        enterAmountField.setText("");

        if(enterUserField != null){
            enterUserField.setText("");
        }

        balanceLabel.setText("Balance: $" + user.getCurrentBalance());

        bankAppGui.getCurrentBalanceField().setText("$" + user.getCurrentBalance());
    }

    private void handleTransfer(User user, String transferredUser, float amount){
        if(DbJDBC.transfer(user, transferredUser, amount)){
            JOptionPane.showMessageDialog(this, "Transfer Success!");
            resetFieldsUpdateCurrentBalance();
        }
        else{
            JOptionPane.showMessageDialog(this, "Transfer Failed...");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonPressed = e.getActionCommand();

        float amountVal = Float.parseFloat(enterAmountField.getText());

        if(buttonPressed.equalsIgnoreCase("Deposit")){
            handleTransaction(buttonPressed, amountVal);
        }
        else{
            int result = user.getCurrentBalance().compareTo(BigDecimal.valueOf(amountVal));

            if(result < 0){
                JOptionPane.showMessageDialog(this, "Error: Input value is more than current balance!");
                return;
            }

            if(buttonPressed.equalsIgnoreCase("Withdraw")){
                handleTransaction(buttonPressed, amountVal);
            }
            else{
                String transferredUser = enterUserField.getText();

                handleTransfer(user, transferredUser, amountVal);
            }
        }
    }
}
