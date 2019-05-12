package by.it.stanishevski.at21;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCreator {
    Connection get () throws SQLException;

}
