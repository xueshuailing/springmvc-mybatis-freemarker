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
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>my/tbshopping/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<div class="form-group" >
				<label for="goodsIddiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsIddiv">
					<input type="text" class="form-control" id="goodsId" name="goodsId" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="goodsNamediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsNamediv">
					<input type="text" class="form-control" id="goodsName" name="goodsName" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="goodsNumdiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsNumdiv">
					<input type="text" class="form-control" id="goodsNum" name="goodsNum" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="goodsUrldiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsUrldiv">
					<input type="text" class="form-control" id="goodsUrl" name="goodsUrl" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="goodsCountdiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsCountdiv">
					<input type="text" class="form-control" id="goodsCount" name="goodsCount" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="goodsPricediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsPricediv">
					<input type="text" class="form-control" id="goodsPrice" name="goodsPrice" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="shoppingCountdiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="shoppingCountdiv">
					<input type="text" class="form-control" id="shoppingCount" name="shoppingCount" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="userIddiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="userIddiv">
					<input type="text" class="form-control" id="userId" name="userId" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
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