<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>新生招生录取管理</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
 <meta name="keywords" content="新生招生录取管理，教师测评系统,教务处,软件学院，泉州信息工程学院">
<meta name="description"
	content="新生招生录取管理，教师测评系统,教务处,软件学院，泉州信息工程学院">
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
        <!--   <dd><a href="javascript:;"><i class="layui-icon">&#xe620;</i>基本设置</a></dd>
          <dd><a href="javascript:;"><i class="iconfont icon-tongzhi" style="top: 4px;"></i>我的消息</a></dd>
          <dd><a href="javascript:;"><i class="layui-icon" style="margin-left: 2px; font-size: 22px;">&#xe68e;</i>我的主页</a></dd>
          <hr style="margin: 5px 0;"> -->
          <dd><a href="${contextpath}/tologinout" style="text-align: center;" >安全退出</a></dd>
        </dl>
      </li>
    </ul>
  </div>
</div>

<div class="layui-container fly-marginTop fly-user-main">
  <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
   
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
        <li data-type="mine-jie" lay-id="index" class="layui-this">新生申请奖学金结果</li>
        <li data-type="collection"  lay-id="collection">新生录取数据管理</li>
      </ul>
      <div class="layui-tab-content" style="padding: 20px 0;">
        <div class="layui-tab-item layui-show">
						<table class="layui-table">
							<colgroup>
								<col width="150">
								<col >
								<col >
								<col >
								<col >
								<col >
								<col >
								<col width="150">
							</colgroup>
							<thead>
							   
								<tr>
									<th>姓名</th>
									<th>考生号</th>
								    <th>类型</th>
								    <th>分数</th>
								    <th>专业</th>
								    <th>批次</th>
								    <th>联系电话</th>
								    <th>时间</th>
								</tr>
							</thead>
							<tbody>
							 <tr>
							    <td colspan="8">
							      <a href="${contextpath }/file/exportScholarshipExcel"
								class="layui-btn layui-btn-primary">导出申请奖学金学生数据</a>
								
								  <a href="javascript:;"
								class="layui-btn layui-btn-primary"  lay-filter="clearSholarship" lay-submit>清空数据数据</a>
							   </td>
							  
							    </td>
							    </tr>
							<c:choose>
							<c:when test="${scholarships!=null&&scholarships.size()>0 }">
							<c:forEach items="${scholarships }"  var="vo">
								<tr>
									<td>${vo.name }</td>
									<td>${vo.studentno }</td>
									<td>${vo.studenttype }</td>
									<td>${vo.grade }</td>
									<td>${vo.marjor }</td>
									<td>${vo.batch }</td>
									<td>${vo.contact }</td>
									<td><fmt:formatDate value="${vo.createtime }" pattern="yyyy-MM-dd"/></td>
								</tr>
								</c:forEach>
							
							</c:when>
							<c:otherwise>
							
							<tr>
									<td colspan="8">
									很遗憾，新生还没有进行申请
									</td>
								</tr>
							</c:otherwise>
							
							</c:choose>
							
							</tbody>
						</table>
        
        
        
          <div id="echart" style="height:500px;width:100%;">

          </div>
      
        </div>
        <div class="layui-tab-item">
          <table class="layui-table">
							<colgroup>
							    <col width="100">
							    <col >
							    <col >
								<col >
								<col >
								<col >
								<col width="150">
								<col width="200">
							</colgroup>
							<thead>
							  
								<tr>
								   <th>考生号</th>
									<th>名称</th>
									
									<th>专业</th>
									<th>电话</th>
									<th>地址</th>
									<th>成绩</th>
								    <th>录取时间</th>
								    <th>顺丰快递</th>
								</tr>
							</thead>
							<tbody>
							 <tr>
							   <td colspan="8">
							    <button type="button" class="layui-btn" id="importExcel">
								<i class="layui-icon">&#xe67c;</i>导入录取数据
							</button>
							  <a href="javascript:;"
								class="layui-btn layui-btn-primary"  lay-filter="clearIncome" lay-submit>清空数据数据</a>
							</td>
							   </tr>
							<c:choose>
							<c:when test="${recruits!=null&&recruits.size()>0 }">
								<c:forEach items="${recruits }"  var="vo">
								<tr>
								   <td>${vo.studentno }</td>
									<td>${vo.name }</td>
									
									<td>${vo.major }</td>
									<td>${vo.mobile }</td>
									<td>${vo.address }</td>
									<td>${vo.score }</td>									
									<td><fmt:formatDate value="${vo.inschool }" pattern="yyyy-MM-dd"/></td>
									<td>${vo.ems }</td>
								</tr>
								</c:forEach>
								</c:when>
						
						    <c:otherwise>
						    
						    <tr>
								<td colspan="8">
								录取数据还没有导入
								
								</td>
								</tr>
						    </c:otherwise>
						    	</c:choose>
							</tbody>
						</table>
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
<script src="${contextpath}/js/echarts.min.js"></script>

<script src="${contextpath}/js/plugins/layui/layui.js"></script>


<script>
layui.use(['form','element'], function(){
	  var element = layui.element;
	  var form=layui.form;
	  
	  form.on('submit(clearIncome)', function(data){
		  $.ajax({
		    	method:"POST",
		    	url:"${contextpath}/recruit/clear",
		    	dataType:"application/json,charset=utf-8",
		    	dataType:"json",
		    	beforeSend:function(){
		    		layer.load(); //上传loading
		    	},
		    	success:function(res){
		    		
		    		if(res.statusCode==1){    			
		    			layer.msg(res.message,{icon:1}, function(){
		    				
		    				window.location.reload();
		    			
		    				}); 
		    			
		    		}
		    		
		    		
		    	},
		    	complete:function(){
		    		
		    		
		    		   layer.closeAll('loading'); //关闭loading
		    	}
		    	
		    	
		    });
		    return false;
		  
		  });
	  

	  

	  
	    
	  form.on('submit(clearSholarship)', function(data){
		  $.ajax({
		    	method:"POST",
		    	url:"${contextpath}/scholarship/clear",
		    	dataType:"application/json,charset=utf-8",
		    	dataType:"json",
		    	beforeSend:function(){
		    		layer.load(); //上传loading
		    	},
		    	success:function(res){
		    		
		    		if(res.statusCode==1){    			
                        layer.msg(res.message,{icon:1}, function(){
		    				
		    				window.location.reload();
		    			
		    				}); 
		    		}
		    		
		    		
		    	},
		    	complete:function(){
		    		
		    		
		    		   layer.closeAll('loading'); //关闭loading
		    	}
		    	
		    	
		    });
		    return false;
		  
		  });
	  
	 });
layui.use('upload', function() {
	var upload = layui.upload;

	//执行实例
	var uploadInst = upload.render({
		elem : '#importExcel' //绑定元素
		,
		url : "${contextpath }/file/ajaxRecruitExcel" //上传接口
		,
		before : function(obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
			layer.load(); //上传loading
		},
		done : function(res) {
			if (res.statusCode == 1) {
				layer.msg(res.message,{icon:1}, function(){
    				
    				window.location.reload();
    			
    				}); 
			}
			if (res.statusCode == 2) {
				 layer.msg(res.message,{icon:2}); 
				 layer.closeAll("loading");
			}
		},
		accept : "file",
		error : function() {
			//请求异常回调
			layer.msg(res.message,{icon:2}); 
			layer.closeAll("loading");
		}
	});
});

	

</script>

</body>
</html>