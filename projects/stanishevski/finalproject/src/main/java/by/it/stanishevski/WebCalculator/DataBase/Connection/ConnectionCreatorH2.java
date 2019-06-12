package by.it.stanishevski.WebCalculator.DataBase.Connection;

//import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreatorH2 implements ConnectionCreator{

    static {
        //URL resource = ConnectionCreatorH2.class.getClassLoader().getResource("stanishevski.sql");
        //String sqlFile=resource.toString();
        String sqlFile="C:/AT2019-03-12/resources/stanishevski.sql";// ???!!! Не поднимается ресурс по toString() с предыдущей строки
        try {
            DriverManager.getConnection("" +
                    "jdbc:h2:mem:test;" +
                    "INIT=RUNSCRIPT FROM '"+sqlFile+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection get() throws SQLException {
        return DriverManager.getConnection("jdbc:h2:mem:test");
    }
}
