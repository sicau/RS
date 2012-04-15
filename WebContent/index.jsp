<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>四川农业大学自主招生</title>
</head>
<body>

	<div id="main_container">
		<%@include file="header.jsp" %>
		 <div class="menu">
	    	<ul>                                                                         
	    		<li class="selected"><a href="index.jsp">首页</a></li>
	            <li><a href="stuRegister.jsp">考生注册</a></li>
	            <li><a href="#">新闻中心</a></li>
	            <li><a href="#">联系我们</a></li>
	    	</ul>
	   	 </div>
	   	 
	     <div class="center_content">
	     	<div class="center_left">
	        	<div class="title_welcome"><span class="red">招生</span> 公告</div>
	            <div class="welcome_box">
	            <p class="">
					<%@include file="listInform.jsp" %>
				</p>
	            <a href="#" class="read_more">查看更多</a>          
	            </div>
	         
	         
	         <div class="features">   
	            <div class="title">最新新闻</div>
	            <%@include file="listnews.jsp" %>
	         </div> 
	        
	        
	         
	         <div class="features">   
	            <div class="title">招生政策</div>
	                <div class="news_box">
	                    <div class="news_icon"></div>
	                    <div class="news_content">
							 四川农业大学，是一所以生物科技为特色，农业科技为优势，农、理、工、经、管、医、文、教、法多学科协调发展的国家“211工程”重点建设大学， 
							 也是教育部本科教学工作水平评估优秀高校。 新行政办公大楼学校源自1906年创办的四川通省农业学堂，1927年和1935年两次并入四川大学，
							 1956年由四川 大学农学院整体迁往原西康省 （1955年撤销）省会雅安成立四川农学院时任中共中央总书记的胡耀邦同志亲自为川农题写校名，
							 1978年恢复招收研究生，1985年更名为四川农业大学，
	                   </div> 
	                   <a href="aboutSchool.jsp" class="read_more">查看更多</a>  
	                </div>       
	         </div> 
	       </div> 
	      
	        <div class="center_right">
		        <div class="software_box"><img src="img/3dbox.gif" alt="" title="" /></div>
		            <div class="text_box">
		            <div class="title">用户登录</div>
		            	<form action="login" name="login" method="post">
			                <div class="login_form_row">
				                <label class="login_label">用户名:</label>
				                <input type="text" name="username" class="login_input" />
			                </div>
			                <div class="login_form_row">
				                <label class="login_label">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
				                <input type="password" name="password" class="login_input" />
			                </div>                                     
			                <input type="image" src="img/login.gif" class="login" />                              
		            	</form>
		            </div>
		            
		            <div class="testimonials">
		            	<div class="title">学校简介</div>
		                <div class="text_box">
		                 <p class="testimonial">
		                		 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;四川农业大学前身是创办于1906年的四川通省农业学堂，是四川第一所农业学府，1931年成为四川省立农学院，1935年并入国
		                		 立四川大学成为川大农学院，1956年川大农学院迁雅安独立建校为四川农学院，198 5年更名为......
		                 <a href="aboutSchool.jsp" class="read_more">查看更多</a>
		                 
		                 </p>
		                </div>                    
		            </div>
	        </div>
	          
	        <div class="clear"></div> 
	    </div>    
	
	    <%@include file="footer.jsp" %>
	    
	</div>
</body>
</html>