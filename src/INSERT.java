import java.util.Scanner;

class INSERT {
   Scanner scanner = new Scanner(System.in);
   public String QUERY() {

       if (MyJDBC.table.equals("users")) {
           System.out.println("Enter username");
           String username = scanner.nextLine();
           System.out.println("Enter password");
           String password = scanner.nextLine();
           return String.format("INSERT INTO users (username, password) VALUES ('%s','%s')",
                  username, password);
       }
       else {
           System.out.println("Enter name");
           String name = scanner.nextLine();
           System.out.println("Enter surname");
           String surname = scanner.nextLine();
           System.out.println("Enter height");
           String height = scanner.nextLine();
           System.out.println("Enter age");
           String age = scanner.nextLine();

           return String.format("INSERT INTO customers (name, surname, height, age) VALUES ('%s','%s','%s','%s')",
                  name, surname, height, age);
       }
   }
}