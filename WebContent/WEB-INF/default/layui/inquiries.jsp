<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="viewport"
          content="width=device-width, initial-scale=1">
    <title>新生录取查询</title>
    
     <!-- Set render engine for 360 browser -->
    <meta name="renderer" content="webkit">

    <!-- No Baidu Siteapp-->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>

    <link rel="icon" type="image/png" href="${contextpath}/js/plugins/amazeui/i/favicon.png">

    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="${contextpath}/js/plugins/amazeui/i/app-icon72x72@2x.png">

    <!-- Add to homescreen for Safari on iOS -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="apple-touch-icon-precomposed" href="${contextpath}/js/plugins/amazeui/i/app-icon72x72@2x.png">

    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <meta name="msapplication-TileImage" content="${contextpath}/js/plugins/amazeui/i/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#0e90d2">

    <link rel="stylesheet" href="${contextpath}/js/plugins/amazeui/css/amazeui.min.css">
    <link rel="stylesheet" href="${contextpath}/js/plugins/validform5.1/validform.css">
    <link rel="stylesheet" href="${contextpath}/js/plugins/amazeui/css/app.css">
</head>
<body>
<div class="am-container">
    <img  src="${contextpath}/images/bannerbgr.png" alt="泉州信息工程学院奖学金申请" title="泉州信息工程学院奖学金申请" width="100%" height="100%">
</div>
<div class="am-container">
    <div class="am-panel am-panel-primary">
        <div class="am-panel-hd"><h3 class="am-panel-title">泉州信息工程学院录取查询</h3></div>
        <div class="am-panel-bd">
            <ul class="am-avg-md-2">
                <li>
                    <form class="am-form am-form-horizontal">
                        <!-- am-form-group 的基础上添加了 am-form-group-sm -->
                        <div class="am-form-group am-form-group-sm">
                            <label for="doc-name1-3-1" class="am-u-sm-4 am-form-label">考生姓名</label>
                            <div class="am-u-sm-8">
                                <input type="text" id="doc-name1-3-1" class="am-form-field" placeholder="输入你的姓名" >
                            </div>
                        </div>

                        <!-- am-form-group 的基础上添加了 am-form-group-lg -->
                        <div class="am-form-group am-form-group-sm">
                            <label for="doc-ipt-name2-21" class="am-u-sm-4 am-form-label">考生号</label>
                            <div class="am-u-sm-8">
                                <input type="text" id="doc-ipt-name2-21" class="am-form-field" placeholder="输入你的考生号" >
                            </div>
                        </div>

                        <div class="am-form-group">
                            <div class="am-u-sm-10 am-u-sm-offset-2" style="align-content: center">
                                <button type="button" class="am-btn am-btn-primary am-fl" id="recruitQuery">查询</button><button type="reset" class="am-btn am-btn-warning am-fr">重置</button><span  id="showerror"></span>
                            </div>
                        </div>
                    </form>

                </li>
                <li>
                    <dl>
                        <dt>
                            咨询电话：0595-22789708、22789808、22789648（传真）

                        </dt>
                        <dd>

                            请各位考生核对录取通知书寄送地址，如果有问题可致电招生办。录取通知书寄送后，考生可在录取查询查询顺丰快递单号。

                        </dd>
                    </dl>


                </li>

            </ul>
        </div>
        <footer class="am-panel-footer" id="result">


        </footer>
    </div>
     <footer>
        <img src="${contextpath}/images/footer.png"  alt="泉州信息工程学院奖学金申请" title="泉州信息工程学院奖学金申请" width="100%" height="100%">
    </footer>
</div>
    
    <!--在这里编写你的代码-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script type="text/javascript"
		src="${contextpath}/js/jquery-3.2.1.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="${contextpath}/js/plugins/amazeui/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="${contextpath}/js/plugins/amazeui/js/amazeui.min.js"></script>
<script src="${contextpath}/js/plugins/validform5.1/Validform_v5.3.2_min.js"></script>
<script src="${contextpath}/js/plugins/layui/layui.js"></script>
<script>
    $(function () {
        $(".am-form").Validform({
            tiptype:function(msg,o,cssctl){
                var objtip=$("#showerror ");
                cssctl(objtip,o.type);
                objtip.text(msg);
            }
        });
        $("#recruitQuery").click(function () {
            $("#result").html("");
            var name1=$("#doc-name1-3-1").val();
            var studentno1=$("#doc-ipt-name2-21").val();
            $.ajax({
  			  method:"POST",
  			  data:{  
  				  name:name1,
  				  studentno:studentno1
  			  },
  			  url:"${contextpath }/recruit/query",
  			  dataType:"json",
  		
  			  success:function(res){
  				 if(res!=null){
  					 var html="<table class='am-table am-table-striped am-table-hover'> <thead> <tr><th>考生姓名</th> <th>考生证号</th> <th>录取专业</th> <th>高考分数</th> <th>家庭地址</th> <th>联系电话</th> <th>顺丰快递</th> </tr> </thead>";
  	                 html+="  <tr> <td>"+res.name+"</td> <td>"+res.studentno+"</td> <td>"+res.major+"</td> <td>"+res.score+"</td> <td>"+res.address+"</td> <td>"+res.mobile+"</td> <td>"+res.ems+"</td>";
  	                 html+="</table>"; 
  	               $("#result").append(html);
  				 }
  				 else{
  					 
  					$("#result").append("无数据,请输入正确的考生姓名和考生号"); 
  				 }
  			
                 
  			    
  			  },
  			  complete:function(){
  		    		
  		    		
  	    		  
  	    	}
  			  
  			  
  		  });

        });
        
    });
    
</script>
</script>
</body>
</html>