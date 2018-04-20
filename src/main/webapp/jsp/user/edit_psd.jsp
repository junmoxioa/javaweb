<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../statics.jsp"%>
<%@ include file="../share_css_js.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>权限配置</title>
		
	</head>
	
	<body>
		<div class="site-text" style="text-align: center">
			<form class="layui-form layui-form-pane" action="/user/edit_psd" method="post">
				<div class="layui-form-item" style="margin-left: 40%;margin-top: 5%">
	    			<label class="layui-form-label">原密码</label>
	    			<div class="layui-input-inline" >
	    				<input type="password" name="password" required="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
	    			</div>
	  			</div>
	  			<div class="layui-form-item" style="margin-left: 40%">
	    			<label class="layui-form-label">新密码</label>
	    			<div class="layui-input-inline" >
	    				<input type="password" name="password2" required="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
	    			</div>
	  			</div>
	  			<div class="layui-form-item" style="margin-left: 40%">
	    			<label class="layui-form-label">确认密码</label>
	    			<div class="layui-input-inline" >
	    				<input type="password" name="password3" required="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
	    			</div>
	  			</div>
	  			<div class="layui-form-item">
	    			<div class="layui-input-block" style="">
	      				<button class="layui-btn" lay-submit="" lay-filter="edit_psd">确定</button>
			    	</div>
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
						success_opt(result.msg);
					}else if(result.success == false){
						eroor_msg(layer, result.msg);
		    		}
				}
				
				//监听表单提交
				form.on('submit(edit_psd)', function(data){
					if (data.field.password2 != data.field.password3){
				 		layer.msg('两次密码不一致', {icon: 5});
						return false;
				 	}
	    		});
				
			});
		</script>
	</body>
</html>