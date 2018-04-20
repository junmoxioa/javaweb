<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../statics.jsp"%>
<%@ include file="../share_css_js.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>新增</title>
	</head>

	<body>
		<div class="site-text" style="text-align: center">
	    	<form class="layui-form layui-form-pane" action="/menu/add" method="post" id="menu_form">
	   			<input type="hidden" name="id">
		        <div class="layui-form-item" style="margin-left: 40%;margin-top: 5%">
	          		<label class="layui-form-label">菜单名称</label>
	          		<div class="layui-input-inline">
	            		<input type="text" name="menuName" required="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
	          		</div>
	        	</div>
	        	<div class="layui-form-item" style="margin-left: 40%">
	          		<label class="layui-form-label">菜单路径</label>
	          		<div class="layui-input-inline">
	            		<input type="text" name="menuUrl" required="" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
	          		</div>
	        	</div>
	        	<div class="layui-form-item">
	          		<button class="layui-btn" lay-submit="" lay-filter="formDemoPane">保存</button>
	        	</div>
	    	</form>
	    </div>
	    
	    <script type="text/javascript">
		    layui.use(['form', 'layer'], function(){ 
		    				
		    	var $ = layui.$;
		    	var layer = layui.layer;
		    	var result_s = '${result}';
		    	
		    	if (result_s.length > 0){
		    		var result = eval('(' + result_s + ')');
		    		if (result.success == true){
		    			if (result.data == undefined){
		    				success_opt(result.msg);
		    				parent_data_re();
			    		}else{
			    			var menu = result.data;
			    			$("input[name='menuName']").val(menu.menuName);
			    			$("input[name='menuUrl']").val(menu.menuUrl);
			    			$("input[name='id']").val(menu.id);
			    			
			    			//修改form表单的提交路径
			    			$('#menu_form').attr('action', '/menu/edit')
			    		}
		    		}else if(result.success == false){
		    			eroor_msg(layer, result.msg);
		    		}
		    	}
		    });
	    </script>
	</body>
</html>