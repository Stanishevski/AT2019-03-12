package by.it.romanova.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCreator {
    Connection get() throws SQLException;
}
