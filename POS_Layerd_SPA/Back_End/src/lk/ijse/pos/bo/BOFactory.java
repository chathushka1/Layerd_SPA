package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.impl.CustomerBOImpl;
import lk.ijse.pos.bo.custom.impl.ItemBOImpl;
import lk.ijse.pos.bo.custom.impl.PurchaseBOImpl;
import lk.ijse.pos.dao.custom.impl.OrderDAOImpl;

public class BOFactory {
    private static BOFactory BOFactory;

    private BOFactory() {
    }

    public static BOFactory getFactory(){
        if (BOFactory == null){
            BOFactory = new BOFactory();
        }
        return BOFactory;
    }

    public enum BOType{
        CUSTOMER,ITEM,ORDER,PURCHASE;
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PURCHASE:
                return new PurchaseBOImpl();
        }
        return null;
    }
}
