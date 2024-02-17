import java.sql.SQLException;
import java.util.Scanner;

public class UI {
    public static void menu() throws SQLException {  // The function that shows menu
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        // a = scanner.nextInt();
        System.out.println("Hello! Welcome to the greatest library on this computer!");
        while (exit) {
            System.out.println("""
                    What do you want to do?
                    1: Log in
                    2: Log up
                    3: Add a book
                    4: Return a book
                    5: Take a book
                    6: Find a book by a isbn 
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
                    Database.register();
                    System.out.println("----------------------------------------------------");
                    break;
                case "3":
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

    public static void logIn() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the login:");
        String login = scanner.nextLine();

        System.out.println("Enter the password:");
        String password = scanner.nextLine();

//        if (Database.logIn(login, User.hashPassword(password))) {
//            System.out.println("You succesfully authorised!");
//        }
//        else System.out.println("Login or password is not correct");

    }
//    public static void register() throws SQLException {
//        Database.register();
//
//        System.out.println("You succesfully authorised!");
//    }



}