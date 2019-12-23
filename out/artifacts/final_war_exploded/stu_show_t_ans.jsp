<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/8
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,com.student_dao.*" %>
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


<div class="container">
    <h4>共${requestScope.que_list.size()}条新留言</h4>
    <table class="table table-bordered">
        <thead>
        <tr><th>标题</th>
            <th>问题</th>
            <th>图片</th>
            <th>教师回答</th>
            <th>图片</th></tr>
        </thead>
        <tbody>
        <c:forEach var="que" items="${requestScope.que_list}" varStatus="status">
        <tr>
            <td>${que.title}</td>
            <td>${que.s_que}</td>
            <td><c:if test="${not empty que.s_pic}">
                <img alt="" src="/stu_pic/${que.s_pic}" style="width:450px;height:300px;"/>
            </c:if></td>
            <td>${que.t_ans}</td>
            <td><c:if test="${not empty que.t_pic}">
                <img alt="" src="/stu_pic/${que.t_pic}" style="width:450px;height:300px;"/>
            </c:if></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
