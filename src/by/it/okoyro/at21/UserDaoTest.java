package by.it.okoyro.at21;

import by.it.okoyro.at21.beans.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class UserDaoTest {

	private static UserDao userDao = new UserDao();
	Date date = Timestamp.valueOf(LocalDateTime.now());

	//	private static User user = new User();


	@Test
	public void userDaoCreateTest() throws SQLException { // is it required to throw SQL Exception ????
		User user = new User(1, "NEW_LOGIN", "NEW_PASSWORD", "NEW_EMAIL", date);
		userDao.create(user);
		User user2 = userDao.read(user.getId());
		Assert.assertEquals(user, user2);
	}

	@Test
	public void userDaoUpdateTest() throws SQLException {
		User user = new User(2, "LOGIN_2", "PASSWORD_2", "EMAIL_2", date);
		userDao.create(user);
		String email = user.getEmail();
		user.setEmail("EMAIL_UPDATED");
		userDao.update(user);
		User user2 = userDao.read(user.getId());
		assertNotEquals(email, user2.getEmail());
		assertEquals(user2.getEmail(), "EMAIL_UPDATED");
	}

	@Test
	public void userDaoDeleteTest() throws SQLException {
		User user = new User(3, "LOGIN_3", "PASSWORD_3", "EMAIL_3", date);
		userDao.create(user);
		userDao.delete(user);
		User readUser = userDao.read(user.getId());
		assertNull(readUser);
	}
}
