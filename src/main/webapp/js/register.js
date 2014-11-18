function checkEmail(basePath) {
	if ($('#inputEmail3').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入电子邮箱</span>").appendTo(
				$('#inputEmail2'));
		$('#inputEmail2').addClass('has-error');
	}
	if ($('#inputEmail3').val() != "") {
		// 对电子邮件的验证
		var reg1 = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.(?:com|cn)$/;
		if (!reg1.test($('#inputEmail3').val())) {
			$('#span').remove();
			$("<span style='color:red' id='span'>请输入有效的电子邮箱</span>").appendTo(
					$('#inputEmail2'));
			$('#inputEmail2').addClass('has-error ');
		} else {
			$.ajax({
				   type: "POST",
				   url: basePath+"nosession/user/ajax.html",
				   data: {"str":$('#inputEmail3').val(),"type":1},
				   success: function(flag){
					   if(flag=='true'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>该邮箱已经注册，请换一个</span>").appendTo(
									$('#inputEmail2'));
							$('#inputEmail2').addClass('has-error ');
					   }
					   else if(flag=='error'){
						   $('#span').remove();
							$("<span style='color:red' id='span'>服务器异常，请稍后重试</span>").appendTo(
									$('#inputEmail2'));
							$('#inputEmail2').addClass('has-error ');
					   }else{
						   $('#span').remove();
						   $('#inputEmail2').removeClass('has-error ');
							$('#inputEmail2').addClass('has-success');
					   }
				   }
				});
			
		}
	}
}
function checkName() {
	if ($('#inputName3').val() == "") {
		$('#span1').remove();
		$("<span style='color:red' id='span1'>请输入姓名</span>").appendTo(
				$('#inputName2'));
		$('#inputName2').addClass('has-error ');
	}
	if ($('#inputName3').val() != "") {
		// [\u4E00-\uFA29]|[\uE7C7-\uE7F3]汉字编码范围 
		var re1 = /^[^\x00-\xff]{2,8}$/; 
		if (!re1.test($('#inputName3').val())){
			$('#span1').remove();
			$("<span style='color:red' id='span1'>请输入中文(至少2个，最多8个)</span>").appendTo(
					$('#inputName2'));
			$('#inputName2').addClass('has-error ');
		}else {
			$('#span1').remove();
			 $('#inputName2').removeClass('has-error ');
			$('#inputName2').addClass('has-success ');
		}
	}
	 
}
function checkpassword() {
	if ($('#inputPassword3').val() == "") {
		$('#span2').remove();
		$("<span style='color:red' id='span2'>请输入密码</span>").appendTo(
				$('#inputPassword2'));
		$('#inputPassword2').addClass('has-error ');
	}
	if ($('#inputPassword3').val() != "") {
		var re1 = /^(\w){6,20}$/; 
		if (!re1.test($('#inputPassword3').val())){
			$('#span2').remove();
			$("<span style='color:red' id='span2'>只能输入6-20个字母、数字、下划线   </span>").appendTo(
					$('#inputPassword2'));
			$('#inputPassword2').addClass('has-error ');
		}else {
			$('#span2').remove();
			 $('#inputPassword2').removeClass('has-error ');
			$('#inputPassword2').addClass('has-success ');
		}
	}
	 
}
function checkpasswordconfig() {
	if ($('#inputPasswordConfig3').val() == "") {
		$('#span3').remove();
		$("<span style='color:red' id='span3'>请输入确认密码</span>").appendTo(
				$('#inputPasswordConfig2'));
		$('#inputPasswordConfig2').addClass('has-error ');
	}
	if ($('#inputPasswordConfig3').val() != "") {
		var re1 =/^(\w){6,20}$/; 
		if (!re1.test($('#inputPasswordConfig3').val())){
			$('#span3').remove();
			$("<span style='color:red' id='span3'>只能输入6-20个字母、数字、下划线</span>").appendTo(
					$('#inputPasswordConfig2'));
			$('#inputPasswordConfig2').addClass('has-error ');
		}
		else if ($('#inputPasswordConfig3').val()!=$('#inputPassword3').val() ){
			$('#span3').remove();
			$("<span style='color:red' id='span3'>两次输入密码不一致</span>").appendTo(
					$('#inputPasswordConfig2'));
			$('#inputPasswordConfig2').addClass('has-error ');
		}
		else {
			$('#span3').remove();
			 $('#inputPasswordConfig2').removeClass('has-error ');
			$('#inputPasswordConfig2').addClass('has-success ');
		}
	}
}
function checkphone(basePath) {
	if ($('#inputPhone3').val() == "") {
		$('#span4').remove();
		$("<span style='color:red' id='span4'>请输入手机号</span>").appendTo(
				$('#inputPhone2'));
		$('#inputPhone2').addClass('has-error ');
	}
	if ($('#inputPhone3').val() != "") {
		var re1 = /^13[0-9]{9}|15[012356789][0-9]{8}|18[0123456789][0-9]{8}|147[0-9]{8}$/; 
		if (!re1.test($('#inputPhone3').val())){
			$('#span4').remove();
			$("<span style='color:red' id='span4'>请输入正确的手机号</span>").appendTo(
					$('#inputPhone2'));
			$('#inputPhone2').addClass('has-error ');
		}else {
			$.ajax({
				   type: "POST",
				   url: basePath+"nosession/user/ajax.html",
				   data: {"str":$('#inputPhone3').val(),"type":2},
				   success: function(flag){
					   if(flag=='true'){
						   $('#span4').remove();
							$("<span style='color:red' id='span4'>该手机已经注册，请换一个</span>").appendTo(
									$('#inputPhone2'));
							$('#inputPhone2').addClass('has-error ');
					   }
					   else if(flag=='error'){
						   $('#span4').remove();
							$("<span style='color:red' id='span4'>服务器异常，请稍后重试</span>").appendTo(
									$('#inputPhone2'));
							$('#inputPhone2').addClass('has-error ');
					   }else{
						   $('#span4').remove();
						   $('#inputPhone2').removeClass('has-error ');
							$('#inputPhone2').addClass('has-success ');
					   }
				   }
				});
		}
	}
	 
}
function checkage() {
	if ($('#inputAge3').val() == "") {
		$('#span5').remove();
		$("<span style='color:red' id='span5'>请输入年龄</span>").appendTo(
				$('#inputAge2'));
		$('#inputAge2').addClass('has-error ');
	}
	if ($('#inputAge3').val() != "") {
		var re1 = /^[0-9]*[1-9][0-9]*$/; 
		if (!re1.test($('#inputAge3').val())){
			$('#span5').remove();
			$("<span style='color:red' id='span5'>年龄只能为正整数</span>").appendTo(
					$('#inputAge2'));
			$('#inputAge2').addClass('has-error ');
		}else {
			$('#span5').remove();
			  $('#inputAge2').removeClass('has-error ');
			$('#inputAge2').addClass('has-success ');
		}
	}
	 
}