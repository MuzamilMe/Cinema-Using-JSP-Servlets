<%@ page import="POJO.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col m6 offset-m3">
                <div class="card">
                <div class="card-content">
                    <h3 align="center" style="color: rgba(176,18,18,0.59)">Add Movie</h3>
                    <div class="form center-align">
                        <form action="AddMovie" method="post">
                        <input  name ="moviename" type="text" placeholder="Movie Name">
                        <input  name ="releasedate" type="date" placeholder="Release Date">
                        <input  name ="availabletickets" type="text" placeholder="Tickets Available">
            <button type="Submit" class="btn green center-align">Submit</button>
           </form>
           </div>
          </div>
          </div>
          </div>
</div></div>
            
                   <!-- comment -->           
   
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
