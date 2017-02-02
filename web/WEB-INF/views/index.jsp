<%--
  Created by IntelliJ IDEA.
  User: jsdgw
  Date: 11/21/16
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Weibo Home</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            padding-top: 50px;
        }

        .carousel {
            height: 750px;
            background-color: #000;
        }

        .carousel .item {
            height: 750px;
            background-color: #000;
        }

        .carousel img {
            width: 100%;
        }

        .carousel-caption p {
            margin-bottom: 20px;
            font-size: 20px;
            line-height: 1.8;
        }

    </style>

</head>
<body>

<spring:url value="/index" var="userActionUrl"/>

<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">

        <div class="navbar-header">
            <a class="navbar-brand" href="index">Home</a>

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
                <li class="active"><a href="register">Sign Up</a></li>
                <li><a href="login">Log In</a></li>
            </ul>
        </div>

    </div>
</nav>

<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="images/index_carousel_1.jpg" alt="1 slide">
            <div class="carousel-caption">
                <h1>Weibo</h1>
                <p>A new way to explore the world</p>
            </div>
        </div>
        <div class="item">
            <img src="images/index_carousel_1.jpg" alt="1 slide">
            <div class="carousel-caption">
                <h1>Weibo</h1>
                <p>A new way to explore the world</p>
            </div>
        </div>
        <div class="item">
            <img src="images/index_carousel_1.jpg" alt="1 slide">
            <div class="carousel-caption">
                <h1>Weibo</h1>
                <p>A new way to explore the world</p>
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>