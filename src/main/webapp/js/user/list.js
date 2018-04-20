/** user/list.jsp页面的js */

var table, layer, $;
layui.use(['table', 'layer'], function(){
  	table = layui.table;
  	layer = layui.layer;
  	$ = layui.$;
  
  	//展示已知数据
  	table.render({
		elem: '#lay_table'
		,url: '/user/list'
		,method: 'post'
		,cols: [[
		     {type:'checkbox'}
		    ,{field: 'id', 			title: 'ID', 	align: 'center', 	sort: true,}
  			,{field: 'userName',	title: '名称', 	align: 'center'}
	      	,{field: 'age', 		title: '年龄', 	align: 'center'}
	      	,{fixed: '', 			title: '操作',	align: 'center',	toolbar: '#user_bar'}
		]]
		,page: true //是否显示分页
	});
	
  	//监听工具条
  	table.on('tool(userData)', function(obj){
  		var data = obj.data;
  		if(obj.event === 'root_config'){
  			root_config(data);
  		} else {
  			
  		}
    });
	
});

/** 查询 */
function query(){
	table.reload('lay_table', {
		page: {
			curr: 1 //重新从第 1 页开始
        }
        ,where: {
    		userName: $('#userName').val()
        }
	});
}

/** 数据表格刷新 */
function data_re(){
	table.reload('lay_table', {
		page: {
    		curr: 1 //重新从第 1 页开始
  		}
	})
}

/** 权限配置 */
function root_config(data){
	parent.layer.open({
  		type: 2,
	  	title: '权限配置',
	  	shadeClose: true,
	  	shade: 0.1,
	  	area: ['50%', '50%'],	//宽, 高
	  	content: '/user/root_config?id='+data.id
	});
}
