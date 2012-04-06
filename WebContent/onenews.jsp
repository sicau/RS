<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="tools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${news.subject }</title>
</head>
<body>

	<div>
		<table width="700px" align="center">
			<tr>
			  	<td align="center"colspan="2"><h2>${news.subject }</h2></td>
			</tr>
			<tr>
				<td align="center">作者：${news.author }</td>
				<td align="center">发布日期：${news.createTime}</td>
			</tr>
			<tr>
				<td colspan="2">${news.content}</td>
			</tr>
		</table>
	</div>
	
</body>
</html>