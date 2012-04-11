$("document").ready(function() {
	$(".person-info").click(function() {
		console.log($("#id").val());
			var ul = "showSignInfoServlet?id="+$("#id").val();
//			$.ajax({
//				  type:"post",
//				  url: ul 
//			});
	});
});
