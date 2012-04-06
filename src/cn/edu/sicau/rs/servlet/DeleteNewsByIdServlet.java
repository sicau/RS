package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.model.Model;

/**
 * Servlet implementation class DeleteNewsByIdServlet
 */
public class DeleteNewsByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNewsByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String str_id = request.getParameter("id");
		System.out.println(str_id);
		int id = Integer.parseInt(str_id);
//		String str_ids[] = null;
//		if(str_id != "") {
//			str_ids = str_id.split(",");
//		}
//		int[] ids = new int[str_ids.length];
//		for(int i=0;i<str_ids.length;i++) {
//			ids[i] = Integer.parseInt(str_ids[i]);
//		}
		Model model = new Model();
		if(model.delNews(id)) {
			response.sendRedirect("GetAllNewsServlet");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
