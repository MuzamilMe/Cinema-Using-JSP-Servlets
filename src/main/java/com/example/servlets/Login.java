package com.example.servlets;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import DAO.LoginDao;
import POJO.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Muzamil
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            response.setContentType("text/html");
            User user = new User();
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setRole(request.getParameter("role"));
            user = LoginDao.validate(user);
            if (user!=null) {
                if(user.getRole().equals("Admin")) {
                   HttpSession session = request.getSession();
                   session.setAttribute("user",user);
                   response.sendRedirect("Admindashboard.jsp");
                }
                else{
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    response.sendRedirect("Userdashboard.jsp");
                }
            } else {
                out.print("<h4>Sorry username or password error</h4><br>");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);

             }
        }

        catch (Exception e){
            e.printStackTrace();
        }











}



}
