//package cn.edu.sicau.rs.servlet;
//
//import java.io.DataInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class UploadServlet extends HttpServlet{
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//					throws ServletException , IOException {
//		int max_size = 10240*10240;    
//		String rootPath;
//		DataInputStream in = null;
//		FileOutputStream fout = null;
//		String remoteAddr = request.getRemoteAddr();
//		String serverName = request.getServerName();
//		String realPath = this.getServletContext().getRealPath("/");
//		System.out.println(realPath);
//		realPath = realPath + "\\upload\\";
//		
//		String contentType = request.getContentType();
//		try {
//			if(contentType.indexOf("multipart/form-data")>=0) {
//				in = new DataInputStream(request.getInputStream());
//				int formDataLength = request.getContentLength();
//				if(formDataLength > max_size) {
//					request.setAttribute("massage", "ͼƬ����");
//					request.getRequestDispatcher("index.jsp").forward(request, response);
//				}
//				//   �����ϴ��ļ�������
//				byte dataBytes[] = new byte[formDataLength];
//				int byteRead = 0;
//				int totalBytesRead = 0;
//				//�ϴ������ݲ�����byte����
//				while(totalBytesRead < formDataLength) {
//					byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
//					totalBytesRead += byteRead;
//				}
//				//����byte���鴴���ַ���
//				String file = new String(dataBytes);
//				//out.println(file);
//				String saveFiel = file.substring(file.indexOf("filename=\") + 10);
//			}
//		}
//		
//	}
//
//}
