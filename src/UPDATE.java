import java.util.Scanner;

public class UPDATE {
    Scanner scanner = new Scanner(System.in);

    public String QUERY() {
        if (MyJDBC.table.equals("users")) {
            System.out.println("Enter what change you would like to make");
            System.out.println("1. Password change");
            System.out.println("2. Username change");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter username");
                String username = scanner.nextLine();
                System.out.println("Enter new password");
                String password = scanner.nextLine();
                return String.format("UPDATE USERS SET password = '%s' WHERE username = '%s'", password, username);

            } else if (choice.equals("2")) {
                System.out.println("Enter username to change");
                String username = scanner.nextLine();
                System.out.println("Enter new username");
                String usernameChanged = scanner.nextLine();
                // Fixed: Added '=' in WHERE clause
                return String.format("UPDATE %s SET username = '%s' WHERE username = '%s'", MyJDBC.table, usernameChanged, username);
            }
        } else {
            System.out.println("Enter what change you would like to make");
            System.out.println("1. Name change");
            System.out.println("2. Surname change");
            System.out.println("3. Age change");
            System.out.println("4. Height change"); // Fixed duplicate numbering
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Name");
                String name = scanner.nextLine();
                System.out.println("Enter new name");
                String nameChanged = scanner.nextLine();
                return String.format("UPDATE customers SET name = '%s' WHERE name = '%s'", nameChanged, name);
            }
        }
        return "";
    }
}