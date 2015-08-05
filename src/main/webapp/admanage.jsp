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
.area_span {
    display: inline-block;
    width: 187px;
    font-size: 14px;
    line-height: 30px;
}
</style>
</head>
<body>
<%
            String username = null;
       		if(request.getSession().getAttribute("username")==null){
       			out.print("<script>alert('用户请登录。');window.location.href='/index01'</script>");
}
       		
%>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:广告图片管理</div>

<div class="c-fix" style="padding-left:35px;    padding-top: 43px;">
<span class="area_span">项目广告图片1(自上而下排)</span>
<span style="float:right;"> 
<input type="text" id="file1" value="${ad1}" style="width:589px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;" class="area_input"><button id="file1liu" >浏览...。</button>
<input type="file" name="ad1" id="ad1"  style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;display:none;"/></span>
</div>
<div class="area_left">
<span class="area_span">链接</span><span><input type="text" id="ad1href" name="ad1href" class="area_input"  value="${ad1href}"></span>
</div>
<div style="clear: both;text-align: center;"><a class="addad1" href="#" onclick="addad1">提交</a></div>
<div class="c-fix" style="padding-left:35px;padding-top: 36px;">
<span class="area_span">项目广告图片2(自上而下排)</span>
<span style="float:right;"> 
<input type="text" id="file2" value="${ad2}" style="width:589px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;" class="area_input"><button id="file2liu" >浏览...。</button>
<input type="file" name="ad2" id="ad2"  style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;display:none;"/></span>
</div>
<div class="area_left">
<span class="area_span">链接</span><span><input type="text" id="ad2href" name="ad2href" class="area_input"  value="${ad2href}"></span>
</div>
<div style="clear: both;text-align: center;"><a class="addad2" href="#" onclick="addad2">提交</a></div>

<div class="c-fix" style="padding-left:35px;padding-top: 36px;">
<span class="area_span">项目广告图片3(自上而下排)</span>
<span style="float:right;"> 
<input type="text" id="file3" value="${ad3}" style="width:589px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;" class="area_input"><button id="file3liu" >浏览...。</button>
<input type="file" name="ad3" id="ad3"  style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;display:none;"/></span>
</div>
<div class="area_left">
<span class="area_span">链接</span><span><input type="text" id="ad3href" name="ad2href" class="area_input"  value="${ad3href}"></span>
</div>
<div style="clear: both;text-align: center;"><a class="addad3" href="#" onclick="addad3">提交</a></div>

<div class="c-fix" style="padding-left:35px;padding-top: 36px;">
<span class="area_span">服务团队广告图片</span>
<span style="float:right;"> 
<input type="text" id="file4" value="${ad4}" style="width:589px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;" class="area_input"><button id="file4liu" >浏览...。</button>
<input type="file" name="ad4" id="ad4"  style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;display:none;"/></span>
</div>
<div class="area_left">
<span class="area_span">链接</span><span><input type="text" id="ad4href" name="ad4href" class="area_input"  value="${ad4href}"></span>
</div>
<div style="clear: both;text-align: center;"><a class="addad4" href="#" onclick="addad4">提交</a></div>

<div>
</div>
</div>
<script type="text/javascript">

        function UpladFile(imageid) {
            var fileObj = document.getElementById(imageid).files[0];
            var FileController = "/imageupload";                
            var form = new FormData();
            form.append("file", fileObj);                       
            var xhr = new XMLHttpRequest();
            xhr.open("post", FileController, true);
            xhr.onload = function () {
                alert("上传完成!");
            };
            xhr.send(form);
        }
</script>
<script>
$(function(){
	$("#file1liu").click(
			function(){
				$("#ad1").click();
				$("#ad1").change(function(){
					var filenames=$('#ad1').val().split("\\");
					var filename=filenames[filenames.length-1];
					$("#file1").val(filename);
					//$("#file1").val($("#broker_img").val());
					});
			});
});
$(function(){
	$("#file2liu").click(
			function(){
				$("#ad2").click();
				$("#ad2").change(function(){
					var filenames=$('#ad2').val().split("\\");
					var filename=filenames[filenames.length-1];
					$("#file2").val(filename);
					//$("#file1").val($("#broker_img").val());
					});
			});
});
$(function(){
	$("#file3liu").click(
			function(){
				$("#ad3").click();
				$("#ad3").change(function(){
					var filenames=$('#ad3').val().split("\\");
					var filename=filenames[filenames.length-1];
					$("#file3").val(filename);
					//$("#file1").val($("#broker_img").val());
					});
			});
});
$(function(){
	$("#file4liu").click(
			function(){
				$("#ad4").click();
				$("#ad4").change(function(){
					var filenames=$('#ad4').val().split("\\");
					var filename=filenames[filenames.length-1];
					$("#file4").val(filename);
					//$("#file1").val($("#broker_img").val());
					});
			});
});
</script>


<script type="text/javascript">


</script>

<script type="text/javascript">
$(".addad1").click(addad1);
$(".addad2").click(addad2);
$(".addad3").click(addad3);
$(".addad4").click(addad4);
function addad1(){
	  var ad1name=$("#file1").val();
	  var ad1href=$("#ad1href").val();
	  UpladFile("ad1");
	  $.ajax({
	 	    type: "POST",
	 		data: {id:1,imagename:ad1name,href:ad1href}, 
	 		dataType: "json",
	 		url: "/UpdateAdImage",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("更新成功！");
	 			}else if(data.flag!=1){
	 				alert("更新失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error");
	 		}
	 	});
	  }
function addad2(){
	  var ad2name=$("#file2").val();
	  var ad2href=$("#ad2href").val();
	  UpladFile("ad2");
	  $.ajax({
	 	    type: "POST",
	 		data: {id:2,imagename:ad2name,href:ad2href}, 
	 		dataType: "json",
	 		url: "/UpdateAdImage",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("更新成功！");
	 			}else if(data.flag <2){
	 				alert("更新失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error");
	 		}
	 	});
	  }
function addad3(){
	  var ad3name=$("#file3").val();
	  var ad3href=$("#ad3href").val();
	  UpladFile("ad3");
	  $.ajax({
	 	    type: "POST",
	 		data: {id:3,imagename:ad3name,href:ad3href}, 
	 		dataType: "json",
	 		url: "/UpdateAdImage",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("更新成功！");
	 			}else if(data.flag <2){
	 				alert("更新失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error");
	 		}
	 	});
	  }
function addad4(){
	  var ad4name=$("#file4").val();
	  var ad4href=$("#ad4href").val();
	  UpladFile("ad4");
	  $.ajax({
	 	    type: "POST",
	 		data: {id:4,imagename:ad4name,href:ad4href}, 
	 		dataType: "json",
	 		url: "/UpdateAdImage",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("更新成功！");
	 			}else if(data.flag <2){
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