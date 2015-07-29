<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>地图中心点录入</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/projectLuru.css" />
<!-- <script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script> -->
<link rel="stylesheet" href="css/chosen.css">
<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
</style>
</head>
<body>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:地图中心点录入</div>
<div class="area_bkg2">地图中心点录入</div>
<div class="area_left">
<span class="area_span">名称</span>
<!-- <span><input type="text" id="name" name="name" class="area_input"></span> -->
<select data-placeholder="请选择..." class="chosen-select" id="name" name="name" style="width:220px;" tabindex="4">
 	 <option value=""></option>
 	 <option value="默认">默认</option>
 	 <c:forEach items="${areacityNameSet}" var="item">
     <option value="${item}">${item}</option>
   	 </c:forEach>
 </select>
</div>
<div class="area_right">
<span class="area_span">类型</span><span>
<select data-placeholder="请选择..." class="chosen-select" id="type" name="type" style="width:220px;" tabindex="4">
 	 <option value=""></option>
 	 <option value="默认">默认</option>
 	 <option value="区域">区域</option>
	 <option value="城市">城市</option>
 </select>
</span>
</div>
<div class="area_left">
<span class="area_span">gps</span><span><input type="text" id="gps" name="gps" class="area_input"></span>
</div>
<div style="width:900px;clear:both;margin:20px auto;text-align:center;">
<!-- <button type="submit" >提交</button>
<button type="reset" >重置</button> -->
<button  type="button" onclick="save()">提交</button>
<button type="reset" onClick="clearAllInput()">重置</button>
</div>
</div>
</body>
</html>

<script type="text/javascript">
   function save(){
     var name=$("#name").val();
     var gps=$("#gps").val();
     var type=$("#type").val();
     $.ajax({
	 	   type: "GET",
	 		data: { name : name, gps:gps,type:type},
	 		async: false, 
	 		dataType: "json",
	 		url: "/AddMapCenter",
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
   function clearAllInput(){
		$("name").val("");
		$("#gps").val("");
		$("#type").val("");
		return false;
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