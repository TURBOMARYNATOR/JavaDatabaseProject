import java.sql.*;
import java.util.Objects;

public class MyJDBC {
    static final String QUERY = "SELECT idusers, username, password FROM USERS";
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

            Statement statement = connection.createStatement();

            Choice choice = new Choice();
            choice.ChoiceMenu();
            String getChoice = choice.getChoice();

            if (getChoice.equals("1")) {
                INSERT insert = new INSERT();
                String sql = insert.QUERY();
                statement.executeUpdate(sql);
            }
            else if (getChoice.equals("2")) {
                DELETE delete = new DELETE();
                String sql = delete.QUERY();
                statement.executeUpdate(sql);
            }

            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("idusers"));
                System.out.print(", Username: " + resultSet.getString("username"));
                System.out.print(", Password: " + resultSet.getString("password"));
                System.out.println();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
