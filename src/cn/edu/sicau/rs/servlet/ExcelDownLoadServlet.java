package cn.edu.sicau.rs.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.function.DataToExcel;
import cn.edu.sicau.rs.model.Model;

public class ExcelDownLoadServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
						throws ServletException,IOException {
		request.setCharacterEncoding("UTF-8");
		Model model = new Model();
		ResultSet rs =null;
				
		try {
			rs = model.getUsers();
			System.out.println(rs.getMetaData().getColumnCount());
			DataToExcel dte = new DataToExcel();
			String path = dte.Excel(rs);
			response.sendRedirect("downLoadServlet?path="+path);
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		this.doGet(request, response);
	}

}
