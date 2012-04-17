package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.model.Model;

/**
 * Servlet implementation class RefreshServlet
 */
public class RefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RefreshServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		List newsList = null;
		List informList = null;
		try {
			newsList = model.getAllNewses(1);
			informList = model.getAllNewses(0);
			if(!newsList.isEmpty()) {
				request.getSession().setAttribute("newsList", newsList);
			}
			if(!informList.isEmpty()) {
				request.getSession().setAttribute("informList", informList);
			}
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch(Exception e ) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
