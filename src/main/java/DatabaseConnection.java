import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        // URL-ul de conectare, de obicei ceva de genul: jdbc:mysql://localhost:3306/numele_bazei_de_date
        String url = "jdbc:mysql://<adresa_host>:<port>/<numele_bazei_de_date>";
        String user = "<user>"; // utilizatorul pentru conectare
        String password = "<parola>"; // parola pentru utilizator

        // Conectarea la baza de date
        return DriverManager.getConnection(url, user, password);
    }
}

