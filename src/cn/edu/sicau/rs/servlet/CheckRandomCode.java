package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.sicau.rs.model.Model;


public class CheckRandomCode extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Model model = new Model();
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String username = URLDecoder.decode(request.getParameter("username"),"UTF-8");
		username = URLDecoder.decode(username,"UTF-8");
		
		
		String code = request.getParameter("code");
		String rcode = (String) request.getSession().getAttribute("randomCode");
		
		if(model.checkNameExist(username)) {
			out.print("exist");
		} else {
			if(code.equals(rcode)) {
				 out.print("success");
			} else {
				 out.print("error");
			}
		}
		
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doGet(request, response);
	}

}
