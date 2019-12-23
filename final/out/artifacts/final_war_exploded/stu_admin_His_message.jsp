<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/7
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.*,com.admin_dao.Admin" %>
<%@ page import="com.admin_dao.adminDAOImpl" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理自己留言</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <script type="text/javascript">
        function check(form) {
            if(form.opt1.value==""||form.opt2.value==""||form.title.value==""||form.s_que.value==""){
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

<div class="container">
    <table class="table table-bordered">
        <thead>
            <tr><th>留言标题</th>
                <th>是否修改</th>
                <th>修改标题</th>
                <th>留言内容</th>
                <th>是否修改</th>
                <th>修改内容</th>
                <th>图片</th>
                <th>提交</th>
                <th>重置</th>
                <th>删除</th></tr>
        </thead>
        <tbody>
        <c:forEach var="message" items="${requestScope.message_list}" varStatus="status">
            <tr>
                <form action="./stu_update_message?old_title=${message.title}" method="post" >
                    <td>${message.title}</td>
                    <td><input type="radio" name="opt1" value="yes" checked>是
                        <input type="radio" name="opt1" value="no" >否</td>
                    <td><textarea rows="10" cols="30" name="title"></textarea></td>
                    <td>${message.s_que}</td>
                    <td><input type="radio" name="opt2" value="yes" checked>是
                        <input type="radio" name="opt2" value="no" >否</td>
                    <td><textarea rows="10" cols="30" name="s_que"></textarea></td>
                    <td><c:if test="${not empty message.s_pic}">
                        <img alt="" src="/stu_pic/${message.s_pic}" style="width:450px;height:300px;"/>
                    </c:if></td>
                    
                    <td><input type="submit" name="submit" value="提交" class="btn btn-outline-primary" onsubmit="return check(this)"></td>
                    <td><input type="reset" name="reset" value="重置" class="btn btn-outline-light text-dark"></td>
                </form>
                <form action="./stu_delete_message?old_title=${message.title}" method="post">
                    <td><input type="submit" name="submit" value="删除" class="btn btn-outline-warning" onclick="del()"></td>
                </form>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
        

</body>
</html>
