import java.sql.SQLException;
import java.util.Scanner;

public class UI {
    public static void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Welcome to the greatest library on this computer!\n Log in or register? (L/R)");
        if (scanner.nextLine() == "L") {
            System.out.print("Enter the login: ");
            String login = scanner.nextLine();
            System.out.print("\nEnter the password: ");
            String password = scanner.nextLine();
            if (Database.logIn(login, User.hashPassword(password))) {
                System.out.println("You successfully authorised!");
                menu();
            }
            else {
                System.out.println("Login or password is not correct");
                start();
            }
        }
        else if (scanner.nextLine() == "R") {
            User.register();
        }
        else {
            System.out.println("Invalid input! please type \"L\" or \"R\"!");
            start();
        }
        

    }
    public static void menu() throws SQLException {  // The function that shows the menu
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        System.out.println("Hello! Welcome to the greatest library on this computer!");

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
                        8: (ADMIN COMMAND)See transaction history
                        9: (ADMIN COMMAND)See last N transactions:\s
                        10: (ADMIN COMMAND)See users
                        11: (ADMIN COMMAND)See users""");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        logIn();
                        System.out.println("----------------------------------------------------");
                        break;
                    case "2":
                        User.register();
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
            System.out.println("You successfully authorised!");
        }
        else System.out.println("Login or password is not correct");
        return User.isAdmin(login, User.hashPassword(password));
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
            System.out.println("Your book is successfully added!");
        }
        else System.out.println("This ISBN is already taken!");
    }

    public static void seeUsers() throws SQLException {

    }



}