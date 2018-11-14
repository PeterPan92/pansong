<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
    <title>个人主页</title>
    <meta name="Desctiption" content="">
    <meta name="" content="">

    <!--需要引用的css-->
    <l:link path="css/bootstrap.css,css/font-awesome.css,css/ui.css,css/form.css,css/datatables.css"/>

    <!--需要引用的js-->
    <l:script path="jquery.js,bootstrap.js,datatables.js,loushang-framework.js,form.js,ui.js,arttemplate.js"/>

    <script type="text/javascript">
        <%--var context="<%=request.getContextPath()%>";--%>
    </script>
</head>
<body>
<h2>Hello To My World!!!</h2>
<a href="<%=request.getContextPath()%>/jsp/bj/login.jsp">登陆</a>
<a href="<%=request.getContextPath()%>/jsp/bj/switchInWebsite.jsp">网站接入</a>
<a href="<%=request.getContextPath()%>/jsp/plugs/musicDinamic.jsp">音乐空间</a>
<a href="<%=request.getContextPath()%>/jsp/plugs/dzkgame.jsp">休闲娱乐</a>
<a href="<%=request.getContextPath()%>/jsp/plugs/earth.jsp">旋转地球</a>
<a href="<%=request.getContextPath()%>/jsp/plugs/3dnav.jsp">导航</a>
</body>
</html>
