package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.model.Model;

public class RegesitServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username="+username);
		      Model model = new Model();
		      if(model.checkNameExist(username)) {
		    	  response.sendRedirect("errRegister.jsp");
		      } else {
			      User user = new User();
			      user.setUserName(username);
			      user.setPassword(password);
			      
			      if(model.saveUser(user)) {
			    	  request.getSession().setAttribute("user", user);
			    	  response.sendRedirect("index.jsp");
			      } else {   //thinking
			    	  response.sendRedirect("errRegister.jsp");
			      }
		      }
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		this.doGet(request, response);
	}

}
