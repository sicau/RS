package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.model.Model;

public class AdminUpdatePwdServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response)
				throws ServletException , IOException {
		request.setCharacterEncoding("GBK");
		String password = request.getParameter("password");
		String adminname = request.getParameter("adminname"); 
		Admin admin = new Admin();
		admin.setAdminName(adminname);
		admin.setPassword(password);
		Model model = new Model();
		if(model.updatePassword(admin)) {
			request.setAttribute("message", "更改成功！！！");
			request.getRequestDispatcher("").forward(request, response);
		} else {
			request.getRequestDispatcher("").forward(request, response);
		}
	}
	
	public void goPost (HttpServletRequest request, HttpServletResponse response )
					throws ServletException , IOException {
		this.doGet(request , response);
	}

}
