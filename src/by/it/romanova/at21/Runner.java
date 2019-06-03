package by.it.romanova.at21;

import by.it.romanova.at21.beans.User;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

public class Runner {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();

        Timestamp timestamp = new Timestamp(1223456729);
        User user = new User(0,"la la la", "00001", "d@mail.ru", timestamp);
        userDao.create(user);
        User user_update = new User(user.getId(),"update", "00002", "mail@mail.ru", timestamp);
        userDao.update(user_update);
        System.out.println(userDao.getAll());
        userDao.delete(user.getId());

    }
}
