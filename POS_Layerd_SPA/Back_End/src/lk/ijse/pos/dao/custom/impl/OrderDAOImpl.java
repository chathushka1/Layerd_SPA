package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.entity.Order;

import java.sql.Connection;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<Order> getAll(Connection connection) {
        return null;
    }

    @Override
    public boolean add(Order dto, Connection connection) {
        return false;
    }

    @Override
    public boolean update(Order dto) {
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
