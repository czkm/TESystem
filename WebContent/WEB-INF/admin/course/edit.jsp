<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程名称</title>
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="${contextpath }/course/toedit.do"  method="post">
<input type="hidden" name="id" value="${course.id }">
<%-- <input type="hidden" name="type" value="${teacher.type==null ? 2 : teacher.type}">  --%>
<!-- <div class="layui-form-item"> -->
<!--     <label class="layui-form-label">选择部门</label> -->
<!--     <div class="layui-input-block"> -->
<!--       <select name="departid" lay-verify="required"> -->
<%--         <c:forEach items="${departList }" var="depart"> --%>
<%--         <option value="${depart.id }">${depart.departName }</option> --%>
<%--         </c:forEach> --%>
<!--       </select> -->
<!--     </div> -->
<!--   </div> -->
  <div class="layui-form-item">
    <label class="layui-form-label">课程代码</label>
    <div class="layui-input-block">
      <input type="text" name="coursecode" value="${course.coursecode }" required  lay-verify="required" placeholder="课程代码" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">课程名称</label>
    <div class="layui-input-block">
      <input type="text" name="coursename" value="${course.coursename }"  required  lay-verify="required" placeholder="课程名称" autocomplete="off" class="layui-input" id="userno">
    </div>
  </div>
 
   <div class="layui-form-item">
    <label class="layui-form-label">学分</label>
    <div class="layui-input-block">
      <input type="text" name="score"  value="${course.score }"  required  lay-verify="required" placeholder="学分" autocomplete="off" class="layui-input">
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
      <button class="layui-btn" type="submit" lay-filter="formDemo">提交</button>
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