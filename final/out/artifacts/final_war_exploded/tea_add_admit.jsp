<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/13
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加访问限制</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script>
        function alter() {
            if(!confirm("确认添加?")){
                window.event.returnValue=false;
            }
        }
    </script>
</head>
<body>

<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr><th>选择学生</th>
            <th>选择课程</th>
            <th>添加</th></tr>
        </thead>
        <form action="tea_add_admit" method="post" onsubmit="return check(this)">
            <td><select id="s_id" name="s_id" >
                <option value="">请选择:</option>
                <c:forEach var="s_id" items="${requestScope.stu_list}" varStatus="status">
                    <option value="${s_id.s_id}">${s_id.s_id}</option>
                </c:forEach>
            </select></td>
            <td><select id="course_id" name="course_id" >
                <option value="">请选择:</option>
                <c:forEach var="course_id" items="${requestScope.course_list}" varStatus="status">
                    <option value="${course_id.course_id}">${course_id.course_id}</option>
                </c:forEach>
            </select></td>
            <td><input type="submit" name="submit" value="添加" class="btn btn-outline-primary" onclick="alter()"></td>
        </form>
    </table>
</div>

</body>
</html>
