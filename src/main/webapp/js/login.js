function login(basePath){
	if ($('#name').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入电子邮箱</span>").appendTo(
				$('#name2'));
		$('#name2').addClass('has-error ');
		return false;
	}
	if ($('#name').val() != "") {
		// 对电子邮件的验证
		var reg1 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.(?:com|cn)$/;
		if (!reg1.test($('#name').val())) {
			$('#span').remove();
			$("<span style='color:red' id='span'>请输入有效的电子邮箱</span>").appendTo(
					$('#name2'));
			$('#name2').addClass('has-error ');
			return false;
		} else {
			$.ajax({
				   type: "POST",
				   url: basePath+"nosession/user/ajax.html",
				   data: {"str":$('#name').val(),"type":3},
				   success: function(flag){
					   if(flag=='1'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>该邮箱还没有注册，请先注册</span>").appendTo(
									$('#name2'));
							$('#name2').addClass('has-error ');
							return false;
					   }
					   else if(flag=='200'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>该邮箱已经激活，请直接登录</span>").appendTo(
									$('#name2'));
							$('#name2').addClass('has-error ');
							return false;
					   }
					   else if(flag=='error'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>服务器异常，请稍后重试</span>").appendTo(
									$('#name2'));
							$('#name2').addClass('has-error ');
							return false;
					   }else{
						   $('#span').remove();
							$('#name2').addClass('has-success ');
							
					   }
				   }
				});
			
		}
	}
	if ($('#password').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入电子邮箱</span>").appendTo(
				$('#pass2'));
		$('#pass2').addClass('has-error ');
		return false;
	}
	return true;
}