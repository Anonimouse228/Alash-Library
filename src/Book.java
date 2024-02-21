import java.sql.SQLException;
import java.util.Scanner;

public class Book {
    private String name;
    private String author;
    private String genre;
    private String isbn;
    private String language;

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
