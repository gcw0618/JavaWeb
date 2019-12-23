<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/6
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生注册</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css\CSS.css">
    
    <script type="text/javascript">
        var xmlHttp;
        function validate() {
            var username = document.getElementById("username");
            var url = "checkregister?username=" + escape(username.value);
            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            }else{
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlHttp.open("GET", url, true);
            xmlHttp.onreadystatechange = callback;
            xmlHttp.send(null);
        }
        function callback() {
            if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
                var check = xmlHttp.responseText;
                show (check);
            }
        }
        function show(str) {
            if(str == "OK") {
                var show = "<font color='green'>用户名可用！</font>";
                document.getElementById("info").innerHTML = show;
            }
            else if( str == "NO") {
                var show = "<font color='red'>用户名不可用！</font>";
                document.getElementById("info").innerHTML = show;
            }
        }
    </script>
    <script>
        function check(form) {
            if(form.username.value==""||form.password.value==""){
                alert("不能为空!");
                return false;
            }
            if(form.username.value!=form.password2.value){
                alert("密码不一致!");
                return false;
            }
            if(!confirm("确认注册?")){
                window.event.returnValue=false;
            }
            return true;
        }
    </script>
    
</head>
<body>

<div class="modal-dialog" style="margin-top: 10%;">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title text-center" id="myModalLabel">学生注册</h4>
        </div>
        <div class="modal-body" id = "model-body">
            <div class="form-group">
                <form action="stu_register" method="post" onsubmit="return check(this)">
                        <div class="form-group">
                            <input type="text" name="username" id="username" class="form-control"placeholder="用户名" autocomplete="off" onblur="validate()">
                            <span id="info"></span>
                        </div>
                        
                        <div class="form-group">
                            <input type="text" name="password" class="form-control" placeholder="密码" autocomplete="off">
                        </div>
                    <div class="form-group">
                        <input type="text" name="password2" class="form-control" placeholder="再次输入密码" autocomplete="off">
                    </div>
                    <div class="modal-footer">
                        <div class="form-group">
                        <tr><td><input type="submit" name="submit" value="注册" class="btn btn-outline-primary"></td>
                            <td><input type="reset" name="reset" value="重置" class="btn btn-outline-light text-dark"></td></tr>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="form-group">
                            <a class="btn btn-primary btn-sm" href="login.jsp" role="button">返回登入</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
