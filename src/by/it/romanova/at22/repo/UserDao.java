package by.it.romanova.at22.repo;

import by.it.romanova.at22.beans.User;
import by.it.romanova.at22.connection.ConnectionCreator;
import by.it.romanova.at22.connection.ConnectionCreatorMySql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class UserDao implements InterfaceDao<User> {
    private ConnectionCreator connectionCreator;

    public UserDao(ConnectionCreator connectionCreator) {
        this.connectionCreator = connectionCreator;
    }

    @Override
    public User read(long id) throws SQLException {

        User user = null;

        String sql = "SELECT * FROM `romanova`.`user` WHERE id="+id;
        try (Connection connection = connectionCreator.get();
             Statement statement = connection.createStatement()){

                ResultSet resultSet = statement.executeQuery(sql);
                if(resultSet.next()){
                    user = new User(resultSet.getLong("id"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            resultSet.getTimestamp("create_time"));
        }
    }

        return user;
    }

    @Override
    public boolean create(User user) throws SQLException {


        String sql = String.format("insert INTO `romanova`.`user` (username, email, password, create_time)"+
                "values('%s','%s','%s','%s')",
                user.getUsername(), user.getEmail(), user.getPassword(), user.getDate());
        try (Connection connection = connectionCreator.get();
             Statement statement = connection.createStatement()){
            if (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if(generatedKeys.next()){
                    long id=generatedKeys.getLong(1);
                    user.setId(id);
                    return true;
                }

            }

        }
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        try (Connection connection = connectionCreator.get();
             Statement statement = connection.createStatement()){

            String sql = String.format("UPDATE `romanova`.`user` SET username = '%s', email = '%s',"+
                            " password='%s', create_time='%s' WHERE (id='%d')",
                    user.getUsername(), user.getEmail(), user.getPassword(), user.getDate(),user.getId());

            if(1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)){
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()){
                    long id = keys.getLong(1);
                    user.setId(id);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean delete(long id) throws SQLException {

        String sql = String.format("DELETE FROM `romanova`.`user` WHERE (id = '%d')", id);

        try(Connection connection = connectionCreator.get();
            Statement statement = connection.createStatement() ){

            if(1 == statement.executeUpdate(sql)){

                return true;

            }

        }
        return false;
    }

    @Override
    public List<User> getAll() throws SQLException {
        String sql = "SELECT * FROM `romanova`.`user`";

        try ( Connection connection = connectionCreator.get();
              Statement statement = connection.createStatement()){

            List<User> table = new LinkedList<>();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User(resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getTimestamp("create_time"));

                table.add(user);
            }
            return table;

        }
    }
}
