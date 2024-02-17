import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class User {
    public static Object isAdmin;
    private final String surname;
    private String lastname;
    private final String id;
    private final String login;
    private final String password;

    private boolean isAdmin;

    public User(String surname, String lastname, String id, String login, String password) {
        this.lastname = lastname;
        this.login = login;
        this.surname = surname;
        this.lastname = lastname;
        this.password = hashPassword(password);
        this.id = id;
        this.isAdmin = false;
    }

    public String getPassword() {
        return password;
    }
    public Boolean compare(String userPassword) {
        return Objects.equals(password, hashPassword(userPassword));
    }

    public static boolean isAdmin(String login, String password) {
        return Objects.equals(login, "admin") & Objects.equals(password, "a6c79a27049109e472b246b5dfbe08aedff1e9e2259597e54032dbad4958d4ad");
    }

    public static String hashPassword(String password) {
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
        System.out.println("Surname: '" + surname + "'" +
                ", Author: '" + lastname + "'" +
                ", Login '" + login + "'");
    }
    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
//woefjqwifhqwifjqwiefj


