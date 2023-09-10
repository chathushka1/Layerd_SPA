package lk.ijse.pos.dao;

import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        if (daoFactory == null){
            daoFactory =  new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        CUSTOMER,ITEM,ORDER;
    }

    public SuperDAO getDao(DAOTypes daoTypes){
        switch (daoTypes){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
        }
        return null;
    }
}
