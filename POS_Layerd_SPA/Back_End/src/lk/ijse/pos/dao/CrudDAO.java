package lk.ijse.pos.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    public ArrayList<T> getAll(Connection connection) throws SQLException;
    public boolean add(T dto, Connection connection) throws SQLException;
    public boolean update(T dto);
    public boolean delete(String id);
    public String generateNewId();
}
