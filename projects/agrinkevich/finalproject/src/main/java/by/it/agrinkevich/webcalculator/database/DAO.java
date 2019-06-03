package by.it.agrinkevich.webcalculator.database;

import by.it.agrinkevich.webcalculator.database.connection.ConnectionCreator;
import by.it.agrinkevich.webcalculator.database.connection.ConnectionCreatorH2;
import by.it.agrinkevich.webcalculator.database.connection.ConnectionCreatorMySql;
import by.it.agrinkevich.webcalculator.database.repo.CategoryDAO;
import by.it.agrinkevich.webcalculator.database.repo.UserDAO;

import java.util.NoSuchElementException;

public class DAO {

    public enum TypeDAO {
        MY_SQL, H2
    }

    //all bean Dao

    public UserDAO user;
    public CategoryDAO category;

    public DAO(TypeDAO typeDao) {
        ConnectionCreator connectionCreator;
        switch (typeDao) {
            case MY_SQL:
                connectionCreator = new ConnectionCreatorMySql();
                break;
            case H2:
                connectionCreator = new ConnectionCreatorH2();
                break;
            default:
                throw new NoSuchElementException("not defined type of connection");
        }
        user = new UserDAO(connectionCreator);
        category = new CategoryDAO(connectionCreator);
    }
}
