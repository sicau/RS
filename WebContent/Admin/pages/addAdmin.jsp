<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加管理员</title>
</head>
<body>
	<form action="../../AddAdminServlet" method="post">
		<table align = "center">
			<tr>
				<td colspan="3">增加普通管理员</td>
			</tr>
			<tr>
				<td>管理员名</td>
				<td><input type="text" name="adminame" ></td>
				<td></td>
			</tr>
			<tr>
				<td>密&nbsp;&nbsp;&nbsp;&nbsp;码</td>
				<td><input type="password" name="password"></td>
				<td></td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" name="repassword"></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="hidden" name="type"  value="0"/></td>
				<td><input type="submit" name="submit" value="提交" /></td>
				<td><input type="reset" name="reset" value="重置"/></td>
			</tr>
		</table>
	</form>
</body>
</html>