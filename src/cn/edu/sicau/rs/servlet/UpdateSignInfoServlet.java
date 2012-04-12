package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;


import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.exception.PictureErrorException;
import cn.edu.sicau.rs.function.Picture;
import cn.edu.sicau.rs.model.Model;

public class UpdateSignInfoServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		int upload = Integer.parseInt(request.getParameter("upload"));
		int id = Integer.parseInt(request.getParameter("id"));
		Model model = new Model();
		Picture picture = new Picture();
		try {
			String src = picture.uploadImg(request);
			User user = model.getUser(id);
			user.setTrueName((String)request.getSession().getAttribute("truename"));
			user.setTestNumber("123446");
			user.setSex((String)request.getSession().getAttribute("sex"));
			user.setBirthday((String)request.getSession().getAttribute("birthday"));
			user.setPolitics((String)request.getSession().getAttribute("politics"));
			user.setIdentity((String)request.getSession().getAttribute("identity"));
			user.setSubject((String)request.getSession().getAttribute("subject"));
			user.setSchool((String)request.getSession().getAttribute("school"));
			user.setPhone((String)request.getSession().getAttribute("phone"));
			user.setMphone((String)request.getSession().getAttribute("mphone"));
			user.setSa((String)request.getSession().getAttribute("sa"));
			user.setSpostcode((String)request.getSession().getAttribute("spostcode"));
			user.setHa((String)request.getSession().getAttribute("ha"));
			user.setHpostcode((String)request.getSession().getAttribute("hpostcode"));
			user.setLang((String)request.getSession().getAttribute("lang"));
			user.setCategory((String)request.getSession().getAttribute("category"));
			user.setPrize((String)request.getSession().getAttribute("prize"));
			user.setSpeciality((String)request.getSession().getAttribute("speciality"));
			
			if(upload == 1) {
				user.setSrc(src);
			}
			
			model.updateUser(user);
			request.getRequestDispatcher("selfHome.jsp").forward(request, response);
		} catch(PictureErrorException e) {
			request.setAttribute("massage", e.getMessage());
		}
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		this.doGet(request, response);
	}

	
}
