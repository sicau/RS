<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../../css/adminHome.css" />
	<link rel="stylesheet" type="text/css" href="../../css/content.css" />
	
		
	<script type="text/javascript" src="../Admin/js/jquery-1.7.1.js" ></script>
	
<title>管理员登录</title>
</head>
<body>

	<%@include file="../pages/navbar.jsp" %>

    <form class="form-horizontal" name="login" action="adminLoginServlet" method="post">
    	<fieldset>
        	<legend>管理员登录</legend>
        	<div class="input-container">
		    	<div class="control-group">
		        	<label class="control-label" for="username">用户名：</label>
		            <div class="controls">
		              <input type="text" class="input-xlarge" id="adminname" name="adminname">
		            </div>
		    	</div>
		    	
	       		<div class="control-group">
		           	<label class="control-label" for="psd">密码：</label>
		           	<div class="controls">
		       			<input type="password" class="input-xlarge" id="password" name="password">
		       			<p class="help-block">${message}</p>
		          	</div>
	        	</div>
            </div>
            
            <div class="form-actions">
	            <button type="submit" class="btn btn-primary">登录</button>
            </div>
     	</fieldset>
    </form>
   
</body>
</html>