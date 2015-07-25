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
<script src="/ckeditor/ckeditor.js"></script>
<!-- <script src="/js/jquery.min.js"></script> -->
<!-- <script src="/bootstrap/js/bootstrap.min.js"></script> -->
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
<div class="area_bkg1">当前位置:置业指导录入</div>
<div class="area_bkg2" id="brokerinfo">置业指导</div>
<div class="area_left">
<span class="area_span">编号</span><span><input type="text" id="zhiye_num" name="zhiye_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">标题</span><span><input type="text" id="biaoti" name="biaoti" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">发布人</span><span><input type="text" id="fabu_people" name="fabu_people" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">发布时间</span><span><input type="text" id="fabu_time" name="fabu_time" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">分类</span>
<span>
<!-- <input type="text" id="fenlei" name="fenlei" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="fenlei" name="fenlei" style="width:220px;" tabindex="4">
 	 <option value=""></option>
  	 <option value="购房政策">购房政策</option>
     <option value="购房常识">购房常识</option>
      <option value="购房成本">购房成本</option>
      <option value="交易流程">交易流程</option>
      <option value="看房技巧">看房技巧</option>
      <option value="合同讲解">合同讲解</option>
      <option value="定金原则">定金原则</option>
      <option value="签约事宜">签约事宜</option>
      <option value="信贷政策">信贷政策</option>
      <option value="交易税费">交易税费</option>
      <option value="持有税费">持有税费</option>
      <option value="交割须知">交割须知</option>
      
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">摘要</span><span><input type="text" id="zhiye_abstract" name="zhiye_abstract" class="area_input"></span>
</div>
<div class="c-fix" style="padding-left:35px;">
<span class="area_span">图片</span>
<span style="float:right;"> <input type="file" name="image" id="image" style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#" class="uploadimg">上传</a></span>
</div>
<div class="area_left c-fix">
<span class="area_span">详情</span>
</div>
<div class="c-fix" style="margin-bottom:15px;"><textarea id="detail" placeholder="详情" name="detail"></textarea></div>
<div class="area_left4"><button type="button" class="btn" onclick="add()">提交</button></div>
<div class="area_right4"><button onClick="clearAllInput()" class="btn">不保存</button></div>
</div>

<script type="text/javascript">
CKEDITOR.replace( 'detail' );
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
	  var zhiye_num=$("#zhiye_num").val();
	  var biaoti=$("#biaoti").val();
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
	 		data: { zhiye_num : zhiye_num,title : biaoti,fabu_people : fabu_people,fabu_time : fabu_time,fenlei : fenlei,zhiye_abstract : zhiye_abstract,image : image,detail : detail},
	 		dataType: "json",
	 		url: "/inputZhiYe",
	 		success:function(data){
	 			/* data=eval("("+data+")"); */
	 			if(data.isDuplicate==1){
					alert("置业指导编号已存在！");
				}
	 			else if(data.flag == 1){
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