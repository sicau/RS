<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="../../css/stuShowView.css" />
	
	<title>学生个人信息</title>
</head>
<body>
	<%@include file="navbar.jsp" %>
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
		    		<img id="img-preview" src="<%=request.getContextPath()%>/${user.src}" />
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
    
   		<form class="form-actions well form-inline" action="changeStuStatusServlet">
   		 	<input type="hidden" name="id" id="id" value="${user.id}"/>
   			<label>考生状态:</label>
   			<select class="check-result" name="type">
   				 <option value ="0" <c:if test="${user.type==0}">selected</c:if> >审核中</option>
				 <option value ="1" <c:if test="${user.type==1}">selected</c:if> >审核未通过</option>
				 <option value="2" <c:if test="${user.type==2}">selected</c:if> >通过审核</option>
				 <option value="3" <c:if test="${user.type==3}">selected</c:if> >已缴费</option>
				 <option value ="4" <c:if test="${user.type==4}">selected</c:if> >通过初试</option>
				 <option value="5" <c:if test="${user.type==5}">selected</c:if> >通过复试</option>
				 <option value="6" <c:if test="${user.type==6}">selected</c:if> >已录取</option>
   			</select>
        	<button type="submit" class="btn btn-primary">提交</button>
            <a class="btn" href="adminHome.jsp">返回</a>
        </form>
   	
</body>
</html>