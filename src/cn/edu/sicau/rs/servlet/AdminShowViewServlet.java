package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.model.Model;

public class AdminShowViewServlet extends HttpServlet{
	public void doGet (HttpServletRequest request, HttpServletResponse response)
				throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id=**************"+id);
		Admin admin = null;
		try {
			admin = model.getAdmin(id);
			request.getSession().setAttribute("admin", admin); 
			response.sendRedirect("adminShowView.jsp");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException , IOException {
		
		this.doGet(request,response);
	}
}