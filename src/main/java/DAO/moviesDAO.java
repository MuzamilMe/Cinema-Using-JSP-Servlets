package DAO;

import POJO.Movies;

import POJO.User;
import helper.DBManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class moviesDAO {
    static Connection connection  = DBManager.getConnection();
    public static List<Movies> getall() throws SQLException {
        List list = new ArrayList();
        Movies movie = new Movies();
        String query = "Select * from movies";
        Statement st = connection.createStatement();
        ResultSet resultset =  st.executeQuery(query);
        while(resultset.next()){
            movie.setId(resultset.getInt(1));
            movie.setName(resultset.getString(2));
            movie.setReleaseDate(resultset.getString(3));
            movie.setAvailabletickets(resultset.getInt(4));
            list.add(movie);
            movie = new Movies();
        }
        return list;
    }

    public static Movies getbyid(int id) throws SQLException {
        Movies movie = new Movies();
        String query = "Select * from movies where idMovies=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1,id);
        ResultSet resultset =  ps.executeQuery();
        while(resultset.next()){
            movie.setId(resultset.getInt(1));
            movie.setName(resultset.getString(2));
            movie.setReleaseDate(resultset.getString(3));
            movie.setAvailabletickets(resultset.getInt(4));
        }
        return movie;
    }
    public static int delete(Movies movies) throws SQLException {
        int row=0;
        try {
        Connection connection = DBManager.getConnection();
        PreparedStatement ps = null;
        String q = "DELETE from movies where idMovies =?";
            ps = connection.prepareStatement(q);
            ps.setInt(1,movies.getId());
            row=ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return row;
    }
    public static List<Movies> getadminmovie(User user){
        List<Movies> list = new ArrayList<>();
        Movies movie = new Movies();
        try {
        String query = "Select * from movies where adminid=?";
        PreparedStatement ps = null;
            ps = connection.prepareStatement(query);

        ps.setInt(1,user.getId());
        ResultSet resultset =  ps.executeQuery();
        while(resultset.next()){
            movie.setId(resultset.getInt(1));
            movie.setName(resultset.getString(2));
            movie.setReleaseDate(resultset.getString(3));
            movie.setAvailabletickets(resultset.getInt(4));
            list.add(movie);
            movie = new Movies();
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;

    }


}
