import GUIs.BankAppGui;
import GUIs.LoginGui;
import GUIs.RegisterGui;
import dbobjects.User;

import javax.swing.*;
import java.math.BigDecimal;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //new LoginGui().setVisible(true);
                //new RegisterGui().setVisible(true);
                new BankAppGui(
                        new User(1, "username", "password", new BigDecimal("20.00"))
                ).setVisible(true);
            }
        });
    }
}
