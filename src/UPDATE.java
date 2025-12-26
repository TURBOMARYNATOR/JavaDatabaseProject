import java.util.Scanner;

public class UPDATE {
    Scanner scanner = new Scanner(System.in);
    public String QUERY() {
        System.out.println("Enter what change you would like to make");
        System.out.println("1. Password change");
        System.out.println("2. Username change");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.println("Enter username");
            String username = scanner.nextLine();
            System.out.println("Enter new password");
            String password = scanner.nextLine();
            return String.format("UPDATE USERS SET password = '%s' " +
                                 "WHERE username = '%s'",
                                 password, username);

        } else if (choice.equals("2")) {
            System.out.println("Enter username to change");
            String username = scanner.nextLine();
            System.out.println("Enter new username");
            String usernameChanged = scanner.nextLine();
            return String.format("UPDATE '%s' SET username = '%s' WHERE username '%s'",
                                 MyJDBC.table, usernameChanged, username);
        }
        return "";
    }
}
