<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="size" value="${fn:length(criteriaList) }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>教师列表</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
 <meta name="keywords" content="教师测评系统,教务处,软件学院，泉州信息工程学院">
<meta name="description"
	content="教师测评系统,教务处,软件学院，泉州信息工程学院">
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/layui.css">
<link rel="stylesheet"
	href="${contextpath}/js/plugins/layui/css/global.css">
	
	<style type="text/css">
	
	.layui-form-checkbox span {
	
	color:black;
	}
	
	</style>
</head>
<body>
	<div class="fly-header layui-bg-blue">
		<div class="layui-container">
			<a class="fly-logo" href="/"
				style="font-size: 24px; color: rgba(255, 255, 255, .7)"> <img
				alt="" src="${ contextpath}/images/logo2.png" width="200px;"
				height="40px;">
			</a>

			<ul class="layui-nav fly-nav-user">
				<!-- 登入后的状态 -->
				<li class="layui-nav-item"><a class="fly-nav-avatar"
					href="javascript:;"> <cite class="layui-hide-xs"> <c:if
								test="${sessionScope.user!=null}">
           ${sessionScope.user.username}
           </c:if> <c:if test="${sessionScope.user==null}">
								<c:redirect url="${ contextpath}/tologin"></c:redirect>
							</c:if>
					</cite> <i class="iconfont icon-renzheng layui-hide-xs"
						title="认证信息：layui 作者"></i> <i
						class="layui-badge fly-badge-vip layui-hide-xs">VIP3</i> <img
						src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
				</a>
					<dl class="layui-nav-child">
						<!-- <dd>
							<a href="../user/set.html"><i class="layui-icon">&#xe620;</i>基本设置</a>
						</dd>
						<dd>
							<a href="../user/message.html"><i
								class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a>
						</dd>
						<dd>
							<a href="../user/home.html"><i class="layui-icon"
								style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a>
						</dd>
						<hr style="margin: 5px 0;"> -->
						<dd><a href="${contextpath}/tologinout" style="text-align: center;" >安全退出</a></dd>
					</dl></li>
			</ul>
		</div>
	</div>

	<div class="layui-container fly-marginTop fly-user-main">
		<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
      <c:if test="${sessionScope.user.type==1 }">
      <li class="layui-nav-item layui-this">
      <a href="${contextpath}/user/touser">
        <i class="layui-icon">&#xe612;</i>
        学生中心
      </a>
    </li>
       <li class="layui-nav-item">
      <a href="${contextpath}/user/touserlist">
        <i class="layui-icon">&#xe609;</i>
            教师测评
      </a>
    </li>
    
      <li class="layui-nav-item ">
      <a href="${contextpath}/user/toset">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
      </li>
<li class="layui-nav-item ">
      <a href="${contextpath}/user/tosign">
        <i class="layui-icon">&#x1005;</i>
          学生签到
      </a>
    </li>
    </c:if>
   
   <c:if test="${sessionScope.user.type==2}">
    <li class="layui-nav-item layui-this">
      <a href="${contextpath}/user/touser">
        <i class="layui-icon">&#xe612;</i>
        教师中心
      </a>
    </li>
    <li class="layui-nav-item">
      <a href="${contextpath}/user/toclasses">
        <i class="layui-icon">&#xe608;</i>
        添加班级
      </a>
    </li>
    <li class="layui-nav-item">
      <a href="${contextpath}/user/touserlist">
        <i class="layui-icon">&#xe609;</i>
        教师互评
      </a>
    </li>
     <li class="layui-nav-item">
      <a href="${contextpath}/user/toclassesinfo">
        <i class="layui-icon">&#xe702;</i>
       班级评学
      </a>
    </li>
    
      <li class="layui-nav-item ">
      <a href="${contextpath}/user/toset">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
   
   </c:if>
   <c:if test="${sessionScope.user.type==3 }">
    <li class="layui-nav-item layui-this">
      <a href="${contextpath}/user/touser">
        <i class="layui-icon">&#xe612;</i>
    督导中心
      </a>
    </li>
    <li class="layui-nav-item">
      <a href="${contextpath}/user/touserlist">
        <i class="layui-icon">&#xe609;</i>
        教师测评
      </a>
    </li>
  
      <li class="layui-nav-item ">
      <a href="${contextpath}/user/toset">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
   
   </c:if>
   <c:if test="${sessionScope.user.type==4 }">
    <li class="layui-nav-item ">
      <a href="${contextpath}/user/touser">
        <i class="layui-icon">&#xe612;</i>
        班主任中心
      </a>
    </li>
     <li class="layui-nav-item layui-this">
      <a href="${contextpath}/user/toadviserclasses">
        <i class="layui-icon">&#xe608;</i>
         负责班级
      </a>
    </li>
   
    <li class="layui-nav-item">
      <a href="${contextpath}/user/toclassesinfo">
        <i class="layui-icon">&#xe702;</i>
         班级信息
      </a>
    </li>
    
      <li class="layui-nav-item ">
      <a href="${contextpath}/user/toset">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
   </c:if>
   <c:if test="${sessionScope.user.type==5 }">
    <li class="layui-nav-item layui-this">
      <a href="${contextpath}/user/touser">
        <i class="layui-icon">&#xe612;</i>
        用户中心
      </a>
    </li>
      <li class="layui-nav-item ">
      <a href="${contextpath}/user/toset">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
   </c:if>
   <!--老师兼职班主任  教师为2，班主任为4-->
    <c:if test="${sessionScope.user.type==24 }">
   <li class="layui-nav-item ">
      <a href="${contextpath}/user/touser">
        <i class="layui-icon">&#xe612;</i>
        用户中心
      </a>
    </li>
    <li class="layui-nav-item">
      <a href="${contextpath}/user/toclasses">
        <i class="layui-icon">&#xe608;</i>
        添加班级
      </a>
    </li>
     <li class="layui-nav-item layui-this">
      <a href="${contextpath}/user/toadviserclasses">
        <i class="layui-icon">&#xe608;</i>
         负责班级
      </a>
    </li>
    <li class="layui-nav-item">
      <a href="${contextpath}/user/touserlist">
        <i class="layui-icon">&#xe609;</i>
        教师互评
      </a>
    </li>
     <li class="layui-nav-item">
      <a href="${contextpath}/user/toclassesinfo">
        <i class="layui-icon">&#xe702;</i>
       班级评学
      </a>
    </li>
    
      <li class="layui-nav-item ">
      <a href="${contextpath}/user/toset">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
   </c:if>
  </ul>
		<div class="site-tree-mobile layui-hide">
			<i class="layui-icon">&#xe602;</i>
		</div>
		<div class="site-mobile-shade"></div>

		<div class="site-tree-mobile layui-hide">
			<i class="layui-icon">&#xe602;</i>
		</div>
		<div class="site-mobile-shade"></div>


		<div class="fly-panel fly-panel-user" pad20>
			<!--
    <div class="fly-msg" style="margin-top: 15px;">
      您的邮箱尚未验证，这比较影响您的帐号安全，<a href="activate.html">立即去激活？</a>
    </div>
    -->
			<div class="layui-tab layui-tab-brief">
				<ul class="layui-tab-title" id="LAY_mine">
					<li data-type="mine-jie" lay-id="index" class="layui-this">选择班级（<span>89</span>）
					</li>
				</ul>
				<div class="layui-tab-content" style="padding: 20px 0;">
					<form class="layui-form" method="post" >
						<input type="hidden" name="userId"
							value="${sessionScope.user.id}">
						<div class="layui-form-item">
							<div class="layui-collapse" lay-accordion>
								<div class="layui-colla-item">
									<c:forEach items="${departmentAndClassesVos }" var="depart">
										<h2 class="layui-colla-title">${depart.departName }</h2>
										<div class="layui-colla-content layui-show">
											<c:forEach items="${ depart.classeses}" var="classes" varStatus="index">
											<c:set var="flag" value="true"></c:set>
									       <c:if test="${flag }">
											<c:forEach items="${classesIds }" var="classesId">
											  <c:choose>
											      <c:when test="${classes.id==classesId}">
											  
											  <input type="checkbox" name="classesIds"
													value="${classes.id }" checked title="${classes.classesName}">   
											     <c:set var="flag" value="false"></c:set>	
											   </c:when>
											 
											    </c:choose>																			  
										     </c:forEach>	
										    </c:if>	
										   <c:if test="${flag}">
										    <input type="checkbox" name="classesIds"
													value="${classes.id }"  title="${classes.classesName}"> 
										    </c:if>
									 </c:forEach>
										
										</div>

									</c:forEach>

								</div>

							</div>

						</div>


						<div class="layui-form-item">

							<button class="layui-btn" lay-submit lay-filter="addClasses">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>

	<div class="fly-footer">
  <p><a href="javascript:;" target="_blank">泉州信息工程学院教师测试系统V1.0</a> 2018 &copy; <a href="http://www.layui.com/" target="_blank">互联网+社团 出品</a></p>
  <p>
    <a href="javascript:;" target="_blank">招生电话</a>
    <a href="javascript:;" target="_blank">0595-22789708， 0595-22789808</a>
    <a href="javascript:;" target="_blank">备案号：闽ICP备05015349号</a>
  </p>
  <p>
  
  <a href="javascript:;" target="_blank">福建省泉州市丰泽区博东路249号</a>
  </p>
</div>
	<script src="${contextpath}/js/jquery-3.2.1.min.js"></script>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script>
		//Demo
		layui.use(['form','element'], function() {
			var form = layui.form;
			var element = layui.element;
			//监听提交
		
			form.on('submit(addClasses)', function(data){
			  if( $(":checkbox:checked").length==0){
				 layer.msg("必须选择一个班级",{icon:7});
				 return false;
				 
			 }
			  var idList = new Array();
			  $(":checkbox:checked").each(function(){
				  
				  idList.push($(this).val());
				  
				  
			  });
			
			  $.ajax({
				  method:"POST",
				  data:{  
					  classesIds:idList
				  },
				  url:"${contextpath }/user/addadviserclasses",
				  dataType:"json",
				  beforeSend:function(){
			    		layer.load(); //上传loading
			    	},
				  success:function(res){
					  
				      if(res.statusCode==3){    			
			    			layer.msg(res.message,{icon:1}, function(){
			    				
			    				window.location.href="${contextpath}/user/toclassesinfo";
			    			
			    				}); 
			    		}
			    		if(res.statusCode==2){
			    			
			    			layer.msg(res.message,{icon:2},function(){
			    				
			    				window.location.href="${contextpath}/tologin";
			    				
			    			}); 
			    		}
			    		
		                  if(res.statusCode==1){
			    			
			    			layer.msg(res.message,{icon:2}); 
			    			 layer.closeAll('loading'); //关闭loading
			    			return false;
			    			
			    		}
				  },
				  complete:function(){
			    		
			    		
		    		   layer.closeAll('loading'); //关闭loading
		    	}
				  
				  
			  });
			  
			});
			 
		});
	</script>


</script>
</body>
</html>