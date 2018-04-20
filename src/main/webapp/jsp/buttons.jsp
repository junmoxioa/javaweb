<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="statics.jsp"%>

<div class="layui-btn-group">
	<c:if test="${url != '/user'}">
		<button class="layui-btn layui-btn-primary layui-btn-sm" onclick="add()">
   		<i class="layui-icon">&#xe654;</i>
	  	</button>
	  	<button class="layui-btn layui-btn-primary layui-btn-sm" onclick="edit()">
	    	<i class="layui-icon">&#xe642;</i>
	  	</button>
	</c:if>
  	<button class="layui-btn layui-btn-primary layui-btn-sm" onclick="del()">
    	<i class="layui-icon">&#xe640;</i>
  	</button>
</div>

<script>

	/** 新增 */
	function add(){
		parent.layer.open({
	  		type: 2,
		  	title: '${name}/新增',
		  	shadeClose: true,
		  	shade: 0.1,
		  	area: ['50%', '50%'],	//宽, 高
		  	content: '${url}/add'
		});
	}
	
	/** 修改 */
	function edit(){
		
		var data = getData();
      	var count = data.length;
		
      	if(count ==0 || count > 1){
			parent.layer.alert("请选择一条数据操作", {
				title:false
				,closeBtn: 0
				,btnAlign: 'c'
				,icon: 0
			});
			return;
		}
		var id = data[0].id;
		parent.layer.open({
	  		type: 2,
		  	title: '${name}/修改',
		  	shadeClose: true,
		  	shade: 0.1,
		  	area: ['50%', '50%'],	//宽, 高
		  	content: '${url}/edit?id='+id
		});
	}
	
	/** 删除 */
	function del(){
		var data = getData();
      	var count = data.length;
		
      	if(count ==0){
			parent.layer.alert("请选择需要操作的数据",{
				title:false
				,closeBtn: 0
				,btnAlign: 'c'
				,icon: 0
			});
			return;
		}
		var id = 0;
		for(var i=0 ;i<data.length;i++ ){
			id=id+","+data[i].id;
		}
		parent.layer.confirm('确认要删除吗', {
			title:false
			,closeBtn: 0
			,btnAlign: 'c'
			,icon: 3
		}, function(index){
			$.ajax({
			   type: "POST",
			   url: "../${url }/del?ids="+id,
			   dataType: "json",
			   success: function (result) {
					console.log("result", result);
			   		if(result.success == true){
						parent.layer.msg(result.msg,{icon:1,time:1000});
						parent_data_re();
					}else{
						parent.layer.msg(result.msg,{icon:2,time:1000});
					}
			   	}
			});
		});
	}
	
	/** 获取多选框选中的数据 */
	function getData(){
		var checkStatus = table.checkStatus('lay_table');	//此处的'lay_table'是数据表格的id
      	return checkStatus.data;
	}
	
</script>