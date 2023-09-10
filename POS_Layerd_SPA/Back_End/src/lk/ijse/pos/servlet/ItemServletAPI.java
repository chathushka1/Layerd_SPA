package lk.ijse.pos.servlet;

import lk.ijse.pos.bo.BOFactory;
import lk.ijse.pos.bo.custom.ItemBO;
import lk.ijse.pos.model.ItemDTO;
import lk.ijse.pos.util.ResponseUtil;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/item")
public class ItemServletAPI extends HttpServlet {
    ItemBO itemBO = (ItemBO) BOFactory.getFactory().getBO(BOFactory.BOType.ITEM);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            BasicDataSource pool = (BasicDataSource) getServletContext().getAttribute("dbcp");
            Connection connection = pool.getConnection();

            ArrayList<ItemDTO> allItem = itemBO.getAllItem(connection);
            JsonArrayBuilder getAllItem = Json.createArrayBuilder();
            //System.out.println("API");

            for(ItemDTO itemDTO : allItem){
                JsonObjectBuilder jsonitemObjectBuilder = Json.createObjectBuilder();

                jsonitemObjectBuilder.add("code",itemDTO.getItemCode());
                jsonitemObjectBuilder.add("description",itemDTO.getItemName());
                jsonitemObjectBuilder.add("qtyOnHand",itemDTO.getItemQty());
                jsonitemObjectBuilder.add("unitprice",itemDTO.getItemPrice());
                getAllItem.add(jsonitemObjectBuilder.build());
            }
            resp.getWriter().print(ResponseUtil.getJson("Success","Loaded",getAllItem.build()));
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(500);
            resp.getWriter().print(ResponseUtil.getJson("Error", e.getMessage()));
        }
    }
}
