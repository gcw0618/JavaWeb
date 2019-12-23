<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/6
  Time: 14:27
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
    <title>学生提出问题</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script type="text/javascript">
        function check(form) {
            if (form.course_id.value == ""||form.s_que.value == "") {
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

    <%
        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = df.format(d);
    %>
<div class="container">
    <h4>当前时间：<%=now %></h4>
    <table class="table table-bordered">
        <thead>
        <tr><th>选择课程</th>
            <th>留言标题</th>
            <th>留言内容</th>
            <th>上传图片附件</th>
            <th>操作</th>
            <th>操作</th></tr>
        </thead>
        <tbody>
            <form action="./stu_add_message?s_id=${sessionScope.nowusername}" method="post" enctype="multipart/form-data" onsubmit="return check(this)">
                <td><select id="course_id" name="course_id">
                    <option value="">请选择:</option>
                    <c:forEach var="course" items="${requestScope.course_list}" varStatus="status">
                        <option value="${course.course_id}">${course.course_id}</option>
                    </c:forEach>
                    </select></td>
                <td><input type="text" name="title"></td>
                <td><textarea rows="10" cols="30" name="s_que"></textarea></td>
                <td><input type="file" name="image" size="30"></td>
                <td><input type="submit" name="submit" value="提交" class="btn btn-outline-primary"></td>
                <td><input type="reset" name="reset" value="重置" class="btn btn-outline-light text-dark"></td>
            </form>
        </tbody>
    </table>
</div>

</body>
</html>
