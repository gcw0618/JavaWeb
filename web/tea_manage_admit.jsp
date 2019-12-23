<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/10
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理学生访问</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script type="text/javascript">
        function check(form) {
            if(form.s_id.value==""||form.course_id==""){
                alert("请输入课程名称!");
                return false;
            }
            return true;
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
            <td><input type="submit" name="submit" value="添加"></td>
        </form>
    </table>
</div>

    <div><table border="1">
        <tr><th>学生</th>
            <th>课程</th>
            <th>删除</th></tr>
        <c:forEach var="admit" items="${requestScope.admit_stu}" varStatus="status">
            <tr><td>${admit.s_id}</td>
                <td>${admit.course_id}</td>
                <form action="tea_delete_admit?s_id=${admit.s_id}&course_id=${admit.course_id}" method="post" >
                    <td><input type="submit" name="submit" value="删除" class="btn btn-outline-warning"></td>
                </form>
            </tr>
        </c:forEach>
    </table></div>


</body>
</html>
