<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/selfHome.css" />
		
	<script type="text/javascript" src="js/jquery-1.7.1.js" ></script>
	<script type="text/javascript" src="js/selfHome.js" ></script>
	<title>个人主页</title>
	
</head>
<body>
	<%@include file="nav.jsp" %>
	<input type="hidden" id="id" value="${id}"/>
	<div class="main-container row">
		<div class="left-container span6">
			<div class="welcome-word">欢迎来到个人中心</div>
			<div class="per-center">Personal Cener</div>
			<div class="my-status">
				<c:if test="${type==null}">审核中</c:if> 
			 	<c:if test="${type==0}">审核中</c:if> 
				<c:if test="${type==1}">通过初试</c:if> 
				<c:if test="${type==2}">通过复试</c:if> 
				<c:if test="${type==3}">已录取</c:if>
			</div>
			
		</div>
		<div class="right-container span6">
			<a href="showSignInfoServlet?id=${id}"><div class="person-info">个人信息</div></a>
		</div>
	</div>
	
</body>
</html>