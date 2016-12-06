<%--
  Created by IntelliJ IDEA.
  User: jsdgw
  Date: 11/22/16
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/login.css"/>

    <style>
        body {
            padding-top: 50px;
        }
    </style>

</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">

        <div class="navbar-header">
            <a class="navbar-brand" href="#">Home</a>

            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <div class = "collapse navbar-collapse" id = "navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="register.jsp">Sign Up</a></li>
                <li><a href="login.jsp">Log In</a></li>
            </ul>
        </div>

    </div>
</nav>

<div class="title">
    <h1>Please Log in</h1>
</div>

<div class="auth-form" id='login'>
    <form role='form' method="post" target=" ">
        <div class="form-group">
            <label for='ID'>ID:</label>
            <input type="text" class='form-control' placeholder='Your id'/>
        </div>
        <div class="form-group">
            <label for='Password'>Password:</label>
            <input type="password" class='form-control' placeholder='Your password'/>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox"> Remeber me
            </label>
        </div>
        <div class="form-group">
            <button class="btn btn-block btn-primary" type="submit">
                Log in
            </button>
        </div>
    </form>
</div>

<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>