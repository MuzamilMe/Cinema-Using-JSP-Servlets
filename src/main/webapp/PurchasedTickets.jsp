<%@ page import="POJO.Movies" %>
<%@ page import="DAO.moviesDAO" %>
<%@ page import="POJO.User" %>
<%@ page import="POJO.Tickets" %>
<%@ page import="DAO.UserDAO" %>
<%@ page import="DAO.TicketDAO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Muzamil-M
  Date: 1/22/2024
  Time: 3:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    <title>Your Tickets</title>
  </head>
  <body>
  <nav>
    <div class="nav-wrapper">
      <a href="#!"  class="brand-logo center">Elysian Theaters</a>
      </ul>
    </div>
  </nav>
  <div class="container">
    <div class="row">
      <div class="card">
        <div class="form">
  <table>
    <thead>
    <h2 style="background:#f2f2ea; text-align: center"><font><strong><i>Your Tickets</i></strong></font></h2>
    <tr>
      <td><b>Movie Name</b></td>
      <td><b>Your Tickets</b></td>
      <td><b>Cancel Tickets</b></td>
    </tr>
    </thead>
    <%
      try {
        int userid = Integer.parseInt(request.getParameter("id"));
        List<Tickets> list = TicketDAO.getTicketByUserId(userid);
        int rowid=0;
        for(Tickets ticket:list){
        Movies movies = moviesDAO.getbyid(ticket.getIdMovie());
        rowid++;
    %>
    <tr   style="text-align: center">
      <input type="hidden" id="pid" name="pid" value="<%=ticket.getPid()%>"/>
      <td><%=movies.getName()%></td>
      <td><%=ticket.getTickets()%></td>
      <td>

        <form action="Cancel?mid=<%=ticket.getIdMovie()%>&pid=<%=ticket.getPid()%>&uid=<%=userid%>" method="post">
        <input type="number" min="1" max="<%=ticket.getTickets()%>" name="cid" id="cid" required>
          <button type="submit">Cancel</button>
        </form>
      </td>

    </tr>
    <%}} catch (Exception e) {
      throw new RuntimeException(e);
    }%>
  </table>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>
