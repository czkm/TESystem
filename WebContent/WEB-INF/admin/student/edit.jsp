<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑学生信息</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${ contextpath}/student/edit.do"
		method="post">
		<input type="hidden" name="id" value="${student.id }"> 
		<input type="hidden" name="type" value="${student.type==null ? 1 : student.type}"> 
		<input
			type="hidden" name="password" value="${student.password}">
		<div class="layui-form-item">
			<label class="layui-form-label">部门</label>
			<div class="layui-inline">
				<select name="departid" lay-filter='departList'>
					<option value="0">选择部门</option>
					<c:forEach items="${departList }" var="vo">
						<c:choose>
							<c:when test="${vo.id==student.departid }">
								<option value="${vo.id }" selected>${vo.departName }</option>
							</c:when>
							<c:otherwise>
								<option value="${vo.id }">${vo.departName }</option>
							</c:otherwise>
						</c:choose>

					</c:forEach> 
					
				</select>
			</div>
			<div class="layui-inline">
				<select name="classesid" lay-verify="required" id="classesList">
					<!-- var="classes" 不能使用，会出现问题-->
				    <option value="0">请选择班级</option>
					<c:forEach items="${classesList }" var="vo">
						<c:choose>
							<c:when test="${vo.id==student.classesid }">
								<option value="${vo.id }" selected>${vo.classesName }</option>
							</c:when>
							<c:otherwise>
								<option value="${vo.id }">${vo.classesName }</option>
							</c:otherwise>
						</c:choose>

					</c:forEach> 

				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学生名称</label>
			<div class="layui-input-block">
				<input type="text" name="username" value="${student.username}"
					required lay-verify="required" placeholder="学生名称"
					autocomplete="off" class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">学号</label>
			<div class="layui-input-block">
				<input type="text" name="userno" value="${student.userno}"
					required lay-verify="required" placeholder="学号" autocomplete="off"
					class="layui-input" id="userno" >
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">状态</label>
			<div class="layui-input-block">
					<select name="status" lay-verify="required">
					<!-- var="classes" 不能使用，会出现问题-->
	
						<c:choose>
							<c:when test="${1==student.status}">
								<option value="1" selected>启用</option>
								<option value="0" >未启用</option>
							</c:when>
							<c:when test="${0==student.status}">
								<option value="1" >启用</option>
								<option value="0" selected>未启用</option>
							</c:when>
							<c:otherwise>
								<option value="1" selected>启用</option>
								<option value="0" >未启用</option>
							</c:otherwise>
						</c:choose>
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
	<script type="text/javascript" src="${contextpath}/js/jquery-3.2.1.min.js"></script>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>

	<script type="text/javascript">
		//Demo

		layui.use('form', function() {
			var form = layui.form;
			$("#userno").change(function() {
	               var userno=$(this).val();
	               var json={
	            		   
	            		   "userno":userno
	               }
	               
	               $.ajax({
	       	    	method:"POST",
	       	    	url:"${contextpath}/user/checkuserno",
	       	    	dataType:"application/json,charset=utf-8",
	       	    	data:json,
	       	    	dataType:"json",
	       	    	beforeSend:function(){
	       	    		layer.load(); //上传loading
	       	    	},
	       	    	success:function(res){
	       	    		if(res.statusCode==0){    			
	       	    			layer.msg(res.message,{icon:2}); 
	       	    			$("#userno").focus();
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
				});
			
			
			
			form.on('select(departList)', function(data1) {
				var departId = data1.value;

				$.ajax({
					type : 'POST',
					url : '${contextpath}/student/queryClasses.do',
					data : {
						departId : departId
					},
					dataType : 'json',
					success : function(res) {
						$("#classesList").empty();
						$.each(res, function(index, value) {
							var option = $('<option>').val(value.id).text(
									value.classesName);
							$("#classesList").append(option);
							form.render('select');

						})

					}

				});

				  return false;

			});
			//监听提交
		
			form.on('submit(formDemo)', function(data){

			  
			  var departid=data.field.departid;
			  if(departid=="0"){
				  
				  layer.msg("表单提交前要先选择部门!!!",{icon:2});
				  return false;
			  }
	
			  
			});
			 
		});
	</script>
</body>
</html>