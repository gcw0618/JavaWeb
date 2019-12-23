<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/6
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script type="text/javascript">
        function check(form) {
            if(form.password1.value==""||form.password2.value==""){
                alert("请输入密码!");
                return false;
            }
            if(form.password2.value!=form.password1.value) {
                alert("密码不一致!");
                return false;
            }
            return true;
        }
    </script>
    <script>
        function alter() {
            if(!confirm("确认更新?")){
                window.event.returnValue=false;
            }
        }
    </script>

</head>
<body>

<div class="modal-dialog" style="margin-top: 10%;">
    <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title text-center" id="myModalLabel">修改密码</h4>
        </div>
        <div class="modal-body" id = "model-body">
            <div class="form-group">
            <form action="stu_changepsw" method="post" onsubmit="return check(this)">
                <div class="form-group">
                    <td><input type="text" name="password1" class="form-control" placeholder="新密码"></td></tr>
                </div>
                <div class="form-group">
                    <td><input type="text" name="password2" class="form-control" placeholder="再输一次密码"></td></tr>
                </div>
                <div class="modal-footer">
                    <div class="form-group">
                        <td><input type="submit" name="submit" value="提交" class="btn btn-outline-primary" onclick="alter()"></td>
                        <td><input type="reset" name="reset" value="重置" class="btn btn-outline-light text-dark"></td></tr>
                        <div><%=request.getAttribute("result")==null?"":request.getAttribute("result") %></div>
                    </div>
                </div>
            </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
