<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="tools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dataTable.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />

<title>新闻中心</title>
</head>
<body>
<div id="main_container">
<%@include file="header.jsp" %>
    <div class="menu">
    	<ul>                                                                         
    		<li><a href="index.jsp">首页</a></li>
            <li><a href="stuRegister.jsp">考生注册</a></li>
            <li class="selected"><a href="NewsCenterServlet?type=1">新闻中心</a></li>
    	</ul>
    </div>
	<div class="center_content">
		<table cellpadding="0" cellspacing="0" border="0" class="display table table-striped" id="example">
			<c:forEach items="${news}" varStatus="i" var="item" >   
	            <tr class="gradeX">
					<td class="left" width="500"><a href="GetOneNewsServlet?id=${item.id}">${item.subject}</a></td>
					<td class="left" width="100">${item.createTime}</td>
				</tr>     
	    	</c:forEach> 
		</table>  
	    	<div class="pagination">
	    		<ul>
	    			<pg:pager items="${npager.totalNum}" maxPageItems="${npager.pageSize}"  export="currentPage = pageNumber"   url="NewsCenterServlet">
	    				<pg:param name="pageSize" value="${npager.pageSize }"/>
	    				<pg:param name="pageNo" value="${currentPage }"/>
	    				<pg:param name="type" value="1"/>
	    				<pg:first>
	    					<li><a href="${pageUrl}">首页</a></li>
	    				</pg:first>
	    				<pg:prev>
	    					<li><a href="${pageUrl}">上一页</a></li>
	    				</pg:prev>
	    				<pg:pages>
	    					<c:choose>
	    						<c:when test="${npager.currentPage eq pageNamber }">
	    							<li class="active"><a href="#">${pageNumber }</a></li>
	    						</c:when>
	    						<c:otherwise>
	    							<li><a href="${pageUrl}">${pageNumber}</a></li>
	    						</c:otherwise>
	    					</c:choose>
	    				</pg:pages>
	    				<pg:next>
	    					<li><a href="${pageUrl}">下一页</a></li>
	    				</pg:next>
	    				<pg:last>
	    					<li><a href="${pageUrl}">尾页</a></li>
	    				</pg:last>
	    			</pg:pager>
	    		</ul>
	    	</div>
	</div>
<%@include file="footer.jsp" %>
</div>
</body>
</html>