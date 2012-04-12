<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dataTable.css" />
	
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.1.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery.dataTables.js"></script>
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-ui.js"></script>
	<script type="text/javascript">
		function selectAll() {
			var deletes = document.getElementsByName("delete");
			var selectAll = document.getElementById("selectAll");
			for(var i = 0;i<deletes.length; i++) {
				if(selectAll.checked == true) {
					deletes[i].checked = true;
				} else {
					deletes[i].checked = false;
				}
			}
		}
		
		function removeUser(pageOffset,pageSize,type) {
			var deletes = document.getElementsByName("delete");
			var count = 0;
			var users = new Array();
			for(var i = 0;i<deletes.length;i++) {
				if(deletes[i].checked) {
					count++;
					users.push(deletes[i].value);
				}
			}
			
			if(count == 0) {
				alert("还没有选中删除项");
				return false;
			}
			var oform = document.getElementsByTagName("form")[0];
			oform.action = "DeleteUserServlet?userIds="+users+"&pageOffset="+pageOffset+"&pageSize="+pageSize+"&type="+type;
			oform.submit();
		}
	
	</script>
	
	
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
	<table cellpadding="0" cellspacing="0" border="0" class="display table table-striped" id="example">
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>出生日期</th>
				<th>政治面貌</th>
				<th>科类</th>
				<th>外语语种</th>
				<th>考生类别</th>
				<th><input type="checkbox" id="selectAll" onclick="selectAll()"/>全/反选</th>
			</tr>
		</thead>
		<tbody>
			<form method="post" name="deleteform" >
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
						<td class="center"><input type="checkbox" name="delete" value="${item.id }"/></td>
					</tr>     
		    	</c:forEach>  
	    	</form>
	    </tbody>
	</table>
	    	 
	<div class="pagination">
			<ul>
				<pg:pager items="${userPager.totalNum }" maxPageItems="${userPager.pageSize}"  export="currentPage = pageNumber"   url="GetUserPageServlet">
					<pg:param name="pageSize" value="${userPager.pageSize }" />
					<pg:param name="pageNo" value="${currentPage }" />
					<pg:param name="type" value="${type}"/>
					<pg:first>
						<li><a href="${pageUrl}">首页</a></li>
					</pg:first>
					<pg:prev>
						<li><a href="${pageUrl}">上一页</a></li>
					</pg:prev>
					<pg:pages>
						<c:choose>
							<c:when test="${userPager.currentPage eq pageNumber }">
								<li class="active"><a href="#">${pageNumber }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="${pageUrl }">${pageNumber} </a></li>
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
		<input type="button" value="删除" onclick="removeUser(${userPager.pageOffset},${userPager.pageSize },${type })"/>
	<a class="btn pull-right" href="Admin/pages/excelDownLoadServlet?type=${type}" >导出Excel</a>
</body>
</html>