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
<form class="layui-form" action="${contextpath}/supervisor/edit.do" method="post">
<input type="hidden" name="id" value="${supervisor.id }">
<input type="hidden" name="password" value="${supervisor.password }">
<input type="hidden" name="type" value="${supervisor.type==null ? 3 : supervisor.type}"> 
<div class="layui-form-item">
    <label class="layui-form-label">选择部门</label>
    <div class="layui-input-block">
      <select name="departid" lay-verify="required">
        <option value="0">选择部门</option>
        <c:forEach items="${departList }" var="depart">
        <c:choose>
        <c:when test="${supervisor.departid==depart.id }">
        <option value="${depart.id }" selected>${depart.departName}</option>
        </c:when>
        <c:otherwise>
        <option value="${depart.id }">${depart.departName}</option>
        </c:otherwise>
        </c:choose>
          
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">督导名称</label>
    <div class="layui-input-block">
      <input type="text" name="username" value="${supervisor.username}" required  lay-verify="required" placeholder="督导名称" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">工号</label>
    <div class="layui-input-block">
      <input type="text" name="userno" value="${supervisor.userno }" required  lay-verify="required" placeholder="工号" autocomplete="off" class="layui-input" id="userno">
    </div>
  </div>
  
  
  <div class="layui-form-item">
    <label class="layui-form-label">职称</label>
    <div class="layui-input-block">
      <input type="text" name="ranks"  value="${supervisor.ranks }" required  lay-verify="required" placeholder="职称" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">专业</label>
    <div class="layui-input-block">
      <input type="text" name="major"  value="${supervisor.major }" required  lay-verify="required" placeholder="专业" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="status" lay-verify="required">
       <c:choose>
       <c:when test="${supervisor.status==1 }">
       <option value="1" selected>启用</option>
       <option value="0">未启用</option>
       </c:when>
       <c:otherwise>
        <option value="1" >启用</option>
       <option value="0" selected>未启用</option>
       </c:otherwise>
       </c:choose>
        
        
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
  
  
	$("#userno").change(function() {
        var userno=$(this).val();
        var json={
     		   
     		   "userno":userno
        }
        
        $.ajax({
	    	method:"POST",
	    	url:"${contextpath}/user/checkuserno",
	    	dataType:"application/json,charset=utf-8",
	    	data:json,
	    	dataType:"json",
	    	beforeSend:function(){
	    		layer.load(); //上传loading
	    	},
	    	success:function(res){
	    		if(res.statusCode==0){    			
	    			layer.msg(res.message,{icon:2}); 
	    			$("#userno").focus();
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
		});
	
  
  //监听提交

  form.on('submit(formDemo)', function(data){
	  var departid=data.field.departid;
	  if(departid=="0"){
		  layer.msg("数据提交前,请先选择部门！！！",{icon:2});
		  return false;  
	  }
   
   
  });
});
</script>
</body>
</html>