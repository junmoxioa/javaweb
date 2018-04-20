<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../statics.jsp"%>
<%@ include file="../share_css_js.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>数据表格</title>
		
		<c:set var="url" value="/user"/>
		<c:set var="name" value="用户"/>
	</head>
	
	<body>
		<!-- 查询 -->
		<div style="margin-bottom: 5px">
			用户名称 ：
		  	<div class="layui-inline">
		    	<input class="layui-input" id="userName">
		  	</div>
		  	<button class="layui-btn" onclick="query();">搜索</button>
		</div>
		
		<!-- 按钮 -->
		<%@ include file="../buttons.jsp"%>
		
		<!-- 数据表格的容器 -->
		<table class="layui-hide" id="lay_table" lay-filter="userData"></table>
		
		<!-- 模板 -->
		<%@ include file="../templet.jsp"%>
		
		<!-- 页面专属js文件 -->
		<script src="../../js/user/list.js"></script>
	</body>
</html>