package by.it.udalyou.at21;

import by.it.udalyou.at21.beans.User1;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Runner1 {
    public static void main(String[] args) throws SQLException {
        //проверим чтение
        User1_Dao user1Dao = new User1_Dao();
        User1 user1 = user1Dao.read(3);
        System.out.println("user after read 3: " + user1);
        //проверим создание
        Date date = Timestamp.valueOf(LocalDateTime.now());
        user1 = new User1(0, "NEW_LOGIN", "NEW_PASSWORD", "NEW_EMAIL", date);
        user1Dao.create(user1);
        user1 = user1Dao.read(user1.getId());
        System.out.println("user after create: " + user1);

        //проверим обновление
        user1.setUsername("LOGIN_UPDATE");
        user1Dao.update(user1);
        user1 = user1Dao.read(user1.getId());
        System.out.println("user after update: " + user1);

        //проверим удаление
        user1Dao.delete(user1);
        user1 = user1Dao.read(user1.getId());
        System.out.println("user after delete: " + user1);

    }
}
