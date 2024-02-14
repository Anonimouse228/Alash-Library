package Secrets;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class User {
    private final String surname;
    private String lastname;
    private final String login;
    private final String password;
    private boolean isAdmin;

    public User(String surname, String lastname, String login, String password) {
        this.lastname = lastname;
        this.login = login;
        this.surname = surname;
        this.lastname = lastname;
        this.password = hashPassword(password);
        this.isAdmin = false;
    }

    public String getPassword() {
        return password;
    }
    public Boolean compare(String userPassword) {
        return Objects.equals(password, hashPassword(userPassword));
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



