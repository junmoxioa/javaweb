/** 共用函数的定义 */


/** 父窗口显示成功提示信息 */
function parent_success_msg(msg){
	parent.layer.msg(msg, {icon: 1});
}

/** 父窗口显示失败提示信息 */
function parent_eroor_msg(msg){
	parent.layer.msg(msg, {
		time: 5000
		,shade: 0.005
		,shadeClose: true
		,icon: 2
		
	});
}

/** 父窗口数据表格刷新 */
function parent_data_re(){
	var iframe = parent.window.document.getElementById("mainFrame");
	iframe.contentWindow.data_re();
}

/** 显示成功提示信息 */
function success_msg(layer, msg){
	layer.msg(msg, {icon: 1});
}

/** 显示失败提示信息 */
function eroor_msg(layer, msg){
	layer.msg(msg, {
		time: 5000
		,shade: 0.005
		,shadeClose: true
		,icon: 2
		
	});
}

/** 请求成功时关闭子页面，显示操作成功提示 */
function success_opt(msg){
	close_frame(get_frame_index());	//关闭当前窗口
	parent_success_msg(msg);		//在父窗口显示提示信息
}

/** 请求失败时关闭子页面，显示操作失败提示 */
function error_opt(msg){
	close_frame(get_frame_index());	//关闭当前窗口
	parent_eroor_msg(msg);		//在父窗口显示提示信息
}

/** 获取当前窗口的索引 */
function get_frame_index(){
	return parent.layer.getFrameIndex(window.name);
}

/** 关闭当前窗口 */
function close_frame(index){
	parent.layer.close(index);
}
