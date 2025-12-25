import java.util.Scanner;

public class DELETE {
    Scanner scanner = new Scanner(System.in);
    public String QUERY() {
        System.out.println("Enter username of a user that you would like to delete");
        String username = scanner.nextLine();
        return String.format("DELETE FROM USERS WHERE username = '%s'", username);
    }
}
