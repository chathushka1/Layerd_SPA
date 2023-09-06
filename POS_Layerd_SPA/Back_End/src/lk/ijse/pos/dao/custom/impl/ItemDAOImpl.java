package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.Item;

import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() {
        return null;
    }

    @Override
    public boolean add(Item dto) {
        return false;
    }

    @Override
    public boolean update(Item dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public String generateNewId() {
        return null;
    }
}
