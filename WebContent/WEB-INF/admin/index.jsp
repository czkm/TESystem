<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>教师测评系统后台</title>
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
</head>
<body class="layui-layout-body ">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header layui-bg-blue">
			<div class="layui-logo" >
			<img alt="" src="${contextpath}/images/logo2.png " width="200px" height="40px;">
			</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
		
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> <c:choose>
						<c:when test="${admin!=null}">
					        	${admin.loginname}
						</c:when>
							<c:otherwise>
								<c:redirect url="${contextpath }/admin/tologin"></c:redirect>
							</c:otherwise>
						</c:choose>
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="${contextpath }/admin/tologinout">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<c:forEach items="${menuList}" var="menu">
						<li class="layui-nav-item layui-nav-itemed"><a class=""
							href="javascript:;">${menu.title }</a>

							<dl class="layui-nav-child ">
								<c:forEach items="${menu.children}" var="sub">
									<dd class="">
										<a href="${contextpath }/${sub.controller}/${sub.action}"
											target="main">${sub.title }</a>
									</dd>
								</c:forEach>

							</dl></li>
					</c:forEach>

				</ul>
			</div>
		</div>

		<div class="layui-body">
			<span class="layui-breadcrumb" style="padding: 15px;"><%-- <a
				href="">首页</a>  <a href="">管理员</a> <a href="">亚太地区</a> <a><cite>正文</cite></a> --%>
			</span>
			<!-- 内容主体区域 -->

			<div style="padding: 15px; height: 600px">
				<iframe id="main" name="main" height="100%" width="100%"
					frameborder="no" border="0" marginwidth="0" marginheight="0"
					scrolling="yes" allowtransparency="yes" src="${contextpath }/towelcome"> </iframe>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© 泉州信息工程学院版权所有，互联网+社团提供技术支持
		</div>
	</div>
	
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script>
		//JavaScript代码区域
		layui.use('element', function() {
			var element = layui.element;

		});
	</script>
</body>
</html>