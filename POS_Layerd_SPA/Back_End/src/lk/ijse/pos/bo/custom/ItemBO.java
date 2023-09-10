package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.model.ItemDTO;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
    public ArrayList<ItemDTO> getAllItem(Connection connection) throws SQLException;
    public boolean addItem(ItemDTO dto);
    public boolean updateItem(ItemDTO dto);
    public boolean deleteItem(String id);
    public String generateNewID();
}
