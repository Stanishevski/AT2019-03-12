package by.it.okoyro.at22;

import by.it.okoyro.at22.beans.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import static by.it.okoyro.at22.Dao.DaoType.H2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class UserDaoTest {

	Dao dao;
	Date date = Timestamp.valueOf(LocalDateTime.now());

	@Before public void init (){
		dao = new Dao(H2);
	}

	@Test(timeout = 5000)
//	@Ignore
	public void userDaoCreateUser() throws Exception {
		User user = new User(1, "NEW_LOGIN", "NEW_PASSWORD", "NEW_EMAIL", date);
		dao.user.create(user);
		User user2 = dao.user.read(user.getId());
		assertEquals(user, user2);
	}

	@Test(timeout = 5000)
	public void userDaoUpdateTest() throws Exception {
		User user = new User(2, "login_2", "password_2", "email_2", date);
		dao.user.create(user);
		String email = user.getEmail();
		user.setEmail("email_update");
		dao.user.update(user);
		User user2 = dao.user.read(user.getId());
		assertNotEquals(email, user2.getEmail());
		assertEquals(user2.getEmail(), "email_update");
	}

	@Test(timeout = 5000)
	public void userDaoDeleteTest() throws Exception {
		User user = new User(3, "login_3", "password_3", "email_3", date);
		dao.user.create(user);
		dao.user.delete(user);
		User readUser = dao.user.read(user.getId());
		assertNull(readUser);
	}
}
