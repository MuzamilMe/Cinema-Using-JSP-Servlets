package com.example.servlets;

import POJO.User;
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
import java.sql.Statement;


@WebServlet(name = "Register",urlPatterns = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Statement st = null;
        PreparedStatement ps = null;
        Connection connection = DBManager.getConnection();
        User user = new User();
        try {
            user.setName(request.getParameter("name"));
            user.setPassword(request.getParameter("password"));
            user.setContact(request.getParameter("contact"));
            user.setEmail(request.getParameter("email"));
            user.setRole(request.getParameter("role"));
                String query = "Insert INTO  users(Name,email,password,contact,Role) values(?,?,?,?,?)";
                st = connection.createStatement();
                ps = connection.prepareStatement(query);
                ps.setString(1, user.getName());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getContact());
                ps.setString(5,user.getRole());
                ps.execute();
                st.close();
                connection.close();
                request.setAttribute("Register",user.getRole()+" Created <br> Username:" + user.getName() + "<br>Password:" + user.getPassword() + "<br>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(request,response);
            } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (st != null)
                    st.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (connection != null)
                    connection.close();
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