import java.time.LocalDateTime;

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
    public void displayTransactionInfo() {
        System.out.println("transactionID: '" + transactionID + "'" +
                ", timestamp: '" + timestamp + "'"  +
                ", action: '" + action + "'"  +
                ", item: '" + item + "'" );
    }

}
