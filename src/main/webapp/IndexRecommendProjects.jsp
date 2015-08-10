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
<script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
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
<div class="area_bkg1">当前位置:首页推荐项目管理</div>

<div class="area_left">
<span class="area_span ">墨尔本：推荐项目1</span><span><input type="text" id="mreco1" name="mreco1" class="area_input" value="${mreco1}"></span>
</div>
<div class="area_right">
<span class="area_span">墨尔本：推荐项目2</span><span><input type="text" id="mreco2" name="mreco2" class="area_input" value="${mreco2}"></span>
</div>
<div class="area_left">
<span class="area_span ">墨尔本：推荐项目3</span><span><input type="text" id="mreco3" name="mreco3" class="area_input" value="${mreco3}"></span>
</div>


<div class="area_right">
<span class="area_span ">悉尼：推荐项目1</span><span><input type="text" id="sreco1" name="sreco1" class="area_input" value="${sreco1}"></span>
</div>
<div class="area_left">
<span class="area_span">悉尼：推荐项目2</span><span><input type="text" id="sreco2" name="sreco2" class="area_input" value="${sreco2}"></span>
</div>
<div class="area_right">
<span class="area_span ">悉尼：推荐项目3</span><span><input type="text" id="sreco3" name="sreco3" class="area_input" value="${sreco3}"></span>
</div>
<div style="text-align: center;"><button type="button" class="btnupdate">提交</button></div>

</div>
<script type="text/javascript">

</script>

<script type="text/javascript">
$(".btnupdate").click(addad1);
function addad1(){
	  var mreco1=$("#mreco1").val();
	  var mreco2=$("#mreco2").val();
	  var mreco3=$("#mreco3").val();
	  var sreco1=$("#sreco1").val();
	  var sreco2=$("#sreco2").val();
	  var sreco3=$("#sreco3").val();
	  $.ajax({
	 	    type: "POST",
	 		data: {mreco1:mreco1,mreco2:mreco2,mreco3:mreco3,sreco1:sreco1,sreco2:sreco2,sreco3:sreco3}, 
	 		dataType: "json",
	 		url: "/UpdateIndexRecoPro",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("更新成功！");
	 			}else if(data.flag !=1){
	 				alert("更新失败！");
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