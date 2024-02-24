import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class UI {
    public static void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Welcome to the greatest library on this computer!\n1. Log in\n2. Register");
        String choice = scanner.nextLine();
        if (Objects.equals(choice, "1")) {
            User.logIn();
        } else if (Objects.equals(choice, "2")) {
            User.register();
        } else {
            System.out.println("Invalid input! please type \"1\" or \"2\"!");
            start();
        }
    }
    public static void menu(User user) throws SQLException {  // The function that shows the menu
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        System.out.println("Hello! Welcome to the greatest library on this computer!");

        while (exit) {
            if (user.isAdmin()) {
                System.out.println("""
                        What do you want to do, admin?
                                                
                        1: Display all books
                        2: Display last N books
                        3: Add a book
                        4: Find a book by a isbn\s
                        5: Find a book
                        6: Log out
                        7: (ADMIN COMMAND)See users
                        8: (ADMIN COMMAND)See last n users""");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        Book.displayBooks(false);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "2":
                        Book.displayBooks(true);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "3":
                        Book.addBook();
                        System.out.println("----------------------------------------------------");
                        break;
                    case "4":
                        Book.findBook(true);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "5":
                        Book.findBook(false);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "6":
                        System.out.println("----------------------------------------------------");
                        exit = false;
                        break;
                    case "7":
                        User.showUsers(true);
                        System.out.println("----------------------------------------------------");
                    case "8":
                        User.showUsers(false);
                        System.out.println("----------------------------------------------------");
                        break;
                    default:
                        System.out.println("Invalid input! Please try again!");
                        System.out.println("----------------------------------------------------");
                        break;
                }
            }
            else {
                System.out.println("""
                        What do you want to do, admin?
                                                
                        1: Display all books
                        2: Display last N books
                        3: Add a book
                        4: Find a book by a isbn\s
                        5: Find a book
                        6: Log out""");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        Book.displayBooks(false);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "2":
                        Book.displayBooks(true);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "3":
                        Book.addBook();
                        System.out.println("----------------------------------------------------");
                        break;
                    case "4":
                        Book.findBook(true);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "5":
                        Book.findBook(false);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "6":
                        System.out.println("----------------------------------------------------");
                        exit = false;
                        break;
                    default:
                        System.out.println("Invalid input! Please try again!");
                        System.out.println("----------------------------------------------------");
                        break;
                }
            }
        }
    }
}