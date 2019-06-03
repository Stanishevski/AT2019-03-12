package by.it.romanova.at22;

import by.it.romanova.at22.beans.User;
import by.it.romanova.at22.connection.ConnectionCreator;
import by.it.romanova.at22.connection.ConnectionCreatorMySql;
import by.it.romanova.at22.repo.UserDao;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Runner {
    public static void main(String[] args) throws SQLException {

        Dao dao = new Dao(Dao.TypeDao.H2);


//
//        Timestamp timestamp = new Timestamp(1223456729);
//        User user = new User(0,"la la la", "00001", "d@mail.ru", timestamp);
//        dao.user.create(user);
//        User user_update = new User(user.getId(),"update", "00002", "mail@mail.ru", timestamp);
//        dao.user.update(user_update);
//        System.out.println(dao.user.getAll());
//        dao.user.delete(user.getId());

    }
}
