function exportword(tableid) {
    var curTbl = document.getElementById(tableid);   
    var   oWD   =   new   ActiveXObject("Word.Application");   
    var   oDC   =   oWD.Documents.Add("",0,1);   
    var   oRange   =oDC.Range(0,1);   
    var   sel   =   document.body.createTextRange();   
      sel.moveToElementText(curTbl);   
      sel.select();   
      sel.execCommand("Copy");   
      oRange.Paste();   
      oWD.Application.Visible   =   true;
}


/**

function method1(tableid) {
    var curTbl = document.getElementById(tableid);
    var oXL = new ActiveXObject("Excel.Application");
    var oWB = oXL.Workbooks.Add();
    var oSheet = oWB.ActiveSheet;
    var sel = document.body.createTextRange();
    sel.moveToElementText(curTbl);
    sel.select();
    sel.execCommand("Copy");
    oSheet.Paste();
    oXL.Visible = true;
}
 //B、读取表格中每个单元到EXCEL中：
function method2(tableid)
{
    var curTbl = document.getElementById(tableid);
    var oXL = new ActiveXObject("Excel.Application");
    var oWB = oXL.Workbooks.Add();
    var oSheet = oWB.ActiveSheet;
    var Lenr = curTbl.rows.length;
    for (i = 0; i < Lenr; i++)
    {
        var Lenc = curTbl.rows(i).cells.length;
        for (j = 0; j < Lenc; j++)
        {
            oSheet.Cells(i + 1, j + 1).value = curTbl.rows(i).cells(j).innerText;
        }
    }
    oXL.Visible = true;
}
// c、把表格输出到另一个页面，然后存成cvs格式
function getXlsFromTbl(inTblId, inWindow)
{
    try {
        var allStr = "";
        var curStr = "";
        if (inTblId != null && inTblId != "" && inTblId != "null") {
            curStr = getTblData(inTblId, inWindow);
        }
        if (curStr != null) {
            allStr += curStr;
        }
        else {
            alert("你要导出的表不存在");
            return;
        }
        var fileName = getExcelFileName();
        doFileExport(fileName, allStr);
    }
    catch(e) {
        alert("导出发生异常:" + e.name + "->" + e.description + "!");
    }
}
function getTblData(inTbl, inWindow) {
    var rows = 0;
    var tblDocument = document;
    if (!!inWindow && inWindow != "") {
        if (!document.all(inWindow)) {
            return null;
        }
        else {
            tblDocument = eval(inWindow).document;
        }
    }
    var curTbl = tblDocument.getElementById(inTbl);
    var outStr = "";
    if (curTbl != null) {
        for (var j = 0; j < curTbl.rows.length; j++) {
            for (var i = 0; i < curTbl.rows[j].cells.length; i++) {
                if (i == 0 && rows > 0) {
                    outStr += " /t";
                    rows -= 1;
                }
                outStr += curTbl.rows[j].cells[i].innerText + "/t";
                if (curTbl.rows[j].cells[i].colSpan > 1) {
                    for (var k = 0; k < curTbl.rows[j].cells[i].colSpan - 1; k++) {
                        outStr += " /t";
                    }
                }
                if (i == 0) {
                    if (rows == 0 && curTbl.rows[j].cells[i].rowSpan > 1) {
                        rows = curTbl.rows[j].cells[i].rowSpan - 1;
                    }
                }
            }
            outStr += "/r/n";
        }
    }
    else {
        outStr = null;
        alert(inTbl + "不存在 !");
    }
    return outStr;
}
function getExcelFileName() {
    var d = new Date();
    var curYear = d.getYear();
    var curMonth = "" + (d.getMonth() + 1);
    var curDate = "" + d.getDate();
    var curHour = "" + d.getHours();
    var curMinute = "" + d.getMinutes();
    var curSecond = "" + d.getSeconds();
    if (curMonth.length == 1) {
        curMonth = "0" + curMonth;
    }
    if (curDate.length == 1) {
        curDate = "0" + curDate;
    }
    if (curHour.length == 1) {
        curHour = "0" + curHour;
    }
    if (curMinute.length == 1) {
        curMinute = "0" + curMinute;
    }
    if (curSecond.length == 1) {
        curSecond = "0" + curSecond;
    }
    var fileName = "table" + "_" + curYear + curMonth + curDate + "_"
            + curHour + curMinute + curSecond + ".csv";
    return fileName;
}
function doFileExport(inName, inStr) {
    var xlsWin = null;
    if (!!document.all("glbHideFrm")) {
        xlsWin = glbHideFrm;
    }
    else {
        var width = 6;
        var height = 4;
       var openPara = "left=" + (window.screen.width / 2 - width / 2)
                + ",top=" + (window.screen.height / 2 - height / 2)
                + ",scrollbars=no,width=" + width + ",height=" + height;
        xlsWin = window.open("", "_blank", openPara);
    }
    xlsWin.document.write(inStr);
    xlsWin.document.close();
    xlsWin.document.execCommand('Saveas', true, inName);
    xlsWin.close();
}

*/