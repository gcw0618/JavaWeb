<%--
  Created by IntelliJ IDEA.
  User: gcw
  Date: 2019/12/10
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="jquery.js" type="text/javascript" charset="UTF-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/ab/jquery.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="page_nav" align="center">
    <a href="${page.path}&pageNo=1">首页</a>
    <a href="${page.path}&pageNo=${page.pageNumber -1 }">上一页</a>
    <c:choose>
        <c:when test="${page.totalPage <= 5 }" >
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="${page.totalPage}"></c:set>
        </c:when>
        <c:when test="${page.pageNumber <= 3 }">
            <c:set var="begin" value="1"></c:set>
            <c:set var="end" value="5"></c:set>
        </c:when>
        <c:otherwise>
            <c:set var="begin" value="${page.pageNumber-2}"></c:set>
            <c:set var="end" value="${page.pageNumber+2}"></c:set>
            <c:if test="${end > page.totalPage }">
                <c:set var="begin" value="${page.totalPage-4}"></c:set>
                <c:set var="end" value="${page.totalPage}"></c:set>
            </c:if>
        </c:otherwise>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="num">
        <c:if test="${page.pageNumber == num }">
            【${num}】
        </c:if>
        <c:if test="${page.pageNumber != num }">
            <a href="${page.path}&pageNo=${num}">${num }</a>
        </c:if>
    </c:forEach>
    <a href="${page.path}&pageNo=${page.pageNumber +1}">下一页</a>
    <a href="${page.path}&pageNo=${page.totalPage}">末页</a>
    共${page.totalPage }页，${page.totalRecord }条记录到,去第<input value="${page.totalPage }" name = "pn" id ="pn_input"/>页

    <input type="button" value="确定" id="btn_id"/>
    <script type="text/javascript">
        $("#btn_id").click(function(){
            var value= $("#pn_input").val();
            window.location="${page.path}&pageNo="+value;
        });
    </script>
</div>

</body>
</html>