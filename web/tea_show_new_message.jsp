<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/9
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
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
    <script type="text/javascript">
        function check(form) {
            if (form.t_ans.value == "") {
                alert("不能为空!");
                return false;
            }
            if(!confirm("确认回复?")){
                window.event.returnValue=false;
            }
        }
    </script>
</head>
<body>

<div class="container">
    <h4>共${requestScope.message_list.size()}条新留言</h4>
    <table class="table ">
        <thead>
        <tr><th>留言标题</th>
            <th>留言学生</th>
            <th>留言内容</th>
            <th>图片</th>
            <th>课程</th>
            <th>回复内容</th>
            <th>添加图片</th>
            <th>回答</th></tr>
        </thead>
        <tbody>
        <c:forEach var="message" items="${requestScope.message_list}" varStatus="status">
        <tr>
            <td>${message.title}</td>
            <td>${message.s_id}</td>
            <td>${message.s_que}</td>
            <td><c:if test="${not empty message.s_pic}">
                <img alt="" src="/stu_pic/${message.s_pic}" style="width:450px;height:300px;"/>
            </c:if></td>
            <td>${message.course_id}</td>
            <form action="./tea_ans_message?s_id=${message.s_id}&title=${message.title}" method="post" enctype="multipart/form-data" onsubmit="return check(this)">
                <td><textarea rows="10" cols="30" name="t_ans"></textarea></td>
                <td><input type="file" name="image" size="30"></td>
                <td><input type="submit" name="submit" value="回复" class="btn btn-outline-primary"></td>
            </form>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


</body>
</html>
