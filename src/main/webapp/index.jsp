<%--
    Document   : login
    Created on : May 21, 2023, 4:28:04 PM
    Author     : Muzamil
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <nav>
        <div class="nav-wrapper " style="background: #2e9752">
            <a href="#!"  class="brand-logo center">Elysian Theaters</a>
            <ul class="right hide-on-med-and-down">

                <li><strong><a href="SignUp.jsp" style="font-size: large">Register</a></strong></li>
            </ul>
        </div>
    </nav>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
<div class="container">
    <p style="align-content: center"><b><i>${Register}</i></b></p>
    <div class="row">
        <div class="col m6 offset-m3">
            <div style="background: #141059" class="card">
                <div class="card-content">
<%--                    <h3 style="color: #2eb5a8" align="center">Login here</h3>--%>
                    <div class="form">
                        <form action="Login" method="post">
                            <label for="email">Email</label>
                            <input style="color: #f2f2ea" id="email" name ="email" type="text" placeholder="Enter Email" required><br>
                            <label for="password">Password</label>
                            <input style="color: #f2f2ea" id="password" name ="password" type="password" placeholder="Enter Password" required><br>
                            <p>
                                <label>
                                    <input name="role" type="radio" value="Admin"/>
                                    <span>Admin</span>
                                </label>
                                <label>
                                    <input name="role" type="radio" value="User" checked/>
                                    <span>USER</span>
                                </label>
                            </p><br>
                             <button type="Submit" class="btn green ">Login</button><br/><br/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div></div>
<script>
    src="https://code.jquery.com/jquery-3.7.0.min.js";
    integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=";
    crossorigin="anonymous"></script>

<script>
    $(document).ready(function(){
        console.log("Page is Ready");
    });
</script></body>
</html>
