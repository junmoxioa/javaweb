<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../statics.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>百度地图</title>
		<style type="text/css">
			body, html,#allmap {
				width: 100%;
				height: 100%;
				overflow: hidden;
				margin:0;
				font-family:"微软雅黑";
			}
		</style>
		<script type="text/javascript" 
			src="http://api.map.baidu.com/api?v=3.0&ak=riNGxGTvTrieYei08kXuQ4lrzwayTd1j">
		</script>
	</head>
	
	<body>
		<div id="allmap"></div>
	</body>
	<script type="text/javascript">
		// 百度地图API功能
		var map = new BMap.Map("allmap");    // 创建Map实例
		map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
		//添加地图类型控件
		map.addControl(new BMap.MapTypeControl({
			mapTypes:[
	            BMAP_NORMAL_MAP,
	            BMAP_HYBRID_MAP
	        ]}));
		map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
	</script>
</html>