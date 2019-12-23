<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/9
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示课程的留言</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script>
        function check(form) {
            if(form.t_ans.value==""){
                alert("不能为空!");
                return false;
            }
            if(!confirm("确认提交?")){
                window.event.returnValue=false;
            }
        }
    </script>
</head>
<body>

<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr><th>留言标题</th>
            <th>留言学生</th>
            <th>留言内容</th>
            <th>教师回复</th>
            <th>提交</th></tr>
        </thead>
        <tbody>
        <C:forEach var="message" items="${requestScope.message_list}" varStatus="status">
            <form action="tea_ans_message?title=${message.title}&s_id=${message.s_id}" method="post" onsubmit="return check(this)">
            <tr>
                <td>${message.title}</td>
                <td>${message.s_id}</td>
                <td>${message.s_que}</td>
                <td><textarea rows="10" cols="30" name="t_ans"></textarea></td>
                <td><input type="submit" name="submit" value="提交" class="btn btn-outline-primary"></td>
            </tr>
            </form>
        </C:forEach></tbody>
    </table>
</div>

</body>
</html>
