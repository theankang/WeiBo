<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Created by IntelliJ IDEA.
 User: jsdgw
 Date: 1/23/17
 Time: 1:01
 To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>This is User Home Page</title>
    <link href="/weibo/resources/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            padding-top: 50px;
        }

        .content {
            margin-top: 30px;
        }

        .btn-toolbar {
            margin-top: 10px;
        }
    </style>
</head>
<body>
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

        <div class="collapse navbar-collapse" id="navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a
                        href="/weibo/user/${sessionScope.user.userId}/profile">${sessionScope.user.userNickname}</a>
                </li>
                <li><a href="/weibo/user/logout">Log Out</a></li>
            </ul>
        </div>

    </div>
</nav>

<div class="container content">
    <div class="row clearfix">
        <div class="col-md-3">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">我的分组</div>

                <div class="list-group">
                    <c:forEach items="${user.attentionGroupSet}" var="attentionGroup">
                        <a href="#" class="list-group-item">${attentionGroup.attentionGroupName}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <form action="/weibo/user/${user.userId}/msg/add" id="WB_publish_box" method="post">
            <textarea name="messageContent" rows="8" cols="75">有什么新鲜事想告诉大家?</textarea>
            </form>
            <div class="btn-toolbar" role="toolbar" aria-label="...">
                <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default">表情</button>
                    <button type="button" class="btn btn-default">图片</button>
                    <button type="button" class="btn btn-default">视频</button>
                    <button type="button" class="btn btn-default">话题</button>
                    <button type="button" class="btn btn-default">头条文章</button>
                </div>
                <div class="btn-group" role="group" aria-label="...">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                        公开 <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li><a href="#">公开</a></li>
                        <li><a href="#">好友圈</a></li>
                        <li><a href="#">仅自己可见</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">群可见</a></li>
                    </ul>
                </div>
                <div class="btn-group " role="group" aria-label="...">
                    <button type="button" class="btn btn-default" onclick="document.getElementById('WB_publish_box').submit();">发布</button>
                </div>
            </div>
            <div class="media">
                <div class="media-left media-Top">
                    <a href="#">
                        <img class="media-object" width="64" height="64"
                             src="/weibo/resources/images/profilephoto/${user.userProfilePhoto}" alt="...">
                    </a>
                </div>
                <div class="media-body">
                    <h4 class="media-heading">Hyuna</h4>
                    【金泫雅将出演28日KBS2的《Happy together3》】在展现音乐方面成长的新专辑《A’wesome》中，
                    时隔1年回归的泫雅参与了五首歌曲的作词，同时Lsle Qim、韩海等独立Hip-pop代表歌手也奖参与到专辑的制作中，
                    为泫雅出击新专辑应援。泫雅的第五张迷你专辑《A’wesome》将于8月1日零点在各大音源网站公开。 ​
                </div>
            </div>
        </div>
        <div class="col-md-3">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="thumbnail">
                        <img src="/weibo/resources/images/profilephoto/${user.userProfilePhoto}" alt=""/>
                    </div>
                        <ul class="list-group">
                            <li class="list-group-item">
                                <span class="badge">14</span>
                                关注
                            </li>
                            <li class="list-group-item">
                                <span class="badge">14</span>
                                粉丝
                            </li>
                            <li class="list-group-item">
                                <span class="badge">14</span>
                                <a href="${pageContext.request.contextPath}/user/${user.userId}/all_weibos">微博</a>
                            </li>
                        </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="/weibo/resources/js/lib/jquery-3.1.1.min.js"></script>
<script src="/weibo/resources/js/lib/bootstrap.min.js"></script>
</body>
</html>
