<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>新闻发布中心</title>
	
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../../css/dataTable.css" />
	<link rel="stylesheet" href="../../kindeditor/themes/default/default.css"/>
	<link rel="stylesheet" href="../../kindeditor/plugins/code/prettify.css"/>
	
	<script charset="utf-8" src="../../kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="../../kindeditor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="../../kindeditor/plugins/code/prettify.js"></script>
	<script type="text/javascript">
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content"]', {
				cssPath : '../../kindeditor/plugins/code/prettify.css',
				uploadJson : '../../kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '../../kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['info'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['info'].submit();
					});
				}
			});
			prettyPrint();
		});

	</script>
</head>
<body>
	<h2>管理新闻</h2>
	<form name="info" action="../../AddNewsServlet" method="post">
		<table width="800px" height="300px"  class="table">
			<tr>
				<td width="100">新闻类型</td>
				<td>
					<input type="radio" name="type" value="0" >通知公告
					<input type="radio" name="type" value="1">招生新闻
				</td>
				<td>新闻标题</td>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr>
				<td >作&nbsp;&nbsp;&nbsp;&nbsp;者</td>
				<td><input type="text" name="author"></td>
				<td >发布时间</td>
				<td><input type="text" name="time" value="now"/></td>
			</tr>
			<tr>
				<td>新闻内容</td>
				<td colspan="3">
			        <textarea id="editor_id" name="content" style="width:700px;height:300px;">
			           &lt;strong&gt;HTML内容&lt;/strong&gt;
					</textarea>
				</td>
		  	</tr>
		  
		</table>
		<div class="form-actions">
			<input type="submit" class="btn btn-primary" name="submit" value="提交" />
		</div>
		
		
	</form>
</body>
</html>
