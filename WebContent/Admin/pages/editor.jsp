<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>新闻发布中心</title>
	<link rel="stylesheet" href="../../kindeditor/themes/default/default.css"/>
	<link rel="stylesheet" href="../../kindeditor/plugins/code/prettify.css"/>
	
	<script charset="utf-8" src="../../kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="../../kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="../../kindeditor/plugins/code/prettify.js"></script>
	<script type="text/javascript">
		 var editor;
	     KindEditor.ready(function(K) {
	             editor = K.create('#editor_id');
	     });
	     
	     var options = {
	    	        cssPath : '/css/index.css',
	    	        filterMode : true
	    	};
	    	var editor = K.create('textarea[name="content"]', options);

	    	html = editor.html();
	</script>
</head>
<body>
	<form name="form1" action="AddNewsServlet" method="post">
		<table width="800px" height="300px" border="01">
			<tr>
				<td width="100">新闻类型</td>
				<td>
					<input type="radio" name="type" value="1" >通知公告
					<input type="radio" name="type" value="2">招生新闻
				</td>
				<td>新闻标题</td>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr>
				<td >作&nbsp;&nbsp;&nbsp;&nbsp;者</td>
				<td><input type="text" name="author"></td>
				<td >发布时间</td>
				<td><input type="text" name="time"/></td>
			</tr>
			<tr>
				<td>新闻内容</td>
				<td colspan="3">
			        <textarea id="editor_id" name="content" style="width:700px;height:300px;">
			           &lt;strong&gt;HTML内容&lt;/strong&gt;
					</textarea>
				</td>
		  	</tr>
		  	<tr>
		  		<td align="center" colspan="4"><input type="submit" name="submit" value="提交"></td>
		  	</tr>
		</table>
	</form>
</body>
</html>
