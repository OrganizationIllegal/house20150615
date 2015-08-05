<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>加入我们-海房优选-海外房产优选</title> 
   <meta name="description" content="加入我们-海房优选-海外房产优选" />
   <meta name="keywords" content="海外买房,澳洲买房,海外房产投资新工具" />
 <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<link href="css/newstyle.css" rel="stylesheet">
</head>

<body style="background:rgb(232, 233, 234);">
<%-- <jsp:include page="head2_new.jsp" /> --%>
<jsp:include page="head4index.jsp" />
<div style="width:1190px;margin:0 auto; background:#fff;margin-top:40px;">
<div style="width:800px;margin:0 auto; padding-top:90px;min-height:700px;">
<div style="font-size:18px;font-wight:bold;border-bottom:1px solid rgba(238, 238, 238, 1);height:40px;color:#000;">现有职位空缺</div>
<div style="font-size:12px;letter-spacing:1px;border-bottom:1px solid rgba(238, 238, 238, 1);padding:6px 0;color:rgb(137,137,137);">非常感谢浏览我们的职位空缺。如果对任何职位感兴趣，请发送邮件至：<span style="font-size:15px;">job@haifangbest.com</span></div>
<div class="" style="height:50px;padding:13px 0px;margin:0px;border-bottom:1px solid rgba(238, 238, 238, 1);font-size:15px;">
	<div class="fl w450"><div style="color:rgb(51,122,183);">网页前端开发</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">技术部</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">技术</div></div>
	<div class="fl"><div style="color:rgb(137,137,137);text-align:right;">北京</div></div>
</div>
<div class="" style="height:50px;padding:13px 0px;margin:0px;border-bottom:1px solid rgba(238, 238, 238, 1);font-size:15px;">
	<div class="fl w450"><div style="color:rgb(51,122,183);">移动IOS开发</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">技术部</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">技术</div></div>
	<div class="fl"><div style="color:rgb(137,137,137);text-align:right;">北京</div></div>
</div>
<div class="" style="height:50px;padding:13px 0px;margin:0px;border-bottom:1px solid rgba(238, 238, 238, 1);font-size:15px;">
	<div class="fl w450"><div style="color:rgb(51,122,183);">网站美工</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">设计部</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">设计</div></div>
	<div class="fl"><div style="color:rgb(137,137,137);text-align:right;">北京</div></div>
</div>
<div class="" style="height:50px;padding:13px 0px;margin:0px;border-bottom:1px solid rgba(238, 238, 238, 1);font-size:15px;">
	<div class="fl w450"><div style="color:rgb(51,122,183);">网站推广</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">市场部</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">市场</div></div>
	<div class="fl"><div style="color:rgb(137,137,137);text-align:right;">北京</div></div>
</div>
<div class="" style="height:50px;padding:13px 0px;margin:0px;border-bottom:1px solid rgba(238, 238, 238, 1);font-size:15px;">
	<div class="fl w450"><div style="color:rgb(51,122,183);">市场运营</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">市场部</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">市场</div></div>
	<div class="fl"><div style="color:rgb(137,137,137);text-align:right;">北京</div></div>
</div>
<div class="" style="height:50px;padding:13px 0px;margin:0px;border-bottom:1px solid rgba(238, 238, 238, 1);font-size:15px;">
	<div class="fl w450"><div style="color:rgb(51,122,183);">自媒体编辑</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">设计部</div></div>
	<div class="fl w140"><div style="color:rgb(137,137,137);">设计</div></div>
	<div class="fl"><div style="color:rgb(137,137,137);text-align:right;">北京</div></div>
</div>

</div>
</div>
</body>
<%-- <jsp:include page="footlong.jsp" /> --%>
<jsp:include page="foot4index.jsp" />
</html>