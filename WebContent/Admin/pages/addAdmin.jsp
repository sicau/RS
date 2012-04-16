<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../../css/adminShowView.css" />
	
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/addAdmin.js"></script>
	
	<title>增加管理员</title>
</head>
<body>

	<form action="../../AddAdminServlet" method="post" class="form-horizontal">
		<fieldset>
			<legend>增加普通管理员</legend>
			<div class="control-group">
				<label class="control-label" for="adminname">管理员名:</label>
				<div class="controls">
					<input type="text" class="input-xlarge" id="adminname" name="adminname" />
					<p class="help-block adminname" ></p>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="password">密码:</label>
				<div class="controls">
					<input type="password" class="input-xlarge" id="password" name="password" />
					<p class="help-block password" ></p>
				</div>
			</div>
			
			<div class="control-group">
				<label class="control-label" for="repassword">确认密码:</label>
				<div class="controls">
					<input type="password" class="input-xlarge" id="repassword" name="repassword" />
					<p class="help-block repassword" ></p>
				</div>
			</div>
		
			<div class="form-actions">
				<input type="hidden" name="type"  value="1"/>
				<input type="button" class="btn btn-primary submit" value="提交" />
				<input type="reset" name="reset" class="btn" value="重置"/>
			</div>
		</fieldset>
	</form>
</body>
</html>