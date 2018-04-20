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
		<form class="layui-form" action="/user/root_config" method="post">
			<input type="hidden" name="userId">
			<div class="layui-form-item">
    			<label class="layui-form-label"></label>
    			<div class="layui-input-block" id="root_config">
    				
    			</div>
  			</div>
  			<div class="layui-form-item">
    			<div class="layui-input-block" style="">
      				<button class="layui-btn" lay-submit="" lay-filter="root_config">立即提交</button>
		    	</div>
		  	</div>
		</form>
	</body>
	<script>
		layui.use(['form', 'layer'], function(){
			var $ = layui.$;
			var form = layui.form;
			var layer = layui.layer;
	    	var result_s = '${result}';
	    	
	    	if (result_s.length > 0){
	    		var result = eval('(' + result_s + ')');
	    		if (result.success == true){
	    			if (result.data == undefined){
	    				success_opt(result.msg);
	    			}else{
	    				fn_(result, $);
		    			form.render('checkbox');
	    			}
	    		}else if(result.success == false){
	    			error_opt(result.msg);
	    		}
	    	}
		});
		
		/** 将所有菜单显示到页面, 用户拥有的勾选上 */
		function fn_(result, $){
			var menus = result.data.menus;
			var userMenus = result.data.userMenus;
			var div_ = $('#root_config');
			
			//设置隐藏参数的值/
			$("input[name='userId']").val(result.data.id);
			
			for (var i=0;i<menus.length;i++){
				var input = '<input type="checkbox" title="'+menus[i].menuName+'" value="'+menus[i].id+'" name="menuIds['+menus[i].id+']">';
				for (var j=0;j<userMenus.length;j++){
					if (menus[i].id == userMenus[j].menuId){
						input = '<input type="checkbox" title="'+menus[i].menuName+'" value="'+menus[i].id+'" name="menuIds['+menus[i].id+']" checked="">';
						break;
					}
				}
				$(div_).append(input);
			}
		}
	</script>
</html>