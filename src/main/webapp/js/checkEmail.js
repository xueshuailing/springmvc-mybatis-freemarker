function checkemail(basePath){
	if ($('#inputEmail3').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入电子邮箱</span>").appendTo(
				$('#inputEmail2'));
		$('#inputEmail2').addClass('has-error ');
		$('#bt').attr("disabled","disabled");
		return false;
	}
	if ($('#inputEmail3').val() != "") {
		// 对电子邮件的验证
		var reg1 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.(?:com|cn)$/;
		if (!reg1.test($('#inputEmail3').val())) {
			$('#span').remove();
			$("<span style='color:red' id='span'>请输入有效的电子邮箱</span>").appendTo(
					$('#inputEmail2'));
			$('#inputEmail2').addClass('has-error ');
			$('#bt').attr("disabled","disabled");
			return false;
		} else {
			$.ajax({
				   type: "POST",
				   url: basePath+"nosession/user/ajax.html",
				   data: {"str":$('#inputEmail3').val(),"type":3},
				   success: function(flag){
					   if(flag=='1'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>该邮箱还没有注册，请先注册</span>").appendTo(
									$('#inputEmail2'));
							$('#inputEmail2').addClass('has-error ');
							$('#bt').attr("disabled","disabled");
							return false;
					   }
					   else if(flag=='200'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>该邮箱已经激活，请直接登录</span>").appendTo(
									$('#inputEmail2'));
							$('#inputEmail2').addClass('has-error ');
							$('#bt').attr("disabled","disabled");
							return false;
					   }
					   else if(flag=='error'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>服务器异常，请稍后重试</span>").appendTo(
									$('#inputEmail2'));
							$('#inputEmail2').addClass('has-error ');
							$('#bt').attr("disabled","disabled");
							return false;
					   }else{
						   $('#span').remove();
						   $('#inputEmail2').removeClass('has-error ');
							$('#inputEmail2').addClass('has-success ');
							$('#bt').removeAttr("disabled"); 
					   }
				   }
				});
			
		}
	}
	return true;
}
function check(basePath){
	if ($('#inputEmail3').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入电子邮箱</span>").appendTo(
				$('#inputEmail2'));
		$('#inputEmail2').addClass('has-error ');
		$('#bt').attr("disabled","disabled");
	}
	if ($('#inputEmail3').val() != "") {
		// 对电子邮件的验证
		var reg1 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.(?:com|cn)$/;
		if (!reg1.test($('#inputEmail3').val())) {
			$('#span').remove();
			$("<span style='color:red' id='span'>请输入有效的电子邮箱</span>").appendTo(
					$('#inputEmail2'));
			$('#inputEmail2').addClass('has-error ');
			$('#bt').attr("disabled","disabled");
		} else {
			$.ajax({
				   type: "POST",
				   url: basePath+"nosession/user/ajax.html",
				   data: {"str":$('#inputEmail3').val(),"type":3},
				   success: function(flag){
					   if(flag=='1'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>该邮箱还没有注册，请先注册</span>").appendTo(
									$('#inputEmail2'));
							$('#inputEmail2').addClass('has-error ');
							$('#bt').attr("disabled","disabled");
					   }
					   else if(flag=='200'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>该邮箱已经激活，请直接登录</span>").appendTo(
									$('#inputEmail2'));
							$('#inputEmail2').addClass('has-error ');
							$('#bt').attr("disabled","disabled");
					   }
					   else if(flag=='error'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>服务器异常，请稍后重试</span>").appendTo(
									$('#inputEmail2'));
							$('#inputEmail2').addClass('has-error ');
							$('#bt').attr("disabled","disabled");
					   }else{
						   $('#span').remove();
						   $('#inputEmail2').removeClass('has-error ');
							$('#inputEmail2').addClass('has-success ');
							$('#bt').removeAttr("disabled"); 
					   }
				   }
				});
			
		}
	}
}