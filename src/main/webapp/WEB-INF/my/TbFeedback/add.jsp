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
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>my/tbfeedback/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<div class="form-group" >
				<label for="phonediv" class="col-sm-2 control-label" >
					<strong>联系方式：</strong>
				</label>
				<div class="input-group col-sm-6" id="phonediv">
					<input type="text" class="form-control" id="phone" name="phone" placeholder="联系方式"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="opiniondiv" class="col-sm-2 control-label" >
					<strong>反馈内容：</strong>
				</label>
				<div class="input-group col-sm-6" id="opiniondiv">
					<input type="text" class="form-control" id="opinion" name="opinion" placeholder="反馈内容"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="userIddiv" class="col-sm-2 control-label" >
					<strong>员工id：</strong>
				</label>
				<div class="input-group col-sm-6" id="userIddiv">
					<input type="text" class="form-control" id="userId" name="userId" placeholder="员工id"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="dateTimediv" class="col-sm-2 control-label" >
					<strong>创建时间：</strong>
				</label>
				<div class="input-group col-sm-6" id="dateTimediv">
					<input type="text" class="form-control" id="dateTime" name="dateTime" placeholder="创建时间"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="userNamediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="userNamediv">
					<input type="text" class="form-control" id="userName" name="userName" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
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