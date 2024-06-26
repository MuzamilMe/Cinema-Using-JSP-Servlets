package helper;

import core.AppConstants;

import java.sql.Connection;
import java.sql.DriverManager;


public class  DBManager {
    public static  Connection getConnection(){
        Connection ob  = null;
        try {
            Class.forName(AppConstants.JDBC_Driver);
            ob = DriverManager.getConnection(AppConstants.JDBC_URL,AppConstants.User_name,AppConstants.password);
            return ob;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
