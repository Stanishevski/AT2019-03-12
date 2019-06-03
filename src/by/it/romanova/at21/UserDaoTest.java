package by.it.romanova.at21;

import by.it.romanova.at21.beans.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import static org.junit.Assert.*;

public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        userDao = new UserDao();
    }

    @Test
    public void create() throws SQLException {
        Timestamp timestamp = new Timestamp(1223456729);
        User user = new User(0,"la la la", "00001", "d@mail.ru", timestamp);
        userDao.create(user);
        long created_id = user.getId();
        User check_user = new User(created_id,"la la la", "00001", "d@mail.ru", timestamp);
        User read_user = userDao.read(created_id);
        System.out.println(read_user + "\n" + check_user);
        System.out.println(timestamp);
        Assert.assertEquals("user is not created", read_user, check_user);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}