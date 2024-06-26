package DAO;

import POJO.Movies;
import POJO.Tickets;
import helper.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {
    static Connection connection = DBManager.getConnection();

    public static List<Tickets> getTicketByUserId(int id) {
          List<Tickets> list = new ArrayList<>();
        Tickets tickets = new Tickets();
        tickets.setIdUser(id);
        try {
            String query = "select * from users_has_movies where users_idUser=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, tickets.getIdUser());
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                tickets.setIdMovie(resultSet.getInt(1));
                tickets.setTickets(resultSet.getInt(2));
                tickets.setIdUser(resultSet.getInt(3));
                tickets.setPid(resultSet.getInt(4));
                list.add(tickets);
                tickets = new Tickets();
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkTicket(Tickets tickets){
        String query = "Select AvailableTickets from movies where idMovies=?";
        PreparedStatement ps = null;
        boolean flag =false;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1,tickets.getIdMovie());
            ResultSet resultset =  ps.executeQuery();
            resultset.next();
            int available = resultset.getInt("AvailableTickets");
            if(available>=tickets.getTickets()){
                flag =true;
            }
            else{
                flag= false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return flag;
    }

    public  static  void deduct(Tickets tickets) throws Exception {
       try{
           DBManager.getConnection();
           String query = "UPDATE movies SET AvailableTickets=AvailableTickets-? Where idMovies=?";
               PreparedStatement ps =connection.prepareStatement(query);
               ps.setInt(1,tickets.getTickets());
               ps.setInt(2,tickets.getIdMovie());
               ps.executeUpdate();

       }catch (Exception e){
           throw new Exception(e);
       }
    }
public static void cancelticket(Tickets tickets) throws Exception {
        try{
        DBManager.getConnection();
        String query = "UPDATE movies SET AvailableTickets=AvailableTickets+? Where idMovies=?";
        PreparedStatement ps =connection.prepareStatement(query);
        ps.setInt(1,tickets.getTickets());
        ps.setInt(2,tickets.getIdMovie());
        ps.executeUpdate();
         cancelticketuser(tickets);
    }catch (Exception e){
        e.printStackTrace();
    }
}
public static void cancelticketuser(Tickets tickets){
    try{
        DBManager.getConnection();
        String query = "UPDATE users_has_movies SET PurchasedTickets=PurchasedTickets-? Where Purchaseid=?";
        PreparedStatement ps =connection.prepareStatement(query);
        ps.setInt(1,tickets.getTickets());
        ps.setInt(2,tickets.getPid());
        ps.executeUpdate();

    }catch (Exception e){
        e.printStackTrace();
    }
}
}

