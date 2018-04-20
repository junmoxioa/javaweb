<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../share_css_js.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>登录</title>
		
		<link rel="stylesheet" href="../../css/drag.css">

		<script src="../../js/jquery-1.7.2.min.js"></script>
		<script src="../../js/drag.js"></script>
		
	</head>

	<body>
		<div class="site-text" style="text-align: center"><!--  -->
	    	<form class="layui-form layui-form-pane" action="/login" method="post">
		        <div class="layui-form-item" style="margin-left: 40%;margin-top: 5%">
	          		<label class="layui-form-label">姓名</label>
	          		<div class="layui-input-inline">
	            		<input type="text" name="userName" required="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
	          		</div>
	        	</div>
	        	<div class="layui-form-item" style="margin-left: 40%">
	          		<label class="layui-form-label">密码</label>
	          		<div class="layui-input-inline">
	            		<input type="password" name="password" required="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
	          		</div>
	        	</div>
	        	<div class="layui-form-item" style="margin-left: 40%">
        			<div id="drag"></div>
        		</div>
	        	<div class="layui-form-item">
	          		<button class="layui-btn" lay-submit="" lay-filter="login">登录</button>
	          		<a href="/register"><font color="green">注册</font></a>
	        	</div>
	        	<div class="layui-form-item">
	        	</div>
	    	</form>
	    </div>
		<script>
			layui.use(['form', 'layer'], function(){
				var layer  = layui.layer;
				var form  = layui.form;
				var $ = layui.$;
				
				//获取请求返回值
				var result_s = '${result}'
				if (result_s.length > 0){
					var result = eval('(' + result_s + ')');
					console.log('result', result)
					if (result.success == true){
						layer.msg(result.msg,{
							icon: 1
							,time: 500
							,end: function (index){
								window.location.href = '/index'
							}
						});
					}else if(result.success == false){
						eroor_msg(layer, result.msg);
		    		}
				}
				
				//监听表单提交
				form.on('submit(login)', function(data){
					if (!$('#drag').getVer()){
						layer.msg('请完成滑动验证', {icon: 5});
						return false;
					}
	    		});
				
				//加载滑动验证
				$('#drag').drag();
			});
		</script>
	</body>
</html>