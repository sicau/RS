<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>四川农业大学自主招生</title>
	<style type="text/css">
	
</style>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="css/signInfo.css" />
	<link rel="stylesheet" type="text/css" href="css/style.css" />
	
	<script type="text/javascript" src="js/jquery-1.7.1.js" ></script>
	<script type="text/javascript" src="js/CJL.0.1.min.js"></script>
	<script type="text/javascript" src="js/ImagePreviewd.js"></script>
	<script type="text/javascript" src="js/spin.min.js"></script>
	<script type="text/javascript" src="js/signInfo.js"></script>
	<script type="text/javascript" src="DatePicker/WdatePicker.js"></script>
	   
</head>
<body>
	<%
	if(request.getAttribute("username") == null && request.getSession().getAttribute("username")==null ) { 
		response.sendRedirect("index.jsp");
	} 
	%>
	<div id="main_container">
		<%@include file="header.jsp" %>
		<div class="menu">
	    	<ul>                                                                         
	    		<li><a href="index.jsp">首页</a></li>
	            <li><a href="stuRegister.jsp">考生注册</a></li>
	            <li><a href="newsCenter.jsp">新闻中心</a></li>
	            <li><a href="#">联系我们</a></li>
	    	</ul>
	   	 </div>
		
		<div class="center_content">
		 <%if (request.getAttribute("username")!=null) {%>
			<form action="saveSignInfo" method = "post" enctype="multipart/form-data">
		<%} else { %>
			<form action="updateSignInfo" method = "post" enctype="multipart/form-data">
		<%} %>
   
	   	<input type="hidden" name="id" id="id" value="${user.id}"/>
	   	<input type="hidden" name="isUpload" id="isUpload" />
	   	<input type="hidden" name="password" id="password" value="${password}" />
	   	<input type="hidden" name="username" id="username" value="${username}" />
	    <div class="signInfo signInfo-container">
		      <table width="811" height="661" border="1" >
		      	  <h2>四川农业大学2012年自主选拔录取考生报名表</h2>
		      	  <br/> 
				  <tr>
				    <td height="55" width="179"><div align="center">考生号</div></td>
				    <td colspan="2">&nbsp;</td>
				    <td width="114"><div align="center">报名编号</div></td>
				    <td colspan="2">&nbsp;</td>
				  </tr>
				  <tr>
				    <td height="60"><div align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</div></td>
				    <td width="148">
				    	<input class="input-small" type="text" id="truename" name="truename" value="${user.trueName}"/>
				    	<p class="help-block truename"></p> 
				    </td>
				    <td width="60"><div align="center">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 别</div></td>
				    <td colspan="2">
				    	<select name="sex">
				    		<option value="男" <c:if test="${user.sex=='男'}">selected</c:if> >男</option>
				    		<option value="女" <c:if test="${user.sex=='女'}">selected</c:if> >女</option>
				    	</select>
				    </td>
				    <td width="149" rowspan="3">
				    	<a href="#" class="thumbnail">
				    		<img id="upload-preview" />
				    		<img id="img-preview" <c:if test="${user.src!=null}">src="<%=request.getContextPath()%>/${user.src}"</c:if> />
				    	</a>
				    	<input type="file" id="selimg" name="selimg" />
				    	<p class="help-block selimg"></p> 
				    </td>
				  </tr>
				  <tr>
				    <td height="60"><div align="center">出生日期</div></td>
				    <td>
				    	<input type="text" id="birthday" name="birthday" value="${user.birthday}"  />
				    	<p class="help-block birthday"></p> 
				    </td>
				    <td><div align="center">政治面貌</div></td>
				    <td colspan="2">
				    	<select name="politics" id="politics">
				    		<option value="群众" <c:if test="${user.politics=='群众'}">selected</c:if> >群众</option>
				    		<option value="团员" <c:if test="${user.politics=='团员'}">selected</c:if> >团员</option>
				    		<option value="党员" <c:if test="${user.politics=='党员'}">selected</c:if> >党员</option>
				    	</select>
				    </td>
				  </tr>
				  <tr>
				    <td height="60"><div align="center">身份证号</div></td>
				    <td>
				    	<input type="text" id="identity" name="identity" value="${user.identity}"/>
				    	<p class="help-block identity"></p> 
				    </td>
				    <td><div align="center">科&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类</div></td>
				    <td colspan="2">
				    	<select name="subject" id="subject">
				    		<option value="文科" <c:if test="${user.subject=='文科'}">selected</c:if> >文科</option>
				    		<option value="理科" <c:if test="${user.subject=='理科'}">selected</c:if> >理科</option>
				    	</select>
				    </td>
				  </tr>
				  <tr>
				    <td height="60"><div align="center">中学名称</div></td>
				    <td>
				    	<input type="text" id="school" name="school" value="${user.school}"/>
				    	<p class="help-block school"></p> 
				    </td>
				    <td><div align="center">本人电话</div></td>
				    <td>
				    	<input type="text" id="mphone" name="mphone" value="${user.mphone}"/>
				    	<p class="help-block mphone"></p> 
				    </td>
				    <td width="73"><div align="center">住宅电话</div></td>
				    <td>
				    	<input type="text" id="phone" name="phone" value="${user.phone}"/>
				    	<p class="help-block phone"></p> 
				    </td>
				  </tr>
				  <tr>
				    <td><div align="center">中学通讯地址及邮编</div></td>
				    <td colspan="3">
				    	<input type="text" id="sa" name="sa" class="long-input" value="${user.sa}"/>
				    	<p class="help-block sa"></p> 
				    	<input type="text" id="spostcode" name="spostcode" value="${user.spostcode}"/>
				    	<p class="help-block spostcode"></p> 
				    </td>
				    <td><div align="center">外语语种</div></td>
				    <td>
				    	<input type="text" id="lang" name="lang" value="${user.lang}"/>
				    	<p class="help-block lang"></p> 
				    </td>
				  </tr>
				  <tr>
				    <td><div align="center">家庭通讯地址及邮编</div></td>
				    <td colspan="3">
				    	<input type="text" id="ha" name="ha" class="long-input" value="${user.ha}"/>
				    	<p class="help-block ha"></p> 
				    	<input type="text" id="homepostcode" name="hpostcode" value="${user.hpostcode}"/>
				    	<p class="help-block homepostcode"></p> 
				    </td>
				    <td><div align="center">考生类别</div></td>
				    <td>
				    	<select  name="category" id="category">
				    		<option value="城市应届" <c:if test="${user.category=='城市应届'}">selected</c:if> >城市应届</option>
				    		<option value="农村应届" <c:if test="${user.category=='农村应届'}">selected</c:if> >农村应届</option>
				    		<option value="城市往届" <c:if test="${user.category=='城市往届'}">selected</c:if> >城市往届</option>
				    		<option value="农村往届" <c:if test="${user.category=='农村往届'}">selected</c:if> >农村往届</option>
				    	</select>
				    	
				    </td>
				  </tr>
				  <tr>
				    <td height="153"><div align="center">个人获奖情况（仅限高中阶段）请注明获奖时间</div></td>
				    <td colspan="5">
				    	<textarea  rows="4" class="long-textarea" id="prize" name="prize">${user.prize}</textarea>
				    </td>
				  </tr>
				  <tr>
				    <td height="129"><div align="center">个人特长及社会实践活动等方面所获得的成绩</div></td>
				    <td colspan="5">
				    	<textarea rows="4" class="long-textarea" id="speciality" name="speciality">${user.speciality}</textarea>
				    </td>
				  </tr>
				</table>
		    </div>
		    
		    <div class="form-actions">
					<%if (request.getAttribute("username")!=null) {%>
						<input type="button" class="btn btn-primary save" value="注册" />
					<%} else { %>
					<c:if test="${user.type<2}">
						<input type="button" class="btn btn-primary update" value="更新" />
					</c:if> 
					<%} %>
				
				 <%if (request.getSession().getAttribute("username")!=null) {%>
				 	<a class="btn-success btn" href="downWordServlet?id=${user.id}"><i class="icon-download-alt"></i>下载</a>
				<%} %>
				
		    </div>
		   
		   </form>
		   
		</div>
		
	    <%@include file="footer.jsp" %>
	</div>

</body>
</html>