<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/2
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,com.admin_dao.Admin" %>
<%@ page import="com.admin_dao.adminDAOImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学院操作界面</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script type="text/javascript">
        function check(form) {
            if(form.alter_dept_name.value==""){
                alert("输入不能为空!");
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
    <table class="table table-hover">
        <thead>
            <tr><th>现有学院</th>
                <th>操作</th>
                <th>操作</th></tr>
        </thead>
        <tbody>
            <c:forEach var="dept" items="${requestScope.dept_name}" varStatus="status">
                <tr>
                    <td>${dept.dept_name}</td>
                    <td><form method="post" action="./delete_department?dept_name=${dept.dept_name}">
                            <input type="submit" value="删除" class="btn btn-outline-warning" onclick="del()">
                        </form>
                    </td>
                    <td><form method="post" action="./update_department?dept_name=${dept.dept_name}" onsubmit="return check(this)">
                            <font size="3" face="arial" >新的学院名称:</font>
                            <input type="text" name="alter_dept_name">
                            <input type="submit" value="更新" class="btn btn-outline-primary" onclick="alter()">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
