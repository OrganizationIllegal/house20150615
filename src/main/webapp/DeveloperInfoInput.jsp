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
<link rel="stylesheet" type="text/css" href="css/projectLuru.css" />
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
<div class="area_bkg1">当前位置:开发商信息录入</div>
<!-- ****************************************************学校信息start***************************************************** -->
<div class="area_bkg2">开发商信息录入</div>
<div class="area_left">
<span class="area_span">学校名称</span><span><input type="text" id="school_name" name="school_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">学校排名</span><span><input type="text" id="school_rank" name="school_rank" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">学校类型</span><span><input type="text" id="school_type" name="school_type" class="area_input"></span>
</div>

<!-- ****************************************************学校信息end***************************************************** -->


<div style="width:900px;clear:both;margin:20px auto;text-align:center;">
<button type="submit" >提交</button>
<button type="reset" >重置</button>
</div>

</div>
</body>
</html>