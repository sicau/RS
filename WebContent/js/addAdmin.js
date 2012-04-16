$("document").ready(function() {
	$(".submit").click(function() {
		if(checkAll()) {
			$("form").submit();
		}
	});
});

function checkAll() {
	$(".help-block").html("");
	
	if($("#adminname").val() == "") {
		$(".adminname").html("请输入管理员名");
		return false;
	}
	
	if($("#password").val() == "") {
		$(".password").html("请输入密码");
		return false;
	}
	
	if($("#repassword").val() == "") {
		$(".repassword").html("请输入确认密码");
		return false;
	}
	
	if($("#password").val() != $("#repassword").val()) {
		$(".repassword").html("确认密码与密码不符");
		return false;
	}
	
	return true;
}