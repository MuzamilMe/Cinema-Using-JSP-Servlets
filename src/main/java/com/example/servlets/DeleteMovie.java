package com.example.servlets;

import DAO.moviesDAO;
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
import java.sql.Statement;
//
@WebServlet("/DeleteMovie")
public class DeleteMovie extends HttpServlet {
    int row=0;
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException {
        try {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Movies movie = new Movies();
        int mid = Integer.parseInt(request.getParameter("mid"));
            movie.setId(mid);
            row=moviesDAO.delete(movie);
        if(row>0) {
            request.setAttribute("Success","<font color='green'>Movie Deleted " + movie.getId() + "</font>");
                RequestDispatcher rd = request.getRequestDispatcher("Admindashboard.jsp");
                rd.forward(request,response);
            }
            else{
            request.setAttribute("Fail","<font color='red'>Movie not Deleted " + movie.getId() + "</font>");
            RequestDispatcher rd = request.getRequestDispatcher("Admindashboard.jsp");
            rd.forward(request,response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }

}