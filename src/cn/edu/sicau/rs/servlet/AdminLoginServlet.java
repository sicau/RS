package cn.edu.sicau.rs.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.exception.NameNotFound;
import cn.edu.sicau.rs.exception.PasswordError;
import cn.edu.sicau.rs.model.Model;

public class AdminLoginServlet extends HttpServlet{
	public void doGet (HttpServletRequest request, HttpServletResponse response)
				throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		String adminname = request.getParameter("adminname");
		String password = request.getParameter("password");
		Admin admin = new Admin();
		admin.setAdminName(adminname);
		admin.setPassword(password);
		Model model = new Model();
		try {
			admin = model.login(admin);
			request.getSession().setAttribute("admin", admin);
			String href = request.getContextPath()+"/Admin/pages/adminHome.jsp";
			response.sendRedirect(href);
		
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException , IOException {
		this.doGet(request,response);
	}

}
