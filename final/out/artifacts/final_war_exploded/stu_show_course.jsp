<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/8
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
            if((form.course_id.value!=""&&form.t_id.value==""&&form.dept.value==""&&form.word.value=="")||
                (form.course_id.value==""&&form.t_id.value!=""&&form.dept.value==""&&form.word.value=="")||
                (form.course_id.value==""&&form.t_id.value==""&&form.dept.value!=""&&form.word.value=="")||
                (form.course_id.value==""&&form.t_id.value==""&&form.dept.value==""&&form.word.value!="")||
                (form.course_id.value==""&&form.t_id.value==""&&form.dept.value==""&&form.word.value==""))
                return true;
            else{
                alert("单选!");
                return false;
            }
        }
    </script>
</head>
<body>

<div class="container">
    <h4>单选</h4>
    <table class="table table-bordered">
        <thead>
            <tr><th>选择课程查看</th>
                <th>选择回复老师查看</th>
                <th>选择学院查看</th>
                <th>选择关键词查看</th>
                <th>选择</th></tr>
        </thead>
        <tbody> 
            <form action="./stu_show_course_info" method="post" onsubmit="return check(this)">
            <td><select id="course_id" name="course_id">
                <option value="">查看所有留言:</option>
                <c:forEach var="course" items="${requestScope.course_list}" varStatus="status">
                    <option value="${course.course_id}">${course.course_id}</option>
                </c:forEach>
                </select></td>
                <td><select id="t_id" name="t_id">
                    <option value="">查看所有留言:</option>
                    <c:forEach var="instructor" items="${requestScope.instructor_list}" varStatus="status">
                        <option value="${instructor.username}">${instructor.username}</option>
                    </c:forEach>
                    </select></td>
                <td><select id="dept_name" name="dept_name">
                    <option value="">查看所有留言:</option>
                    <c:forEach var="dept" items="${requestScope.dept_list}" varStatus="status">
                        <option value="${dept.dept_name}">${dept.dept_name}</option>
                    </c:forEach>
                    </select></td>
                <td><input type="text" id="word" name="word"></td>
                <td><input type="submit" name="submit" value="提交" class="btn btn-outline-primary"></td>
            </form>
        </tbody>
    </table>
</div>

</body>
</html>
