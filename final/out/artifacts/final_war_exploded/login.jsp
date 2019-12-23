<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/11/29
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登入</title>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="CSS.css">
    <style>
        a:hover {
            COLOR: #0099cc; TEXT-DECORATION: none;
        }
        body {
            background-image: url(/image/mainPageImg.jpg);
            no-repeat;
            list-style: none;
            /*去掉ui和li的 点*/
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            background-attachment: fixed;
            background-position: center bottom;
            color: #fff;
            background-color: #333;
            font-family: 'microsoft yahei', Arial, sans-serif;
        }

       

        .dropdown-menu>li>a:hover,
        .dropdown-menu>li>a:focus {
            color: #fff !important;
            background-color: #fff0 !important;
            font-size: 19px;
        }

        .dropup .dropdown-menu {
            background-color: #fff0 !important;
            text-decoration: none;
            margin-bottom: 10px;
            border: 0px;
            border-radius: 16px 16px 0px 0px;
            box-shadow: none;
            margin-bottom: 14px;
        }

        .dropdown-menu>li>a {
            color: #fff;
            padding: 12px;
            font-weight: bolder;
        }

       
        .modal-content {
            background-color: #afd2ff66;
            border: 0px solid rgba(0, 0, 0, .2);
            border-radius: 31px;
            box-shadow: 0px 0px 40px 21px rgba(131, 151, 201, 0.5);
            -webkit-box-shadow: 0px 0px 40px 21px rgba(131, 151, 201, 0.5);
            box-shadow: 0px 0px 40px 21px rgba(131, 151, 201, 0.5);
        }
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            /* Set the fixed height of the footer here */
            height: 50px;
            box-shadow: none;
            background-color: rgba(0,0,0,0);
            border:none;
        }
    </style>

</head>
<body>
    <div class="modal-dialog" style="margin-top: 10%;">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title text-center" id="myModalLabel">教学在线留言答疑系统</h4>
            </div>
            <div class="modal-body" id = "model-body">
                <div class="form-group">
                    <form action="checklogin" method="post">
                        <div class="form-group">
                            <input type="text" name="username" class="form-control"placeholder="用户名" autocomplete="off">
                            <span id="myspan"></span>
                        </div>
                        <div class="form-group">
                            <input type="text" name="password" class="form-control" placeholder="密码" autocomplete="off">
                        </div>
                        <div>
                        <label class="radio-inline">
                            <input type="radio" name="job" id="optionsRadios1" value="administrator"  checked>管理员
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="job" value="teacher" id="optionsRadios2" >教师
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="job" value="student" id="optionsRadios3">学生
                        </label></div>
                        <div class="modal-footer">
                            <div class="form-group"> 
                                <input type="submit" name="submit" value="登入" class="btn btn-outline-dark btn-lg">
                            </div>
                            <div class="form-group">
                                <a class="btn btn-outline-dark btn-lg" href="stu_register.jsp" role="button">学生注册</a>
                            </div>
                        </div>
                    </form>
                </div>
                <div><%=request.getAttribute("userror")==null?"":request.getAttribute("userror") %></div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
    <footer class="footer">
        <p class="text-info text-center"><a href="https://github.com/gcw0618" >Click here to My Github: github.com/gcw0618</a></p>
    </footer>
</body>

</html>
