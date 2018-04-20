<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../statics.jsp"%>
<%@ include file="../share_css_js.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>文件上传</title>
	</head>

	<body>
		<form action="/file/upload" enctype="multipart/form-data" method="post">
			<div class="layui-upload">
	  			<div class="layui-upload-list">
	    			<table class="layui-table">
		      			<thead>
		        			<tr>
		        				<th>文件名</th>
			        			<th>大小</th>
			        			<th>状态</th>
			       	 			<th>操作</th>
			      			</tr>
			      		</thead>
			      		<tbody id="fileList"></tbody>
			    	</table>
	  			</div>
		  		<button type="button" class="layui-btn layui-btn-primary" id="uploadList">选择多文件</button> 
		  		<button type="button" class="layui-btn" id="fileListAction">开始上传</button>
			</div>
		</form>
	</body>
	<script>
		layui.use(['form', 'upload'], function (){
			var form = layui.form;
			var upload = layui.upload;
			var $ = layui.$;
	  		var demoListView = $('#fileList')
		  		,uploadListIns = upload.render({
			    	elem: '#uploadList'
			    	,url: '/file/upload'
			    	,accept: 'file'
			    	,multiple: true
			    	,auto: false
			    	,bindAction: '#fileListAction'
			    	,choose: function(obj){
			      		var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
			      		//读取本地文件
			      		obj.preview(function(index, file, result){
			        		var tr = $(['<tr id="upload-'+ index +'">'
			          			,'<td>'+ file.name +'</td>'
			          			,'<td>'+ (file.size/1024).toFixed(2) +'kb</td>'
			          			,'<td>等待上传</td>'
			          			,'<td>'
			            		,'<button class="layui-btn layui-btn-mini demo-reload layui-hide">重传</button>'
			            		,'<button class="layui-btn layui-btn-mini layui-btn-danger demo-delete">删除</button>'
			          			,'</td>'
			       			,'</tr>'].join(''));
			        
			        		//单个重传
				        	tr.find('.demo-reload').on('click', function(){
				          		obj.upload(index, file);
				        	});
				        
				        	//删除
				        	tr.find('.demo-delete').on('click', function(){
				          		delete files[index]; //删除对应的文件
				          		tr.remove();
				          		uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
			        		});
				        
				        	demoListView.append(tr);
			      		});
			    	}
			    	,done: function(res, index, upload){
			      		if(res.data.code == 0){ //上传成功
				        	var tr = demoListView.find('tr#upload-'+ index)
				        	,tds = tr.children();
				        	tds.eq(2).html('<span style="color: #5FB878;">上传成功</span>');
				        	tds.eq(3).html(''); //清空操作
				        	return delete this.files[index]; //删除文件队列已经上传成功的文件
			      		}
			      		this.error(index, upload);
			    	}
			    	,error: function(index, upload){
			      		var tr = demoListView.find('tr#upload-'+ index)
			      		,tds = tr.children();
			      		tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
			      		tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
			    	}
	  			});
			})
	</script>
</html>