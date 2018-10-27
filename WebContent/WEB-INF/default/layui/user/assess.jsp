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
					href="javascript:;"> <cite class="layui-hide-xs"> 
					 <c:if test="${sessionScope.user!=null}">
           ${sessionScope.user.username}
           </c:if>
           <c:if test="${sessionScope.user==null}">
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
      <li class="layui-nav-item ">
      <a href="${contextpath}/user/touser">
        <i class="layui-icon">&#xe612;</i>
        学生中心
      </a>
    </li>
       <li class="layui-nav-item layui-this">
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
   
   <c:if test="${sessionScope.user.type==2}">
    <li class="layui-nav-item ">
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
    <li class="layui-nav-item layui-this">
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
    <li class="layui-nav-item layui-this">
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
    <li class="layui-nav-item">
      <a href="${contextpath}/user/touser">
        <i class="layui-icon">&#xe612;</i>
         班主任中心
      </a>
    </li>
     <li class="layui-nav-item">
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
    <li class="layui-nav-item">
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
     <li class="layui-nav-item">
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
					<li data-type="mine-jie" lay-id="index" class="layui-this">教师测评
					</li>
				</ul>
				<div class="layui-tab-content" style="padding: 20px 0;">
					<form  class="layui-form layui-form-pane">
<input type="hidden" name="targetTeacher" value="${assess.targetTeacher }">
<input type="hidden" name="userid" value="${assess.userid }">
						 <input
							type="hidden" name="usertype" value="${assess.usertype}">
							<div class="layui-fixbar-scorce" style="position: fixed;top: 30%;right:0;z-index:10">
						<div class="layui-form-item" lay-type="top">
							<label for="scorce" class="layui-form-label" >最终分数</label>
							<div >
								<input type="text" id="scorce" name="scorce" 
									autocomplete="off" class="layui-input" 
									readonly="readonly" style="width:110px;">
							</div>
							<div >
							<label for="customscorce" class="layui-form-label" >自定义分数</label>
								<input type="text" name="customscorce" 
									autocomplete="off" class="layui-input" style="width:110px;" id="customscorce"
									placeholder="自定义分数">
							</div>
						</div>
</div>
						<div class="layui-collapse">
							<c:forEach items="${criteriaList }" var="criteria">


								<div class="layui-colla-item">

									<h2 class="layui-colla-title">项目:${criteria.criteriaName };</h2>
									<div class="layui-form-item" pane="">
										<c:forEach items="${criteria.children }" var="sub"
											varStatus="two">
											<div>
												<h3>${two.count}、${ sub.criteriaName}(分值:${sub.weight })</h3>
												<div>
													<c:forEach items="${ranks}" var="rank">
													
													<input type="radio" name="criteria${ sub.id}"
															value="${rank.value*sub.weight/100}" title="${rank.key}"
															lay-filter="scorce ">
													</c:forEach>
												</div>
											</div>
										</c:forEach>
									</div>
								</div>
							</c:forEach>
							<div class="layui-colla-item">
							<h2 class="layui-colla-title">项目:你认为最想对老师提的的建议？</h2>
							<div class="layui-form-item" pane="">
							
							<textarea rows="5" cols="120" name="remarks" style="vetical-align:top; vertical-align: left">
							
							
							</textarea>
							
							</div>
							</div>
							
						</div>
						<button class="layui-btn layui-btn-fluid layui-btn-danger"
							lay-submit lay-filter="assesssubmit">评测提交</button>
					</form>
					<div class="layui-tab-item">
						<ul class="mine-view jie-row">
							<li><a class="jie-title" href="../jie/detail.html"
								target="_blank">基于 layui 的极简社区页面模版</a> <i>收藏于23小时前</i></li>
						</ul>
						<div id="LAY_page1"></div>
					</div>
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
	<script type="text/javascript"
		src="${contextpath}/js/jquery-3.2.1.min.js"></script>
	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script>
		//注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
		layui.use([ 'element', 'form' ,'util'], function() {
			var element = layui.element;
			var form = layui.form;
			form.on('submit(assesssubmit)', function(data) {

				var radioLength = parseInt($("input:radio:checked").length);
				var size = parseInt($("input:radio").length / 5);
				//alert(size);

				//alert($("input:radio:checked").length);
				if (size > radioLength) {

					alert("还有项目没有选择")
					return false;
				} 
				  var userid=data.field.userid;
				  var targetTeacher=data.field.targetTeacher;
				  var usertype=data.field.usertype;
				  var customscorce=$("#customscorce").val();
				 
				  var scorce=0;
				  if(customscorce==null||customscorce==""){
					  
					  scorce=$("#scorce").val();
					 
				  }
				  else{
					  scorce= customscorce;
					  
				  }
				  
				  if(scorce>=380){
					  
					  layer.msg("不能选项都选择优秀或者自定义分数不能超过380分！！！,请重新选择",{icon:2}); 
					   return false;
				  }
				  if(scorce<=220){
					  
					  layer.msg("亲，我没有那么差吧！！！，请重新选择",{icon:2}); 
					  return false;
				  }
				  var remarks=data.field.remarks;
				
				   var json={
							"userid":userid,
							"targetTeacher":targetTeacher,
							"usertype":usertype,
							"scorce":scorce,
							"remarks":remarks							
					        } 
					    $.ajax({
					    	method:"POST",
					    	url:"${contextpath}/user/assess",
					    	dataType:"application/json,charset=utf-8",
					    	data:json,
					    	dataType:"json",
					    	beforeSend:function(){
					    		layer.load(); //上传loading
					    	},
					    	success:function(res){
					    		
					    		if(res.statusCode==2){    			
					    			layer.msg(res.message,{icon:1}, function(){
					    				
					    				window.location.href="${contextpath}/user/touser";
					    			
					    				}); 
					    		}
					    		if(res.statusCode==1){
					    			
					    			layer.msg(res.message,{icon:2}); 
					    			layer.closeAll('loading'); //关闭loading
					    			return flase;
					    		}
					    		
				              
					    		
					    	},
					    	complete:function(){
					    		
					    		
					    		   layer.closeAll('loading'); //关闭loading
					    	}
					    	
					    	
					    });
										  
					 
				return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});
			form.on('radio', function(data) {
				var score = 0;
				$("input:radio:checked").each(function(index, obj) {

					score += parseFloat(obj.value);

				});
				$("#scorce").val(score);
				if(score>=380){
					layer.msg("不能选项都选择优秀！！！",{icon:2}); 
					
					
				}
				if(score==220){
					layer.msg("亲，我没有那么差吧！！！",{icon:2}); 
					
					
				}

			})
			
			 var util = layui.util;
			
			

		});
	</script>

</body>
</html>