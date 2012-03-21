<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<th>引擎</th>
				<th>Browser</th>
				<th>Platform(s)</th>
				<th>Engine version</th>
				<th>CSS grade</th>
			</tr>
		</thead>
		<tbody>
			<tr class="gradeX">
				<td>Trident</td>
				<td>Internet
					 Explorer 4.0</td>
				<td>Win 95+</td>
				<td class="center">4</td>
				<td class="center">X</td>
			</tr>
			<tr class="gradeC">
				<td>Trident</td>
				<td>Internet
					 Explorer 5.0</td>
				<td>Win 95+</td>
				<td class="center">5</td>
				<td class="center">C</td>
			</tr>
			<tr class="gradeA">
				<td>Trident</td>
				<td>Internet
					 Explorer 5.5</td>
				<td>Win 95+</td>
				<td class="center">5.5</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Trident</td>
				<td>Internet
					 Explorer 6</td>
				<td>Win 98+</td>
				<td class="center">6</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Trident</td>
				<td>Internet Explorer 7</td>
				<td>Win XP SP2+</td>
				<td class="center">7</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Trident</td>
				<td>AOL browser (AOL desktop)</td>
				<td>Win XP</td>
				<td class="center">6</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Firefox 1.0</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.7</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Firefox 1.5</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.8</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Firefox 2.0</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.8</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Firefox 3.0</td>
				<td>Win 2k+ / OSX.3+</td>
				<td class="center">1.9</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Camino 1.0</td>
				<td>OSX.2+</td>
				<td class="center">1.8</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Camino 1.5</td>
				<td>OSX.3+</td>
				<td class="center">1.8</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Netscape 7.2</td>
				<td>Win 95+ / Mac OS 8.6-9.2</td>
				<td class="center">1.7</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Netscape Browser 8</td>
				<td>Win 98SE+</td>
				<td class="center">1.7</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Netscape Navigator 9</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.8</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.0</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.1</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.1</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.2</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.2</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.3</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.3</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.4</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.4</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.5</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.5</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.6</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">1.6</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.7</td>
				<td>Win 98+ / OSX.1+</td>
				<td class="center">1.7</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Mozilla 1.8</td>
				<td>Win 98+ / OSX.1+</td>
				<td class="center">1.8</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Seamonkey 1.1</td>
				<td>Win 98+ / OSX.2+</td>
				<td class="center">1.8</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Gecko</td>
				<td>Epiphany 2.20</td>
				<td>Gnome</td>
				<td class="center">1.8</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Webkit</td>
				<td>Safari 1.2</td>
				<td>OSX.3</td>
				<td class="center">125.5</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Webkit</td>
				<td>Safari 1.3</td>
				<td>OSX.3</td>
				<td class="center">312.8</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Webkit</td>
				<td>Safari 2.0</td>
				<td>OSX.4+</td>
				<td class="center">419.3</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Webkit</td>
				<td>Safari 3.0</td>
				<td>OSX.4+</td>
				<td class="center">522.1</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Webkit</td>
				<td>OmniWeb 5.5</td>
				<td>OSX.4+</td>
				<td class="center">420</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Webkit</td>
				<td>iPod Touch / iPhone</td>
				<td>iPod</td>
				<td class="center">420.1</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Webkit</td>
				<td>S60</td>
				<td>S60</td>
				<td class="center">413</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 7.0</td>
				<td>Win 95+ / OSX.1+</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 7.5</td>
				<td>Win 95+ / OSX.2+</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 8.0</td>
				<td>Win 95+ / OSX.2+</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 8.5</td>
				<td>Win 95+ / OSX.2+</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 9.0</td>
				<td>Win 95+ / OSX.3+</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 9.2</td>
				<td>Win 88+ / OSX.3+</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Opera 9.5</td>
				<td>Win 88+ / OSX.3+</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Opera for Wii</td>
				<td>Wii</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Nokia N800</td>
				<td>N800</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>Presto</td>
				<td>Nintendo DS browser</td>
				<td>Nintendo DS</td>
				<td class="center">8.5</td>
				<td class="center">C/A<sup>1</sup></td>
			</tr>
			<tr class="gradeC">
				<td>KHTML</td>
				<td>Konqureror 3.1</td>
				<td>KDE 3.1</td>
				<td class="center">3.1</td>
				<td class="center">C</td>
			</tr>
			<tr class="gradeA">
				<td>KHTML</td>
				<td>Konqureror 3.3</td>
				<td>KDE 3.3</td>
				<td class="center">3.3</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeA">
				<td>KHTML</td>
				<td>Konqureror 3.5</td>
				<td>KDE 3.5</td>
				<td class="center">3.5</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeX">
				<td>Tasman</td>
				<td>Internet Explorer 4.5</td>
				<td>Mac OS 8-9</td>
				<td class="center">-</td>
				<td class="center">X</td>
			</tr>
			<tr class="gradeC">
				<td>Tasman</td>
				<td>Internet Explorer 5.1</td>
				<td>Mac OS 7.6-9</td>
				<td class="center">1</td>
				<td class="center">C</td>
			</tr>
			<tr class="gradeC">
				<td>Tasman</td>
				<td>Internet Explorer 5.2</td>
				<td>Mac OS 8-X</td>
				<td class="center">1</td>
				<td class="center">C</td>
			</tr>
			<tr class="gradeA">
				<td>Misc</td>
				<td>NetFront 3.1</td>
				<td>Embedded devices</td>
				<td class="center">-</td>
				<td class="center">C</td>
			</tr>
			<tr class="gradeA">
				<td>Misc</td>
				<td>NetFront 3.4</td>
				<td>Embedded devices</td>
				<td class="center">-</td>
				<td class="center">A</td>
			</tr>
			<tr class="gradeX">
				<td>Misc</td>
				<td>Dillo 0.8</td>
				<td>Embedded devices</td>
				<td class="center">-</td>
				<td class="center">X</td>
			</tr>
			<tr class="gradeX">
				<td>Misc</td>
				<td>Links</td>
				<td>Text only</td>
				<td class="center">-</td>
				<td class="center">X</td>
			</tr>
			<tr class="gradeX">
				<td>Misc</td>
				<td>Lynx</td>
				<td>Text only</td>
				<td class="center">-</td>
				<td class="center">X</td>
			</tr>
			<tr class="gradeC">
				<td>Misc</td>
				<td>IE Mobile</td>
				<td>Windows Mobile 6</td>
				<td class="center">-</td>
				<td class="center">C</td>
			</tr>
			<tr class="gradeC">
				<td>Misc</td>
				<td>PSP browser</td>
				<td>PSP</td>
				<td class="center">-</td>
				<td class="center">C</td>
			</tr>
			<tr class="gradeU">
				<td>Other browsers</td>
				<td>All others</td>
				<td>-</td>
				<td class="center">-</td>
				<td class="center">U</td>
			</tr>
		</tbody>
	</table>
</body>
</html>