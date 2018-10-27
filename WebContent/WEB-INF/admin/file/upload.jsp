<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
	
	
</head>
<body>
	<div class="layui-tab">
		<ul class="layui-tab-title">
			<li class="layui-this">文件上传</li>
			<li>ajax上传文件</li>
			<li>ueditordemo</li>
			<li>商品管理</li>
			<li>订单管理</li>
		</ul>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<form class="layui-form" action="${contextpath }/file/upload"
					method="post" enctype="multipart/form-data">
					<div class="layui-form-item">
						<input type="file" name="file" class="layui-input">

					</div>
					<div class="layui-form-item">
						<input type="submit" value="文件上传" class="layui-input">

					</div>
				</form>

			</div>
			<div class="layui-tab-item">
				<button type="button" class="layui-btn" id="test2">
					<i class="layui-icon">&#xe67c;</i>上传图片
				</button>
			</div>
			<div class="layui-tab-item">
			
			<div id="editor"></div>
			
			</div>
			<div class="layui-tab-item">内容4</div>
			<div class="layui-tab-item">内容5</div>
		</div>
	</div>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script type="text/javascript" src="${contextpath}/js/plugins/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" src="${contextpath}/js/plugins/ueditor/ueditor.all.js"></script>
	<script>
		//注意：选项卡 依赖 element 模块，否则无法进行功能性操作
		layui.use('element', function() {
			var element = layui.element;

			//…
		});
		layui.use('upload', function(){
			  var upload = layui.upload;
			   
			  //执行实例
			  var uploadInst = upload.render({
			    elem: '#test2' //绑定元素
			    ,url: "${contextpath }/file/ajaxUpload" //上传接口
			    ,done: function(res){
			      alert(res)
			    }
			    ,accept:"file"
			    ,error: function(){
			      //请求异常回调
			    }
			  });
			});
		
		
		var ue = UE.getEditor('editor');
		
	</script>

</body>
</html>