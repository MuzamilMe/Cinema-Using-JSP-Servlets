package DAO;

import POJO.User;
import helper.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static User getbyemail(String email) throws SQLException {
        Connection connection = DBManager.getConnection();
        User user = new User();
        user.setEmail(email);
        String query = "Select * from users where email=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1,user.getEmail());
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            user.setName(resultSet.getString(1));
            user.setPassword(resultSet.getString(3));
            user.setContact(resultSet.getString(4));
            user.setRole(resultSet.getString(5));
            user.setId(resultSet.getInt(6));
        }
        return user;
    }
}
