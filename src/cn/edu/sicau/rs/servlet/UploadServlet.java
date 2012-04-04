package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.exception.PictureErrorException;
import cn.edu.sicau.rs.function.Picture;


public class UploadServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		String dsf = "fdskf";
		String path = null;
		Picture picture = new Picture();
		try{
			path = picture.uploadImg(request);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch(PictureErrorException e) {
			request.getRequestDispatcher("selfHome.jsp").forward(request, response);
			request.setAttribute("massage", e.getMessage());
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException , IOException {
		this.doPost(request, response);
	}
   
	
}

