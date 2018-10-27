<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>用户登入</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="学生登录注册|教师登录注册|督导登录注册注册">
  <meta name="description" content="学生登录注册|教师登录注册|督导登录注册注册">
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
      <!-- 未登入的状态 -->
      <li class="layui-nav-item">
        <a class="iconfont icon-touxiang layui-hide-xs" href="user/login.html"></a>
      </li>
      <li class="layui-nav-item">
        <a href="${contextpath }/tologin">登入</a>
      </li>
      <li class="layui-nav-item">
        <a href="javascript:;" onclick="layer.msg('系统目前不提供注册' ,{icon: 2})">注册</a>
      </li>
      <!-- 
      <li class="layui-nav-item layui-hide-xs">
        <a href="/app/qq/" onclick="layer.msg('正在通过QQ登入', {icon:16, shade: 0.1, time:0})" title="QQ登入" class="iconfont icon-qq"></a>
      </li>
      <li class="layui-nav-item layui-hide-xs">
        <a href="/app/weibo/" onclick="layer.msg('正在通过微博登入', {icon:16, shade: 0.1, time:0})" title="微博登入" class="iconfont icon-weibo"></a>
      </li>
       -->
    </ul>
  </div>
</div>

<div class="layui-container fly-marginTop">
  <div class="fly-panel fly-panel-user" pad20>
    <div class="layui-tab layui-tab-brief" lay-filter="user">
      <ul class="layui-tab-title">
        <li class="layui-this">登入</li>
        <li><a href="javascript:;" onclick="layer.msg('系统目前不提供注册' ,{icon: 2})">注册</a></li>
      </ul>
      <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
          <div class="layui-form layui-form-pane">
            <form>
              <div class="layui-form-item">
                <label for="L_email" class="layui-form-label">学号/工号</label>
                <div class="layui-input-inline">
                  <input type="text" id="userNo" name="userNo" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_pass" class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                  <input type="password" id="password" name="password" required lay-verify="required" autocomplete="off" class="layui-input">
                </div>
              </div>
              <div class="layui-form-item">
                <label for="L_vercode" class="layui-form-label">
                <img alt="验证码" src="${contextpath }/file/verifyCode" id="checkCode" align="middle" onclick="reloadPic()" style=" width: 100%; height: 32px;border-radius: 4px;">
                </label>
                <div class="layui-input-inline">
				    <input type="text" id="code" name="code" required lay-verify="required" placeholder="输入验证码" class="layui-input">
                </div>
                <div class="layui-input-inline">
						
                </div>
                <div class="layui-form-mid">
                  <span style="color: #c00;" id="isCodeOk"></span>
                </div>
              </div>
              <div class="layui-form-item">
                <input class="layui-btn"  type="submit" value="立即登录" lay-submit lay-filter="login">
                <span style="padding-left:20px;">
                  <a href="javascript:;">忘记密码？</a>
                </span>
              </div>
              <div class="layui-form-item fly-form-app">
                <span>或者使用社交账号登入</span>
                <a href="javascript:;" onclick="layer.msg('系统目前不提供第三方账户登录' ,{icon: 2})" class="iconfont icon-qq" title="QQ登入"></a>
                <a href="javascript:;" onclick="layer.msg('系统目前不提供第三方账户登录' ,{icon: 2})" class="iconfont icon-weibo" title="微博登入"></a>
              </div>
            </form>
          </div>
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
<!-- <div class="fly-footer">
  <p><a href="javascript:;" target="_blank">泉州信息工程学院教师测试系统</a> 2018 &copy; <a href="http://www.layui.com/" target="_blank">泉州智慧科技 出品</a></p>
  <p>
    <a href="javascript:;" target="_blank">招生电话</a>
    <a href="javascript:;" target="_blank">0595-22789708， 0595-22789808</a>
    <a href="javascript:;" target="_blank">备案号：闽ICP备05015349号</a>
  </p>
  <p>
  
  <a href="javascript:;" target="_blank">福建省泉州市丰泽区博东路249号</a>
  </p>
</div> -->
<script type="text/javascript" src="${contextpath}/js/jquery-3.2.1.min.js"></script>
<script src="${contextpath}/js/plugins/layui/layui.js"></script>
<script>

layui.use('form', function(){
	  var form = layui.form;
	  
	  //监听提交
	  form.on('submit(login)', function(data){
		  var userNo=data.field.userNo;
		  var password=data.field.password;
		  var code=data.field.code;
		 // var json=JSON.stringify(data.field)
	 var json={
			"userno":userNo,
			"password":password,
			"code":code
			
	        } 
	    $.ajax({
	    	method:"POST",
	    	url:"${contextpath}/login",
	    	dataType:"application/json,charset=utf-8",
	    	data:json,
	    	dataType:"json",
	    	beforeSend:function(){
	    		layer.load(); //上传loading
	    	},
	    	success:function(res){
	    		
	    		if(res.statusCode==1){    			
	    			layer.msg(res.message,{icon:1}, function(){
	    				
	    				window.location.href="${contextpath}/user/touser";
	    			
	    				}); 
	    		}
	    		if(res.statusCode==2){
	    			
	    			layer.msg(res.message,{icon:2}); 
	    		}
	    		
                  if(res.statusCode==3){
	    			
	    			layer.msg(res.message,{icon:2}); 
	    		}
	    		
	    	},
	    	complete:function(){
	    		
	    		
	    		   layer.closeAll('loading'); //关闭loading
	    	}
	    	
	    	
	    });
	    return false;
	  
	  });
	  
	});
function reloadPic() {  
  //  document.getElementById("checkCode").src = document.getElementById("checkCode").src + "1";
    
    $("#checkCode").attr("src","${contextpath }/file/verifyCode?code="+Math.random());
} 



</script>

</body>
</html>