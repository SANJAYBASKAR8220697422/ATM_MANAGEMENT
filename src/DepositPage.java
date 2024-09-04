import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositPage extends JFrame {
    private Account account;
    private ATM atm;

    public DepositPage(Account account, ATM atm) {
        this.account = account;
        this.atm = atm;
        initialize();
    }

    private void initialize() {
        setTitle("Deposit");
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

        JButton btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(140, 100, 120, 30);
        getContentPane().add(btnDeposit);

        btnDeposit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(txtAmount.getText());
                account.deposit(amount);
                atm.updateBalance(account.getAccountNumber(), account.getBalance());
                JOptionPane.showMessageDialog(null, "Deposit successful!");
                new MenuPage(account, atm);
                dispose();
            }
        });

        setVisible(true);
    }
}
