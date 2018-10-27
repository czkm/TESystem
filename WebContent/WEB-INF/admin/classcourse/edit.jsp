<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加课程</title>
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="${contextpath }/classcourse/edit"  method="post">
<input type="hidden" name="id" value="${classCourse.id>0?classCourse.id:0}">

  <div class="layui-form-item">
    <label class="layui-form-label">班级编号</label>
    <div class="layui-input-block">
      <input type="text" name="classid" value="${classCourse.classid }" required  lay-verify="required" placeholder="班级编号" autocomplete="off" class="layui-input" id="criteriaName">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">教师编号</label>
    <div class="layui-input-block">
      <input type="text" name="teacherid" value="${classCourse.teacherid }" required  lay-verify="required" placeholder="教师编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">课程编号</label>
    <div class="layui-input-block">
      <input type="text" name="courseid" value="${classCourse.courseid }" required  lay-verify="required" placeholder="课程编号" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">学期</label>
    <div class="layui-input-block">
      <input type="text" name="semester" value="${classCourse.semester }" required  lay-verify="required" placeholder="学期" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">学年</label>
    <div class="layui-input-block">
      <input type="text" name="semesteryear" value="${classCourse.semesteryear }" required  lay-verify="required" placeholder="学年" autocomplete="off" class="layui-input">
    </div>
  </div>
 <div class="layui-form-item">
    <label class="layui-form-label">上课时间</label>
    <div class="layui-input-block">
      <input type="text" name="starttime" value="${classCourse.starttime }" required  lay-verify="required" placeholder="上课时间" autocomplete="off" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">下课时间</label>
    <div class="layui-input-block">
      <input type="text" name="endtime" value="${classCourse.endtime }" required  lay-verify="required" placeholder="上课时间" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">星期几</label>
    <div class="layui-input-block">
      <input type="text" name="weekday" value="${classCourse.weekday }" required  lay-verify="required" placeholder="星期几" autocomplete="off" class="layui-input">
    </div>
  </div>
    <div class="layui-form-item">
    <label class="layui-form-label">部门编号</label>
    <div class="layui-input-block">
      <input type="text" name="departmentId" value="${classCourse.departmentId }" required  lay-verify="required" placeholder="部门编号" autocomplete="off" class="layui-input">
    </div>
  </div>
   
   <div class="layui-form-item">
   <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <select name="status" lay-verify="required">   
       <c:choose>
      <c:when test="${classCourse.status==1 }">
          <option value="1" selected>启用</option>
       <option value="0">未启用</option>
      
      </c:when>
       <c:when test="${classCourse.status==0 }">
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
	    	url:"${contextpath}/criteriaclasses/checkcriterianame",
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
	    			layer.closeAll('loading'); //关闭loading
	    			return false;
	    			
	    		}
	    		if(res.statusCode==1){
	    			layer.closeAll('loading'); //关闭loading
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