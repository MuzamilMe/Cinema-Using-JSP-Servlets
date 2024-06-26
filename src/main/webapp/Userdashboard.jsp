<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </head>
    <body>
    <% User user = (User) session.getAttribute("user");%>
    <nav>
        <div class="nav-wrapper">
            <a href="#!"  class="brand-logo center">Elysian Theaters</a>
            <ul class="left hide-on-med-and-down">
                <li><a href="Logout">Logout</a></li>
                <li><a href="PurchasedTickets.jsp?id=<%=user.getId()%>">Your Tickets</a></li>
            </ul>
        </div>
    </nav>
<!-- <form action="Logout" method="post">-->
     <p style="align-content: center"><b><i>${Success}</i></b></p>
    <p style="align-content: center"><b><i>${CancelSuccess}</i></b></p>
     <p style="align-content: center"><b><i>${Fail}</i></b></p>
        <div class="container">
            <div class="row">
                <div class="card">
                    <div class="form">
                            <%@ page import="DAO.moviesDAO" %>
                            <%@ page import="java.util.List" %>
                            <%@ page import="POJO.Movies" %>
                            <%@ page import="POJO.User" %>
                        <table>
                             <thead>
                             <h2 style="background:#f2f2ea; text-align: center"><font><strong><i>Movies</i></strong></font></h2>
                         <tr>
                         <td><b>Movie Name</b></td>
                         <td><b>Release Date</b></td>
                         <td><b>Available Tickets</b></td>
                             <td><b>Buy Tickets</b></td>
                         </tr>
                         </thead>
                         <%
                             List<Movies> list = moviesDAO.getall();
                              for(Movies movies:list) {
                         %>
                         <tr style="text-align: center">
                             <input type="hidden" id="idMovies" name="idMovies" value="<%=movies.getId()%>"/>
                         <td><%=movies.getName()%></td>
                         <td><%=movies.getReleaseDate()%></td>
                         <td><%=movies.getAvailabletickets()%></td>
                             <td>
                                 <form action="MovieBuy?mid=<%=movies.getId()%>" method="post">
                                     <input  name ="tickets" type="number"  placeholder="Enter Tickets" min="1" max="<%=movies.getAvailabletickets()%>" required>
                                     <button type="submit">Buy</button>
                                 </form>
                             </td>
                         </tr>
                          <%}%>
                          </table>
<!--           </form>-->
           </div>
          </div>
          </div>
</div>

            <script src="https://code.jquery.com/jquery-3.7.0.min.js">
  integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
  crossorigin="anonymous"></script>

  <script>
      $(document).ready(function(){
          console.log("Page is Ready")
      })
  </script>
    </body>
</html>
