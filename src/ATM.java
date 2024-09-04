import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<String, Account> accounts;
    private static final String FILE_NAME = "accounts.txt";

    public ATM() {
        accounts = new HashMap<>();
        loadAccounts();
    }

    public void createAccount(String accountNumber, String pin, double initialBalance) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new Account(accountNumber, pin, initialBalance));
            saveAccounts();
        }
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean validateLogin(String accountNumber, String pin) {
        Account account = accounts.get(accountNumber);
        return account != null && account.getPin().equals(pin);
    }

    public boolean updateBalance(String accountNumber, double newBalance) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setBalance(newBalance);
            saveAccounts();
            return true;
        }
        return false;
    }

    private void saveAccounts() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account account : accounts.values()) {
                writer.write(account.getAccountNumber() + "," +
                        account.getPin() + "," +
                        account.getBalance());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAccounts() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String accountNumber = parts[0];
                        String pin = parts[1];
                        double balance = Double.parseDouble(parts[2]);
                        accounts.put(accountNumber, new Account(accountNumber, pin, balance));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
