<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "tools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理</title>

</head>

<body>
   <table width="99%" border="0" align="center" cellpadding="0" cellspacing="0">
       <tr>
           <th>姓名</th>
           <th>性别</th>
           <th>政治面貌</th>
           <th>出生日期</th>
           <th>科类</th>
           <th>外语语种</th>
           <th>考生类别</th>
           <th><input type="checkbox" id="selectAll" onclick="selectAll()"></th>
       </tr>
   </table>
   <form method="post" name="deleteForm">
      <c:forEach var="user" items="$userList">
          <tr align="center">
          	<td><a href="getOneUserSerlvet?id=${user.id }">${user.trueName }</a></td>
          	<th>${user.sex }</th>
          	<th>${user.political }</th>
          	<th>${user.birthday }</th>
          	<th>${user.lang }</th>
          	<th>${user.category }</th>
          	
          </tr>
      </c:forEach>
   </form>

</body>
</html>