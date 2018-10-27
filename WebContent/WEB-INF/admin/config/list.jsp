<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站设置</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${contextpath }/config/index.do" method="post">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="200">
				<col>
				<col>
				<col>
				<col width="150">
			</colgroup>

			<thead>
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>值</th>
					<th>类型</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="6">

						<div class="layui-inline">
							<input type="text" name="name" placeholder="名称"
								class="layui-input" value="${config.name }">
						</div>
						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						</div>
						
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/config/toedit.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div>

					</td>
				</tr>
				<c:forEach items="${configList }" var="config">
					<tr>
						<td>${config.id}</td>
						<td>${config.name }</td>
						<td>${config.value }</td>
						<td>${ config.incType}</td>
						<td>
						<select id="${config.id}"  lay-filter="status">
					<c:choose>
					<c:when test="${config.status==1 }">
					<option value="1" selected>启用</option>
					<option value="0">未启用</option>
					</c:when>
					
					<c:otherwise>
					<option value="1">启用</option>
					<option value="0" selected>未启用</option>
					</c:otherwise>
					</c:choose>
					</select>
						
						</td>
						<td>
							<div class="layui-btn-group">

								<a href="${contextpath}/config/toedit.do?id=${config.id}"
									class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
									class="layui-icon">&#xe642;</i>
								</a> <a href="${contextpath}/config/delete.do?id=${config.id}"
									class="layui-btn layui-btn-sm" alt="删除" title="删除" onclick="return confirm('是否要删除数据')"> <i
									class="layui-icon">&#xe640;</i>
								</a>

							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tr>
				<td colspan="6"><a>一共${page.pages}页</a> <a
					href="${contextpath}/config/index.do?page=${page.firstPage}">第一页</a>
					<a href="${contextpath}/config/index.do?page=${page.nextPage}">下一页</a>
					<a href="${contextpath}/config/index.do?page=${page.prePage}">上一页</a>
					<a href="${contextpath}/config/index.do?page=${page.lastPage}">最后页</a>
				</td>
			</tr>
		</table>
	</form>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
</body>
</html>