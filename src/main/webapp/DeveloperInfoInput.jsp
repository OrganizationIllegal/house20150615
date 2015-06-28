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
<span class="area_span">开发商名称</span><span><input type="text" id="developer_name" name="developer_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">开发商logo</span><span><input type="text" id="developer_logo" name="developer_logo" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">开发商编号</span><span><input type="text" id="developer_num" name="developer_num" class="area_input"></span>
</div>
<div class="duoarea_left2">
<span class="area_span">开发商介绍</span><span><textarea id="developer_desc" name="developer_desc" class="duoarea_input2"></textarea></span>
</div>
<!-- ****************************************************学校信息end***************************************************** -->


<div style="width:900px;clear:both;margin:20px auto;text-align:center;">
<!-- <button type="submit" >提交</button>
<button type="reset" >重置</button> -->
<button  type="button" onclick="save()">提交</button>
<button type="reset" >重置</button>
</div>

</div>

</body>
</html>

<script type="text/javascript">
   function save(){
     var developer_name=$("#developer_name").val();
     var developer_logo=$("#developer_logo").val();
     var developer_num=$("#developer_num").val();
     var developer_desc=$("#developer_desc").val();
     $.ajax({
	 	   type: "GET",
	 		data: { developer_name : developer_name,developer_logo:developer_logo,developer_num:developer_num,developer_desc:developer_desc},
	 		async: false, 
	 		dataType: "json",
	 		url: "/AddDeveloperInfo",
	 		success:function(data){
	 			//alert("okokokoko");
	 			//alert(data);
	 			//alert(data.flag);
	 			if(data.flag == 1){
	 				alert("添加成功");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
    }
</script>