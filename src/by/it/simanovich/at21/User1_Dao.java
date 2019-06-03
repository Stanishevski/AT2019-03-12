package by.it.simanovich.at21;

import by.it.simanovich.at21.beans.User1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class User1_Dao implements interfaseDAO_1<User1> {


    @Override
    public User1 read(long id) throws SQLException {
        User1 user1 = null;
        String sql = "SELECT * FROM udalyou.user WHERE id=" + id;
        ConnectionCreator connectionCreator = new ConnectionCreatorMySQL();
        try (
                Connection connection = connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                user1 = new User1(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getDate("create_time")
                );
            }
        }
        return user1;
    }

    @Override
    public boolean create(User1 user1) throws SQLException {

        String sql = String.format("insert INTO user (username, email, password, create_time)" +
                        "values ('%s','%s','%s','%s')",
                user1.getUsername(), user1.getEmail(), user1.getPassword(), user1.getDate()
        );

        ConnectionCreator connectionCreator = new ConnectionCreatorMySQL();
        try (
                Connection connection = connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long id = generatedKeys.getLong(1);
                    user1.setId(id);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean update(User1 user1) throws SQLException {

        String sql = String.format("update user " +
                        " SET username='%s', email='%s', password='%s', create_time='%s'" +
                        " WHERE id='%d'",
                user1.getUsername(), user1.getEmail(), user1.getPassword(), user1.getDate(), user1.getId()
        );

        ConnectionCreator connectionCreator = new ConnectionCreatorMySQL();
        try (
                Connection connection = connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
        }
    }

    @Override
    public boolean delete(User1 user1) throws SQLException {

        String sql = String.format("DELETE FROM user " +
                " WHERE id='%d'", user1.getId()
        );

        ConnectionCreator connectionCreator = new ConnectionCreatorMySQL();
        try (
                Connection connection = connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
        }
    }

    @Override
    public List<User1> getAll() throws SQLException {

        return null;
    }
}
