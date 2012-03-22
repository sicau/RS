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
})


