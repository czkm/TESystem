
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程</title>
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
					<th>班级</th>	
					<th>教师</th>	
					<th>课程</th>
					<th>学期</th>
					<th>学年</th>
					<th>上课时间</th>
					<th>星期几</th>
					<th>部门</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="12">
						
						<div class="layui-inline">
							<input type="text" name="classid" value="${ClassCourse.classid }" placeholder="班级"
								class="layui-input">

						</div>
						<!-- <div class="layui-inline">
							<input type="text" name="teacherName" placeholder="教师"
								class="layui-input">
						</div>
						<div class="layui-inline">
							<input type="text" name="teacherName" placeholder="课程"
								class="layui-input">
						</div>
						<div class="layui-inline">
							<input type="text" name="teacherName" placeholder="学期"
								class="layui-input">
						</div>
						<div class="layui-inline">
							<input type="text" name="teacherName" placeholder="学年"
								class="layui-input">
						</div>
						<div class="layui-inline">
							<input type="text" name="teacherName" placeholder="上课时间"
								class="layui-input">
						</div>
						<div class="layui-inline">
							<input type="text" name="teacherName" placeholder="星期几"
								class="layui-input">
						</div>
						<div class="layui-inline">
							<input type="text" name="teacherName" placeholder="状态"
								class="layui-input">
						</div> -->
						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						</div>
					<!--  
						<div class="layui-inline" style="float: right">
							<input type="submit" value="导入教师数据"
								class="layui-btn layui-btn-primary">
						</div>
						<div class="layui-inline" style="float: right">
							<input type="submit" value="导出教师数据"
								class="layui-btn layui-btn-primary">
						</div>
						-->
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/classcourse/toeditclasscourse.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div>

					</td>
				</tr>
				<c:forEach items="${classCourseList }" var="classcou">
				<tr>
					<td>${classcou.classname}</td>
					<td>${classcou.teachername}</td>
					<td>${classcou.coursename}</td>
					<td>${classcou.semester}</td>
					<td>${classcou.semesteryear}</td>
					<td><fmt:formatDate value="${classcou.starttime}" pattern="HH:mm"/></td>
					<td>${classcou.weekday}</td>
					<td>${classcou.departname}</td>
					<td>${classcou.status}</td>
					<td>
						<div class="layui-btn-group">
							<a href="${contextpath}/classcourse/toeditclasscourse.do?id=${classcou.id}"
								class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
								class="layui-icon">&#xe642;</i>
							</a> <a href="${contextpath}/classcourse/deleteclasscourse.do?id=${classcou.id}"
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