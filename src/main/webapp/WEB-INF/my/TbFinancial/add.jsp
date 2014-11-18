<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="modal fade"  id="myModal" >
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header ">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h1 class="modal-title "><strong>添加</strong></h1>
      </div>
      <div class="modal-body">
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>my/tbfinancial/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<div class="form-group" >
				<label for="typeIddiv" class="col-sm-2 control-label" >
					<strong>财务的类型（存储的是财务类型表的id）：</strong>
				</label>
				<div class="input-group col-sm-6" id="typeIddiv">
					<input type="text" class="form-control" id="typeId" name="typeId" placeholder="财务的类型（存储的是财务类型表的id）"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="numdiv" class="col-sm-2 control-label" >
					<strong>金额：</strong>
				</label>
				<div class="input-group col-sm-6" id="numdiv">
					<input type="text" class="form-control" id="num" name="num" placeholder="金额"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="createDatediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="createDatediv">
					<input type="text" class="form-control" id="createDate" name="createDate" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="familyIddiv" class="col-sm-2 control-label" >
					<strong>该条财务是由哪个家庭成员产生的 存储的是家庭成员的id：</strong>
				</label>
				<div class="input-group col-sm-6" id="familyIddiv">
					<input type="text" class="form-control" id="familyId" name="familyId" placeholder="该条财务是由哪个家庭成员产生的 存储的是家庭成员的id"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="userIddiv" class="col-sm-2 control-label" >
					<strong>用户id：</strong>
				</label>
				<div class="input-group col-sm-6" id="userIddiv">
					<input type="text" class="form-control" id="userId" name="userId" placeholder="用户id"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="familySexdiv" class="col-sm-2 control-label" >
					<strong>成员性别 0--男 1--女 主要用来性别统计：</strong>
				</label>
				<div class="input-group col-sm-6" id="familySexdiv">
					<input type="text" class="form-control" id="familySex" name="familySex" placeholder="成员性别 0--男 1--女 主要用来性别统计"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="familyAgediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="familyAgediv">
					<input type="text" class="form-control" id="familyAge" name="familyAge" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="flagdiv" class="col-sm-2 control-label" >
					<strong>是否收入 0--是 1--不是：</strong>
				</label>
				<div class="input-group col-sm-6" id="flagdiv">
					<input type="text" class="form-control" id="flag" name="flag" placeholder="是否收入 0--是 1--不是"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="remarkdiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="remarkdiv">
					<input type="text" class="form-control" id="remark" name="remark" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger btn-xl" data-dismiss="modal">
  			<span class="glyphicon glyphicon-remove"></span> 取消
   		</button>
        <button type="button" class="btn btn-primary btn-xl" onclick="add();">
  			<span class="glyphicon glyphicon-saved"></span> 添加
   		</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->