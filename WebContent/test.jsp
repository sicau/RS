<<<<<<< HEAD
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML>
    <HEAD>
      <title>WEB页面导出为EXCEL文档的方法
      </title>
    </HEAD>
<body>
<BR>
<table id = "PrintA" width="100%" border="1" cellspacing="0" cellpadding="0" bgcolor = "#61FF13">
<TR style="text-align : center;">
<TD>单元格A</TD>
<TD>单元格A</TD>
<TD>单元格A</TD>
<TD>单元格A</TD>
</TR>
<TR>
<TD colSpan=4 style="text-align : center;"><font color="BLUE" face="Verdana">单元格合并行A</FONT></TD>
</TR>
</TABLE>
<BR>
<table id = "PrintB" width="100%" border="1" cellspacing="0" cellpadding="0">
<TR style="text-align : center;">
<TD>单元格B</TD>
<TD>单元格B</TD>
<TD>单元格B</TD>
<TD>单元格B</TD>
</TR>
<TR>
<TD colSpan=4 style="text-align : center;">单元格合并行B</TD>
</TR>
</TABLE>
<br><br><br>
<input type="button" onclick="javascript:AllAreaWord();" value="导出页面指定区域内容到Word">
<input type="button" onclick="javascript:AllAreaExcel();" value="导出页面指定区域内容到Excel">
<input type="button" onclick="javascript:CellAreaExcel();" value="导出表单单元格内容到Excel">
<SCRIPT LANGUAGE="javascript">
//指定页面区域内容导入Excel
function AllAreaExcel() 
{
    var oXL = new ActiveXObject("Excel.Application"); 
    var oWB = oXL.Workbooks.Add(); 
    var oSheet = oWB.ActiveSheet;  
    var sel=document.body.createTextRange();
    sel.moveToElementText(PrintA);
    sel.select();
    sel.execCommand("Copy");
    oSheet.Paste();
    oXL.Visible = true;
}
//指定页面区域“单元格”内容导入Excel
function CellAreaExcel() 
{
    var oXL = new ActiveXObject("Excel.Application"); 
    var oWB = oXL.Workbooks.Add(); 
    var oSheet = oWB.ActiveSheet; 
    var Lenr = PrintA.rows.length;
    for (i=0;i<Lenr;i++) 
    { 
     var Lenc = PrintA.rows(i).cells.length; 
     for (j=0;j<Lenc;j++) 
     { 
      oSheet.Cells(i+1,j+1).value = PrintA.rows(i).cells(j).innerText; 
     } 
    } 
    oXL.Visible = true; 
} 
//指定页面区域内容导入Word
function AllAreaWord()
{
    var oWD = new ActiveXObject("Word.Application");
    var oDC = oWD.Documents.Add("",0,1);
    var orange =oDC.Range(0,1);
    var sel = document.body.createTextRange();
    sel.moveToElementText(PrintA);
    sel.select();
    sel.execCommand("Copy");
    orange.Paste();
    oWD.Application.Visible = true;
    //window.close();
}
</SCRIPT>
</body>
</html>
=======
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <form action = "ListNewsServlet" method = "post">
     <input type="submit" value = "tijiao">
  </form>
</body>
</html>
>>>>>>> 7b5c40f85acec7da85faff712912e3115a23526e
