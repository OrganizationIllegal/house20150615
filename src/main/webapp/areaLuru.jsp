<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Service Protocol</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/areaLuru.css" />
<script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
</style>
</head>
<body>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:区域录入</div>
<div class="area_bkg2">区域信息</div>
<div class="area_left">
<span class="area_span">区域编号</span><span><input type="text" id="area_num" name="area_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">区域名称</span><span><input type="text" id="area_name" name="area_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">城市名称</span><span><input type="text" id="area_city" name="area_city" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">州/省</span><span><input type="text" id="area_zhou" name="area_zhou" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">国家</span><span><input type="text" id="area_nation" name="area_nation" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">邮政编码</span><span><input type="text" id="area_postcode" name="area_postcode" class="area_input"></span>
</div>
</div>
</body>
</html>