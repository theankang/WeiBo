<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jsdgw
  Date: 1/27/17
  Time: 0:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is ALL WEIBOS Page</title>
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h1>This is ALL WEIBOS Page</h1>
<div class="container content">
    <div class="row clearfix">
        <div class="col-md-3">
        </div>
        <div class="col-md-6">
            <c:forEach items="${user.messageSet}" var="message">
                <div class="media">
                    <div class="media-left media-Top">
                        <a href="#">
                            <img class="media-object" width="64" height="64"
                                 src="/weibo/resources/images/profilephoto/${user.userProfilePhoto}" alt="...">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">${user.userNickname}</h4>
                            ${message.messageContent} ​
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
