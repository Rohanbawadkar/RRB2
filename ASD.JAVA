import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresJDBCExample {

    public static void main(String[] args) {
        // JDBC URL, username, and password of PostgreSQL server
        String url = "jdbc:postgresql://localhost:5432/emp";
        String user = "postgres";
String pass="12345";

        try {
            // Register PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Open a connection
            Connection connection = DriverManager.getConnection(url,user,pass);

            // Execute a query
            String sql = "SELECT * FROM emp1";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                // Process the result set
                while (resultSet.next()) {
                    int id = resultSet.getInt("empno");
                    String name = resultSet.getString("empname");
                    System.out.println("ID: " + id + ", Name: " + name);
                }
            }

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

