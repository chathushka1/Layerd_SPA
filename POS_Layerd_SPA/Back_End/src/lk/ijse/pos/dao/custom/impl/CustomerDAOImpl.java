package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;

import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() {
        ArrayList<Customer> allCustomer = new ArrayList<>();
        ResultSet set =
    }

    @Override
    public boolean add(Customer dto) {
        return false;
    }

    @Override
    public boolean update(Customer dto) {
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
