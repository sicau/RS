<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../../css/adminHome.css" />
	
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/adminHome.js"></script>

	<title>后台管理</title>
</head>

<body>

	 <%@include file="navbar.jsp" %>
 	
	 <div class="container-fluid back-color">
	   <div class="row-fluid">
	     <div class="span3">
	       <div class="well sidebar-nav">
	         <ul class="nav nav-list">
	           <li class="nav-header">学生信息管理</li>
	           <li class="li"><a href="../../GetUserPageServlet?type=0" target="contentIframe">报考学生列表</a></li>
	           <li class="li"><a href="../../GetUserPageServlet?type=1" target="contentIframe">初试学生列表</a></li>
	           <li class="li"><a href="../../GetUserPageServlet?type=2" target="contentIframe">复试学生列表</a></li>
	           <li class="li"><a href="../../GetUserPageServlet?type=3" target="contentIframe">录取学生列表</a></li>
	           <li class="nav-header">管理员设置</li>
	           <li class="li"><a href="adminListServlet" target="contentIframe">管理员列表</a></li>
	           <li class="li"><a href="addAdmin.jsp" target="contentIframe">增加管理员</a></li>
	           <li class="li"><a href="adminShowView.jsp" target="contentIframe">修改个人密码</a></li>
	           <li class="nav-header">新闻发布</li>
	           <li class="li"><a href="addNews.jsp" target="contentIframe">添加新闻</a></li>
	           <li class="li"><a href="../../GetNewsPagerServlet?type=0" target="contentIframe">管理新闻</a></li>
	           <li class="li"><a href="../../GetNewsPagerServlet?type=1" target="contentIframe">管理公告</a></li>
	         </ul>
	       </div><!--/.well -->
	     </div><!--/span-->
	     <div class="span9">
	      	<div id="content">
				<iframe src="welcome.jsp" name="contentIframe" frameborder="0" ></iframe>
			</div>
	     </div><!--/span-->
	   </div><!--/row-->
	 </div>
	
</body>
</html>