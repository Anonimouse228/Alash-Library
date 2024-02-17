import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/newdata";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Na260206";
    private static final String ADMIN_PASSWORD = "admin123";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to PostgreSQL database!");

            Scanner scanner = new Scanner(System.in);

            boolean exit = true;

            while (exit) {
                System.out.println("Choose an option: ");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Add a book");
                System.out.println("4. Return a book");
                System.out.println("5. Take a book");
                System.out.println("6. Find a book by ISBN");
                System.out.println("7. Find a book");
                System.out.println("8. See transaction history");
                System.out.println("9. See last N transactions");
                System.out.println("10. (ADMIN COMMAND) See users");
                System.out.println("11. (ADMIN COMMAND) Delete user");
                System.out.println("12. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        // Login
                        System.out.println("Enter the login: ");
                        String login = scanner.nextLine();
                        System.out.println("Enter the password: ");
                        String password = scanner.nextLine();

                        if (authenticateUser(connection, login, password)) {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Login failed. Invalid credentials.");
                        }
                        break;

                    case 2:
                        // Register
                        System.out.println("Enter the Name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter the Surname: ");
                        String surname = scanner.nextLine();
                        System.out.println("Enter the ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the login: ");
                        String registerLogin = scanner.nextLine();
                        System.out.println("Enter the password: ");
                        String registerPassword = scanner.nextLine();

                        registerUser(connection, name, surname, id, registerLogin, registerPassword);
                        System.out.println("Registration successful!");
                        break;
                    case 3:
                        System.out.println("you chose 3");
                        break;
                    case 4:
                        System.out.println("you chose 4");
                        break;
                    case 5:
                        System.out.println("you chose 5");
                        break;
                    case 6:
                        System.out.println("you chose 6 ");

                        break;
                    case 7:
                        System.out.println("you chose 7");
                        break;
                    case 8:
                        System.out.println("you chose 8");
                        break;
                    case 9:
                        System.out.println("you chose 9");
                        break;
                    case 10:
                        System.out.println("Enter admin password: ");
                        String adminPassword = scanner.nextLine();

                        if (ADMIN_PASSWORD.equals(adminPassword)) {
                            displayUsers(connection);
                        } else {
                            System.out.println("Incorrect admin password. Access denied.");
                        }
                        break;

                    case 11:
                        System.out.println("Enter admin password: ");
                        adminPassword = scanner.nextLine();

                        if (ADMIN_PASSWORD.equals(adminPassword)) {
                            System.out.println("Enter the login of the user to delete: ");
                            String userToDelete = scanner.nextLine();
                            deleteUser(connection, userToDelete);
                        } else {
                            System.out.println("Incorrect admin password. Access denied.");
                        }
                        break;
                    case 12:
                        exit = false;
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }

            scanner.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticateUser(Connection connection, String login, String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE login = ? AND password = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }

    private static void registerUser(Connection connection, String name, String surname, int id, String login, String password) throws SQLException {
        String sql = "INSERT INTO users (name, surname, id, login, password) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setInt(3, id);
            preparedStatement.setString(4, login);
            preparedStatement.setString(5, password);

            preparedStatement.executeUpdate();
        }
    }
    private static void displayUsers(Connection connection) {
        try {
            String sql = "SELECT * FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    System.out.println("----------------------------------");
                    System.out.println("User ID: " + resultSet.getInt("user_id"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Surname: " + resultSet.getString("surname"));
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Login: " + resultSet.getString("login"));
                    System.out.println("----------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteUser(Connection connection, String userToDelete) {
        try {
            String sql = "DELETE FROM users WHERE login = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, userToDelete);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("User deleted successfully!");
                } else {
                    System.out.println("User not found or deletion failed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
