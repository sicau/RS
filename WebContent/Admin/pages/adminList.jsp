<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "tools.jsp" %>
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
	<script type="text/javascript">
	$('document').ready(function() {
		$('#example').dataTable( {
		   "bStateSave":true,
		   "bJQueryUI": true,
		   "sPaginationType": "full_numbers",
		   "oLanguage": {
			   "oPaginate": {
			   		"sPrevious": "前一页",
			   		"sNext": "下一页",
			   		"sFirst": "首页",
					"sLast": "最后一页"
				},
			   "sInfo": "第  _START_ 到  _END_ 共  _TOTAL_ 记录 ",
			   "sLengthMenu": '页面容量 <select>'+
				             '<option value="10">10</option>'+
				             '<option value="15">15</option>'+
				             '<option value="20">20</option>'+
				             '<option value="25">25</option>'+
				             '</select> 条记录',
				"sSearch": "搜索:"
		   }
		} );
	})
	</script>
	<title>管理员权限管理管理</title>

</head>

<body>
	<h2>管理员列表</h2>
   <table cellpadding="0" cellspacing="0" border="0" class="display" id="example">
		<thead>
			<tr>
				<th>序号</th>
				<th>用户名</th>
				<th>用户类型</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${adminList}" varStatus="i" var="item" >   
	            <tr class="gradeX">
	            	<td class="center">${item.id}</td>
					<td class="center">
						<a href="adminShowViewServlet?id=${item.id}">${item.adminName}</a>
					</td>
					<td class="center">${item.type}</td>
				</tr>     
	    	</c:forEach>   
		</tbody>
	</table>
	<a href="" >添加</a>
	<a href="" >删除</a>
</body>
</html>