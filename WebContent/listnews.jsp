<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="tools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<script type="text/javascript" src="js/prototype.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.1.js" ></script>
	<script language="javascript">
	$(document).ready(function() {
		shownews();
		function shownews() {
			var url = "ListNewsServlet "
			var myAjax = new Ajax.Request(
				url,
				{
					method:"post",
				});
		}
	})	
	</script>
	<title>list news</title>
</head>
<body>
  	<table>
    	<c:forEach var="item" items="${newsList}">
    		<tr align="center">
    			<td><a href="GetOneNewsServlet?id=${item.id}">${item.subject }</a></td>
    			<td>${item.createTime }  ${item.id }</td>
    			
    		</tr>
    	</c:forEach>
   	</table>
</body>
</html>