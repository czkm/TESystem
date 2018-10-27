<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程管理</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${contextpath }/course/index.do" method="post">
		<table class="layui-table">
			<colgroup>
				<col width="200">
				<col width="200">				
				<col>
				<col>
				<col>
				<col width="150">
			</colgroup>

			<thead>
				<tr>
					<th>课程代码</th>
					<th>课程名称</th>
					<th>学分</th>					
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="8">
						<div class="layui-inline">
							<select name="coursecode" lay-verify="required">
								<option value="0">课程代码</option>
								<c:forEach items="${allCourse }" var="course">
									<c:choose>
										<c:when test="">
											<option value="${course.coursecode }" selected>${course.coursecode}</option>
										</c:when>
										<c:otherwise>
											<option value="${course.coursecode }">${course.coursecode}</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</select>
						</div>
						<!-- <div class="layui-inline">
							<input type="text" name="coursecode" placeholder="课程代码"
								class="layui-input">
						</div> -->
						<div class="layui-inline">
							<input type="text" name="coursename" placeholder="课程名称"
								class="layui-input">
						</div>
						<%-- <div class="layui-inline">
							<select name="departmentId" lay-verify="required">
								<option value="0">选择课程</option>
								<c:forEach items="${allCourse }" var="course">
									<c:choose>
										<c:when test="">
											<option value="${course.id }" selected>${course.coursename}</option>
										</c:when>
										<c:otherwise>
											<option value="${course.id }">${course.coursename}</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</select>
						</div> --%>
						<div class="layui-inline">
							<select name="score" lay-verify="required">
								<option value="0">课程学分</option>
								<c:forEach items="${allCourse }" var="course">
									<c:choose>
										<c:when test="1==1">
											<option value="${course.score }" selected>${course.score}</option>
										</c:when>
										<c:otherwise>
											<option value="${course.score }">${course.score}</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</select>
							
						</div>
						<%-- <div class="layui-inline">
							<select name="departmentId" lay-verify="required">
								<option value="0">课程状态</option>
								<c:forEach items="${allCourse }" var="course">
									<c:choose>
										<c:when test="${supervisor.departmentId==depart.id }">
											<option value="${course.id }" selected>${course.status}</option>
										</c:when>
										<c:otherwise>
											<option value="${course.id }">${course.status}</option>
										</c:otherwise>
									</c:choose>

								</c:forEach>
							</select>
						</div> --%>
						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						 </div>
						 <div class="layui-inline" alt="返回" title="返回">
							<a href="${contextpath}/course/index.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 返回
							</a>
						</div>
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/course/add" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div>

					</td>
				</tr>
				<c:forEach items="${allCourse }" var="course">
				<tr>
					<td>${course.coursecode}</td>
					<td>${course.coursename}</td>
					<td>${course.score}</td>					
					<td>
					    <!-- 监控select 的选定的值 -->
						<select id="${course.id}" lay-filter='status'>
						<c:choose>
						<c:when test="${course.status==1}">
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

							<a href="${contextpath}/course/toedit?id=${course.id}"
								class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
								class="layui-icon">&#xe642;</i>
							</a> <a href="${contextpath}/course/delete.do?id=${course.id}"
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
layui.use(['form','jquery'], function(){
	var form=layui.form,$=layui.$ 
    form.on('select(status)', function(data){
 	  
	  var courseid=data.elem.id;
	  var status=data.elem.value;
	  alert(courseid);
	  alert(status);
	  $.ajax({
		  method:"POST",
		  data:{  
			  id:courseid,
			  status:status
		  },
		  url:"${contextpath }/course/changestatus.do",
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
	 
	  
	  
	});
});
</script>
</body>
</html>