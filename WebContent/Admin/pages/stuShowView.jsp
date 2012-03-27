<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="navbar.jsp" %>
	<form action="updateSignInfo" method = "post">	
   	<input type="hidden" name="id" id="id" value="${user.id}"/>
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
		    <td width="198">${user.trueName}</td>
		    <td width="78"><div align="center">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 别</div></td>
		    <td colspan="2">${user.sex}</td>
		    <td width="149" rowspan="3">
		    	<a href="#" class="thumbnail">
		    		<img id="img-preview" />
		    	</a>
		    </td>
		  </tr>
		  <tr>
		    <td height="50"><div align="center">出生日期</div></td>
		    <td>${user.birthday}</td>
		    <td><div align="center">政治面貌</div></td>
		    <td colspan="2">${user.politics}</td>
		  </tr>
		  <tr>
		    <td height="52"><div align="center">身份证号</div></td>
		    <td>${user.identity}</td>
		    <td><div align="center">科&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类</div></td>
		    <td colspan="2">${user.subject}</td>
		  </tr>
		  <tr>
		    <td><div align="center">中学名称</div></td>
		    <td>${user.school}</td>
		    <td><div align="center">本人电话</div></td>
		    <td>${user.mphone}</td>
		    <td width="73"><div align="center">住宅电话</div></td>
		    <td>${user.phone}</td>
		  </tr>
		  <tr>
		    <td><div align="center">中学通讯地址及邮编</div></td>
		    <td colspan="3">
		    	${user.sa}
		    	<br/>
		    	${user.spostcode}
		    </td>
		    <td><div align="center">外语语种</div></td>
		    <td>${user.lang}</td>
		  </tr>
		  <tr>
		    <td><div align="center">家庭通讯地址及邮编</div></td>
		    <td colspan="3">
		    	${user.ha}
		    	<br/>
		    	${user.hpostcode}
		    </td>
		    <td><div align="center">考生类别</div></td>
		    <td>${user.category}</td>
		  </tr>
		  <tr>
		    <td height="153"><div align="center">个人获奖情况（仅限高中阶段）请注明获奖时间</div></td>
		    <td colspan="5">
		    	${user.prize}
		    </td>
		  </tr>
		  <tr>
		    <td height="129"><div align="center">个人特长及社会实践活动等方面所获得的成绩</div></td>
		    <td colspan="5">
		    	${user.speciality}
		    </td>
		  </tr>
		</table>
		
 	
    </div> <!-- /container -->
    
    <div class="form-actions">
        	<button type="submit" class="btn btn-primary">提交</button>
            <a class="btn">取消</a>
    </div>
   
   </form>
	
</body>
</html>