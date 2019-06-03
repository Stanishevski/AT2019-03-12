package by.it.tsyhanova.at22.repo;

import by.it.tsyhanova.at22.beans.User;
import by.it.tsyhanova.at22.connection.ConnectionCreator;
import by.it.tsyhanova.at22.connection.ConnectionCreatorMySql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDao implements InterfaceDao<User> {
    //
    private ConnectionCreator connectionCreator;
    //code>generate>constructor
    public UserDao(ConnectionCreator connectionCreator) {
        this.connectionCreator = connectionCreator;
    }

    //чтение
    @Override
    public User read(long id) throws SQLException {
        User user=null;
        //переписываем select в полном варианте с обратными кавычками
        String sql=String.format("SELECT * FROM `tsyhanova`.`user` WHERE ID=%d",id);
        //удаляем все жесткие зависимости, вынеся connectioncreator вверх
        //ConnectionCreator connectionCreator=new ConnectionCreatorMySql();
        try (
                Connection connection=connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            //read from db
            //resultSet ничего не возвращает, а при наличии данных шагает на шаг вперед
            ResultSet resultSet = statement.executeQuery(sql);
            //возвращаем юзера, если в resultSet что-нибудь есть
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getDate("create_time")
                );
            }
        }
        return user;
    }
    //чтобы сделать List пользователей, нужно заменить в методе read if на while

    //создание
    @Override
    public boolean create(User user) throws SQLException {
        String sql=String.format(
                "insert INTO `tsyhanova`.`user` (username,email,password,create_time)"+
                " values ('%s','%s','%s','%s');",
                user.getUsername(),user.getEmail(),user.getPassword(),user.getDate()
                );
        //удаляем все жесткие зависимости, вынеся connectioncreator вверх
        //ConnectionCreator connectionCreator=new ConnectionCreatorMySql();
        try (
                Connection connection=connectionCreator.get();
                Statement statement = connection.createStatement()
        ){
            //проверка отработки запроса sql с возвращением в user id, где user это bean по которому работаем с базой
            //для возвращения id используем Statement.RETURN_GENERATED_KEYS
            if(1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
                //Statement врзвращает последние ключи
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
        String sql=String.format(
                "UPDATE `tsyhanova`.`user` SET `username`='%s',`email`='%s',`password`='%s',`create_time`='%s' WHERE `user`.`ID`=%d;",
                user.getUsername(),user.getEmail(),user.getPassword(),user.getDate(),user.getId()
        );
        //удаляем все жесткие зависимости, вынеся connectioncreator вверх
        //ConnectionCreator connectionCreator=new ConnectionCreatorMySql();
        try (
                Connection connection=connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            if(1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
                //Statement врзвращает последние ключи
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
    public boolean delete(User user) throws SQLException {
        String sql=String.format(
                "DELETE FROM `tsyhanova`.`user` WHERE `user`.`ID`=%d;",
                user.getId()
        );
        //удаляем все жесткие зависимости, вынеся connectioncreator вверх
        //ConnectionCreator connectionCreator=new ConnectionCreatorMySql();
        try (
                Connection connection=connectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            if(1==statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS)){
                //Statement врзвращает последние ключи
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
    public List<User> getAll() throws SQLException {
        return null;
    }
}
