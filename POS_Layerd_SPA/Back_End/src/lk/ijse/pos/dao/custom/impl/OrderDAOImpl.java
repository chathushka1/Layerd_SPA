package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<Order> getAll(Connection connection) {
        return null;
    }

    @Override
    public boolean add(Order dto, Connection connection) throws SQLException {
        return connection.createStatement().executeUpdate("INSERT INTO orders VALUES ('"+dto.getOrderId()+"','"+dto.getDate()+"','"+dto.getCustomerId()+"')")>0;
    }

    @Override
    public boolean update(Order dto, Connection connection) {
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
    public boolean UpdateQty(Order dto, Connection connection) throws SQLException, ClassNotFoundException {
        return false;
    }
}
