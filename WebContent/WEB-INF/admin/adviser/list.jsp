<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师管理</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${contextpath }/adviser/index.do" method="post">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="200">
				<col>
				<col>
				<col width="150">
				<col width="200">
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
							<input type="text" name="userno" placeholder="工号"
								class="layui-input" valur="${user.userno }">

						</div>
						<div class="layui-inline">
							<input type="text" name="username" placeholder="名称"
								class="layui-input" value="${user.username }">
						</div>
						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						</div>
						<div class="layui-inline" style="float: right">
							<button type="button" class="layui-btn" id="importAdviserExcel">
								<i class="layui-icon">&#xe67c;</i>导入班主任数据
							</button>

						</div>
						<div class="layui-inline" style="float: right">
							<a href="${contextpath }/file/exportAdviserExcel"
								class="layui-btn layui-btn-primary">导出班主任数据</a>
						</div>
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/adviser/toedit.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div>

					</td>
				</tr>
				<c:forEach items="${adviserList }" var="adviser">
					<tr>
						<td>${adviser.username}</td>
						<td>${adviser.userno}</td>
						<td>${adviser.major}</td>
						<td>${adviser.ranks}</td>
						<td>
						<select id="status">
						<c:choose>
						<c:when test="${adviser.status==1}">
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
						<select >
				
								<c:forEach items="${departments }" var="depart">
									<c:choose>
										<c:when test="${adviser.departid==depart.id }">
											<option value="${depart.id }" selected>${depart.departName}</option>
										</c:when>
										<c:otherwise>
											<option value="${depart.id }">${depart.departName}</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
			
						
						</td>
						<td>
							<div class="layui-btn-group">

								<a href="${contextpath}/teacher/toedit.do?id=${adviser.id}"
									class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
									class="layui-icon">&#xe642;</i>
								</a> <a href="${contextpath}/adviser/delete.do?id=${teacher.id}"
									class="layui-btn layui-btn-sm" alt="删除" title="删除"
									onclick="return confirm('是否要删除数据')"> <i class="layui-icon">&#xe640;</i>
								</a>

							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tr>
				<td colspan="7"><a>一共${page.pages}页</a> <a
					href="?page=${page.firstPage}">第一页</a>
					<a href="?page=${page.nextPage}">下一页</a>
					<a href="?page=${page.prePage}">上一页</a>
					<a href="?page=${page.lastPage}">最后页</a>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript"
		src="${contextpath}/js/jquery-3.2.1.min.js"></script>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script>
		//Demo
		layui.use('form', function() {
			var form = layui.form;
			
			

		});

	

		layui.use('upload', function() {
				var upload = layui.upload;
				//执行实例
				var uploadInst = upload.render({
					elem : '#importAdviserExcel' //绑定元素
					,
					url : "${contextpath }/file/ajaxImportAdviserExcel" //上传接口
					,
					before : function(obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
						layer.load(); //上传loading
					},
					done : function(res) {
						if (res.statusCode == 1) {
							
							layer.closeAll("loading");
							layer.msg(res.message,{icon:1}, function(){
			    				
			    				window.location.reload();
			    			
			    				}); 
						}
						if (res.statusCode == 2) {				
							layer.closeAll("loading");
                             layer.msg(res.message,{icon:2}); 
							return false;
						}
					},
					accept : "file",
					error : function() {
						//请求异常回调
						alert("导入数据失败")
						layer.closeAll("loading");
					}
				});
				
			}); 
	</script>
</body>
</html>