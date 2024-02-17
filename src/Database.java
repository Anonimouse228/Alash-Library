import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Database {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/AlashLibrary";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "ali1230123";
    private static final String ADMIN_PASSWORD = "admin123";



    public static void start_database() {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to PostgreSQL database!");

            Scanner scanner = new Scanner(System.in);

            boolean exit = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//
//        private static boolean authenticateUser(Connection connection, String login, String password) throws SQLException {
//        String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, login);
//            preparedStatement.setString(2, password);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            return resultSet.next();
//        }
    }
    public static boolean logIn(String login, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            connection.close();
            return resultSet.next();
        }
    }
    public static boolean register(String surname, String lastname, String id, String login, String password) throws SQLException {
        String sql = "INSERT INTO users (name, surname, id, login, password) VALUES (?, ?, ?, ?, ?)";
        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        if (isLoginTaken(login) || isIdTaken(id)) {
            return false;
        }
        else {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, surname);
                preparedStatement.setString(2, lastname);
                preparedStatement.setString(3, id);
                preparedStatement.setString(4, login);
                preparedStatement.setString(5, password);
                connection.close();
                preparedStatement.executeUpdate();
            }
        }
        return true;
    }

    public static boolean addBook (String name, String author, String genre, String isbn, String language) throws SQLException {
        String sql = "INSERT INTO books (name, author, genre, isbn, language) VALUES (?, ?, ?, ?, ?)";
        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        if (isIsbnTaken(isbn)) {
            return false;
        }
        else {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, author);
                preparedStatement.setString(3, genre);
                preparedStatement.setString(4, isbn);
                preparedStatement.setString(5, language);
                preparedStatement.executeUpdate();
                connection.close();
            }
        }
        return true;

    }





    private static void addTransaction(String name, LocalDateTime timestamp, String action, String language) throws SQLException {

    }


    private static boolean isLoginTaken(String login) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE login = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // User exists if count > 0
                }
            }
        }
        return false; // Login is not taken, so return false
    }
    private static boolean isIdTaken(String id) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // User exists if count > 0, so return false
                }
            }
        }
        return false; // ID is not taken so return false
    }
    private static boolean isIsbnTaken(String isbn) throws SQLException {
        String query = "SELECT COUNT(*) FROM books WHERE isbn = ?";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, isbn);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // isbn taken if count > 0
                }
            }
        }
        return false; // isbn is not taken, so return false
    }




//
//    private static void registerUser(Connection connection, String name, String surname, int id, String login, String password) throws SQLException {
//        String sql = "INSERT INTO users (name, surname, id, login, password) VALUES (?, ?, ?, ?, ?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//            preparedStatement.setString(1, name);
//            preparedStatement.setString(2, surname);
//            preparedStatement.setInt(3, id);
//            preparedStatement.setString(4, login);
//            preparedStatement.setString(5, password);
//
//            preparedStatement.executeUpdate();
//        }
//    }
//    private static void displayUsers(Connection connection) {
//        try {
//            String sql = "SELECT * FROM users";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                 ResultSet resultSet = preparedStatement.executeQuery()) {
//
//                while (resultSet.next()) {
//                    System.out.println("----------------------------------");
//                    System.out.println("User ID: " + resultSet.getInt("user_id"));
//                    System.out.println("Name: " + resultSet.getString("name"));
//                    System.out.println("Surname: " + resultSet.getString("surname"));
//                    System.out.println("ID: " + resultSet.getInt("id"));
//                    System.out.println("Login: " + resultSet.getString("login"));
//                    System.out.println("----------------------------------");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private static void deleteUser(Connection connection, String userToDelete) {
//        try {
//            String sql = "DELETE FROM users WHERE login = ?";
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                preparedStatement.setString(1, userToDelete);
//
//                int rowsAffected = preparedStatement.executeUpdate();
//
//                if (rowsAffected > 0) {
//                    System.out.println("User deleted successfully!");
//                } else {
//                    System.out.println("User not found or deletion failed.");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}