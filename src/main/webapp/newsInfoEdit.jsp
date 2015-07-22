<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>新闻博客录入</title>
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
<div class="area_bkg1">当前位置:新闻录入</div>
<div class="area_bkg2" id="brokerinfo">新闻博客</div>
<div class="area_left">
<span class="area_span">新闻编号</span><span><input type="text" id="news_num" name="news_num" class="area_input" value="${newsBoke.news_num}"></span>
<input type="hidden" id="id" name="id" class="area_input" value="${newsBoke.id}">
</div>
<div class="area_right">
<span class="area_span">新闻标题</span><span><input type="text" id="news_title" name="news_title" class="area_input" value="${newsBoke.news_title}"></span>
</div>
<div class="area_left">
<span class="area_span">发布人</span><span><input type="text" id="news_people" name="news_people" class="area_input" value="${newsBoke.news_people}"></span>
</div>
<div class="area_right">
<span class="area_span">发布时间</span><span><input type="text" id="news_time" name="news_time" class="area_input" value="${newsBoke.news_time.toString().length()>10?newsBoke.news_time.toString().substring(0,10):newsBoke.news_time.toString()}" ></span>
</div>
<div class="area_left">
<span class="area_span">分类</span>
<%-- <span><input type="text" id="news_fenlei" name="news_fenlei" class="area_input" value="${newsBoke.news_fenlei}"></span> --%>
<select data-placeholder="请选择..." class="chosen-select" id="news_fenlei" name="news_fenlei" style="width:220px;" tabindex="4">
<option value=""></option>
  <c:forEach items="${fenleiList}" var="item">
	  <c:choose>
	    <c:when test="${item == newsBoke.news_fenlei}">
	      <option value="${item}" selected="selected">${item}</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="${item}">${item}</option>
	   </c:otherwise>
  	  </c:choose>
    </c:forEach>
  <%-- <option value ="${newsBoke.news_fenlei}">${newsBoke.news_fenlei}</option>
  <option value ="房屋贷款">房屋贷款</option>
  <option value ="市场现状">市场现状</option>
  <option value ="时事新闻">时事新闻</option>
  <option value ="投资">投资</option>
  <option value ="攻略">攻略</option>
  <option value ="贷款">贷款</option> --%>
</select>
</div>
<div class="area_right">
<span class="area_span">摘要</span><span><input type="text" id="news_abstract" name="news_abstract" class="area_input" value="${newsBoke.news_abstract}"></span>
</div>
<div class="c-fix" style="padding-left:35px;">
<span class="area_span">新闻图片</span>
<span style="float:right;"> 

<input type="text" id="file1" value="${newsBoke.news_image}" style="width:619px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"><button  id="file2" >浏览...</button>
<input type="file" name="news_image" id="news_image"  value="${newsBoke.news_image}" style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;display:none;"/><a href="#" class="uploadimg">上传</a></span>
<script>
$(function(){
	$("#file2").click(
			function(){
				$("#news_image").click();
				$("#news_image").change(function(){
					$("#file1").val($("#news_image").val());
					});
			});
});

</script>
</div>
<div class="area_left c-fix">
<span class="area_span">新闻详情</span>
</div>
<div class="c-fix" style="margin-bottom:15px;"><textarea id="news_detail" placeholder="新闻详情" name="news_detail">${newsBoke.news_detail}</textarea></div>
<div class="area_left4"><button type="button" class="btn" onclick="add()">提交</button></div>
<div class="area_right4"><button onClick="clearAllInput()" class="btn">不保存</button></div>
</div>
<script type="text/javascript">
CKEDITOR.replace( 'news_detail' );
$('#news_time').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});

	/* CKEDITOR.instances.news_detail.setData("${newsBoke.news_detail}"); */

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
	UpladFile("news_image");
});

  function add(){
	  if($('#news_time').val()==""){
			alert("请选择发布时间！");
			$("#news_time").focus();
			return false;
		}
	  //alert("add");
	  
	  var id=$("#id").val();
	  var news_num=$("#news_num").val();
	  var news_title=$("#news_title").val();
	  var news_people=$("#news_people").val();
	  var news_time=$("#news_time").val();
	  var news_fenlei=$("#news_fenlei").val();
	  var news_abstract=$("#news_abstract").val();
	  var filenames=$('#news_image').val().split("\\");
	  var news_image=filenames[filenames.length-1];
	  if(news_image==""){
		  news_image="${newsBoke.news_image}";
	  }
	  var news_detail=CKEDITOR.instances.news_detail.getData();
	  //alert(news_detail);
	  $.ajax({
	 	    type: "POST",
	 		data: { id:id,news_num : news_num,news_title : news_title,news_people : news_people,news_time : news_time,news_fenlei : news_fenlei,news_abstract : news_abstract,news_image : news_image,news_detail : news_detail}, 
	 		dataType: "json",
	 		url: "/EditNewsBoke",
	 		success:function(data){
	 			/* data=eval("("+data+")"); */
	 			if(data.isDuplicate==1){
					alert("新闻博客编号已存在！");
				}
	 			else if(data.flag == 1){
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
	    CKEDITOR.instances.news_detail.setData(' ');//蓝色为控件名称
		$("input").val("");
		$("#id").val(id);
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
</body>
</html>