import java.sql.SQLException;
import java.util.Scanner;

public class UI {
    public static void menu() throws SQLException {  // The function that shows the menu
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        System.out.println("Hello! Welcome to the greatest library on this computer!");

        logIn();

        while (exit) {
            System.out.println("""
                    What do you want to do?
                    1: Log in
                    2: Log up
                    3: Add a book
                    4: Return a book
                    5: Take a book
                    6: Find a book by a isbn\s
                    7: Find a book
                    8: See transaction history
                    9: See last N transactions:\s
                    10: (ADMIN COMMAND)See users
                    11: (ADMIN COMMAND)See users""");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    logIn();
                    System.out.println("----------------------------------------------------");
                    break;
                case "2":
                    register();
                    System.out.println("----------------------------------------------------");
                    break;
                case "3":
                    addBook();
                    System.out.println("----------------------------------------------------");
                    break;
                case "4":
                    System.out.println("----------------------------------------------------");
                    break;
                case "5":
                    System.out.println("----------------------------------------------------");
                    break;
                case "6":
                    System.out.println("----------------------------------------------------");
                    break;
                case "7":
                    System.out.println("----------------------------------------------------");
                    break;
                case "8":
                    System.out.println("----------------------------------------------------");
                    break;
                case "9":
                    System.out.println("----------------------------------------------------");
                    break;
                case "10":
                    System.out.println("----------------------------------------------------");
                    break;
                case "11":
                    exit = false;
                    System.out.println("----------------------------------------------------");
                default:
                    System.out.println("Invalid input! Please try again!");
                    System.out.println("----------------------------------------------------");
                    break;
            }
        }
    }

    public static boolean logIn() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the login:");
        String login = scanner.nextLine();

        System.out.println("Enter the password:");
        String password = scanner.nextLine();

        if (Database.logIn(login, User.hashPassword(password))) {
            System.out.println("You succesfully authorised!");

        }
        else System.out.println("Login or password is not correct");
        return User.isAdmin(login, User.hashPassword(password));

    }
    public static void register() throws SQLException {
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

        if (Database.register(surname, lastname, id, login, User.hashPassword(password))) {
            System.out.println("You are successfully registered!");
        }
        else System.out.println("This login is already taken or id already exists3!");
    }

    public static void addBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the book's name:");
        String name = scanner.nextLine();
        System.out.println("Enter the name of the author of the book:");
        String author = scanner.nextLine();
        System.out.println("Enter the book's genre:");
        String genre = scanner.nextLine();
        System.out.println("Enter the book's ISBN:");
        String isbn = scanner.nextLine();
        System.out.println("Enter the book's language");
        String language = scanner.nextLine();

        if (Database.addBook(name, author, genre, isbn, language)) {
            System.out.println("Your book is succesfully added!");
        }
        else System.out.println("This ISBN is already taken!");
    }

    public static void seeUsers() throws SQLException {

    }



}