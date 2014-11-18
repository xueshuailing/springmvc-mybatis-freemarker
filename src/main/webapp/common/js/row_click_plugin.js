/**
 * @author zyl
 * @param {Object} table -->tbody的id
 * @param {Object} checkboxName -->checkbox的name属性
 */
var row = {
	sc:function(table,checkboxName){
		$("#"+table).find("tr td").click(function(){
			$(this).parent().find("input[name='"+checkboxName+"']").attr("checked",!$(this).parent().find("input[name='"+checkboxName+"']").attr("checked"));
		});
	},
	backgroundColor:function(table){
		$("#"+table).find("tr:odd").css("background-color","#F5F9FB");
	},
	mousemoveBackground:function(table){
		$("#"+table).find("tr").hover(function(){
			$(this).find("td").css("background-color","#E1F1FB");
		},function(){
			var o = $(this).index()%2;
			$(this).find("td").css("background-color",o==1?"#F5F9FB":"#FFFFFF");
		});
	},
	rowNumber:function(pageSize,pageNo,spanName){
		var span = $("span[name='"+spanName+"']");
		$.each(span,function(i,v){
			$(this).html(pageSize*(pageNo-1)+$(this).parent().parent().index()+1);
		});
	},
	rowClick:function(table,checkboxName){
		$("#"+table).find("tr td").click(function(){
			var cbk = $(this).parent().find("input[name='"+checkboxName+"']");
			if(cbk.data("cbk")==0){
				cbk.data("cbk",1);
				cbk.prop("checked",false);
			}else{
				cbk.data("cbk",0);
				cbk.prop("checked",true);
			}
		});
	},
	rowSelectOrCancel:function(table,checkboxName){
		var cbk = $("input[name='"+checkboxName+"']").first();
		cbk.click(function(){
			$("#"+table).find("input[name='"+checkboxName+"']").prop("checked",$(this).attr("checked")!=undefined);
		});
	}
};