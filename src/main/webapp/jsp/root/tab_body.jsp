<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="layui-tab layui-tab-brief" lay-allowclose="true" lay-filter="tab-switch">
	<ul class="layui-tab-title">
		<li class="layui-this first-tab">
	   		初始页
	   	</li>
	</ul>
 	<div class="layui-tab-content" id="left_tab_content">
    	<div class="layui-tab-item layui-show">
   			<iframe width="100%" style="min-height: 500px;"
     		onload="setIframeHeight(this)" frameborder="0" 
        		src="/first">
       		</iframe>
        </div>
    </div>
</div>