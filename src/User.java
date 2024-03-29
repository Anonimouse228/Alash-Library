import javax.xml.crypto.Data;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class User {
    public final boolean isAdmin;
//    private final String surname;
//    private String lastname;
//    private final String id;
    private final String login;
    private final String password;



    public User(String login, String password, boolean isAdmin) {
//        this.lastname = lastname;
        this.login = login;
//        this.surname = surname;
//        this.lastname = lastname;
        this.password = hashPassword(password);
//        this.id = id;
        this.isAdmin = isAdmin;
    }

    public static void logIn() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the login: ");
        String login = scanner.nextLine();
        System.out.print("\nEnter the password: ");
        String password = scanner.nextLine();
        User user = new User(login, password, isAdmin(login, password));

        if (Database.logIn(login, hashPassword(password))) {
            System.out.println("You successfully authorised!");
            UI.menu(user);
        }
        else {
            System.out.println("Login or password is not correct");
            UI.start();
        }
        UI.menu(user);
    }

    public static boolean register() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter your lastname:");
        String lastname = scanner.nextLine();
        System.out.println("Enter your id:");
        String id = scanner.nextLine();
        System.out.println("Enter the login:");
        String login = scanner.nextLine();
        System.out.println("Enter the password:");
        String password = scanner.nextLine();

        if (Database.register(surname, lastname, id, login, hashPassword(password))) {
            System.out.println("You are successfully registered!");
        }
        else {
            System.out.println("This login is already taken or id already exists!");
            return false;
        }
        UI.menu(null);
        return true;
    }
    public static void showUsers(boolean isN) throws SQLException {
        if (!isN) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            Database.showUsers(N);
        }
        else Database.showUsers();
    }


    public String getPassword() {
        return password;
    }
    public Boolean compare(String userPassword) {
        return Objects.equals(password, hashPassword(userPassword));
    }

    private static boolean isAdmin(String login, String password) {
        return Objects.equals(login, "admin") & Objects.equals(password, "a6c79a27049109e472b246b5dfbe08aedff1e9e2259597e54032dbad4958d4ad");
    }
    public boolean isAdmin() {
        return Objects.equals(this.login, "admin") & Objects.equals(this.password, "a6c79a27049109e472b246b5dfbe08aedff1e9e2259597e54032dbad4958d4ad");
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }

    public void displayUserInfo() {
    }

//    public void displayUserInfo() {
//        System.out.println("Surname: '" + surname + "'" +
//                ", Author: '" + lastname + "'" +
//                ", Login '" + login + "'");
//    }


}
//woefjqwifhqwifjqwiefj


