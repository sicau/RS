package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.model.Model;

public class ChangeStuStatusServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id")); 
		String type = request.getParameter("type");
		Model model = new Model();
		User user = new User();
		System.out.println("*************type:*"+type);
		System.out.println("*************id:*"+id);
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		this.doGet(request, response);
	}

}