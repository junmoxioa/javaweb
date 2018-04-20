<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="statics.jsp"%>

<script type="text/javascript">
	/** 格式化日期 */
	function getLocalTime(nS) {
		
		if (nS){
			var time = new Date(nS);
			var y = time.getFullYear();//年
			var M = fill(time.getMonth() + 1);//月
			var d = fill(time.getDate());//日
			var h = fill(time.getHours());//时
			var m = fill(time.getMinutes());//分
			var s = fill(time.getSeconds());//秒
			
			return (y + "/" + M + "/" + d + "  " + h + ":" + m + ":" + s);
		}
		
		return "";
	}
	
	/** 将日期不足两位的补0 */
	function fill(param){
		if (param < 10){
			param = "0" + param;
		}
		return param;
	}
</script>

<!-- 查看图片 -->
<script type="text/html" id="img">
  	<a href="{{d.img}}" 
		class="layui-btn layui-btn-primary layui-btn-xs" 
		target="_blank">
		打开
	</a>
</script>

<!-- 格式化上传时间 -->
<script type="text/html" id="fmt_up_time">
  	{{ getLocalTime(d.uploadTime) }}
</script>

<!-- 格式化创建时间 -->
<script type="text/html" id="fmt_cr_time">
  	{{ getLocalTime(d.creatime) }}
</script>

<!-- 格式化修改时间 -->
<script type="text/html" id="fmt_mo_time">
  	{{ getLocalTime(d.modifytime) }}
</script>

<!-- 借支人-->
<script type="text/html" id="name">
  	{{ d.user.name }}
</script>

<!-- 状态 -->
<script type="text/html" id="state">
  	{{#  if(d.state === 'd'){ }}
    	待审核
  	{{#  } else if(d.state === 'y'){ }}
    	<span style="color: #01AAED;">已审核</span>
  	{{#  } else if(d.state === 'h'){ }}
		<span style="color: #FFB800;">已打回</span>
	{{#  } else { }}
		<span style="color: #FF5722;">已拒绝</span>
	{{#  } }}
</script>

<!-- 职位 -->
<script type="text/html" id="position">
  	{{#  if(d.position === 'a'){ }}
    	管理员
  	{{#  } else if(d.position === 'e'){ }}
    	员工
  	{{#  } else if(d.position === 'm'){ }}
		经理
	{{#  } else { }}
		老板
	{{#  } }}
</script>

<!-- 文件下载表格工具条 -->
<script type="text/html" id="download_bar">
  	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="download">下载</a>
  	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script type="text/html" id="user_bar">
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="root_config">权限配置</a>
</script>