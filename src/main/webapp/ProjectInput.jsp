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

<form id="project">

<div class="area_bkg2" id="projectinfo">项目信息</div>
<div class="area_left">
<span class="area_span">项目编号</span><span><input type="text" id="project_code" name="project_code" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">项目名称</span><span><input type="text" id="project_name" name="project_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">项目视频链接</span><span><input type="text" id="project_video" name="project_video" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">项目GPS</span><span><input type="text" id="GPS" name="GPS" class="area_input"></span>
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
<!-- <div class="area_left">
<span class="area_span">项目GPS</span><span><input type="text" id="GPS" name="GPS" class="area_input"></span>
</div> -->
<div class="area_left">
<span class="area_span">更新时间</span><span><input type="text" id="update_time" name="update_time" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">购房税费说明</span><span><input type="text" id="buyTaxInfo" name="buyTaxInfo" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">持有成本说明</span><span><input type="text" id="holdCostInfo" name="holdCostInfo" class="area_input"></span>
</div>
 </form> 
<!-- ****************************************************项目信息end***************************************************** -->

<!-- ****************************************************开发商信息start***************************************************** -->

<form id="developer">
<div class="area_bkg2" style="clear:both;" id="developerinfo">开发商信息</div>
<div class="area_left" style="width:900px">
<span class="area_span">开发商编号</span>
<span>
<select class="area_select" id="developer_code" name="developer_code" style="width:670px">
				 <option value="请选择">请选择</option>
         <c:forEach items="${codeAndNameSet}" var="item">
        		 <option>${item}</option>
       	 </c:forEach>
</select>
</span>
</div>
</form>
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
<form id="school">
<div class="area_left">
<span class="area_span">学校名称</span>
<span>
<select class="area_select" id="school_name" name="school_name">
				  <option>请选择</option>
		 <c:forEach items="${schoolList}" var="item">
        		 <option>${item}</option>
       	 </c:forEach>
</select>
</span>
<!-- <span><input type="text" id="school_name" name="school_name" class="area_input"></span> -->
</div>
<div class="area_right">
<span class="area_span">学校距离</span><span><input type="text" id="school_distance" name="school_distance" class="area_input"></span>
</div>
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addschool">添加</a></div>
</form>
<div id="schoollist">

</div>

<!-- ****************************************************附近学校end***************************************************** -->

<!-- ****************************************************持有成本start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="holdcost">持有成本</div>
<form id="holdingcost">
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
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addholdingcost">添加</a></div>
</form>
<div id="holdingcostlist">

</div>
<!-- ****************************************************持有成本end***************************************************** -->

<!-- ****************************************************购房税费start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="housetax">购房税费</div>
<form id="housetaxform">
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
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addhousetax">添加</a></div>
</form>
<div id="housetaxlist">
</div>
<!-- ****************************************************购房税费end***************************************************** -->
<!-- <div style="width:900px;clear:both;margin:20px auto;text-align:center;">
<button type="submit" >提交</button>
<button type="reset" >重置</button>
</div> -->
<div style="float:left;">

<div class="area_left4"><button  class="btn" onClick="savepro()">提交</button></div>
<div class="area_right4"><button type="reset" class="btn">重置</button></div>
</div>

</div>
</div>
<script type="text/javascript">

$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
})

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

		huxingcount--;

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

			fujinedititem=eval("("+fujinedititem+")");

			/* fujinedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#fujin input").each(function(){
				$(this).val("");
				});

			fujinlist[fujinedit]=fujinedititem;
			alert($("#fujinlist").children().eq(fujinedit));
			$("#fujinlist").children().eq(fujinedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(fujinedit+1)+"</span><span style='padding-right:10px;'>"+fujinlist[fujinedit].peitao_type+"</span><span style='padding-right:10px;'>"+fujinlist[fujinedit].peitao_name+"</span><span style='padding-right:10px;'>"+fujinlist[fujinedit].peitao_distance+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show();
			fujinedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#fujinlist").on("click",".deletepeitao",function(){
		fujinlist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		fujincount--;
		});
	$("#fujinlist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		fujinedititem=fujinlist[index];
		$(this).parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		alert(index+"index");
		fujinedit=index;
		$("#peitao_type").val(fujinedititem.peitao_type);
		$("#peitao_name").val(fujinedititem.peitao_name);
		$("#peitao_distance").val(fujinedititem.peitao_distance);
		}); 
	
});

var schoollist=[];
var schooledit=100;
var schooledititem;
var schoolcount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addschool").click(function(){
		alert(schooledit);
		if(schooledit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var school={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			school=DataDeal.formToJson(data= decodeURIComponent($("#school").serialize(),true));
			school=eval("("+school+")");
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
			schoollist.push(school);
			$("#schoollist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++schoolcount)+"</span><span style='padding-right:10px;'>"+schoollist[schoolcount-1].school_name+"</span><span style='padding-right:10px;'>"+schoollist[schoolcount-1].school_distance+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			/* UpladFile("houseimg"); */
			$("#school input").each(function(){
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
			schooledititem=DataDeal.formToJson(data= decodeURIComponent($("#school").serialize(),true));
			schooledititem=eval("("+schooledititem+")");
			/* schooledititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#school input").each(function(){
				$(this).val("");
				});
			schoollist[schooledit]=schooledititem;
			alert($("#schoollist").children().eq(schooledit));
			$("#schoollist").children().eq(schooledit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(schooledit+1)+"</span><span style='padding-right:10px;'>"+schoollist[schooledit].school_name+"</span><span style='padding-right:10px;'>"+schoollist[schooledit].school_distance+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show();
			schooledit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#schoollist").on("click",".deletepeitao",function(){
		schoollist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		schoolcount--;
		});
	$("#schoollist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		schooledititem=schoollist[index];
		$(this).parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		alert(index+"index");
		schooledit=index;
		$("#school_name").val(schooledititem.school_name);
		$("#school_distance").val(schooledititem.school_distance);
		}); 
	
});

var holdingcostlist=[];
var holdingcostedit=100;
var holdingcostedititem;
var holdingcostcount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addholdingcost").click(function(){
		alert(holdingcostedit);
		if(holdingcostedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var holdingcost={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			holdingcost=DataDeal.formToJson(data= decodeURIComponent($("#holdingcost").serialize(),true));
			holdingcost=eval("("+holdingcost+")");
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
			holdingcostlist.push(holdingcost);
			$("#holdingcostlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++holdingcostcount)+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostcount-1].holdcosttype+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostcount-1].holdcostprice+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostcount-1].holdcostdesc+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostcount-1].holdcost_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			/* UpladFile("houseimg"); */
			$("#holdingcost input").each(function(){
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
			holdingcostedititem=DataDeal.formToJson(data= decodeURIComponent($("#holdingcost").serialize(),true));
			holdingcostedititem=eval("("+holdingcostedititem+")");
			/* holdingcostedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#holdingcost input").each(function(){
				$(this).val("");
				});
			holdingcostlist[holdingcostedit]=holdingcostedititem;
			alert($("#holdingcostlist").children().eq(holdingcostedit));
			$("#holdingcostlist").children().eq(holdingcostedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(holdingcostedit+1)+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostedit].holdcosttype+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostedit].holdcostprice+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostedit].holdcostdesc+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostedit].holdcost_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show();
			holdingcostedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});

	$("#holdingcostlist").on("click",".deletepeitao",function(){
		holdingcostlist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		holdingcostcount--;
		});
	$("#holdingcostlist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		holdingcostedititem=holdingcostlist[index];

		$(this).parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		alert(index+"index");

		holdingcostedit=index;
		$("#holdcosttype").val(holdingcostedititem.holdcosttype);
		$("#holdcostprice").val(holdingcostedititem.holdcostprice);
		$("#holdcostdesc").val(holdingcostedititem.holdcostdesc);
		$("#holdcost_housename").val(holdingcostedititem.holdcost_housename);

		}); 
	
});



var housetaxformlist=[];
var housetaxformedit=100;
var housetaxformedititem;
var housetaxformcount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addhousetaxform").click(function(){
		alert(housetaxformedit);
		if(housetaxformedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var housetaxform={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			housetaxform=DataDeal.formToJson(data= decodeURIComponent($("#housetaxform").serialize(),true));
			housetaxform=eval("("+housetaxform+")");
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
			housetaxformlist.push(housetaxform);
			$("#housetaxformlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++housetaxformcount)+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformcount-1].housetaxformtype+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformcount-1].housetaxformprice+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformcount-1].housetaxformdesc+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformcount-1].housetaxform_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			/* UpladFile("houseimg"); */
			$("#housetaxform input").each(function(){
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
			housetaxformedititem=DataDeal.formToJson(data= decodeURIComponent($("#housetaxform").serialize(),true));
			housetaxformedititem=eval("("+housetaxformedititem+")");
			/* housetaxformedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#housetaxform input").each(function(){
				$(this).val("");
				});
			housetaxformlist[housetaxformedit]=housetaxformedititem;
			alert($("#housetaxformlist").children().eq(housetaxformedit));
			$("#housetaxformlist").children().eq(housetaxformedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(housetaxformedit+1)+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformedit].housetaxformtype+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformedit].housetaxformprice+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformedit].housetaxformdesc+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformedit].housetaxform_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show();
			housetaxformedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#housetaxformlist").on("click",".deletepeitao",function(){
		housetaxformlist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		housetaxformcount--;
		});
	$("#housetaxformlist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		housetaxformedititem=housetaxformlist[index];
		$(this).parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		alert(index+"index");
		housetaxformedit=index;
		$("#housetaxtype").val(housetaxformedititem.housetaxtype);
		$("#housetaxprice").val(housetaxformedititem.housetaxprice);
		$("#housetaxdesc").val(housetaxformedititem.housetaxdesc);
		$("#housetax_housename").val(housetaxformedititem.housetax_housename);
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


<script>

function savepro(){
	/* var list=[];
	var obj={};
	obj.peitao_type="alue1";
	obj.peitao_name="value2";
	obj.peitao_distance="value3";
	list.push(obj);
	var obj1={};
	obj1.peitao_type="aa";
	obj1.peitao_name="bb";
	obj1.peitao_distance="aa";
	list.push(obj1);
	alert("list:"+list); */
	//项目
	var projectlist=[];
	var project = {};
	project.project_name=$("#project_name").val();
	project.project_nation=$("#project_nation").val();
	project.project_address=$("#project_address").val();
	project.project_area=$("#project_area").val();
	project.project_price_qi=$("#danjia").val();
	project.project_sales_remain=$("#keshou").val();
	project.project_finish_time=$("#finish_time").val();
	project.project_desc=$("#project_desc").val();
	project.project_city=$("#project_city").val();
	project.project_house_type=$("#house_type").val();
	project.project_high=$("#ceng").val();
	project.project_lan_en=$("#project_lan_en").val();
	project.project_num=$("#project_code").val();
	project.project_vedio=$("#project_video").val();
	project.project_zhou=$("#project_zhou").val();
	project.project_lan_cn=$("#project_lan_an").val();
	project.gps=$("#GPS").val();
	project.return_money=$("#return_money").val();
	project.walk_num=$("#walk_num").val();
	project.mianji=$("#mianji").val();
	project.project_min_price=$("#minprice").val();
	project.project_high_price=$("#maxprice").val();
	project.tuijiandu=$("#tuijian").val();
	project.housePrice_update_time=$("#update_time").val();
	project.developer_id_name=$("#developer_code").val();
	project.min_area=$("#minarea").val();
	project.max_area=$("#maxarea").val();
	project.buytaxInfo=$("#buyTaxInfo").val();
	project.holdInfo=$("#holdCostInfo").val();								
	projectlist.push(project);


    $.ajax({
	    type: "POST",
 		async:false, 
		dateType: "json",
		data:{"project":JSON.stringify(projectlist),"huxinglist":JSON.stringify(huxinglist)},
		url: "/AddprojectInfo",
		success:function(data){
			alert("添加成功")
		},
		error:function(){
			alert("error")
		}
    });
}

</script>


</script>
</body>
</html>
