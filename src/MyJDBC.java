import java.sql.*;

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
            ResultSet resultSet = statement.executeQuery(QUERY);

            while (resultSet.next()) {
                System.out.print("ID: " + resultSet.getInt("idusers"));
                System.out.print(", Username: " + resultSet.getString("username"));
                System.out.print(", Password: " + resultSet.getString("password"));
                System.out.println();
            }

            Choice choice = new Choice();
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
