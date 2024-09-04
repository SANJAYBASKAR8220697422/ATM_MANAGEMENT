import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPage extends JFrame {
    private Account account;
    private ATM atm;

    public MenuPage(Account account, ATM atm) {
        this.account = account;
        this.atm = atm;
        initialize();
    }

    private void initialize() {
        setTitle("Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(140, 50, 120, 30);
        getContentPane().add(btnDeposit);

        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(140, 100, 120, 30);
        getContentPane().add(btnWithdraw);

        JButton btnCheckBalance = new JButton("Check Balance");
        btnCheckBalance.setBounds(140, 150, 120, 30);
        getContentPane().add(btnCheckBalance);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(140, 200, 120, 30);
        getContentPane().add(btnLogout);

        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DepositPage(account, atm);
                dispose();
            }
        });

        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new WithdrawPage(account, atm);
                dispose();
            }
        });

        btnCheckBalance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BalancePage(account, atm);
                dispose();
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ATMHome();
                dispose();
            }
        });

        setVisible(true);
    }
}
