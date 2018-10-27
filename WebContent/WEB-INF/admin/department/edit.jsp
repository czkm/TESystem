<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑部门信息</title>
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="${contextpath}/depart/edit.do"  method="post">
<input type="hidden" name="id" value="${department.id }">
  <div class="layui-form-item">
    <label class="layui-form-label">部门名称</label>
    <div class="layui-input-block">
      <input type="text" name="departName" value="${department.departName }" required  lay-verify="required" placeholder="部门名称" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">类型</label>
    <div class="layui-input-block">
      <select name="type" lay-verify="required">
        <option value="学院">学院</option>
        <option value="处室">处室</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
 <script src="${contextpath}/js/plugins/layui/layui.js"></script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  $("#criteriaName").change(function() {
      var criteriaName=$(this).val();
      var json={
   		   
   		   "criteriaName":criteriaName
      }
      
      $.ajax({
	    	method:"POST",
	    	url:"${contextpath}/criteria/checkcriterianame",
	    	dataType:"application/json,charset=utf-8",
	    	data:json,
	    	dataType:"json",
	    	beforeSend:function(){
	    		layer.load(); //上传loading
	    	},
	    	success:function(res){
	    		if(res.statusCode==0){    			
	    			layer.msg(res.message,{icon:2}); 
	    			$("#criteriaName").focus();
	    			return false;
	    			
	    		}
	    		if(res.statusCode==1){
	    			
	    			layer.msg(res.message,{icon:1}); 
	    			return true;
	    		}
	    		
             
	    		
	    	},
	    	complete:function(){
	    		
	    		
	    		   layer.closeAll('loading'); //关闭loading
	    	}
	    	
	    	
	    });
	    return false;
		})
  //监听提交
  /*
  form.on('submit(formDemo)', function(data){
    layer.msg(JSON.stringify(data.field));
    return false;
  });
  */
});
</script>
</body>
</html>