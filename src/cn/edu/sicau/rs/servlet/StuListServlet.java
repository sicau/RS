package cn.edu.sicau.rs.servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import cn.edu.sicau.rs.bean.Admin;
import cn.edu.sicau.rs.exception.NameNotFound;
import cn.edu.sicau.rs.exception.PasswordError;
import cn.edu.sicau.rs.model.Model;

public class StuListServlet extends HttpServlet{
	public void doGet (HttpServletRequest request, HttpServletResponse response)
				throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		int type = Integer.parseInt(request.getParameter("type"));
		System.out.println("***************");
		System.out.println(type);
		List stuList = null;
		try {
			if(type==0) {
				stuList = model.getAllUsers();
			}else {
				stuList = model.stuList(type);
			}
			
			request.getSession().setAttribute("stuList", stuList); 
			request.getSession().setAttribute("type",type);
			response.sendRedirect("stuList.jsp");
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException , IOException {
		
		this.doGet(request,response);
	}

}
