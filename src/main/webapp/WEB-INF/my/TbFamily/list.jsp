<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html  lang="zh-CN">
  <head>
    <base href="<%=basePath%>">
  
    <title>xsl</title>
	<meta   name="viewport" content="width=device-width, initial-scale=1,IE=Edge"   http-equiv="X-UA-Compatible"   charset="UTF-8">    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<jsp:include  page="/common/commons.jsp" flush="true"/>     
	<!-- 引入日期插件css -->
		<link rel="stylesheet" href="<%=basePath%>common/css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
		<link rel="stylesheet" href="<%=basePath%>common/css/style.css">
  </head>
  
  <body>
  <form class="form-horizontal" role="form" id="serch" method="post" action="<%=basePath%>my/tbfamily/query.html">
  <div class="form-group">
     
  </div>
  <div style="float:left">
  <button type="button" class="btn btn-primary btn-xl" onclick="addModel();">
  		<span class="glyphicon glyphicon-plus"></span> 添加
   </button>
  <button type="button" class="btn btn-primary btn-xl" onclick="editForm();">
  		<span class="glyphicon glyphicon-pencil"></span> 修改
   </button>
   <button type="button" class="btn btn-primary btn-xl" onclick="del();">
  		<span class="glyphicon glyphicon-trash"></span> 删除
   </button>
   </div>
   <div style="float:right">
    <div class="col-md-1" >
	    <button type="button" class="btn btn-primary btn-xl"  onclick="serch();">
	  		<span class="glyphicon glyphicon-search"></span> 查询
	   </button>
   </div>
   </div>
</form>
   <input type="hidden" id="pageNo_result" value="${page.page}"/>
    	<div class="table-responsive">
			<table id="myTable" class="table table-condensed table-bordered" >
				<thead>
					<tr align="center">
					<td > <input type="checkbox" id="selectAll" name="selectAll"  ></td>
					<td >序号</td>
   					 <td >姓名</td>
   					 <td >性别 0--男 1--女</td>
   					 <td ></td>
   					 <td ></td>
   					 <td ></td>
					</tr>
				</thead>
					<tbody id="tb_tbody">
					<c:choose>
						<c:when  test="${(list)!= null && fn:length(list) > 0}">
							 <c:forEach var="d" items="${list}" varStatus="status">
		              	  		<tr align="center">
		              	  			<td> <input type="checkbox" name="id" id="id" value="${d.id }"></td>
									<td><span data-toggle="tooltip"   title="${(page.page-1)*page.pageSize+status.index + 1}">${(page.page-1)*page.pageSize+status.index + 1}</span></td>
   									 <td >
   									 <span  data-toggle="tooltip"   title="${d.name }">${d.name }</span></td>
   									 <td >
   									 <span  data-toggle="tooltip"   title="${d.sex }">${d.sex }</span></td>
   									 <td >
   									 <span  data-toggle="tooltip"   title="${d.userId }">${d.userId }</span></td>
   									 <td >
   									 <span  data-toggle="tooltip"   title="${d.createDate }">${d.createDate }</span></td>
   									 <td >
   									 <span  data-toggle="tooltip"   title="${d.age }">${d.age }</span></td>
									 
								</tr>
	                	  </c:forEach>
						</c:when>
						<c:otherwise>
							<tr align="center">
								<td colspan="7">暂无数据</td>
							</tr>
						</c:otherwise>
          			</c:choose>
					</tbody>
				</table>
		
		<div align="right">
			 <ul id="pagination-demo"class="pagination-sm"></ul>
		</div>
</div>
<!-- 添加弹出窗口 -->
<jsp:include  page="/WEB-INF/my/TbFamily/add.jsp" flush="true"/> 
		<!-- 日期插件js -->
	<script src="<%=basePath%>common/datepicker/date-range.js"></script>
	<script src="<%=basePath%>common/page/jquery.twbsPagination.js"></script>
	
	<script type="text/javascript">
	//弹出添加model
    function addModel(){
    	$('#myModal').modal('show');
    }
//工具提示
$(function () {
	row.rowClick("tb_tbody","id");
  $('[data-toggle="tooltip"]').tooltip();
})
		 //分页相关
		 $('#pagination-demo').twbsPagination({
        totalPages: ${page.pageCount},//总页数
        startPage:${page.page},//当前页
        visiblePages: 7,
         href: '<%=basePath%>my/tbfamily/query.html?pageNo={{number}}',
        onPageClick: function (event, page) {
            $('#page-content').text('Page ' + page);
        }
    });
    //全选
    $("#selectAll").click(function(){
    		if($("#selectAll").prop("checked")){
    			  $("input[name='id']").prop("checked", true);
    		} else{
    			 $("input[name='id']").prop("checked", false);
    		}
		  	 
	 });
		 
 
    //查询
	function serch(){
		var form1 = window.document.getElementById("serch");//获取form1对象
		form1.submit(); 
	};
	  //添加
    function add(){
		var form1 = window.document.getElementById("save");//获取form1对象
		form1.submit(); 
	};
	</script>
  </body>
</html>