package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.impl.CustomerBOImpl;
import lk.ijse.pos.bo.custom.impl.ItemBOImpl;

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
        CUSTOMER,ITEM,ORDER;
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
        }
        return null;
    }
}
