package by.it.stanishevski.at22;

import by.it.stanishevski.at22.beans.Category;
import by.it.stanishevski.at22.connection.ConnectionCreator;
import by.it.stanishevski.at22.connection.ConnectionCreatorH2;
import by.it.stanishevski.at22.connection.ConnectionCreatorMySql;
import by.it.stanishevski.at22.connection.repo.CategoryDao;
import by.it.stanishevski.at22.connection.repo.UserDao;

import java.util.NoSuchElementException;

public class Dao {

    enum TypeDao {
        MY_SQL, H2;
    }

    public UserDao user;
    public CategoryDao category;


    public Dao(TypeDao typeDao) {
        ConnectionCreator connectionCreator;
        switch (typeDao) {
            case MY_SQL:
                connectionCreator= new ConnectionCreatorMySql();
                break;
            case H2:
                connectionCreator = new ConnectionCreatorH2();
                break;
            default:
                throw new NoSuchElementException("Not defined type of connection");


        }
        user = new UserDao(connectionCreator);
        category = new CategoryDao(connectionCreator);

        }
    }
