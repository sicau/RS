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
			if(model.login(admin)) {
				ServletContext context = this.getServletContext();
				List adminList = (List) context.getAttribute("adminList");
				System.out.println(adminList.size());
				if(!adminList.contains("admin")) {
					request.getSession().setAttribute("admin", admin);
					response.sendRedirect("WebContent/WEB-INF/admin/pages/adminConter.jsp");
				} else {
					request.setAttribute("message", "�ѵ�¼");
					request.getRequestDispatcher("WebContent/WEB-INF/admin/pages/adminLogin.jsp").forward(request, response);
				}
			}
		} catch (NameNotFound nnf) {
			request.setAttribute("message", nnf.getMessage());
			request.getRequestDispatcher("WebContent/WEB-INF/admin/pages/").forward(request, response);
		} catch (PasswordError pe) {
			request.setAttribute("message", pe.getMessage());
			request.getRequestDispatcher("").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException , IOException {
		
		this.doGet(request,response);
	}

}