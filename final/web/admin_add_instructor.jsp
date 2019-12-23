<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/13
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,com.admin_dao.Admin" %>
<%@ page import="com.admin_dao.adminDAOImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加教师信息</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script>
        function check(form) {
            if(form.t_id.value==""||form.t_rank.value==""||form.course_id.value==""||form.dept_name1.value==""||form.intro.value==""){
                alert("不能为空!");
                return false;
            }
            if(!confirm("确认添加?")){
                window.event.returnValue=false;
            }
            return true;
        }
    </script>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        添加教师信息 请确保已注册教师
        <form action="add_instructor" method="post" onsubmit="return check(this)">
            <tr><td><font size="3" face="arial" color="purple">教师名称:</font></td>
                <td><select id="t_id" name="t_id">
                    <option value="">请选择:</option>
                    <c:forEach var="teachers" items="${requestScope.teachers}" varStatus="status">
                        <option value="${teachers.username}">${teachers.username}</option>
                    </c:forEach>
                </select></td></tr>
            <tr><td><font size="3" face="arial" color="purple">教师职称:</font></td>
                <td><input type="text" name="t_rank"></td></tr>
            <tr><td><font size="3" face="arial" color="purple">讲授课程:</font></td>
                <td><select id="course_id" name="course_id">
                    <option value="">请选择:</option>
                    <c:forEach var="course" items="${requestScope.course}" varStatus="status">
                        <option value="${course.course_id}">${course.course_id}</option>
                    </c:forEach></select></td></tr>
            <!--<input type="text" name="course_id">-->
            <tr><td><font size="3" face="arial" color="purple">所在学院:</font></td>
                <td><select id="dept_name1" name="dept_name1">
                    <option value="">请选择:</option>
                    <c:forEach var="dept" items="${requestScope.dept_name}" varStatus="status">
                        <option value="${dept.dept_name}">${dept.dept_name}</option>
                    </c:forEach>
                </select></td></tr>
            <tr><td><font size="3" face="arial" color="purple">教师简介:</font></td>
                <td><textarea name="intro" class="form-control" placeholder="教师简介" rows="3" cols="20"></textarea></td></tr>
            <tr><td><input type="submit" name="submit" value="提交" class="btn btn-outline-primary"></td>
                <td><input type="reset" name="reset" value="重置" class="btn btn-outline-light text-dark"></td></tr>
            <%=request.getAttribute("result")==null?"":request.getAttribute("result") %>
        </form>
    </table>
</div>

</body>
</html>
