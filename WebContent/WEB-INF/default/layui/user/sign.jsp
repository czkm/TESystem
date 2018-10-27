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
  
<!--   sign页面css -->
  <link href="${contextpath}/js/plugins/layui/css/signcss/common.css" rel="stylesheet" type="text/css">
<link href="${contextpath}/js/plugins/layui/css/signcss/style.css" rel="stylesheet" type="text/css">
<!-- 引入js -->

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
    <li class="layui-nav-item ">
      <a href="${contextpath}/user/tosign">
        <i class="layui-icon">&#x1005;</i>
          学生签到
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


                <div style="width:1000px;margin: 0 auto;">
                  <h1 class="titleH1 underNone clearfix">
	               <span class="left underNone underLine">班级课程表 </span>
                 </h1>
                 </div>
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
<!-- 		星期一 -->
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
				  <form action="${contextpath }/user/submitUserSign.do" method="POST">
					<ul class="tabUl">
					<c:forEach items="${classandcourse1}" var="classandcourse1">
						<li class="tabtr clearfix">
							<span class="starttime" style="width: 20%; color: #F7001E"><fmt:formatDate value="${classandcourse1.starttime}" pattern="HH:mm"/></span>
							<span class="coursecode" style="width: 20%;color: #AB9C08" value="${classandcourse1.coursecode}">${classandcourse1.coursename}</span>
							<span class="classid" style="width: 20%;color: #067D14" value="${classandcourse1.classid}">${classandcourse1.classname}</span>
							<!-- <span style="width: 15%">杨秀菊</span>
							<span style="width: 20%">上机</span> -->
							<span class="userid" style="width: 20%" value="${classandcourse1.teacherid}">${classandcourse1.teachername}</span>
							<a class="submitSign" style="width: 20%;color: #F7001E;display: block"
							userclassid="${user.classesid }" weekday="${classandcourse1.weekday}"
							classid="${classandcourse1.classid}" userid="${classandcourse1.teacherid}" coursecode="${classandcourse1.coursecode}" starttime="${classandcourse1.starttime}"
							><em class="clickbtn hot">签到</em></a>
							<%-- <a href="${contextpath }/user/submitUserSign.do"
								class="layui-btn layui-btn-sm" alt="编辑" title="编辑"> <i
								class="layui-icon">&#xe642;</i>
							</a> --%>
						 </li>										
						</c:forEach>
					 </ul>
				  </form>
			</div>

				
			</div>
<!-- 	星期二 -->
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
					<ul class="tabUl">
					<c:forEach items="${classandcourse2}" var="classandcourse2">
						<li class="tabtr clearfix">
							<span style="width: 20%; color: #F7001E"><fmt:formatDate value="${classandcourse2.starttime}" pattern="HH:mm"/></span>
							<span style="width: 20%;color: #AB9C08">${classandcourse2.coursename}</span>
							<span style="width: 20%;color: #067D14">${classandcourse2.classname}</span>
							<!-- <span style="width: 15%">杨秀菊</span>
							<span style="width: 17%">上机</span> -->
							<span style="width: 20%">${classandcourse2.teachername}</span>
                            <a class="submitSign" style="width: 20%;color: #F7001E"
                            userclassid="${user.classesid }" weekday="${classandcourse2.weekday}"
							classid="${classandcourse2.classid}" userid="${classandcourse2.teacherid}" coursecode="${classandcourse2.coursecode}" starttime="${classandcourse2.starttime}"
							><em class="clickbtn hot">签到</em></a>	
						</li>
					
					
						</c:forEach>
					</ul>
				</div>

				
			</div>
<!-- 		星期三	 -->
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
					<c:forEach items="${classandcourse3}" var="classandcourse3">
						<li class="tabtr clearfix">
							<span style="width: 20%; color: #F7001E"><fmt:formatDate value="${classandcourse3.starttime}" pattern="HH:mm"/></span>
							<span style="width: 20%;color: #AB9C08">${classandcourse3.coursename}</span>
							<span style="width: 20%;color: #067D14">${classandcourse3.classname}</span>
							<!-- <span style="width: 15%">杨秀菊</span>
							<span style="width: 20%">上机</span> -->
							<span style="width: 20%">${classandcourse3.teachername}</span>
							<a class="submitSign" style="width: 20%;color: #F7001E"
							userclassid="${user.classesid }"
							 weekday="${classandcourse3.weekday}"
							classid="${classandcourse3.classid}" userid="${classandcourse3.teacherid}" coursecode="${classandcourse3.coursecode}" starttime="${classandcourse3.starttime}"
							><em class="clickbtn hot">签到</em></a>
						</li>
					
					
						</c:forEach>
					</ul>
				</div>

				
			</div>
<!-- 		星期四 -->
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
					<c:forEach items="${classandcourse4}" var="classandcourse4">
						<li class="tabtr clearfix">
							<span style="width: 20%; color: #F7001E"><fmt:formatDate value="${classandcourse4.starttime}" pattern="HH:mm"/></span>
							<span style="width: 20%;color: #AB9C08">${classandcourse4.coursename}</span>
							<span style="width: 20%;color: #067D14">${classandcourse4.classname}</span>
							<!-- <span style="width: 15%">杨秀菊</span>
							<span style="width: 20%">上机</span> -->
							<span  style="width: 20%">${classandcourse4.teachername}</span>
						<a class="submitSign" style="width: 20%;color: #F7001E"
							userclassid="${user.classesid }"
							 weekday="${classandcourse4.weekday}"
							classid="${classandcourse4.classid}" userid="${classandcourse4.teacherid}" coursecode="${classandcourse4.coursecode}" starttime="${classandcourse4.starttime}"
							><em class="clickbtn hot">签到</em></a>
						</li>
					
					
						</c:forEach>
					</ul>
				</div>

				
			</div>
<!-- 		星期五 -->
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
					<c:forEach items="${classandcourse5}" var="classandcourse5">
						<li class="tabtr clearfix">
							<span style="width: 20%; color: #F7001E"><fmt:formatDate value="${classandcourse5.starttime}" pattern="HH:mm"/></span>
							<span style="width: 20%;color: #AB9C08">${classandcourse5.coursename}</span>
							<span style="width: 20%;color: #067D14">${classandcourse5.classname}</span>
							<!-- <span style="width: 15%">杨秀菊</span>
							<span style="width: 20%">上机</span> -->
							<span style="width: 20%">${classandcourse5.teachername}</span>
						<a class="submitSign" style="width: 20%;color: #F7001E"
							userclassid="${user.classesid }"
							 weekday="${classandcourse5.weekday}"
							classid="${classandcourse5.classid}" userid="${classandcourse5.teacherid}" coursecode="${classandcourse5.coursecode}" starttime="${classandcourse5.starttime}"
							><em class="clickbtn hot">签到</em></a>
						</li>
					
					
						</c:forEach>
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
<script type="text/javascript" src="${contextpath}/js/plugins/layui/css/signcss/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${contextpath}/js/plugins/layui/css/signcss/tab.js"></script>

<script>
$(function(){
    //格式化当前时间
/* 	function getFormatDate(){  
	    var nowDate = new Date();   
	   // var year = nowDate.getFullYear();  
	   // var month = nowDate.getMonth() + 1 < 10 ? "0" + (nowDate.getMonth() + 1) : nowDate.getMonth() + 1;  
	   // var date = nowDate.getDate() < 10 ? "0" + nowDate.getDate() : nowDate.getDate();  
	    var hour = nowDate.getHours()< 10 ? "0" + nowDate.getHours() : nowDate.getHours();  
	    var minute = nowDate.getMinutes()< 10 ? "0" + nowDate.getMinutes() : nowDate.getMinutes();  
	  //  var second = nowDate.getSeconds()< 10 ? "0" + nowDate.getSeconds() : nowDate.getSeconds();  
	    return hour+":"+minute;  
	}
	var str = getFormatDate();
	console.log(str); */
 
	var starttime=$(".submitSign").attr("starttime");
	console.log("数据库时间"+starttime);
	var nowDate=new Date();
	var str=nowDate.getHours()+":"+nowDate.getMinutes();
	console.log(typeof str);
	console.log("当前时间"+str);
	var userclassesid=$(".submitSign").attr("userclassid");
	console.log("当前登录学生的班级id:"+userclassesid);
	$.ajax({
		method:"POST",
		data:{
			userclassid:userclassesid			
		},
	     url:"${contextpath }/user/getuserclassid",
	     dataType:"json",
	});
	
	
	$(".submitSign").click(function(){
		
		alert("点击");
		var classid=$(this).attr("classid");
		var coursecode=$(this).attr("coursecode");
		var userid=$(this).attr("userid");
		var starttime=$(this).attr("starttime");
		var weekday = $(this).attr("weekday");
		
		//判断签到学生上课情况
		/* time(starttime,weekday,classid,coursecode,userid); */
		var starttimeHours = starttime.slice(11,13);
		var starttimeMinutes = starttime.slice(14,16);
		starttimeHours = parseInt(starttimeHours); 
		starttimeMinutes =  parseInt(starttimeMinutes);
		var start = starttimeHours*60 + starttimeMinutes;
		var nowDate=new Date();
		var day = nowDate.getDay(); 

		 alert(day); 
			for(var a = 1;a<=7;a++) {
				if(day==1) {
					day="星期一"
				}
				if(day==2) {
					day="星期二"
				}
				if(day==3) {
					day="星期三"
				}
				if(day==4) {
					day="星期四"
				}
				if(day==5) {
					day="星期五"
				}
				if(day==6) {
					day="星期六"
				}
				if(day==0) {
					day="星期日"
				}
			}		
				if(day == weekday) {
					var nowDateHours=nowDate.getHours();
					var	nowDateMinutes = nowDate.getMinutes();
					var now = nowDateHours*60 + nowDateMinutes;
					var beforecoursetime=start-10;
					if(beforecoursetime<=now&&start>=now){
						alert("签到成功");
						$(this).css("display","none");
						 $.ajax({
							  method:"POST",
							  data:{  
								  userid:userid,
								  classesid:classid,
								  coursecode:coursecode,
								  coursetime:starttime
							  },
							  url:"${contextpath }/user/submitUserSign.do",
							  dataType:"json",		  	  
						  });
					} else if(start+45>=now&&now>start) {
						alert("你迟到了");
						$(this).css("display","none");
						 $.ajax({
							  method:"POST",
							  data:{  
								  userid:userid,
								  classesid:classid,
								  coursecode:coursecode,
								  coursetime:starttime
							  },
							  url:"${contextpath }/user/submitUserSign.do",
							  dataType:"json",		  	  
						  });
					} else{
						alert("你旷课了");
						$(this).css("display","none");
						 $.ajax({
							  method:"POST",
							  data:{  
								  userid:userid,
								  classesid:classid,
								  coursecode:coursecode,
								  coursetime:starttime
							  },
							  url:"${contextpath }/user/submitUserSign.do",
							  dataType:"json",		  	  
						  });
					}
					
				} else {
					alert("星期不符");
				}
	  });
});

 /* function time(starttime,weekday,classid,coursecode,userid){
	var starttimeHours = starttime.slice(11,13);
	var starttimeMinutes = starttime.slice(14,16);
	starttimeHours = parseInt(starttimeHours); 
	starttimeMinutes =  parseInt(starttimeMinutes);
	var start = starttimeHours*60 + starttimeMinutes;
	var nowDate=new Date();
	var day = nowDate.getDay(); 

	 alert(day); 
		for(var a = 1;a<=7;a++) {
			if(day==1) {
				day="星期一"
			}
			if(day==2) {
				day="星期二"
			}
			if(day==3) {
				day="星期三"
			}
			if(day==4) {
				day="星期四"
			}
			if(day==5) {
				day="星期五"
			}
			if(day==6) {
				day="星期六"
			}
			if(day==0) {
				day="星期日"
			}
		}		
			if(day == weekday) {
				var nowDateHours=nowDate.getHours();
				var	nowDateMinutes = nowDate.getMinutes();
				var now = nowDateHours*60 + nowDateMinutes;
				var beforecoursetime=start-10;
				if(beforecoursetime<=now&&start>=now){
					alert("签到成功");
					$(this).css("display","none");
					 $.ajax({
						  method:"POST",
						  data:{  
							  userid:userid,
							  classesid:classid,
							  coursecode:coursecode,
							  coursetime:starttime
						  },
						  url:"${contextpath }/user/submitUserSign.do",
						  dataType:"json",		  	  
					  });
				} else if(start+45>=now&&now>start) {
					alert("你迟到了");
					$(this).css("display","none");
					 $.ajax({
						  method:"POST",
						  data:{  
							  userid:userid,
							  classesid:classid,
							  coursecode:coursecode,
							  coursetime:starttime
						  },
						  url:"${contextpath }/user/submitUserSign.do",
						  dataType:"json",		  	  
					  });
				} else{
					alert("你旷课了");
					$(".submitSign").css("display","none");
					 $.ajax({
						  method:"POST",
						  data:{  
							  userid:userid,
							  classesid:classid,
							  coursecode:coursecode,
							  coursetime:starttime
						  },
						  url:"${contextpath }/user/submitUserSign.do",
						  dataType:"json",		  	  
					  });
				}
				
			} else {
				alert("星期不符");
			}
	
	
}  */
</script>

</body>
</html>