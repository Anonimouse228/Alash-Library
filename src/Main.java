import Secrets.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Book> checkedOutBooks = new ArrayList<>();
        ArrayList<Transaction> transactionHistory = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        Library library = new Library(books, transactionHistory, checkedOutBooks, users);

        Book book = new Book("a", "a", "a", "123", "a");
        User user = new User("a", "a", "a", "a");
        library.addBook(book);
        System.out.println(user.getPassword());

        book.displayBookInfo();
        user.displayUserInfo();
        UI.menu();
    }
}