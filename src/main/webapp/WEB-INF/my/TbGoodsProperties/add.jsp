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
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>my/tbgoodsproperties/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<div class="form-group" >
				<label for="namediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="namediv">
					<input type="text" class="form-control" id="name" name="name" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="isManydiv" class="col-sm-2 control-label" >
					<strong>是否多选 0--否 1--是：</strong>
				</label>
				<div class="input-group col-sm-6" id="isManydiv">
					<input type="text" class="form-control" id="isMany" name="isMany" placeholder="是否多选 0--否 1--是"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="parentIddiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="parentIddiv">
					<input type="text" class="form-control" id="parentId" name="parentId" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="isPublicdiv" class="col-sm-2 control-label" >
					<strong>是否公共属性 0--否 1--是：</strong>
				</label>
				<div class="input-group col-sm-6" id="isPublicdiv">
					<input type="text" class="form-control" id="isPublic" name="isPublic" placeholder="是否公共属性 0--否 1--是"     required   onkeydown="if(event.keyCode==32) return false"    >
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