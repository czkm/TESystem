<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>督导管理</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${ contextpath}/supervisor/index.do"
		method="post">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col >
				<col>
				<col>
				<col width="200">
				<col width="200">
				<col width="200">
			</colgroup>

			<thead>
				<tr>
					<th>督导名称</th>
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
					<td colspan="7">
					<div class="layui-inline">
					<select name="departid"
						lay-verify="required">
							<option value="0">选择部门</option>
							<c:forEach items="${departList }" var="depart">
								<c:choose>
									<c:when test="${user.departid==depart.id }">
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
						
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/supervisor/toedit.do" class="layui-btn">
								<i class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div></td>
				</tr>
				<c:forEach items="${supervisorList }" var="supervisor">
					<tr>
						<td>${supervisor.username}</td>
						<td>${supervisor.userno}</td>
						<td>${supervisor.major}</td>
						<td>${supervisor.ranks}</td>
						<td>
						<select id="status">
						<c:choose>
						<c:when test="${supervisor.status==1}">
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
						<select  id="${supervisor.id }" lay-filter='department'>
						<c:forEach items="${departList }" var="depart">
						<c:choose>
						<c:when test="${depart.id== supervisor.departid}">
						
						<option value="${depart.id}" selected>${depart.departName}</option>
						</c:when>
						<c:otherwise>
						<option value="${depart.id}" >${depart.departName}</option>
						
						</c:otherwise>
						</c:choose>
						
						</c:forEach>
						
						</select>
						
						
						</td>
						<td>
							<div class="layui-btn-group">

								<a
									href="${contextpath}/supervisor/toedit.do?id=${ supervisor.id}"
									class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
									class="layui-icon">&#xe642;</i>
								</a> <a
									href="${contextpath}/supervisor/delete.do?id=${ supervisor.id}"
									class="layui-btn layui-btn-sm" alt="删除" title="删除"
									onclick="return confirm('是否要删除数据')"> <i class="layui-icon">&#xe640;</i>
								</a>
								 <a href="javascript:;"
									class="layui-btn layui-btn-sm" alt="重置密码" title="重置密码"
									onclick="resetpassword(${supervisor.id},'${supervisor.userno}')"> <i class="layui-icon">&#xe6b1;</i>

							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<tr>
				<td colspan="7"><a>一共${page.pages}页</a> <a
					href="${contextpath}/supervisor/index.do?page=${page.firstPage}">第一页</a>
					<a href="${contextpath}/supervisor/index.do?page=${page.nextPage}">下一页</a>
					<a href="${contextpath}/supervisor/index.do?page=${page.prePage}">上一页</a>
					<a href="${contextpath}/supervisor/index.do?page=${page.lastPage}">最后页</a>
				</td>
			</tr>
		</table>
	</form>
	<script type="text/javascript"
		src="${contextpath}/js/jquery-3.2.1.min.js"></script>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script>
	layui.use('form', function(){
		  var form = layui.form;
		  
		  
		  
		  form.on('select(department)', function(data){
		 	  
			  var teacherId=data.elem.id;
			  var departId=data.elem.value;
			  $.ajax({
				  method:"POST",
				  data:{  
					  teacherId:teacherId,
					  departId:departId
				  },
				  url:"${contextpath }/teacher/changedepart.do",
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
		  
		  //监听提交
		  /*
		  form.on('submit(formDemo)', function(data){
		    layer.msg(JSON.stringify(data.field));
		    return false;
		  });*/
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