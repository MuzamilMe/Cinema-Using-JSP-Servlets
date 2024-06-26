package com.example.servlets;

import DAO.TicketDAO;
import DAO.moviesDAO;
import POJO.Tickets;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
@WebServlet(name = "Cancel", urlPatterns = "/Cancel")
public class Cancel extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tickets tickets = new Tickets();
            int mid = Integer.parseInt(request.getParameter("mid"));
            int pid = Integer.parseInt(request.getParameter("pid"));
            int cid = Integer.parseInt(request.getParameter("cid"));
            tickets.setPid(pid);
        // no of tickets user want to cancel
        tickets.setTickets(cid);
         tickets.setIdMovie(mid);
         try {
            TicketDAO.cancelticket(tickets);
            request.setAttribute("CancelSuccess","<font color='green'>Purchase Cancel Success Purchaseid: "+tickets.getPid()+"</font>");
            RequestDispatcher rd = request.getRequestDispatcher("Userdashboard.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("CancelSuccess","<font color='red'>  Purchase Cancel Failed </font>");
               e.printStackTrace();
         }
    }
}
