package unl.soc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static final String hostname = "nuros.unl.edu";
    public static final String username = "your_mysql_username";
    public static final String password = "your_mysql_password";
    public static final String url = "jdbc:mysql://" + hostname + "/" + username;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
