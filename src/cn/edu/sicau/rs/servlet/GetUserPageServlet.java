package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.UserPager;
import cn.edu.sicau.rs.model.Model;

/**
 * Servlet implementation class GetUserPageServlet
 */
public class GetUserPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type_str = request.getParameter("type");
		String pageOffset_str = request.getParameter("pager.offset");
		String pageSize_str = request.getParameter("pageSize");
		int type = Integer.parseInt(type_str);
		int pageOffset = 0;
		int pageSize = 5;
		int currentPage = 0;
		
		if(pageOffset_str != null && pageSize_str != null) {
			pageOffset = Integer.parseInt(pageOffset_str);
			pageSize = Integer.parseInt(pageSize_str);
		}
		
		Model model = new Model();
		UserPager userPager = model.getUserPage(pageOffset, pageSize, type);
		if(userPager.getUserMap().size() == 0 && pageOffset != 0) {
			pageOffset -= pageSize;
			userPager = model.getUserPage(pageOffset, pageSize, type);
		}
		
		if(pageOffset%pageSize == 0 || pageOffset/pageSize > 0) {
			currentPage = pageOffset/pageSize + 1;
		}
		
		userPager.setPageOffset(pageOffset);
		userPager.setPageSize(pageSize);
		userPager.setCurrentPage(currentPage);
		request.setAttribute("type", type);
		request.setAttribute("userPager", userPager);
		request.setAttribute("userList", userPager.getUserMap().values());
		request.getRequestDispatcher("Admin/pages/stuList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
