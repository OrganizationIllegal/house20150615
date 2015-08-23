<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>添加国家</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/areaLuru.css" />
<!-- <script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script> -->
<link rel="stylesheet" href="css/chosen.css">
<style type="text/css">
body{
	font-family:"Microsoft YaHei"!important;
}
</style>
</head>
<body>
<%
            String username = null;
       		if(request.getSession().getAttribute("username")==null){
       			out.print("<script>alert('用户请登录。');window.location.href='/index'</script>");
}
       		
%>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:添加国家</div>

<div class="area_left">
<span class="area_span ">国家名字</span><span><input type="text" id="nation_name" name="nation_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span ">中心GPS</span><span><input type="text" id="center_gps" name="center_gps" class="area_input"></span>
</div>


<div style="text-align: center;"><button type="button" class="btnupdate">提交</button></div>

</div>
<script type="text/javascript">

</script>

<script type="text/javascript">
$(".btnupdate").click(addad1);
function addad1(){
	  var mreco1=$("#nation_name").val();
	  var mreco3=$("#center_gps").val();
	  $.ajax({
	 	    type: "POST",
	 		data: {nation_name:mreco1,center_gps:mreco3}, 
	 		dataType: "json",
	 		url: "/SaveAddNation",
	 		success:function(data){
	 			if(data.flag == true){
	 				alert("添加成功！");
	 			}else if(data.flag !=true){
	 				alert("添加失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error");
	 		}
	 	});
	  }
</script>

</body>
</html>