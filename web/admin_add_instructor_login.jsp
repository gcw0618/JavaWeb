<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/13
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加教师</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script type="text/javascript">
        function check(form) {
            if(form.username.value==""||form.password.value==""){
                alert("不能为空!");
                return false;
            }
            if(!confirm("确认添加?")){
                window.event.returnValue=false;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <table class="table table-striped">
        添加老师账户
        <form action="addteacherlogin" method="post" onsubmit="return check(this)">
            <tr><td><font size="3" face="arial" color="red">用户名:</font></td>
                <td><input type="text" name="username"></td></tr>
            <tr><td><font size="3" face="arial" color="red">密码:</font></td>
                <td><input type="text" name="password"></td></tr>
            <tr><td><input type="submit" name="submit" value="提交" class="btn btn-outline-primary"></td>
                <td><input type="reset" name="reset" value="重置" class="btn btn-outline-light text-dark"></td></tr>
            <%=request.getAttribute("result")==null?"":request.getAttribute("result") %>
        </form>
    </table>
</div>

</body>
</html>
