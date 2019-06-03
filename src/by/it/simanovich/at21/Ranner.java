package by.it.simanovich.at21;

import by.it.asimanovich.at21.beans.User;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

public class Ranner {
    public static void main(String[] args) throws SQLException {
        //роверка на чтение
        int i=3;
        UserDAO userDAO=new UserDAO();
        User user=userDAO.read(i);
        System.out.println("user after read "+i+": " +user);

        //проверка создания
        Date date = Timestamp.valueOf(LocalDateTime.now());
        user=new User(0,"fghklg","852147","yyyyy@gmail.com",date);
        userDAO.create(user);
        user=userDAO.read(user.getId());
        System.out.println("user after create: "+user);
    }
}
