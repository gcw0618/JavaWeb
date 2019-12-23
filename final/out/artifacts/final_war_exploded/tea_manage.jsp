<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/8
  Time: 0:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
</head>
<body>

<nav class="navbar navbar-expand-sm bg-danger navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#" ><h3>教师${sessionScope.nowusername}</h3></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tea_changepsw.jsp" target="mainFrame">修改密码</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tea_show_new_message" target="mainFrame">显示未回复信息</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tea_show_his_course" target="mainFrame">显示所教的课程</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tea_show_ans" target="mainFrame">显示自己回复的留言</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="tea_show_all_message" target="mainFrame">显示所有留言</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="tea_manage_admit" target="mainFrame">管理学生访问</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="tea_manage_admit?opt=1" target="mainFrame">添加</a>
                <a class="dropdown-item" href="tea_manage_admit?opt=2" target="mainFrame">删除</a>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="login.jsp">退出</a>
        </li>
    </ul>
</nav>

<div class="pageContent">
    <iframe src="" id="mainFrame" name="mainFrame" frameborder="0" width="100%"  height="100%" frameBorder="0"></iframe>
</div>
        
</body>
</html>
