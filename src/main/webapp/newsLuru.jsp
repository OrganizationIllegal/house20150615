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
<link rel="stylesheet" type="text/css" href="/bootstrap-datepicker-1.4.0-dist/css/bootstrap-datepicker.min.css" />
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
<!-- <script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script> -->
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
<span class="area_span">新闻编号</span><span><input type="text" id="news_num" name="news_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">新闻标题</span><span><input type="text" id="news_title" name="news_title" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">发布人</span><span><input type="text" id="news_people" name="news_people" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">发布时间</span><span><input type="text" id="news_time" name="news_time" class="area_input"></span>
</div>
<div class="area_left c-fix">
<span class="area_span">分类</span>
<!-- <span><input type="text" id="news_fenlei" name="news_fenlei" class="area_input"></span> -->
<span>
<select data-placeholder="请选择..." class="chosen-select" id="news_fenlei" name="news_fenlei" style="width:220px;" tabindex="4">
 <option value=""></option>
  <c:forEach items="${fenleiList}" var="item">
                    	<option value="${item}">${item}</option>
                    </c:forEach>
                    
  <!-- <option value ="房屋贷款">房屋贷款</option>
  <option value ="市场现状">市场现状</option>
  <option value ="时事新闻">时事新闻</option>
  <option value ="投资">投资</option>
  <option value ="攻略">攻略</option>
  <option value ="贷款">贷款</option> -->
</select>
</span>
</div>
<div class="area_right">
<span class="area_span">摘要</span><span><input type="text" id="news_abstract" name="news_abstract" class="area_input"></span>
</div>
<div class="c-fix" style="padding-left:35px;">
<span class="area_span">新闻图片</span>
<span style="float:right;"> <input type="file" name="news_image" id="news_image" style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#" class="uploadimg">上传</a></span>
</div>
<div class="area_left c-fix">
<span class="area_span">新闻详情</span>
</div>
<div class="c-fix" style="margin-bottom:15px;"><textarea id="news_detail" placeholder="新闻详情" name="news_detail"></textarea></div>
<div class="area_left4"><button type="button" class="btn" onclick="add()">提交</button></div>
<div class="area_right4"><button onClick="clearAllInput()" class="btn">不保存</button></div>
</div>
<script type="text/javascript">
/* CKEDITOR.replace( 'news_detail' ); */
CKEDITOR.replace( 'news_detail', {
	extraPlugins: 'image2'
} );
$('#news_time').datepicker({
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
	UpladFile("news_image");
});

  function add(){
		if($('#news_time').val()==""){
			alert("请选择发布时间！");
			$("#news_time").focus();
			return false;
		}
	  //alert("add");
	  var news_num=$("#news_num").val();
	  var news_title=$("#news_title").val();
	  var news_people=$("#news_people").val();
	  var news_time=$("#news_time").val();
	  var news_fenlei=$("#news_fenlei").val();
	  var news_abstract=$("#news_abstract").val();
	  var filenames=$('#news_image').val().split("\\");
	  var news_image=filenames[filenames.length-1];
	  var news_detail=CKEDITOR.instances.news_detail.getData();
	  //alert(news_detail);
	  $.ajax({
	 	    type: "POST",
	 		data: { news_num : news_num,news_title : news_title,news_people : news_people,news_time : news_time,news_fenlei : news_fenlei,news_abstract : news_abstract,news_image : news_image,news_detail : news_detail}, 
	 		dataType: "json",
	 		url: "/inputNewsBoke",
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
		$("input").val("");
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