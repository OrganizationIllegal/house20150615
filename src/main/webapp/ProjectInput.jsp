<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Service Protocol</title>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  -->
<!-- <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/projectLuru.css" />
<!-- <link rel="stylesheet" type="text/css" href="uploadify/uploadify.css" /> -->
<link rel="stylesheet" type="text/css" href="/webuploader-0.1.5/webuploader.css"/> 
<script src="/js/jquery.min.js"></script>
<!-- <script src="/bootstrap/js/bootstrap.min.js"></script> -->
<!-- <script src="uploadify/jquery.uploadify.js"></script> -->
<script src="/webuploader-0.1.5/webuploader.min.js"></script>

<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="/css/default.css" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <link rel="stylesheet" type="text/css" href="/webuploader-0.1.5/webuploader.css"/> 
   <!-- <script src="/js/jquery.min.js"></script> -->
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>


<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
.imageselect{
	width:700px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;
}
</style>

</head>
<body>
<!-- action="/projectinput" method="post"  enctype="multipart/form-data" -->
<div>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:项目录入</div>
<!-- ****************************************************项目信息start***************************************************** -->
<div class="area_bkg2" id="projectinfo">项目信息</div>
<form action="/pinput" id="test" enctype="multipart/form-data">
<div class="area_left">
<span class="area_span">项目编号</span><span><input type="text" id="project_code" name="project_code" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">项目名称</span><span><input type="text" id="project_name" name="project_name" class="area_input"></span>
</div>
</form>

<div class="area_left">
<span class="area_span">项目视频链接</span><span><input type="text" id="project_video" name="project_video" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">开发商编号</span><span><input type="text" id="develop_id" name="develop_id" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">项目所在国家</span><span><input type="text" id="project_nation" name="project_nation" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">项目所在州/省</span><span><input type="text" id="project_zhou" name="project_zhou" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">项目所在城市</span><span><input type="text" id="project_city" name="project_city" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">项目所在地区</span><span><input type="text" id="project_area" name="project_area" class="area_input"></span>
</div>
<div class="duoarea_left">
<span class="duoarea_span" >项目所在地址</span><span><textarea id="project_address" name="project_address" class="duoarea_input"></textarea></span>
</div>
<div class="area_right">
<span class="area_span">项目类型</span>
<span>
<select class="area_select" id="project_type" name="project_type">
  <option >公寓</option>
  <option >别墅</option>
  <option>联合别墅</option>
</select>
</span>
</div>
<div class="area_right">
<span class="area_span">户型</span><span><input type="text" id="house_type" name="house_type" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">项目完成时间</span><span><input type="text" id="finish_time" name="finish_time" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">可售套数</span><span><input type="text" id="keshou" name="keshou" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">步行指数</span><span><input type="text" id="walk_num" name="walk_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">层数</span><span><input type="text" id="ceng" name="ceng" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">推荐度</span><span><input type="text" id="tuijian" name="tuijian" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">面积单位</span><span><input type="text" id="mianji" name="mianji" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">最小单位</span><span><input type="text" id="minarea" name="minarea" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">最大单位</span><span><input type="text" id="maxarea" name="maxarea" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">单价（起价）</span><span><input type="text" id="danjia" name="danjia" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">返利</span><span><input type="text" id="return_money" name="return_money" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">最低价格</span><span><input type="text" id="minprice" name="minprice" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">最高价格</span><span><input type="text" id="maxprice" name="maxprice" class="area_input"></span>
</div>
<div class="duoarea_left">
<span class="duoarea_span">项目一句话（中文）</span><span><textarea id="project_lan_an" name="project_lan_an" class="duoarea_input"></textarea></span>
</div>
<div class="duoarea_right">
<span class="duoarea_span">项目一句话（英文）</span><span><textarea id="project_lan_en" name="project_lan_en" class="duoarea_input"></textarea></span>
</div>
<div class="duoarea_left2">
<span class="duoarea_span">项目描述</span><span><textarea id="project_desc" name="project_desc" class="duoarea_input2"></textarea></span>
</div>
<div class="area_left">
<span class="area_span">项目GPS</span><span><input type="text" id="GPS" name="GPS" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新时间</span><span><input type="text" id="update_time" name="update_time" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">购房税费说明</span><span><input type="text" id="buyTaxInfo" name="buyTaxInfo" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">持有成本说明</span><span><input type="text" id="holdCostInfo" name="holdCostInfo" class="area_input"></span>
</div>

<!-- ****************************************************项目信息end***************************************************** -->

<!-- ****************************************************开发商信息start***************************************************** -->


<div class="area_bkg2" style="clear:both;" id="developerinfo">开发商信息</div>
<div class="area_left" style="width:900px">
<span class="area_span">开发商编号及名称</span>
<span>
<select class="area_select" id=developer_code name="developer_code" style="width:670px">
         <c:forEach items="${codeAndNameSet}" var="item">
        		 <option>${item}</option>
       	 </c:forEach>
</select>
</span>
</div>
<!-- <div class="area_right">
<span class="area_span">开发商名称</span><span><input type="text" id="developer_name" name="developer_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">开发商logo</span><span><input type="text" id="developer_logo" name="developer_logo" class="area_input"></span>
</div>
<div class="duoarea_left2">
<span class="area_span">开发商介绍</span><span><textarea id="developer_desc" name="developer_desc" class="duoarea_input2"></textarea></span>
</div> -->


<!-- ****************************************************开发商信息end***************************************************** -->

<!-- ****************************************************户型及价格start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="housetypeinfo">户型及价格</div>
<form id="huxingjiage">
<div class="area_left">
<span class="area_span">户型名称</span><span><input type="text" id="housename" name="housename" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">户型价格</span><span><input type="text" id="houseprice" name="houseprice" class="area_input"></span>
</div>
<!-- <div class="chang_left2">
<span class="area_span">户型图片</span><span><input type="text" id="houseimg" name="houseimg" class="chang_input2"></span>
</div> -->
<div class="area_left"  style="width:900px">
 <input type="file" name="houseimg" id="houseimg" style="width:700px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><!-- <a href="#">上传</a> -->
</div>
<div class="area_left">
<span class="area_span">卧室数量</span><span><input type="text" id="room_num" name="room_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">土地面积</span><span><input type="text" id="tudi_mianji" name="tudi_mianji" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">建筑面积</span><span><input type="text" id="jianzhu_mianji" name="jianzhu_mianji" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">室内面积</span><span><input type="text" id="shinei_mianji" name="shinei_mianji" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">室外面积</span><span><input type="text" id="shiwai_mianji" name="shiwai_mianji" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">卫生间数量</span><span><input type="text" id="wc_num" name="wc_num" class="area_input"></span>
</div>
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addhuxing">添加</a></div>
</form>
<div id="huxingjiagelist">
</div>
<!-- ****************************************************开发商信息end***************************************************** -->

<!-- ****************************************************项目配套start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="projectpeitao">项目配套</div>
<div class="area_left"  style="width:900px;height:auto;">
<div id="some_queue" style="width:700px;height:auto;"></div>
 <input type="file" name="projectimage" id="projectimage"  multiple  style="width:700px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#" class="addpeitao">添加</a>
<!--  <div id="uploader" class="wu-example">
    <div id="thelist" class="uploader-list"></div>
    <div class="btns">
        <div id="picker">选择文件</div>
        <button id="ctlBtn" class="btn btn-default">开始上传</button>
    </div>
</div>
 <div style="float:right:padding-right:40px;"><a href="#" class="addpeitao">添加</a></div> -->
 </div>
 
<!--   -->
 
<div id="peitaolist">
<!-- <div style="float:left;padding-left:40px;">
<span style="padding-right:10px;">1</span>
<span class="">圣大非省说法是否圣大非省是撒旦发生。jpg</span><span style="padding-left: 30px;padding-right: 40px;"><a href="#" style="padding-right:10px;" class="editpeitao">编辑</a><a href="#" class="deletepeitao">删除</a></span>
</div> -->
</div>



<!-- ****************************************************项目配套end***************************************************** -->

<!-- ****************************************************附近配套start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="nearpeitao">附近配套</div>
<form id="fujin">
<div class="area_left">
<span class="area_span">配套类型</span><span><input type="text" id="peitao_type" name="peitao_type" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">配套名称</span><span><input type="text" id="peitao_name" name="peitao_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">配套距离</span><span><input type="text" id="peitao_distance" name="peitao_distance" class="area_input"></span>
</div>
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addfujin">添加</a></div>
</form>
<div id="fujinlist">

</div>
<!-- ****************************************************附近配套end***************************************************** -->

<!-- ****************************************************附近学校start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="nearschool">附近学校</div>
<div class="area_left">
<span class="area_span">学校名称</span>
<span>
<select class="area_select" id="school_name" name="school_name">
  <option >学校1</option>
  <option >学校2</option>
  <option>学校3</option>
</select>
</span>
<!-- <span><input type="text" id="school_name" name="school_name" class="area_input"></span> -->
</div>
<div class="area_right">
<span class="area_span">学校距离</span><span><input type="text" id="school_distance" name="school_distance" class="area_input"></span>
</div>


<!-- ****************************************************附近学校end***************************************************** -->

<!-- ****************************************************持有成本start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="holdcost">持有成本</div>
<div class="area_left">
<span class="area_span">类型</span><span><input type="text" id="holdcosttype" name="holdcosttype" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">价格</span><span><input type="text" id="holdcostprice" name="holdcostprice" class="area_input"></span>
</div>
<div class="chang_left2">
<span class="area_span">描述</span><span><input type="text" id="holdcostdesc" name="holdcostdesc" class="chang_input2"></span>
</div>
<div class="area_left">
<span class="area_span">户型名称</span><span><input type="text" id="holdcost_housename" name="holdcost_housename" class="area_input"></span>
</div>

<!-- ****************************************************持有成本end***************************************************** -->

<!-- ****************************************************购房税费start***************************************************** -->
<div class="area_bkg2" style="clear:both;" id="housetax">购房税费</div>
<div class="area_left">
<span class="area_span">类型</span><span><input type="text" id="houseTaxtype" name="houseTaxtype" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">价格</span><span><input type="text" id="houseTaxprice" name="houseTaxprice" class="area_input"></span>
</div>
<div class="chang_left2">
<span class="area_span">描述</span><span><input type="text" id="houseTaxdesc" name="houseTaxdesc" class="chang_input2"></span>
</div>
<div class="area_left">
<span class="area_span">户型名称</span><span><input type="text" id="houseTax_housename" name="houseTax_housename" class="area_input"></span>
</div>
<!-- ****************************************************购房税费end***************************************************** -->
<!-- <div style="width:900px;clear:both;margin:20px auto;text-align:center;">
<button type="submit" >提交</button>
<button type="reset" >重置</button>
</div> -->
<div style="float:left;">
<div class="area_left4"><button  class="btn" onClick="submitfun()">提交</button></div>
<div class="area_right4"><button type="reset" class="btn">重置</button></div>
</div>

</div>
</div>
<script type="text/javascript">
$(".btn").click(submitfun());
function submitfun(){
	xhr = new XMLHttpRequest();
	xhr.open("post", "/pinput", true);
	xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
	var formobj =  document.getElementById("test")[0];
	var formdata = new FormData(formobj); 
	/* var fd = new FormData(); */
	formdata.append('project_file', "safdasfsad");
	formdata.append('project_file1', "safdasfsad");
	
	xhr.send(formdata);
}
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
})

        function UpladFile(imageid) {
            var fileObj = document.getElementById(imageid).files[0]; // 获取文件对象

            var FileController = "/projectinput";                    // 接收上传文件的后台地址 

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
/* $(function(){
	$("#shangchuanimage").click(function(){
		$.ajax({
				
			});
		});
}); */
/* $(function(){
	var $ = jQuery,
	$list = $('#thelist'),
	$btn = $('#ctlBtn'),
	state = 'pending',
	uploader;
	uploader = new WebUploader.Uploader({
		resize: false,
		swf:'/webuploader-0.1.5/Uploader.swf',
		server: '/projectinput',
		pick: {
			id:'#picker',
			multiple:false
			
		},
		fileVal:'file',
		threads:20,
		duplicate:false
	});

	// 当有文件添加进来的时候
	uploader.on( 'fileQueued', function( file ) {
	$list.append( '<div id="' + file.id + '" class="item">' +
	    '<h4 class="info">' + file.name + '</h4>' +
	    '<p class="state">等待上传...</p>' +
	'</div>' );
	});

	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
	var $li = $( '#'+file.id ),
	    $percent = $li.find('.progress .progress-bar');

	// 避免重复创建
	if ( !$percent.length ) {
	    $percent = $('<div class="progress progress-striped active">' +
	      '<div class="progress-bar" role="progressbar" style="width: 0%">' +
	      '</div>' +
	    '</div>').appendTo( $li ).find('.progress-bar');
	}

	$li.find('p.state').text('上传中');

	$percent.css( 'width', percentage * 100 + '%' );
	});

	uploader.on( 'uploadSuccess', function( file ) {
	$( '#'+file.id ).find('p.state').text('已上传');
	});

	uploader.on( 'uploadError', function( file ) {
	$( '#'+file.id ).find('p.state').text('上传出错');
	});

	uploader.on( 'uploadComplete', function( file ) {
	$( '#'+file.id ).find('.progress').fadeOut();
	});

	uploader.on( 'all', function( type ) {
	if ( type === 'startUpload' ) {
	    state = 'uploading';
	} else if ( type === 'stopUpload' ) {
	    state = 'paused';
	} else if ( type === 'uploadFinished' ) {
	    state = 'done';
	}

	if ( state === 'uploading' ) {
	    $btn.text('暂停上传');
	} else {
	    $btn.text('开始上传');
	}
	});

	$btn.on( 'click', function() {
	if ( state === 'uploading' ) {
	    uploader.stop();
	} else {
	    uploader.upload();
	}
	});
	uploader.on( 'uploadAccept', function( file, response ) {
	    if ( response ) {
	        // 通过return false来告诉组件，此文件上传有错。
	        return true;
	    }
	});
}); */
var peitaolist=[];
var isedit=100;
var edititem;
var peitaocount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addpeitao").click(function(){
		alert(isedit);
		if(isedit==100){
			if($('#projectimage').val()==""){
				alert("请选择文件！");
				return false;}
			var peitao={};
			var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1];
			peitao["name"]=filename/* $('#projectimage').val() */;
			peitao.shunxu=peitaocount+1;
			/* peitao.view= */
			peitaolist.push(peitao);
			UpladFile("projectimage");
			$("#projectimage").val("");
			$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' class='deletepeitao'>删除</a></span></div>")
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			alert("edit");
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			edititem.name=$('#projectimage').val();
			UpladFile("projectimage");
			$("#projectimage").val("");
			alert($("#peitaolist").children().eq(isedit));
			$("#peitaolist").children().eq(++isedit).show();
			isedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#peitaolist").on("click",".deletepeitao",function(){
		peitaolist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		peitaocount--;
		});
	$("#peitaolist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		edititem=peitaolist[index];
		$(this).parent().parent().hide();
		alert(edititem.name);
		//$("#projectimage").val(edititem.name+"");
		alert(index+"index");
		isedit=index;
		}); 
	
});
var huxinglist=[];
var ishuxingedit=100;
var huxingedititem;
var huxingcount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addhuxing").click(function(){
		alert(ishuxingedit);
		if(ishuxingedit==100){
			if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;}
			var huxing={};
			var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1];
			huxing=DataDeal.formToJson(data= decodeURIComponent($("#huxingjiage").serialize(),true));
			huxing=eval("("+huxing+")");
			huxing["houseimg"]=filename/* $('#projectimage').val() */;
			/* peitao.shunxu=peitaocount+1; */
			/* peitao.view= */
			/* alert($("#huxingjiage").serializeArray()); */
			/* huxing.housename=$("#housename").val();
			huxing.houseprice=$("#houseprice").val();
			huxing.room_num=$("#room_num").val();
			huxing.tudi_mianji=$("#tudi_mianji").val();
			huxing.jianzhu_mianji=$("#jianzhu_mianji").val();
			huxing.shinei_mianji=$("#") */
			huxinglist.push(huxing);
			$("#huxingjiagelist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++huxingcount)+"</span><span style='padding-right:10px;'>"+huxinglist[huxingcount-1].houseimg+"</span><span style='padding-right:10px;'>"+huxinglist[huxingcount-1].housename+"</span><span style='padding-right:10px;'>"+huxinglist[huxingcount-1].houseprice+"</span><span >"+huxinglist[huxingcount-1].room_num+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			UpladFile("houseimg");
			$("#huxingjiage input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset(); */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;}
			alert("edit");
			/* var huxing={}; */
			var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1];
			huxingedititem=DataDeal.formToJson(data= decodeURIComponent($("#huxingjiage").serialize(),true));
			huxingedititem=eval("("+huxingedititem+")");
			huxingedititem["houseimg"]=filename;
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			UpladFile("houseimg");
			$("#huxingjiage input").each(function(){
				$(this).val("");
				});
			huxinglist[ishuxingedit]=huxingedititem;
			alert($("#huxingjiagelist").children().eq(isedit));
			$("#huxingjiagelist").children().eq(ishuxingedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(ishuxingedit+1)+"</span><span style='padding-right:10px;'>"+huxinglist[ishuxingedit].houseimg+"</span><span style='padding-right:10px;'>"+huxinglist[ishuxingedit].housename+"</span><span style='padding-right:10px;'>"+huxinglist[ishuxingedit].houseprice+"</span><span >"+huxinglist[ishuxingedit].room_num+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show();
			ishuxingedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#huxingjiagelist").on("click",".deletepeitao",function(){
		huxinglist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		peitaocount--;
		});
	$("#huxingjiagelist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		huxingedititem=huxinglist[index];
		$(this).parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		alert(index+"index");
		ishuxingedit=index;
		$("#housename").val(huxingedititem.housename);
		$("#houseprice").val(huxingedititem.houseprice);
		$("#room_num").val(huxingedititem.room_num);
		$("#tudi_mianji").val(huxingedititem.tudi_mianji);
		$("#jianzhu_mianji").val(huxingedititem.jianzhu_mianji);
		$("#shinei_mianji").val(huxingedititem.shinei_mianji);
		$("#shiwai_mianji").val(huxingedititem.shiwai_mianji);
		$("#wc_num").val(huxingedititem.wc_num);
		}); 
	
});

var fujinlist=[];
var fujinedit=100;
var fujinedititem;
var fujincount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addfujin").click(function(){
		alert(fujinedit);
		if(fujinedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var fujin={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			fujin=DataDeal.formToJson(data= decodeURIComponent($("#fujin").serialize(),true));
			fujin=eval("("+fujin+")");
			/* huxing["houseimg"]=filename *//* $('#projectimage').val() */;
			/* peitao.shunxu=peitaocount+1; */
			/* peitao.view= */
			/* alert($("#huxingjiage").serializeArray()); */
			/* huxing.housename=$("#housename").val();
			huxing.houseprice=$("#houseprice").val();
			huxing.room_num=$("#room_num").val();
			huxing.tudi_mianji=$("#tudi_mianji").val();
			huxing.jianzhu_mianji=$("#jianzhu_mianji").val();
			huxing.shinei_mianji=$("#") */
			fujinlist.push(fujin);
			$("#fujinlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++fujincount)+"</span><span style='padding-right:10px;'>"+fujinlist[fujincount-1].peitao_type+"</span><span style='padding-right:10px;'>"+fujinlist[fujincount-1].peitao_name+"</span><span style='padding-right:10px;'>"+fujinlist[fujincount-1].peitao_distance+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			/* UpladFile("houseimg"); */
			$("#fujin input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			fujinedititem=DataDeal.formToJson(data= decodeURIComponent($("#fujin").serialize(),true));
			fujinedititem=eval("("+huxingedititem+")");
			/* fujinedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#fujin input").each(function(){
				$(this).val("");
				});
			fujinlist[fujinedit]=huxingedititem;
			alert($("#huxingjiagelist").children().eq(isedit));
			$("#huxingjiagelist").children().eq(ishuxingedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(ishuxingedit+1)+"</span><span style='padding-right:10px;'>"+huxinglist[ishuxingedit].houseimg+"</span><span style='padding-right:10px;'>"+huxinglist[ishuxingedit].housename+"</span><span style='padding-right:10px;'>"+huxinglist[ishuxingedit].houseprice+"</span><span >"+huxinglist[ishuxingedit].room_num+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show();
			ishuxingedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#huxingjiagelist").on("click",".deletepeitao",function(){
		huxinglist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		peitaocount--;
		});
	$("#huxingjiagelist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		huxingedititem=huxinglist[index];
		$(this).parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		alert(index+"index");
		ishuxingedit=index;
		$("#housename").val(huxingedititem.housename);
		$("#houseprice").val(huxingedititem.houseprice);
		$("#room_num").val(huxingedititem.room_num);
		$("#tudi_mianji").val(huxingedititem.tudi_mianji);
		$("#jianzhu_mianji").val(huxingedititem.jianzhu_mianji);
		$("#shinei_mianji").val(huxingedititem.shinei_mianji);
		$("#shiwai_mianji").val(huxingedititem.shiwai_mianji);
		$("#wc_num").val(huxingedititem.wc_num);
		}); 
	
});


window.onload=function(){
}
$.ajaxSetup({  
    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
});  
var DataDeal = {  
		//将从form中通过$('#form').serialize()获取的值转成json  
		           formToJson: function (data) {  
		               data=data.replace(/&/g,"\",\"");  
		               data=data.replace(/=/g,"\":\"");  
		               data="{\""+data+"\"}";  
		               return data;  
		            },  
		};  

	

</script>
</body>
</html>