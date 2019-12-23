<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/8
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,com.admin_dao.Admin" %>
<%@ page import="com.admin_dao.adminDAOImpl" %>
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
            if(form.dept.value!=""&&form.instructor.value!=""){
                alert("单选!");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>



<div class="container">
    <h4>单选查找课程</h4>
    <table class="table table-bordered">
        <thead>
            <tr><th>按照学院名字</th>
                <th>按照教师名字</th>
                <th>查找</th></tr>
        </thead>
        <form action="stu_search_course" method="post" onsubmit="return check(this)">
            <td><select id="dept" name="dept">
                <option value="">请选择:</option>
                <c:forEach var="dept" items="${requestScope.dept_list}" varStatus="status">
                    <option value="${dept.dept_name}">${dept.dept_name}</option>
                </c:forEach>
            </select></td>
            <td><select id="instructor" name="instructor">
                <option value="">请选择:</option>
                <c:forEach var="instructor" items="${requestScope.instructor_list}" varStatus="status">
                    <option value="${instructor.username}">${instructor.username}</option>
                </c:forEach>
            </select></td>

           
            <td><input type="submit" name="submit" value="查找"></td>
            
        </form>
    </table>
</div>>
<div class="container">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>课程</th>
            <th>查看留言</th></tr>
        </thead>
        <tbody>
            <c:forEach var="course" items="${course_list}" varStatus="status">
                <tr><td>${course.course_id}</td>
                    <td><form action="stu_show_course_message?course_id=${course.course_id}" method="post">
                        <input type="submit" name="submit" value="查看" class="btn btn-outline-primary">
                    </form></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>



</body>
</html>
