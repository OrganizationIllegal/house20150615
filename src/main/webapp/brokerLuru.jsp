<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>经纪人录入</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/areaLuru.css" />
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
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
<div class="area_bkg1">当前位置:经纪人录入</div>
<div class="area_bkg2" id="brokerinfo">经纪人信息</div>
<div class="area_left">
<span class="area_span">经纪人编号</span><span><input type="text" id="broker_num" name="broker_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">经纪人姓名</span><span><input type="text" id="broker_name" name="broker_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">掌握语言</span><span><input type="text" id="broker_language" name="broker_language" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">所在地区</span><span><input type="text" id="broker_region" name="broker_region" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">经纪人类型</span><span><input type="text" id="broker_type" name="broker_type" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">经纪人资质</span><span><input type="text" id="broker_zizhi" name="broker_zizhi" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">经纪人经验</span><span><input type="text" id="broker_experience" name="broker_experience" class="area_input"></span>
</div>
<div class="area_right"><span class="area_span">经纪人图片</span><span ><input type="text" class="area_input"></span></div>
<div class="area_left">
<span class="area_span">经纪人描述</span>
</div>
<div class="c-fix" style="margin-bottom:15px;"><textarea id="introduction" placeholder="经纪人描述" name="introduction"></textarea></div>
<div class="area_bkg2 c-fix" id="shanchang">擅长类型</div>
<div class="area_left">
<span class="area_span">类型编号</span><span><input type="text" id="type_num" name="type_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">类型名称</span><span><input type="text" id="type_name" name="type_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">类型图标</span><span><input type="text" id="type_image" name="type_image" class="area_input"></span>
</div>
<div class="area_right"></div>
<div class="area_bkg2 c-fix" id="fuwu">经纪人服务区域</div>
<div class="area_left">
<span class="area_span">区域编号</span><span><input type="text" id="area_code" name="area_code" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu" name="view_shunxu" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">1</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">2</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_bkg2 c-fix" id="shanchangtype">经纪人擅长类型</div>
<div class="area_left">
<span class="area_span">擅长类型编号</span><span><input type="text" id="interested_num" name="interested_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu" name="view_shunxu" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">aupr0001</span><span class="area_span">1</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">aupr0001</span><span class="area_span">2</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left4"><button type="submit" class="btn">提交</button></div>
<div class="area_right4"><button type="reset" class="btn">重置</button></div>
</div>

<script type="text/javascript">
CKEDITOR.replace( 'introduction' );
</script>
</body>
</html>