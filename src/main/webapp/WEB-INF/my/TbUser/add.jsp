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
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>my/tbuser/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<div class="form-group" >
				<label for="namediv" class="col-sm-2 control-label" >
					<strong>姓名：</strong>
				</label>
				<div class="input-group col-sm-6" id="namediv">
					<input type="text" class="form-control" id="name" name="name" placeholder="姓名"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="agediv" class="col-sm-2 control-label" >
					<strong>年龄：</strong>
				</label>
				<div class="input-group col-sm-6" id="agediv">
					<input type="text" class="form-control" id="age" name="age" placeholder="年龄"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="sexdiv" class="col-sm-2 control-label" >
					<strong>性别 0--男 1--女：</strong>
				</label>
				<div class="input-group col-sm-6" id="sexdiv">
					<input type="text" class="form-control" id="sex" name="sex" placeholder="性别 0--男 1--女"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="emaildiv" class="col-sm-2 control-label" >
					<strong>邮箱：</strong>
				</label>
				<div class="input-group col-sm-6" id="emaildiv">
					<input type="text" class="form-control" id="email" name="email" placeholder="邮箱"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="phonediv" class="col-sm-2 control-label" >
					<strong>手机号：</strong>
				</label>
				<div class="input-group col-sm-6" id="phonediv">
					<input type="text" class="form-control" id="phone" name="phone" placeholder="手机号"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="passworddiv" class="col-sm-2 control-label" >
					<strong>密码：</strong>
				</label>
				<div class="input-group col-sm-6" id="passworddiv">
					<input type="text" class="form-control" id="password" name="password" placeholder="密码"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="timediv" class="col-sm-2 control-label" >
					<strong>创建时间：</strong>
				</label>
				<div class="input-group col-sm-6" id="timediv">
					<input type="text" class="form-control" id="time" name="time" placeholder="创建时间"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="statediv" class="col-sm-2 control-label" >
					<strong>是否激活 0--未激活 1--激活：</strong>
				</label>
				<div class="input-group col-sm-6" id="statediv">
					<input type="text" class="form-control" id="state" name="state" placeholder="是否激活 0--未激活 1--激活"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="numberdiv" class="col-sm-2 control-label" >
					<strong>激活码：</strong>
				</label>
				<div class="input-group col-sm-6" id="numberdiv">
					<input type="text" class="form-control" id="number" name="number" placeholder="激活码"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="endTimediv" class="col-sm-2 control-label" >
					<strong>到期时间：</strong>
				</label>
				<div class="input-group col-sm-6" id="endTimediv">
					<input type="text" class="form-control" id="endTime" name="endTime" placeholder="到期时间"     required   onkeydown="if(event.keyCode==32) return false"    >
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