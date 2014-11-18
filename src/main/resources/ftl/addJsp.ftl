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
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>${interceptUrl}/${tableInfo.getTableClassName()?lower_case}/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<#list tableInfo.tableColumns as columnInfo>
			<#if columnInfo.javaName != "id">
			<div class="form-group" >
				<label for="${columnInfo.javaName}div" class="col-sm-2 control-label" >
					<strong>${columnInfo.remark}：</strong>
				</label>
				<div class="input-group col-sm-6" id="${columnInfo.javaName}div">
					<input type="text" class="form-control" id="${columnInfo.javaName}" name="${columnInfo.javaName}" placeholder="${columnInfo.remark}"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			</#if>
			</#list>
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