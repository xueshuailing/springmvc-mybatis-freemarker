
function namecheck(){
	if ($('#name').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入名称</span>").appendTo(
				$('#namediv'));
		$('#namediv').addClass('has-error ');
	}else{
		$('#span').remove();
		$('#namediv').removeClass('has-error ');
	}
}
//添加验证和Ajax异步保存
function check(basePath){
	if ($('#name').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入名称</span>").appendTo(
				$('#namediv'));
		$('#namediv').addClass('has-error ');
		return  ;
	}else{
		$('#span').remove();
		$('#namediv').removeClass('has-error ');
	}
	$.ajax({
		   type: "POST",
		   url: basePath+"myfamily/type/save.html",
		   data: {"name":$('#name').val(),"types":$('#types').val()},
		   success: function(flag){
			   if(flag=='500'){
				  alert("保存失败");
			   }
			   else if(flag=='200'){
				   alert("保存成功");
				  window.location.href=basePath+"myfamily/type/query.html";
			   }else{
				   alert("未知错误");
			   }
		   }
		});
}