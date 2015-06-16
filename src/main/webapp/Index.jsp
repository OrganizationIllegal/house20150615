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
		<script type="text/javascript" src="js/jquery.js"></script>
		<script src="/js/jquery-1.11.1.min.js"></script>
		<script src="/js/suggestion.js"></script>
		<!--<script type="text/javascript" src="js/divselect.js"></script>  -->
		<script src="/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/main.js"></script>
		<script type="text/javascript" src="js/houseinfosearch.js"></script>
		
<style style="text/css">		
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
.nobg , .suglist{width:434px;}   /*宽度修改*/

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
   				/*inputselect.val(value);*/
   				/* ul.hide(); */
   				
   			});
   			var ul = $("#terry").find("ul");
   			ul.find("li").find("a").click(function(){
   				var txt = $(this).text();
   				$("#terry").find("cite").html(txt);
   				var value = $(this).attr("selectid");
   				/*inputselect.val(value);*/
   				/* ul.hide(); */
   				
   			});
   			var ul3 = $("#territ").find("ul");
   			ul3.find("li").find("a").click(function(){
   				var txt = $(this).text();
   				$("#territ").find("cite").html(txt);
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
   			if($("#typeInfo").css("display")=="none"){
   				$("#typeInfo").css("display","block");
   			}else{
   				$("#typeInfo").slideUp("fast");
   			}
   		}
   		function city2(){
   			if($("#minimumpriceInfo").css("display")=="none"){
   				$("#minimumpriceInfo").css("display","block");
   				
   			}else{
   				$("#minimumpriceInfo").slideUp("fast");
   			}
   		}
   		function city3(){
   	   		//alert("999");
   			if($("#maxNum").css("display")=="none"){
   				$("#maxNum").css("display","block");
   			}else{
   				$("#maxNum").slideUp("fast");
   			}
   		}

   		
</script>

	</head>
	
<body style="width:auto; margin:0 auto;">
 <jsp:include page="head4index.jsp" />
<%--  <jsp:include page="head4.jsp" /> --%>

	
	<!-- *************************************** main_bkg1 ************************************************** -->
		 <div class="main_bkg" style="background:rgb(30,52,66) url(../pic/indexbg2.png) repeat-x 0 -666px;">
			<div class="main_img">
				<div class="c-fix f-l main_div" id="city">
				 <div id="divselect" onclick="test()" style="width:76px;" class="divselect">
      					<cite style="width:70px; font-family:微软雅黑; font-size:14px;">澳洲</cite>
				      <ul id="test1" style="width:74px;">
				         <li><a href="javascript:;" selectid="1">澳洲</a></li>
				         <!--<li><a href="javascript:;" selectid="2">美洲</a></li>
				         <li><a href="javascript:;" selectid="3">非洲</a></li>-->
				      </ul>
				  </div>
								
					
                    <a id="city1" class="f-l main_lab f-yahei s-14 city" style="cursor:pointer">墨尔本</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer">悉尼</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer">布里斯班</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer">阿德莱德</a>
					<a class="f-l main_lab f-yahei s-14 city" style="cursor:pointer">珀斯</a>
                    
					
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
					<div id="territory" onclick="city1()" style="width:110px; clear:left; margin-top:5px;" class="divselect">
	      				<cite id="city1" style="width:100px; font-family:微软雅黑; font-size:14px; background:url(/pic/jiaoy.png) no-repeat right center; color:#efef39;">房屋类型</cite>
					      <ul id="typeInfo" style="width:94px;">
					         <li><a href="javascript:;" selectid="1">公寓</a></li>
					         <li><a href="javascript:;" selectid="2">别墅</a></li>
					         <li><a href="javascript:;" selectid="3">联排别墅</a></li>
					      </ul>
					      <input type="hidden" name="type" value="" id="typeName">
					 </div>
					 
					 <div id="terry" onclick="city2()" style="width:110px;  margin-top:5px;margin-left:8px;" class="divselect">
	      				<cite id="city2" style="width:100px; font-family:微软雅黑; font-size:14px; background:url(/pic/jiaoy.png) no-repeat right center; color:#efef39;">最小价格</cite>
					      <ul id="minimumpriceInfo" style="width:94px; display:none;">
					         <li><a href="javascript:;" selectid="1">$10,000</a></li>
					         <li><a href="javascript:;" selectid="2">$20,000</a></li>
					         <li><a href="javascript:;" selectid="3">$30,000</a></li>
					      </ul>
					      <input type="hidden" name="minimumprice" value="" id="minimumpriceName">
					 </div>
					 
					 <div id="territ" onclick="city3()" style="width:110px; margin-top:5px; margin-left:8px;" class="divselect">
	      				<cite id="city3" style="width:100px; font-family:微软雅黑; font-size:14px; background:url(/pic/jiaoy.png) no-repeat right center; color:#efef39;">最大价格</cite>
					      <ul id="maxNum" style="width:94px; display:none;">
					         <li><a href="javascript:;" selectid="1">$70,000</a></li>
					         <li><a href="javascript:;" selectid="2">$80,000</a></li>
					         <li><a href="javascript:;" selectid="3">$90,000</a></li>
					      </ul>
					      <input type="hidden" name="maximumprice" value="" id="maximumpriceName">
					 </div>
					 
					<a class="f-l f-yahei s-14 btn_more cp">更多</a>
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
					</div>
					</form>
				</div>
				</div>
		</div>
		
		<!-- *************************************** main_bkg2 ************************************************** -->
	 	<div class="main_bkg2" style="background:#163F66 url(../pic/indexbg4.png) repeat-x 0 -666px;">
			<div style="background:#163F66 url(../pic/indexbg4.png) repeat-x 0 -666px; width:1190px; margin:0 auto; height:155px;">
				<div class="c-fix f-l main_bkg2_div">
					<div style="color:white;font-family:微软雅黑;font-size:46px;font-weight:bolder;position:absolute;filter:alpha(opacity=60);opacity:0.6;top:20px">我们</div>
					<div style="color:white;font-family:微软雅黑;font-size:15px;font-weight:Regular;position:absolute;left:100px;margin-top:30px;">我们应用互联网思维和技术，为您提供更全、更多的海外项目信息，通过全方位服务，让您更方便、更快捷、更省钱的买到更适合的海外房产</div>
					<div style="color:white;font-family:微软雅黑;font-size:33px;font-weight:bolder;font-family:黑体;position:absolute;filter:alpha(opacity=60);opacity:0.6;top:80px;border-top:2px solid white;letter-spacing:5px;">重新定义海外置业模式</div>
					<div style="color:white;font-family:微软雅黑;font-size:15px;font-weight:Regular;position:absolute;left:415px;top:73px;width:179px;">每天上百个新房源满足了越来越多的客户海外需求</div>
				</div>
			</div>
		</div>  
		
		<!-- *************************************** main_bkg3 ************************************************** -->
	<div class="main_bkg3">
	   <div id="myCarousel" class="carousel slide" style="height:500px;width:1190px; margin:0 auto;">
	   <!-- 轮播（Carousel）指标 -->
	   <ol class="carousel-indicators">
	      <li data-target="#myCarousel" data-slide-to="0" class="active" style="background-color:#8E8E8E"></li>
	      <li data-target="#myCarousel" data-slide-to="1" style="background-color:#8E8E8E"></li>
	      <li data-target="#myCarousel" data-slide-to="2" style="background-color:#8E8E8E"></li>
	   </ol>   
	<!--    轮播（Carousel）项目 -->
	   <div class="carousel-inner">
	      <div class="item active">
	         <img src="pic/a.jpg" alt="First slide">
	         <div class="carousel-caption"></div>
	      </div>
	      <div class="item">
	         <img src="pic/a.jpg" alt="Second slide">
	         <div class="carousel-caption"></div>
	      </div>
	      <div class="item">
	        <img src="pic/90.jpg" alt="Third slide"> 
	     
	          <div id="map"  alt="Third slide">
	         	<div></div>
	         	<div  style="margin-top:150px">
	         		<div><span style="font-family:微软雅黑;font-size:25px">海景房源</span></div>
	         		<div><span style="font-family:微软雅黑;font-weight:bolder;font-size:46px">10000+公寓/别墅</span></div>
	         		<div><span style="font-family:微软雅黑;font-size:15px">海房优选提供超过300个澳洲优选项目</span></div>
	         		<div><span style="font-family:微软雅黑;font-size:15px">超过10000套真实房源</span></div>
	         		<div><span style="font-family:微软雅黑;font-size:15px">每天实时更新最新房源</span></div>
	         	</div>
	         	<div style="margin-top:100px" ><!-- <img src="pic/pomap.jpg" style="width:400px;"/> --></div>
	         	<div ></div>
	         	
	         </div>
	   
	         <div class="carousel-caption"></div>
	      </div>
	   	</div>
		</div>
   </div>
 
   
   <!-- *************************************** main_bkg4 ************************************************** -->
	 <div class="main_bkg4" style="background:#ECEAEB url(../pic/indexbg6.png) repeat-x 0 -666px;">
			<div class="main_bkg4_div" style="background:#ECEAEB url(../pic/indexbg6.png) repeat-x 0 -666px;">
				<a class="c-fix f-l f-yahei s-20 main_title fw">为您提供最好的海外购房服务</a>
				<div class="c-fix f-l large_icon"></div>
				<div class="f-l large_icon2"></div>
				<div class="f-r large_icon3"></div>
				<span class="c-fix f-l large_icon_lab f-yahei s-14"><a class="fw">互联网科技：</a>我们通过互联网科技提供完整、详细、及时的房源及细节信息，使你更聪明，更方便的购买你所需的房产。</span>
				<span class="f-l large_icon_lab2 f-yahei s-14"><a class="fw">完整的购房服务：</a>7*24小时全天候在线，全方位服务的专业代理服务。我们提供了基于您的满意付费房地产经纪人。</span>
				<span class="f-r large_icon_lab3 f-yahei s-14"><a class="fw">难以置信的收益：</a>在海房优选购买房产，我们提供高达70%现金返还。</span>
			</div>
	</div>
		
		
		 <!-- *************************************** main_bkg5 ************************************************** -->
		<div class="main_bkg5">
			<div class=" main_bkg5_div">
				<a class="c-fix f-l f-yahei s-20 main_title2 fw">购房返利</a>
				<img class="c-fix f-l main_round" src="images/round1.jpg"></img>
				<div class="f-l main_round_middle">
					<a class="c-fix f-l lab_money f-arial fw">$17,500</a>
					<a class="c-fix f-l f-yahei s-16 middle_lab fw">佣金返还</a>
				</div>
				<img class="f-r main_round" src="images/round2.jpg"></img>
			</div>
			<img class="c-fix f-l main_bkg5_line" src="images/line.png"></img>
			<a class="c-fix f-l middle_lab2 f-yahei s-16">在海房优选购买澳洲新房</a>
			<a class="c-fix f-l middle_lab2 f-yahei s-16" style="margin-top:5px;">最高可获得高达70%的佣金返还</a>
			<a class="c-fix f-l middle_lab2 f-yahei s-12" style="margin-top:20px;">*以房价50万元澳币房产计算</a>
		</div>
		
		
		 <!-- *************************************** main_bkg6 ************************************************** -->
		 <div class="main_bkg6" style="-background:#ECEAEB url(../pic/indexbg7.png) repeat-x 0 -666px;">
			<div style="width:1190px; margin:0 auto; background:#ECEAEB url(../pic/indexbg7.png) repeat-x 0 -666px;">
			<div class="main_bkg6_div">
			<c:if test="${!empty projectList }">
				<a class="c-fix f-l f-yahei s-16 main_lab2">墨尔本</a>
				<c:forEach var="item" items="${projectList}" varStatus="stat">
				<div class="f-l main_node" <c:if test="${stat.index != 0}">style="margin-left:30px;"</c:if>>
					<a href="/Index?proNum=${item.project_num}"><img src="http://101.200.174.253:8080/all/${item.project_img }" class="c-fix f-l main_node_img"></img></a>
						<div class="c-fix f-l main_node_bkg">
							<a class="c-fix f-l main_node_lab f-yahei s-14" style="margin-top:5px;">${item.project_name}</a>
							<a class="c-fix f-l main_node_lab f-yahei s-14" style="font-style:italic;color:red">$${item.project_min_price}-$${item.project_high_price}</a>
							<a class="c-fix f-l main_node_lab f-yahei s-14">${item.project_area},${item.project_city}</a>
						</div>
					
				</div>
			</c:forEach>
			</c:if>
				<c:if test="${!empty projectList2 }">
					<a class="c-fix f-l f-yahei s-16 main_lab2" style="margin-top:-60px;">悉尼</a>
					<c:forEach var="item" items="${projectList2}" varStatus="stat">
						<div class="f-l main_node" style="margin-top:-20px;<c:if test="${stat.index != 0}">margin-left:30px;</c:if>">
						  <a href="/Index?proNum=${item.project_num}"><img src="http://101.200.174.253:8080/all/${item.project_img }" class="c-fix f-l main_node_img"></img></a>
							<div class="c-fix f-l main_node_bkg">
								<a class="c-fix f-l main_node_lab f-yahei s-14" style="margin-top:5px;">${item.project_name}</a>
								<a class="c-fix f-l main_node_lab f-yahei s-14" style="font-style:italic;color:red">$${item.project_min_price}-$${item.project_high_price}</a>
								<a class="c-fix f-l main_node_lab f-yahei s-14">${item.project_area},${item.project_city}</a>
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
							<img src="http://101.200.174.253:8080/all/${item.news_image}" class="c-fix f-l main_node_img"></img>
							<a href="/Detail?id=${item.id}&type=1" style="text-decoration:none" class="c-fix f-l main_node_article f-yahei s-14">
							<c:if test="${fn:length(item.news_abstract) > 30}">
								${fn:substring(item.news_abstract, 0, 30)}...</a>
							</c:if>
						</div>
						</c:forEach>
					</c:if> 
				</div>
			</div> 
	
	<jsp:include page="foot4index.jsp" /> 
		
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
						window.open("/IndexSearch?searchcity="+encodeURIComponent($(this).text()),"_blank");
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

    function s0(o,key){
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
    }
    function checkForm(){
        var _input=$("#searchTerritory").val();
        if(_input.length>40){
            _input = _input.substring(0,40);
            $("#searchTerritory").val(_input);
        }
    }
    
    $(function(){
    
	/* $('#_suggestion >.suginner > .suglist').on('click', 'li', function () {
		window.location.href="/IndexSearch"+encodeURIComponent($(this).text());
				}); */
	/* $('#_suggestion .suginner ').delegate('ul', 'click', function () {
    	alert("ok");
	}); */
});
 
 </script>




