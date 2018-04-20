<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../statics.jsp"%>

<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
<ul class="layui-nav layui-nav-tree" lay-filter="left-menu">
	<c:forEach items="${sessionScope.user_info.menuList }" var="i">
		<li class="layui-nav-item" id="${i.id }" data-name="${i.menuUrl }">
			<a href="javascript:;">${i.menuName }</a>
		</li>
	</c:forEach>
</ul>