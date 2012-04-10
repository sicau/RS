<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ include file="tools.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻管理</title>
  <link rel="stylesheet" type="text/css" href="../../css/jquery.dataTables.css" />
	<link rel="stylesheet" type="text/css" href="../../css/dataTable.css" />
	<style type="text/css" media="screen">
		@import "../../css/jquery-ui.css";		
	</style>
	
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/stuList.js"></script>
	
</head>
<body>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
		<thead>
			<tr>
				<th>标题</th>
				<th>作者</th>
				<th>发布日期</th>
				<th>置顶</th>
				<th>删除</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${newsList}" varStatus="i" var="item" >   
	            <tr class="gradeX">
					<td class="center">${item.subject}</td>
					<td class="center">${item.author}</td>
					<td class="center">${item.createTime}</td>
					<td class="center"><a href="TopSignServlet?id=${item.id }&top=${item.top}&type=${type }">置顶</a></td>
					<td class="center"><a href="../../DeleteNewsByIdServlet?id=${item.id }">删除</a></td>
				</tr>     
	    	</c:forEach>   
	    	<tr>
	    		<td>
	    			<pg:pager items="${newsPager.totalNum }" maxPageItems="${newsPager.pageSize}"  export="currentPage = pageNumber"   url="GetNewsPagerServlet">
	    			
	    				<pg:param name="pageSize" value="${newsPager.pageSize }"/>
	    				<pg:param name="pageNo" value="${currentPage }"/>
	    				<pg:param name="type" value="${type }"/>
	    				<pg:first>
	    					<a href="${pageUrl }">首页</a>
	    				</pg:first>
	    				<pg:prev>
	    					<a href="${pageUrl }">上一页</a>
	    				</pg:prev>
	    				<pg:pages>
	    					<c:choose>
	    						<c:when test="${newsPager.currentPage eq pageNamber }">
	    							<font color = "red">${pageNumber }</font>
	    						</c:when>
	    						<c:otherwise>
	    							<a href="${pageUrl }">${pageNumber}</a>
	    						</c:otherwise>
	    					</c:choose>
	    				</pg:pages>
	    				<pg:next>
	    					<a href="${pageUrl }">下一页</a>
	    				</pg:next>
	    				<pg:last>
	    					<a href="${pageUrl }">尾页</a>
	    				</pg:last>
	    			</pg:pager>
	    		</td>
	    	</tr>
		</tbody>
	</table>

</body>
</html>