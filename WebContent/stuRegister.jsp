<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>四川农业大学自主招生</title>
	
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/content.css" />
		
	<script type="text/javascript" src="js/jquery-1.7.1.js" ></script>
	<script type="text/javascript" src="js/stuRegister.js" ></script>
</head>
<body class="back-color">
	 <%@include file="nav.jsp" %>
	 
	 <form class="form-horizontal" name="register" action="register" method="post">
    	<fieldset>
        	<legend>考生注册</legend>
        	
        	
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
	        	
	        	<div class="control-group">
		           	<label class="control-label" for="rePsd">确认密码：</label>
		           	<div class="controls">
		       			<input type="text" class="input-xlarge" id="rePsd" name="rePsd">
		          	</div>
	        	</div>
	        	
	        	<div class="control-group">
		           	<label class="control-label" for="validation">验证码：</label>
		           	<div class="controls">
		       			<input type="text" class="input-xlarge" id="validation" name="validation">
		          	</div>
	        	</div>
	        
            
            <div class="form-actions">
	            <button type="submit" class="btn btn-primary">注册</button>
            </div>
            
     	</fieldset>
    </form>
    
</body>
</html>