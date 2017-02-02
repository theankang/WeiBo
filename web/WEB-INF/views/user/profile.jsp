<%--
  Created by IntelliJ IDEA.
  User: jsdgw
  Date: 1/23/17
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is User Profile Page</title>
    <link href="/weibo/resources/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            text-align: center;
        }

        .table_div {
            margin: 0 auto;
            width: 500px;
        }

        .btn-primary {
            background-color: #555555;
        }
    </style>
</head>
<body>
<h1>This is User Profile Page</h1>
<div class="table_div">
    <table class="table table-hover">
        <tr>
            <td>
                头像
            </td>
            <td>
                <img src="/weibo/resources/images/profilephoto/${user.userProfilePhoto}"  alt="" />
            </td>
        </tr>
        <tr>
            <td>
                真实姓名
            </td>
            <td>
                ${user.userName}
            </td>
        </tr>
        <tr>
            <td>
                昵称
            </td>
            <td>
                ${user.userNickname}
            </td>
        </tr>
        <tr>
            <td>
                邮箱
            </td>
            <td>
                ${user.email}
            </td>
        </tr>
        <tr>
            <td>
                性别
            </td>
            <td>
                ${user.sex}
            </td>
        </tr>
        <tr>
            <td>
                工作
            </td>
            <td>
                ${user.work}
            </td>
        </tr>
        <tr>
            <td>
                学校
            </td>
            <td>
                ${user.school}
            </td>
        </tr>
        <tr>
            <td>
                手机号码
            </td>
            <td>
                ${user.phoneNumber}
            </td>
        </tr>
        <tr>
            <td>
                简介
            </td>
            <td>
                ${user.userInfo}
            </td>
        </tr>
        <tr>
            <td>
                注册日期
            </td>
            <td>
                ${user.registrationDate}
            </td>
        </tr>
    </table>
    <a class="btn btn-primary" href="#" role="button" style="float:left;margin-left:150px;">编辑</a>
    <a class="btn btn-primary" href="#" role="button" style="float:right;margin-right:150px;">修改密码</a>
</div>
<script src="/weibo/resources/js/lib/jquery-3.1.1.min.js"></script>
<script src="/weibo/resources/js/lib/bootstrap.min.js"></script>
</body>
</html>
