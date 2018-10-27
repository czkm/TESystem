<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑管理员信息</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${contextpath}/admin/edit.do"
		method="post">
		<input type="hidden" name="id" value="${admin.id}"> <input
			type="hidden" name="password" value="${admin.password}">
		<div class="layui-form-item">
			<label class="layui-form-label">名称</label>
			<div class="layui-input-block">
				<input type="text" name="adminName" value="${admin.adminName}"
					required lay-verify="required" placeholder="名称" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">登录名称</label>
			<div class="layui-input-block">
				<input type="text" name="loginname" value="${admin.loginname}"
					required lay-verify="required" placeholder="登录名称"
					autocomplete="off" class="layui-input" id="loginname">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">手机号码</label>
			<div class="layui-input-inline">
				<input type="text" name="mobile" value="${admin.mobile}" required
					lay-verify="required" placeholder="手机号码" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">请输入正确格式的手机号码</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">电子邮件</label>
			<div class="layui-input-inline">
				<input type="text" name="email" value="${admin.email}" required
					lay-verify="required" placeholder="电子邮件" autocomplete="off"
					class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux">请输入正确格式的电子邮件</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block">
				<select name="status" lay-verify="required">
					<option value="1">启用</option>
					<option value="0">未启用</option>

				</select>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script type="text/javascript"
		src="${contextpath}/js/jquery-3.2.1.min.js"></script>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script>
		//Demo
		layui.use('form', function() {
			var form = layui.form;
			$("#loginname").change(function() {
               var loginname=$(this).val();
               var json={
            		   
            		   "loginname":loginname
               }
               
               $.ajax({
       	    	method:"POST",
       	    	url:"${contextpath}/admin/checkadminname",
       	    	dataType:"application/json,charset=utf-8",
       	    	data:json,
       	    	dataType:"json",
       	    	beforeSend:function(){
       	    		layer.load(); //上传loading
       	    	},
       	    	success:function(res){
       	    		if(res.statusCode==0){    			
       	    			layer.msg(res.message,{icon:2}); 
       	    			$("#loginname").focus();
       	    			return false;
       	    			
       	    		}
       	    		if(res.statusCode==1){
       	    			
       	    			layer.msg(res.message,{icon:1}); 
       	    			return true;
       	    		}
       	    		
                      
       	    		
       	    	},
       	    	complete:function(){
       	    		
       	    		
       	    		   layer.closeAll('loading'); //关闭loading
       	    	}
       	    	
       	    	
       	    });
       	    return false;
			})
			//监听提交
			/*  form.on('submit(formDemo)', function(data){
			  layer.confirm('数据是否删除', {icon: 3, title:'提示'}, function(index){
				  //do something
				  
				  layer.close(index);
				});
			  return false;
			 }); */
		});
	</script>
</body>
</html>