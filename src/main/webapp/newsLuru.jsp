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
<div class="area_bkg1">当前位置:新闻录入</div>
<div class="area_bkg2" id="brokerinfo">新闻博客</div>
<div class="area_left">
<span class="area_span">新闻编号</span><span><input type="text" id="news_num" name="news_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">新闻标题</span><span><input type="text" id="news_title" name="news_title" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">发布人</span><span><input type="text" id="news_people" name="news_people" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">发布时间</span><span><input type="text" id="news_time" name="news_time" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">分类</span><span><input type="text" id="news_fenlei" name="news_fenlei" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">摘要</span><span><input type="text" id="news_abstract" name="news_abstract" class="area_input"></span>
</div>
<div class="c-fix" style="padding-left:35px;">
<span class="area_span">新闻图片</span>
<span style="float:right;"> <input type="file" name="news_image" id="news_image" style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#">上传</a></span>
</div>
<div class="area_left c-fix">
<span class="area_span">新闻详情</span>
</div>
<div class="c-fix" style="margin-bottom:15px;"><textarea id="news_detail" placeholder="新闻详情" name="news_detail"></textarea></div>
<div class="area_left4"><button type="button" class="btn" onclick="add()">提交</button></div>
<div class="area_right4"><button type="reset" class="btn">重置</button></div>
</div>
<script type="text/javascript">
CKEDITOR.replace( 'news_detail' );
</script>
<script type="text/javascript">
  function add(){
	  var news_num=$("#news_num").val();
	  var news_title=$("#news_title").val();
	  var news_people=$("#news_people").val();
	  var news_time=$("#news_time").val();
	  var news_fenlei=$("#news_fenlei").val();
	  var news_abstract=$("#news_abstract").val();
	  var news_image=$("#news_image").val();
	  var news_detail=$("#news_detail").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { news_num : news_num,news_title : news_title,news_people : news_people,news_time : news_time,news_fenlei : news_fenlei,news_abstract : news_abstract,news_image : news_image,news_detail : news_detail}, 
	 		dataType: "json",
	 		url: "/inputNewsBoke",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("添加成功！");
	 			}else if(data.flag == 0){
	 				alert("添加失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	  }
</script>
</body>
</html>