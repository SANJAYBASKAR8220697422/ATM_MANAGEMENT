import javax.swing.*;

public class BalancePage extends JFrame {
    private Account account;
    private ATM atm;

    public BalancePage(Account account, ATM atm) {
        this.account = account;
        this.atm = atm;
        initialize();
    }

    private void initialize() {
        setTitle("Check Balance");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblBalance = new JLabel("Current Balance:");
        lblBalance.setBounds(50, 50, 120, 25);
        getContentPane().add(lblBalance);

        JTextField txtBalance = new JTextField();
        txtBalance.setBounds(180, 50, 150, 25);
        txtBalance.setText(String.valueOf(account.getBalance()));
        txtBalance.setEditable(false);
        getContentPane().add(txtBalance);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(140, 100, 120, 30);
        getContentPane().add(btnBack);

        btnBack.addActionListener(e -> {
            new MenuPage(account, atm);
            dispose();
        });

        setVisible(true);
    }
}
