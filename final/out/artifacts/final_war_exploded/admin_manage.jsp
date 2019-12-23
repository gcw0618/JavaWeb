<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/1
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#" ><h3>管理员${sessionScope.nowusername}</h3></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="admin_changepsw.jsp" target="mainFrame">修改密码</a>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="show_instructor" target="mainFrame" id="navbardrop1" data-toggle="dropdown">教师管理</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="show_instructor?opt=1" target="mainFrame">添加教师</a>
                <a class="dropdown-item" href="show_instructor?opt=2" target="mainFrame">添加教师信息</a>
                <a class="dropdown-item" href="show_instructor?opt=3" target="mainFrame">管理教师信息</a>
            </div>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="show_course" target="mainFrame" id="navbardrop2" data-toggle="dropdown">课程管理</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="show_course?opt=1" target="mainFrame">添加课程</a>
                <a class="dropdown-item" href="show_course?opt=2" target="mainFrame">管理课程</a>
            </div>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="show_department" target="mainFrame" id="navbardrop3" data-toggle="dropdown">学院管理</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="show_department?opt=1" target="mainFrame">添加学院</a>
                <a class="dropdown-item" href="show_department?opt=2" target="mainFrame">管理学院</a>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="show_message" target="mainFrame">留言管理</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="login.jsp">退出</a>
        </li>
    </ul>
</nav>

<div class="pageContent">
    <iframe src="" id="mainFrame" name="mainFrame"
            frameborder="0" width="100%"  height="100%" frameBorder="0">
    </iframe>
</div>

    
 
</body>
</html>
