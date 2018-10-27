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
<title>教师测评结果</title>
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
					href="javascript:;"> <cite class="layui-hide-xs"> <c:if
								test="${sessionScope.user!=null}">
           ${sessionScope.user.username}
           </c:if> <c:if test="${sessionScope.user==null}">
								<%-- <c:redirect url="${ contextpath}/tologin"></c:redirect> --%>
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
						<dd>
							<a href="${contextpath}/tologinout" style="text-align: center;">安全退出</a>
						</dd>
					</dl></li>
			</ul>
		</div>
	</div>

	<div class="layui-container fly-marginTop fly-user-main">
	<%-- <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
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
    <li class="layui-nav-item layui-this">
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
   <li class="layui-nav-item layui-this">
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
 --%>
		<div class="site-tree-mobile layui-hide">
			<i class="layui-icon">&#xe602;</i>
		</div>
		<div class="site-mobile-shade"></div>

		<div class="site-tree-mobile layui-hide">
			<i class="layui-icon">&#xe602;</i>
		</div>
		<div class="site-mobile-shade"></div>


		<div class="fly-panel fly-panel-user" pad20 style="margin-left: 15px">
			<!--
    <div class="fly-msg" style="margin-top: 15px;">
      您的邮箱尚未验证，这比较影响您的帐号安全，<a href="activate.html">立即去激活？</a>
    </div>
    -->
    
    <div class="layui-tab">
  <ul class="layui-tab-title">
     <li class="layui-this">学院教师测评结果</li>
     <li>学校教师测评结果(<span>${teacherCount }</span>)</li>
     <li>学校教师评学结果(<span>${classesCount }</span>)</li>
     <li>学校教师互评结果(<span>${betweenTeacherCount }</span>)</li>
  </ul>
  <div class="layui-tab-content">
    <div class="layui-tab-item layui-show">
					<div class="layui-card">
						<div class="layui-card-header">
						<form class="layui-form">
									<div class="layui-form-item">
										<label class="layui-form-label">选择部门</label>
										<div class="layui-input-block">
											<select name="departId" lay-filter="depart" id="depart">
											    <c:forEach items="${departments }" var="department">
											    <option value="${ department.id}">${department.departName }</option>
											    </c:forEach>
												
											</select>
										</div>
									</div>
								</form>
						
						</div>
						<div class="layui-card-body">
							 <div id="echart" style="height:500px;width:100%;">

          </div>
						</div>
					</div>
    
    
    
    </div>
    <div class="layui-tab-item">
    
     <table class="layui-table">
							<colgroup>
								<col width="200" >
								<col >
								<col >
								<col >
								<col >
								<col width="200">
							</colgroup>
							<tr>
							<td colspan="6">
							<a class="layui-btn" href="${contextpath }/file/exportAssessExcel">导出教师测评数据及学生提交比例</a>
							
							<a class="layui-btn" href="${contextpath }/file/exportTeacherClassesStudentSubmitRateExcel">导出教师授课班级学生提交比例</a>
							</td>
							</tr>
							<thead>
								<tr>
									<th>教师名称</th>
									<th>测评分数</th>
									<th>提交人数</th>
									<th>总人数</th>
									<th>提交比率</th>
								    <th>部门</th>
								</tr>
							</thead>
							<tbody>
							<c:choose>
							<c:when test="${allTeacherGetScoreVOs!=null&&allTeacherGetScoreVOs.size()>0 }">
								<c:forEach items="${allTeacherGetScoreVOs }"  var="vo">
								<tr>
									<td>${vo.username }</td>
									<td>${vo.score }</td>
									<td>${vo.studentSubmitCount }</td>
									<td>${vo.studentCount }</td>
									<td><fmt:formatNumber 	 value="${vo.rate }" type="percent" /></td>
									<td>${vo.departName }</td>
										
								</tr>
								<c:forEach items="${vo.queryClassesRateofStudentSubmits }" var="voo">
								<tr>
								    <td></td>
									<td>${voo.classesName }</td>
									<td>${voo.studentSubmitCount }</td>
									<td>${voo.studentCount }</td>
									<td><fmt:formatNumber 	 value="${voo.rate }" type="percent" /></td>
									<td>${vo.departName }</td>
								
								</tr>
									</c:forEach>
								</c:forEach>
								</c:when>
						
						    <c:otherwise>
						    
						    <tr>
								<td colspan="6">
								   很遗憾，你的任务还没有开始，需要多多努力
								
								</td>
								</tr>
						    </c:otherwise>
						    	</c:choose>
							</tbody>
						</table>
    
    
    </div>
   <div class="layui-tab-item">
   
            <table class="layui-table">
							<colgroup>
								<col width="200" >
								<col >
								<col width="200">
							</colgroup>
							<tr>
							<td colspan="6"><a class="layui-btn" href="${contextpath }/file/exportClassesExcel">导出教师评学数据</a></td>
							</tr>
							<thead>
								<tr>
									<th>班级名称</th>
									<th>评学分数</th>
								
								    <th>所属部门</th>
								</tr>
							</thead>
							<tbody>
							<c:choose>
							<c:when test="${allClassesGetScoreVOs!=null&&allClassesGetScoreVOs.size()>0 }">
								<c:forEach items="${allClassesGetScoreVOs }"  var="vo">
								<tr>
									<td>${vo.classesName }</td>
									
									<td>${vo.scorce }</td>
									
									<td>${vo.departName }</td>
								</tr>
								</c:forEach>
								</c:when>
						
						    <c:otherwise>
						    
						    <tr>
								<td colspan="3">
								  还没有数据
								
								</td>
								</tr>
						    </c:otherwise>
						    	</c:choose>
							</tbody>
						</table>
   </div>
   
    <div class="layui-tab-item">
   
            <table class="layui-table">
							<colgroup>
								<col width="200" >
								<col >
								<col width="200">
							</colgroup>
							<tr>
							<td colspan="3"><a class="layui-btn" href="${contextpath }/file/exportBetweenAssessExcel">导出教师互评数据结果</a></td>
							</tr>
							<thead>
								<tr>
									<th>教师名称</th>
									<th>测评分数</th>
								
								    <th>所属部门</th>
								</tr>
							</thead>
							<tbody>
							<c:choose>
							<c:when test="${betweenTeacherGetScoreVOs!=null&&betweenTeacherGetScoreVOs.size()>0 }">
								<c:forEach items="${betweenTeacherGetScoreVOs }"  var="vo">
								<tr>
									<td>${vo.username }</td>
									
									<td>${vo.score }</td>
									
									<td>${vo.departName }</td>
								</tr>
								</c:forEach>
								</c:when>
						
						    <c:otherwise>
						    
						    <tr>
								<td colspan="3">
								  还没有数据
								
								</td>
								</tr>
						    </c:otherwise>
						    	</c:choose>
							</tbody>
						</table>
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
<script src="${contextpath}/js/echarts.min.js"></script>
<script type="text/javascript">

$("#depart").change(function(){
	
	alert($(this).value)
	
	
})

</script>

	<script src="${contextpath}/js/plugins/layui/layui.js"></script>
	<script>
	layui.use(['form','element'], function(){
		  var form = layui.form;
		  var element = layui.element;
		  form.on('select(depart)', function(data){
			  initEcharts(data.value)
			});
		 
		});
	
	

	  var echarts = echarts.init(document.getElementById('echart'));	
	initEcharts();
	function initEcharts(id){
		id=id||1
        echarts.clear();
        echarts.showLoading({text: '正在努力的读取数据中...'});
       $.ajax({
           url:"${contextpath}/user/scoreofteacherbydepartBar?departId="+id,
           type:"post",
           success:function(data){
             if(data!="-1"){
               var option = eval("("+data+")");
               echarts.setOption(option);
               echarts.hideLoading();
             }
             else{
             
              echarts.hideLoading();
             }
              

           }

       })

   }  
	</script>

</body>
</html>