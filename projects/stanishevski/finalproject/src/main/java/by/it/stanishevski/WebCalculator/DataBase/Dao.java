package by.it.stanishevski.WebCalculator.DataBase;

import by.it.stanishevski.WebCalculator.DataBase.Connection.ConnectionCreator;
import by.it.stanishevski.WebCalculator.DataBase.Connection.ConnectionCreatorH2;
import by.it.stanishevski.WebCalculator.DataBase.Connection.ConnectionCreatorMySql;
import by.it.stanishevski.WebCalculator.DataBase.Repo.CategoryDao;
import by.it.stanishevski.WebCalculator.DataBase.Repo.UserDao;

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
