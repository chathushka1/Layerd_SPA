package lk.ijse.pos.dao;

import java.util.ArrayList;

public interface CrudDAO<T> {
    public ArrayList<T> getAll();
    public boolean add(T dto);
    public boolean update(T dto);
    public boolean delete(String id);
    public String generateNewId();
}
