<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户中心</title>
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
      泉州信息工程学院教师测评系统
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
    <li class="layui-nav-item ">
      <a href="${contextpath}/user/tosign">
        <i class="layui-icon">&#x1005;</i>
          学生签到
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
    <li class="layui-nav-item ">
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
     <li class="layui-nav-item">
      <a href="${contextpath}/user/toadviserclasses">
        <i class="layui-icon">&#xe608;</i>
         负责班级
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
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title" id="LAY_mine">
        <li data-type="mine-jie" lay-id="index" class="layui-this">教师列表</li>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <table class="layui-table" lay-size="sm">
      <colgroup>
        <col width="150">
        <col width="200">
        <col>
        <col width="150">
      </colgroup>
      <thead>
         <tr>
         <td colspan="4">
         <p style="height:30px;color:red;font-size: 25px;">请大家按照测评教师的实际教学表现进行评分，评分要客观公正！！！<p>
         
         </td>
         </tr>
        <tr>
          <th>姓名</th>
          <th>职称</th>
          <th>专业</th>
          <th>操作</th>
        </tr> 
      </thead>
      <tbody>
      <c:choose>
      <c:when test="${teachers!=null&&teachers.size()>0 }">
       <c:forEach items="${teachers }" var="teacher">
        <tr>
          <td>${teacher.username }</td>
          <td>${teacher.ranks}</td>
          <td>${teacher.major}</td>
          <td> <a class="layui-btn" class="mine-edit" href="${contextpath}/user/toassess?teacherId=${teacher.id}">测评</a></td>
        </tr>
           </c:forEach>
      </c:when>
      <c:otherwise>
      <tr>
      <td colspan="4">
      
         恭喜！！！，你的教师测评的任务已经完成
      </td>
      </tr>
      
      </c:otherwise>
      </c:choose>
     
      </tbody>
    </table>
         
          <div id="LAY_page"></div>
        </div>
        <div class="layui-tab-item">
          <ul class="mine-view jie-row">
            <li>
              <a class="jie-title" href="../jie/detail.html" target="_blank">基于 layui 的极简社区页面模版</a>
              <i>收藏于23小时前</i>  </li>
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

<script src="${contextpath}/js/plugins/layui/layui.js"></script>
<script>
layui.use('element', function(){
	  var element = layui.element;
	  
	  //一些事件监听
	  element.on('tab(demo)', function(data){
	    console.log(data);
	  });
	});
</script>

</body>
</html>