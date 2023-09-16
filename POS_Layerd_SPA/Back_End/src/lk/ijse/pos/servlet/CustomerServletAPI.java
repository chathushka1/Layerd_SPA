package lk.ijse.pos.servlet;


import lk.ijse.pos.bo.BOFactory;
import lk.ijse.pos.bo.custom.CustomerBO;
import lk.ijse.pos.model.CustomerDTO;
import lk.ijse.pos.util.ResponseUtil;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/customer")
public class CustomerServletAPI extends HttpServlet {
    CustomerBO customerBO = (CustomerBO) BOFactory.getFactory().getBO(BOFactory.BOType.CUSTOMER);


     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            BasicDataSource pool = (BasicDataSource) getServletContext().getAttribute("dbcp");
            Connection connection = pool.getConnection();

            ArrayList<CustomerDTO> allCustomer = customerBO.getAllCustomer(connection);
            JsonArrayBuilder allCustomers = Json.createArrayBuilder();
            System.out.println("API");

            for(CustomerDTO customerDTO : allCustomer){
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

                jsonObjectBuilder.add("id",customerDTO.getCusId());
                jsonObjectBuilder.add("name",customerDTO.getCusName());
                jsonObjectBuilder.add("address",customerDTO.getCusAddress());
                jsonObjectBuilder.add("salary",customerDTO.getCusSalary());
                allCustomers.add(jsonObjectBuilder.build());
            }
            resp.getWriter().print(ResponseUtil.getJson("Success","Loaded",allCustomers.build()));
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", e.getMessage()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            BasicDataSource pool = (BasicDataSource) getServletContext().getAttribute("dbcp");
            Connection connection = pool.getConnection();

            String id =req.getParameter("cusId");
            String name = req.getParameter("cusName");
            String address = req.getParameter("cusAddress");
            String salary = req.getParameter("cusSalary");

            customerBO.addCustomer(new CustomerDTO(id,name,address,salary),connection);
            resp.getWriter().print(ResponseUtil.getJson("Success","Customer Added"));

        } catch (SQLException throwables) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", throwables.getMessage()));
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            BasicDataSource pool = (BasicDataSource) getServletContext().getAttribute("dbcp");
            Connection connection = pool.getConnection();

            JsonReader jsonReader = Json.createReader(req.getReader());
            JsonObject jsonObject = jsonReader.readObject();

            String id = jsonObject.getString("cusId");
            String name = jsonObject.getString("cusName");
            String address = jsonObject.getString("cusAddress");
            String salary = jsonObject.getString("cusSalary");

            customerBO.updateCustomer(new CustomerDTO(id,name,address,salary),connection);
            resp.getWriter().print(ResponseUtil.getJson("Success","Customer update"));

            connection.close();


        } catch (SQLException throwables) {
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", throwables.getMessage()));
        }
    }
}
