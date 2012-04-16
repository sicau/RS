<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../../css/adminShowView.css" />
	
	<title>管理员个人信息</title>
</head>
<body>

	<form class="form-horizontal" action="../../AdminInfoServlet" method="post">
		<input type="hidden" name="type" value="${admin.type}"/> 
		<fieldset>
			<legend>管理员个人信息</legend>
			<div class="control-group">
				<label class="control-label" for="adminname">用户名:</label>
				<div class="controls">
					<input type="text" class="input-xlarge" id="adminname" name="adminname" value="${admin.adminName}"/>
					<input type="hidden" name="id" value="${admin.id }"/>
				</div>
			</div>
		
			<div class="control-group">
				<label class="control-label" for="optionsCheckbox">密码：</label>
				<div class="controls">
					<input type="password" class="input-xlarge" id="password" name="password" value="${admin.password}"/> 
				</div>
			</div>
		
			<div class="control-group">
				<label class="control-label" for="repassword">确认密码：</label>
				<div class="controls">
					<input type="password" class="input-xlarge" id="repassword" value="${admin.password}"/> 
				</div>
			</div>
		
			<div class="form-actions">
			
			<c:if test="${admin.type!=0}">
				<input type="submit" class="btn btn-primary" value="修改"/>
			</c:if>
				
			</div>
		</fieldset>
	</form>

</body>
</html>