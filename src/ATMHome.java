import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ATMHome extends JFrame {
    private ATM atm;

    public ATMHome() {
        atm = new ATM();
        initialize();
    }

    private void initialize() {
        setTitle("ATM System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel lblAccountNumber = new JLabel("Account Number:");
        lblAccountNumber.setBounds(50, 50, 120, 25);
        getContentPane().add(lblAccountNumber);

        JTextField txtAccountNumber = new JTextField();
        txtAccountNumber.setBounds(180, 50, 150, 25);
        getContentPane().add(txtAccountNumber);

        JLabel lblPin = new JLabel("PIN:");
        lblPin.setBounds(50, 90, 120, 25);
        getContentPane().add(lblPin);

        JTextField txtPin = new JTextField();
        txtPin.setBounds(180, 90, 150, 25);
        getContentPane().add(txtPin);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(140, 130, 120, 30);
        getContentPane().add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String accountNumber = txtAccountNumber.getText();
                String pin = txtPin.getText();
                if (atm.validateLogin(accountNumber, pin)) {
                    Account account = atm.getAccount(accountNumber);
                    new MenuPage(account, atm);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid account number or PIN.");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ATMHome();
    }
}
