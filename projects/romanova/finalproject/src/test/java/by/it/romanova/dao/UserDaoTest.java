package by.it.romanova.dao;

import by.it.romanova.dao.beans.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDaoTest {

    private Dao dao;

    @BeforeMethod
    public void setUp() throws Exception {
        dao = new Dao(Dao.TypeDao.MY_SQL);
    }

    @Test
    public void create() throws SQLException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        User user = new User(0,"la la la", "00001", "d@mail.ru", timestamp);
        dao.user.create(user);
        long created_id = user.getId();
        User check_user = user;
        User read_user = dao.user.read(created_id);
        Assert.assertEquals(read_user.getId(), check_user.getId());
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}