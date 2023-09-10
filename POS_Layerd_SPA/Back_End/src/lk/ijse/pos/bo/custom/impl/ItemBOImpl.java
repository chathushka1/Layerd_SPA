package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.model.ItemDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ITEM);
    @Override
    public ArrayList<ItemDTO> getAllItem(Connection connection) throws SQLException {
        ArrayList<ItemDTO> allItem = new ArrayList<>();

        ArrayList<Item> all = itemDAO.getAll(connection);

        for (Item item : all){
            allItem.add(new ItemDTO(
               item.getItemCode(),
               item.getItemName(),
               item.getItemQty(),
               item.getItemPrice()
            ));
        }
        return allItem;
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
