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
	<form class="layui-form" action="${contextpath}/student/index.do"
		method="post">
		<table class="layui-table">
			<colgroup>
				<col width="200">
				<col>
				<col  width="300" >
				<col width="150">
				<col width="200">
			</colgroup>

			<thead>
				<tr>
					<th>学生名称</th>
					<th>学号</th>
					<th>班级</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="5">
						
						<div class="layui-inline">
							<select lay-ignore style="height: 35px;" name="classesid">
								<c:forEach items="${departmentAndClassesVos }" var="vo">					            
								<optgroup label="${vo.departName }">								
								<c:forEach items="${vo.classeses }" var="voo">													
									<option value="${voo.id }">---->${voo.classesName }</option>
								</c:forEach>
								</optgroup>
								</c:forEach>
						</select>
						
						</div>
						<div class="layui-inline">
							<input type="text" name="userno" placeholder="学号"
								class="layui-input" value="${user.userno }">
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
							<button type="button" class="layui-btn" id="importExcel">
								<i class="layui-icon">&#xe67c;</i>导入学生数据
							</button>
						</div>
						<div class="layui-inline" style="float: right">
							<a href="${contextpath }/file/exportStudentExcel"
								class="layui-btn layui-btn-primary">导出学生数据</a>
						</div>
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/student/toedit.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div>

					</td>
				</tr>
			
				<c:forEach items="${studentList }" var="student">
					<tr>
						<td>${student.username }</td>
						<td>${student.userno }</td>

						<td>
						
						<select lay-ignore style="height: 35px;">
								<c:forEach items="${departmentAndClassesVos }" var="vo">
					            
								<optgroup label="${vo.departName }">
								
								<c:forEach items="${vo.classeses }" var="voo">
								<c:choose>
								<c:when test="${voo.id==student.classesid }">
									<option value="${voo.id }" selected>---->${voo.classesName }</option>
								</c:when>
								<c:otherwise>
									<option value="${voo.id }">---->${voo.classesName }</option>
								
								</c:otherwise>
							
								</c:choose>
							
								</c:forEach>
								</optgroup>
								</c:forEach>
						</select>
						</td>
						<td>
						<select id="status">
						<c:choose>
						<c:when test="${student.status==1}">
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
							<div class="layui-btn-group">

								<a href="${contextpath}/student/toedit.do?id=${student.id}"
									class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
									class="layui-icon">&#xe642;</i>
								</a> <a href="${contextpath}/student/delete.do?id=${student.id}"
									class="layui-btn layui-btn-sm" alt="删除" title="删除"
									onclick="return confirm('是否要删除数据')"> <i class="layui-icon">&#xe640;</i>
								</a>
                                  <a href="javascript:;"
									class="layui-btn layui-btn-sm" alt="重置密码" title="重置密码"
									onclick="resetpassword(${student.id},'${student.userno}')"> <i class="layui-icon">&#xe6b1;</i>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tr>
				<td colspan="5"><a>一共${page.pages}页</a> <a
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
	<script type="text/javascript">
		layui.use('form', function() {
			var form = layui.form;

			form.on('select(departList)', function(data1) {
				var departId = data1.value;

				$.ajax({
					type : 'POST',
					url : '${contextpath}/student/queryClasses',
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

		});

		layui.use('upload', function() {
			var upload = layui.upload;

			//执行实例
			var uploadInst = upload.render({
				elem : '#importExcel' //绑定元素
				,
				url : "${contextpath }/file/student/ajaxImportExcel" //上传接口
				,
				before : function(obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
					layer.load(); //上传loading
				},
				done : function(res) {
					if (res.statusCode == 1) {
						layer.msg(res.message,{icon:1}, function(){
		    				
		    				window.location.reload();
		    			
		    				}); 
					}
					if (res.statusCode == 2) {
						 layer.msg(res.message,{icon:2}); 
						 layer.closeAll("loading");
					}
				},
				accept : "file",
				error : function() {
					//请求异常回调
					layer.msg(res.message,{icon:2}); 
					layer.closeAll("loading");
				}
			});
		});
		function resetpassword(id,userno){
			 var json={
						"id":id,
					    "userno":userno
				        } 
				    $.ajax({
				    	method:"POST",
				    	url:"${contextpath}/user/resetpassword",
				    	dataType:"application/json,charset=utf-8",
				    	data:json,
				    	dataType:"json",
				    	beforeSend:function(){
				    		layer.load(); //上传loading
				    	},
				    	success:function(res){
				    		
				    		if(res.statusCode==1){    			
				    			layer.msg(res.message,{icon:1}); 
				    			layer.closeAll('loading'); //关闭loading
				    		}
				    		if(res.statusCode==0){
				    			
				    			layer.msg(res.message,{icon:2}); 
				    			layer.closeAll('loading'); //关闭loading
				    		}
				    		
			               
				    	},
				    	complete:function(){
				    		
				    		
				    		   layer.closeAll('loading'); //关闭loading
				    	}
				    	
				    	
				    });
				    return false;
				  
			
			
		}
	</script>
</body>
</html>