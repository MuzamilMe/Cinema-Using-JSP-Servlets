package com.example.servlets;

import DAO.TicketDAO;
import DAO.moviesDAO;
import POJO.Movies;
import POJO.User;
import POJO.Tickets;
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
@WebServlet("/MovieBuy")

public class MovieBuy extends HttpServlet {
    Connection conn = null;
    PreparedStatement ps = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection parameters
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            int mid = Integer.parseInt(request.getParameter("mid"));
            int ticket = Integer.parseInt(request.getParameter("tickets"));
           Movies movie = moviesDAO.getbyid(mid);
           Tickets tickets = new Tickets();
           tickets.setTickets(ticket);
           tickets.setIdMovie(mid);
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            // Create a database connection
            conn = DBManager.getConnection();
            // Prepare the SQL statement
//            boolean flag = TicketDAO.checkTicket(tickets);
//            if(flag){

            String sql = "INSERT INTO users_has_movies(Movies_idMovies,PurchasedTickets,users_idUser) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, movie.getId());
            ps.setInt(2, tickets.getTickets());
            ps.setInt(3, user.getId());
            int rowsAffected = ps.executeUpdate();
//            // Process the result
            if (rowsAffected>0) {
                TicketDAO.deduct(tickets);
                // Data updated successfully
                request.setAttribute("Success", "<font color='blue'>"+ tickets.getTickets()+" Tickets Purchased Successful </font>");
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Userdashboard.jsp");
                requestDispatcher.forward(request,response);


            } else {
                // No rows were affected
                request.setAttribute("Fail", "<font color='red'>Movie not Purchased </font>");
                response.setContentType("text/html");
                RequestDispatcher rd = request.getRequestDispatcher("Userdashboard.jsp");
                rd.forward(request,response);
            }
        }
//            else{
//                request.setAttribute("Fail", "<font color='red'>Check Available Tickets First </font>");
//                response.setContentType("text/html");
//                RequestDispatcher rd = request.getRequestDispatcher("Userdashboard.jsp");
//                rd.forward(request,response);
//            }

//        }
        catch (Exception e) {
            // Handle any database errors
            e.printStackTrace();
        }
        finally {
            // Close the database resources
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
