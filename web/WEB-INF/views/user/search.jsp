<%--
  Created by IntelliJ IDEA.
  User: jsdgw
  Date: 12/11/16
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Search User</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="auth-form" id='login'>
    <form:form role='form' method="post" action="/user/search">

        <div class="form-group">
            <label for='userNickname'>Nickname:</label>
            <input id="userNickname" type="text" class='form-control' placeholder='Nickname'/>
        </div>

        <div class="form-group">
            <button class="btn btn-block btn-default" type="submit">
                Log in
            </button>
        </div>
    </form:form>
</div>

<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>
</html>
