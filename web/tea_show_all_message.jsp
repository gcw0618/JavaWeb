<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/10
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示所有留言</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script>
        function del() {
            if(!confirm("确认删除?")){
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
            <th>删除</th></tr>
        </thead>
        <c:forEach var="message" items="${requestScope.message_list}" varStatus="status">
            <tr>
                <td>${message.title}</td>
                <td>${message.s_id}</td>
                <td>${message.s_que}</td>
                <td><form action="tea_delete_message?title=${message.title}&s_id=${message.s_id}" method="post">
                    <input type="submit" name="submit" value="删除" class="btn btn-outline-warning" onclick="del()">
                </form> </td>
            </tr>
        </c:forEach>
    </table>
</div>>

</body>
</html>
