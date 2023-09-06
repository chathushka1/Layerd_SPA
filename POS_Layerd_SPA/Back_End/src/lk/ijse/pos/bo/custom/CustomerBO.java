package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.model.CustomerDTO;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public ArrayList<CustomerDTO> getAllCustomer();
    public boolean addCustomer(CustomerDTO dto);
    public boolean updateCustomer(CustomerDTO dto);
    public boolean deleteCustomer(String id);
    public String generateNewID();
}
