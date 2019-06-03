package by.it.romanova.dao;

import by.it.romanova.dao.beans.User;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Runner {
    public static void main(String[] args) throws SQLException {

        Dao dao = new Dao(Dao.TypeDao.MY_SQL);



        Timestamp timestamp = new Timestamp(1223456729);
        User user = new User(0,"la la la", "00001", "d@mail.ru", timestamp);
        dao.user.create(user);
        User user_update = new User(user.getId(),"update", "00002", "mail@mail.ru", timestamp);
        dao.user.update(user_update);
        System.out.println(dao.user.getAll());
        dao.user.delete(user.getId());

    }
}
