package by.it.romanova.dao;

import by.it.romanova.dao.connection.ConnectionCreator;
import by.it.romanova.dao.connection.ConnectionCreatorH2;
import by.it.romanova.dao.connection.ConnectionCreatorMySql;
import by.it.romanova.dao.repo.CategoryDao;
import by.it.romanova.dao.repo.UserDao;

import java.util.NoSuchElementException;

public class Dao {

    enum TypeDao{
        MY_SQL, H2
    }

    //all beandao
    public UserDao user;
    public CategoryDao category;


    Dao(TypeDao typeDao) {
        ConnectionCreator connectionCreator;
        switch (typeDao){
            case MY_SQL:
                connectionCreator = new ConnectionCreatorMySql();
                break;
            case H2:
                connectionCreator = new ConnectionCreatorH2();
                break;
            default:
                throw new NoSuchElementException("not defined connection type");

        }

        user = new UserDao(connectionCreator);
    }
}
