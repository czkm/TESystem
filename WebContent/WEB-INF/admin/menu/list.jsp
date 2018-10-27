<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单信息管理</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${contextpath }/menu/edit.do" method="post">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="200">
				<col>
				<col>
				<col width="150">
				<col width="150">
				<col width="100">
				<col width="200">
			</colgroup>

			<thead>
				<tr>
					<th>模块名称</th>
					<th>模块</th>
					<th>Controller</th>		
					<th>Action</th>
					<th>是否可见</th>
					<th>排序</th>
					<th>图标</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="8">
						<div class="layui-inline">
							<input type="text" name="title" placeholder="模块名称"
								class="layui-input" value="${systemModule.title }">
						</div>
						<div class="layui-inline">
							<input type="text" name="module" placeholder="模块"
								class="layui-input" value="${systemModule.module }">

						</div>
						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						</div>
					
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/menu/toedit.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div>

					</td>
				</tr>
				<c:forEach items="${menuList }" var="menu">
				<tr>
					<td>${menu.title}</td>
					<td>${menu.module}</td>
					<td>${menu.controller}</td>
					<td>${menu.action}</td>
					<td>
					<select id="visible">
					<c:choose>
					<c:when test="${menu.visible==1 }">
					<option value="1" selected>可视</option>
					<option value="0">隐藏</option>
					</c:when>
					<c:otherwise>
					<option value="1" >可视</option>
					<option value="0" selected>隐藏</option>
					</c:otherwise>
					</c:choose>
					</select>
					
					</td>
					<td><input type="text" value="${menu.orderby}" class="layui-input"></td>
					<td>${menu.icon}</td>
					<td>
						<div class="layui-btn-group">

							<a href="${contextpath}/menu/toedit.do?id=${menu.modId}"
								class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
								class="layui-icon">&#xe642;</i>
							</a>
							<a href="${contextpath}/menu/toedit.do?parentId=${menu.modId}"
								class="layui-btn layui-btn-sm" alt="添加子菜单" title="添加子菜单"> <i
								class="layui-icon">&#xe654;</i>
							</a>
							 <a href="${contextpath}/menu/delete.do?id=${menu.modId}"
								class="layui-btn layui-btn-sm" alt="删除" title="删除"
								onclick="return confirm('是否要删除数据')"> <i class="layui-icon">&#xe640;</i>
							</a>

						</div>
					</td>
				</tr>
				<c:forEach items="${ menu.children}" var="sub">
				
				    <td>----${sub.title}</td>
					<td>----${sub.module}</td>
					<td>${sub.controller}</td>
					<td>${sub.action}</td>
					<td>
					<select id="subvisible">
					<c:choose>
					<c:when test="${menu.visible==1 }">
					<option value="1" selected>可视</option>
					<option value="0">隐藏</option>
					</c:when>
					<c:otherwise>
					<option value="1" >可视</option>
					<option value="0" selected>隐藏</option>
					</c:otherwise>
					</c:choose>
					</select>
                    </td>
					<td><input type="text" value="${sub.orderby}" class="layui-input"></td>
					<td>${sub.icon}</td>
					<td>
						<div class="layui-btn-group">

							<a href="${contextpath}/menu/toedit.do?id=${sub.modId}"
								class="layui-btn layui-btn-warm layui-btn-sm" alt="编辑" title="编辑"> <i
								class="layui-icon">&#xe642;</i>
							</a> <a href="${contextpath}/menu/delete.do?id=${sub.modId}"
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
layui.use('form', function(){
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