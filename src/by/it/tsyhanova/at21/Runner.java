package by.it.tsyhanova.at21;

import by.it.tsyhanova.at21.beans.User;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        //чтение
        UserDao userDao=new UserDao();
        User user = userDao.read(3);
        System.out.println("user after reading: " + user);

        //запись
        user=new User(0,"test_username","test_password","test@mail.ru",user.getDate());
        userDao.create(user);
        /*user.setUsername("test_name");
        userDao.create(user);//создаем из старого юзера нового*/
        System.out.println("user after creating: " + user);

        //проверим обновление
        user.setUsername("LOGIN_UPDATE");
        userDao.update(user);
        user = userDao.read(user.getId());
        System.out.println("user after update: " + user);

        //проверим удаление
        userDao.delete(user);
        user = userDao.read(user.getId());
        System.out.println("user after delete: " + user);


    }
}
