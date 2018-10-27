<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${contextpath }/depart/index.do" method="post">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col >
				<col >
				<col width="150">
			</colgroup>

			<thead>
				<tr>
					<th>部门编号</th>
					<th>部门名称</th>
<th>类型</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="4">

						<div class="layui-inline">
							<input type="text" name="departName" placeholder="部门名称"
								class="layui-input"  value="${department.departName}">
						</div>
						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						</div>
						
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/depart/toedit.do" class="layui-btn"> <i
								class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div>

					</td>
				</tr>
				<c:forEach items="${list}" var="depart">
				<tr>
					<td>${depart.id }</td>
					<td>${depart.departName}</td>
					<td>${depart.type}</td>
					<td>
						<div class="layui-btn-group">

							<a href="${contextpath}/depart/toedit.do?id=${depart.id }"
								class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
								class="layui-icon">&#xe642;</i>
							</a> <a href="${contextpath}/depart/delete.do?id=${depart.id }"
								class="layui-btn layui-btn-sm" alt="删除" title="删除" onclick="return confirm('是否要删除数据')"> <i
								class="layui-icon">&#xe640;</i>
							</a>

						</div>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
</body>
</html>