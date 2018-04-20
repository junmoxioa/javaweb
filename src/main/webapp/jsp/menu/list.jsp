<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../statics.jsp"%>
<%@ include file="../share_css_js.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>数据表格</title>
		
		<c:set var="url" value="/menu"/>
		<c:set var="name" value="菜单"/>
	</head>
	
	<body>
		
		<div class="demoTable" style="margin-bottom: 5px">
	  		菜单名称
		  	<div class="layui-inline">
		    	<input class="layui-input" name="id" id="demoReload" autocomplete="off">
		  	</div>
		  	<button class="layui-btn" data-type="reload">搜索</button>
		</div>
		
		<!-- 按钮 -->
		<%@ include file="../buttons.jsp"%>
		
		<table class="layui-hide" id="lay_table" lay-filter="menuData"></table>
		
		<!--  -->
		<script src="../../js/menu/list.js"></script>
	</body>
</html>