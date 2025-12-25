import java.util.Scanner;

class INSERT {
   Scanner scanner = new Scanner(System.in);
   public String QUERY() {
       System.out.println("Enter username");
       String username = scanner.nextLine();
       System.out.println("Enter password");
       String password = scanner.nextLine();
       return String.format("INSERT INTO users (username, password) VALUES ('%s','%s')", username, password);
   }
}
