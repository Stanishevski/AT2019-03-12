package by.it.romanova.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreatorH2 implements ConnectionCreator {

    static{
        String sqlfile = "/Users/elizabeth/AT2019-03-12/resources/romanova.sql";
        try {
            DriverManager.getConnection("jdbc:h2:mem:test;"+
                    "INIT=RUNSCRIPT FROM '"+ sqlfile + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection get() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }
}
