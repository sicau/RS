<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   


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
	
	<title>所有报名者信息</title>
</head>
<body>
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
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${stuList}" varStatus="i" var="item" >   
	            <tr class="gradeX">
					<td class="center">${item.userName}</td>
					<td class="center">${item.sex}</td>
					<td class="center">${item.birthday}</td>
					<td class="center">${item.politics}</td>
					<td class="center">${item.subject}</td>
					<td class="center">${item.lang}</td>
					<td class="center">${item.category}</td>
				</tr>     
	    	</c:forEach>   
		</tbody>
	</table>
</body>
</html>