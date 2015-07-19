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
<link rel="stylesheet" href="css/chosen.css">
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
<div class="area_bkg1">当前位置:学校信息录入</div>
<!-- ****************************************************学校信息start***************************************************** -->
<div class="area_bkg2">学校信息</div>
<div class="area_left">
<span class="area_span">学校名称</span><span><input type="text" id="school_name" name="school_name" class="area_input" value="${schoolInfo.school_name}"></span>
<input type="hidden" id="id" name="id" class="area_input" value="${schoolInfo.id}">
</div>
<div class="area_right">
<span class="area_span">学校排名</span><span><input type="text" id="school_rank" name="school_rank" class="area_input" value="${schoolInfo.school_ranking}"></span>
</div>
<div class="area_left">
<span class="area_span">学校类型</span>
<%-- <span><input type="text" id="school_type" name="school_type" class="area_input" value="${schoolInfo.school_type}"></span> --%>
<select data-placeholder="请选择..." class="chosen-select" id="school_type" name="school_type" style="width:220px;" tabindex="4">
       <c:choose>
	    <c:when test="${schoolInfo.school_type eq '儿童托管'}">
	      <option value="儿童托管" selected="selected">公寓</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="儿童托管">儿童托管</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${schoolInfo.school_type eq '公立小学'}">
	      <option value="公立小学" selected="selected">公立小学</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="公立小学">公立小学</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${schoolInfo.school_type eq '私立小学'}">
	      <option value="私立小学" selected="selected">私立小学</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="私立小学">私立小学</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${schoolInfo.school_type eq '公立中学'}">
	      <option value="公立中学" selected="selected">公立中学</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="公立中学">公立中学</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${schoolInfo.school_type eq '私立中学'}">
	      <option value="私立中学" selected="selected">私立中学</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="私立中学">私立中学</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${schoolInfo.school_type eq '公立中小学'}">
	      <option value="公立中小学" selected="selected">公立中小学</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="公立中小学">公立中小学</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${schoolInfo.school_type eq '私立中小学'}">
	      <option value="私立中小学" selected="selected">私立中小学</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="私立中小学">私立中小学</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${schoolInfo.school_type eq 'primiy school'}">
	      <option value="primiy school" selected="selected">primiy school</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="primiy school">primiy school</option>
	   </c:otherwise>
  	  </c:choose>
  	   
<!--  <option value=""></option>
 <option value="儿童托管">儿童托管</option>
 <option value="公立小学">公立小学</option>
 <option value="私立小学">私立小学</option>
 <option value="公立中学">公立中学</option>
 <option value="私立中学">私立中学</option>
 <option value="公立中小学">公立中小学</option>
 <option value="私立中小学">私立中小学</option>
 <option value="primiy school">primiy school</option> -->
 </select>
</div>
<div class="area_right">
<span class="area_span">学生总数</span><span><input type="text" id="school_total" name="school_total" class="area_input" value="${schoolInfo.student_total}"></span>
</div>
<div class="area_left">
<span class="area_span">教工人数</span><span><input type="text" id="teacher_num" name="teacher_num" class="area_input" value="${schoolInfo.teacher_total}"></span>
</div>
<div class="area_right">
<span class="area_span">学校位置</span><span><input type="text" id="school_position" name="school_position" class="area_input" value="${schoolInfo.school_position}"></span>
</div>
<div class="area_left">
<span class="area_span">国家</span><span><input type="text" id="nation" name="nation" class="area_input" value="${schoolInfo.nation}"></span>
</div>
<div class="area_right">
<span class="area_span">城市</span><span><input type="text" id="city" name="city" class="area_input" value="${schoolInfo.nation}"></span>
</div>
<div class="area_left">
<span class="area_span">GPS</span><span><input type="text" id="school_gps" name="school_gps" class="area_input" value="${schoolInfo.gps}"></span>
</div>
<div class="area_right">
<span class="area_span">网址</span><span><input type="text" id="school_url" name="school_url" class="area_input" value="${schoolInfo.net_info}"></span>
</div>
<div class="area_left">
<span class="area_span">非英文学生比例</span><span><input type="text" id="non_en_studen_trate" name="non_en_studen_trate" class="area_input" value="${schoolInfo.not_en_stu_bili}"></span>
</div>
<div class="area_left" style="width:900px">
<span class="area_span" style="float:left;">学校照片</span>
<span></span>
<input type="text" id="file1" value="${schoolInfo.school_image}" style="float:left;width:580px;border:1px solid rgb(239,235,242);"><input type="button" id="file2" value="浏览...">
<input type="file" name="schoolimg" id="schoolimg"  value="${schoolInfo.school_image}" style="width:620px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;display:none;"/><a href="#"  onclick="upload()">上传</a></span>
<script>
$(function(){
	$("#file2").click(
			function(){
				$("#schoolimg").click();
				$("#schoolimg").change(function(){
					$("#file1").val($("#schoolimg").val());
					});
			});
});

</script>

</div>
<div class="duoarea_left2">
<span class="duoarea_span">学校简介</span><span><textarea id="school_intro" name="school_intro" class="duoarea_input2">${schoolInfo.school_desc}</textarea></span>
</div>

<!-- ****************************************************学校信息end***************************************************** -->


<div style="width:900px;clear:both;margin:20px auto;text-align:center;">
<button type="submit" onclick="edit()">提交</button>
<button onClick="clearAllInput()">不保存</button>
</div>
</div>
<script type="text/javascript">
$('#school_total').blur(function() {
	if(isNaN($('#school_total').val())){
		alert("请输入数字！");
		$("#school_total").focus();
		return false;
	}
	});
$('#teacher_num').blur(function() {
	if(isNaN($('#teacher_num').val())){
		alert("请输入数字！");
		$("#teacher_num").focus();
		return false;
	}
	});
$('#non_en_studen_trate').blur(function() {
	if(isNaN($('#non_en_studen_trate').val())){
		alert("请输入数字！");
		$("#non_en_studen_trate").focus();
		return false;
	}
	});
   function edit(){
	 var id=$("#id").val();
     var school_name=$("#school_name").val();
     var school_rank=$("#school_rank").val();
     var school_type=$("#school_type").val();
     var school_total=$("#school_total").val();
     var teacher_num=$("#teacher_num").val();
     var school_position=$("#school_position").val();
     var school_gps=$("#school_gps").val();
     var school_url=$("#school_url").val();
     var non_en_studen_trate=$("#non_en_studen_trate").val();
   /*  var  schoolimg=$("#schoolimg").val(); */
    var filenames=$('#schoolimg').val().split("\\");
	  var schoolimg=filenames[filenames.length-1];
    var school_intro=$("#school_intro").val();
    var  nation=$("#nation").val();
    var city=$("#city").val();
     $.ajax({
     		async : false,
	 	    type: "POST",
	 		data: { id:id,school_name : school_name,school_rank:school_rank,school_type:school_type,school_total:school_total,teacher_num:teacher_num,school_position:school_position,school_gps:school_gps,school_url:school_url,non_en_studen_trate:non_en_studen_trate,schoolimg:schoolimg,school_intro:school_intro,nation:nation,city:city},
	 		dataType: "json",
	 		url: "/EditSchoolInfo",
	 		success:function(data){
	 			//window.location.reload();
	 			//alert(data);
	 			//alert(data.flag);
	 			if(data.flag==1){
	 				alert("更新成功");
	 			}
	 			if(data.flag==0){
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
		$("#school_intro").val("");
		return false;
	}

   function upload(){
	   UpladFile("schoolimg");
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