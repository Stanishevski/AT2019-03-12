package by.it.agrinkevich.webcalculator.database.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCreator {
    Connection get() throws SQLException;
}
