<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/6
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生界面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">

</head>
<body>

<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="#" ><h3>学生${sessionScope.nowusername}</h3></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="stu_changepsw.jsp" target="mainFrame">修改密码</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="stu_show_t_ans" target="mainFrame">显示新的教师回答</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="stu_show_course?opt=s_que" target="mainFrame">提出问题</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="stu_admin_message" target="mainFrame">管理自己的留言</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="stu_show_course?opt=course" target="mainFrame">显示所有留言</a>
        </li>
        <!--<li class="nav-item">
            <a class="nav-link" href="stu_find_course" target="mainFrame">显示课程列表</a>
        </li>-->
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
