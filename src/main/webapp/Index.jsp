<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head> 
		<title>HouseSale</title> 
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/main.css" />
		<link rel="stylesheet" type="text/css" href="css/newstyle.css" />
		<link rel="stylesheet" type="text/css" href="css/selectDIV.css" />
		<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
		<!-- <script type="text/javascript" src="js/jquery.js"></script> -->
		<script src="/js/jquery-1.11.1.min.js"></script>
		<script src="/js/suggestion.js"></script>
		<!--<script type="text/javascript" src="js/divselect.js"></script>  -->
		<script src="/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/main.js"></script>
		<script type="text/javascript" src="js/houseinfosearch.js"></script>
		
<style style="text/css">	
	@font-face {
	  font-family: 'hanyi';
	  src: url('../font/pinghei.eot');
	  src:
	    url('../font/pinghei.eot?#font-spider') format('embedded-opentype'),
	    url('../font/pinghei.woff') format('woff'),
	    url('../font/汉仪综艺体简.ttf') format('truetype'),
	    url('../font/pinghei.svg') format('svg');
	  font-weight: normal;
	  font-style: normal;
	}
	/*使用选择器指定字体*/
	.mainfont{
	    font-family: 'hanyi';
	    color: white;
    	font-size: 72px;
    	
	}
	.suglist {
	width:233px;
	list-style:none;
	font-size:14px;
	padding:4px 0;
	float:left;
	margin:0px;
}
.suglist li {
	padding:0 9px;
	cursor:pointer;
	zoom:1;
	height:27px;
	line-height:27px;
}

.suglist li.cur, .slhover {
	background:#F3F3F3;
	color:#1E8D00;
}

.nobg , .suginner{background:#fff;}
.nobg , .suglist{width:365px;}   /*宽度修改*/

.suginner_nobg {
	background:none;
}
.suginner:after {
	clear:both;
	content:" ";
	visibility:hidden;
	overflow:hidden;
	height:0;
	display:block;
}
.chengshi a:hover{color:white}
</style>
 <script type="text/javascript">
   		$().ready(function(){
   		 /*  $('.carousel').carousel({
   		     interval: 3000
   		    }); */
   		   $("#typeInfo").click(function(){
   			 var temp = $("#cite1").text();
   			 $("#typeName").val(temp);
   	   	   })
   	   	    $("#minimumpriceInfo").click(function(){
   			 var temp = $("#cite2").text();
   			 $("#minimumpriceName").val(temp);
   	   	   })
   	   	    $("#maximumpriceInfo").click(function(){
   			 var temp = $("#cite3").text();
   			 $("#maximumpriceName").val(temp);
   	   	   })
   		   
   		    $("#header2_new").load("../head2_new.jsp");

   			var ul = $("#divselect").find("ul");
   			ul.find("li").find("a").click(function(){
   				var txt = $(this).text();
   				$("#divselect").find("cite").html(txt);
   				var value = $(this).attr("selectid");
   				/*inputselect.val(value);*/
   				/* ul.hide(); */
   				
   			});

   			var ul = $("#territory").find("ul");
   			ul.find("li").find("a").click(function(){
   				var txt = $(this).text();
   				$("#territory").find("cite").html(txt);
   				var value = $(this).attr("selectid");
   				$("#typeInfo").slideUp("fast");
   				/*inputselect.val(value);*/
   				/* ul.hide(); */
   				
   			});
   			var ul = $("#terry").find("ul");
   			ul.find("li").find("a").click(function(){
   				var txt = $(this).text();
   				$("#terry").find("cite").html(txt);
   				var value = $(this).attr("selectid");
   				$("#minimumpriceInfo").slideUp("fast");
   				/*inputselect.val(value);*/
   				/* ul.hide(); */
   				
   			});
   			var ul3 = $("#territ").find("ul");
   			ul3.find("li").find("a").click(function(){
   				var txt = $(this).text();
   				$("#territ").find("cite").html(txt);
   				$("#maxNum").slideUp("fast");
   				//var value = $(this).attr("selectid");
   				/*inputselect.val(value);*/
   				/* ul.hide(); */
   				
   			});

   		});
   		function test(){
   			if($("#test1").css("display")=="none"){
   				$("#test1").css("display","block");
   			}else{
   				$("#test1").slideUp("fast");
   				//alert("2");
   			}
   		}
   		function city1(){
   			/* if($("#typeInfo").css("display")=="none"){
   				$("#typeInfo").css("display","block");
   			}else{
   				$("#typeInfo").slideUp("fast");
   			} */
   			$("#typeInfo").css("display","block");
   			$("#territory").mouseleave(function(){
   		   		$("#typeInfo").slideUp("fast");
   			   	});
   		}
   		function city2(){
   			/* if($("#minimumpriceInfo").css("display")=="none"){
   				$("#minimumpriceInfo").css("display","block");
   				
   			}else{
   				$("#minimumpriceInfo").slideUp("fast");
   			} */
   			$("#minimumpriceInfo").css("display","block");
   			$("#terry").mouseleave(function(){
   		   		$("#minimumpriceInfo").slideUp("fast");
   			   	});
   		}
   		function city3(){
   	   		//alert("999");
   			/* if($("#maxNum").css("display")=="none"){
   				$("#maxNum").css("display","block");
   			}else{
   				$("#maxNum").slideUp("fast");
   			} */
   			$("#maxNum").css("display","block");
   			$("#territ").mouseleave(function(){
   		   		$("#maxNum").slideUp("fast");
   			   	});
   		}

   		
   		/* $(document).click(function(){
   			$("#maxNum").slideUp("fast");
   			$("#minimumpriceInfo").slideUp("fast");
   			$("#typeInfo").slideUp("fast");
   	   		}); */
	   	
</script>

	</head>
	
<body style="width:auto; margin:0 auto;">
 <jsp:include page="head4index.jsp" />
<%--  <jsp:include page="head4.jsp" /> --%>

	<!-- *************************************** main_bkg1 ************************************************** -->
		 <div class="main_bkg" style="background:url(images/海房_index_top.jpg) no-repeat;width: 100%;/* background-attachment: fixed; */
    background-position: center 0;height:480px;background-position-y: 0px;">
		    <!-- <img  src="images/海房_index_top.jpg" style="width:100%;height:480px;margin:0 auto;min-width:1190px;"> -->
		    <!-- <div style="background:url(images/海房_index_top.jpg) no-repeat;width: 100%;background-attachment: fixed;
    background-position: center 0;"></div> -->
    		<div style="width:1190px;height:480px;"></div>
		    <div style="position:relative;top:-330px;margin:0 auto;width:630px;height:90px;text-align: center;">
		    <!--  <img  src="images/index/font1.png" style="width:630px;height:90px;"> -->
		    	<span class="mainfont">聪明海外置业</span>
		    </div>
		    <div style="position:relative;top:-315px;width:540px;height:150px;margin:0 auto;"><img  src="images/index/lankuang.png" style="width:535px;height:150px;">
		    <div style="position:relative;top:-135px;left:30px;width:360px;height:40px;">
		    <!-- <img src="images/index/font2.png" style="width:330px;height:35px;"> -->
		    <span style="font-size:19px;padding-left:10px;color:white;vertical-align: top;font-family: Microsoft Yahei;font-weight: bold;/* position: absolute; */">[澳洲]</span>
		    <span style="color:#fccc2b;font-size:30px;padding-left:2px;font-weight: bold;line-height: 100%;font-family: Microsoft Yahei;/* position: absolute; */">10000+</span>
		    <span style="color:white;font-size:19px;padding-left:0px;font-family: Microsoft Yahei;/* position: absolute; */"> 套</span>
		    <span style="color:white;font-size:19px;padding-left:2px;font-family: Microsoft Yahei;/* position: absolute; */">新房在售</span>
		    </div>
		    <div style="position:relative;top:-130px;left:30px;">
		        <form role="form" name="searchForm" action="/IndexSearch" method="get"  target="_blank" id="housesousuo">
						<input type="text" class="c-fix f-l inp_search" placeholder="请输入期望的城市（区域）" id="searchTerritory" name="searchcity" autocomplete="off" style="background-color:white;width:365px;"></input>
						<!-- <input class="f-l btn_search cp" style="border:none; " type="submit" id="search" target="blank" value=""> -->
						<div class="cp" style="margin-left:15px;width:100px;height:30px;position:relative;top:-30px;left:365px;" id="search" target="blank">
						<img src="images/index/btn1.png"></div>
						<div id="_suggestion" class="suggestion nobg" style="position:absolute;left: 0px; top: 30px; display: none; z-index:999;">			                
						<div class="suginner">
			                    <ul class="suglist"></ul>
			                </div>
                		</div>
                		
                		<div style="width:370px;height:30px;margin-top:15px;" class="chengshi">
					<div id="divselect" onclick="test()" style="width:76px;" class="divselect">
      					<cite style="width:70px; font-family:微软雅黑; -font-size:14px;font-size:16px">澳洲</cite>
				      <ul id="test1" style="width:74px;">
				         <li><a href="javascript:;" selectid="1" style="font-size:16px">澳洲</a></li>
				         <!--<li><a href="javascript:;" selectid="2">美洲</a></li>
				         <li><a href="javascript:;" selectid="3">非洲</a></li>-->
				      </ul>
				    </div>
				    <a id="city1" class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">墨尔本</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">悉尼</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">布里斯班</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">阿德莱德</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">珀斯</a>
				  </div>

				  <div class="btn_more" style="position:relative;top:-38px;left:415px;width:65px;height:20px;cursor:pointer;">

				  <img src="images/index/gaoji.png" style="width:65px;height:20px;">
				  </div>
				  
				  
						<div class="c-fix f-l main_more" style="display:none;position: absolute;top: 73px;z-index: 10;left: -22px;">
						<div class="c-fix f-l main_more_line">
							<a class="c-fix f-l f-yahei s-12 main_more_title">国家</a>
							<input type="radio" name="country" value="" class="f-l main_more_radio more" checked="checked">
							<a class="f-l f-yahei s-12 main_more_name">不限</a>
							<input type="radio" name="country" value="澳大利亚"  class="f-l main_more_radio australia">
							<a class="f-l f-yahei s-12 main_more_name ">澳大利亚</a>
							<input type="radio" name="country" value="加拿大"  class="f-l main_more_radio canada">
							<a class="f-l f-yahei s-12 main_more_name ">加拿大</a>
						</div>
						<div class="c-fix f-l main_more_line" id="australiacity">
							<a class="c-fix f-l f-yahei s-12 main_more_title">城市</a>
							<input type="radio" name="city2" value="" class="f-l main_more_radio" checked="checked">
							<a class="f-l f-yahei s-12 main_more_name">不限</a>
							<input type="radio" name="city2" value="墨尔本" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">墨尔本(Melbourne)</a>
							<input type="radio" name="city2" value="悉尼" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">悉尼(Sydney)</a>
							<input type="radio" name="city2" value="布里斯班" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">布里斯班(Brisbane)</a>
							<input type="radio" name="city2" value="阿德莱德" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">阿德莱德(Adelaide)</a>
							<input type="radio" name="city2" value="珀斯" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">珀斯(Perth)</a>
						</div>
						<div class="c-fix f-l main_more_line" id="canadiancity">
							<a class="c-fix f-l f-yahei s-12 main_more_title">城市</a>
							<input type="radio" name="city2" value="" class="f-l main_more_radio" checked="checked">
							<a class="f-l f-yahei s-12 main_more_name">不限</a>
							<input type="radio" name="city2" value="多伦多" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">多伦多(Toronoto)</a>
							<input type="radio" name="city2" value="温哥华" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">温哥华(Vancouver)</a>
						</div>
						<div class="c-fix f-l main_more_line">
							<a class="c-fix f-l f-yahei s-12 main_more_title">用途</a>
							<input type="checkbox"  class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">不限</a>
							<input type="checkbox" name="xinkaipan" value="新开盘" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">新开盘</a>
							<input type="checkbox" name="huaren" value="华人区" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">华人区</a>
							<input type="checkbox" name="remen" value="热门项目" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">热门项目</a>
							<input type="checkbox" name="xuequ" value="优秀学区" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">优秀学区</a>
							<input type="checkbox" name="baozu" value="包租项目" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">包租项目</a>
							<input type="checkbox" name="daxue" value="大学附近" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">大学附近</a>
							<input type="checkbox" name="center" value="城市中心" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">城市中心</a>
						</div>
						<div class="c-fix f-l main_more_line" style="border-width:0px;">
							<a class="c-fix f-l f-yahei s-12 main_more_title"></a>
							<input type="checkbox" name="traffic" value="轨道交通" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">轨道交通</a>
							<input type="checkbox" name="xianfang" value="现房项目" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">现房项目</a>
							<input type="checkbox" name="maidi" value="买地建房"class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">买地建房</a>
						</div>
						<div class="c-fix f-l main_more_line" style="border-width:0px;text-align:center;height:33px">
							<input  type="button" id="moretijiao" value="提交" style="background-color:#ff6600;width:50px;height:24px;font-family:微软雅黑;line-height: normal;"/>
							<input type="button" id="morequxiao" value="取消 " style="background-color:#ff6600;width:50px;height:24px;font-family:微软雅黑;line-height: normal;"/>
						</div>
					</div>
				</form>
				
		    </div>
		    </div>
			<%-- <div class="main_img">               
				<div class="c-fix f-l main_div" id="city">
				 <div id="divselect" onclick="test()" style="width:76px;" class="divselect">
      					<cite style="width:70px; font-family:微软雅黑; -font-size:14px;font-size:16px">澳洲</cite>
				      <ul id="test1" style="width:74px;">
				         <li><a href="javascript:;" selectid="1" style="font-size:16px">澳洲</a></li>
				         <!--<li><a href="javascript:;" selectid="2">美洲</a></li>
				         <li><a href="javascript:;" selectid="3">非洲</a></li>-->
				      </ul>
				  </div>
								
					
                    <a id="city1" class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">墨尔本</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">悉尼</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">布里斯班</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">阿德莱德</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer;font-size:16px;">珀斯</a>
                    
					
			<form role="form" action="/IndexSearch" method="get"  target="_blank">
					<div class="c-fix f-l main_search">
						<input type="text" class="c-fix f-l inp_search" placeholder="项目名称/区域,城市,邮编" id="searchTerritory" name="searchcity" autocomplete="off"></input>
						<input class="f-l btn_search cp" style="border:none; " type="submit" id="search" target="blank" value="">
						<div id="_suggestion" class="suggestion nobg" style="position:absolute;left: 100px; top: 130px; display: none; z-index:999;">			                <div class="suginner">
			                    <ul class="suglist"></ul>
			                </div>
                		</div>
						<!-- <a class="f-l btn_search cp"></a> -->
						
					</div>
					<div id="territory" onmouseover="city1()" style="width:110px; clear:left; margin-top:5px;" class="divselect">
	      				<cite id="city1" style="width:100px; font-family:微软雅黑; -font-size:14px;font-size:16px; background:url(/pic/jiaoy.png) no-repeat right center; color:#efef39;">房屋类型</cite>
					      <ul onmouseover="city1()"  id="typeInfo" style="width:94px;font-size:16px;">
					         <li><a href="javascript:;" selectid="1" >公寓</a></li>
					         <li><a href="javascript:;" selectid="2">别墅</a></li>
					         <li><a href="javascript:;" selectid="3">联排别墅</a></li>
					      </ul>
					      <input type="hidden" name="type" value="" id="typeName">
					 </div>
					  <!-- onmouseout="city1out()" -->
					 <div id="terry" onmouseover="city2()" style="width:110px;  margin-top:5px;margin-left:8px;" class="divselect">
	      				<cite id="city2" style="width:100px; font-family:微软雅黑; -font-size:14px;font-size:16px; background:url(/pic/jiaoy.png) no-repeat right center; color:#efef39;">最小价格</cite>
					      <ul  onmouseover="city2()"  id="minimumpriceInfo" style="width:94px; display:none;font-size:16px;">
					         <li><a href="javascript:;" selectid="1">$10,000</a></li>
					         <li><a href="javascript:;" selectid="2">$20,000</a></li>
					         <li><a href="javascript:;" selectid="3">$30,000</a></li>
					      </ul>
					      <input type="hidden" name="minimumprice" value="" id="minimumpriceName">
					 </div>
					 <!-- onmouseout="city2out()" -->
					 
					 <div id="territ" onmouseover="city3()"   style="width:110px; margin-top:5px; margin-left:8px;" class="divselect">
	      				<cite id="city3" style="width:100px; font-family:微软雅黑; -font-size:14px;font-size:16px; background:url(/pic/jiaoy.png) no-repeat right center; color:#efef39;">最大价格</cite>
					      <div>
					      <ul  onmouseover="city3()"  id="maxNum" style="width:94px; display:none;font-size:16px;">
					         <li><a href="javascript:;" selectid="1">$70,000</a></li>
					         <li><a href="javascript:;" selectid="2">$80,000</a></li>
					         <li><a href="javascript:;" selectid="3">$90,000</a></li>
					      </ul>
					      </div>
					      <input type="hidden" name="maximumprice" value="" id="maximumpriceName">
					 </div>
					 
					 <!-- onmouseout="city3out()" -->
					<a class="f-l f-yahei s-14 btn_more" style="cursor:pointer;">更多</a>
					<div class="c-fix f-l main_more" style="display:none;">
						<div class="c-fix f-l main_more_line">
							<a class="c-fix f-l f-yahei s-12 main_more_title">国家</a>
							<input type="radio" name="country" value="" class="f-l main_more_radio more" checked="checked">
							<a class="f-l f-yahei s-12 main_more_name">不限</a>
							<input type="radio" name="country" value="澳大利亚"  class="f-l main_more_radio australia">
							<a class="f-l f-yahei s-12 main_more_name ">澳大利亚</a>
							<input type="radio" name="country" value="加拿大"  class="f-l main_more_radio canada">
							<a class="f-l f-yahei s-12 main_more_name ">加拿大</a>
						</div>
						<div class="c-fix f-l main_more_line" id="australiacity">
							<a class="c-fix f-l f-yahei s-12 main_more_title">城市</a>
							<input type="radio" name="city2" value="" class="f-l main_more_radio" checked="checked">
							<a class="f-l f-yahei s-12 main_more_name">不限</a>
							<input type="radio" name="city2" value="墨尔本" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">墨尔本(Melbourne)</a>
							<input type="radio" name="city2" value="悉尼" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">悉尼(Sydney)</a>
							<input type="radio" name="city2" value="布里斯班" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">布里斯班(Brisbane)</a>
							<input type="radio" name="city2" value="阿德莱德" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">阿德莱德(Adelaide)</a>
							<input type="radio" name="city2" value="珀斯" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">珀斯(Perth)</a>
						</div>
						<div class="c-fix f-l main_more_line" id="canadiancity">
							<a class="c-fix f-l f-yahei s-12 main_more_title">城市</a>
							<input type="radio" name="city2" value="" class="f-l main_more_radio" checked="checked">
							<a class="f-l f-yahei s-12 main_more_name">不限</a>
							<input type="radio" name="city2" value="多伦多" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">多伦多(Toronoto)</a>
							<input type="radio" name="city2" value="温哥华" class="f-l main_more_radio">
							<a class="f-l f-yahei s-12 main_more_name">温哥华(Vancouver)</a>
						</div>
						<div class="c-fix f-l main_more_line">
							<a class="c-fix f-l f-yahei s-12 main_more_title">用途</a>
							<input type="checkbox"  class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">不限</a>
							<input type="checkbox" name="xinkaipan" value="新开盘" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">新开盘</a>
							<input type="checkbox" name="huaren" value="华人区" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">华人区</a>
							<input type="checkbox" name="remen" value="热门项目" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">热门项目</a>
							<input type="checkbox" name="xuequ" value="优秀学区" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">优秀学区</a>
							<input type="checkbox" name="baozu" value="包租项目" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">包租项目</a>
							<input type="checkbox" name="daxue" value="大学附近" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">大学附近</a>
							<input type="checkbox" name="center" value="城市中心" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">城市中心</a>
						</div>
						<div class="c-fix f-l main_more_line" style="border-width:0px;">
							<a class="c-fix f-l f-yahei s-12 main_more_title"></a>
							<input type="checkbox" name="traffic" value="轨道交通" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">轨道交通</a>
							<input type="checkbox" name="xianfang" value="现房项目" class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">现房项目</a>
							<input type="checkbox" name="maidi" value="买地建房"class="f-l main_more_check">
							<a class="f-l f-yahei s-12 main_more_name">买地建房</a>
						</div>
						<div class="c-fix f-l main_more_line" style="border-width:0px;text-align:center">
							<input  type="button" id="moretijiao" value="提交" style="background-color:#ff6600;width:50px;height:30px;font-family:微软雅黑;line-height: normal;"/>
							<input type="button" id="morequxiao" value="取消 " style="background-color:#ff6600;width:50px;height:30px;font-family:微软雅黑;line-height: normal;"/>
						</div>
					</div>
					</form>
				</div>
				</div> --%>
		</div>
		
		<!-- *************************************** main_bkg2 ************************************************** -->
	 	<!-- <div class="main_bkg2" style="background:#1763ac url(../pic/indexbg4.png) repeat-x 0 -666px;">
			<div style="background:#1763ac url(../pic/indexbg4.png) repeat-x 0 -666px; width:1190px; margin:0 auto; height:155px;">
				<div class="c-fix f-l main_bkg2_div">
					<div style="color:white;font-family:微软雅黑;font-size:46px;font-weight:bolder;position:absolute;filter:alpha(opacity=60);opacity:0.6;top:20px">我们</div>
					<div style="color:white;font-family:微软雅黑;font-size:15px;font-weight:Regular;position:absolute;left:100px;margin-top:30px;">我们应用互联网思维和技术，为您提供更全、更多的海外项目信息，通过全方位服务，让您更方便、更快捷、更省钱的买到更适合的海外房产</div>
					<div style="color:white;font-family:微软雅黑;font-size:33px;font-weight:bolder;font-family:黑体;position:absolute;filter:alpha(opacity=60);opacity:0.6;top:80px;border-top:2px solid white;letter-spacing:5px;">重新定义海外置业模式</div>
					<div style="color:white;font-family:微软雅黑;font-size:15px;font-weight:Regular;position:absolute;left:415px;top:73px;width:179px;">每天上百个新房源满足了越来越多的客户海外需求</div>
				</div>
			</div>
		</div>   -->
		 <div class="main_bkg2" style="background:#1763ac url(../pic/indexbg4.png) repeat-x 0 -666px;">
			<div style="background:#1763ac url(../pic/indexbg4.png) repeat-x 0 -666px; width:1190px; margin:0 auto; height:155px;">
				<div class="c-fix f-l main_bkg2_div">
					<!-- <div style="color:white;font-family:微软雅黑;font-size:46px;font-weight:bolder;position:absolute;filter:alpha(opacity=60);opacity:0.6;top:20px">我们</div>
					<div style="color:white;font-family:微软雅黑;font-size:15px;font-weight:Regular;position:absolute;left:100px;margin-top:30px;">我们应用互联网思维和技术，为您提供更全、更多的海外项目信息，通过全方位服务，让您更方便、更快捷、更省钱的买到更适合的海外房产</div>
					<div style="color:white;font-family:微软雅黑;font-size:33px;font-weight:bolder;font-family:黑体;position:absolute;filter:alpha(opacity=60);opacity:0.6;top:80px;border-top:2px solid white;letter-spacing:5px;">重新定义海外置业模式</div>
					<div style="color:white;font-family:微软雅黑;font-size:15px;font-weight:Regular;position:absolute;left:415px;top:73px;width:179px;">每天上百个新房源满足了越来越多的客户海外需求</div> -->
					<div style="color:white;font-family:微软雅黑;font-size:33px;font-weight:bolder;margin-top:20px;text-align:center">海外置业新工具</div>
					<div style="color:white;font-family:微软雅黑;font-size:18px;font-weight:Regular;text-align:center;filter:alpha(opacity=60);opacity:0.6;">提供大量真实的房源，全面的房屋信息，购房者可以自由、自主、更聪明的海外置业</div>
				</div>
			</div>
		</div>
		
		<!-- *************************************** main_bkg3 ************************************************** -->
	<!-- <div class="main_bkg3">
	   <div id="myCarousel" class="carousel slide" style="height:500px;width:1190px; margin:0 auto;">
	   轮播（Carousel）指标
	   <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active" style="background-color:#8E8E8E"></li>
	      <li data-target="#myCarousel" data-slide-to="1" style="background-color:#8E8E8E"></li>
	      <li data-target="#myCarousel" data-slide-to="2" style="background-color:#8E8E8E"></li>
	   </ol>   
	   轮播（Carousel）项目
	   <div class="carousel-inner">
	      <div class="item active">
	         <img src="images/index/lunbo1.png" alt="First slide" style="width:1190px;height:500px;">
	         <div class="carousel-caption"></div>
	      </div>
	      <div class="item">
	         <img src="images/index/lunbo2.jpg" alt="Second slide" style="width:1190px;height:500px;">
	         <div class="carousel-caption"></div>
	      </div>
	     
	   	</div>
		</div>
   </div>
  -->
   <div class="main_bkg3" style="height:658px">
	   <div id="myCarousel" class="carousel slide" style="height:642px;width:1190px; margin:0 auto;">
	   <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active" style="background-color:#8E8E8E"></li>
	      <li data-target="#myCarousel" data-slide-to="1" style="background-color:#8E8E8E"></li>
	    <!--   <li data-target="#myCarousel" data-slide-to="2" style="background-color:#8E8E8E"></li> -->
	   </ol>   
	   <div class="carousel-inner">
	      <div class="item active">
	         <img src="images/index/lunbo1.png" alt="First slide" style="width:1190px;height:642px;">
	         <div class="carousel-caption"></div>
	      </div>
	      <div class="item">
	         <img src="images/index/lunbo2.jpg" alt="Second slide" style="width:1190px;height:642px;">
	         <div class="carousel-caption"></div>
	      </div>
	     
	   	</div>
		</div>
   </div>
   
   <!-- *************************************** main_bkg4 ************************************************** -->
	 <div class="main_bkg4" style="background:#ECEAEB url(../pic/indexbg6.png) repeat-x 0 -666px;">
			<div class="main_bkg4_div" style="background:#ECEAEB url(../pic/indexbg6.png) repeat-x 0 -666px;">
				<!-- <a class="c-fix f-l f-yahei s-20 main_title fw" style="width:1190px">为您提供最好的海外购房服务</a>
				<div class="c-fix f-l large_icon"></div>
				<div class="f-l large_icon2"></div>
				<div class="f-r large_icon3"></div>
				<span class="c-fix f-l large_icon_lab f-yahei s-14"><a class="fw" style="color:black">互联网科技：</a>我们通过互联网科技提供完整、详细、及时的房源及细节信息，使你更聪明，更方便的购买你所需的房产。</span>
				<span class="f-l large_icon_lab2 f-yahei s-14"><a class="fw" style="color:black">完整的购房服务：</a>7*24小时全天候在线，全方位服务的专业代理服务。我们提供了基于您的满意付费房地产经纪人。</span>
				<span class="f-r large_icon_lab3 f-yahei s-14"><a class="fw" style="color:black">难以置信的收益：</a>在海房优选购买房产，我们提供高达70%现金返还。</span> -->
				<div class="c-fix f-l f-yahei" style="width:250px;px;height:375px;text-align:center;margin-left: 25px;">
				    <div class="f-yahei fw" style="color:#4a494a;font-size:35px;margin-top:15px;margin-bottom:5px;">华人区</div>
				    <a href="/IndexSearch?huaren=华人区"><img src="images/index/01.png" style="width:230px;height:230px;"></a>
				    <div class="f-yahei" style="color:#888889;font-size:25px;margin-top:5px;">华人聚集地，优质房源</div>
				    <div class="f-yahei cp fw" style="color:#1763ac;font-size:20px;"><a href="/IndexSearch?huaren=华人区">去找房</a></div>
				</div>
				<div class="f-l f-yahei" style="width:292px;height:375px;text-align:center;margin-left: 174px;">
				    <div class="f-yahei fw" style="color:#4a494a;font-size:35px;margin-top:15px;margin-bottom:5px;">学区房</div>
				    <a href="/IndexSearch?xuequ=优秀学区"><img src="images/index/02.png" style="width:230px;height:230px;"></a>
				    <div class="f-yahei" style="color:#888889;font-size:25px;margin-top:5px;">热门学区，海外置业首选</div>
				    <div class="f-yahei cp fw" style="color:#1763ac;font-size:20px;"><a href="/IndexSearch?xuequ=优秀学区">去找房</a></div>
				</div>
				<div class="f-l f-yahei" style="width:278px;height:375px;text-align:center;margin-left: 146px;">
				    <div class="f-yahei fw" style="color:#4a494a;font-size:35px;margin-top:15px;margin-bottom:5px;">市中心</div>
				    <a href="/IndexSearch?center=城市中心"><img src="images/index/03.png" style="width:230px;height:230px;"></a>
				    <div class="f-yahei" style="color:#888889;font-size:25px;margin-top:5px;">城市中心，稀缺房产资源</div>
				    <div class="f-yahei cp fw" style="color:#1763ac;font-size:20px;"><a href="/IndexSearch?center=城市中心">去找房</a></div>
				</div>
			</div>
	</div>
		
		
		 <!-- *************************************** main_bkg5 ************************************************** -->
		<div class="main_bkg5">
			<!-- <div class=" main_bkg5_div">
				<a class="c-fix f-l f-yahei s-20 main_title2 fw">购房返利</a>
				<img class="c-fix f-l main_round" src="images/round1.jpg"></img>
				<img class="c-fix f-l main_round" src="images/round4.jpg"></img>
				<div class="f-l main_round_middle">
					<a class="c-fix f-l lab_money f-arial fw">$17,500</a>
					<a class="c-fix f-l f-yahei s-16 middle_lab fw">佣金返还</a>
				</div>
				<img class="f-r main_round" src="images/round2.jpg"></img>
				<img class="f-r main_round" src="images/round3.jpg"></img>
				
			</div>
			<img class="c-fix f-l main_bkg5_line" src="images/line.png"></img>
			<a class="c-fix f-l middle_lab2 f-yahei s-16">在海房优选购买澳洲新房</a>
			<a class="c-fix f-l middle_lab2 f-yahei s-16" style="margin-top:5px;">最高可获得高达70%的佣金返还</a>
			<a class="c-fix f-l middle_lab2 f-yahei s-12" style="margin-top:20px;">*以房价50万元澳币房产计算</a> -->
			<div class=" main_bkg4_div">
			<div class="c-fix f-l f-yahei" style="width:595px;height:300px;margin-top:100px;padding-left:25px;">
			     <div class="f-yahei" style="color:rgb(74,74,74);font-size:30px;margin-top:15px;margin-bottom:5px;">最适合你的优秀经纪</div>
			     <a href="/SearchService" style="text-decoration: none;">
			          <!-- <img src="images/index/btn3.png" style="width:450px;height:70px;margin-top:5px;"> -->
			           <div style="background-color:rgb(23,99,172);width:450px;height:70px;-webkit-border-radius: 10px;border-radius: 10px;-moz-border-radius:10px; text-align:center;padding-top:8px"class="f-yahei" ><span style="color:white;font-weight:bold;font-size:36px">自主选择经纪人</span></div>
			     </a>
			    <!--  <div class="f-yahei" style="color:rgb(162,162,162);font-size:19px;margin-top:15px;margin-bottom:5px;">购房者可以通过专业背景、本地经验、服务区域、所在区域</div>
			     <div class="f-yahei" style="color:rgb(162,162,162);font-size:19px;margin-top:10px;margin-bottom:5px;">多维度的找到适合自己需求的经纪人</div>
			     <div class="f-yahei" style="color:rgb(162,162,162);font-size:19px;margin-top:10px;margin-bottom:5px;">更简单的开启海外置业。</div> -->
			      <div class="f-yahei" style="color:rgb(162,162,162);font-size:19px;margin-top:15px;margin-bottom:5px;">基于专业背景、本地经验、服务区域、精通语言，</div>
			     <div class="f-yahei" style="color:rgb(162,162,162);font-size:19px;margin-top:10px;margin-bottom:5px;">多维度的找到适合自己需求的经纪人</div>
			</div>
			<div class="f-l" style="width:595px;"><img src="images/index/broker.png" style="margin-left: 98px;"></div>
			</div>
		 </div>
		
		
		 <!-- *************************************** main_bkg6 ************************************************** -->
		 <div class="main_bkg6" style="-background:#ECEAEB url(../pic/indexbg7.png) repeat-x 0 -666px;padding-bottom:15px;">
			<div style="width:1190px; margin:0 auto; background:#ECEAEB url(../pic/indexbg7.png) repeat-x 0 -666px;">
			<div class="main_bkg6_div">
			<c:if test="${!empty projectList }">
				<span class="c-fix f-l f-yahei s-16 main_lab2">墨尔本</span>
				<c:forEach var="item" items="${projectList}" varStatus="stat">
				<div class="f-l main_node" <c:if test="${stat.index != 0}">style="margin-left:30px;"</c:if>>
					<a href="/Index?proNum=${item.project_num}"><img src="<%=application.getInitParameter("imagedir")%>/${item.project_img }" class="c-fix f-l main_node_img"></img></a>
						<div class="c-fix f-l main_node_bkg" onclick="location.href='/Index?proNum=${item.project_num}'">
							<a class="c-fix f-l main_node_lab f-yahei s-14" style="margin-top:5px;text-decoration: none;color:white" href="/Index?proNum=${item.project_num}">${item.project_name}</a>
							<a class="c-fix f-l main_node_lab f-yahei s-14" style="font-style:italic;color:red;text-decoration: none;color:white">$${item.project_min_price}-$${item.project_high_price}</a>
							<a class="c-fix f-l main_node_lab f-yahei s-14" style="text-decoration: none;">${item.project_area},${item.project_city}</a>
						</div>
				</div>
			</c:forEach>
			</c:if>
				<c:if test="${!empty projectList2 }">
					<span class="c-fix f-l f-yahei s-16 main_lab2" style="margin-top:-60px;">悉尼</span>
					<c:forEach var="item" items="${projectList2}" varStatus="stat">
						<div class="f-l main_node" style="margin-top:-20px;<c:if test="${stat.index != 0}">margin-left:30px;</c:if>">
						  <a href="/Index?proNum=${item.project_num}"><img src="<%=application.getInitParameter("imagedir")%>/${item.project_img }" class="c-fix f-l main_node_img"></img></a>
							<div class="c-fix f-l main_node_bkg" onclick="location.href='/Index?proNum=${item.project_num}'">
								<a class="c-fix f-l main_node_lab f-yahei s-14" style="margin-top:5px;text-decoration: none;" href="/Index?proNum=${item.project_num}">${item.project_name}</a>
								<a class="c-fix f-l main_node_lab f-yahei s-14" style="font-style:italic;color:red;text-decoration: none;">$${item.project_min_price}-$${item.project_high_price}</a>
								<a class="c-fix f-l main_node_lab f-yahei s-14" style="text-decoration: none;">${item.project_area},${item.project_city}</a>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>	
		</div> 
		
		 <!-- *************************************** main_bkg7 ************************************************** -->
			<div class="main_bkg7">
				<div class="main_bkg7_div">
				 <c:if test="${!empty newsList }">
					<a class="c-fix f-l f-yahei s-20 main_title fw" style="margin:0 auto">最新博客</a>
						<c:forEach var="item" items="${newsList}" varStatus="stat">
							<div class="f-l main_node" <c:if test="${stat.index != 0}">style="margin-left:30px;"</c:if>>
								<a href="/Detail?id=${item.id}&type=1">
									<img src="<%=application.getInitParameter("imagedir")%>/${item.news_image}" class="c-fix f-l main_node_img" style="width:360px;height:225px"></img>
								</a>
								<a href="/Detail?id=${item.id}&type=1" style="text-decoration:none;width:360px;overflow: hidden;text-overflow: ellipsis;height:50px" class="c-fix f-l main_node_article f-yahei s-14">
								${item.news_abstract}
									<%-- <c:choose>
										<c:when test="${fn:length(item.news_abstract) > 50}">
											${fn:substring(item.news_abstract, 0, 50)}...
										</c:when>
										<c:otherwise>
											${item.news_abstract}
										</c:otherwise>
									</c:choose> --%>
									
								</a>
									</div>
									</c:forEach>
								</c:if>
							</div>
						
					</div>
			
			
	
	<jsp:include page="foot4index.jsp" /> 
	<script type="text/javascript">
	$(function(){
		$("#moretijiao").click(function(){
			$(".main_more").css({'display': 'none'});
			$("#moretijiao").val("提交");
			$("#morequxiao").val("取消");
			$(".btn_more").data("open",false);
			$("#housesousuo").submit();
			});
		$("#morequxiao").click(function(){
			$(".main_more input:radio").attr("checked",false);
			$(".main_more input:checkbox").attr("checked",false);
			$(".main_more").css({'display': 'none'});
			$("#morequxiao").val("取消");
			$("#moretijiao").val("提交");
			$(".btn_more").data("open",false);
			});
    });
	</script>
</body>
</html>

<script type="text/javascript">
  $(".more").on("click",function(){
		    //通过判断按钮btn有没有active这个class名判断是否已经点击过
				$("#australiacity").show();
				$("#canadiancity").show();
		});
 $(".canada").on("click",function(){
		    //通过判断按钮btn有没有active这个class名判断是否已经点击过
		    if($(this).attr("checked")==true){
				$("#australiacity").show();
				$("#canadiancity").hide();
		    }else{
			    
				$("#australiacity").hide();
				$("#canadiancity").show();
		    }
		});
		$(".australia").on("click",function(){
		    //通过判断按钮btn有没有active这个class名判断是否已经点击过
		    if($(this).attr("checked")==true){
				$("#australiacity").hide();
				$("#canadiancity").show();
		    }else{
			    
				$("#australiacity").show();
				$("#canadiancity").hide();
		    }
		});
		
		
 var value = $("#searchTerritory").val();
  		 
   		
   		$(document).ready(function(){
	   		$('.carousel').carousel({
	     		interval: 2000
	    	})
	    	//alert(value)
		    if($('#searchTerritory').val()==""){
		    	$('#searchTerritory').focus();
		    	//$("#_suggestion").hide();
		    	$("#_suggestion").hide();
		    }


})


//IE和firefox
if(navigator.userAgent.toLowerCase().indexOf('msie')>0 || navigator.userAgent.toLowerCase().indexOf('firefox')>0){
    $('#searchTerritory').bind('keyup',function(event){
        if(event.keyCode != "9" && event.keyCode != "38" && event.keyCode!='40') {
            input_suggest();
        }
    });
}else{
    $("#searchTerritory").on('input',function(e){
        input_suggest();
    });
}

$("#searchTerritory").on('focus',function(e){
	 if($('#searchTerritory').val()==""){
	 	
		 $("#_suggestion").hide();
		 
	 }
	 else{
	 	input_suggest();
	 }
    
});

$("#searchTerritory").on('click',function(e){
	 if($('#searchTerritory').val()==""){
		 //input_suggest_recommend();
	 }
	 
});

$("#searchTerritory").on('blur',function(e){      //焦点 
    if(e.target.id!='query' && e.target.className.indexOf("slide")<0){
        //$("#_suggestion").hide();
    }
});
var input_suggest = function(){
	value = $('#searchTerritory').val();
    $.ajax({
        type:"get",
        url:"/getSuggestion",
        dataType:"json",
        async:true,
        data:{query:value},
        success:function(data){
       
            if(data.success && data.list.length>0){
           
                var _html = "";
                 
                for(var i = 0 ; i<10 && i < data.list.length;i++){
                    var _text = data.list[i];
                    if(_text=='' || _text==undefined){
                        continue;
                    }
                    if(_text.length>30){
                        _text = _text.substring(0,30);
                    }
                    var _text = data.list[i];
               //alert(_text.indexOf(value))
                    _html += "<li>";
                    /* var arr=new Array();   
                    arr = _text.split(',');
               
                    for(var i=0; i<arr.length; i++){
                    	var item = $.trim(arr[i]);  
                    	if(item.indexOf(value)==0){
                    		_html += "<strong>"+arr[i]+"</strong>";
                    	}
                    	else{
                    		_html += arr[i];
                    	}
                    		
                    } */
                    //var txt=$.trim(_text);  
                    //alert(txt.indexOf(value));
                   if(_text.indexOf(value)==0){
                	   
                        _text = _text.substring(value.length,_text.length);
                        _html += value+"<strong>"+_text+"</strong>";
                   }/* else if(_text.indexOf(value)==_text.length-4){
                	   var tempText = _text.substring(_text.indexOf(value),_text.length);
                       _html += "<strong>"+_text.substring(0,_text.indexOf(value))+"</strong>"+tempText;
                   } */
                   
                   else{
                        _html += _text;
                   }
                    _html += "</li>"; 
                }
                $("#_suggestion div ul").html(_html);
                
				
                $("#_suggestion div ul li").each(function(){
                
					$(this).on('click',function(event){
						var info = $(this).text();
						$('#searchTerritory').val(info);
						//window.open("/IndexSearch?searchcity="+encodeURIComponent($(this).text()),"_blank");
					});
                }); 
                $("#_suggestion").show();
               
                suggLis = $("#_suggestion div ul li");
                highlight_li = -1;
                hoverFunc('#_suggestion div ul li', 'cur');
            }else{
                $("#_suggestion").hide();
            }
        },
        error:function(){}
    });
};


/* var input_suggest_recommend = function(){
	value = $('#searchTerritory').val();
    $.ajax({
        type:"get",
        url:"/getSuggestionRecommend",
        dataType:"json",
        async:true,
        data:{},
        success:function(data){
       
            if(data.success && data.list.length>0){
           
                var _html = "";
                 
                for(var i = 0 ; i<10 && i < data.list.length;i++){
                    var _text = data.list[i];
                    if(_text=='' || _text==undefined){
                        continue;
                    }
                    if(_text.length>30){
                        _text = _text.substring(0,30);
                    }
                    var _text = data.list[i];
               //alert(_text.indexOf(value))
                    _html += "<li>";
                    /* var arr=new Array();   
                    arr = _text.split(',');
               
                    for(var i=0; i<arr.length; i++){
                    	var item = $.trim(arr[i]);  
                    	if(item.indexOf(value)==0){
                    		_html += "<strong>"+arr[i]+"</strong>";
                    	}
                    	else{
                    		_html += arr[i];
                    	}
                    		
                    } */
                    //var txt=$.trim(_text);  
                    //alert(txt.indexOf(value));
                   /* if(_text.indexOf(value)==0){
                	   
                        _text = _text.substring(value.length,_text.length);
                        _html += value+"<strong>"+_text+"</strong>";
                   }/* else if(_text.indexOf(value)==_text.length-4){
                	   var tempText = _text.substring(_text.indexOf(value),_text.length);
                       _html += "<strong>"+_text.substring(0,_text.indexOf(value))+"</strong>"+tempText;
                   } */
                   
                  /*  else{
                        _html += _text;
                   }
                    _html += "</li>"; 
                }
                $("#_suggestion div ul").html(_html);
                
				
                $("#_suggestion div ul li").each(function(){
                
					$(this).on('click',function(event){
						var info = $(this).text();
						$('#searchTerritory').val(info); */
						//window.open("/IndexSearch?searchcity="+encodeURIComponent($(this).text()),"_blank");
				/* 	});
                }); 
                $("#_suggestion").show();
               
                suggLis = $("#_suggestion div ul li");
                highlight_li = -1;
                hoverFunc('#_suggestion div ul li', 'cur');
            }else{
                $("#_suggestion").hide();
            }
        },
        error:function(){}
    });
}; */

function stopEvent(evt){
    if(evt.preventDefault){
        evt.preventDefault()
    }
    evt.cancelBubble=true;
    return evt.returnValue=false
}
//keydown的处理
function keydown(evt){
    evt = evt||window.event;
    if (evt.keyCode == 27){ //Esc
       $("#_suggestion").hide();
        return stopEvent(evt);
    }else if(evt.keyCode==0x1){
    	alert("zuojian");
    }
    else if(evt.keyCode == 13){ //Enter
    }else{
        if($("#_suggestion").css("display")=="block"){
            if (evt.keyCode == 38){
                upKey();
                return stopEvent(evt);
            }else if (evt.keyCode == 9 || evt.keyCode == 40){
                downKey();
                return stopEvent(evt);
            }
        }else{
            if ((evt.keyCode == 38)||(evt.keyCode == 40)){
                highlight_li = -1;
                clearHighlight();
                $("#_suggestion").show();
            }
        }
    }
}
$(document).click(function(e){
    if(e.target.id!='searchTerritory' && e.target.className.indexOf("slide")<0){
        $("#_suggestion").hide();
    }
});
$(document).bind('keydown',function(event){
    keydown(event);
});


function highlight(){
    clearHighlight();
    if(highlight_li>=0){
        suggLis[highlight_li].className="cur";
        $("#searchTerritory").val($(suggLis[highlight_li]).text());
        $("#w").val("2042")
    }else{
        $("#searchTerritory").val(default_query);
    }
}
function clearHighlight(){
    for(var i=0;i<suggLis.length;i++){
    	suggLis[i].className="";
    }
}

function upKey(){
    clearHighlight();
    highlight_li--;
    if(highlight_li==-2){
        highlight_li=Math.min(suggLis.length,10)-1
    }
    highlight()
}

function downKey(){
    clearHighlight();
    highlight_li++;
    if(highlight_li==Math.min(suggLis.length,10)){
        highlight_li=-1
    }
    highlight()
}
function hoverFunc(select, css){
    $(select).hover(
        function(){
            $(this).addClass(css);
        },
        function(){
            $(this).removeClass(css);
        }
    )
}

    /* function s0(o,key){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&"+key+"="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    }
    function s(o){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&query="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    }
    function s2(o){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&kw="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    }

    function s3(o){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&sp="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    }

    function s4(o){
        var _input=$("#searchTerritory").val();
        if(_input.length>0){
            var h = $(o).attr("search");
            h+="&w="+encodeURIComponent(_input);
            $(o).attr("href",h);
        }
    } */
    function checkForm(){
        var _input=$("#searchTerritory").val();
        if(_input.length>40){
            _input = _input.substring(0,40);
            $("#searchTerritory").val(_input);
        }
    }
    
    $(function(){
    	$("#search").click(function(){
    		
    		document.searchForm.submit();
    	})
	/* $('#_suggestion >.suginner > .suglist').on('click', 'li', function () {
		window.location.href="/IndexSearch"+encodeURIComponent($(this).text());
				}); */
	/* /* $('#_suggestion .suginner ').delegate('ul', 'click', function () {
    	alert("ok"); */
	//}); */
});
    
        
 
 </script>




