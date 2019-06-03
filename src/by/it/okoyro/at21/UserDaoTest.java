package by.it.okoyro.at21;

import by.it.okoyro.at21.beans.User;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoTest {

	private static UserDao userDao = new UserDao();
	private static User user = new User();


	@Test
	public void userDaoCreateTest() throws SQLException {
		userDao.create(user);
		userDao.read(user.getId());
		//		Assert.assertEquals(user);
	}

	@Test
	public void userDaoUpdateTest() throws SQLException {
		userDao.update(user);
		userDao.read(user.getId());
	}

	@Test
	public void userDaoDeleteTest() throws SQLException {
		userDao.delete(user);
		userDao.read(user.getId());
	}

}
