package DAO;

import POJO.User;
import helper.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao  {

    public static  User validate(User user){
try{
    Connection connection = DBManager.getConnection();
PreparedStatement ps=connection.prepareStatement("select * from cinema.users where email=? and password=? and Role=?");
ps.setString(1,user.getEmail());
ps.setString(2,user.getPassword());
ps.setString(3, user.getRole());
ResultSet rs=ps.executeQuery();
if(rs.next()) {
    user.setId(rs.getInt(6));
    System.out.println("  " + user.getRole() + user.getEmail());
}
else{
    user=null;
}
}

catch(Exception e) {
    System.out.println(e);
}
return user;
}  
}  