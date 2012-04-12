package cn.edu.sicau.rs.common;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sicau.rs.bean.User;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.rtf.RtfWriter2;

public class CreateWord {
	
	public CreateWord() {
	}

	public void createRTF(User user,HttpServletResponse response) throws FileNotFoundException, DocumentException,
			MalformedURLException, IOException {
		OutputStream outputStream = response.getOutputStream();
		// 创建word文档
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		// 输入word文档
		RtfWriter2.getInstance(document, outputStream);
		document.open();
		Paragraph p=new Paragraph("四川农业大学 2012年自主选拔录取考生报名表",FontFactory.getFont( FontFactory.COURIER,18,Font.BOLDITALIC,new Color(0,0,0)));
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);
		// 创建有56列的表格
		Table table = new Table(60);
		table.setAlignment(Paragraph.ALIGN_CENTER);
		table.setCellsFitPage(true);
		table.setAutoFillEmptyCells(true);
		table.setPadding(10);
		table.setBorderWidth(1);
		//下一行
		
		Cell testnumber = new Cell();
		testnumber.add(new Paragraph("考生号",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		testnumber.setColspan(10);
		testnumber.setRowspan(1);
		testnumber.setHorizontalAlignment(Cell.ALIGN_CENTER);
		testnumber.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(testnumber);
		Cell myTestnumber = new Cell(new Paragraph(user.getTestNumber(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myTestnumber.setColspan(20);
		myTestnumber.setRowspan(1);
		myTestnumber.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myTestnumber.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myTestnumber);
		
		Cell signnumber = new Cell();
		signnumber.add(new Paragraph("报名编号",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		signnumber.setColspan(10);
		signnumber.setRowspan(1);
		signnumber.setHorizontalAlignment(Cell.ALIGN_CENTER);
		signnumber.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(signnumber);
		Cell mySignnumber = new Cell(new Paragraph(user.getSigNumber(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		mySignnumber.setColspan(20);
		mySignnumber.setRowspan(1);
		mySignnumber.setHorizontalAlignment(Cell.ALIGN_CENTER);
		mySignnumber.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(mySignnumber);
		
		Cell truename = new Cell();
		truename.add(new Paragraph("姓名",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		truename.setColspan(10);
		truename.setRowspan(1);
		truename.setHorizontalAlignment(Cell.ALIGN_CENTER);
		truename.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(truename);
		Cell myTruename = new Cell(new Paragraph(user.getTrueName(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myTruename.setColspan(15);
		myTruename.setRowspan(1);
		myTruename.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myTruename.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myTruename);
		
		
		Cell sex = new Cell();
		sex.add(new Paragraph("性别",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		sex.setColspan(10);
		sex.setRowspan(1);
		sex.setHorizontalAlignment(Cell.ALIGN_CENTER);
		sex.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(sex);
		Cell mySex = new Cell(new Paragraph(user.getSex(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		mySex.setColspan(15);
		mySex.setRowspan(1);
		mySex.setHorizontalAlignment(Cell.ALIGN_CENTER);
		mySex.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(mySex);
		
		String src = "//"+user.getSrc();
		Image img = Image.getInstance(src);
		img.scaleAbsolute(50,72);
		Cell myImg = new Cell(img);
		myImg.setColspan(10);
		myImg.setRowspan(3);
		table.addCell(myImg);
		
		
		Cell birth = new Cell();
		birth.add(new Paragraph("出生日期",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		birth.setColspan(10);
		birth.setRowspan(1);
		birth.setHorizontalAlignment(Cell.ALIGN_CENTER);
		birth.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(birth);
		Cell myBirth = new Cell(new Paragraph(user.getBirthday(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myBirth.setColspan(15);
		myBirth.setRowspan(1);
		myBirth.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myBirth.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myBirth);
		
		Cell politics = new Cell();
		politics.add(new Paragraph("政治面貌",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		politics.setColspan(10);
		politics.setRowspan(1);
		politics.setHorizontalAlignment(Cell.ALIGN_CENTER);
		politics.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(politics);
		Cell myPolitics = new Cell(new Paragraph(user.getPolitics(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myPolitics.setColspan(15);
		myPolitics.setRowspan(1);
		myPolitics.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myPolitics.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myPolitics);
		
		Cell iden = new Cell();
		iden.add(new Paragraph("身份证号",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		iden.setColspan(10);
		iden.setRowspan(1);
		iden.setHorizontalAlignment(Cell.ALIGN_CENTER);
		iden.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(iden);
		Cell myIden = new Cell(new Paragraph(user.getIdentity(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myIden.setColspan(15);
		myIden.setRowspan(1);
		myIden.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myIden.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myIden);
		
		Cell subject = new Cell();
		subject.add(new Paragraph("科类",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		subject.setColspan(10);
		subject.setRowspan(1);
		subject.setHorizontalAlignment(Cell.ALIGN_CENTER);
		subject.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(subject);
		Cell mySubject = new Cell(new Paragraph(user.getSubject(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		mySubject.setColspan(15);
		mySubject.setRowspan(1);
		mySubject.setHorizontalAlignment(Cell.ALIGN_CENTER);
		mySubject.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(mySubject);
		
		Cell school = new Cell();
		school.add(new Paragraph("中学名称",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		school.setColspan(10);
		school.setRowspan(1);
		school.setHorizontalAlignment(Cell.ALIGN_CENTER);
		school.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(school);
		Cell mySchool = new Cell(new Paragraph(user.getSchool(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		mySchool.setColspan(10);
		mySubject.setRowspan(1);
		mySchool.setHorizontalAlignment(Cell.ALIGN_CENTER);
		mySchool.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(mySchool);
		
		Cell mphone = new Cell();
		mphone.add(new Paragraph("本人电话",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		mphone.setColspan(10);
		mphone.setRowspan(1);
		mphone.setHorizontalAlignment(Cell.ALIGN_CENTER);
		mphone.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(mphone);
		Cell myPh = new Cell(new Paragraph(user.getMphone(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myPh.setColspan(10);
		myPh.setRowspan(1);
		myPh.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myPh.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myPh);
		
		Cell phone = new Cell();
		phone.add(new Paragraph("住宅电话",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		phone.setColspan(10);
		phone.setRowspan(1);
		phone.setHorizontalAlignment(Cell.ALIGN_CENTER);
		phone.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(phone);
		Cell ph = new Cell(new Paragraph(user.getPhone(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		ph.setColspan(10);
		ph.setRowspan(1);
		ph.setHorizontalAlignment(Cell.ALIGN_CENTER);
		ph.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(ph);
		
		Cell sa = new Cell();
		sa.add(new Paragraph("中学通讯地址及邮编",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		sa.setColspan(10);
		sa.setRowspan(2);
		sa.setHorizontalAlignment(Cell.ALIGN_CENTER);
		sa.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(sa);
		Cell mySa = new Cell(new Paragraph(user.getSa()+" 邮编："+user.getSpostcode(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		mySa.setColspan(30);
		mySa.setRowspan(2);
		mySa.setHorizontalAlignment(Cell.ALIGN_CENTER);
		mySa.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(mySa);
		
		Cell lang = new Cell();
		lang.add(new Paragraph("外语语种",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		lang.setColspan(10);
		lang.setRowspan(2);
		lang.setHorizontalAlignment(Cell.ALIGN_CENTER);
		lang.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(lang);
		Cell myLang = new Cell(new Paragraph(user.getLang(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myLang.setColspan(10);
		myLang.setRowspan(2);
		myLang.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myLang.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myLang);
		
		Cell ha = new Cell();
		ha.add(new Paragraph("家庭通讯地址及邮编",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		ha.setColspan(10);
		ha.setRowspan(2);
		ha.setHorizontalAlignment(Cell.ALIGN_CENTER);
		ha.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(ha);
		Cell myHa = new Cell(new Paragraph(user.getHa()+" 邮编："+user.getHpostcode(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myHa.setColspan(30);
		myHa.setRowspan(2);
		myHa.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myHa.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myHa);
		
		Cell category = new Cell();
		category.add(new Paragraph("考生类别",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		category.setColspan(10);
		category.setRowspan(2);
		category.setHorizontalAlignment(Cell.ALIGN_CENTER);
		category.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(category);
		Cell myCategory = new Cell(new Paragraph(user.getCategory(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myCategory.setColspan(10);
		myCategory.setRowspan(2);
		myCategory.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myCategory.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myCategory);
		
		Cell prize = new Cell();
		prize.add(new Paragraph("个人获奖情况（仅限于高中阶段）请注明获奖时间",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		prize.setColspan(10);
		prize.setRowspan(4);
		prize.setHorizontalAlignment(Cell.ALIGN_CENTER);
		prize.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(prize);
		Cell myPrize = new Cell(new Paragraph(user.getPrize(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		myPrize.setColspan(50);
		myPrize.setRowspan(4);
		myPrize.setHorizontalAlignment(Cell.ALIGN_CENTER);
		myPrize.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(myPrize);
		
		Cell speciality = new Cell();
		speciality.add(new Paragraph("个人特长及社会实践活动等方面所取得的成绩",FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		speciality.setColspan(10);
		speciality.setRowspan(4);
		speciality.setHorizontalAlignment(Cell.ALIGN_CENTER);
		speciality.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(speciality);
		Cell mySpeciality = new Cell(new Paragraph(user.getSpeciality(),FontFactory.getFont( FontFactory.COURIER,12,Font.UNDEFINED,new Color(0,0,0))));
		mySpeciality.setColspan(50);
		mySpeciality.setRowspan(4);
		mySpeciality.setHorizontalAlignment(Cell.ALIGN_CENTER);
		mySpeciality.setVerticalAlignment(Cell.ALIGN_CENTER);
		table.addCell(mySpeciality);
		
		table.setWidth(90);
		
		
		document.add(table);
		
		String fname=user.getUserName();
		fname=java.net.URLEncoder.encode(fname,"UTF-8");
	    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"utf8")+".doc");
	    response.setContentType("application/msword");
		document.close();
	}
}
