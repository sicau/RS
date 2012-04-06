<%@ page language="java" contentType="text/htm; charset=UTF-8"
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
	<script type="text/javascript">
		function checkName() {
			var username = document.getElementsById("username");
			var checkName = document.getElementById("checkName");
			var patrn = /^[a-z,A-Z_]{1}\w{5,16}$/;
			if(username.value==""){
				checkName.style.color="red";
				checkName.innerHTML="用户名不能为空！";
			}else if (!patrn.exec(username.value)) {
				checkName.style.color="red";
				checkName.innerHTML="用户名输入有误！";
				return false;
			} else {
				checkName.style.color="green";
				checkName.innerHTML="√ 输入正确";
				return true;
			}
			
		}	

		function checkPassword() {
			var password1 = document.getElementById("password1");
			var pwdRemind = document.getElementById("pwdRemind");
			var patrn=/^[a-z,A-Z,0-9]{6,15}$/;
			if (password1.value=="") {
				pwdRemind.sytli.color = "red";
				pwdRemind.innerHTML="密码不能为空！";
				return false;
			}else if(!patrn.exec(password1.value)) {
				pwdRemind.sytli.color = "red";
				pwdRemind.innerHTML="密码格式输入有误！";
				return false;
			}else{
				pwdRemind.style.color="green";
				pwdRemind.innerHTML="√ 输入正确";
				return true;
			}
			
		}
		//确认密码
		function checkPwd(){
			var password1 = document.getElementById("password1");
			var password2 = document.getElementById("password2");
			var checkPwd = document.getElementById("checkPwd");
			if(password1.value != password2.value) {
				checkPwd.style.color="red";
				checkPwd.innerHTML="两次密码输入不一致！";
				return false;
			}else{
				checkPwd.style.color="green";
				checkPwd.innerHTML="两次密码输入一致！";
				return true;
			} 
		}
		//清除用户名错误提示 
		function clearRN() {
			var checkName = document.getElementById("checkName");
			checkName.style.color="black";
			checkName.innerHTML="英文字母或下划线(6-15)字符组成";
		}
		//清除密码验证错误提示 
		function clearPwd() {
			var checkPwd = document.getElementById("checkPwd");
			var pwdRemind = document.getElementById("pwdRemind");
			checkPwd.style.color="black";
			checkPwd.innerHTML="由英文字母和数字(6-15)字符组成";
			pwdRemind.innerHTML="";
		}
		
	
	</script>
</head>
<body class="back-color">
	 <%@include file="nav.jsp" %>
	 
	 <div class="form-container">
		 <form class="form-horizontal" name="register" action="register" method="post">
	    	<fieldset>
	        	<legend>考生注册</legend>
	        	
	        	
			    	<div class="control-group">
			        	<label class="control-label" for="username">用户名：</label>
			            <div class="controls">
			              <input type="text" class="input-xlarge" id="username" name="username" onblur="checkName()" onfocus="clearRN()">
			              <label class="control-label" for="" id="checkName"><span style="color: red">*</span><span style="color:black">由英文字母、数字或下划线(6-16)个字符组成,且不能以数字开头</span></label>
			            </div>
			    	</div>
			    	
		       		<div class="control-group">
			           	<label class="control-label" for="psd">密码：</label>
			           	<div class="controls">
			       			<input type="password" class="input-xlarge" id="psd" name="password">
			          	</div>
		        	</div>
		        	
		        	<div class="control-group">
			           	<label class="control-label" for="rePsd">确认密码：</label>
			           	<div class="controls">
			       			<input type="password" class="input-xlarge" id="rePsd" name="rePsd">
			          	</div>
		        	</div>
		        	
		        	<div class="control-group">
			           	<label class="control-label" for="validation">验证码：</label>
			           	<div class="controls">
			       			<input type="text" class="input-medium" id="validation" name="validation">
			       			<img class="validate-img" src="RandomCodeServlet">
			          	</div>
		        	</div>
		        
	            
	            <div class="form-actions">
		            <button type="submit" class="btn btn-primary">下一步</button>
	            </div>
	            
	     	</fieldset>
	    </form>
    </div>
</body>
</html>