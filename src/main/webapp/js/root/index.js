/** index.jsp页面的js */

var lay_ids  = new Array();		//储存所有已经打开的tab lay_id

layui.use(['element', 'layer'], function(){
	var element  = layui.element;
	var layer  = layui.layer;
	var $ = layui.$;
	
	// 监听左侧导航栏点击
	element.on('nav(left-menu)', function(elem){
		var lay_title = elem.find('a').text()
  		,lay_url = elem.attr('data-name')
  		,lay_id = elem.attr('id');
  		addTab(lay_title, lay_url, lay_id);
	});
	
	// 监听tab切换
	element.on('tab(tab-switch)', function(data){
		setMenuClaee($(this).attr('lay-id'))	//修改对应左侧菜单的样式
	});
	
	// 监听删除tab事件 
  	element.on('tabDelete(tab-switch)', function(data){
  		//获取对应的 lay-id 然后从数组中删除
  		var lay_id = $(this).parent().attr("lay-id");
		removeById(lay_id);
	});
	
	/** 添加tab */
	function addTab(lay_title, lay_url, lay_id){
		if (!check(lay_id)){
			return false;
		}
		
		var content = 
			'<iframe width="100%" id="mainFrame" name="mainFrame" style="min-height: 600px;" onload="setIframeHeight(this)" frameborder="0" src="'+lay_url+'">' +
			'</iframe>';
		
		element.tabAdd('tab-switch', {
	  		title: lay_title
		  	,content: content //支持传入html
		  	,id: lay_id
		});
		
		lay_ids.push(lay_id);	//将tab对应的lay-id添加到数组中
		tabChange(lay_id);		//切换到新增的tab
	}
	
	/** 判断要添加tab的是否已经打开,打开则直接切换 */
	function check(lay_id){
		for (var i=0;i<lay_ids.length;i++){
			if (lay_ids[i] == lay_id){
				tabChange(lay_id);
				return false;
			}
		}
		return true;
	}
	
	/** 删除数组中指定的元素 */
  	function removeById(lay_id) {
  		for(var i=0; i<lay_ids.length; i++) {
  			if(lay_ids[i] == lay_id) {     
  				lay_ids.splice(i, 1);
  				break;    
			}  
		}
	}
	
	/** 切换到指定的tab */
	function tabChange(lay_id){
		element.tabChange('tab-switch', lay_id);
	}
	
	/** 切换tab时修改对应的左侧菜单的样式 */
	function setMenuClaee(lay_id){
		
		layui.each($(".layui-nav-item"), function () {
			$(this).attr("class","layui-nav-item");
        });
		
		layui.each($(".layui-nav-child"), function () {
            $(this).find("dd").removeClass("layui-this");
        });
		
		if (undefined == lay_id){
			return;
		}
		
		$("#"+lay_id).attr("class","layui-nav-item layui-this");
		
	}
});

/** ifrme自适应页面高度，需要设定min-height */
function setIframeHeight(iframe) {
    if (iframe) {
        var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
        if (iframeWin.document.body) {
            iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
        }
    }
};
