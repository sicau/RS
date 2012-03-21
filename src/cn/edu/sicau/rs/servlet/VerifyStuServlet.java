package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.model.Model;

public class VerifyStuServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		String userid = (String) request.getAttribute("userid");
		String usertype = (String) request.getAttribute("usertype");
		int id = new Integer(userid);
		int type = new Integer(usertype);
		Model model = new Model();
		if(model.verifyStu(id, type)) {
			request.setAttribute("massage", "设置成功！");
			request.getRequestDispatcher("stuList.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "设置失败！");
		}
	}

}
