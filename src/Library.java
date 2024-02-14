import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Transaction> transactionHistory;
    private ArrayList<Book> checkedOutBooks;

    public Library(ArrayList<Book> books, ArrayList<Transaction> transactionHistory, ArrayList<Book> checkedOutBooks) {
        this.books = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
        this.checkedOutBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        //addbook
    }
    public void addBookToTheDB() {

    }
    public void deleteBookFromTheDB() {

    }


}
