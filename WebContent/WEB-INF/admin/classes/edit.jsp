<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑学生信息</title>
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="${contextpath }/classes/edit.do" method="post">
<input type="hidden" name="id" value="${classes.id }">
  <div class="layui-form-item">
    <label class="layui-form-label">班级名称</label>
    <div class="layui-input-block">
      <input type="text" name="classesName" value="${classes.classesName }" required  lay-verify="required" placeholder="班级名称" autocomplete="off" class="layui-input" id="classesName">
    </div>
  </div>
 
  <div class="layui-form-item">
    <label class="layui-form-label">是否启用</label>
    <div class="layui-input-block">
      <select name="status" lay-verify="required">
        <option value="1">启用</option>
        <option value="0">不启用</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">选择部门</label>
    <div class="layui-input-block">
      <select name="departId" lay-verify="required">
      <c:forEach items="${departList }" var="depart">
      <c:choose>
      <c:when test="${depart.id==classes.departId}">
       <option value="${depart.id}" selected>${depart.departName}</option>
      </c:when>
     <c:otherwise>
      <option value="${depart.id}">${depart.departName}</option>
     
     </c:otherwise>
      </c:choose>
      
       
       </c:forEach>
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
<script type="text/javascript"
		src="${contextpath}/js/jquery-3.2.1.min.js"></script>
 <script src="${contextpath}/js/plugins/layui/layui.js"></script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  $("#classesName").change(function() {
      var classesName=$(this).val();
      var json={
   		   
   		   "classesName":classesName
      }
      
      $.ajax({
	    	method:"POST",
	    	url:"${contextpath}/classes/checkclassesname",
	    	dataType:"application/json,charset=utf-8",
	    	data:json,
	    	dataType:"json",
	    	beforeSend:function(){
	    		layer.load(); //上传loading
	    	},
	    	success:function(res){
	    		if(res.statusCode==0){    			
	    			layer.msg(res.message,{icon:2}); 
	    			$("#classesName").focus();
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