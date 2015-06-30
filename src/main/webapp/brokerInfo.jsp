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
<div class="area_bkg2" >经纪人信息</div>
<form id="brokerinfo">
<div class="area_left">
<span class="area_span">经纪人编号</span><span><input type="text" id="broker_num" name="broker_num" class="area_input" value="${broker.broker_num}"></span>
<input type="hidden" id="id" name="id" class="area_input" value="${broker.id}">
</div>
<div class="area_right">
<span class="area_span">经纪人姓名</span><span><input type="text" id="broker_name" name="broker_name" class="area_input" value="${broker.broker_name}"></span>
</div>
<div class="area_left">
<span class="area_span">掌握语言</span><span><input type="text" id="broker_language" name="broker_language" class="area_input" value="${broker.broker_language}"></span>
</div>
<div class="area_right">
<span class="area_span">所在地区</span><span><input type="text" id="broker_region" name="broker_region" class="area_input" value="${broker.broker_region}"></span>
</div>
<div class="area_left">
<span class="area_span">经纪人类型</span><span><input type="text" id="broker_type" name="broker_type" class="area_input" value="${broker.broker_type}"></span>
</div>
<div class="area_right">
<span class="area_span">经纪人资质</span><span><input type="text" id="broker_zizhi" name="broker_zizhi" class="area_input" value="${broker.broker_zizhi}"></span>
</div>
<div class="area_left">
<span class="area_span ">经纪人经验</span><span><input type="text" id="broker_experience" name="broker_experience" class="area_input" value="${broker.broker_experience}"></span>
</div>
</form>
<div class="c-fix" style="padding-left:35px;">
<span class="area_span">经纪人图片</span>
<span style="float:right;"> <input type="file" name="broker_img" id="broker_img" value="${broker.broker_img}" style="width:677px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a class="addBrokerImage" href="#">上传</a></span>
</div>
<!-- <div id="brokerImglist">

</div> -->
<div class="area_left c-fix">
<span class="area_span">经纪人描述</span>
</div>
<div class="c-fix" style="margin-bottom:15px;"><textarea id="introduction"  value="${broker.introduction}" placeholder="经纪人描述" name="introduction"></textarea></div>

<!-- 
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
 -->





<form id="area">
<div class="area_bkg2 c-fix" id="fuwu">经纪人服务区域</div>
<div class="area_left">
<span class="area_span">区域编号</span><span><input type="text" id="area_code" name="area_code" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu" name="view_shunxu" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addarea">添加</a></span></div>
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
<div style="float:left;padding-left:40px;">
 <c:forEach items="${brokerServiceAreaList}" var="brokerServiceArea" varStatus="status">
 <table>
 <tr>
<td><span style="padding-right:10px">${status.index + 1}</span></td>
<td><span style="padding-right:10px">${brokerServiceArea.area_code}</span></td>
<td><span style="padding-right:10px">${brokerServiceArea.view_shunxu}</span></td>
</tr>
</table>
</c:forEach>
</div>
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
<div class="area_right3"><span class="area_span5"><a href="#" class="addtype">添加</a></span></div>
</form>
<div id="typelist">
<div style="float:left;padding-left:40px;">
 <c:forEach items="${brokerIntegerTypeList}" var="brokerType" varStatus="status">
 <table>
 <tr>
<td><span style="padding-right:10px">${status.index + 1}</span></td>
<td><span style="padding-right:10px">${brokerType.interested_num}</span></td>
<td><span style="padding-right:10px">${brokerType.view_shunxu2}</span></td>
</tr>
</table>
</c:forEach>
</div>
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
$(function(){
	$(".addBrokerImage").click(function(){
		UpladFile("broker_img");
		});
});

var arealist='${brokerServiceAreaListJson}';
arealist=eval("("+arealist+")");
var areaedit=100;
var areaedititem;
var areacount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addarea").click(function(){
		//alert(areaedit);
		if(areaedit==100){
			var area={};
			area=DataDeal.formToJson(data= decodeURIComponent($("#area").serialize(),true));
			area=eval("("+area+")");
			arealist.push(area);
			$('#arealist').append("<div><div class='area_left3'><span style='display:none;'>"+(++areacount)+"</span><span class='area_span'>"+arealist[areacount-1].area_code+"</span><span class='area_span'>"+arealist[areacount-1].view_shunxu+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editarea'>编辑</a></span><span class='area_span5'><a href='#' class='deletearea'>删除</a></span></div></div>");
			$("#area input").each(function(){
				$(this).val("");
				});
			}
		else{
			//alert("edit");
			areaedititem=DataDeal.formToJson(data= decodeURIComponent($("#area").serialize(),true));
			//alert("aaa"+areaedititem);
			areaedititem=eval("("+areaedititem+")");
			$("#area input").each(function(){
				$(this).val("");
			});
			areaedititem.id=arealist[areaedit].id;
			arealist[areaedit]=areaedititem;
			//alert($("#arealist").children().eq(areaedit));
			$("#arealist").children().eq(areaedit).html("<div class='area_left3'><span style='display:none;'>"+(areaedit+1)+"</span><span class='area_span'>"+arealist[areaedit].area_code+"</span><span class='area_span'>"+arealist[areaedit].view_shunxu+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editarea'>编辑</a></span><span class='area_span5'><a href='#' class='deletearea'>删除</a></span></div>").show();
			areaedit=100;
			}
		});
	$("#arealist").on("click",".deletearea",function(){
		/* $(this).parent().parent().prevAll().length */
		arealist.splice($(this).parent().parent().children().eq(0).eq(0).text()-1,1);
		$(this).parent().parent().parent().remove();
		areacount--;
		});
	$("#arealist").on("click",".editarea",function(){
		var index=$(this).parent().parent().parent().children().eq(0).children().eq(0).text()-1;
		//alert(index);
		areaedititem=arealist[index];
		$(this).parent().parent().parent().hide();
		//alert(index+"index");
		areaedit=index;
		$("#area_code").val(areaedititem.area_code);
		$("#view_shunxu").val(areaedititem.view_shunxu);
		}); 
	
});


var typelist='${brokerIntegertypeListJson}';
typelist=eval("("+typelist+")");
var typeedit=100;
var typeedititem;
var typecount=0;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addtype").click(function(){
		//alert(typeedit);
		if(typeedit==100){
			var type={};
			type=DataDeal.formToJson(data= decodeURIComponent($("#type").serialize(),true));
			type=eval("("+type+")");
			typelist.push(type);
			$('#typelist').append("<div><div class='area_left3'><span style='display:none;'>"+(++typecount)+"</span><span class='area_span'>"+typelist[typecount-1].interested_num+"</span><span class='area_span'>"+typelist[typecount-1].view_shunxu2+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='edittype'>编辑</a></span><span class='area_span5'><a href='#' class='deletetype'>删除</a></span></div></div>");
			$("#type input").each(function(){
				$(this).val("");
				});
			}
		else{
			//alert("edit");
			typeedititem=DataDeal.formToJson(data= decodeURIComponent($("#type").serialize(),true));
			typeedititem=eval("("+typeedititem+")");
			$("#type input").each(function(){
				$(this).val("");
				});
			typeedititem.id=typelist[typeedit].id;
			typelist[typeedit]=typeedititem;
			//alert($("#typelist").children().eq(typeedit));
			$("#typelist").children().eq(typeedit).html("<div class='area_left3'><span style='display:none;'>"+(typeedit+1)+"</span><span class='area_span'>"+typelist[typeedit].interested_num+"</span><span class='area_span'>"+typelist[typeedit].view_shunxu2+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='edittype'>编辑</a></span><span class='area_span5'><a href='#' class='deletetype'>删除</a></span></div>").show();
			typeedit=100;
			}
		});
	$("#typelist").on("click",".deletetype",function(){
		/* $(this).parent().parent().prevAll().length */
		typelist.splice($(this).parent().parent().children().eq(0).eq(0).text()-1,1);
		$(this).parent().parent().parent().remove();
		typecount--;
		});
	$("#typelist").on("click",".edittype",function(){
		var index=$(this).parent().parent().parent().children().eq(0).children().eq(0).text()-1;
		//alert(index);
		typeedititem=typelist[index];
		$(this).parent().parent().parent().hide();
		//alert(index+"index");
		typeedit=index;
		$("#interested_num").val(typeedititem.interested_num);
		$("#view_shunxu2").val(typeedititem.view_shunxu2);
		}); 
	
});
</script>

<script type="text/javascript">

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

function saveBroker(){
	var id=$("#id").val();
	alert("id"+id);
	var broker;
	broker=DataDeal.formToJson(data= decodeURIComponent($("#brokerinfo").serialize(),true));
	broker=eval("("+broker+")");
	var filenames=$('#broker_img').val().split("\\");
	var filename=filenames[filenames.length-1];
	broker.broker_img=filename;
	//alert(CKEDITOR.instances.introduction.getData());
	broker.introduction=CKEDITOR.instances.introduction.getData();
	alert(JSON.stringify(broker));
	alert(JSON.stringify(arealist));
	alert(JSON.stringify(typelist));
    $.ajax({
	    type: "POST",
 		async:false, 
		dateType: "json",
		data:{"broker":JSON.stringify(broker),"arealist":JSON.stringify(arealist),"typelist":JSON.stringify(typelist)},
		url: "/EditBrokerInfo?id="+id,
		success:function(data){
			alert("更新成功")
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
	 		data: { id:id,broker_num : broker_num,broker_name : broker_name,broker_language : broker_language,broker_region : broker_region,broker_type : broker_type,broker_zizhi : broker_zizhi,broker_experience : broker_experience,broker_img : broker_img,introduction : introduction,type_num : type_num,type_name : type_name,type_image : type_image,"arealist":JSON.stringify(arealist),"arealist":JSON.stringify(arealist)}, 
	 		dataType: "json",
	 		url: "/EditBroker",
	 		success:function(data){
	 			if(data.flag == 2){
	 				alert("更新成功！");
	 			}else if(data.flag <2){
	 				alert("更新失败！");
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
	  //alert("ehhe")
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