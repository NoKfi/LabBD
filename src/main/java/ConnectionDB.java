import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    static String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";
    static String username = "root";
    static String password = "root";
    static Connection connection = null;
    public ConnectionDB() {
    }
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {

        }
        return connection;
    }

    public static void closeConnection () throws SQLException {

        connection.close();
    }

}
