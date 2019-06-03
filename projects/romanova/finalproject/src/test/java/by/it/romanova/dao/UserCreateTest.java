package by.it.romanova.dao;

import by.it.romanova.dao.beans.User;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class UserCreateTest {

    @Test
    public void createUser() throws Exception{

        Dao dao = new Dao(Dao.TypeDao.MY_SQL);
        Timestamp timestamp = new Timestamp(1223456729);
        User user = new User(0,"la la la", "00001", "d@mail.ru", timestamp);
        dao.user.create(user);
        User user2 = dao.user.read(user.getId());
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user.equals(user2));
    }
}
