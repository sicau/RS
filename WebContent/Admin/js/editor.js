var PPEditor = function( instanceName)
{
    this.InstanceName   = instanceName ;
    this.Width          = '100%' ;
    this.Height         = '500' ;
    this.LinkPath       = '';
    this.SkinPath       = 'images/' ;
    this.TextObj        = document.getElementById(this.InstanceName);
    this.Initialized    = false;//编辑器是否初始化
    this.IsEditStatus   = true;//是否在编辑状态
this.IsLoadDialog   = false;//是否已经载入对话框
    this.AllowNumber    = 25000;
this.CurrenNumber   = 0;
this.EditorBGColor = "#E0F4FF";
this.EditorBorder = "1px solid #0275BF";
this.EditorOVColor = "#91D4FF";
    this.ToolbarSets    = [['Bold','Italic','Underline','StrikeThrough'],['SubScript','SuperScript'],['InsertOrderedList','InsertUnOrderedList'],['JustifyLeft','JustifyCenter','JustifyRight'],['CreateLink','UnLink'],['InsertImage'],['TextColor','BGColor'],['FontName','FontSize'],['Source']] ;
    this.ToolbarSource = [['Editor','Preview'],['WordCountSource']];
    this.FontNames      = '请选择字体;宋体;黑体;隶书;幼圆;楷体_GB2312;仿宋_GB2312;Arial;Tahoma;Verdana';
    this.FontSizes      = '请选择大小;七号;六号;五号;四号;三号;二号;一号';
this.CreateLinkMsg = '<div class="editor_line_left"><br /><fieldset><legend>{title}</legend><br />&nbsp;&nbsp;地址：<input type="text" id="_link_url" size="30" value="{url}" class="editor_input_main"><br /><br /></fieldset><br /><fieldset><legend>其他选项</legend><br />&nbsp;&nbsp;在新窗口打开:<input id="_link_target" type="checkbox" value="1" {target}><br /><br /></fieldset></div><br /><div class="editor_line_center"><input type="button" value=" 确定 " onclick="DoInsertLink()">&nbsp;&nbsp; <input type="button" value=" 取消 " onclick="CloseDialog()"></div>';
this.InsertImgMsg   = '<div class="editor_line_left"><br /><fieldset><legend>{title}</legend><br />&nbsp;&nbsp;地址：<input type="text" id="_img_url" size="30" value="{url}" class="editor_input_main"><br /><br /></fieldset><br /><fieldset><legend>显示效果</legend><br />&nbsp;&nbsp;边框粗细:<input type="text" class="editor_input_main" id="_img_border" value="{border}" size="5" maxlength="1">&nbsp;&nbsp;对齐方式:<span class="editor_editor_select_span"><select id="_img_align" style="width:72px" class="editor_select_span"><option value="absmiddle" selected>绝对居中</option><option value="left">居左</option><option value="right">居右</option><option value="top">顶部</option><option value="middle">居中</option><option value="bottom">底部</option><option value="absbottom">绝对底部</option><option value="baseline">基线</option><option value="texttop">文本顶部</option></select></span><br /><br /></fieldset></div><br /><div class="editor_line_center"><input type="button" value=" 确定 " onclick="DoInsertImage()">&nbsp;&nbsp;<input type="button" value=" 取消 " onclick="CloseDialog()"></div>';
this.ColorType      = 1;
}
PPEditor.prototype.IsIE = function(){
    if (document.all) {
        var sBrowserVersionMain = navigator.appVersion.match(/MSIE (.)/)[1];
   var sBrowserVersionSub = navigator.appVersion.match(/MSIE .\.(.)/)[1];
        return (sBrowserVersionMain >= 6 || ( sBrowserVersionMain >= 5 && sBrowserVersionSub >= 5 ))
}
return false;
}
PPEditor.prototype.Create = function(){
    this.PPELang        = {Bold:"加粗",Italic:"倾斜",Underline:"下划线",StrikeThrough:"删除线",SubScript:"下标",SuperScript: "上标",InsertOrderedList: "插入/编辑编号列表",InsertUnOrderedList : "插入/编辑项目列表",JustifyLeft: "左对齐",JustifyCenter: "居中对齐",JustifyRight: "右对齐",CreateLink: "插入/编辑超链接",UnLink: "取消超链接",InsertImage: "插入/编辑图象",TextColor: "文本颜色",BGColor: "背景颜色",FontName: "字体",FontSize: "大小",Source: "HTML",Editor: "TEXT",Preview: "预览",WordCount: "<span class=\"font_orange\">当前[<span id=\"_wordnumber\" class=\"font_orange\">0</span>]字节,最多["+this.AllowNumber+"]字节</span>",WordCountSource: "<span class=\"font_orange\">当前[<span id=\"_wordnumber_source\" class=\"font_orange\">0</span>]字节,最多["+this.AllowNumber+"]字节</span>"};
this.DialogHeadMsg = '<div style="height:20px;background-color:'+this.EditorOVColor+';padding:0px;border-bottom:'+this.EditorBorder+'" onmousedown="DialogMouseDown()" onmouseup="DialogMouseUp()">&nbsp;</div>';
if(this.TextObj.style.width) this.sWidth = this.TextObj.style.width;
else this.sWidth = this.Width.toString().indexOf('%') > 0 ? this.Width : this.Width + 'px' ;
if(this.TextObj.style.height) this.sHeight = this.TextObj.style.height;
else this.sHeight = this.Height.toString().indexOf('%') > 0 ? this.Height : this.Height + 'px' ;
this.TextObj.style.width = this.sWidth;
    this.TextObj.style.height = this.sHeight;
this.TextObj.style.border=this.EditorBorder;
    if(this.IsIE())
        document.onreadystatechange=this.InitEditor;
else {
   alert("提示：建议使用IE5.5及以上版本浏览器，否则在线编辑器将无法显示！");
   this.TextObj.style.display="block";
}
}
PPEditor.prototype.InitEditor = function(){
    oEditor.LoadEditor();
}
PPEditor.prototype.LoadEditor = function(){
    if(document.readyState!="complete") return false;
    if(this.Initialized) return false;
    this.Initialized=true;
    try {
        //create a frame
        this.EditObj = document.createElement('iframe');
        this.EditObj.id = '_editor';
        this.EditObj.style.width = this.sWidth;
        this.EditObj.style.height = this.sHeight;
   this.EditObj.style.border=this.EditorBorder;
   this.EditObj.style.borderTop="none";
   this.TextObj.style.borderTop="none";
        this.EditObj.scrolling = 'auto';
        this.EditObj.frameBorder = 0;
        this.EditObj.marginHeight = 0;
        this.EditObj.marginWidth = 0;  
        //show it
        this.TextObj.parentElement.insertBefore(this.EditObj,this.TextObj);
        this.Editor = _editor;
        //set edit mode
        this.Editor.document.designMode = 'On';
        this.Editor.document.open();
        this.Editor.document.write('<html><head><link href="' + this.LinkPath + 'editor.css" rel="stylesheet" type="text/css"></head><body align="left">' + this.TextObj.value + '</body></html>');
        this.Editor.document.onclick = CloseDialog;
        this.Editor.document.onkeydown=GetKeyPress;
        this.Editor.document.close();
        CountWord();
        //hidden textarea
        this.TextObj.style.display = 'none';
        this.InitToolBar();
    }catch (er) {
        try {   if (this.EditObj) this.EditObj.removeNode(true);}
        catch (ee) {}
        this.TextObj.style.display = 'block';
    }
}
function GetKeyPress()
{
    var ev = oEditor.Editor.event;
    if(ev.keyCode==13)
    {
        var NewTextObj=oEditor.Editor.document.selection.createRange();
        if(NewTextObj.text=="")
        {
            NewTextObj.text="\n";
        }
        else
        {
            oEditor.Editor.document.selection.clear();
            NewTextObj.text="\n";
        }
        oEditor.Editor.document.selection.createRange().select();
        return false;
    }
}
function CountWord(){
    var count_default = document.getElementById('_wordnumber');
    var count_source = document.getElementById('_wordnumber_source');
    if (count_default) {
        oEditor.CurrenNumber=count_default.innerHTML = oEditor.Editor.document.body.innerHTML.replace(/[^\x00-\xff]/g,"**").length;
    }
    if (count_source) {
        oEditor.CurrenNumber=count_source.innerHTML = oEditor.TextObj.value.replace(/[^\x00-\xff]/g,"**").length;
    }
    if (oEditor.CountTimer) {
        window.clearTimeout(oEditor.CountTimer);
    }
    oEditor.CountTimer = window.setTimeout('CountWord()', 500);
    oEditor.Save();
}
PPEditor.prototype.InitToolBar=function(){
    this.ToolbarDefault=this.CreateToolbar('_toolbar','default');
    this.ToolbarSource=this.CreateToolbar('_toolbar_source','source');
    this.ToolbarSource.style.display='none';
}
PPEditor.prototype.CreateToolbar=function(toolbarId,type){
    var Toolbar = document.createElement('div');
    Toolbar.style.width = this.sWidth;
    Toolbar.style.backgroundColor=this.EditorBGColor;
    Toolbar.style.textAlign="left";
    Toolbar.style.border=this.EditorBorder;
    Toolbar.id = toolbarId;
    var oToolbar="";
    if(type=='default')
        ToolbarSets=this.ToolbarSets;
    else ToolbarSets=this.ToolbarSource;
    for (var i = 0; i < ToolbarSets.length; ++i)
    {
        var oToolbarItems=ToolbarSets[i];
        if ( typeof( oToolbarItems ) == 'string' )
        {
            if ( oToolbarItems == '/' )
                oToolbar +='<br>';
        }
        else
        {
            oToolbar +=this.AddIcon('toolbar.start');
            for(var j = 0; j < oToolbarItems.length; ++j){
                var sItems=oToolbarItems[j];
      if(sItems=='-')
      oToolbar +=this.AddIcon('toolbar.separator');
      else if(sItems=='FontName')
       oToolbar +=this.AddSelect(this.FontNames,sItems,1);
      else if(sItems=='FontSize')
       oToolbar +=this.AddSelect(this.FontSizes,sItems);
      else if(sItems=='Source'||sItems=='Editor'||sItems=='Preview'||sItems=='WordCount'||sItems=='WordCountSource')
      oToolbar +=this.AddIcon(sItems,1);
     else oToolbar +=this.AddIcon(sItems);
            }
        }
    }
    Toolbar.innerHTML=oToolbar;
    this.TextObj.parentElement.insertBefore(Toolbar, this.EditObj);
    return Toolbar;
}
PPEditor.prototype.AddIcon=function(iconId,text){
    var iconHTML;
    var iconStyle=' onclick="IconClick(\''+iconId+'\')" onmouseover="this.style.backgroundColor=\''+ this.EditorOVColor +'\'" onmouseout="this.style.backgroundColor=\'\';"';
    var iconAlt=this.PPELang[iconId];
if(iconId=='toolbar.separator'||iconId=='toolbar.start') {iconStyle='';iconAlt=''}
if(text) iconAlt='';
    iconHTML='<span'+iconStyle+'><img src="' + this.SkinPath + iconId.toLowerCase() + '.gif" align="absmiddle" alt="'+iconAlt+'">';
    if(text) iconHTML+=this.PPELang[iconId]+'</span>';
    else iconHTML+='</span>';
    return iconHTML;
}
PPEditor.prototype.GetColorSpace=function(){
var ac=['00','33','66','99','cc','ff'];
var txt='<table ID="ColorTable" border="0" cellspacing="0" cellpadding="0">';
for (var i=0; i<3;i++){txt+='<tr>';for (var j=0; j<3;j++){for (var n=0; n<6;n++){txt+='<td onmousedown="SetColor(this.title)" style="cursor:hand;height:10px; width:10px;" bgcolor="#'+ac[j]+ac[n]+ac[i]+'" title="#'+ac[j]+ac[n]+ac[i]+'"></td>';}}txt+='</tr>';}
for (var i=3; i<6;i++){txt+='<tr>';for (var j=0; j<3;j++){for (var n=0; n<6;n++){txt+='<td onmousedown="SetColor(this.title)" style="cursor:hand;height:10px; width:10px;" bgcolor="#'+ac[j]+ac[n]+ac[i]+'" title="#'+ac[j]+ac[n]+ac[i]+'"></td>';}}txt+='</tr>';}
for (var i=0; i<3;i++){txt+='<tr>';for (var j=3; j<6;j++){for (var n=0; n<6;n++){txt+='<td onmousedown="SetColor(this.title)" style="cursor:hand;height:10px; width:10px;" bgcolor="#'+ac[j]+ac[n]+ac[i]+'" title="#'+ac[j]+ac[n]+ac[i]+'"></td>';}}txt+='</tr>';}
for (var i=3; i<6;i++){txt+='<tr>';for (var j=3; j<6;j++){for (var n=0; n<6;n++){txt+='<td onmousedown="SetColor(this.title)" style="cursor:hand;height:10px; width:10px;" bgcolor="#'+ac[j]+ac[n]+ac[i]+'" title="#'+ac[j]+ac[n]+ac[i]+'"></td>';}}txt+='</tr>';}
txt+='<tr>';for (var n=0; n<6;n++){txt+='<td onmousedown="SetColor(this.title)" style="cursor:hand;height:10px; width:10px;" bgcolor="#'+ac[n]+ac[n]+ac[n]+'"title="#'+ac[n]+ac[n]+ac[n]+'"></td>';}
for (var i=0;i<12;i++){txt+='<td onmousedown="SetColor(this.title)" style="cursor:hand;height:10px; width:10px;" bgcolor="#000000" title="#000000"></td>';}
txt+='</tr>';
txt+='</table>';
return txt;
}
function SetColor(color) {
if (oEditor.ColorType == 1) IconClick('ForeColor', color);
else IconClick('BackColor', color);
CloseDialog();
}
PPEditor.prototype.AddSelect=function(selectString,selectId,type){
    var selectHTML='<span class="editor_editor_select_span"><select class="editor_select_span" id="' + selectId.toLowerCase() +'" onchange="IconClick(\''+selectId+'\',this.value)">';
    var arrOptions=selectString.split(";");
    for(var i=0;i<arrOptions.length;++i){
            var oOptions=arrOptions[i];
    if(i==0) selectHTML+='<option value="">'+oOptions+'</option>';
    else{
     if(type==1) selectHTML+='<option value="'+oOptions+'">'+oOptions+'</option>';
     else selectHTML+='<option value="'+i+'">'+oOptions+'</option>';
    }
    }
    selectHTML+='</select></span>&nbsp;';
    return selectHTML;
}
function IconClick(action,text){
oEditor.SaveSelection();
    if(action=='Source'){
   oEditor.ToolbarDefault.style.display='none';
   oEditor.ToolbarSource.style.display='block';
   oEditor.TextObj.style.display = 'block';
   oEditor.EditObj.style.display = 'none';
   oEditor.IsEditStatus=false;
} else if(action=='Editor'){
   oEditor.ToolbarDefault.style.display='block';
   oEditor.ToolbarSource.style.display='none';
   oEditor.TextObj.style.display = 'none';
   oEditor.EditObj.style.display = 'block';
   oEditor.IsEditStatus=true;
    } else if(action=='CreateLink'){
   oEditor.InsertLink();
} else if(action=='InsertImage'){
   oEditor.InsertImage();
} else if(action=='TextColor' || action=='BGColor'){
   var ColorMsg=oEditor.GetColorSpace();
   var text = '<div id="ColorTableCell">'+ColorMsg+'</div>';
   oEditor.ShowDialog(text, 180, 150,true);
   if(action=='BGColor') oEditor.ColorType=2;
   else oEditor.ColorType=1;
} else if(action=='Preview'){
   oEditor.Preview();
} else if(action=='WordCount' || action=='WordCountSource'){
   alert("您当前已输入[" + oEditor.CurrenNumber + "]字节。您还可以再输入["+(oEditor.AllowNumber-oEditor.CurrenNumber)+"]字节！");
} else{
   oEditor.ReSelect();
   oEditor.Editor.document.execCommand(action,false,''+text+'');
   oEditor.Editor.focus();
    }
}
PPEditor.prototype.Preview = function()
{
if(this.CurrenNumber>this.AllowNumber){
   alert("您当前已输入[" + this.CurrenNumber + "]字节，超出限制["+(this.CurrenNumber-this.AllowNumber)+"]字节！请删除部分内容后重试，谢谢！");
   return false;
}
var iWidth = screen.width * 0.8 ;
var iHeight = screen.height * 0.7 ;
var iLeft = ( screen.width - iWidth ) / 2 ;
var oWindow = window.open( '', null, 'toolbar=yes,location=no,status=yes,menubar=yes,scrollbars=yes,resizable=yes,width=' + iWidth + ',height=' + iHeight + ',left=' + iLeft ) ;

var sHTML ; 
sHTML = '<html>' +
    '<head><title>' + this.PPELang.Preview + '</title>' +
    '<link href="' + this.LinkPath + 'editor.css" rel="stylesheet" type="text/css" />' +
    '</head><body>' + 
    this.TextObj.value + 
    '</body></html>' ;

oWindow.document.write( sHTML );
oWindow.document.close();
}
PPEditor.prototype.InsertLink=function(){
var olink = this.GetLink();
var text = this.CreateLinkMsg;
text = text.replace(/\{title\}/g,this.PPELang['CreateLink']);
text = text.replace(/\{url\}/g,olink.url);
if (olink.target == '_blank')
   text = text.replace(/\{target\}/g, 'checked');
else text = text.replace(/\{target\}/g, '');
this.ShowDialog(text, 300, 240,true);
}
PPEditor.prototype.InsertImage=function(){
var oImg = this.GetImage();
var text = this.InsertImgMsg;
text = text.replace(/\{title\}/g,this.PPELang['InsertImage']);
text = text.replace(/\{url\}/g, oImg.url);
text = text.replace(/\{border\}/g, oImg.border);
this.ShowDialog(text, 300, 240, true);
}
PPEditor.prototype.GetLink=function(){
this.link = new Object();
this.link.url = '';
this.link.target = '_blank';
this.link.control = null;
if (this.nowRng) {
   var isLink;
   if (this.nowSel.type == 'Control') {
    isLink = this.GetParentElement('A', this.nowRng.item(0));
   }else {
    try {
     isLink = this.GetParentElement("A", this.nowRng.parentElement());
    }catch(e) {
     isLink = this.GetParentElement('A', this.nowRng.item(0));
    }
   }
   if (isLink) {
    this.link.url = isLink.href ? isLink.href : "";
    this.link.target = isLink.target;
    this.link.control = isLink;
   }
}
return this.link;
}
PPEditor.prototype.GetImage=function(){
this.img = new Object();
this.img.url = '';
this.img.border = '0';
this.img.align = '';
this.img.control = null;

if (this.nowRng) {
   var isImg;
   if (this.nowSel.type == 'Control') {
    if (this.nowRng.item(0).tagName == "IMG"){
     oControl = this.nowRng.item(0);
     this.img.url = oControl.src;
     var b = oControl.style.border;
     if(b) this.img.border = b.replace(/.*([0-9]+)px.+/g, '$1');
     else this.img.border = oControl.style.border;
     this.img.align = oControl.align;
     this.img.control = oControl;
    }
   }
}
return this.img;
}
function DoInsertLink(){
oEditor.ReSelect();
var url = document.getElementById('_link_url').value;
var target = document.getElementById('_link_target').checked;
if ( url != "" ) {
   oEditor.Editor.document.execCommand("CreateLink", "", url);
   var nLink = oEditor.GetLink();
   if(nLink.control){
    if (target) nLink.control.target = "_blank";
    else nLink.control.target = "";
   }
}
CloseDialog();
}
function DoInsertImage(){
var url = document.getElementById('_img_url').value;
var border = document.getElementById('_img_border').value;
var algin = document.getElementById('_img_align').value;
if (oEditor.img.control) {
   oEditor.Editor.focus();
   var oControl = oEditor.img.control;
   oControl.src = url;
   try {
   oControl.style.border = border + 'px solid #000000';
   }catch (eee) {}
   oControl.align = algin;
}else{
   oEditor.ReSelect();
   var sHTML = '<img src="'+url+'" style="border:'+border+'px solid #000000;" align="'+algin+'">';
   oEditor.InsertHTML(sHTML);
}
CloseDialog();
}
PPEditor.prototype.InsertHTML=function(text){
if (!this.isSel){
   r = this.Editor.document.body.createTextRange();
   r.move("word", 1);
   r.collapse();
   r.select();
}
if (!this.nowSel || this.nowSel == null) return false;
if ( this.nowSel.type == "Control" ) {
   this.nowSel.createRange().item(0).outerHTML = text;
} else {
   rng = this.nowSel.createRange();
   rng.pasteHTML(text);
   rng.select();
}
}
PPEditor.prototype.GetParentElement=function(sTag,start) {
while ((start!=null) && start.tagName && (start.tagName!=sTag)){
   start = start.parentElement;
}
return start;
}
PPEditor.prototype.SaveSelection=function(){
this.nowSel = this.Editor.document.selection;
this.nowRng = this.nowSel.createRange();
}
PPEditor.prototype.ReSelect=function(){
if (!this.nowSel ||this.nowSel == null){
   this.isSel = false;
   return false;
}
if (this.nowSel.type != "None") return false;
try {
   r = this.Editor.document.body.createTextRange();
   if ( r.inRange(this.nowRng) ){
    this.isSel = true;
    r.setEndPoint("StartToStart", this.nowRng);
    r.setEndPoint("EndToEnd", this.nowRng);
    r.select();
   } else this.isSel = false;
}catch(e) {
   this.nowRng.select();
   this.isSel = true;
}
}
PPEditor.prototype.Save=function(){
    if(this.IsEditStatus)
        this.TextObj.value = this.Editor.document.body.innerHTML;
    else this.Editor.document.body.innerHTML=this.TextObj.value;
}
PPEditor.prototype.ShowDialog=function(text, width, height,isHead){
if(!this.IsLoadDialog) this.LoadDialog();
if(isHead) text=this.DialogHeadMsg+text;
this.Editor.focus();
this.Dialog.style.width = width + 'px';
this.Dialog.style.height = height + 'px';
var top = this.getClientXY(this.EditObj, true);
var left = this.getClientXY(this.EditObj, false);
this.Dialog.style.top = top + 20;
this.Dialog.style.left = left + this.EditObj.offsetWidth / 2 - width / 2;;
this.Dialog.innerHTML = text;
this.Dialog.style.display = 'block';
}
PPEditor.prototype.getClientXY=function(obj, isTop) {
var distance = 0;
for ( i=0; i<10; i++){
   if ( isTop ){
    distance += obj.offsetTop+obj.clientTop;
   } else {
    distance += obj.offsetLeft+obj.clientLeft;
   }
   obj = obj.offsetParent;
   if ( obj == document.body ) break;
}
return distance;
}
PPEditor.prototype.LoadDialog=function(){
if(this.IsLoadDialog) return false;
else this.IsLoadDialog=true;
this.Dialog = document.createElement('div');
this.Dialog.id = '_dialog';
this.Dialog.style.position = 'absolute';
this.Dialog.style.backgroundColor = this.EditorBGColor;
this.Dialog.style.border = this.EditorBorder;
this.Dialog.style.display = 'none';
this.DialogCanMove = false;
this.TextObj.parentElement.appendChild(this.Dialog);
}
function CloseDialog(){
if(oEditor.Dialog){
   oEditor.Dialog.style.display = 'none';
   oEditor.DialogCanMove = false;
}
}
function DialogMouseDown() {
oEditor.DialogCanMove = true;
oEditor.DialogX = event.x;
oEditor.DialogY = event.y;
oEditor.DialogT = parseInt(oEditor.Dialog.style.top);
oEditor.DialogL = parseInt(oEditor.Dialog.style.left);
document.attachEvent("onmousemove", DialogMouseMove);
}
function DialogMouseUp(){
oEditor.DialogCanMove = false;
document.detachEvent("onmousemove", DialogMouseMove);
}
function DialogMouseMove(){
if (oEditor.DialogCanMove) {
   oEditor.Dialog.style.top = oEditor.DialogT + event.y - oEditor.DialogY;
   oEditor.Dialog.style.left =oEditor.DialogL + event.x - oEditor.DialogX;
   window.event.returnValue = false;
   window.event.cancelBubble = true;
}
}

PPEditor.prototype.SetXHTML=function(){
var sXHTML = PPEXHtml.GetXHTML(this.Editor.document.body) ;
this.Editor.document.body.innerHTML=this.TextObj.value = sXHTML;
}
var PPEXHtml = new Object() ;
PPEXHtml.CurrentJobNum = 0 ;
PPEXHtml.GetXHTML = function(node)
{
this.XML = this.CreateXmlObject() ;
this.MainNode = this.XML.appendChild( this.XML.createElement( 'xhtml' ) ) ;
PPEXHtml.CurrentJobNum++ ;
this._AppendChildNodes( this.MainNode, node) ;
var sXHTML = this.MainNode.xml;
sXHTML = sXHTML.substr( 7, sXHTML.length - 15 ).trim() ; 
sXHTML = sXHTML.replace( PPERegexLib.SpaceNoClose, ' />');
this.XML = null ;
return sXHTML;
}
PPEXHtml.CreateXmlObject = function()
{
var aObjs = [ 'MSXML2.DOMDocument', 'Microsoft.XmlDom' ] ;
for ( var i = 0 ; i < 2 ; i++ )
{
   try { return new ActiveXObject( aObjs[i] ) ; }
   catch (e) {}
}
}
PPEXHtml._AppendAttribute = function( xmlNode, attributeName, attributeValue )
{
try
{
   var oXmlAtt = this.XML.createAttribute( attributeName ) ;
   oXmlAtt.value = attributeValue ? attributeValue : '' ;
   xmlNode.attributes.setNamedItem( oXmlAtt ) ;
}
catch (e){}
}

PPEXHtml._AppendChildNodes = function( xmlNode, htmlNode)
{
var iCount = 0 ;
if ( htmlNode.hasChildNodes() )
{
   var oChildren = htmlNode.childNodes ;
   for ( var i = 0 ; i < oChildren.length ; i++ )
   {
    if ( this._AppendNode( xmlNode, oChildren[i] ) )
     iCount++ ;
   }
}

if ( iCount == 0 )
{
   if ( !PPERegexLib.EmptyElements.test( htmlNode.nodeName ) )
    xmlNode.appendChild( this.XML.createTextNode('') ) ;
}
}

PPEXHtml._AppendNode = function( xmlNode, htmlNode )
{
switch ( htmlNode.nodeType )
{
   case 1 : 
    var sNodeName = htmlNode.nodeName ;
    if ( !PPERegexLib.ElementName.test( sNodeName ) )
     return false ;
    sNodeName = sNodeName.toLowerCase() ;
    if ( htmlNode._ppexhtmljob == PPEXHtml.CurrentJobNum )
     return false ;
    else htmlNode._ppexhtmljob = PPEXHtml.CurrentJobNum ;
    var oNode = this.XML.createElement( sNodeName ) ;
    PPEXHtml._AppendAttributes( xmlNode, htmlNode, oNode, sNodeName ) ;
    var oTagProcessor = PPEXHtml.TagProcessors[ sNodeName ] ;
    if ( oTagProcessor )
    {
     oNode = oTagProcessor( oNode, htmlNode ) ;
     if ( !oNode ) break ;
    }
    else
     this._AppendChildNodes( oNode, htmlNode) ;

    xmlNode.appendChild( oNode ) ;
    break ;
   case 3 :
    this._AppendTextNode( xmlNode, htmlNode.nodeValue.replaceNewLineChars(' ') ) ;
    break ;
   case 8 :
    xmlNode.appendChild( this.XML.createComment( htmlNode.nodeValue ) ) ;
    break ;
   default :
    xmlNode.appendChild( this.XML.createComment( "Element not supported - Type: " + htmlNode.nodeType + " Name: " + htmlNode.nodeName ) ) ;
    break ;
}
return true ;
}
PPEXHtml._AppendAttributes = function( xmlNode, htmlNode, node, nodeName )
{
var aAttributes = htmlNode.attributes ;

for ( var n = 0 ; n < aAttributes.length ; n++ )
{
   var oAttribute = aAttributes[n] ;

   if ( oAttribute.specified )
   {
    var sAttName = oAttribute.nodeName.toLowerCase() ;
    var sAttValue ;
    if ( sAttName == '_ppexhtmljob' )
     continue ;
    else if ( sAttName == 'style' )
     sAttValue = htmlNode.style.cssText ;
    else if ( sAttName == 'class' || sAttName.indexOf('on') == 0 )
     sAttValue = oAttribute.nodeValue ;
    else if ( nodeName == 'body' && sAttName == 'contenteditable' )
     continue ;
    else if ( oAttribute.nodeValue === true )
     sAttValue = sAttName ;
    else if ( ! (sAttValue = htmlNode.getAttribute( sAttName, 2 ) ) )
     sAttValue = oAttribute.nodeValue ;
    this._AppendAttribute( node, sAttName, sAttValue ) ;
   }
}
}
PPEXHtml._AppendTextNode = function( targetNode, textValue )
{
targetNode.appendChild( this.XML.createTextNode( textValue ) ) ;
}

PPEXHtml.TagProcessors = new Object() ;
PPEXHtml.TagProcessors['img'] = function( node )
{
if ( ! node.attributes.getNamedItem( 'alt' ) )
   PPEXHtml._AppendAttribute( node, 'alt', '' ) ;
return node ;
}

PPEXHtml.TagProcessors['script'] = function( node, htmlNode )
{
return null;
}

PPEXHtml.TagProcessors['style'] = function( node, htmlNode )
{
return null;
}

PPEXHtml.TagProcessors['table'] = function( node, htmlNode )
{
var oClassAtt = node.attributes.getNamedItem( 'class' ) ;
PPEXHtml._AppendChildNodes( node, htmlNode) ;
return node ;
}


var PPERegexLib = new Object() ;
PPERegexLib.EmptyElements = /^(?:BASE|META|LINK|HR|BR|PARAM|IMG|AREA|INPUT)$/i ;
PPERegexLib.ElementName = /^[A-Za-z_:][\w.-:]*$/ ;
PPERegexLib.SpaceNoClose = /\/>/g ;

String.prototype.trim = function()
{
return this.replace( /(^\s*)|(\s*$)/g, '' ) ;
}
String.prototype.replaceNewLineChars = function( replacement )
{
return this.replace( /\n/g, replacement ) ;
}
