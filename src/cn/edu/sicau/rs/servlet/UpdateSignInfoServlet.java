package cn.edu.sicau.rs.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;

import com.oreilly.servlet.MultipartRequest;


import cn.edu.sicau.rs.bean.User;
import cn.edu.sicau.rs.exception.PictureErrorException;
import cn.edu.sicau.rs.function.Picture;
import cn.edu.sicau.rs.model.Model;

public class UpdateSignInfoServlet extends HttpServlet {
	public void doPost (HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException , IOException {
		request.setCharacterEncoding("UTF-8");
		int upload = Integer.parseInt(request.getParameter("upload"));
		Model model = new Model();
	
		String path= request.getSession().getServletContext().getRealPath("upload")+"\\";
		File fileDir = new File(path);  
	    if (!fileDir.exists()) {  
	       fileDir.mkdirs();  
	    }  
	    int inmaxPostSize = 10 * 1024 * 1024;  
	    MultipartRequest multirequest = null;  
		
		Picture picture = new Picture();
		try {
			
			multirequest = new MultipartRequest(request, fileDir.getAbsolutePath(), inmaxPostSize, "utf-8"); // utf-8中文编码模式上传文件
		    int id =Integer.parseInt(multirequest.getParameter("id"));
		    User user = model.getUser(id);
	        String newImgPath = "";  
	        Enumeration<String> filedFileNames = multirequest.getFileNames();  
	        String filedName = null;  
			if (null != filedFileNames) {  
			    while (filedFileNames.hasMoreElements()) {  
			        filedName = filedFileNames.nextElement();// 文件文本框的名称   
					File uploadFile = multirequest.getFile(filedName);        
					if(null != uploadFile && uploadFile.length() > 0) {  
					   String imgPath = uploadFile.getName();  
					   int idx = imgPath.lastIndexOf(".");  
					   String extention= imgPath.substring(idx);  
					     
					   java.util.Date dt = new java.util.Date(System.currentTimeMillis());  
					   SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");  
					   String time = fmt.format(dt);  
					   newImgPath = time + extention;  
					   File f = new File(fileDir + "\\" + newImgPath);  
					   uploadFile.renameTo(f);  
					}  
			    }
	        }
			
	        user.setTrueName(multirequest.getParameter("truename"));
			user.setTestNumber("123446");
			user.setSex(multirequest.getParameter("sex"));
			user.setBirthday(multirequest.getParameter("birthday"));
			user.setPolitics(multirequest.getParameter("politics"));
			user.setIdentity(multirequest.getParameter("identity"));
			user.setSubject(multirequest.getParameter("subject"));
			user.setSchool(multirequest.getParameter("school"));
			user.setPhone(multirequest.getParameter("phone"));
			user.setMphone(multirequest.getParameter("mphone"));
			user.setSa(multirequest.getParameter("sa"));
			user.setSpostcode(multirequest.getParameter("spostcode"));
			user.setHa(multirequest.getParameter("ha"));
			user.setHpostcode(multirequest.getParameter("hpostcode"));
			user.setLang(multirequest.getParameter("lang"));
			user.setCategory(multirequest.getParameter("category"));
			user.setPrize(multirequest.getParameter("prize"));
			user.setSpeciality(multirequest.getParameter("speciality"));
			
			if(upload == 1) {
				user.setSrc(newImgPath);
			}
			
			model.updateUser(user);
			request.getSession().setAttribute("id", id);
			request.getRequestDispatcher("selfHome.jsp").forward(request, response);
		} catch(PictureErrorException e) {
			request.setAttribute("massage", e.getMessage());
		}
	}
	
	public void doGet (HttpServletRequest request, HttpServletResponse response)
	           throws ServletException , IOException {
		this.doGet(request, response);
	}

	
}
