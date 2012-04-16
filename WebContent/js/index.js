$("document").ready(function() {
	$("input").bind("focus",function() {
		$("p.error-message").html("");
	});
});