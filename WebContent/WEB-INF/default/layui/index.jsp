<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>泉州信息工程学院教师测评系统</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="fly,layui,前端社区">
  <meta name="description" content="Fly社区是模块化前端UI框架Layui的官网社区，致力于为web开发提供强劲动力">
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/layui.css">
  <link rel="stylesheet" href="${contextpath}/js/plugins/layui/css/global.css">
  <style type="text/css">
  
 #h5-bg-index  h1 {
  position: absolute;
  top:25%;
  right:40%;
  color: #EEEEEE;
  font-weight: 600;
  font-size: 40px;
  padding: 0;
  margin: 30px;
  line-height: 1;
  text-shadow: 0 0 30px #000155;
  z-index: 999;
  opacity:0.8;
 
}
  </style>
</head>
<body style="margin-top: 199px;">

<div class="fly-header layui-bg-blue" id="h5-bg-index" style="height:199px;">
  <div class="layui-container">
    <a class="fly-logo" href="/" style="font-size: 18;color:white;" >
        <img alt="" src="${ contextpath}/images/logo412-104.png" width="257px;" height="65px;">
    </a>
   <!--  <ul class="layui-nav fly-nav layui-hide-xs">
      <li class="layui-nav-item layui-this">
        <a href="/"><i class="iconfont icon-jiaoliu"></i>交流</a>
      </li>
      <li class="layui-nav-item">
        <a href="case/case.html"><i class="iconfont icon-iconmingxinganli"></i>案例</a>
      </li>
      <li class="layui-nav-item">
        <a href="http://www.layui.com/" target="_blank"><i class="iconfont icon-ui"></i>框架</a>
      </li>
    </ul> -->
    
    <ul class="layui-nav fly-nav-user">
      
      <!-- 未登入的状态 -->
      <li class="layui-nav-item">
        <a class="iconfont icon-touxiang layui-hide-xs" href="${contextpath }/tologin"></a>
      </li>
      <li class="layui-nav-item">
        <a href="${contextpath }/tologin">登入</a>
      </li>
      <li class="layui-nav-item">
        <a href="javascript:;">注册</a>
      </li>
    <!--   <li class="layui-nav-item layui-hide-xs">
        <a href="/app/qq/" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" title="QQ登入" class="iconfont icon-qq"></a>
      </li>
      <li class="layui-nav-item layui-hide-xs">
        <a href="/app/weibo/" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" title="微博登入" class="iconfont icon-weibo"></a>
      </li> -->
      
      <!-- 登入后的状态 -->
      <!--
      <li class="layui-nav-item">
        <a class="fly-nav-avatar" href="javascript:;">
          <cite class="layui-hide-xs">吴宗波</cite>
          <i class="iconfont icon-renzheng layui-hide-xs" title="认证信息：layui 作者"></i>
          <i class="layui-badge fly-badge-vip layui-hide-xs">VIP3</i>
          泉州信息工程学院教师测试平台
        </a>
        <dl class="layui-nav-child">
          <dd><a href="user/set.html"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="user/home.html"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;">
          <dd><a href="/user/logout/" style="text-align: center;">退出</a></dd>
        </dl>
      </li>
      -->
    </ul>
   
  </div>
   <h1>教师测评系统</h1>
</div>

<div class="fly-panel fly-column">
  <div class="layui-container">
    <ul class="layui-clear">
      <li class="layui-hide-xs layui-this"><a href="/">首页</a></li> 
      <li><a href="jie/index.html">提问</a></li> 
      <li><a href="jie/index.html">分享<span class="layui-badge-dot"></span></a></li> 
      <li><a href="jie/index.html">讨论</a></li> 
      <li><a href="jie/index.html">建议</a></li> 
      <li><a href="jie/index.html">公告</a></li> 
      <li><a href="jie/index.html">动态</a></li> 
      <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><span class="fly-mid"></span></li> 
      
      <!-- 用户登入后显示 -->
      <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a href="user/index.html">我发表的贴</a></li> 
      <li class="layui-hide-xs layui-hide-sm layui-show-md-inline-block"><a href="user/index.html#collection">我收藏的贴</a></li> 
    </ul> 
    
    <div class="fly-column-right layui-hide-xs"> 
      <span class="fly-search"><i class="layui-icon"></i></span> 
      <a href="jie/add.html" class="layui-btn">发表新帖</a> 
    </div> 
    <div class="layui-hide-sm layui-show-xs-block" style="margin-top: -10px; padding-bottom: 10px; text-align: center;"> 
      <a href="jie/add.html" class="layui-btn">发表新帖</a> 
    </div> 
  </div>
</div>

<div class="layui-container">
  <h3>系统操作指南</h3> 
  <video src="http://movie-1251531734.costj.myqcloud.com/demo.mp4" controls="controls" width="100%"></video>
   
</div>
<div class="fly-footer">
  <p><a href="javascript:;" target="_blank">泉州信息工程学院教师测试系统</a> 2018 &copy; <a href="http://www.layui.com/" target="_blank">互联网+社团 出品</a></p>
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
 <script type="text/javascript" src="${contextpath }/js/h5-bg-index.js"></script>


</body>
</html>