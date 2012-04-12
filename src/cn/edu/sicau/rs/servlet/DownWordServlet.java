package cn.edu.sicau.rs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.DocumentException;

import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.common.CreateWord;
import cn.edu.sicau.rs.model.Model;

public class DownWordServlet extends HttpServlet {
	public void doGet (HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		int id =Integer.parseInt(request.getParameter("id"));
		Model model = new Model();
	    User user = model.getUser(id);
	    user.setSrc(request.getSession().getServletContext().getRealPath("upload")+"\\"+user.getSrc());
	    CreateWord word=new CreateWord();
		try {
			word.createRTF(user,response);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	    
	}
	
	public void doPost (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		this.doGet(request, response);
	}

	//test
}
