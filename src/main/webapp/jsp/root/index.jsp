<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../share_css_js.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>首页</title>
		
	</head>

	<body class="layui-layout-body">
		<div class="layui-layout layui-layout-admin">
			<!-- 顶部导航栏 -->
		    <div class="layui-header ">
		    	<%@ include file="header.jsp"%>
		    </div>
		
			<!-- 左侧菜单栏  -->
		    <div class="layui-side layui-bg-black">
		        <div class="layui-side-scroll">
		            <%@ include file="left_menu.jsp"%>
		        </div>
		    </div>
			
			<!-- tab选项卡和主体区域 -->
		    <div class="layui-body" style="bottom: 0px;">
		        <div style="padding-left: 15px">
		            <%@ include file="tab_body.jsp"%>
		        </div>
		    </div>
		</div>
		
		<script src="../../js/root/index.js"></script>
		
	</body>
	<style type="text/css">
		.first-tab i.layui-tab-close{
			display:none!important;
		}
	</style>
</html>