package GUIs;

import dbobjects.User;

import javax.swing.*;

public class BankAppDialog extends JDialog {
    private User user;
    private BankAppGui bankAppGui;

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
}
