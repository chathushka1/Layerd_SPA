package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.entity.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll(Connection connection) throws SQLException {
        ArrayList<Customer> allCustomer = new ArrayList<>();
        ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM customer");

        while (resultSet.next()){
            Customer customer =  new Customer(
                    resultSet.getString("id"),
                    resultSet.getString("name"),
                    resultSet.getString("address"),
                    resultSet.getString("salary"));
            allCustomer.add(customer);
        }
        //System.out.println("DAO"+allCustomer);

        return allCustomer;

    }

    @Override
    public boolean add(Customer dto , Connection connection) throws SQLException {
        //return false;
        return connection.createStatement().executeUpdate("INSERT INTO customer VALUES ('"+dto.getCusId()+"','"+dto.getCusName()+"','"+dto.getCusAddress()+"','"+dto.getCusSalary()+"')")>0;
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
