package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.model.ItemDTO;

import java.sql.Connection;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {
    @Override
    public ArrayList<ItemDTO> getAllItem(Connection connection) {
        return null;
    }

    @Override
    public boolean addItem(ItemDTO dto) {
        return false;
    }

    @Override
    public boolean updateItem(ItemDTO dto) {
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }

    @Override
    public String generateNewID() {
        return null;
    }
}
