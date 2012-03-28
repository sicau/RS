<%@ page language="java" contentType="application/msword; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  long now = System.currentTimeMillis();
  response.setHeader("Content-Disposition", "attachment.filename = "+now);
%>

<html>
 <body width="150mm" height="250">
 	
      <table width="150mm" height="250mm" border="1" align="center" >
      	  <tr height="45">
      	    <td align="center" colspan="6">四川农业大学2012年自主选拔录取考生报名表</td>
      	  </tr> 
      	  
		  <tr>
		    <td width="25mm"><div align="center">考生号</div></td>
		    <td colspan="2">&nbsp;</td>
		    <td width="0"><div align="center">报名编号</div></td>
		    <td colspan="2">&nbsp;</td>
		  </tr>
		  
		  <tr height="45">
		    <td><div align="center">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</div></td>
		    <td width="25">${user.trueName}</td>
		    <td width="25"><div align="center">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</div></td>
		    <td colspan="2">${user.sex}</td>
		    <td width="25" rowspan="3">&nbsp;</td>  <!-- photo -->
		  </tr>
		  
		  <tr height="45">
		    <td><div align="center">出生日期</div></td>
		    <td>
		    	${user.birthday}
		    </td>
		    <td><div align="center">政治面貌</div></td>
		    <td colspan="2">
		    	${user.politics}
		    </td>
		  </tr>
		  
		  <tr height="45">
		    <td><div align="center">身份证号</div></td>
		    <td>
		    	${user.identity}
		    </td>
		    <td><div align="center">科&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类</div></td>
		    <td colspan="2">
		    	${user.subject}
		    </td>
		  </tr>
		  
		  <tr height="45">
		    <td><div align="center">中学名称</div></td>
		    <td>
		    	${user.school}
		    </td>
		    <td><div align="center">本人电话</div></td>
		    <td>
		    	${user.mphone}
		    </td>
		    <td width="10"><div align="center">住宅电话</div></td>
		    <td>
		    	${user.phone}
		    </td>
		  </tr>
		  
		  <tr height="45">
		    <td><div align="center">中学通讯地址及邮编</div></td>
		    <td colspan="3">
		    	${user.sa} ${user.spostcode}
		    </td>
		    <td><div align="center">外语语种</div></td>
		    <td>
		    	${user.lang}
		    </td>
		  </tr>
		  
		  <tr height="45">
		    <td><div align="center">家庭通讯地址及邮编</div></td>
		    <td colspan="3">
		    	${user.ha} ${user.hpostcode}
		    </td>
		    <td><div align="center">考生类别</div></td>
		    <td>
		    	${user.category}
		    </td>
		  </tr>
		  
		  <tr height="129">
		    <td><div align="center">个人获奖情况（仅限高中阶段）请注明获奖时间</div></td>
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
 </body>
</html>