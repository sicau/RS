$("document").ready(function() {
	$(".submit").click(function() {
		if(checkAll()) {
			var ul = "CheckRandomCode?code="+$("#validation").val()+"&username="+encodeURI(encodeURI($("#username").val()));
			console.log(ul);
			$.ajax({
				  type:"post",
				  contentType:"application/x-www-form-urlencoded:charset=UTF-8",
				  url: ul 
			}).done(function(result) { 
			  	if(result == "error") {
			  		$(".val-code").html("验证码错误");
			  	} else if(result == "exist"){
			  		$(".username").html("用户名已存在");
			  	} else if(result == "success"){
			  		$("form").submit();
			  	} 
			});
		}
	});
});

function checkAll() {
		var c = this;
	    c.flag = false;
		$(".help-block").html("");
		if($("#username").val() == "") {
			$(".username").html("请输入用户名");
			return false;
		}
		
		if($("#psd").val() == "") {
			$(".psd").html("请输入密码");
			return false;
		}
		
		if($("#rePsd").val() == "") {
			$(".rePsd").html("请输入确认密码");
			return false;
		}
		
		if($("#psd").val() != $("#rePsd").val() ) {
			$(".rePsd").html("确认密码与原密码不符");
			return false;
		}
		
		if($("#validation").val() == "") {
			$(".val-code").html("请输入验证码");
			return false;
		}
		
		return true;
	}

