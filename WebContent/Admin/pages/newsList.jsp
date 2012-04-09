<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
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
					<td class="center"><a href="../../TopSignServlet?id=${item.id }&top=${item.top}">置顶</a></td>
					<td class="center"><a href="../../DeleteNewsByIdServlet?id=${item.id }">删除</a></td>
				</tr>     
	    	</c:forEach>   
		</tbody>
	</table>

</body>
</html>