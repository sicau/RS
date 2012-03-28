$(document).ready(function() {
	if(jQuery.browser.msie) {
		var ip = new ImagePreview( $$("selimg"), $$("img-preview"), {
			maxWidth: 200, maxHeight: 200
		});
		ip.img.src = ImagePreview.TRANSPARENT;
		ip.file.onchange = function(){ ip.preview(); };
	} else {
		$("#selimg").bind("change", function() {
			var $inputUpload = $(this);
			if (this.files && this.files.length > 0) {
				var file = this.files[0];
				var reader = new FileReader(file);
				reader.onload = function(e) {
					var data = e.target.result;
					$("#img-preview").attr("src",data);
				}
				reader.readAsDataURL(file);
			}
		});
	}
	$("#selimg").bind("change", function() {
		console.log(getValueIE8("selimg"));
	})
	
})
 function getValueFF(id){
        var ip = document.getElementById(id);
        if (ip.files) {
            //ffx3 - try to have access to full path
            try {
                netscape.security.PrivilegeManager.enablePrivilege( 'UniversalFileRead' )
            }
            catch (err) {
                //need to set signed.applets.codebase_principal_support to true
            }
        };
        return ip.value;
    }

function getValueIE8(id){
    var ip = document.getElementById(id);
    console.log(ip);
    ip.select();
    return null;
}
