<%--
  Created by IntelliJ IDEA.
  User: jsdgw
  Date: 12/12/16
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Your Info</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>Edit Your Info</h1>

<div class="auth-form" id="userDiv">
    <form:form action="${pageContext.request.contextPath}/user/editinfo/${requestScope.user.userId}" method="post" modelAttribute="user">
        <%--<div class="form-group">--%>
            <%--<label for='Nickname'>Nickname:</label>--%>
            <%--<input id="userNickname" name="userNickname" type="text" class='form-control' placeholder='Choose your nickname'/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for='UserName'>UserName:</label>--%>
            <%--<input id="userName" name="userName" type="text" class="form-control"/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for='E-mail'>E-mail:</label>--%>
            <%--<input id="email" name="email" type="Email" class='form-control' placeholder='Your E-mail'/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for='Password'>Password:</label>--%>
            <%--<input id="userPassword" name="userPassword" type="password" class='form-control' placeholder='Set your password'/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<label for="UserInfo">UserInfo:</label>--%>
            <%--<input id="userInfo" name="userInfo" type="textarea" class="form-control"/>--%>
        <%--</div>--%>
        <%--<div class="form-group">--%>
            <%--<button name="submit" class="btn btn-block btn-default" type="submit">--%>
                <%--Submit--%>
            <%--</button>--%>
        <%--</div>--%>


        <div class="form-group">
            <label for='Nickname'>Nickname:</label>
            <form:input path="userNickname"/>
        </div>
        <div class="form-group">
            <label for='UserName'>UserName:</label>
            <form:input path="userName"/>
        </div>
        <div class="form-group">
            <label for='E-mail'>E-mail:</label>
            <form:input path="email" />
        </div>
        <div class="form-group">
            <label for='Password'>Password:</label>
            <form:input path="userPassword" />
        </div>
        <div class="form-group">
            <label for="UserInfo">UserInfo:</label>
            <form:input path="userInfo" />
        </div>
        <div class="form-group">
            <input type="submit" value="Submit"/>
        </div>
    </form:form>
</div>
<script src="../../js/jquery-3.1.1.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
</body>
</html>
