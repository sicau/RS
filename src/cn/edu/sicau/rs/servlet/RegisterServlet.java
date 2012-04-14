package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.model.Model;

public class RegisterServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String code = (String) request.getSession().getAttribute("randomCode");
		System.out.println("code="+code);
	    
	    request.getSession().setAttribute("username",username);
	    request.getSession().setAttribute("password",password);
	    request.getSession().setAttribute("status","register");
	    request.getRequestDispatcher("signInfo.jsp").forward(request, response);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		this.doGet(request, response);
	}

	//test
}
