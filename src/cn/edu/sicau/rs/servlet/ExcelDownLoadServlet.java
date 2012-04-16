package cn.edu.sicau.rs.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		int type = Integer.parseInt(request.getParameter("type"));
		try {
			rs = model.getUsers(type);
			System.out.println(rs.getMetaData().getColumnCount());
			DataToExcel dte = new DataToExcel();
			String path = dte.Excel(rs);
			path = new String(path.getBytes("iso-8859-1"));
			File file = new File(path);
			InputStream in = new FileInputStream(file);
			OutputStream out = response.getOutputStream();
			response.addHeader("Content-Disposition", "attachment;filename="+
						new String(file.getName().getBytes("UTF-8"),"iso-8859-1"));
			response.addHeader("Content-Length", file.length()+"");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/octet-stream");
			int data = 0;
			while((data = in.read()) != -1) {
				out.write(data);
			}
			out.close();
			in.close();
			file.delete();
	} catch(Exception e) {
		e.printStackTrace();
	} 
}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
						throws ServletException, IOException {
		this.doGet(request, response);
	}

}
