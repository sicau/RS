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
		String adminname = request.getParameter("Name");
		String password = request.getParameter("Password");
		Admin admin = new Admin();
		admin.setAdminName(adminname);
		admin.setPassword(password);
		Model model = new Model();
		try {
			if(model.login(admin)) {
				ServletContext context = this.getServletContext();
				List adminList = (List) context.getAttribute("adminList");
				if(!adminList.contains("admin")) {
					request.getSession().setAttribute("admin", admin);
					String href = request.getContextPath()+"/Admin/pages/adminConter.jsp";
					response.sendRedirect(href);
				} else {
					request.setAttribute("message", "ÒÑµÇÂ¼");
					request.getRequestDispatcher("Admin/pages/adminLogin.jsp").forward(request, response);
				}
			}
		} catch (NameNotFound nnf) {
			request.setAttribute("message", nnf.getMessage());
			request.getRequestDispatcher("Admin/pages/adminLogin.jsp").forward(request, response);
		} catch (PasswordError pe) {
			request.setAttribute("message", pe.getMessage());
			request.getRequestDispatcher("Admin/pages/adminLogin.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException , IOException {
		
		this.doGet(request,response);
	}

}
