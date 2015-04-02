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
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>my/tbversion/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<div class="form-group" >
				<label for="versionCodediv" class="col-sm-2 control-label" >
					<strong>存放版本例如 1 、 2、  3：</strong>
				</label>
				<div class="input-group col-sm-6" id="versionCodediv">
					<input type="text" class="form-control" id="versionCode" name="versionCode" placeholder="存放版本例如 1 、 2、  3"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="versionNamediv" class="col-sm-2 control-label" >
					<strong>存放版本号 例如 1.2.3：</strong>
				</label>
				<div class="input-group col-sm-6" id="versionNamediv">
					<input type="text" class="form-control" id="versionName" name="versionName" placeholder="存放版本号 例如 1.2.3"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="versionUpdatediv" class="col-sm-2 control-label" >
					<strong>版本升级更新内容：</strong>
				</label>
				<div class="input-group col-sm-6" id="versionUpdatediv">
					<input type="text" class="form-control" id="versionUpdate" name="versionUpdate" placeholder="版本升级更新内容"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="versionSizediv" class="col-sm-2 control-label" >
					<strong>app大小：</strong>
				</label>
				<div class="input-group col-sm-6" id="versionSizediv">
					<input type="text" class="form-control" id="versionSize" name="versionSize" placeholder="app大小"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="versionUrldiv" class="col-sm-2 control-label" >
					<strong>更新url路径：</strong>
				</label>
				<div class="input-group col-sm-6" id="versionUrldiv">
					<input type="text" class="form-control" id="versionUrl" name="versionUrl" placeholder="更新url路径"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="versionTimediv" class="col-sm-2 control-label" >
					<strong>时间：</strong>
				</label>
				<div class="input-group col-sm-6" id="versionTimediv">
					<input type="text" class="form-control" id="versionTime" name="versionTime" placeholder="时间"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="versionTypediv" class="col-sm-2 control-label" >
					<strong>类型 0--安卓 1--苹果：</strong>
				</label>
				<div class="input-group col-sm-6" id="versionTypediv">
					<input type="text" class="form-control" id="versionType" name="versionType" placeholder="类型 0--安卓 1--苹果"     required   onkeydown="if(event.keyCode==32) return false"    >
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