package lk.ijse.pos.bo;

import lk.ijse.pos.bo.custom.impl.CustomerBOImpl;

public class Factory {
    private static Factory factory;

    private Factory() {
    }

    public static Factory getInstance(){
        if (factory == null){
            factory = new Factory();
        }
        return factory;
    }

    public enum BOType{
        CUSTOMER,ITEM,ORDER
    }
    public SuperBO getBO(BOType boType){
        switch (boType){
            case CUSTOMER:
                return new CustomerBOImpl();
        }
        return null;
    }
}
