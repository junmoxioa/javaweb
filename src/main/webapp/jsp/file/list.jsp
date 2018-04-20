<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../statics.jsp"%>
<%@ include file="../share_css_js.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>文件下载</title>
	</head>

	<body>
		<table class="layui-hide" id="lay_table" lay-filter="fileData"></table>
	</body>
	
	<%@ include file="../templet.jsp"%>
	
	<script>
		layui.use(['table', 'layer'], function (){
			table = layui.table;
			layer = layui.layer;
			$ = layui.$;
		  
		  	//展示已知数据
		  	table.render({
				elem: '#lay_table'
				,url: '/file/list'
				,method: 'post'
				,cols: [[
				     {field: 'id', 			title: 'ID',	align: 'center', 	sort: true,}
		  			,{field: 'userName',	title: '上传人',	align: 'center'}
			      	,{field: 'fileName', 	title: '文件名称',	align: 'center'}
			      	,{field: 'fileSize', 	title: '文件大小',	align: 'center'}
			      	,{field: 'uploadTime', 	title: '上传时间',	align: 'center',	templet: '#fmt_up_time'}
			      	,{field: '', 			title: '操作',	align: 'center',	toolbar: '#download_bar'}
				]]
				,page: true //是否显示分页
			});
		  	
		  	//监听工具条事件
		  	table.on('tool(fileData)', function(obj){
	  	  		var data = obj.data; //获得当前行数据
		  	  	var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		  	 		
		  	  	if(layEvent === 'download'){
		  	  		window.location.href = '/file/download?fileName='+data.fileName;
		  	  	} else if(layEvent === 'del'){
		  	  		del(data);
		  	  	}
		  	});
		});
		
		//删除
		function del(data){
			parent.layer.confirm('确认要删除吗', {
				title:false
				,closeBtn: 0
				,btnAlign: 'c'
				,icon: 3
			}, function(index){
				$.post('/file/del', {
	  	  			fileName: data.fileName
	  	  		}, function (result){
	  	  			console.log("result", result);
			   		if(result.success == true){
						parent.layer.msg(result.msg,{icon:1,time:1000});
						data_re();
					}else{
						parent.layer.msg(result.msg,{icon:2,time:1000});
					}
	  	  		});
			});
		}
		
		//数据表格刷新
		function data_re(){
			table.reload('lay_table', {
				page: {
					curr: 1 //重新从第 1 页开始
		        }
			});
		}
	</script>
</html>