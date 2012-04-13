<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="css/style.css" />
<title>四川农业大学简介</title>
</head>
<body>
<div id="main_container">
<%@include file="header.jsp" %>
    <div class="menu">
    	<ul>                                                                         
    		<li><a href="index1.jsp">首页</a></li>
            <li><a href="#">about</a></li>
            <li><a href="#">demo</a></li>
            <li><a href="#">license</a></li>
            <li><a href="#">新闻中心</a></li>
            <li><a href="#">关于我们</a></li>
            <li><a href="#">联系我们</a></li>
    	</ul>
    </div>
	<div class="center_content">
		<h2 align="center">四川农业大学简介</h2>
		<p align="center" class="intro">
			<%@include file="aboutSchool.txt" %>
		</p>
	</div>
<%@include file="footer.jsp" %>
</div>
</body>
</html>