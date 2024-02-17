import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public static boolean logIn() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the login:");
        String login = scanner.nextLine();

        System.out.println("Enter the password:");
        String password = scanner.nextLine();

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
    public static void register() throws SQLException {
//        String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
//        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
//        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//            connection.close();
//            return resultSet.next();
//        }
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
        String sql = "INSERT INTO users (name, surname, id, login, password) VALUES (?, ?, ?, ?, ?)";
        Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, surname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, id);
            preparedStatement.setString(4, login);
            preparedStatement.setString(5, password);
            preparedStatement.executeUpdate();

        }


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