package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.exception.ErrPwdException;
import cn.edu.sicau.rs.exception.NameNotFoundException;
import cn.edu.sicau.rs.model.Model;


public class ShowSignInfoServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		Model model = new Model();
			User user = model.getUser(id);
//			ServletContext context = this.getServletContext();    //设置上下文
//			List nameList = (List) context.getAttribute("nameList");   
//			
//			request.getSession().setAttribute("username", username);    //在监听器中会把username放入namelist中
			user.setSrc("upload/"+user.getSrc());
			request.getSession().setAttribute("user", user);  
			request.setAttribute("status","update");
			response.sendRedirect("signInfo.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}