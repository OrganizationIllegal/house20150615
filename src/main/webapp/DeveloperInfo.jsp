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
<span class="area_span">开发商名称</span><span><input type="text" id="developer_name" name="developer_name" class="area_input" value="${developerInfo.developer_name}"></span>
<input type="hidden" id="id" name="id" class="area_input" value="${developerInfo.id}">
</div>
<div class="area_right">
<span class="area_span">开发商编号</span><span><input type="text" id="developer_num" name="developer_num" class="area_input" value="${developerInfo.developer_num}"></span>
</div>
<div class="area_left">
<span class="area_span">开发商国家</span><span><input type="text" id="nation" name="nation" class="area_input" value="${developerInfo.nation}"></span>
</div>
<%-- <div class="area_right">
<span class="area_span">开发商logo</span><span><input type="text" id="developer_logo" name="developer_logo" class="area_input" value="${developerInfo.developer_logo}"></span>
</div> --%>
<div class="area_left" style="width:900px">
<span class="area_span" style="float:left;">开发商logo</span>
<span>
<input type="text" id="file1" value="${developerInfo.developer_logo}" style="float:left;width:580px;border:1px solid rgb(239,235,242);"><input type="button" id="file2" value="浏览...">
<input type="file" name="developer_logo" id="developer_logo"  multiple  style="float:left;width:620px;border:1px solid rgb(239,235,242);display:none;" value="${developerInfo.developer_logo}"/><a href="#" class="addpeitao" onclick="upload()">上传</a></span>
<script>
$(function(){
	$("#file2").click(
			function(){
				$("#developer_logo").click();
				$("#developer_logo").change(function(){
					$("#file1").val($("#developer_logo").val());
					});
				
			});
});

</script>
</div>
<div class="duoarea_left2">
<span class="area_span">开发商介绍</span><span><textarea id="developer_desc" name="developer_desc" class="duoarea_input2" >${developerInfo.developer_desc}</textarea></span>
</div>
<!-- ****************************************************学校信息end***************************************************** -->


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
	 var id=$("#id").val();
     var developer_name=$("#developer_name").val();
    // var developer_logo=$("#developer_logo").val();
     var developer_num=$("#developer_num").val();
     var developer_desc=$("#developer_desc").val();
     var nation=$("#nation").val();
     var filenames=$('#developer_logo').val().split("\\");
	 var developer_logo=filenames[filenames.length-1];
	 if(developer_logo==""){
		 developer_logo="${developerInfo.developer_logo}";
	  }
	 //alert(developer_logo)
     $.ajax({
	 	   type: "GET",
	 		data: {id:id, developer_name : developer_name,developer_logo:developer_logo,developer_num:developer_num,developer_desc:developer_desc,nation:nation},
	 		async: false, 
	 		dataType: "json",
	 		url: "/EditDeveloperInfo",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("更新成功");
	 			}
	 			else{
	 				alert("更新失败");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
    }
   function clearAllInput(){
		$("input").val("");
		$("#developer_desc").val("");
		return false;
	}
   function upload(){
	   UpladFile("developer_logo");
   }
   
   function UpladFile(imageid) {
       var fileObj = document.getElementById(imageid).files[0]; // 获取文件对象

       var FileController = "/imageupload";                    // 接收上传文件的后台地址 

       // FormData 对象

       var form = new FormData();

       /* form.append("author", "hooyes");    */                     // 可以增加表单数据

       form.append("file", fileObj);                           // 文件对象



       // XMLHttpRequest 对象

       var xhr = new XMLHttpRequest();

       xhr.open("post", FileController, true);

       xhr.onload = function () {

           alert("上传完成!");

       };

       xhr.send(form);
   }
</script>