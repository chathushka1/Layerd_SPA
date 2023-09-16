package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.model.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO {
    public ArrayList<CustomerDTO> getAllCustomer(Connection connection) throws SQLException;
    public boolean addCustomer(CustomerDTO dto,Connection connection) throws SQLException;
    public boolean updateCustomer(CustomerDTO dto, Connection connection) throws SQLException;
    public boolean deleteCustomer(String id,Connection connection);
    public String generateNewID();
}
