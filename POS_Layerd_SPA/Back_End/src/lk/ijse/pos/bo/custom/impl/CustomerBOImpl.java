package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.model.CustomerDTO;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() {
        return null;
    }

    @Override
    public boolean addCustomer(CustomerDTO dto) {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public String generateNewID() {
        return null;
    }
}
