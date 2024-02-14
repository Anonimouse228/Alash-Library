import java.util.Scanner;

public class UI {
    public static void menu() {  // The function that shows menu
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        // a = scanner.nextInt();
        System.out.println("Hello! Welcome to the greatest library on this computer!");
        while (exit) {
            System.out.println("""
                    What do you want to do?
                    1. Add a physical book
                    2. Add an EBook
                    3. Check out a book
                    4. Check out an EBook
                    5. Display all the books in the library
                    6. Display the list of checked-out items
                    7. Display the transaction history
                    8. Display the last n of transactions
                    9. Exit the program""");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
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