<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>帐号设置</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="keywords" content="教师测评系统,教务处,软件学院，泉州信息工程学院">
  <meta name="description"
	content="教师测评系统,教务处,软件学院，泉州信息工程学院">
  <link rel="stylesheet" href="http://localhost:8080/TESystem/js/plugins/layui/css/layui.css">
  <link rel="stylesheet" href="http://localhost:8080/TESystem/js/plugins/layui/css/global.css">
  
<!--   sign页面css -->
  <link href="http://localhost:8080/TESystem/js/plugins/layui/css/signcss/common.css" rel="stylesheet" type="text/css">
<link href="http://localhost:8080/TESystem/js/plugins/layui/css/signcss/style.css" rel="stylesheet" type="text/css">
<!-- 引入js -->

</head>
<body>

    <div class="fly-header layui-bg-blue">
        <div class="layui-container">
          <a class="fly-logo" href="/" style="font-size: 24px;color: rgba(255,255,255,.7)">
          <img alt="" src="http://localhost:8080/TESystem/images/logo2.png" width="200px;" height="40px;">
          </a>
  
          <ul class="layui-nav fly-nav-user">
           <!-- 登入后的状态 -->
           <li class="layui-nav-item">
               <a class="fly-nav-avatar" href="javascript:;">
         <cite class="layui-hide-xs">
           <#if user??>
               ${user.username}
           </#if>
           </cite>
          <i class="iconfont icon-renzheng layui-hide-xs" title="认证信息：layui 作者"></i>
          <i class="layui-badge fly-badge-vip layui-hide-xs">VIP3</i>
          <img src="https://tva1.sinaimg.cn/crop.0.0.118.118.180/5db11ff4gw1e77d3nqrv8j203b03cweg.jpg">
        </a>
        <dl class="layui-nav-child">
          <#-- <dd><a href="../user/set.html"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="../user/message.html"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="../user/home.html"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;"> -->
         <dd><a href="http://localhost:8080/TESystem/tologinout" style="text-align: center;" >安全退出</a></dd>
        </dl>
      </li>
    </ul>
  </div>
</div>

<div class="layui-container fly-marginTop fly-user-main">
 <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
    
      <li class="layui-nav-item ">
      <a href="http://localhost:8080/TESystem/user/touser">
        <i class="layui-icon">&#xe612;</i>
        学生中心
      </a>
    </li>
       <li class="layui-nav-item">
      <a href="http://localhost:8080/TESystem/user/touserlist">
        <i class="layui-icon">&#xe609;</i>
            教师测评
      </a>
    </li>
    
      <li class="layui-nav-item ">
      <a href="http://localhost:8080/TESystem/user/toset">
        <i class="layui-icon">&#xe620;</i>
        基本设置
      </a>
    </li>
    <li class="layui-nav-item ">
      <a href="http://localhost:8080/TESystem/user/tosign">
        <i class="layui-icon">&#x1005;</i>
          学生签到
      </a>
    </li>

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

                <div style="width:1000px;margin: 0 auto;">
<h1 class="titleH1 underNone clearfix">
	<span class="left underNone underLine">班级课程表 </span>
</h1>
<div class="jyTable">
	<div class="clearfix">
		<ul class="title title1 left">
			<li class='cur'>星期一</li>
			<li>星期二</li>
			<li>星期三</li>
			<li>星期四</li>
			<li>星期五</li>
			<!-- <li>星期六</li>
			<li>星期日</li> -->
		</ul>
	</div>
	<div class='zong'>
		<div class="list list1">
<#-- 		星期一 -->
			<div class="tabCon">
				<ul>
					<li class="tabth clearfix">
						<span style="width: 20%">时间</span>
						<span style="width: 20%">课程</span>
						<!-- <span style="width: 10%">教室</span> -->
						<span style="width: 20%">班级</span>
						<!-- <span style="width: 16%">课程内容</span> -->
						<span style="width: 20%">教员/班主任</span>
						<span style="width: 20%">签到</span>
					</li>
					</li>
				</ul>
		
				<div id="s1">
				  <form action="http://localhost:8080/TESystem/user/submitUserSign.do" method="POST">
					<ul class="tabUl">
					 <#list classandcourse1 as classandcourse1>					
						<li class="tabtr clearfix">
							<span class="starttime" style="width: 20%; color: #F7001E">${classandcourse1.starttime?string('HH:mm')}</span>
							<span class="coursecode" style="width: 20%;color: #AB9C08" value="${classandcourse1.coursecode}">${classandcourse1.coursename}</span>
							<span class="classid" style="width: 20%;color: #067D14" value="${classandcourse1.classid}">${classandcourse1.classname}</span>
							<span class="userid" style="width: 20%" value="${classandcourse1.teacherid}">${classandcourse1.teachername}</span>
							<a class="submitSign" style="width: 20%;color: #F7001E"
							userclassid="${user.classesid }"
							classid="${classandcourse1.classid}" userid="${classandcourse1.teacherid}" coursecode="${classandcourse1.coursecode}" starttime="${classandcourse1.starttime?string('HH:mm')}"
							><em class="clickbtn hot">签到freemaker</em></a>
						 </li>										
						</#list>
					 </ul>
				  </form>
			</div>

				
			</div>
<#-- 	星期二 -->
			<div class="tabCon">
				<ul>
					<li class="tabth clearfix">
						<span style="width: 20%">时间</span>
						<span style="width: 20%">课程</span>
						<!-- <span style="width: 10%">教室</span> -->
						<span style="width: 20%">班级</span>
						<!-- <span style="width: 16%">课程内容</span> -->
						<span style="width: 20%">教员/班主任</span>
						<span style="width: 20%">签到</span>
					</li>
					</li>
				</ul>
				
			<div id="s2">
			    <form action="http://localhost:8080/TESystem/user/submitUserSign.do" method="POST">
					<ul class="tabUl">
					   <#list classandcourse2 as classandcourse2>	
						<li class="tabtr clearfix">
							<span style="width: 20%; color: #F7001E">${classandcourse2.starttime?string('HH:mm')}</span>
							<span style="width: 20%;color: #AB9C08">${classandcourse2.coursename}</span>
							<span style="width: 20%;color: #067D14">${classandcourse2.classname}</span>
							<!-- <span style="width: 15%">杨秀菊</span>
							<span style="width: 17%">上机</span> -->
							<span style="width: 20%">${classandcourse2.teachername}</span>
                            <a class="submitSign" style="width: 20%;color: #F7001E"
							classid="${classandcourse2.classid}" userid="${classandcourse2.teacherid}" coursecode="${classandcourse2.coursecode}" starttime="${classandcourse2.starttime?string('HH:mm')}"
							><em class="clickbtn hot">签到</em></a>	
						</li>										
						</#list>
					</ul>
				  </form>
				</div>

				
			</div>
<#-- 		星期三	 -->
		   <div class="tabCon">
				<ul>
					<li class="tabth clearfix">
						<span style="width: 20%">时间</span>
						<span style="width: 20%">课程</span>
						<!-- <span style="width: 10%">教室</span> -->
						<span style="width: 20%">班级</span>
						<!-- <span style="width: 16%">课程内容</span> -->
						<span style="width: 20%">教员/班主任</span>
						<span style="width: 20%">签到</span>
					</li>
					</li>
				</ul>
				<div id="s3">
					<ul class="tabUl">
					<#list classandcourse3 as classandcourse3>	
						<li class="tabtr clearfix">
							<span style="width: 20%; color: #F7001E">${classandcourse3.starttime?string('HH:mm')}</span>
							<span style="width: 20%;color: #AB9C08">${classandcourse3.coursename}</span>
							<span style="width: 20%;color: #067D14">${classandcourse3.classname}</span>
							<!-- <span style="width: 15%">杨秀菊</span>
							<span style="width: 20%">上机</span> -->
							<span style="width: 20%">${classandcourse3.teachername}</span>
							<a class="submitSign" style="width: 20%;color: #F7001E"
							classid="${classandcourse3.classid}" userid="${classandcourse3.teacherid}" coursecode="${classandcourse3.coursecode}" starttime="${classandcourse3.starttime?string('HH:mm')}"
							><em class="clickbtn hot">签到</em></a>
						</li>
					
					
						</#list>
					</ul>
				</div>

				
			</div>
<#-- 	星期四 -->
			<div class="tabCon">
				<ul>
					<li class="tabth clearfix">
						<span style="width: 20%">时间</span>
						<span style="width: 20%">课程</span>
						<!-- <span style="width: 10%">教室</span> -->
						<span style="width: 20%">班级</span>
						<!-- <span style="width: 16%">课程内容</span> -->
						<span style="width: 20%">教员/班主任</span>
						<span style="width: 20%">签到</span>
					</li>
					</li>
				</ul>
				<div id="s4">
					<ul class="tabUl">
					<#list classandcourse4 as classandcourse4>	
						<li class="tabtr clearfix">
							<span style="width: 20%; color: #F7001E">${classandcourse4.starttime?string('HH:mm')}</span>
							<span style="width: 20%;color: #AB9C08">${classandcourse4.coursename}</span>
							<span style="width: 20%;color: #067D14">${classandcourse4.classname}</span>
							<!-- <span style="width: 15%">杨秀菊</span>
							<span style="width: 20%">上机</span> -->
							<span  style="width: 20%">${classandcourse4.teachername}</span>
						<a class="submitSign" style="width: 20%;color: #F7001E"
							classid="${classandcourse4.classid}" userid="${classandcourse4.teacherid}" coursecode="${classandcourse4.coursecode}" starttime="${classandcourse4.starttime?string('HH:mm')}"
							><em class="clickbtn hot">签到</em></a>
						</li>
					
					
						</#list>
					</ul>
				</div>

				
			</div>
<#-- 		星期五 -->
			<div class="tabCon">
				<ul>
					<li class="tabth clearfix">
						<span style="width: 20%">时间</span>
						<span style="width: 20%">课程</span>
						<!-- <span style="width: 10%">教室</span> -->
						<span style="width: 20%">班级</span>
						<!-- <span style="width: 16%">课程内容</span> -->
						<span style="width: 20%">教员/班主任</span>
						<span style="width: 20%">签到</span>
					</li>
					</li>
				</ul>
				<div id="s1">
					<ul class="tabUl">
					<#list classandcourse5 as classandcourse5>	
						<li class="tabtr clearfix">
							<span style="width: 20%; color: #F7001E">${classandcourse5.starttime?string('HH:mm')}</span>
							<span style="width: 20%;color: #AB9C08">${classandcourse5.coursename}</span>
							<span style="width: 20%;color: #067D14">${classandcourse5.classname}</span>
							<!-- <span style="width: 15%">杨秀菊</span>
							<span style="width: 20%">上机</span> -->
							<span style="width: 20%">${classandcourse5.teachername}</span>
						    <a class="submitSign" style="width: 20%;color: #F7001E"
							classid="${classandcourse5.classid}" userid="${classandcourse5.teacherid}" coursecode="${classandcourse5.coursecode}" starttime="${classandcourse5.starttime?string('HH:mm')}"
							><em class="clickbtn hot">签到</em></a>
						</li>
					
					
						</#list>
					</ul>
				</div>

				
			</div>
		
		</div>
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
<#-- <div class="fly-footer">
  <p><a href="http://fly.layui.com/" target="_blank">Fly社区</a> 2017 &copy; <a href="http://www.layui.com/" target="_blank">layui.com 出品</a></p>
  <p>
    <a href="http://fly.layui.com/jie/3147/" target="_blank">付费计划</a>
    <a href="http://www.layui.com/template/fly/" target="_blank">获取Fly社区模版</a>
    <a href="http://fly.layui.com/jie/2461/" target="_blank">微信公众号</a>
  </p>
</div> -->
<script type="text/javascript" src="http://localhost:8080/TESystem/js/jquery-3.2.1.min.js"></script>
<script src="http://localhost:8080/TESystem/js/plugins/layui/layui.js"></script>
<script type="text/javascript" src="http://localhost:8080/TESystem/js/plugins/layui/css/signcss/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="http://localhost:8080/TESystem/js/plugins/layui/css/signcss/tab.js"></script>

<script>
$(function(){
 
	var starttime=$(".submitSign").attr("starttime");
	console.log("数据库时间"+starttime);
	var nowDate=new Date();
	var str=nowDate.getHours()+":"+nowDate.getMinutes();
	console.log(typeof str);
	console.log("当前时间"+str);
	
	
	
	$(".submitSign").click(function(){
		alert("点击");
		/* var userid=$(".userid").attr("value");
		var classid=$(".classid").attr("value");
		var coursecode=$(".coursecode").attr("value");
		var starttime =	$(".starttime").attr("value"); */
		var classid=$(this).attr("classid");
		var coursecode=$(this).attr("coursecode");
		var userid=$(this).attr("userid");
		var starttime=$(this).attr("starttime");
		
		//var starttime =	$(".starttime").text();
		alert(classid);		
	    alert(starttime);
	    $.ajax({
			  method:"POST",
			  data:{  
				  userid:userid,
				  classesid:classid,
				  coursecode:coursecode,
				 
			  },
			  url:"http://localhost:8080/TESystem/user/submitUserSign.do",
			  dataType:"json",
			  /* beforeSend:function(){
		    		
		    	},
			  success:function(res){			   
			      if(res.statusCode==1){    			
		    			
		    		}
		    		if(res.statusCode==0){	    			
		    			
		    		}	                  
			  },
			  complete:function(){
		    			    		
	    		
	    	} */		  	  
		  });	    
	  });
});


</script>

</body>
</html>