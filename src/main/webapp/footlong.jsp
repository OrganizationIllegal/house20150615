<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>HouseSale</title>
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="/css/index.css" rel="stylesheet">
</head>
<body>

	<div class="row" style="background-color: rgb(228,229,231);margin:0;">
		<div style="width:1190px; margin:0 auto;">
			<div style="width:1000px; margin:0 auto;">
			<div style="float:left; width:800px">
				<div style="width:100%;padding-top:20px">
					<img src="pic/newlogo12.png" style="width:200px;height:50px;padding-left:30px"/>
					<a style="margin-left:20px;margin-right:20px;font-family:微软雅黑;font-size:13px" href="#">关于我们</a>
					<a style="margin-left:20px;margin-right:20px;font-family:微软雅黑;font-size:13px" href="#">商务合作</a>
					<a style="margin-left:20px;margin-right:20px;font-family:微软雅黑;font-size:13px" href="/ServiceProtocol.jsp">服务协议</a>
					<a style="margin-left:20px;margin-right:20px;font-family:微软雅黑;font-size:13px" href="/PrivacyPolicy.jsp">使用条款&隐私政策</a>
					<a style="margin-left:20px;margin-right:20px;font-family:微软雅黑;font-size:13px" href="/Joinus.jsp">加入我们</a>
				</div>
				<img src="pic/footer.jpg" style="width:100%"/>
			</div>
			<div style="width:200px;float:left;">
				<img src="pic/weixin.jpg"  style="margin-top:16px;width:120px"/>
			</div>
			</div>
			</div>
	</div>

</body>
</html>