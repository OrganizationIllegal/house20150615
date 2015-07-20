<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>置业指导录入</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/areaLuru.css" />
<link rel="stylesheet" type="text/css" href="/bootstrap-datepicker-1.4.0-dist/css/bootstrap-datepicker.min.css" />
<script src="/ckeditor/ckeditor.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="/bootstrap-datepicker-1.4.0-dist/js/bootstrap-datepicker.min.js"></script>
<script src="/bootstrap-datepicker-1.4.0-dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
</style>
</head>
<body>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:置业指导录入</div>
<div class="area_bkg2" id="brokerinfo">置业指导</div>
<div class="area_left">
<span class="area_span">编号</span><span><input type="text" id="zhiye_num" name="zhiye_num" class="area_input" value="${zhiYeZhiDao.zhiye_num}"></span>
<input type="hidden" id="id" name="id" class="area_input" value="${zhiYeZhiDao.id}">
</div>
<div class="area_right">
<span class="area_span">标题</span><span><input type="text" id="title" name="title" class="area_input" value="${zhiYeZhiDao.title}"></span>
</div>
<div class="area_left">
<span class="area_span">发布人</span><span><input type="text" id="fabu_people" name="fabu_people" class="area_input" value="${zhiYeZhiDao.fabu_people}"></span>
</div>
<div class="area_right">
<span class="area_span">发布时间</span><span><input type="text" id="fabu_time" name="fabu_time" class="area_input" value="${zhiYeZhiDao.fabu_time.toString().length()>10?zhiYeZhiDao.fabu_time.toString().substring(0,10):zhiYeZhiDao.fabu_time.toString()}"></span>
</div>
<div class="area_left">
<span class="area_span">分类</span><span><input type="text" id="fenlei" name="fenlei" class="area_input" value="${zhiYeZhiDao.fenlei}"></span>
</div>
<div class="area_right">
<span class="area_span">摘要</span><span><input type="text" id="zhiye_abstract" name="zhiye_abstract" class="area_input" value="${zhiYeZhiDao.zhiye_abstract}"></span>
</div>
<div class="c-fix" style="padding-left:35px;">
<span class="area_span">图片</span>
<span style="float:right;"> 

<input type="text" id="file1" value="${zhiYeZhiDao.image}" style="width:619px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"><button id="file2" >浏览...</button>
<input type="file" name="image" id="image" value="${zhiYeZhiDao.image}" style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;display:none;"/><a href="#" class="uploadimg">上传</a></span>
<script>
$(function(){
	$("#file2").click(
			function(){
				$("#image").click();
				$("#image").change(function(){
					$("#file1").val($("#image").val());
					});
			});
});

</script>
</div>
<div class="area_left c-fix">
<span class="area_span">详情</span>
</div>
<div class="c-fix" style="margin-bottom:15px;"><textarea id="detail" placeholder="详情" name="detail">${zhiYeZhiDao.detail}</textarea></div>
<div class="area_left4"><button type="button" class="btn" onclick="add()">提交</button></div>
<div class="area_right4"><button onClick="clearAllInput()" class="btn">不保存</button></div>
</div>

<script type="text/javascript">
CKEDITOR.replace('detail');
$('#fabu_time').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
</script>
<script type="text/javascript">
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
<script type="text/javascript">
$(".uploadimg").click(function(){
	UpladFile("image");
});
</script>
<script type="text/javascript">
  function add(){
		if($('#fabu_time').val()==""){
			alert("请选择发布时间！");
			$("#fabu_time").focus();
			return false;
		}
	  var id=$("#id").val();
	  alert("id"+id);
	  var zhiye_num=$("#zhiye_num").val();
	  var title=$("#title").val();
	  var fabu_people=$("#fabu_people").val();
	  var fabu_time=$("#fabu_time").val();
	  var fenlei=$("#fenlei").val();
	  var zhiye_abstract=$("#zhiye_abstract").val();
	  var filenames=$('#image').val().split("\\");
	  var image=filenames[filenames.length-1];
	  var detail=CKEDITOR.instances.detail.getData();
	  //alert(detail);
	  $.ajax({
	 	    type: "POST",
	 		data: { id:id,zhiye_num : zhiye_num,title : title,fabu_people : fabu_people,fabu_time : fabu_time,fenlei : fenlei,zhiye_abstract : zhiye_abstract,image : image,detail : detail},
	 		dataType: "json",
	 		url: "/EditZhiYe",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("更新成功！");
	 			}else if(data.flag == 0){
	 				alert("更新失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	  }
  function clearAllInput(){
	    var id=$("#id").val();
	    CKEDITOR.instances.detail.setData(' ');//蓝色为控件名称
		$("input").val("");
		$("#id").val(id);
		return false;
	}
</script>
</body>
</html>