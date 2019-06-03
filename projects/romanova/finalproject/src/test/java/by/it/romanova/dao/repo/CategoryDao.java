package by.it.romanova.dao.repo;

import by.it.romanova.dao.connection.ConnectionCreator;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao implements InterfaceDao {
    private ConnectionCreator connectionCreator;

    public CategoryDao(ConnectionCreator connectionCreator) {
        this.connectionCreator = connectionCreator;
    }

    @Override
    public Object read(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean create(Object bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Object bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(long id) throws SQLException {
        return false;
    }

    @Override
    public List getAll() throws SQLException {
        return null;
    }
}
