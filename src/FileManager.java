import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileManager {
    private static final String FILE_PATH = "accounts.dat";

    public static void saveAccounts(Map<String, Account> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<String, Account> loadAccounts() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (Map<String, Account>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new HashMap<>();
        }
    }
}
