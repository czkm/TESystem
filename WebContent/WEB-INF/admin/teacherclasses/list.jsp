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
	<form class="layui-form" action="" method="post">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="200">
				<col>
				<col>
				<col>
				<col>
				<col width="150">
			</colgroup>

			<thead>
				<tr>
					<th>名称</th>
					<th>工号</th>
					<th>专业</th>		
					<th>职称</th>
					<th>状态</th>
					<th>部门</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="8">
						<div class="layui-inline">
							<select name="departmentId" lay-verify="required">
								<option value="0">选择部门</option>
								<c:forEach items="${departList }" var="depart">
									<c:choose>
										<c:when test="${supervisor.departmentId==depart.id }">
											<option value="${depart.id }" selected>${depart.departName}</option>
										</c:when>
										<c:otherwise>
											<option value="${depart.id }">${depart.departName}</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</select>
						</div>
						<div class="layui-inline">
							<input type="text" name="teacherNo" placeholder="工号"
								class="layui-input">

						</div>
						<div class="layui-inline">
							<input type="text" name="teacherName" placeholder="名称"
								class="layui-input">
						</div>
						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						</div>
						<div class="layui-inline" style="float: right">
							<input type="submit" value="导入教师数据"
								class="layui-btn layui-btn-primary">
						</div>
						<div class="layui-inline" style="float: right">
							<input type="submit" value="导出教师数据"
								class="layui-btn layui-btn-primary">
						</div>
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/teacher/toedit.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div>

					</td>
				</tr>
				<c:forEach items="${teacherList }" var="teacher">
				<tr>
					<td>${teacher.teacherName}</td>
					<td>${teacher.teacherNo}</td>
					<td>${teacher.major}</td>
					<td>${teacher.ranks}</td>
					<td>${teacher.status}</td>
					<td>${teacher.departmentId}</td>
					<td>
						<div class="layui-btn-group">

							<a href="${contextpath}/teacher/toedit.do?id=${teacher.id}"
								class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
								class="layui-icon">&#xe642;</i>
							</a> <a href="${contextpath}/teacher/delete.do?id=${teacher.id}"
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