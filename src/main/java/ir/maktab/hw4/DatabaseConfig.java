package ir.maktab.hw4;
import java.sql.*;
public class DatabaseConfig {

    //Database driver and url
    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/shop";

    //Database credentials
    public static final String DB_USER = "root";
    public static final String DB_PASS = "";

    private static Connection connection;
    public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } else {
            if (connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            }
        }
        return connection;
    }
}
