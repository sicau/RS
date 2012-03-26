package cn.edu.sicau.rs.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFileServlet
 */
public class DeleteFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteFileServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		request.getParameter("path");
		try {
			File file = new File("path");
			file.delete();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
