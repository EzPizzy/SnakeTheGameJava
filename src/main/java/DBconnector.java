import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class DBconnector {
//    zadeklarowanie zmiennych, które przechowują dane połączeniowe z bazą postgresql
    public static String url = "jdbc:postgresql://localhost/SnakeTheGame";
    public static String user = "postgres";
    public static String password = "password";
    public static Connection connect()

    {
        Connection connection= null;
        try {
           connection=DriverManager.getConnection(url, user, password);
            System.out.println("Połączenie przeszło pomyślnie");
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return connection;
    }

}
