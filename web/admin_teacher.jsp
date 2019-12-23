<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/2
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,com.admin_dao.Admin" %>
<%@ page import="com.admin_dao.adminDAOImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理教师界面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script>
        function check(form) {
            if(form.update_instructor_rank.value==""||form.update_instructor_course_id.value==""||form.update_instructor_intro.value==""||form.dept_name2.value==""){
                alert("不能为空!");
                return false;
            }
            if(!confirm("确认更新?")){
                window.event.returnValue=false;
            }
            return true;
        }
    </script>
    <script>
        function del() {
            if(!confirm("确认删除?")){
                window.event.returnValue=false;
            }
        }
    </script>
</head>
<body>
<center>
    <div class="container">
        <table class="table table-striped">
            <tr><th>现有教师姓名</th>
                <th>教师职称</th>
                <th>教师课程</th>
                <th>教师简介</th>
                <th>学院名称</th>
                <th>操作</th>
                <th>更新</th></tr>
            <c:forEach var="instructor" items="${requestScope.instructor_list}" varStatus="status">
            <tr>
                <td>${instructor.username}</td>
                <td>${instructor.rank}</td>
                <td>${instructor.course_id}</td>
                <td>${instructor.description}</td>
                <td>${instructor.dept_name}</td>
                <td><form method="post" action="./delete_instructor?username=${instructor.username}&course_id=${instructor.course_id}">
                    <input type="submit" value="删除" class="btn btn-outline-warning" onclick="del()">
                    <%=request.getAttribute("result")==null?"":request.getAttribute("result") %>
                </form>
                </td>
                <td><form method="post" action="./update_instructor?username=${instructor.username}" onsubmit="return check(this)">
                    <p><font size="3" face="arial" >教师职称:</font><input type="text" name="update_instructor_rank"></p>
                    <p><font size="3" face="arial" >教师课程:</font>
                        <select id="update_instructor_course_id" name="update_instructor_course_id">
                            <option value="">请选择:</option>
                            <c:forEach var="course" items="${requestScope.course}" varStatus="status">
                              <option value="${course.course_id}">${course.course_id}</option>
                            </c:forEach>
                        </select></p>
                    <p><font size="3" face="arial" >教师简介:</font><input type="text" name="update_instructor_intro"></p>
                    <p><font size="3" face="arial" >教师学院:</font>
                        <select id="dept_name2" name="dept_name2">
                        <option value="">请选择:</option>
                        <c:forEach var="dept" items="${requestScope.dept_name}" varStatus="status">
                            <option value="${dept.dept_name}">${dept.dept_name}</option>
                        </c:forEach>
                        </select>
                    </p>
                    <input type="submit" value="更新" class="btn btn-outline-primary" onclick="alter()">
                    <%=request.getAttribute("result")==null?"":request.getAttribute("result") %>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</center>
</body>
</html>
