package by.it.stanishevski.WebCalculator.DataBase.Repo;

import by.it.stanishevski.WebCalculator.DataBase.Connection.ConnectionCreator;
import by.it.stanishevski.WebCalculator.DataBase.beans.Category;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao implements InterfaceDao<Category> {

    private ConnectionCreator connectionCreator;

    public CategoryDao(ConnectionCreator connectionCreator) {
        this.connectionCreator=connectionCreator;
    }

    @Override
    public Category read(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean create(Category bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Category bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Category bean) throws SQLException {
        return false;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        return null;
    }
}
