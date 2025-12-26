import java.sql.*;
import java.util.Scanner;

public class MyJDBC {
    static Scanner scanner = new Scanner(System.in);
    public static String table;
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/login_schema",
                    "root",
                    "wiktor123"
            );

            if (connection != null) {
                System.out.println("Connected to the database");
            }

            System.out.println("Which table would you like to use?");
            System.out.println("1. users");
            System.out.println("2. customers");
            String tableChoice = scanner.nextLine();

            if (tableChoice.equals("1")) {
                table = "users";
            }
            else {
                table = "customers";
            }

            String QUERY = String.format("SELECT * FROM %s", table);
            Statement statement = connection.createStatement();
            ResultSet resultSet;

            Choice choice =  new Choice();
            choice.choiceMenu();
            String getChoice = choice.getChoice();

            switch (getChoice) {
                case "1" -> {
                    INSERT insert = new INSERT();
                    String sql = insert.QUERY();
                    statement.executeUpdate(sql);
                }
                case "2" -> {
                    DELETE delete = new DELETE();
                    String sql = delete.QUERY();
                    statement.executeUpdate(sql);

                }
                case "3" -> {
                    UPDATE update = new UPDATE();
                    String sql = update.QUERY();
                    statement.executeUpdate(sql);
                }
            }

            resultSet = statement.executeQuery(QUERY);
            if (table.equals("users")) {
                while (resultSet.next()) {
                    System.out.print("ID: " + resultSet.getInt("user_id"));
                    System.out.print(", Username: " + resultSet.getString("username"));
                    System.out.print(", Password: " + resultSet.getString("password"));
                    System.out.println();
                }
            } else if (table.equals("customers")) {
                while (resultSet.next()) {
                    System.out.print("ID: " + resultSet.getInt("customer_id"));
                    System.out.print(", Name: " + resultSet.getString("name"));
                    System.out.print(", Surname: " + resultSet.getString("surname"));
                    System.out.print(", Age: " + resultSet.getInt("age"));
                    System.out.print(", Height: " + resultSet.getInt("height"));
                    System.out.println();
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}