package lk.ijse.pos.bo.custom;

import lk.ijse.pos.bo.SuperBO;
import lk.ijse.pos.model.ItemDTO;
import lk.ijse.pos.model.OrderDTO;

import java.sql.Connection;
import java.sql.SQLException;


public interface PurchaseBO extends SuperBO {
    boolean purchaseOrder(OrderDTO dto, Connection connection);
    boolean UpdateQty(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException;
}
