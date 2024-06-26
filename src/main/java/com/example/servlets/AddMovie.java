package com.example.servlets;

import POJO.Movies;
import POJO.User;
import helper.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet(name = "AddMovie", urlPatterns = "/AddMovie")
public class AddMovie extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection connection = DBManager.getConnection();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        PreparedStatement ps = null;
        Movies movie = new Movies();
        movie.setName(request.getParameter("moviename"));
        movie.setReleaseDate(request.getParameter("releasedate"));
        movie.setAvailabletickets(Integer.parseInt(request.getParameter("availabletickets")));
        try {
            DBManager.getConnection();
               String query = "Insert INTO  movies values(?,?,?,?,?)";
                ps = connection.prepareStatement(query);
                ps.setInt(1, movie.getId());
                ps.setString(2, movie.getName());
                ps.setString(3, movie.getReleaseDate());
                ps.setInt(4, movie.getAvailabletickets());
                ps.setInt(5,user.getId());
                ps.execute();
                connection.close();
                out.println("<font color='green'>New Movie Inserted <br> Movie Name: " + movie.getName() + "</font>");
                RequestDispatcher rd = request.getRequestDispatcher("Admindashboard.jsp");
                rd.include(request, response);

            }
        catch (Exception ex) {
            ex.printStackTrace();
            out.println("<h2>Cant Inserted</h3> <br> Due to error");
            RequestDispatcher rd = request.getRequestDispatcher("Admindashboard.jsp");
            rd.include(request, response);

        }
     finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
            //end try
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}