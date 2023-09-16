package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.dao.CrudDAO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.model.CustomerDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public ArrayList<CustomerDTO> getAllCustomer(Connection connection) throws SQLException {
        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();

        ArrayList<Customer> all = customerDAO.getAll(connection);

        for (Customer customer : all){
            allCustomer.add(new CustomerDTO(
                    customer.getCusId(),
                    customer.getCusName(),
                    customer.getCusAddress(),
                    customer.getCusSalary()
            ));
        }
        return allCustomer;
        //return null;
    }

    @Override
    public boolean addCustomer(CustomerDTO dto, Connection connection) throws SQLException {
        return customerDAO.add(new Customer(dto.getCusId(),dto.getCusName(),dto.getCusAddress(),dto.getCusSalary()),connection);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto, Connection connection) throws SQLException {
        return customerDAO.update(new Customer(dto.getCusId(),dto.getCusName(),dto.getCusAddress(),dto.getCusSalary()),connection);
    }

    @Override
    public boolean deleteCustomer(String id, Connection connection) {
        return false;
    }

    @Override
    public String generateNewID() {
        return null;
    }
}
