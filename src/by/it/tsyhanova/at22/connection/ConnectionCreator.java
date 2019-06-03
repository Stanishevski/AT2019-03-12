package by.it.tsyhanova.at22.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface ConnectionCreator {
    

    Connection get() throws SQLException;
}
