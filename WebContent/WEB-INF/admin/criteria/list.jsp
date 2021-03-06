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
	<form class="layui-form" action="${contextpath }/criteria/index.do"
		method="post">
		<table class="layui-table">
			<colgroup>
				<col >
				<col>
				<col width="150">
				<col width="200">
			</colgroup>
			<thead>
				<tr>
					<th>标准</th>
					<th>权重</th>					
					<th>状态</th>
					<th>父节点</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="10">
						<div class="layui-inline">
							<select name="parentId" lay-verify="required">
								<c:forEach items="${criteriaVos }" var="criteriaVo">
									<c:choose>
										<c:when test="${criteriaVo.id==criteria.parentId }">

											<option value="${ criteriaVo.id}" selected>${criteriaVo.criteriaName }</option>
										</c:when>
										<c:otherwise>
											<option value="${criteriaVo.id}">${criteriaVo.criteriaName }</option>
										</c:otherwise>

									</c:choose>
								</c:forEach>

							</select>
						</div>
						<!-- <div class="layui-inline">

							<input type="text" name="criteriaName" placeholder="标准"
								class="layui-input">
						</div> -->

						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						</div>

						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/criteria/toedit.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>



					</td>
				</tr>
				<c:forEach items="${criteriaList }" var="criteria">
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
						
						<td>
						<c:if test="${criteria.parentId==0 }">		
					根节点
					</c:if>
					</td>
						<td>
							<div class="layui-btn-group">

								<a href="${contextpath}/criteria/toedit.do?id=${criteria.id}&level=${criteria.level}&status=${criteria.status}"
									class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
									class="layui-icon">&#xe642;</i>
								</a> <a
									href="${contextpath}/criteria/toedit.do?parentId=${criteria.id}&level=${criteria.level+1}&status=${criteria.status}"
									class="layui-btn layui-btn-sm" alt="添加子菜单" title="添加子菜单"> <i
									class="layui-icon">&#xe654;</i>
								</a> <a href="${contextpath}/criteria/delete.do?id=${criteria.id}"
									class="layui-btn layui-btn-sm" alt="删除" title="删除"
									onclick="return confirm('是否要删除数据')"> <i class="layui-icon">&#xe640;</i>
								</a>

							</div>
						</td>
					</tr>
					<c:forEach items="${criteria.children}" var="sub">			
						<td>${sub.criteriaName}</td>
						<td>${sub.weight}</td>
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
						</select></td>
						
						<td>
								<c:if test="${criteria.id==sub.parentId}">
					            ${criteria.criteriaName}
					
					          </c:if>

					
						</td>
						<td>
							<div class="layui-btn-group">

								<a href="${contextpath}/criteria/toedit.do?id=${sub.id}&level=${sub.level}&status=${sub.status}"
									class="layui-btn layui-btn-warm layui-btn-sm" alt="编辑" title="编辑"> <i
									class="layui-icon">&#xe642;</i>
									
								</a> 
								
								
								<a href="${contextpath}/criteria/delete.do?id=${sub.id}"
									class="layui-btn layui-btn-warm layui-btn-sm" alt="删除" title="删除"
									onclick="return confirm('是否要删除数据')"> <i class="layui-icon">&#xe640;</i>
								</a>

							</div>
						</td>
						</tr>
					</c:forEach>
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