import java.time.LocalDateTime;
import java.util.Scanner;

public class Transaction {
    private final Book item;
    private final LocalDateTime timestamp;
    private final String action;
    private final int transactionID;

    public Transaction(Book item, LocalDateTime timestamp, String action, int transactionID) {
        this.item = item;
        this.timestamp = timestamp;
        this.action = action;
        this.transactionID = transactionID;

    }
    public static void transactionHistory(boolean isN) {

        if (isN) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the amount of transactions:");
            int N = scanner.nextInt();
            Database.transactionHistory(N);
        }
        else Database.transactionHistory();
    }
    public void displayTransactionInfo() {
        System.out.println("transactionID: '" + transactionID + "'" +
                ", timestamp: '" + timestamp + "'"  +
                ", action: '" + action + "'"  +
                ", item: '" + item + "'" );
    }

}
