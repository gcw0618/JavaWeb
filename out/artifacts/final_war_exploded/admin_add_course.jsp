<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/13
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,com.admin_dao.Admin" %>
<%@ page import="com.admin_dao.adminDAOImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加课程</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script type="text/javascript">
        function check(form) {
            if(form.course_id.value==""||form.t_id.value==""||form.description.value==""||form.dept_name.value==""){
                alert("输入不能为空!");
                return false;
            }
            if(!confirm("确认添加?")){
                window.event.returnValue=false;
            }
        }
    </script>
</head>
<body>
<div class="modal-dialog" style="margin-top: 0%;">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title text-center" id="myModalLabel">管理课程</h4>
        </div>
        <div class="modal-body" id = "model-body">
            <div class="form-group">
                <form action="add_course" method="post" onsubmit="return check(this)">
                    <div class="form-group">
                        <input type="text" name="course_id" class="form-control" placeholder="课程名称">
                    </div>
                    <div class="form-group">
                        <select id="t_id" name="t_id">
                            <option value="">请选择授课教师:</option>
                            <c:forEach var="allteacher" items="${requestScope.instructor}" varStatus="status">
                                <option value="${allteacher.username}">${allteacher.username}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <textarea name="description" class="form-control" placeholder="课程内容描述" rows="3" cols="20"></textarea>
                    </div>
                    <div class="form-group">
                        <select id="dept_name" name="dept_name">
                            <option value="">请选择开课学院:</option>
                            <c:forEach var="dept" items="${requestScope.dept_name}" varStatus="status">
                                <option value="${dept.dept_name}">${dept.dept_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <input type="submit" name="submit" value="提交" class="btn btn-outline-primary">
                        <input type="reset" name="reset" value="重置" class="btn btn-outline-light text-dark">
                    </div>
                    <div><%=request.getAttribute("result")==null?"":request.getAttribute("result") %></div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
