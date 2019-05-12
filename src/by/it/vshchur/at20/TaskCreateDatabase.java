package by.it.vshchur.at20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;

public class TaskCreateDatabase {
    public static void main(String[] args) throws SQLException {
        try(
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vshchur?"+
                    "useUnicode=true&"+
                    "useJDBCCompliantTimezoneShift=true&"+
                    "useLegacyDatetimeCode=false&"+
                    "serverTimezone=UTC", "root","");
            Statement statement = connection.createStatement()
        ){

            try {
                statement.executeQuery(String.valueOf(new BufferedReader(new FileReader(System.getProperty("user.dir") +
                        "/src/by/it/vshchur/at20/create.sql"))));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            ResultSet resultSet = statement.executeQuery("select * from vshchur.user");
            while (resultSet.next()){
                System.out.printf("name %-10s email:%-15s\n",
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        }
    }
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("Driver not found");
        }
    }
}
