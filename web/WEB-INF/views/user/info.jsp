<%--
  Created by IntelliJ IDEA.
  User: jsdgw
  Date: 12/10/16
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>User Info</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="../../js/jquery-3.1.1.min.js"></script>

</head>
<body>
<div class="title">
    <h1>User Profile</h1>
</div>


<form:form action="/user/info" method="post" modelAttribute="userInfo">
    <c:forEach items="${requestScope.user}" var="user">
        <table>
            <tr>
                <td>
                    userName:
                </td>
                <td>
                        ${user.userName}
                </td>
            </tr>
            <tr>
                <td>
                    userNickname:
                </td>
                <td>
                        ${user.userNickname}
                </td>
            </tr>
            <tr>
                <td>
                    email:
                </td>
                <td>
                        ${user.email}
                </td>
            </tr>
            <tr>
                <td>
                    sex:
                </td>
                <td>
                        ${user.sex}
                </td>
            </tr>
            <tr>
                <td>
                    school:
                </td>
                <td>
                        ${user.school}
                </td>
            </tr>
            <tr>
                <td>
                    phoneNumber:
                </td>
                <td>
                        ${user.phoneNumber}
                </td>
            </tr>
            <tr>
                <td>
                    userInfo:
                </td>
                <td>
                        ${user.userInfo}
                </td>
            </tr>
            <tr>
                <td>
                    registrationDate:
                </td>
                <td>
                        ${user.registrationDate}
                </td>
            </tr>
        </table>

    <a href="../edit_user/${user.userId}">Edit</a>
    </c:forEach>

    <%--userName :<form:input path="userName"/>--%>
    <%--userNickname :<form:input path="userNickname"/> <br>--%>
    <%--sex <form:input path="sex"/> <br>--%>
    <%--email :<form:input path="email"/> <br>--%>
    <%--school :<form:input path="school"/> <br>--%>
    <%--work :<form:input path="work"/> <br>--%>
    <%--phoneNumber :<form:input path="phoneNumber"/> <br>--%>
    <%--userInfo :<form:textarea path="userInfo"/> <br>--%>
    <%--registrationDate :<form:input path="registrationDate"/> <br>--%>

</form:form>


</body>
</html>