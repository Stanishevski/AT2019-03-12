package by.it.stanishevski.at22;

import by.it.stanishevski.at22.beans.User;
//import by.it.stanishevski.at22.connection.ConnectionCreator;
//import by.it.stanishevski.at22.connection.ConnectionCreatorMySql;
//import by.it.stanishevski.at22.connection.repo.UserDao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static by.it.stanishevski.at22.Dao.TypeDao.H2;
import static by.it.stanishevski.at22.Dao.TypeDao.MY_SQL;

public class Runner {
    public static void main(String[] args) throws SQLException {
        //ConnectionCreator connectionCreator = new ConnectionCreatorMySql();
        Dao dao = new Dao (H2);
        User user = dao.user.read(3);
        user.setUsername("Nouwenki");
        System.out.println("user after read 3: " + user);

        //проверим создание
        Timestamp date = Timestamp.valueOf(LocalDateTime.now());
        user = new User(0, "CreaTED_nOW", "NEW_PASSWORD_666", "NEW_EMAIL_777", date);
        dao.user.create(user);
        user = dao.user.read(user.getId());
        System.out.println("user after create: " + user);

        //проверим обновление
        user.setUsername("Obnouka");
        dao.user.update(user);
        user = dao.user.read(user.getId());
        System.out.println("Login user after update: " + user);

        //проверим удаление
        dao.user.delete(user);
        user = dao.user.read(user.getId());
        System.out.println("user after delete: " + user);

    }
}
