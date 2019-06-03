package by.it.tsyhanova.at22.repo;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao<T> {
    // Интерфейс Generic. Имея такой интерфейс, необходимо дописать его реализацию в UserDao
    //<T> обозначение нужной для текущей операции таблицы в базе данных
    T read(long id) throws SQLException;
    boolean create(T bean) throws SQLException;
    boolean update(T bean) throws SQLException;
    boolean delete(T bean) throws SQLException;
    List<T> getAll() throws SQLException;
}
