package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.entity.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll(Connection connection) throws SQLException {
        ArrayList<Item> allItem = new ArrayList<>();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM item");

        while (resultSet.next()){
            Item item = new Item(
                    resultSet.getString("code"),
                    resultSet.getString("description"),
                    resultSet.getInt("qtyOnHand"),
                    resultSet.getDouble("unitPrice"));
                    allItem.add(item);
        }
        return allItem;
    }

    @Override
    public boolean add(Item dto, Connection connection) throws SQLException {
        return connection.createStatement().executeUpdate("INSERT INTO item VALUES ('"+dto.getItemCode()+"','"+dto.getItemName()+"','"+dto.getItemQty()+"','"+dto.getItemPrice()+"')")>0;
    }

    @Override
    public boolean update(Item dto, Connection connection) {
        return false;
    }

    @Override
    public boolean delete(String id, Connection connection) {
        return false;
    }

    @Override
    public String generateNewId() {
        return null;
    }

    @Override
    public boolean UpdateQty(Item dto, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }
}
