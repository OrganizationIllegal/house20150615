<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>添加城市</title>
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
<div class="area_bkg1">当前位置:添加城市</div>

<div class="area_left">
<span class="area_span ">国家名字</span><span>
<!-- <input type="text" id="nation_name" name="nation_name" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="nation_name" name="nation_name" style="width:200px;">
   <option value=""></option>
  	<c:forEach items="${nationlist}" var="item">
	      <option value="${item}">${item}</option>
    </c:forEach>
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">城市名字</span><span><input type="text" id="city_name" name="city_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span ">中心GPS</span><span><input type="text" id="center_gps" name="center_gps" class="area_input"></span>
</div>

<div style="text-align: center;clear:both;"><button type="button" class="btnupdate">提交</button></div>

</div>
<script type="text/javascript">

</script>

<script type="text/javascript">
$(".btnupdate").click(addad1);
function addad1(){
	  var mreco1=$("#city_name").val();
	  var mreco2=$("#nation_name").val();
	  var mreco3=$("#center_gps").val();
	  $.ajax({
	 	    type: "POST",
	 		data: {city_name:mreco1,pre_num:mreco2,center_gps:mreco3}, 
	 		dataType: "json",
	 		url: "/SaveAddCity",
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
 <script src="/js/chosen.jquery.js" type="text/javascript"></script>
 <script src="/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
 <script type="text/javascript">
    var config = {
      '.chosen-select'           : {},
      '.chosen-select-deselect'  : {allow_single_deselect:true},
      '.chosen-select-no-single' : {disable_search_threshold:10},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width'     : {width:"95%"}
    }
    for (var selector in config) {
      $(selector).chosen(config[selector]);
    }
  </script>
</body>
</html>