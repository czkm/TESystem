<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>标准管理</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${contextpath }/criteriaclasses/index.do"
		method="post">
		<table class="layui-table">
			<colgroup>
				<col >
				<col width="150">
				<col width="150">
				<col width="200">
			</colgroup>
			<thead>
				<tr>
					<th>标准</th>
					<th>权重</th>					
				   <th>状态</th>	
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="10">
						
						<div class="layui-inline">

							<input type="text" name="criteriaName" placeholder="标准"
								class="layui-input">
						</div> 

						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						</div>

						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/criteriaclasses/toedit.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>



					</td>
				</tr>
				<c:forEach items="${criteriaClassesList }" var="criteria">
					<tr>
						
						<td>${criteria.criteriaName}</td>
						<td>${criteria.weight}</td>
						<td><select id="status">
						<c:choose>
						<c:when test="${criteria.status==1}">
						<option value="1" selected>启用</option>
						<option value="0" >未启用</option>
						</c:when>
						<c:otherwise>
						<option value="1" >启用</option>
						<option value="0" selected>未启用</option>
						
						</c:otherwise>
						</c:choose>
						</select>
						</td>
						
						
					</td>
						<td>
							<div class="layui-btn-group">

								<a href="${contextpath}/criteriaclasses/toedit.do?id=${criteria.id}"
									class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
									class="layui-icon">&#xe642;</i>
								</a>  <a href="${contextpath}/criteriaclasses/delete.do?id=${criteria.id}"
									class="layui-btn layui-btn-sm" alt="删除" title="删除"
									onclick="return confirm('是否要删除数据')"> <i class="layui-icon">&#xe640;</i>
								</a>

							</div>
						</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</form>
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
			});*/
		});
	</script>
</body>
</html>