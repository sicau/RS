package cn.edu.sicau.rs.function;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;


public class DataToExcel {
	public String Excel(ResultSet rs){
		HSSFWorkbook workBook = new HSSFWorkbook(); // create a excel object
		HSSFSheet sheet = workBook.createSheet();  // create a sheet object
		//set style
		HSSFCellStyle titleStyle = workBook.createCellStyle();    //create style object
		titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);    // align center
		titleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  //  vertical center
		//set font
		HSSFFont titleFont = workBook.createFont();   //create font object
		titleFont.setFontHeightInPoints((short)15);   //font size
		titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  // bold
		titleFont.setFontName("���� ");
		titleStyle.setFont(titleFont);    //apply font
		//
		sheet.addMergedRegion((new CellRangeAddress(0,1,0,17)));
		HSSFRow row = null;
		HSSFCell cell = null;
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellStyle(titleStyle);
		cell.setCellValue(new HSSFRichTextString("ѧ����Ϣ��"));
		//���ñ�����ʽ
		HSSFCellStyle tableStyle = workBook.createCellStyle();
		tableStyle.setBorderBottom((short)1);
		tableStyle.setBorderTop((short)1);
		tableStyle.setBorderLeft((short)1);
		tableStyle.setBorderRight((short)1);
		tableStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//���ñ�������
		HSSFFont tableFont = workBook.createFont();
		tableFont.setFontHeightInPoints((short)12);
		tableFont.setFontName("����");
		tableStyle.setFont(tableFont);
		
		String[] title = {"����","����","�Ա�","����","������ò","���֤��","����","��ѧ����","�̶��绰" 
				,"�ƶ��绰","ѧУ��ַ","ѧУ�ʱ�","��ͥ��ַ","��ͥ�ʱ�","��������","�������","�����","�����س�"};  //��ͷ
		row = sheet.createRow(2);
		for(int i = 0;i < title.length;i++) {
			cell = row.createCell(i);
			cell.setCellStyle(tableStyle);
			cell.setCellValue(new HSSFRichTextString(title[i]));
		}
		
		try {
			while (rs.next()) {
				int j = 3;
				row = sheet.createRow((short)j);
				for(int i = 0; i < rs.getMetaData().getColumnCount();i++) {
					cell = row.createCell(i);
					cell.setCellStyle(tableStyle);
					cell.setCellValue(new HSSFRichTextString(rs.getString(i+1)));
				}
				j++;
			}

		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			long now = System.currentTimeMillis();
			FileOutputStream os = new FileOutputStream("D:\\"+now+".xls");
			workBook.write(os);
			os.close();
			String path = "D:\\"+now+".xls";
			return path;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}
