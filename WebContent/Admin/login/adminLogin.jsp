<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="../Admin/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../Admin/css/content.css" />
		
	<script type="text/javascript" src="../Admin/js/jquery-1.7.1.js" ></script>
	<script type="text/javascript" src="../Admin/js/stuLogin.js" ></script>
	
<title>考生登录</title>
</head>
<body>
	 <%@include file="nav.jsp" %>

    <form class="form-horizontal" name="login" action="adminLoginServlet" method="post">
    	<fieldset>
        	<legend>考生登录</legend>
        	
        	<div class="input-container">
		    	<div class="control-group">
		        	<label class="control-label" for="username">用户名：</label>
		            <div class="controls">
		              <input type="text" class="input-xlarge" id="username" name="username">
		            </div>
		    	</div>
		    	
	       		<div class="control-group">
		           	<label class="control-label" for="psd">密码：</label>
		           	<div class="controls">
		       			<input type="text" class="input-xlarge" id="psd" name="password">
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