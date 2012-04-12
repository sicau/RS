<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ include file="tools.jsp" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新闻管理</title>

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/dataTable.css" />
	
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.1.js"></script>
	<script type="text/javascript">
		function selectAll() {
			var deletes = document.getElementsByName("delete");
			var selectAll = document.getElementById("selectAll");
			for(var i = 0;i<deletes.length;i++) {
				if(selectAll.checked == true) {
					deletes[i].checked = true;
				} else {
					deletes[i].checked = false;
				}
			}
		}
		
		function removeNews() {
			var deletes = document.getElementsByName("delete");
			var count = 0;
			var news = new Array();
			for(var i = 0 ;i<deletes.length;i++) {
				if(deletes[i].checked) {
					count++;
					news.push(deletes[i].value);
				}
			}
			if(count == 0) {
				alert("还没有选中删除项！");
				return false;
			}
			var oform = document.getElementsByTagName("form")[0];
			oform.action = "DeleteNewsByIdServlet?id="+news;
			alert(oform.action);
			oform.submit();
		}
	</script>
	
</head>
<body>
	<h2>管理新闻</h2>
	
	<table cellpadding="0" cellspacing="0" border="0" class="display table table-striped" id="example">
		<thead>
			<tr>
				<th>标题</th>
				<th>作者</th>
				<th>发布日期</th>
				<th>置顶</th>
				<th><input type="checkbox" id="selectAll" onclick="selectAll()"/>全/反选</th>
			</tr>
		</thead>
		<tbody>
			<form method="post" name="deleteform">
				<c:forEach items="${newsList}" varStatus="i" var="item" >   
		            <tr class="gradeX">
						<td class="center">${item.subject}</td>
						<td class="center">${item.author}</td>
						<td class="center">${item.createTime}</td>
						<td class="center"><a href="TopSignServlet?id=${item.id }&top=${item.top}&type=${type }">置顶</a></td>
						<td class="center"><input type="checkbox" name="delete" value="${item.id }"/></td>
					</tr>     
		    	</c:forEach> 
	    	</form>
	    </tbody>
	</table>  
	    	<div class="pagination">
	    		<ul>
	    			<pg:pager items="${newsPager.totalNum}" maxPageItems="${newsPager.pageSize}"  export="currentPage = pageNumber"   url="GetNewsPagerServlet">
	    				<pg:param name="pageSize" value="${newsPager.pageSize }"/>
	    				<pg:param name="pageNo" value="${currentPage }"/>
	    				<pg:param name="type" value="${type }"/>
	    				<pg:first>
	    					<li><a href="${pageUrl}">首页</a></li>
	    				</pg:first>
	    				<pg:prev>
	    					<li><a href="${pageUrl}">上一页</a></li>
	    				</pg:prev>
	    				<pg:pages>
	    					<c:choose>
	    						<c:when test="${newsPager.currentPage eq pageNamber }">
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
	    	<input type="button" value="删除" onclick="removeNews()"/>
</body>
</html>