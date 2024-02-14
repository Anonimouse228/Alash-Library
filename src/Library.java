import Secrets.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Transaction> transactionHistory;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<User> users;

    public Library(ArrayList<Book> books, ArrayList<Transaction> transactionHistory, ArrayList<Book> checkedOutBooks, ArrayList<User> user) {
        this.books = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
        this.checkedOutBooks = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(Book book) {                //3
        //addbook
    }

    public void returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            //return book
        } else System.out.println("We didn't had that book!");
    }

    public void takeBook(Book book) {
        if (books.contains(book)) {
            //take book
        } else System.out.println("We don't have that book! But soon we will!");
    }

    public void findBook(int isbn) {

    }

    public void findBook(String name) {

    }

    public void displayTransactionHistory() {
        if(transactionHistory.isEmpty()) {
            System.out.println("Transaction history is empty!");
        }
        else {
            for (Transaction transaction : transactionHistory) {
                transaction.displayTransactionInfo();
            }
        }
    }
    public void displayTransactionHistory(int n) {
        if (transactionHistory.isEmpty()) {
            System.out.println("Transaction history is empty!");
        } else {
            if (n >= transactionHistory.size()) {
                // display the whole transaction history if n is more than the size of transaction history
                for (Transaction transaction : transactionHistory) {
                    transaction.displayTransactionInfo();
                }
            } else {
                // display the last n transactions
                for (int i = transactionHistory.size() - 1; i >= Math.max(0, transactionHistory.size() - n); i--) {
                    Transaction transaction = transactionHistory.get(i);
                    transaction.displayTransactionInfo();
                }
            }
        }
    }

    public void displayUsers() {
        //крч надо
        if(users.isEmpty()) {
            System.out.println("No users yet!");
        }
        else {
            for (User user : users) {
                user.displayUserInfo();
            }
        }

    }
    public void addBookToTheDB() {
        // addbook
    }

    public void deleteBookFromTheDB() {
        // deletebook
    }



}
