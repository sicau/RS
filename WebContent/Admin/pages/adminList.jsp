<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "tools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../../css/dataTable.css" />
	
	<script type="text/javascript" language="javascript" src="<%=request.getContextPath()%>/js/jquery-1.7.1.js"></script>

	<title>管理员权限管理管理</title>

</head>

<body>
	<div>
		<h2>管理员列表</h2>
		<div class="content-container">
		    <table cellpadding="1" cellspacing="1"  class="display table table-striped" id="example" align="center">
				<thead>
					<tr align="center">
						<th width="50">序号</th>
						<th width="70">用户名</th>
						<th width="100">用户类型</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${adminList}" varStatus="i" var="item" >   
			            <tr class="gradeX" align="center">
			            	<td class="center" width="50">${item.id}</td>
							<td class="center" width="70">
								<a href="adminShowViewServlet?id=${item.id}">${item.adminName}</a>
							</td>
							<td class="center" width="100">${item.type}</td>
						</tr>     
			    	</c:forEach>   
				</tbody>
			</table>
		</div>
		<div class="form-actions">
			<a href="addAdmin.jsp" class="btn btn-primary">增加</a>
			<a href="#" class="btn">删除</a>
		</div>
	</div>
</body>
</html>