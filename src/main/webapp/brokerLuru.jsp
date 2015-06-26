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
<span class="area_span ">经纪人经验</span><span><input type="text" id="broker_experience" name="broker_experience" class="area_input"></span>
</div>
<div class="c-fix" style="padding-left:35px;">
<span class="area_span">经纪人图片</span>
<span style="float:right;"> <input type="file" name="broker_img" id="broker_img" style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#">上传</a></span>
</div>
<div class="area_left c-fix">
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
<div class="area_right3"><span class="area_span5"><a href="#" onclick="add1()">添加</a></span></div>
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
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu2" name="view_shunxu2" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" onclick="add2()">添加</a></span></div>
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
<div class="area_left4"><button type="button" class="btn" onclick="add()">提交</button></div>
<div class="area_right4"><button type="reset" class="btn">重置</button></div>
</div>

<script type="text/javascript">
CKEDITOR.replace( 'introduction' );
</script>
<script type="text/javascript">
function add(){
	  var broker_num=$("#broker_num").val();
	  var broker_name=$("#broker_name").val();
	  var broker_language=$("#broker_language").val();
	  var broker_region=$("#broker_region").val();
	  var broker_type=$("#broker_type").val();
	  var broker_zizhi=$("#broker_zizhi").val();
	  var broker_experience=$("#broker_experience").val();
	  var broker_img=$("#broker_img").val();
	  var introduction=$("#introduction").val();
	  var type_num=$("#type_num").val();
	  var type_name=$("#type_name").val();
	  var type_image=$("#type_image").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { broker_num : broker_num,broker_name : broker_name,broker_language : broker_language,broker_region : broker_region,broker_type : broker_type,broker_zizhi : broker_zizhi,broker_experience : broker_experience,broker_img : broker_img,introduction : introduction,type_num : type_num,type_name : type_name,type_image : type_image}, 
	 		dataType: "json",
	 		url: "/inputBroker",
	 		success:function(data){
	 			if(data.flag == 2){
	 				alert("添加成功！");
	 			}else if(data.flag <2){
	 				alert("添加失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	  }
  function add1(){
	  var broker_num=$("#broker_num").val();
	  var area_code=$("#area_code").val();
	  var view_shunxu=$("#view_shunxu").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { broker_num : broker_num,area_code : area_code,view_shunxu : view_shunxu}, 
	 		dataType: "json",
	 		url: "/addServiceArea",
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

  function add2(){
	  alert("ehhe")
	  var broker_num=$("#broker_num").val();
	  var interested_num=$("#interested_num").val();
	  var view_shunxu2=$("#view_shunxu2").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { broker_num : broker_num,interested_num : interested_num,view_shunxu : view_shunxu2}, 
	 		dataType: "json",
	 		url: "/addInteType",
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