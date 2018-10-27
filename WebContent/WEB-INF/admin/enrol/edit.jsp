<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑招生办人员信息</title>
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="${contextpath }/enrol/edit.do"  method="post">
<input type="hidden" name="id" value="${enrol.id }">
<input type="hidden" name="password" value="${enrol.password }">
<input type="hidden" name="type" value="${enrol.type==null ? 5 : enrol.type}"> 
<div class="layui-form-item">
    <label class="layui-form-label">选择部门</label>
    <div class="layui-input-block">
      <select name="departid" lay-verify="required">
        <c:forEach items="${departList }" var="depart">
        <option value="${depart.id }">${depart.departName }</option>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">名称</label>
    <div class="layui-input-block">
      <input type="text" name="username" value="${enrol.username }" required  lay-verify="required" placeholder="教师名称" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">工号</label>
    <div class="layui-input-block">
      <input type="text" name="userno" value="${enrol.userno }"  required  lay-verify="required" placeholder="工号" autocomplete="off" class="layui-input" id="userno">
    </div>
  </div>
 
   <div class="layui-form-item">
    <label class="layui-form-label">专业</label>
    <div class="layui-input-block">
      <input type="text" name="major"  value="${enrol.major }"  required  lay-verify="required" placeholder="专业" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">职称</label>
    <div class="layui-input-block">
      <input type="text" name="ranks" value="${enrol.ranks }"  required  lay-verify="required" placeholder="职称" autocomplete="off" class="layui-input">
    </div>
  </div>
   <label class="layui-form-label">选择状态</label>
    <div class="layui-input-block">
      <select name="status" lay-verify="required">
        
        <option value="1">启用</option>
       <option value="2">未启用</option>
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
<script type="text/javascript" src="${contextpath}/js/jquery-3.2.1.min.js"></script>
 <script src="${contextpath}/js/plugins/layui/layui.js"></script>
<script>


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