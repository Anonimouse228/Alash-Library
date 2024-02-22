import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.Scanner;

public class Book {
    private final String name;
    private final String author;
    private final String genre;
    private final String isbn;
    private final String language;

    public Book(String name, String author, String genre, String isbn, String language) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.language = language;
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

    public static void displayBooks(boolean isN) throws SQLException{

        if (isN) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the amount of books:");
            int N = scanner.nextInt();
            System.out.println("All the books in this library:");
            Database.displayBooks(N);
        }

        else {
            System.out.println("All the books in this library:");
            Database.displayBooks();
        }
    }

    public static void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of books:");
        int N = scanner.nextInt();
        Database.returnBook();
    }

    public static void takeBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of books:");
        String N = scanner.nextLine();
        Database.findBookIsbn(N);
    }

    public static void findBook(boolean isName) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        if (isName) {

            System.out.println("Enter the name of the book:");
            String N = scanner.nextLine();
            Database.findBookName(N);
        }
        else {
            System.out.println("Enter the ISBN of your book:");
            String N = scanner.nextLine();
            Database.findBookIsbn(N);
        }
    }

    public String getIsbn() {
        return isbn;
    }


    public void displayBookInfo() {
        System.out.println("name: '" + name + "'"  +
                ", author: '" + author + "'"  +
                ", genre: '" + genre + "'" +
                ", language: '" + language + "'" +
                ", ISBN: '" + isbn + "'" );
    }
}
