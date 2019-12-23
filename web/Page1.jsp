<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/10
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="jquery.js" type="text/javascript" charset="UTF-8"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="page">
    <a href="${page.path}&pageNumber=1">首页</a>
    <a href="${page.path}&pageNumber=${page.pageNumber-1}">上一页</a>
    <!--
        始终保证当前页在中间，一共显示5页
        1.总页码<=5时，显示所有页数
        2.总页码>5时：
            当前页码<=3时：显示1~5页
            当前页码>3时：显示当前页在中间的5页,当当前页为倒数前3页时，显示最后5页
    -->
    <c:choose>
        <c:when test="${page.totalPage<=5}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${page.totalPage}"></c:set>
        </c:when>
        <c:when test="${page.pageNumber<=3}">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="5"></c:set>
        </c:when>
        <c:when test="${page.pageNumber>3}">
            <c:set var="begin" value="${page.pageNumber-2}"></c:set>
            <c:set var="end" value="${page.pageNumber+2}"></c:set>
            <c:if test="${page.pageNumber+2>=page.totalPage}">
                <c:set var="begin" value="${page.totalPage-4}"></c:set>
                <c:set var="end" value="${page.totalPage}"></c:set>
            </c:if>
        </c:when>
    </c:choose>
    <!-- 通过循环显示由begin到end的5个页面，当前页用【】标识 -->
    <c:forEach begin="${begin}" end="${end}" var="index">
        <c:if test="${page.pageNumber==index}">
            <a href="${page.path}&pageNumber=${index}">【${index}】</a>
        </c:if>
        <c:if test="${page.pageNumber!=index}">
            <a href="${page.path}&pageNumber=${index}">${index}</a>
        </c:if>
    </c:forEach>

    <a href="${page.path}&pageNumber=${page.pageNumber+1}">下一页</a>
    第${page.pageNumber}页，共${page.totalPage}页
    转到第<input id="setPage" type="text" value="${page.pageNumber}"/>页，<a id="goto" href="">跳转</a>
    <a href="${page.path}&pageNumber=${page.totalPage}">末页</a>
    <script type="text/javascript">
        window.onload=function(){
            var agoto=document.getElementById("goto");
            agoto.onclick=function(){
                var setPage=document.getElementById("setPage").value;
                window.location="${page.path}&pageNumber="+setPage;
                return false;
            };
        };
    </script>
    <!--或 <script type="text/javascript">
        $(function(){
            $("#goto").click(function(){
                var $setPage=$("#setPage").val();
                window.location="/MyBookStore/book?method=getPage&pageNumber="+$setPage;
                return false;
            });
        });
    </script> -->
</div>

</body>
</html>
