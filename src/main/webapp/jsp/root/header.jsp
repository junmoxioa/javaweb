<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../statics.jsp"%>

<!-- logo区域 -->
<div class="layui-logo">
     <i class="layui-icon" style="font-size: 26px; color: #1E9FFF;"></i>
     layui多页面集成
</div>

<!-- 顶部左侧导航栏 -->
<ul class="layui-nav layui-layout-left">
	<li class="layui-nav-item"><a href="">顶部靠左导航栏</a></li>
    <li class="layui-nav-item">
        <a href="javascript:;">一级菜单<span class="layui-nav-more"></span></a>
        <dl class="layui-nav-child">
            <dd><a href="">二级菜单</a></dd>
        </dl>
    </li>
</ul>

<!-- 顶部右侧导航栏 -->
<ul class="layui-nav layui-layout-right">
	<li class="layui-nav-item"><a href="">顶部靠右导航栏</a></li>
	<li class="layui-nav-item">
    	<a href="javascript:;">
           	${sessionScope.user_info.user.userName }
         	<span class="layui-nav-more"></span>
        </a>
        <dl class="layui-nav-child">
        	<dd><a href="/logout">退出</a></dd>
        	<dd><a href="#" onclick="edit_psd();return false;">修改密码</a></dd>
        </dl>
     </li>
</ul>
<script>
	function edit_psd(){
		parent.layer.open({
	  		type: 2,
		  	title: '密码修改',
		  	shadeClose: true,
		  	shade: 0.1,
		  	area: ['50%', '50%'],	//宽, 高
		  	content: '/user/edit_psd'
		});
	}
</script>