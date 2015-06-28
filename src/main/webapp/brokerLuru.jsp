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
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
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
<%
            String username = null;
       		if(request.getSession().getAttribute("username")==null){
       			out.print("<script>alert('用户请登录。');window.location.href='/index01'</script>");
}
       		
%>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:经纪人录入</div>
<div class="area_bkg2" id="brokerinfo">经纪人信息</div>
<div class="area_left">
<span class="area_span">经纪人编号</span><span><input type="text" id="broker_num" name="broker_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">经纪人姓名</span><span><input type="text" id="broker_name" name="broker_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">掌握语言</span><span><input type="text" id="broker_language" name="broker_language" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">所在地区</span><span><input type="text" id="broker_region" name="broker_region" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">经纪人类型</span><span><input type="text" id="broker_type" name="broker_type" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">经纪人资质</span><span><input type="text" id="broker_zizhi" name="broker_zizhi" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span ">经纪人经验</span><span><input type="text" id="broker_experience" name="broker_experience" class="area_input"></span>
</div>
<div class="c-fix" style="padding-left:35px;">
<span class="area_span">经纪人图片</span>
<span style="float:right;"> <input type="file" name="broker_img" id="broker_img" style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a class="addBrokerImage" href="#">上传</a></span>
</div>
<div id="brokerImglist">

</div>
<div class="area_left c-fix">
<span class="area_span">经纪人描述</span>
</div>
<div class="c-fix" style="margin-bottom:15px;"><textarea id="introduction" placeholder="经纪人描述" name="introduction"></textarea></div>
<div class="area_bkg2 c-fix" id="shanchang">擅长类型</div>
<div class="area_left">
<span class="area_span">类型编号</span><span><input type="text" id="type_num" name="type_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">类型名称</span><span><input type="text" id="type_name" name="type_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">类型图标</span><span><input type="text" id="type_image" name="type_image" class="area_input"></span>
</div>




<div class="area_right"></div>
<form id="area">
<div class="area_bkg2 c-fix" id="fuwu">经纪人服务区域</div>
<div class="area_left">
<span class="area_span">区域编号</span><span><input type="text" id="area_code" name="area_code" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu" name="view_shunxu" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addArea" onclick="add1()">添加</a></span></div>
</form>
<!-- <div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">1</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">2</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div> -->
<div id="arealist">

</div>

<form id="type">
<div class="area_bkg2 c-fix" id="shanchangtype">经纪人擅长类型</div>
<div class="area_left">
<span class="area_span">擅长类型编号</span><span><input type="text" id="interested_num" name="interested_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu2" name="view_shunxu2" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addType" onclick="add2()">添加</a></span></div>
</form>
<div id="typelist">

</div>

<div class="area_left4"><button type="button" class="btn" onclick="saveBroker()">提交</button></div>
<div class="area_right4"><button type="reset" class="btn">重置</button></div>
</div>

<script type="text/javascript">
CKEDITOR.replace( 'introduction' );
</script>


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



var brokerImagelist=[];
var isedit=100;
var edititem;
var brokerImagecount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	
	$(".addBrokerImage").click(function(){
	alert(123);
		alert(isedit);
		if(isedit==100){
			if($('#broker_img').val()==""){
				alert("请选择文件！");
				return false;}
			var image={};
			var filenames=$('#broker_img').val().split("\\");
			var filename=filenames[filenames.length-1];
			image["name"]=filename;    
			//peitao.shunxu=brokerImagecount+1;
			/* peitao.view= */
			brokerImagelist.push(image);
			alert(filename)
			UpladFile("broker_img");
			$("#broker_img").val("");
			$("#brokerImglist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++brokerImagecount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' class='deletepeitao'>删除</a></span></div>")
			
			}
		else{
			alert("edit");
			
			edititem.name=$('#broker_img').val();
			UpladFile("broker_img");
			$("#broker_img").val("");
			alert($("#brokerImglist").children().eq(isedit));
			$("#brokerImglist").children().eq(++isedit).show();
			isedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#brokerImglist").on("click",".deletepeitao",function(){
		brokerImagelist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		brokerImagecount--;
		});
	$("#brokerImglist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		edititem=brokerImagelist[index];
		$(this).parent().parent().hide();
		alert(edititem.name);
		//$("#projectimage").val(edititem.name+"");
		alert(index+"index");
		isedit=index;
		}); 
	
});



var arealist=[];
var areaedit=100;
var areaedititem;
var areacount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addArea").click(function(){
		alert(areaedit);
		if(areaedit==100){
			var area={};
			area=DataDeal.formToJson(data= decodeURIComponent($("#area").serialize(),true));
			area=eval("("+area+")");
			
			arealist.push(area);
			
			$("#arealist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++areacount)+"</span><span style='padding-right:10px;'>"+arealist[areacount-1].area_code+"</span><span style='padding-right:10px;'>"+arealist[areacount-1].view_shunxu+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");

			$("#area input").each(function(){
				$(this).val("");
				});
			
			}
		else{
			
			alert("edit");
			
			areaedititem=DataDeal.formToJson(data= decodeURIComponent($("#area").serialize(),true));
			areaedititem=eval("("+areaedititem+")");
			
			$("#area input").each(function(){
				$(this).val("");
				});
			arealist[areaedit]=areaedititem;
			alert($("#arealist").children().eq(areaedit));
			$("#arealist").children().eq(areaedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(areaedit+1)+"</span><span style='padding-right:10px;'>"+arealist[areaedit].area_code+"</span><span style='padding-right:10px;'>"+arealist[areaedit].view_shunxu+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show();
			areaedit=100;
			
			
			}
		});
	$("#arealist").on("click",".deletepeitao",function(){
		arealist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		areacount--;
		});
	$("#arealist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		areaedititem=arealist[index];
		$(this).parent().parent().hide();
		
		alert(index+"index");
		areaedit=index;
		$("#area_code").val(areaedititem.area_code);
		$("#view_shunxu").val(areaedititem.view_shunxu);
		}); 
	
});
</script>

<script type="text/javascript">
var typelist=[];
var typeedit=100;
var typeedititem;
var typecount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addType").click(function(){
		alert(typeedit);
		if(typeedit==100){
			var type={};
			type=DataDeal.formToJson(data= decodeURIComponent($("#type").serialize(),true));
			type=eval("("+type+")");
			
			typelist.push(type);
			
			$("#typelist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++typecount)+"</span><span style='padding-right:10px;'>"+typelist[typecount-1].interested_num+"</span><span style='padding-right:10px;'>"+typelist[typecount-1].view_shunxu2+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");

			$("#type input").each(function(){
				$(this).val("");
				});
			
			}
		else{
			
			alert("edit");
			
			typeedititem=DataDeal.formToJson(data= decodeURIComponent($("#type").serialize(),true));
			typeedititem=eval("("+typeedititem+")");
			
			$("#type input").each(function(){
				$(this).val("");
				});
			typelist[typeedit]=typeedititem;
			
			$("#typelist").children().eq(typeedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(areaedit+1)+"</span><span style='padding-right:10px;'>"+arealist[areaedit].interested_num+"</span><span style='padding-right:10px;'>"+arealist[areaedit].view_shunxu+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show();
			typeedit=100;
			
			
			}
		});
	$("#typelist").on("click",".deletepeitao",function(){
		typelist.splice($(this).parent().parent().children().eq(0).text()-1,1);
		$(this).parent().parent().empty();
		typecount--;
		});
	$("#typelist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().children().eq(0).text()-1;
		alert(index);
		typeedititem=typelist[index];
		$(this).parent().parent().hide();
		
		alert(index+"index");
		areaedit=index;
		$("#interested_num").val(typeedititem.interested_num);
		$("#view_shunxu2").val(typeedititem.view_shunxu2);
		}); 
	
});
</script>





<script>

function saveBroker(){
	var brokerlist=[];
	var broker = {};
	broker.broker_num=$("#broker_num").val();
	
	 broker. broker_name=$("#broker_name").val();
	  broker. broker_language=$("#broker_language").val();
	  broker. broker_region=$("#broker_region").val();
	  broker. broker_type=$("#broker_type").val();
	  broker.broker_zizhi=$("#broker_zizhi").val();
	  broker. broker_experience=$("#broker_experience").val();
	  broker. broker_img=$("#broker_img").val();
	  broker. introduction=$("#introduction").val();
	  
	  
	  broker. type_num=$("#type_num").val();
	  broker. type_name=$("#type_name").val();
	  broker. type_image=$("#type_image").val();						
	brokerlist.push(broker);
	
	var arealist=[];
	var areaAbout = {};

	areaAbout.broker_num=$("#broker_num").val();
	areaAbout. area_code=$("#area_code").val();
	areaAbout. view_shunxu=$("#view_shunxu").val();
    arealist.push(areaAbout);

    var intelist=[];
	var inteBroker = {};
    inteBroker.broker_num=$("#broker_num").val();
	inteBroker.interested_num=$("#interested_num").val();
	inteBroker.view_shunxu2=$("#view_shunxu2").val();
	intelist.push(inteBroker);
	
	
	var shanchanglist=[];
	var shanchang = {};
    shanchang.broker_num=$("#broker_num").val();
	shanchang.interested_num=$("#interested_num").val();
	shanchang.view_shunxu2=$("#view_shunxu2").val();
	intelist.push(inteBroker);
	
	
    $.ajax({
	    type: "POST",
 		async:false, 
		dateType: "json",
		data:{"brokerlist":JSON.stringify(brokerlist),"arealist":JSON.stringify(arealist),"intelist":JSON.stringify(intelist)},
		url: "/AddBrokerInfo",
		success:function(data){
			alert("添加成功")
		},
		error:function(){
			alert("error")
		}
    });
}

</script>



<script type="text/javascript">
function add(){
	  var broker_num=$("#broker_num").val();
	  var broker_name=$("#broker_name").val();
	  var broker_language=$("#broker_language").val();
	  var broker_region=$("#broker_region").val();
	  var broker_type=$("#broker_type").val();
	  var broker_zizhi=$("#broker_zizhi").val();
	  var broker_experience=$("#broker_experience").val();
	  var broker_img=$("#broker_img").val();
	  var introduction=$("#introduction").val();
	  var type_num=$("#type_num").val();
	  var type_name=$("#type_name").val();
	  var type_image=$("#type_image").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { broker_num : broker_num,broker_name : broker_name,broker_language : broker_language,broker_region : broker_region,broker_type : broker_type,broker_zizhi : broker_zizhi,broker_experience : broker_experience,broker_img : broker_img,introduction : introduction,type_num : type_num,type_name : type_name,type_image : type_image}, 
	 		dataType: "json",
	 		url: "/inputBroker",
	 		success:function(data){
	 			if(data.flag == 2){
	 				alert("添加成功！");
	 			}else if(data.flag <2){
	 				alert("添加失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	  }
  function add1(){
	  var broker_num=$("#broker_num").val();
	  var area_code=$("#area_code").val();
	  var view_shunxu=$("#view_shunxu").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { broker_num : broker_num,area_code : area_code,view_shunxu : view_shunxu}, 
	 		dataType: "json",
	 		url: "/addServiceArea",
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

  function add2(){
	  alert("ehhe")
	  var broker_num=$("#broker_num").val();
	  var interested_num=$("#interested_num").val();
	  var view_shunxu2=$("#view_shunxu2").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { broker_num : broker_num,interested_num : interested_num,view_shunxu : view_shunxu2}, 
	 		dataType: "json",
	 		url: "/addInteType",
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
</script>
</body>
</html>