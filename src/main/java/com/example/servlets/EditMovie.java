package com.example.servlets;

import POJO.Movies;
import helper.DBManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet(name = "EditMovie",urlPatterns = "/Edit")
public class EditMovie extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Movies movie = new Movies();
        movie.setId(Integer.parseInt(request.getParameter("id")));
       movie.setName(request.getParameter("moviename"));
       movie.setReleaseDate(request.getParameter("releasedate"));
       movie.setAvailabletickets(Integer.parseInt(request.getParameter("availabletickets")));
        // Database connection parameters
         Connection conn = null;
        PreparedStatement ps = null;
        try {
            // Create a database connection
             conn = DBManager.getConnection();

            // Prepare the SQL statement
            String sql = "UPDATE movies SET MovieName = ?, ReleaseDate=?, AvailableTickets=? WHERE idMovies = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,movie.getName());
            ps.setString(2, movie.getReleaseDate());
            ps.setInt(3, movie.getAvailabletickets());
            ps.setInt(4, movie.getId());
            int rowsAffected = ps.executeUpdate();
            // Process the result
            if (rowsAffected > 0) {
                // Data updated successfully
                request.setAttribute("Success", "<font color='blue'>Movie updated successfully</font>");
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Admindashboard.jsp");
                requestDispatcher.forward(request,response);
                out.println("<html><body>");
                out.println();
                out.println("</body></html>");

            } else {
                // No rows were affected
                request.setAttribute("Fail", "<font color='red'>Movie not  </font>");
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<font color='red'>Moive not updated </font>");
                out.println("</body></html>");
                RequestDispatcher rd = request.getRequestDispatcher("Admindashboard.jsp");
                rd.forward(request,response);
            }
        } catch (SQLException e) {
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


