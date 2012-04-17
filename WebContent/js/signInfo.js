 $.fn.spin = function(opts) {
    this.each(function() {
      var $this = $(this),
          data = $this.data();

      if (data.spinner) {
        data.spinner.stop();
        delete data.spinner;
      }
      if (opts !== false) {
        data.spinner = new Spinner($.extend({color: $this.css('color')}, opts)).spin(this);
      }
    });
    return this;
  };

$(document).ready(function() {
	$("#upload-preview").hide();
	if(jQuery.browser.msie) {
			var options = {};
			options.maxWidth = 100;
			options.maxHeight = 144;
			var ip = new ImagePreview( $$("selimg"), $$("upload-preview"),options);
			ip.img.src = ImagePreview.TRANSPARENT;
			ip.file.onchange = function(){
				$("#img-preview").hide();
				$("#upload-preview").show();
				$("#isUpload").val("1");
				ip.preview(); 
			};
	} else {
		$("#selimg").bind("change", function() {
			$("#img-preview").hide();
			$("#upload-preview").show();
			$("#isUpload").val("1");
			var $inputUpload = $(this);
			if (this.files && this.files.length > 0) {
				var file = this.files[0];
				var reader = new FileReader(file);
				reader.onload = function(e) {
					var data = e.target.result;
					$("#upload-preview").attr("src",data);
				};
				reader.readAsDataURL(file);
			}
		});
	}
	
	$("#birthday").bind("click", function() {
		WdatePicker({isShowClear:false,isShowToday:false});
	});
	
	$(".save").click(function() {
		if(checkAll()) {
			$("body").spin();
			$("form").submit();
		}
	});
	
	$(".update").click(function() {
		if(checkAll()) {
			var action = $("form").attr("action");
			var id = $("#id").val();
			if($("#isUpload").val() == "1") {
				$("form").attr("action",action+"?upload=1&id="+id); //image is changed
			} else {
				$("form").attr("action",action+"?upload=0&id="+id); //image is not changed
			}
			$("form").submit();
		}
	});
	
});
 
function checkAll() {
	var tnum = /^\d+$/;
	var MobilePhonePa = /^\d{11}$/;
	var FixPhone = /^0\d{2,3}-\d{7}$/;
	var zipcode = /^\d{6}$/;
	var id = /^\d{17}[x0-9X]$/;
	$(".help-block").html("");
	
	if($("#testnumber").val() == "") {
		$(".testnumber").html("请输入考生号");
		$("#testnumber").focus();
		return false;
	} else {
		if(!tnum.test($("#testnumber").val())) {
			$(".testnumber").html("考生号无效");
			$("#testnumber").focus();
			return false;
		}
	}
	
	if($("#truename").val() == "") {
		$(".truename").html("请输入姓名");
		$("#truename").focus();
		return false;
	}
	
	if($("#birthday").val() == "") {
		$(".birthday").html("请输入出生日期");
		$("#birthday").focus();
		return false;
	}
	
	if($("#identity").val() == "") {
		$(".identity").html("请输入身份证号");
		$("#identity").focus();
		return false;
	} else {
		if(!id.test($("#identity").val())) {
			$(".identity").html("请输入18位有效身份证号");
			$("#identity").focus();
			return false;
		}
	}
	
	if($("#id").val() == 0 && $("#isUpload").val() != "1") {
		$(".selimg").html("请上传1寸图片");
		$("#selimg").focus();
		return false;
	}
	
	if($("#school").val() == "") {
		$(".school").html("请输入中学名称");
		$("#school").focus();
		return false;
	}
	
	if($("#mphone").val() == "") {
		$(".mphone").html("请输入本人电话");
		$("#mphone").focus();
		return false;
	} else {
		if(!MobilePhonePa.test($("#mphone").val()) && !FixPhone.test($("#mphone").val())) {
			$(".mphone").html("号码无效，请输入例如:028-1111111,0835-2222222,18723333333");
			$("#mphone").focus();
			return false;
		}
	}
	
	if($("#phone").val() == "") {
		$(".phone").html("请输入住宅电话");
		$("#phone").focus();
		return false;
	} else {
		if(!MobilePhonePa.test($("#phone").val()) && !FixPhone.test($("#phone").val())) {
			$(".phone").html("号码无效，请输入例如:028-1111111,0835-2222222,18723333333");
			$("#phone").focus();
			return false;
		}
	}
	
	if($("#sa").val() == "") {
		$(".sa").html("请输入中学通讯地址");
		$("#sa").focus();
		return false;
	}
	
	if($("#spostcode").val() == "") {
		$(".spostcode").html("请输入邮编");
		$("#spostcode").focus();
		return false;
	} else {
		if(!zipcode.test($("#spostcode").val())) {
			$(".spostcode").html("邮编无效，请输入例如：666666");
			$("#spostcode").focus();
			return false;
		}
	}
	
	if($("#lang").val() == "") {
		$(".lang").html("请输入外语语种");
		$("#lang").focus();
		return false;
	}
	
	if($("#ha").val() == "") {
		$(".ha").html("请输入家庭通讯地址");
		$("#ha").focus();
		return false;
	}
	
	if($("#homepostcode").val() == "") {
		$(".homepostcode").html("请输入邮编");
		$("#homepostcode").focus();
		return false;
	} else {
		if(!zipcode.test($("#homepostcode").val())) {
			$(".homepostcode").html("邮编无效，请输入例如：666666");
			$("#homepostcode").focus();
			return false;
		}
	}
	
	if($("#prize").val().length>100) {
		$(".prize").html("字数不能超过100");
		$("#prize").focus();
		return false;
	};
	
	if($("#speciality").val().length>100) {
		$(".speciality").html("字数不能超过100");
		$("#speciality").focus();
		return false;
	};
	
	return true;
}
