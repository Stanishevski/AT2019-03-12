package by.it.romanova.at22;

import by.it.romanova.at22.beans.User;
import by.it.romanova.at22.repo.UserDao;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;

public class UserDaoTest {

    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
       // userDao = new UserDao();
    }

    @Test
    public void create() throws SQLException {
        Timestamp timestamp = new Timestamp(1223456729);
        User user = new User(0,"la la la", "00001", "d@mail.ru", timestamp);
//        userDao.create(user);
//        User user_ckeck = userDao
//                user.equals()
//        Assert.assertThat(user, equals());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}