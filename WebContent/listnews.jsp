<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file="tools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	<script type="text/javascript" src="js/prototype.js"></script>
	<script type="text/javascript" src="js/jquery-1.7.1.js" ></script>
	<script language="javascript">
	$(document).ready(function() {
		$("body").hide();
		shownews();
		function shownews() {
			var ul = "ListNewsServlet?type=1 ";
				$.ajax({
					  type:"post",
					  url: ul 
				}).done(function() { 
					$("body").show();
				});
		}
	});	
	</script>
</head>
<body>
	<table>
	   	<c:forEach var="item" items="${newsList}">
	   		<tr>
	   			<td width="400">
		   			<ul class="list">
		   			<li><span>*</span><a href="GetOneNewsServlet?id=${item.id}">${item.subject }</a></li>
		  		  	</ul>
	  		  	</td>
	  		  	<td width="100">${item.createTime }</td>
	  	    </tr>
	   	</c:forEach>
    </table>
</body>
</html>