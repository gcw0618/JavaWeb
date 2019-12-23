<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/3
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,com.admin_dao.Admin" %>
<%@ page import="com.admin_dao.adminDAOImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>增加课程信息</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script type="text/javascript">
        function check(form) {
            if(form.description.value==""||form.dept_name2.value==""||form.description.value==""||form.dept_name.value==""){
                alert("请输入，不能为空!");
                return false;
            }
        }
    </script>
    <script>
        function del() {
            if(!confirm("确认删除?")){
                window.event.returnValue=false;
            }
        }
        function alter() {
            if(!confirm("确认更新?")){
                window.event.returnValue=false;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <table class="table table-bordered">
        <thead>
            <tr><th>课程名称</th>
                <th>课程内容描述</th>
                <th>开课学院</th>
                <th>删除</th>
                <th>课程内容描述</th>
                <th>开课学院</th>
                <th>更新</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="course" items="${requestScope.course}" varStatus="status">
            <tr>
                <td>${course.course_id}</td>
                <td>${course.description}</td>
                <td>${course.dept_name}</td>
                <td><form method="post" action="./delete_instructor_course?username=${course.username}&course_id=${course.course_id}">
                    <input type="submit" value="删除" class="btn btn-outline-warning" onclick="del()"></form></td>
                <form method="post" action="./update_course?course_id=${course.course_id}" onsubmit="return check(this)">
                <td><textarea name="description" class="form-control" placeholder="课程内容描述" rows="3" cols="20"></textarea></td>
                <td><font size="3" face="arial" >开课学院:
                    <select id="dept_name2" name="dept_name2">
                        <option value="">请选择:</option>
                        <c:forEach var="dept" items="${requestScope.dept_name}" varStatus="status">
                            <option value="${dept.dept_name}">${dept.dept_name}</option>
                        </c:forEach>
                    </select></font>
                </td>
                <td><input type="submit" value="更新" class="btn btn-outline-primary" onclick="alter()"></td>
                <%=request.getAttribute("updateresult")==null?"":request.getAttribute("updateresult") %>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
