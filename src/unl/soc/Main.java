// Student: YOUR NAME
// Partner: PARTNER'S NAME, or None

package unl.soc;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = Database.getConnection()) {
            System.out.println("Connected to the database.");
            View.mainWindow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
