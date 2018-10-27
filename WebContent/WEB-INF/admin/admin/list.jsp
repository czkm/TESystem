<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
	<form class="layui-form" action="${contextpath}/admin/index.do" method="post">
		<table class="layui-table">
			<colgroup>
				<col width="150">
				<col width="200">
				<col>
				<col>
				<col width="300">
				<col width="150">
				<col width="150">
			</colgroup>

			<thead>
				<tr>
					<th>编号</th>
					<th>真实姓名</th>
					<th>登陆名称</th>
					<th>电话号码</th>
					<th>电子邮箱</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="7">
						<div class="layui-inline">
							<input type="text" name="loginname" placeholder="登录名称"
								class="layui-input">
						</div>
						<div class="layui-inline">
							<input type="submit" value="查询"
								class="layui-btn layui-btn-primary">
						</div>
						
						<div class="layui-inline" style="float: right" alt="添加" title="添加">
							<a href="${contextpath}/admin/toedit.do" class="layui-btn"> <i
								class="layui-icon">&#xe608;</i> 添加
							</a>
						</div>

						</div>

					</td>
				</tr>
				<c:forEach items="${admins }" var="admin">
				<tr>
					<td>${admin.id}</td>
					<td>${admin.adminName }</td>
					<td>${admin.loginname }</td>
					<td>${admin.mobile}</td>
					<td>${admin.email}</td>
					<td>
					<select id="${admin.id}"  lay-filter="status">
					<c:choose>
					<c:when test="${admin.status==1 }">
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

							<a href="${contextpath}/admin/toedit.do?id=${admin.id}"
								class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
								class="layui-icon">&#xe642;</i>
							</a> <a href="${contextpath}/admin/delete.do?id=${admin.id}"
								class="layui-btn layui-btn-sm" alt="删除" title="删除"  onclick="return confirm('数据是否删除')"> <i
								class="layui-icon">&#xe640;</i>
							</a>

						</div>
					</td>
				</tr>
				</c:forEach>
				<tr>
				<td colspan="7">
				
				  <a>一共${page.pages}页</a>
        <a href="${contextpath}/admin/list.do?page=${page.firstPage}">第一页</a>
        <a href="${contextpath}/admin/list.do?page=${page.nextPage}">下一页</a>
        <a href="${contextpath}/admin/list.do?page=${page.prePage}">上一页</a>
        <a href="${contextpath}/admin/list.do?page=${page.lastPage}">最后页</a>
				</td>
				</tr>
			</tbody>
		</table>
	</form>
	<script type="text/javascript"
		src="${contextpath}/js/jquery-3.2.1.min.js"></script>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script type="text/javascript">
	layui.use('form', function(){
		  var form = layui.form;
		 
		  //各种基于事件的操作，下面会有进一步介绍
		  form.on('select(status)', function(data){
			  console.log(data.elem.id,data.value);
			  
			  var json={
           		   
           		   "id":data.elem.id,
           		   "status":data.value
              }
              
              $.ajax({
      	    	method:"POST",
      	    	url:"${contextpath}/admin/cahngestatus",
      	    	dataType:"application/json,charset=utf-8",
      	    	data:json,
      	    	dataType:"json",
      	    	beforeSend:function(){
      	    		layer.load(); //上传loading
      	    	},
      	    	success:function(res){
      	    		if(res.statusCode==0){    			
      	    			layer.msg(res.message,{icon:2}); 
      	    			
      	    			
      	    		}
      	    		if(res.statusCode==1){
      	    			
      	    			layer.msg(res.message,{icon:1}); 
      	    			
      	    		}
      	    		
                     
      	    		
      	    	},
      	    	complete:function(){
      	    		
      	    		
      	    		   layer.closeAll('loading'); //关闭loading
      	    	}
      	    	
      	    	
      	    });
      	    return false;
		  });
		});
	
	</script>
</body>
</html>