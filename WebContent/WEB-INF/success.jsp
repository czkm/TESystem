<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextpath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error</title>
 <link rel="stylesheet" href="${contextpath}/js/plugins/amazeui/css/amazeui.min.css">
    <link rel="stylesheet" href="${contextpath}/js/plugins/amazeui/css/app.css">
</head>
<body>
<div class="am-container">
    <img  src="${contextpath}/images/bannerbgr.png" alt="泉州信息工程学院奖学金申请" title="泉州信息工程学院奖学金申请" width="1170px" height="207px">
    <h1>${message}<span id="totalSecond">3</span>秒后自动返回</h1>
    <footer>
        <img src="${contextpath}/images/footer.png"  alt="泉州信息工程学院奖学金申请" title="泉州信息工程学院奖学金申请" width="1170px" height="207px">
    </footer>
</div>

  
</body>
<script language="javascript" type="text/javascript">

    var second = document.getElementById('totalSecond').innerText;
   
    setInterval("redirect()", 1000); //每1秒钟调用redirect()方法一次
    function redirect()
    {
        if (second < 0)
        {
            location.href = '${contextpath}/toscholarship';
        } else
        {
              document.getElementById('totalSecond').innerText = second--;
        }
    }

</script>

</html>
