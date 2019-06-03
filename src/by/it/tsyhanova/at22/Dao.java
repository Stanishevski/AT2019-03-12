package by.it.tsyhanova.at22;

import by.it.tsyhanova.at22.connection.ConnectionCreator;
import by.it.tsyhanova.at22.connection.ConnectionCreatorH2;
import by.it.tsyhanova.at22.connection.ConnectionCreatorMySql;
import by.it.tsyhanova.at22.repo.CategoryDao;
import by.it.tsyhanova.at22.repo.UserDao;

import java.util.NoSuchElementException;

public class Dao {
    //Dao  объект или интерфейс обеспечивающий доступ к какому-либо типу базы данных


    //определение типа Dao - в MySQL или H2  помощью enum - списком именованных констант
    enum TypeDao{
        MY_SQL,H2;
    }
    //создает все beanDao
    public UserDao user;
    public CategoryDao category;

    //конструктор Dao с определением типа соединения
        public Dao(TypeDao typeDao){
        ConnectionCreator connectionCreator;
        switch (typeDao){
            case MY_SQL:connectionCreator=new ConnectionCreatorMySql();
            break;
            case H2:connectionCreator=new ConnectionCreatorH2();
            break;
            default:throw new NoSuchElementException("not defined type of connection");
        }
        user=new UserDao(connectionCreator);
        category=new CategoryDao(connectionCreator);
    }
}
