package lk.ijse.pos.bo.custom.impl;

import lk.ijse.pos.bo.custom.PurchaseBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.model.ItemDTO;
import lk.ijse.pos.model.OrderDTO;

import java.sql.Connection;
import java.sql.SQLException;

public class PurchaseBOImpl implements PurchaseBO {

    OrderDAO orderDAO = (OrderDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ORDER);
    OrderDetailsDAO orderDetailsDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ORDERDETAILS);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean purchaseOrder(OrderDTO dto, Connection connection) {
        return false;
    }

    @Override
    public boolean UpdateQty(ItemDTO dto, Connection connection) throws SQLException, ClassNotFoundException {
        return itemDAO.UpdateQty(new Item(dto.getItemCode(),dto.getItemName(),dto.getItemQty(),dto.getItemPrice()),connection);
    }
}
