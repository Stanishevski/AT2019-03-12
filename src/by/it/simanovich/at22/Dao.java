package by.it.simanovich.at22;

import by.it.simanovich.at22.connection.ConnectionCreator;
import by.it.simanovich.at22.connection.ConnectionCreatorH2;
import by.it.simanovich.at22.connection.ConnectionCreatorMySql;
import by.it.simanovich.at22.repo.CategoryDao;
import by.it.simanovich.at22.repo.UserDao;

import java.util.NoSuchElementException;

public class Dao {

    enum TypeDao {
        MY_SQL, H2;
    }

    //all bean Dao

    public UserDao user;
    public CategoryDao category;

    public Dao(TypeDao typeDao) {
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
        user = new UserDao(connectionCreator);
        category = new CategoryDao(connectionCreator);
    }
}
