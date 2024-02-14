import Secrets.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book("a", "a", "a", "123", "a");
        User user = new User("a", "a", "a", "a");
        System.out.println(user.getPassword());

        book.displayBookInfo();
        user.displayUserInfo();
        UI.menu();
    }
}