import java.util.Scanner;

public class DELETE {
    Scanner scanner = new Scanner(System.in);
    public String QUERY() {
        if (MyJDBC.table.equals("users")) {
            System.out.println("Enter username of a user that you would like to delete");
            String username = scanner.nextLine();
            return String.format("DELETE FROM USERS WHERE username = '%s'", username);
        } else if  (MyJDBC.table.equals("customers")) {
            System.out.println("Enter the name of a customer that you would like to delete");
            String name = scanner.nextLine();
            return String.format("DELETE FROM customers WHERE name = '%s'", name);
        }
        return "";
    }
}
