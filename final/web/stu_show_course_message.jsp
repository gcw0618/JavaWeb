<%@ page import="com.student_dao.Stu" %>
<%@ page import="com.page.PageModel" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/8
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
    <!-- 新 Bootstrap4 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <!-- bootstrap.bundle.min.js 用于弹窗、提示、下拉菜单，包含了 popper.min.js -->
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <!-- 最新的 Bootstrap4 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
</head>
<body>

<center>
    <div class="container">
        <table class="table table-striped">
            <tr><th>课程名称</th>
                <th>课程信息</th>
                <th>课程所在学院</th></tr>
            <c:forEach var="course" items="${requestScope.course_info}" varStatus="status">
                <td>${course.course_id}</td>
                <td>${course.description}</td>
                <td>${course.dept_name}</td>
            </c:forEach>
        </table>
    </div>
<p></p>
    <div class="container">
        <table class="table table-striped">
            <tr><th>留言标题</th>
                <th>留言学生</th>
                <th>留言信息</th>
                <th>回复教师</th>
                <th>回复信息</th></tr>
            <c:forEach var="message" items="${requestScope.message_list}" varStatus="status">
                <tr><td>${message.title}</td>
                <td>${message.s_id}</td>
                <td>${message.s_que}</td>
                <td>${message.t_id}</td>
                <td>${message.t_ans}</td></tr>
            </c:forEach>
        </table>
    </div>

</center>


</body>
</html>
