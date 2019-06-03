package by.it.tsyhanova.at22.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreatorH2 implements ConnectionCreator {

    static {
        String sqlFile="D:/QualityAssuarance/tsyhanova/AT2019-03-12/src/by/it/tsyhanova/at22/tsyhanova.sql";
        try {
            DriverManager.getConnection("jdbc:h2:mem:test;INIT=RUNSCRIPT FROM '"+sqlFile+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection get() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }
}
