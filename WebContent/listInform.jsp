<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="tools.jsp" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			var url = "GetInformServlet?type=0";
			var myAjax = new Ajax.Request(
				url,
				{
					method:"post",
				});
		}
	});	
	</script>
	<style >
		p{
			padding:30px 35px 0 35px;
		}
		a{
			color:#36322B;
		}
	</style>
</head>
<body>
	<c:forEach var="item" items="${informList }">
		<p class="welcome">
			<span class="orange"><a href="GetOneNewsServlet?id=${item.id}" ><font color="#da5b23" size="4px">${item.subject}</font></a></span><br/>
			${fn:substring(item.content,0,170)}......
		</p>
	</c:forEach>
</body>
</html>