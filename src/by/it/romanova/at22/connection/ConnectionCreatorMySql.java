package by.it.romanova.at22.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreatorMySql implements ConnectionCreator {
    static {
        try { //mysql-connector 8.0.15
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Not found Driver");
        }
    }

    private static final String
            URL = "jdbc:mysql://127.0.0.1:3306/romanova?" +
            "useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC",
            login = "root",
            password = "12345678";


    @Override
    public Connection get() throws SQLException {
        return DriverManager.getConnection(
                URL,
                login,
                password);
    }
}
