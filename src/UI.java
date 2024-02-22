import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class UI {
    public static void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! Welcome to the greatest library on this computer!\n1.Log in\n2. Register");
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
                        4: Return a book
                        5: Take a book
                        6: Find a book by a isbn\s
                        7: Find a book
                        8: See transaction history
                        9: See last N transactions:\s
                        10: Log out
                        11: (ADMIN COMMAND)See users
                        12: (ADMIN COMMAND)See last n users
                        13: (ADMIN COMMAND)Delete user""");
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
                        Book.returnBook();
                        System.out.println("----------------------------------------------------");
                        break;
                    case "5":
                        Book.takeBook();
                        System.out.println("----------------------------------------------------");
                        break;
                    case "6":
                        Book.findBook(true);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "7":

                        Book.findBook(false);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "8":
                        Transaction.transactionHistory(false);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "9":
                        System.out.println("----------------------------------------------------");
                        break;
                    case "10":
                        System.out.println("----------------------------------------------------");
                        break;
                    case "11":
                        User.showUsers();
                        System.out.println("----------------------------------------------------");
                    case "12":
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
                        What do you want to do?
                        1: Display all books
                        2: Display last N books
                        3: Add a book
                        4: Return a book
                        5: Take a book
                        6: Find a book by a isbn\s
                        7: Find a book
                        8: See transaction history
                        9: See last N transactions:\s
                        10: Log out
                        11: Exit from the program""");
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
                        Book.returnBook();
                        System.out.println("----------------------------------------------------");
                        break;
                    case "5":
                        Book.takeBook();
                        System.out.println("----------------------------------------------------");
                        break;
                    case "6":
                        Book.findBook(true);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "7":

                        Book.findBook(false);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "8":
                        Transaction.transactionHistory(false);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "9":
                        System.out.println("Enter the amount of transactions:");
                        int N = scanner.nextInt();
                        Transaction.transactionHistory(true);
                        System.out.println("----------------------------------------------------");
                        break;
                    case "10":
                        start();
                        break;
                    case "11":
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