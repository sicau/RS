<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>四川农业大学自主招生</title>
	<style type="text/css">
	
</style>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/signInfo.css" />
	
	<script type="text/javascript" src="js/jquery-1.7.1.js" ></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/CJL.0.1.min.js"></script>
	<script type="text/javascript" src="js/ImagePreviewd.js"></script>
	<script type="text/javascript" src="js/signInfo.js"></script>
	
</head>
<body>
   <%@include file="nav.jsp" %>
   
   
  <form action="updateSignInfo" method = "post">	
   	<input type="hidden" name="user_id" id="user_id" value="${user.id}"/>
    <div class="signInfo signInfo-container">
 	
      <table width="831" height="661" border="1">
      	  <h2>四川农业大学2012年自主选拔录取考生报名表</h2>
      	  <br/> 
		  <tr>
		    <td width="179"><div align="center">考生号</div></td>
		    <td colspan="2">&nbsp;</td>
		    <td width="114"><div align="center">报名编号</div></td>
		    <td colspan="2">&nbsp;</td>
		  </tr>
		  <tr>
		    <td height="49"><div align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</div></td>
		    <td width="198">
		    	<input type="text" id="truename" name="truename" value="${user.trueName}"/>
		    </td>
		    <td width="78"><div align="center">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 别</div></td>
		    <td colspan="2">
		    	<select>
		    		<option value="男" {if user.sex == '男'}selected{{/if}}>男</option>
		    		<option value="女" {if user.sex == '女'}selected{{/if}}>女</option>
		    	</select>
		    </td>
		    <td width="149" rowspan="3">
		    	<a href="#" class="thumbnail">
		    		<img id="img-preview" />
		    	</a>
		    	<input type="file" name="selimg" id="selimg">
		    </td>
		  </tr>
		  <tr>
		    <td height="50"><div align="center">出生日期</div></td>
		    <td>
		    	<input type="text" id="birthday" name="birthday" value="${user.birthday}"/>
		    </td>
		    <td><div align="center">政治面貌</div></td>
		    <td colspan="2">
		    	<input type="text" id="politics" name="politics" value="${user.politics}" />
		    </td>
		  </tr>
		  <tr>
		    <td height="52"><div align="center">身份证号</div></td>
		    <td>
		    	<input type="text" id="identity" name="identity" value="${user.identity}"/>
		    </td>
		    <td><div align="center">科&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类</div></td>
		    <td colspan="2">
		    	<input type="text" id="subject" name="subject" value="${user.subject}" />
		    </td>
		  </tr>
		  <tr>
		    <td><div align="center">中学名称</div></td>
		    <td>
		    	<input type="text" id="school" name="school" value="${user.school}"/>
		    </td>
		    <td><div align="center">本人电话</div></td>
		    <td>
		    	<input type="text" id="mphone" name="mphone" value="${user.mphone}"/>
		    </td>
		    <td width="73"><div align="center">住宅电话</div></td>
		    <td>
		    	<input type="text" id="phone" name="phone" value="${user.phone}"/>
		    </td>
		  </tr>
		  <tr>
		    <td><div align="center">中学通讯地址及邮编</div></td>
		    <td colspan="3">
		    	<input type="text" id="SA" name="SA" value="${user.sa}"/>
		    	<input type="text" id="spostcode" name="spostcode" value="${user.spostcode}"/>
		    </td>
		    <td><div align="center">外语语种</div></td>
		    <td>
		    	<input type="text" id="lang" name="lang" value="${user.lang}"/>
		    </td>
		  </tr>
		  <tr>
		    <td><div align="center">家庭通讯地址及邮编</div></td>
		    <td colspan="3">
		    	<input type="text" id="HA" name="HA" value="${user.ha}"/>
		    	<input type="text" id="hpostcode" name="hpostcode" value="${user.hpostcode}" />
		    </td>
		    <td><div align="center">考生类别</div></td>
		    <td>
		    	<input type="text" id="category" name="category" value="${user.category}"/>
		    </td>
		  </tr>
		  <tr>
		    <td height="153"><div align="center">个人获奖情况（仅限高中阶段）请注明获奖时间</div></td>
		    <td colspan="5">
		    	<textarea id="prize" name="prize">${user.prize}</textarea>
		    </td>
		  </tr>
		  <tr>
		    <td height="129"><div align="center">个人特长及社会实践活动等方面所获得的成绩</div></td>
		    <td colspan="5">
		    	<textarea id="speciality" name="speciality">${user.speciality}</textarea>
		    </td>
		  </tr>
		</table>
		
 	
    </div> <!-- /container -->
    
    <div class="form-actions">
        	<button type="submit" class="btn btn-primary">提交</button>
            <a class="btn">取消</a>
            <a href="downInfo.jsp">下载</a>
    </div>
   
   </form>
</body>
</html>