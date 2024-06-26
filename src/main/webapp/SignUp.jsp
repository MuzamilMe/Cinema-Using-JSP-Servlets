<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp</title>
        
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col m6 offset-m3">
                <div class="card">
                <div class="card-content">
                    <h3 style="color: steelblue" align="center">Register here</h3>
                    <div class="form center-align">
                        <form action="Register" method="post">
                        <input  name ="name" type="text" placeholder="First Name">
                        <input  name ="password" type="password" placeholder="Password">
                        <input  name ="contact" type="text" placeholder="contact">
                        <input  name ="email" type="email" placeholder="Email">
                            <p>
                                <label>
                                    <input name="role" type="radio" value="Admin"/>
                                    <span>Admin</span>
                                    <input name="role" type="radio" value="User" checked/>
                                    <span>USER</span>
                                </label>
                            </p>
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
