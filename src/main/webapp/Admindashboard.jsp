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
                <li><a href="AddMovie.jsp">New Movie</a></li>
                <li><a href="Logout">Logout</a></li>
            </ul>
        </div>
    </nav>
    <p style="align-content: center"><b><i>${Success}</i></b></p>
    <p style="align-content: center"><b><i>${Fail}</i></b></p>
        <div class="container">
            <div class="row">
                <div class="col m12">
                <div class="card">
                <div class="sealed-graph">
                    <div class="form ">
                        <form action="LogoutServlet" method="get">
                            <%@ page import="POJO.Movies" %>
                            <%@ page import="java.util.List" %>
                            <%@ page import="DAO.moviesDAO" %>
                            <%@ page import="POJO.User" %>


                            <h2 style= background:#f2f2ea color: #2c9582 align="center"><font><strong><i>Movies</i></strong></font></h2>



                            <table align="center" cellpadding="5" cellspacing="5" border="1">

                         <tr bgcolor="#bbdefb">
                             <td><b>Movie Id</b></td>
                         <td><b>Movie Name</b></td>
                         <td><b>Release Date</b></td>
                         <td><b>Available Tickets</b></td>
                         <td><b>Action</b></td>

                         </tr>
                                <%
                                    List<Movies> list = moviesDAO.getadminmovie(user);
                                    for(Movies movies:list) {
                                %>

                                <tr bgcolor="#eceff1">
                         <input type="hidden" id="idMovies" name="idMovies" value="<%=movies.getId()%>" />
                             <td><%=movies.getId() %></td>
                         <td><%=movies.getName() %></td>
                         <td><%=movies.getReleaseDate() %></td>
                         <td><%=movies.getAvailabletickets() %></td>


                         <td>
                         <a href="DeleteMovie?mid=<%=movies.getId()%>">Delete</a>
                         <a href="EditMovie.jsp?id=<%=movies.getId()%>">Edit</a>
                         </td>

                         </tr>
                             <%
                                }
                             %>
                          </table>
                          <br>
           </form>
           </div>

          </div>
          </div>
          </div>
</div></div>

            <script>
  src="https://code.jquery.com/jquery-3.7.0.min.js"
  integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
  crossorigin="anonymous"></script>

  <script>
      $(document).ready(function(){
          console.log("Page is Ready")
      })
  </script>
    </body>
</html>
