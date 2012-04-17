<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>四川农业大学自主招生</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/content.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	
	<script type="text/javascript" src="js/jquery-1.7.1.js" ></script>
	<script type="text/javascript" src="js/stuRegister.js" ></script>
	
	
</head>
<body class="back-color">

<div id="main_container">

	<%@include file="header.jsp" %>
	 <div class="menu">
    	<ul>                                                                         
    		<li><a href="index.jsp">首页</a></li>
            <li class="selected"><a href="stuRegister.jsp">考生注册</a></li>
            <li><a href="NewsCenterServlet?type=1">新闻中心</a></li>
    	</ul>
   	 </div>
    <div class="center_content">
	 <div class="form-container">
	    	<form class="form-horizontal" name="register" action="register" method="post">
		    	<fieldset>
		        	<legend>考生注册</legend>
				    	<div class="control-group">
				        	<label class="control-label" for="username">用户名：</label>
				            <div class="controls">
				              <input type="text" class="input-xlarge" id="username" name="username" />
				              <p class="help-block username" ></p>
				            </div>
				    	</div>
				    	
			       		<div class="control-group">
				           	<label class="control-label" for="psd">密码：</label>
				           	<div class="controls">
				       			<input type="password" class="input-xlarge" id="psd" name="password" />
				       			 <p class="help-block psd"></p> 
				          	</div>
			        	</div>
			        	
			        	<div class="control-group">
				           	<label class="control-label" for="rePsd" >确认密码：</label>
				           	<div class="controls">
				       			<input type="password" class="input-xlarge" id="rePsd" name="rePsd"  />
				       			<p class="help-block rePsd"></p>
				          	</div>
			        	</div>
			        	
			        	<div class="control-group">
				           	<label class="control-label" for="validation" >验证码：</label>
				           	<div class="controls">
				       			<input type="text" class="input-medium" id="validation" name="validation"/>
				       			<img class="validate-img" src="RandomCodeServlet">
				       			<p class="help-block val-code"></p>
				          	</div>
			        	</div>
			        
		            <div class="form-actions">
			            <input type="button" class="btn btn-primary submit" value="下一步"/>
		            </div>
		            
		     	</fieldset>
		    </form>
     	</div>
        <div class="clear"></div> 
    </div>    

    <%@include file="footer.jsp" %>

	
</div>	 
  
</body>
</html>