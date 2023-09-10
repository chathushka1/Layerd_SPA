package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.entity.OrderDetails;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {

    @Override
    public ArrayList<OrderDetails> getAll(Connection connection) throws SQLException {
        return null;
    }

    @Override
    public boolean add(OrderDetails dto, Connection connection) throws SQLException {
        return connection.createStatement().executeUpdate("INSERT INTO orderDetails VALUES ('"+dto.getOrdId()+"','"+dto.getItemId()+"','"+dto.getQty()+"','"+dto.getUnitPrice()+"')")>0;
    }

    @Override
    public boolean update(OrderDetails dto) {
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
