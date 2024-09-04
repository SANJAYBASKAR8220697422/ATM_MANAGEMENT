import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawPage extends JFrame {
    private Account account;
    private ATM atm;

    public WithdrawPage(Account account, ATM atm) {
        this.account = account;
        this.atm = atm;
        initialize();
    }

    private void initialize() {
        setTitle("Withdraw");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblAmount = new JLabel("Enter Amount:");
        lblAmount.setBounds(50, 50, 120, 25);
        getContentPane().add(lblAmount);

        JTextField txtAmount = new JTextField();
        txtAmount.setBounds(180, 50, 150, 25);
        getContentPane().add(txtAmount);
        txtAmount.setColumns(10);

        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBounds(140, 100, 120, 30);
        getContentPane().add(btnWithdraw);

        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(txtAmount.getText());
                if (account.withdraw(amount)) {
                    atm.updateBalance(account.getAccountNumber(), account.getBalance());
                    JOptionPane.showMessageDialog(null, "Withdrawal successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient funds.");
                }
                new MenuPage(account, atm);
                dispose();
            }
        });

        setVisible(true);
    }
}
