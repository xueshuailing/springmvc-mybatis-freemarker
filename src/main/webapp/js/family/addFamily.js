
function namecheck(){
	if ($('#name').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入姓名</span>").appendTo(
				$('#namediv'));
		$('#namediv').addClass('has-error ');
	} 
	if ($('#name').val() != "") {
		// [\u4E00-\uFA29]|[\uE7C7-\uE7F3]汉字编码范围 
		var re1 = /^[^\x00-\xff]{2,8}$/; 
		if (!re1.test($('#name').val())){
			$('#span1').remove();
			$("<span style='color:red' id='span1'>请输入中文(至少2个，最多8个)</span>").appendTo(
					$('#namediv'));
			$('#namediv').addClass('has-error ');
		}else {
			$('#span1').remove();
			 $('#namediv').removeClass('has-error ');
		}
	}
}
function checkage() {
	if ($('#age').val() == "") {
		$('#span5').remove();
		$("<span style='color:red' id='span5'>请输入年龄</span>").appendTo(
				$('#agediv'));
		$('#agediv').addClass('has-error ');
	}
	if ($('#age').val() != "") {
		var re1 = /^[0-9]*[1-9][0-9]*$/; 
		if (!re1.test($('#age').val())){
			$('#span5').remove();
			$("<span style='color:red' id='span5'>年龄只能为正整数</span>").appendTo(
					$('#agediv'));
			$('#agediv').addClass('has-error ');
		}else {
			$('#span5').remove();
			  $('#agediv').removeClass('has-error ');
		}
	}
	 
}
//添加验证和Ajax异步保存
function check(basePath){
	if ($('#name').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入姓名</span>").appendTo(
				$('#namediv'));
		$('#namediv').addClass('has-error ');
		return  ;
	}else{
		$('#span').remove();
		$('#namediv').removeClass('has-error ');
	}
	if ($('#age').val() == "") {
		$('#span5').remove();
		$("<span style='color:red' id='span5'>请输入年龄</span>").appendTo(
				$('#agediv'));
		$('#agediv').addClass('has-error ');
		return  ;
	}
	if ($('#age').val() != "") {
		var re1 = /^[0-9]*[1-9][0-9]*$/; 
		if (!re1.test($('#age').val())){
			$('#span5').remove();
			$("<span style='color:red' id='span5'>年龄只能为正整数</span>").appendTo(
					$('#agediv'));
			$('#agediv').addClass('has-error ');
			return  ;
		}else {
			$('#span5').remove();
			  $('#agediv').removeClass('has-error ');
		}
	}
	$.ajax({
		   type: "POST",
		   url: basePath+"myfamily/family/save.html",
		   data: {"name":$('#name').val(),"age":$('#age').val(),"sex":$('#sex').val()},
		   contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		   success: function(flag){
			   if(flag=='500'){
				  alert("保存失败");
			   }
			   else if(flag=='200'){
				   alert("保存成功");
				  window.location.href=basePath+"myfamily/family/query.html";
			   }else{
				   alert("未知错误");
			   }
		   }
		});
}