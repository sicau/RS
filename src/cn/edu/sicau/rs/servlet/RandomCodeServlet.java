package cn.edu.sicau.rs.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

public class RandomCodeServlet extends HttpServlet {

	// ��֤��Ŀ��
	private int width = 60;

	// ��֤��ĸ߶�
	private int height = 20;

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		// ����һ�������������
		Random random = new Random();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�����
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		g.setFont(font);
		// ���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		// �������160��������,ʹͼ���е���֤�벻�ױ���������̽�⵽
		g.setColor(Color.GRAY);
		for (int i = 0; i < 160; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x1, y1);
		}
		// randomCode���ڱ��������������֤�룬�Ա����û���¼�������֤
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		// �������4λ���ֵ���֤��
		for (int i = 0; i < 4; i++) {
			// �õ������������֤������
			String strRand = String.valueOf(random.nextInt(10));
			// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ
			red = random.nextInt(110);
			green = random.nextInt(50);
			blue = random.nextInt(50);
			// �������������ɫ����֤����Ƶ�ͼ����
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, 13 * i + 6, 16);
			// ���������ĸ�����������һ��
			randomCode.append(strRand);
		}
		// ����λ���ֵ���֤�뱣�浽Session��
		HttpSession session = req.getSession();
		session.setAttribute("randomCode", randomCode.toString());
		// ��ֹͼ�񻺴�
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setContentType("image/jpeg");
		// ��ͼ�������Servlet�������
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}

}
