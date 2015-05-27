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
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>my/tbreceipt/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<div class="form-group" >
				<label for="userIddiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="userIddiv">
					<input type="text" class="form-control" id="userId" name="userId" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="receiptPhonediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="receiptPhonediv">
					<input type="text" class="form-control" id="receiptPhone" name="receiptPhone" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="isDefaultdiv" class="col-sm-2 control-label" >
					<strong>0--不是默认收货地址
            1--是默认收货地址：</strong>
				</label>
				<div class="input-group col-sm-6" id="isDefaultdiv">
					<input type="text" class="form-control" id="isDefault" name="isDefault" placeholder="0--不是默认收货地址
            1--是默认收货地址"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="addressdiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="addressdiv">
					<input type="text" class="form-control" id="address" name="address" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="receiptNamediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="receiptNamediv">
					<input type="text" class="form-control" id="receiptName" name="receiptName" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="proIddiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="proIddiv">
					<input type="text" class="form-control" id="proId" name="proId" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="cityIddiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="cityIddiv">
					<input type="text" class="form-control" id="cityId" name="cityId" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="countIddiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="countIddiv">
					<input type="text" class="form-control" id="countId" name="countId" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
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