<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../../css/jquery.dataTables.css" />
	<link rel="stylesheet" type="text/css" href="../../css/dataTable.css" />
	<style type="text/css" media="screen">
		@import "../../css/jquery-ui.css";		
	</style>
	
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
	
	
	<title>所有报名者信息</title>
</head>
<body>
	<h2>	
	<c:if test="${type==0}">
		报考学生列表
    </c:if>
    <c:if test="${type==1}">
		初试学生列表
    </c:if>
    <c:if test="${type==2}">
		复试学生列表
    </c:if>
    <c:if test="${type==3}">
		录取学生列表
    </c:if>   
	</h2>
	<table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>政治面貌</th>
				<th>科类</th>
				<th>外语语种</th>
				<th>考生类别</th>
				<th>删除</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userList}" varStatus="i" var="item" >   
	            <tr class="gradeX">
					<td class="center">
						<a href="Admin/pages/stuShowViewServlet?id=${item.id}" target="_blank">${item.userName}</a>
					</td>
					<td class="center">${item.sex}</td>
					<td class="center">${item.birthday}</td>
					<td class="center">${item.politics}</td>
					<td class="center">${item.subject}</td>
					<td class="center">${item.lang}</td>
					<td class="center">${item.category}</td>
					<td class="center"><a href="DeleteUserServlet?id=${id}">删除</a></td>
				</tr>     
	    	</c:forEach>  
	    	 
	    <div>
			<table>
				<tr>
					<td>
						<pg:pager items="${userPager.totalNum }" maxPageItems="${userPager.pageSize}"  export="currentPage = pageNumber"   url="GetUserPageServlet">
							<pg:param name="pageSize" value="${userPager.pageSize }" />
							<pg:param name="pageNo" value="${currentPage }" />
							<pg:param name="type" value="${type}"/>
							<pg:first>
								<a href="${pageUrl }">首页</a>
							</pg:first>
							<pg:prev>
								<a href="${pageUrl }">上一页</a>
							</pg:prev>
							<pg:pages>
								<c:choose>
									<c:when test="${userPager.currentPage eq pageNumber }">
										<font color = "red">${pageNumber }</font>
									</c:when>
									<c:otherwise>
										<a href="${pageUrl }">${pageNumber} </a>
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
			</table>
		</div>
		
		</tbody>
		
		
	</table>
		  
	<a class="btn" href="Admin/pages/excelDownLoadServlet?type=${type}" >导出Excel</a>

</body>
</html>