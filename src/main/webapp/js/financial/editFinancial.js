
function moneycheck1(){
	if ($('#money1').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入金额</span>").appendTo(
				$('#moneydiv'));
		$('#moneydiv1').addClass('has-error ');
	}else{
		$('#span').remove();
		$('#moneydiv1').removeClass('has-error ');
	}
}
function timecheck1(){
	if ($('#time-value1').val() == "") {
		$('#span1').remove();
		$("<span style='color:red' id='span1'>请选择时间</span>").appendTo(
				$('#time'));
		$('#time1').addClass('has-error ');
}else{
	$('#span1').remove();
	$('#time1').removeClass('has-error ');
}
}
function remarkcheck1(){
	if ($.trim($('#remark1').val()) == "") {
		$('#span2').remove();
		$("<span style='color:red' id='span2'>请输入备注</span>").appendTo(
				$('#remarkdiv'));
		$('#remarkdiv1').addClass('has-error ');
	}else{
		$('#span2').remove();
		$('#remarkdiv1').removeClass('has-error ');
	}
}
function update(basePath){
	 	if ($('#money1').val() == "") {
			$('#span').remove();
			$("<span style='color:red' id='span'>请输入金额</span>").appendTo(
					$('#moneydiv1'));
			$('#moneydiv1').addClass('has-error ');
			return  ;
		}else{
			$('#span').remove();
			$('#moneydiv1').removeClass('has-error ');
		}
		if ($('#time-value1').val() == "") {
				$('#span1').remove();
				$("<span style='color:red' id='span1'>请选择时间</span>").appendTo(
						$('#time'));
				$('#time1').addClass('has-error ');
				return  ;
		}else{
			$('#span1').remove();
			$('#time1').removeClass('has-error ');
		}
		if ($.trim($('#remark1').val()) == "") {
			$('#span2').remove();
			$("<span style='color:red' id='span2'>请输入备注</span>").appendTo(
					$('#remarkdiv1'));
			$('#remarkdiv1').addClass('has-error ');
			return  ;
		}else{
			$('#span2').remove();
			$('#remarkdiv1').removeClass('has-error ');
		}
		  window.location.href=basePath+"myfamily/financial/update.html?money="+$('#money1').val()+"&time="+$('#time-value1').val()+"&types="+$('#types1').val()+"&familys="+$('#familys1').val()+"&remark="+$('#remark1').val()+"&id="+$('#fid').val()+"&startTime="+$('#start-value').val()+"&pageNo="+$("#pageNo_result").val()+"&familyId="+$('#family').val()+"&typeId="+$('#type').val()+"&endTime="+$('#end-value').val();
	 }
	 //修改
	 function editForm(){
	 var ids = getId();
	 if(ids==""||ids.split(",").length>1){
		 $('#comment').modal('show');
	    	$("#commentDiv").html("请选择一条修改");
	 	return false;
	 }
	   $('#editModal').modal('show');
	   $.ajax({
			   type: "POST",
			   url: "myfamily/financial/edit.html",
			   dataType:"json",
			   data: {"ids":ids},
			   success: function(reslut){
			   var option = "";
			   var options = "";
			   		 $.each(reslut.typeEdit,function(index,value){
			   		 	if(value.is==true){
			   		 		option += "<option  selected='selected' value='"+value.id+"'>"+value.name+"</option>";
			   		 	}else{
			   		 		option += "<option    value='"+value.id+"'>"+value.name+"</option>";
			   		 	}
						 
				   });
				   	 $.each(reslut.familyEdit,function(index,value){
			   		 	if(value.is==true){
			   		 		options += "<option  selected='selected' value='"+value.id+"'>"+value.name+"</option>";
			   		 	}else{
			   		 		options += "<option    value='"+value.id+"'>"+value.name+"</option>";
			   		 	}
						 
				   });
				    $("#types1").empty().append(option);
				     $("#familys1").empty().append(options);
				   $('#remark1').val(reslut.datas.remark);
				   $('#money1').val(reslut.datas.num);
				   $('#time-value1').val(reslut.datas.date);
				   $('#fid').val(reslut.datas.id);
			   }
			});
	 }
	 function getId(){
			var ckb = $("input[name='id']:checked");
			if(ckb.length>0){
				var dics = "";
				for(var i=0; i<ckb.length; i++){
					dics = dics+ckb[i].value+",";
				}
				dics = dics.substring(0,dics.length-1);
				return dics;
			}
			return "";
		}