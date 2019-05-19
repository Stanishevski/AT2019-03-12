package by.it.stanishevski.at21;

import by.it.stanishevski.at21.beans.User;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Runner {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDao();
        User user = userDao.read(3);
        //user.setUsername("Nouwenki");
        System.out.println("user after read 3: " + user);

        //проверим создание
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
        user = new User(0, "CreaTED_nOW", "NEW_PASSWORD_666", "NEW_EMAIL_777", date);
        userDao.create(user);
        user = userDao.read(user.getId());
        System.out.println("user after create: " + user);

        //проверим обновление
        user.setUsername("Obnouka");
        userDao.update(user);
        user = userDao.read(user.getId());
        System.out.println("Login user after update: " + user);

        //проверим удаление
        userDao.delete(user);
        user = userDao.read(user.getId());
        System.out.println("user after delete: " + user);

    }
}
