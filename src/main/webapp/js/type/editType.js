

function namecheck1(){
	if ($('#name1').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入名称</span>").appendTo(
				$('#namediv1'));
		$('#namediv1').addClass('has-error ');
	}else{
		$('#span').remove();
		$('#name1div').removeClass('has-error ');
	}
}
 
function update(basePath){
	if ($('#name1').val() == "") {
		$('#span').remove();
		$("<span style='color:red' id='span'>请输入名称</span>").appendTo(
				$('#namediv1'));
		$('#namediv1').addClass('has-error ');
		return;
	}else{
		$('#span').remove();
		$('#name1div').removeClass('has-error ');
	}
		  window.location.href=basePath+"myfamily/type/update.html?name="+$('#name1').val()+"&typeEdit="+$('#typeAj').val()+"&type="+$('#type').val()+"&pageNo="+$("#pageNo_result").val()+"&typeName="+$("#typeName").val()+"&id="+$('#tid').val();
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
			   url: "myfamily/type/checkFinancial.html",
			   dataType:"json",
			   data: {"ids":ids},
			   success: function(r){
				    if(r.is=="true"){
				    	$("#typeAj").attr("disabled", true) ;
				    }else{
				    	$("#typeAj").attr("disabled", false) 
				    } 
			   }
			});
	   $.ajax({
			   type: "POST",
			   url: "myfamily/type/edit.html",
			   dataType:"json",
			   data: {"ids":ids},
			   success: function(reslut){
				   var option = "";
			   		if(reslut.type=="0"){
			   		 	option = "<option  selected='selected' value='0'>"+"收入"+"</option>"+"<option   value='1'>"+"支出"+"</option>";
			   		 }else{
			   			option += "<option  selected='selected' value='1'>"+"支出"+"</option>"+"<option   value='0'>"+"收入"+"</option>";
			   		 }
				   $("#typeAj").empty().append(option);
				   $('#name1').val(reslut.typeName);
				   $('#tid').val(reslut.id);
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