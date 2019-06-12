package by.it.stanishevski.WebCalculator.DataBase.Connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCreator {




    Connection get() throws SQLException;

}
