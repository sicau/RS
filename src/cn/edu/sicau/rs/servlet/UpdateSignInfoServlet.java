package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.exception.PictureErrorException;
import cn.edu.sicau.rs.function.Picture;
import cn.edu.sicau.rs.model.Model;

public class UpdateSignInfoServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException , IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		String dsf = "fdskf";
		Picture picture = new Picture();
		try{
			if(picture.uploadImg(request, dsf)) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("selfHome.jsp").forward(request, response);
			}
		} catch(PictureErrorException e) {
			request.setAttribute("massage", e.getMessage());
		}
		
//		request.setCharacterEncoding("UTF-8");
//		User user = new User();
//		Model model = new Model();
//		int id  = Integer.parseInt(request.getParameter("id"));
//		user = model.getUser(id);
//		
//		user.setTrueName(request.getParameter("truename"));
//		user.setTestNumber("123446");
//		user.setSex(request.getParameter("sex"));
//		user.setBirthday(request.getParameter("birthday"));
//		System.out.println(request.getParameter("birthday"));
//		user.setPolitics(request.getParameter("politics"));
//		user.setIdentity(request.getParameter("identity"));
//		user.setSubject(request.getParameter("subject"));
//		user.setSchool(request.getParameter("school"));
//		user.setPhone(request.getParameter("phone"));
//		user.setMphone(request.getParameter("mphone"));
//		user.setSa(request.getParameter("sa"));
//		user.setSpostcode(request.getParameter("spostcode"));
//		user.setHa(request.getParameter("ha"));
//		user.setHpostcode(request.getParameter("hpostcode"));
//		user.setLang(request.getParameter("lang"));
//		user.setCategory(request.getParameter("category"));
//		user.setPrize(request.getParameter("prize"));
//		user.setSpeciality(request.getParameter("speciality"));
//		
//		try{
//			model.updateSignInfo(user); 
//			response.sendRedirect("selfHome.jsp");
//		} catch(HibernateException e) {
//			e.printStackTrace();
//			request.getRequestDispatcher("index.jsp").forward(request, response);
//		}
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		this.doGet(request, response);
	}

	//test
}
