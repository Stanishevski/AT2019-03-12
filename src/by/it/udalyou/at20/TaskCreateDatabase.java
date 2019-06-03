package by.it.udalyou.at20;

import java.sql.*;

public class TaskCreateDatabase {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/udalyou?" +
                        "useUnicode=true&" +
                        "useJDBCCompliantTimezoneShift=true&" +
                        "useLegacyDatetimeCode=false&" +
                        "serverTimezone=UTC", "root", "");
             Statement statement = connection.createStatement()

        ) {
            ResultSet resultSet = statement.executeQuery("select * from udalyou.user");
            while (resultSet.next()) {
                System.out.printf("name %-10s email:%-15s\n",
                        resultSet.getString("username"),
                        resultSet.getString("email")
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

