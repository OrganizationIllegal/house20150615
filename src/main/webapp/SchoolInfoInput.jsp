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
<div class="area_bkg1">当前位置:学校信息录入</div>
<!-- ****************************************************学校信息start***************************************************** -->
<form>
<div class="area_bkg2">学校信息</div>
<div class="area_left">
<span class="area_span">学校名称</span><span><input type="text" id="school_name" name="school_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">学校排名</span><span><input type="text" id="school_rank" name="school_rank" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">学校类型</span><span><input type="text" id="school_type" name="school_type" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">学生总数</span><span><input type="text" id="school_total" name="school_total" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">教工人数</span><span><input type="text" id="teacher_num" name="teacher_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">学校位置</span><span><input type="text" id="school_position" name="school_position" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">GPS</span><span><input type="text" id="school_gps" name="school_gps" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">网址</span><span><input type="text" id="school_url" name="school_url" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">非英文学生比例</span><span><input type="text" id="non_en_studen_trate" name="non_en_studen_trate" class="area_input"></span>
</div>
<div class="area_left" style="width:900px">
<span class="area_span" style="float:left;">学校照片</span>
<span></span><input type="file" name="schoolimg" id="schoolimg" style="width:620px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#">上传</a></span>
</div>
<div class="duoarea_left2">
<span class="duoarea_span">学校简介</span><span><textarea id="school_intro" name="school_intro" class="duoarea_input2"></textarea></span>
</div>

<!-- ****************************************************学校信息end***************************************************** -->


<div style="width:900px;clear:both;margin:20px auto;text-align:center;">
<button type="submit" >提交</button>
<button type="reset" >重置</button>
</div>
</form>
</div>
</body>
</html>