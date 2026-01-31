import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Airline%20Reservation",
                "postgres",
                "Bsd!12348"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
