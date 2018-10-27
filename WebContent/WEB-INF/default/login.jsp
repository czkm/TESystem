<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
	
<link rel="stylesheet"
	href="${contextpath}/css/login.css">	
</head>
<body>

	<div class="layui-flow">
	<div class="layui-container layui-header">
	
	</div>
	<div class="layui-container layui-main">
			<div class="layui-col-md4  layui-col-md-offset8 layui-main-login">
				<c:if test="${allErrors!=null }">
					<c:forEach items="${allErrors}" var="error">
   ${error.defaultMessage }
</c:forEach>
				</c:if>
				<form class="layui-form" action="${contextpath}/login"
					method="post">
					<div class="layui-form-item">

						<input type="text" name="loginname" required lay-verify="required"
							placeholder="学号/工号" autocomplete="off" class="layui-input">

					</div>
					<div class="layui-form-item">

						<input type="password" name="password" required
							lay-verify="required" placeholder="请输入登录密码" autocomplete="off"
							class="layui-input">

					</div>
					<div class="layui-form-item">
						<select name="type" >
						<option value="1">学生入口</option>
						<option value="2">教师入口</option>
						<option value="3">督导入口</option>
						</select>

					</div>
					<div class="layui-form-item">
						<input type="submit" value="管理员登录" class="layui-input">
					</div>

				</form>
			</div>

		</div>
	</div>

	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script type="text/javascript">
		layui.use('form', function() {
			var form = layui.form;

			//各种基于事件的操作，下面会有进一步介绍
		});
	</script>
</body>
</html>