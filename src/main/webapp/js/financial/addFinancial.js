
function moneycheck(){
	if ($('#money').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入金额</span>").appendTo(
				$('#moneydiv'));
		$('#moneydiv').addClass('has-error ');
	}else{
		$('#span').remove();
		$('#moneydiv').removeClass('has-error ');
	}
}
function timecheck(){
	if ($('#time-value').val() == "") {
		$('#span1').remove();
		$("<span style='color:red' id='span1'>请选择时间</span>").appendTo(
				$('#time'));
		$('#time').addClass('has-error ');
}else{
	$('#span1').remove();
	$('#time').removeClass('has-error ');
}
}
function remarkcheck(){
	if ($.trim($('#remark').val()) == "") {
		$('#span2').remove();
		$("<span style='color:red' id='span2'>请输入备注</span>").appendTo(
				$('#remarkdiv'));
		$('#remarkdiv').addClass('has-error ');
	}else{
		$('#span2').remove();
		$('#remarkdiv').removeClass('has-error ');
	}
}
//添加验证和Ajax异步保存
function check(basePath){
	if ($('#money').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入金额</span>").appendTo(
				$('#moneydiv'));
		$('#moneydiv').addClass('has-error ');
		return  ;
	}else{
		$('#span').remove();
		$('#moneydiv').removeClass('has-error ');
	}
	if ($('#time-value').val() == "") {
			$('#span1').remove();
			$("<span style='color:red' id='span1'>请选择时间</span>").appendTo(
					$('#time'));
			$('#time').addClass('has-error ');
			return  ;
	}else{
		$('#span1').remove();
		$('#time').removeClass('has-error ');
	}
	if ($.trim($('#remark').val()) == "") {
		$('#span2').remove();
		$("<span style='color:red' id='span2'>请输入备注</span>").appendTo(
				$('#remarkdiv'));
		$('#remarkdiv').addClass('has-error ');
		return  ;
	}else{
		$('#span2').remove();
		$('#remarkdiv').removeClass('has-error ');
	}
	$.ajax({
		   type: "POST",
		   url: basePath+"myfamily/financial/save.html",
		   contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		   data: {"money":$('#money').val(),"time":$('#time-value').val(),"types":$('#types').val(),"familys":$('#familys').val(),"remark":$('#remark').val()},
		   success: function(flag){
			   if(flag=='500'){
				  alert("保存失败");
			   }
			   else if(flag=='200'){
				   alert("保存成功");
				  window.location.href=basePath+"myfamily/financial/query.html";
			   }else{
				   alert("未知错误");
			   }
		   }
		});
}