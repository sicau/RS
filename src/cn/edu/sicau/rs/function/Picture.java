package cn.edu.sicau.rs.function;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.sicau.rs.exception.PictureErrorException;

public class Picture {
	public String uploadImg(HttpServletRequest request) throws UnsupportedEncodingException{
		
		final long MAX_SIZE = 3*1024*1024;
		
		String filename = null;
		DiskFileItemFactory dfif = new DiskFileItemFactory();   
	    dfif.setSizeThreshold(4096);
	    String route= request.getSession().getServletContext().getRealPath("upload")+"\\";
	    System.out.println(route);
	    dfif.setRepository(new File(route));
	    
	    ServletFileUpload sfu = new ServletFileUpload(dfif);
	    sfu.setSizeMax(MAX_SIZE);
	    List fileList = null;
	    try {
	    	fileList = sfu.parseRequest(request);
	    } catch(FileUploadException e){
	    	if(e instanceof SizeLimitExceededException) {
	    		throw new PictureErrorException("图片过大！");
	    	}
	    	e.printStackTrace();
	    }
	    
	    if(fileList == null || fileList.size() == 0) {
    		throw new PictureErrorException("上传图片错误，没有选择图片！");
	    }

	    Iterator fileItr = fileList.iterator();
	    while (fileItr.hasNext()) {
	    	FileItem fileItem = null;
	    	String path = null;
	    	long size = 0;
	    	
	    	fileItem = (FileItem) fileItr.next();
	    	if (fileItem.isFormField()) {
	    		String content = fileItem.getString("UTF-8");        
	    		String fieldName = fileItem.getFieldName();
	    		//System.out.println(fieldName);
	    		//System.out.println(content);
	    		request.getSession().setAttribute(fieldName, content);
	    		
	    	}else {
	    		path = fileItem.getName();     //得到文件的完整路径
		    	size = fileItem.getSize();     //get file size
		    	if("".equals(path)||size == 0) {
		    		throw new PictureErrorException("上传有误！");
		    	}
		    	String t_name = path.substring(path.lastIndexOf("\\") + 1);
		    	String t_ext = t_name.substring(t_name.lastIndexOf(".") + 1);
		    	
		    	long now = System.currentTimeMillis();
		    	String prefix = String.valueOf(now);
		    	String u_name = now+"."+t_ext;    //重命名
		    	try {
		    		fileItem.write(new File(route, u_name));
		    		System.out.println(route+u_name);
		    		filename = u_name;
		    	} catch(Exception e) {
		    		e.printStackTrace();
		    	}
	    	}
	    	  
	    }
	    return filename;
	}

}
