package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.model.Model;

public class UpdateSignInfoServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException , IOException {
		
		request.setCharacterEncoding("UTF-8");

		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("user_id")));
		user.setTrueName(request.getParameter("truename"));
		user.setTestNumber("123446");
		user.setSex(request.getParameter("sex"));
		user.setBirthday(request.getParameter("birthday"));
		user.setPolitics(request.getParameter("politics"));
		user.setIdentity(request.getParameter("identity"));
		user.setSubject(request.getParameter("subject"));
		user.setSchool(request.getParameter("school"));
		user.setPhone(request.getParameter("phone"));
		user.setMphone(request.getParameter("mphone"));
		user.setSa(request.getParameter("sa"));
		user.setSpostcode(request.getParameter("spostcode"));
		user.setHa(request.getParameter("ha"));
		user.setHpostcode(request.getParameter("hpostcode"));
		user.setLang(request.getParameter("foreign"));
		user.setCategory(request.getParameter("category"));
		user.setPrize(request.getParameter("prize"));
		user.setSpeciality(request.getParameter("speciality"));
		
		Model model = new Model();
		if(model.updateSignInfo(user)) {
			response.sendRedirect("stuLogin.jsp");
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		     
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		this.doGet(request, response);
	}

	//test
}
