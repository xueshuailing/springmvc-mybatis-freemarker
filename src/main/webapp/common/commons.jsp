<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="<%=basePath%>common/css/bootstrap.min.css">
<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet"
	href="<%=basePath%>common/css/bootstrap-theme.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="<%=basePath%>common/js/jquery.min.js"></script>
<script src="<%=basePath%>common/js/modal.js"></script>
<script src="<%=basePath%>common/js/popover.js"></script>
<script src="<%=basePath%>common/js/tooltip.js"></script>
<script src="<%=basePath%>common/js/transition.js"></script>
<script src="<%=basePath%>common/js/fullBg.js"></script>
<script src="<%=basePath%>common/js/jquery.tablesorter.min.js"></script>
<script src="<%=basePath%>common/js/row_click_plugin.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="<%=basePath%>common/js/bootstrap.min.js"></script>
<script src="<%=basePath%>common/js/docs.min.js"></script>
<!-- 日期插件（只适用日期范围查询） -->
<script src="<%=basePath%>common/js/bootstrap-datetimepicker.js"  charset="UTF-8"></script>
<script type="text/javascript" src="<%=basePath%>common/js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<!-- 打开 关闭  单选插件 -->
<script type="text/javascript" src="<%=basePath%>common/js/bootstrap-switch.js" charset="UTF-8"></script>
<script src="<%=basePath%>common/js/ie-emulation-modes-warning.js"></script>
<script src="<%=basePath%>common/js/ie10-viewport-bug-workaround.js"></script>
<link rel="icon" href="<%=basePath%>common/ico/favicon.ico">
