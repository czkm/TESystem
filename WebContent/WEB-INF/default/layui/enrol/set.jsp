<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>帐号设置</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 <meta name="keywords" content="教师测评系统,教务处,软件学院，泉州信息工程学院">
<meta name="description"
	content="教师测评系统,教务处,软件学院，泉州信息工程学院">
 <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/layui.css">
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/global.css">
</head>
<body>

<div class="fly-header layui-bg-blue">
  <div class="layui-container">
     <a class="fly-logo" href="/" style="font-size: 24px;color: rgba(255,255,255,.7)">
      <img alt="" src="${ contextpath}/images/logo2.png" width="200px;" height="40px;">
    </a>
  
    <ul class="layui-nav fly-nav-user">
      <!-- 登入后的状态 -->
      <li class="layui-nav-item">
        <a class="fly-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs">
           <c:if test="${sessionScope.user!=null}">
           ${sessionScope.user.username}
           </c:if>
           <c:if test="${sessionScope.user==null}">
           <c:redirect url="${ contextpath}/tologin"></c:redirect>
           </c:if>
           </cite>
          <i class="iconfont icon-renzheng layui-hide-xs" title="认证信息：layui 作者"></i>
          <i class="layui-badge fly-badge-vip layui-hide-xs">VIP3</i>
          <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
        </a>
        <dl class="layui-nav-child">
          <!-- <dd><a href="../user/set.html"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="../user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="../user/home.html"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;"> -->
         <dd><a href="${contextpath}/tologinout" style="text-align: center;" >安全退出</a></dd>
        </dl>
      </li>
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
    
      <li class="layui-nav-item layui-this">
      <a href="${contextpath}/user/toset">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
   
   </c:if>
   <c:if test="${sessionScope.user.type==3 }">
    <li class="layui-nav-item ">
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
  
      <li class="layui-nav-item layui-this">
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
    
      <li class="layui-nav-item layui-this">
      <a href="${contextpath}/user/toset">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
   </c:if>
   <c:if test="${sessionScope.user.type==5 }">
    <li class="layui-nav-item ">
      <a href="${contextpath}/user/touser">
        <i class="layui-icon">&#xe612;</i>
        用户中心
      </a>
    </li>
      <li class="layui-nav-item layui-this">
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
 
      <li class="layui-nav-item layui-this">
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
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title" id="LAY_mine">
        <li class="layui-this" lay-id="info">我的资料</li>
        <li  lay-id="pass">修改密码</li>
        <c:if test="${sessionScope.user.type==2 }">
        <li  lay-id="pass">兼职班主任</li>
        </c:if>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-form layui-form-pane layui-tab-item layui-show">
        <div class="layui-form-item">
              <label for="studentNo" class="layui-form-label">学号</label>
              <div class="layui-input-inline">
                <input type="text" id="userno" name="userno" value="${user.userno}"  readonly="readonly" required lay-verify="required" autocomplete="off" value="" class="layui-input">
              </div>
             
            </div>
            <div class="layui-form-item">
              <label for="studentName" class="layui-form-label">姓名</label>
              <div class="layui-input-inline">
                <input type="text" id="username" name="username" value="${user.username}" readonly="readonly" required lay-verify="required" autocomplete="off" value="" class="layui-input">
              </div>
              <!-- <div class="layui-form-mid layui-word-aux">如果您在邮箱已激活的情况下，变更了邮箱，需<a href="activate.html" style="font-size: 12px; color: #4f99cf;">重新验证邮箱</a>。</div> -->
            </div>
           
           <c:if test="${sessionScope.user.type==1 }">
            <div class="layui-form-item">
              <label for="L_city" class="layui-form-label">班级</label>
              <div class="layui-input-inline">
                <input type="text" id="classesid" name="classesid" value="${user.classes.classesName}" readonly="readonly" autocomplete="off" value="" class="layui-input">
              </div>
            </div>
            </c:if>
          <div class="layui-form-item">
              <label for="departmentId" class="layui-form-label">学院</label>
              <div class="layui-input-inline">
                <input type="text" id="departid" name="departid" value="${user.department.departName}" readonly="readonly" autocomplete="off" value="" class="layui-input">
              </div>
            </div>
         <!--    <div class="layui-form-item">
              <button class="layui-btn" key="set-mine" lay-filter="*" lay-submit>确认修改</button>
            </div> -->


     <c:if test="${sessionScope.user.type==2 ||sessionScope.user.type==3||sessionScope.user.type==4||sessionScope.user.type==5 }">
            <div class="layui-form-item">
              <label for=""ranks"" class="layui-form-label">职称</label>
              <div class="layui-input-inline">
                <input type="text" id=""ranks"" name="ranks" value="${user.ranks}"  readonly="readonly" autocomplete="off" value="" class="layui-input">
              </div>
            </div>
            <div class="layui-form-item">
              <label for="major" class="layui-form-label">专业</label>
              <div class="layui-input-inline">
                <input type="text" id="major" name="major" value="${user.major}"  readonly="readonly" autocomplete="off" value="" class="layui-input">
              </div>
            </div>
            
         <!--    <div class="layui-form-item">
              <button class="layui-btn" key="set-mine" lay-filter="*" lay-submit>确认修改</button>
            </div> -->
        
      </c:if>
          </div>
          
         
          <!-- 修改密码 start -->
          <div class="layui-form layui-form-pane layui-tab-item">
            <form >
              <input type="hidden" name="type" value="${sessionScope.type}">
              <div class="layui-form-item">
                <label for="L_nowpass" class="layui-form-label">旧密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="nowpassword" name="nowpassword" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">新密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="newpassworld" name="newpassword" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
              </div>
              <div class="layui-form-item">
                <label for="L_repass" class="layui-form-label">确认密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repasspassword" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <input class="layui-btn" type="submit" value="确认修改" lay-filter="changepassword" lay-submit>
              </div>
            </form>
          </div>
          
     <!-- 修改密码结束 -->
     <c:if test="${sessionScope.user.type==2}">
       <div class="layui-form layui-form-pane layui-tab-item">
       <form action="">
           <div class="layui-form-item">
    <label class="layui-form-label">兼职班主任</label>
    <div class="layui-input-block">
      <input type="checkbox" name="close" value="24" lay-skin="switch" lay-text="ON|OFF" lay-filter="isCharger">
    </div>
  </div>
  </form>
          </div>
    </c:if> 

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
<!-- <div class="fly-footer">
  <p><a href="http://fly.layui.com/" target="_blank">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/" target="_blank">layui.com 出品</a></p>
  <p>
    <a href="http://fly.layui.com/jie/3147/" target="_blank">付费计划</a>
    <a href="http://www.layui.com/template/fly/" target="_blank">获取Fly社区模版</a>
    <a href="http://fly.layui.com/jie/2461/" target="_blank">微信公众号</a>
  </p>
</div> -->
<script type="text/javascript" src="${contextpath}/js/jquery-3.2.1.min.js"></script>
<script src="${contextpath}/js/plugins/layui/layui.js"></script>
<script>
layui.use(['element','form'], function(){
	  var element = layui.element;
	  element.on('tab(demo)', function(data){
	    console.log(data);
	  });
	  
	  var form=layui.form;
	  
	  form.on('submit(changepassword)',function(data){
		  var newpassword=data.field.newpassword;
		  var repasspassword=data.field.repasspassword;
		  if(repasspassword!=newpassword){
			  layer.msg('新密码和重复密码要一致',{icon:2}); 
			  return false;
			  
		  }
		 var user={
			 "newpassword":data.field.newpassword,
			 "nowpassword":data.field.nowpassword,
			 "type":data.field.type		 			 
		 } 
		  
		  $.ajax({
		    	method:"POST",
		    	url:"${contextpath}/user/changepassword",
		    	dataType:"application/json,charset=utf-8",
		    	data:user,
		    	dataType:"json",
		    	success:function(res){  		
		    		if(res.statusCode==1){    			
		    			layer.msg(res.message, function(){
		    				window.location.href="${contextpath}/tologin";
		    			
		    				}); 
		    		}
		    		if(res.statusCode==0){
		    			
		    			layer.msg(res.message,{icon:2}); 
		    			return false;
		    		}
                     if(res.statusCode==-1){
		    			
		    			layer.msg(res.message,{icon:2}); 
		    			return false;
		    		}
                     if(res.statusCode==2){
 		    			
                    	 layer.msg(res.message, function(){
 		    				window.location.href="${contextpath}/tologin";
 		    			
 		    				}); 
 		    		}
		    	}
		    	
		    	
		    });
		    return false; 
	  });
	  form.on('switch(isCharger)',function(data){
	     console.log(data.elem.checked);  
	     if(data.elem.checked){
	    	 
	    	  $.ajax({
				  method:"POST",
				  data:{  
					  type:data.value
				  },
				  url:"${contextpath }/user/changeusertype",
				  dataType:"json",
				  beforeSend:function(){
			    		layer.load(); //上传loading
			    	},
				  success:function(res){
					  
					  alert(res.statusCode);  
				      if(res.statusCode==1){    			
			    			layer.msg(res.message,{icon:1}, function(){
			    				
			    				window.location.href="${contextpath}/tologin";
			    			
			    				}); 
			    		}
			    		if(res.statusCode==0){
			    			
			    			layer.msg(res.message,{icon:2},function(){
			    				
			    				window.location.href="${contextpath}/tologin";
			    				
			    			}); 
			    		}
			    		
		                  if(res.statusCode==2){
			    			
			    			layer.msg(res.message,{icon:2}); 
			    			 layer.closeAll('loading'); //关闭loading
			    			return false;
			    			
			    		}
				  },
				  complete:function(){
			    		
			    		
		    		   layer.closeAll('loading'); //关闭loading
		    	}
				  
				  
			  });
	    	 
	     }
	    	 
	  
	  
	  });
	});
</script>

</body>
</html>