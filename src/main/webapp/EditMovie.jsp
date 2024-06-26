<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp</title>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">


    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    </head>
        <%@page import="java.sql.ResultSet"%>
        <%@page import="java.sql.Statement"%>
        <%@page import="java.sql.Connection"%>
        <%@ page import="helper.DBManager" %>
        <%@ page import="java.sql.PreparedStatement" %>

            <%
                         Connection connection = DBManager.getConnection();
                         PreparedStatement ps = null;
                         ResultSet resultSet = null;
                         %>
    <body>
        <div class="container">
            <div class="row">
                <div class="col m6 offset-m3">
                <div class="card">
                <div class="card-content">
                    <h3 align="center" style="color: cadetblue">Update Movie</h3>
                    <div class="form center-align">
                        <form action="Edit" method="get">
                                <%
                         try{
                             String id = request.getParameter("id");
                             DBManager.getConnection();
                         String sql ="SELECT * FROM movies where idMovies =?";
                         ps = connection.prepareStatement(sql);
                         ps.setString(1,id);
                         resultSet = ps.executeQuery();
                          if(resultSet.next()){
                         %>
                            <input type="hidden" id="id" name="id" value="<%=id%>">
                        <input  name ="moviename" type="text" placeholder="Movie Name" value="<%=resultSet.getString(2)%>">
                        <input  name ="releasedate" type="date" placeholder="Release Date" value="<%=resultSet.getString(3)%>">
                        <input  name ="availabletickets" type="text" placeholder="Tickets Available" value="<%=resultSet.getString(4)%>">
                            <%
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            %>
                            <button type="Submit" class="btn green center-align">Update</button>
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
