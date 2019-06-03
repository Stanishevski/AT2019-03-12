package by.it.okoyro.at21;

import by.it.okoyro.at21.beans.User;

import java.sql.SQLException;

public class Runner {
	public static void main(String[] args) throws SQLException {
		UserDao userDao = new UserDao();
		User user = userDao.read(3);
		System.out.println("User with ID=3 is \n" + user);

		userDao.create(user);
		System.out.println("New user has new ID and all values from user above\n" + user);

		user.setUsername("test");
		userDao.update(user);
		System.out.println("Updated user's name is test\n" + user);

		userDao.delete(user);
		System.out.println("Deleted user id is above\n" + user);
	}
}
