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
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>my/tbgoodspic/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<div class="form-group" >
				<label for="goodsOriginalPicUrldiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsOriginalPicUrldiv">
					<input type="text" class="form-control" id="goodsOriginalPicUrl" name="goodsOriginalPicUrl" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="goodsThumbPicUrldiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsThumbPicUrldiv">
					<input type="text" class="form-control" id="goodsThumbPicUrl" name="goodsThumbPicUrl" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="goodsSortdiv" class="col-sm-2 control-label" >
					<strong>正序排 数值越小越靠前：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsSortdiv">
					<input type="text" class="form-control" id="goodsSort" name="goodsSort" placeholder="正序排 数值越小越靠前"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="goodsCreateTimediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsCreateTimediv">
					<input type="text" class="form-control" id="goodsCreateTime" name="goodsCreateTime" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="goodsNumberdiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="goodsNumberdiv">
					<input type="text" class="form-control" id="goodsNumber" name="goodsNumber" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="isShowdiv" class="col-sm-2 control-label" >
					<strong>0 不显示 1 显示 同一件商品只能有一张图片是列表展示的：</strong>
				</label>
				<div class="input-group col-sm-6" id="isShowdiv">
					<input type="text" class="form-control" id="isShow" name="isShow" placeholder="0 不显示 1 显示 同一件商品只能有一张图片是列表展示的"     required   onkeydown="if(event.keyCode==32) return false"    >
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