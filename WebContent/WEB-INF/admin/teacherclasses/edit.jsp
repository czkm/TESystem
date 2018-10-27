<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师添加上课班级</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${contextpath }/teacherclasses/edit"
		method="post">
		<input type="hidden" name="id" value="${teacherclasses.id}"> <input
			type="hidden" name="teacherId" value="${teacherclasses.teacherId}">
		<div class="layui-form-item">
			<label class="layui-form-label">选择班级</label>
			<div class="layui-input-block">
				<div class="layui-collapse" lay-accordion>
					<div class="layui-colla-item">
					<c:forEach items="${departmentAndClassesVos }" var="depart">
					
						<h2 class="layui-colla-title">${depart.departName }</h2>												
						<div class="layui-colla-content layui-show">
						<c:forEach items="${ depart.classeses}" var="classes">
						<input type="checkbox" name="classesIds" value="${classes.id }" title="${classes.classesName}">						
						</c:forEach>
						</div>
					
					</c:forEach>
					
					</div>
				
				</div>
			</div>
		</div>
	

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
	<script src="${contextpath}/js/jquery-3.2.1.min.js"></script>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script>
		//Demo
		layui.use('form', function() {
			var form = layui.form;

			//监听提交
			/*
			form.on('submit(formDemo)', function(data){
			  layer.msg(JSON.stringify(data.field));
			  return false;
			});
			 */
		});
	</script>
</body>
</html>