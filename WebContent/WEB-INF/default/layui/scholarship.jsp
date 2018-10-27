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
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新生入学奖学金申请登记</title>
<!-- Set render engine for 360 browser -->
<meta name="renderer" content="webkit">

<!-- No Baidu Siteapp-->
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="icon" type="image/png"
	href="${contextpath}/js/plugins/amazeui/i/favicon.png">

<!-- Add to homescreen for Chrome on Android -->
<meta name="mobile-web-app-capable" content="yes">
<link rel="icon" sizes="192x192"
	href="${contextpath}/js/plugins/amazeui/i/app-icon72x72@2x.png">

<!-- Add to homescreen for Safari on iOS -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="apple-touch-icon-precomposed"
	href="${contextpath}/js/plugins/amazeui/i/app-icon72x72@2x.png">

<!-- Tile icon for Win8 (144x144 + tile color) -->
<meta name="msapplication-TileImage"
	content="${contextpath}/js/plugins/amazeui/i/app-icon72x72@2x.png">
<meta name="msapplication-TileColor" content="#0e90d2">

<link rel="stylesheet"
	href="${contextpath}/js/plugins/amazeui/css/amazeui.min.css">
<link rel="stylesheet"
	href="${contextpath}/js/plugins/validform5.1/validform.css">
<link rel="stylesheet"
	href="${contextpath}/js/plugins/amazeui/css/app.css">
</head>
<body>
	<div class="am-container">
		<img src="${contextpath}/images/bannerbgr.png" alt="泉州信息工程学院奖学金申请"
			title="泉州信息工程学院奖学金申请" width="100%" height="100%">
	</div>
	<div class="am-container">
		<div class="am-panel am-panel-primary">
			<div class="am-panel-hd">
				<h3 class="am-panel-title">新生入学奖学金申请登记</h3>
			</div>
			<div class="am-panel-bd">

				<c:choose>
					<c:when test="${isOpen }">
						<h1 style='text-align: center; color: red'>
							重要通知： 这批次申请奖学金
							<fmt:formatDate value="${endtime }" pattern="yyyy-MM-dd" />
							前申请有效，其它的无效，下一批次申请等待招生网通知。
						</h1>

						<form class="am-form am-form-horizontal" method="post"
							action="${contextpath }/scholarship/add">

							<div class="am-form-group">
								<label for="doc-ipt-3" class="am-u-sm-4 am-form-label">姓名</label>
								<div class="am-u-sm-8">
									<input type="text" id="doc-ipt-3" name="name"
										placeholder="输入你的姓名" class="inputxt"
										datatype="/^[\u4E00-\u9FA5\uf900-\ufa2d]{2,6}$/"
										errormsg="请输入你的名称">
								</div>
							</div>

							<div class="am-form-group">
								<label for="doc-ipt-studentNO-2" class="am-u-sm-4 am-form-label">考生号</label>
								<div class="am-u-sm-8">
									<input type="text" id="doc-ipt-studentNO-2" name="studentno"
										placeholder="输入你的考生号" class="inputxt" datatype="s14-15"
										errormsg="考生号14个字符！">
								</div>
							</div>
							<div class="am-form-group">
								<label for="doc-ipt-studentType-2"
									class="am-u-sm-4 am-form-label">科类</label>
								<div class="am-u-sm-8">
									<select id="doc-ipt-studentType-2" name="studenttype"
										datatype="*" nullmsg="请选择科类！" errormsg="请选择科类！">
										<option value="-1">请选择科类</option>
										<option value="文史">文史</option>
										<option value="理工">理工</option>
									</select>
								</div>
							</div>
							<div class="am-form-group">
								<label for="doc-ipt-grade-2" class="am-u-sm-4 am-form-label">高考分数</label>
								<div class="am-u-sm-8">
									<input type="text" id="doc-ipt-grade-2" name="grade"
										placeholder="输入你的高考分数" datatype="n" errormsg="必须输入的是你的高考分数">
								</div>
							</div>
							<div class="am-form-group">
								<label for="doc-ipt-batch1-2" class="am-u-sm-4 am-form-label">预填报志愿</label>
								<div class="am-u-sm-8">
									<select data-am-selected id="doc-ipt-batch1-2" name="batch">
										<option value="A">A</option>
										<option value="B">B</option>
										<option value="C">C</option>
										<option value="D" selected>D</option>
										<option value="E">E</option>
										<option value="F">F</option>
										<option value="G">G</option>
										<option value="H">H</option>
										<option value="I">I</option>
										<option value="J">J</option>

									</select>
								</div>
							</div>
							<div class="am-form-group">
								<label for="doc-ipt-marjor1-2" class="am-u-sm-4 am-form-label">预填专业</label>
								<div class="am-u-sm-8">
									<select id="doc-ipt-marjor1-2">
										<option value="金融工程">金融工程</option>
										<option value="工程造价">工程造价</option>
										<option value="软件工程">软件工程</option>
										<option value="物流管理">物流管理</option>
										<option value="电子商务">电子商务</option>
										<option value="国际商务">国际商务</option>
										<option value="投资学">投资学</option>
										<option value="审计学">审计学</option>
									</select> <select id="doc-ipt-marjor2-2" style="display: none">
										<option value="机械设计制造及其自动化">机械设计制造及其自动化</option>
										<option value="电气工程及其自动化">电气工程及其自动化</option>
										<option value="光电信息科学与工程">光电信息科学与工程</option>
										<option value="建筑电气与智能化">建筑电气与智能化</option>
										<option value="通信工程">通信工程</option>
										<option value="电子信息工程">电子信息工程</option>
										<option value="物流管理">物流管理</option>
										<option value="工程造价">工程造价</option>
										<option value="材料成型及控制工程">材料成型及控制工程</option>
										<option value="土木工程">土木工程</option>
										<option value="国际商务">软件工程</option>
										<option value="物联网工程">物联网工程</option>
										<option value="国际商务">国际商务</option>
										<option value="网络工程">网络工程</option>
										<option value="电子商务">电子商务</option>
										<option value="金融工程">金融工程</option>
										<option value="机器人工程">机器人工程</option>
										<option value="汽车服务工程">汽车服务工程</option>
										<option value="投资学">投资学</option>
										<option value="审计学">审计学</option>
									</select>
								</div>
							</div>
							<div class="am-form-group">
								<label for="doc-ipt-contact-2" class="am-u-sm-4 am-form-label">联系方式</label>
								<div class="am-u-sm-8">
									<input type="text" id="doc-ipt-contact-2" name="contact"
										placeholder="输入你的联系方式" datatype="*">
								</div>
							</div>

							<div class="am-form-group">
								<div class="am-u-sm-10 am-u-sm-offset-2">
									<button type="submit" class="am-btn am-btn-default">信息提交</button>
									<span id="showerror"></span>
								</div>
							</div>
						</form>
			</div>
		</div>

		</c:when>
		<c:otherwise>
			<h1 style='text-align: center; color: red'>
				对不起，新生入学奖学金申请登记已经关闭，具体情况查看<a href="http://qziedu.cn/">泉州信息工程学院官网</a>
			</h1>

		</c:otherwise>

		</c:choose>


		<footer>
			<img src="${contextpath}/images/footer.png" alt="泉州信息工程学院奖学金申请"
				title="泉州信息工程学院奖学金申请" width="100%" height="100%">
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
	<script
		src="${contextpath}/js/plugins/validform5.1/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript">
		$(function() {

			$("#doc-ipt-studentType-2").change(function() {

				if ($(this).val() == "文史") {

					$("#doc-ipt-marjor2-2").css("display", "none")
					$('#doc-ipt-marjor2-2').attr("name", "mymajor");
					$("#doc-ipt-marjor1-2").css("display", "block")
					$('#doc-ipt-marjor1-2').attr("name", "marjor");

				} else if ($(this).val() == "理工") {

					$("#doc-ipt-marjor2-2").css("display", "block")
					$('#doc-ipt-marjor2-2').attr("name", "marjor");
					$("#doc-ipt-marjor1-2").css("display", "none")
					$('#doc-ipt-marjor1-2').attr("name", "mymajor");
				} else {
					alert("请选择课类");
				}

			});

		});
		$(function() {
			//$(".registerform").Validform();  //就这一行代码！;
			var flag = false;
			$(".am-form").Validform({
				tiptype : function(msg, o, cssctl) {
					var objtip = $("#showerror ");
					cssctl(objtip, o.type);
					objtip.text(msg);
				},
				beforeSubmit : function(curform) {
					//在验证成功后，表单提交前执行的函数，curform参数是当前表单对象。
					//这里明确return false的话表单将不会提交;

					if ($("#doc-ipt-studentType-2").val() == -1) {
						alert("请选择课类");
						flag = false;
						return flag;
					}

				}
			});
		})
	</script>
</body>
</html>