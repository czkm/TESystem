<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑菜单信息</title>
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="${contextpath }/menu/edit"  method="post">
<input type="hidden" name="id" value="${module.modId }">

<div class="layui-form-item">
    <label class="layui-form-label">父编号</label>
    <div class="layui-input-block">
      <select name="parentId" lay-verify="required">
      
         <c:choose>
            <c:when test="${0==module.modId}">
              <option value="0" selected>根节点</option>
            </c:when>
            <c:otherwise>
            <option value="0" >根节点</option>
            </c:otherwise>
        </c:choose>
        <c:forEach items="${menuList }" var="menu">
          <c:choose>
            <c:when test="${menu.modId==module.parentId}">
              <option value="${menu.modId }" selected>&nbsp;&nbsp;&nbsp;&nbsp;${menu.title }</option>
            </c:when>
            <c:otherwise>
            <option value="${menu.modId }" >&nbsp;&nbsp;&nbsp;&nbsp;${menu.title }</option>
            </c:otherwise>
         </c:choose>
        
        <c:forEach items="${menu.children }" var="child"> 
         <c:choose>
            <c:when test="${child.modId==module.parentId}">
              <option value="${child.modId }" selected>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${child.title }</option>
            </c:when>
            <c:otherwise>
            <option value="${child.modId }" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${child.title }</option>
            </c:otherwise>
         </c:choose>
        </c:forEach>
        </c:forEach>
      </select>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">模块名称</label>
    <div class="layui-input-block">
      <input type="text" name="title" value="${module.title }" required  lay-verify="required" placeholder="模块名称" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">模块</label>
    <div class="layui-input-block">
      <input type="text" name="module" value="${module.module }"  required  lay-verify="required" placeholder="模块" autocomplete="off" class="layui-input">
    </div>
  </div>
 
   <div class="layui-form-item">
    <label class="layui-form-label">Controller</label>
    <div class="layui-input-block">
      <input type="text" name="controller"  value="${module.controller }"  placeholder="Controller" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">Action</label>
    <div class="layui-input-block">
      <input type="text" name="action" value="${module.action }"  placeholder="action" autocomplete="off" class="layui-input">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">排序</label>
    <div class="layui-input-block">
      <input type="text" name="orderby" value="${module.orderby }"  required  lay-verify="required" placeholder="排序" autocomplete="off" class="layui-input">
    </div>
  </div>
    <div class="layui-form-item">
    <label class="layui-form-label">菜单等级</label>
    <div class="layui-input-block">
      <select name="level" lay-verify="required"> 
       <option value="1" selected>一级菜单</option>
       <option value="2">二级菜单</option>
  
      </select>
    </div>
  </div>
   <div class="layui-form-item">
   <label class="layui-form-label">是否可视</label>
    <div class="layui-input-block">
      <select name="visible" lay-verify="required">    
        <option value="1">可视</option>
       <option value="0">隐藏</option>
      </select>
    </div>
    </div>
  </div>
   <div class="layui-form-item">
   <label class="layui-form-label">图标</label>
    <div class="layui-input-block">
    <input type="text" name="icon" class="layui-input">
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
 <script src="${contextpath}/js/plugins/layui/layui.js"></script>
<script>
//Demo
layui.use('form', function(){
  var form = layui.form;
  
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