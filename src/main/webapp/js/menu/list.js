/** list.jsp页面的js */

var table, layer, $, active
layui.use(['table', 'layer'], function(){
  	table = layui.table;
  	layer = layui.layer;
  	$ = layui.$;
  
  	//展示已知数据
  	table.render({
		elem: '#lay_table'
		,url: '/menu/list'
		,method: 'post'
		,cols: [[
		     {type:'checkbox'}
		    ,{field: 'id', 			title: 'ID', 	align: 'center', 	sort: true,}
  			,{field: 'menuName',	title: '名称', 	align: 'center'}
	      	,{field: 'menuUrl', 	title: '路径', 	align: 'center'}
		]]
		,page: true //是否显示分页
	});
	
  	active = {
		reload: function(){
			var demoReload = $('#demoReload');
		      
			//执行重载
			table.reload('lay_table', {
				page: {
					curr: 1 //重新从第 1 页开始
		        }
		        ,where: {
	        		menuName: demoReload.val()
		        }
			});
		}
	};
	
	$('.demoTable .layui-btn').on('click', function(){
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});
	
});

/** 数据表格刷新 */
function data_re(){
	table.reload('lay_table', {
		page: {
			curr: 1 //重新从第 1 页开始
        }
	});
}
