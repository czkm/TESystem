<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑标准信息</title>
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="${contextpath }/criteria/edit.do"  method="post">
<input type="hidden" name="id" value="${criteria.id}">
<div class="layui-form-item">
    <label class="layui-form-label">父编号</label>
    <div class="layui-input-block">
      <select name="parentId" lay-verify="required"> 
       <c:choose>
            <c:when test="${0==criteria.parentId}">
              <option value="0" selected>根节点</option>
            </c:when>
            <c:otherwise>
             <option value="0">根节点</option>
            </c:otherwise>
        </c:choose>
      <c:forEach items="${criteriaVos }" var="criteriaVo">
      <c:choose>
         <c:when test="${criteriaVo.id==criteria.parentId }">
      
         <option value="${criteriaVo.id }" selected>${criteriaVo.criteriaName }</option>
      </c:when>
    
     
      <c:otherwise>
      <option value="${criteriaVo.id}">${criteriaVo.criteriaName }</option>
      </c:otherwise>
      
      </c:choose>
       <c:forEach items="${criteriaVo.children }" var="children">
      
        <c:choose>
         <c:when test="${children.id==criteria.parentId }">
      
         <option value="${children.id }" selected>${children.criteriaName }</option>
      </c:when>
    
     
      <c:otherwise>
      <option value="${children.id}">${children.criteriaName }</option>
      </c:otherwise>
      
      </c:choose>
      </c:forEach>
      </c:forEach>
        
       
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">标准</label>
    <div class="layui-input-block">
      <input type="text" name="criteriaName" value="${criteria.criteriaName }" required  lay-verify="required" placeholder="标准" autocomplete="off" class="layui-input" id="criteriaName">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">权重</label>
    <div class="layui-input-block">
      <input type="text" name="weight" value="${criteria.weight }" required  lay-verify="required" placeholder="标准" autocomplete="off" class="layui-input">
    </div>
  </div>
 
    <div class="layui-form-item">
    <label class="layui-form-label"> ${criteria.level}等级</label>
    <div class="layui-input-block">
   
      <select name="level" lay-verify="required"> 
      <c:choose>
      <c:when test="${criteria.level==1 }">
         <option value="1" selected>一级</option>
         <option value="2">二级</option>
      
      </c:when>
       <c:when test="${criteria.level==2}">
         <option value="1" >一级</option>
         <option value="2" selected>二级</option>
          <option value="3" >三级</option>
      </c:when>

       <c:when test="${criteria.level==3}">
         <option value="1" >一级</option>
         <option value="2" >二级</option>
          <option value="3" selected>三级</option>
      </c:when>
      <c:otherwise>
       <option value="1"  selected>一级</option>
       <option value="2" >二级</option>
        <option value="3" >三级</option>
      </c:otherwise>
      </c:choose>
      </select>
    </div>
  </div>
   <div class="layui-form-item">
   <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="status" lay-verify="required">   
       <c:choose>
      <c:when test="${criteria.status==1 }">
          <option value="1" selected>启用</option>
       <option value="2">未启用</option>
      
      </c:when>
       <c:when test="${criteria.status==2 }">
          <option value="1" >启用</option>
       <option value="0" selected>未启用</option>
      
      </c:when>
      <c:otherwise>
       <option value="1" selected>启用</option>
       <option value="0" >未启用</option>
      </c:otherwise>
      </c:choose>
      </select> 
      
      </select>
    </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
</form>
<script src="${contextpath}/js/jquery-3.2.1.min.js"></script>
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