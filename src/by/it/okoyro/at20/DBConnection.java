package by.it.okoyro.at20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static void main(String[] args) throws SQLException {
			try (
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/okoyro?useSSL=false" +
							"&connectTimeout=0" +
							"&autoReconnect=true" +
							"&useUnicode=true" +
							"&characterEncoding=UTF-8",
//							+
//							"unicode = true&" +
//							"useJDBCCompliantTimezoneShift = true&" +
//							"useLegacyDatetimeCode = false&" +
//							"serverTimezone = UTC",
							"root", "");
					Statement statement = connection.createStatement()
					)  {
				ResultSet resultSet = statement.executeQuery("select * from user");
				while (resultSet.next()){
					System.out.printf("name: %-10s email: %-15s\n",
					resultSet.getString("username"),
					resultSet.getString("email"));

				}
			}


		}
}
