<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%> --%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
	<head> 
		<title>HouseSale</title> 
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
			<link rel="stylesheet" type="text/css" href="css/base.css" />
		<link rel="stylesheet" type="text/css" href="css/project.css" />
		<!-- <link type="text/css" rel="stylesheet" href="/css/sli-style.css"> -->
		<!-- <script type="text/javascript" src="js/jquery.js"></script> -->
	    <script type="text/javascript" src="/js/jquery.min.js"></script>
		<script type="text/javascript" src="js/project.js"></script>
		<script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0"></script>
		 <script src="/js/bingMapIndex.js"></script>
		 <!-- <script src="/js/slides-1.1.1-min.js" type="text/javascript"></script> -->
		 <link href="css/style.css" rel="stylesheet" type="text/css" />
   <link href="css/style_project.css" rel="stylesheet" type="text/css" /> 
    <!-- <link href="/css/sli-style.css" rel="stylesheet" type="text/css" />  -->
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <!-- <link href="css/examples.css" rel="stylesheet" type="text/css" media="screen"/> -->
   <!-- <link href="css/slider-pro.min.css" rel="stylesheet" type="text/css" media="screen"/> -->
   <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600' rel='stylesheet' type='text/css'>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <!-- <script src="/js/jquery.sliderPro.min.js"></script> -->
  <link href="/css/index.css" rel="stylesheet">
   <!-- <script src="http://echarts.baidu.com/build/dist/echarts-all.js" charset="utf-8"></script> -->
   <link href="/css/List-Grid-View.css" rel="stylesheet">
   <script src="/echarts/echarts-all.js"></script>
   <!-- <link href="./bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- <link href="/css/pgwslider.min.css" rel="stylesheet"> -->
<link href="/css/video-js.css" rel="stylesheet" type="text/css">
<!-- <script type="text/javascript" src="js/script.js"></script> -->
<script type="text/javascript" src="js/script_p.js"></script>
<script src="js/video.js"></script>
<script type="text/javascript" src="http://player.youku.com/jsapi"></script>
<script>videojs.options.flash.swf = "/js/video-js.swf";</script>
		<style type="text/css">
			.active a{
				background-color: rgb(169, 193, 217)!important;
			}
			.agent_avatar{
				margin-top:7px;
			}
			#indexMap{
				 position: relative;
		 		 width: 490px;
		  		 height: 490px;
			}
			#eyeMap{
				 position: relative;
		 		 width: 490px;
		  		 height: 490px;
			}
			
			
			.succesny{
			  width:990px;
			  height:600px;
			  margin:0 auto;
			  background:#fff;
			}
			.thumbWrap {
			   width:240px;
			   background: none;
			}
			.thumbPrev {
				left:70px;
			}
			.thumbNext {
			    left:70px;
			}
			.succescont .control{
				 background: none;
			}
			.title{
				background:none;
			}
			
			
		</style>
<script type="text/javascript">



function lunbo(){
	//alert("lunbo")
	var animate_time=200;//锟斤拷锟斤拷时锟戒：0.3锟斤拷
	var interval_time=5000;//锟斤拷锟脚硷拷锟绞憋拷洌�锟斤拷
	var ad_size=jQuery(".ad_position .limit .ad_small_box ul li").size()-1;//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	var ad_huandeng_click_i = 0;//锟斤拷始锟斤拷
	
	//循锟斤拷锟斤拷锟斤拷
	function ad_huandeng_play(){
		
		ad_huandeng_click_i++;

		if(ad_huandeng_click_i<=ad_size)
			{jQuery(".ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");}
		else
			{jQuery(".ad_small_box ul li").eq(0).trigger("dblclick");ad_huandeng_click_i = 0}
	}
	//锟斤拷锟斤拷循锟斤拷时锟戒，锟皆讹拷锟斤拷始循锟斤拷
	var ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);
	
	//锟斤拷停锟斤拷锟斤拷锟斤拷锟绞憋拷锟斤拷锟酵Ｖ�
	jQuery(".ad_position").hover(function(){clearInterval(ad_huandeng_setInterval);}, function(){ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);});
	//小图锟斤拷锟绞憋拷锟斤拷锟绞硷拷锟斤拷锟�
	jQuery(".ad_position .limit .ad_small_box ul li").dblclick(function(){
		ad_huandeng_click_i=jQuery(".ad_position .limit .ad_small_box ul li").index(jQuery(this));		
		jQuery(".ad_position .limit .ad_left_big").animate({"margin-top":ad_huandeng_click_i*-474},{duration:animate_time,queue:false});//锟斤拷图锟斤拷锟斤拷
		if(ad_huandeng_click_i<ad_size)//锟斤拷小图锟斤拷锟斤拷锟斤拷锟斤拷锟绞撅拷锟斤拷锟绞憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			{
				if(ad_huandeng_click_i==0||ad_huandeng_click_i==1)
					{jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":"0px"},{duration:animate_time,queue:false});}
				else
					{
						jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":(ad_huandeng_click_i-1)*-146},{duration:animate_time,queue:false});
					}
			}		
		if(ad_huandeng_click_i==0)//锟斤拷始锟叫讹拷指示锟斤拷图片锟斤拷位锟斤拷
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","0px");}
		else if(ad_huandeng_click_i==ad_size)
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","293px");} 
		else
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","146px");}
		//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
		//jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).css("opacity","1");
		//锟叫讹拷锟斤拷锟铰帮拷钮锟角凤拷傻锟斤拷
		if(ad_huandeng_click_i==0)
			{
				jQuery(".ad_small_box .top_button").addClass("off");
//				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
		else if(ad_huandeng_click_i==ad_size)
			{
//				jQuery(".ad_small_box .top_button").removeClass("off");
				jQuery(".ad_small_box .bottom_button").addClass("off");
			}
		else 
			{
//				jQuery(".ad_small_box .top_button").removeClass("off");
//				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
	});
	
	//锟斤拷锟斤拷锟叫⊥硷拷锟斤拷锟酵Ｊ憋拷锟斤拷锟斤拷锟狡讹拷
	jQuery(".ad_position .limit .ad_small_box ul li").mouseover(function(){		
		var small_ad_hover_i = jQuery(".ad_position .limit .ad_small_box ul li").index(jQuery(this));
		var this_ad_top=jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top");
		this_ad_top=parseInt(this_ad_top);
		jQuery(".ad_position .limit .ad_left_big").animate({"margin-top":small_ad_hover_i*-474},{duration:animate_time,queue:false});if(small_ad_hover_i!=ad_huandeng_click_i);
		if(small_ad_hover_i==0)
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","0px");}
		else if(small_ad_hover_i<ad_huandeng_click_i)
			{
				if(ad_huandeng_click_i-small_ad_hover_i==1)
					{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top-146);}
				else
					{{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top-296);}}
			}
		else if(small_ad_hover_i>ad_huandeng_click_i)
			{
				if(small_ad_hover_i-ad_huandeng_click_i==1)
					{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top+146);}
				else
					{{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top+296);}}
			}
		ad_huandeng_click_i=small_ad_hover_i;
		//锟叫讹拷锟斤拷锟铰帮拷钮锟角凤拷傻锟斤拷
		if(ad_huandeng_click_i==0)
			{
				jQuery(".ad_small_box .top_button").addClass("off");
//				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
		else if(ad_huandeng_click_i==ad_size)
			{
//				jQuery(".ad_small_box .top_button").removeClass("off");
				jQuery(".ad_small_box .bottom_button").addClass("off");
			}
		else
			{
//				jQuery(".ad_small_box .top_button").removeClass("off");
//				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
		//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
		//jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).css("opacity","1");
	});	
	
	//锟斤拷锟斤拷锟斤拷习锟脚ナ�
	jQuery(".ad_small_box .top_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i-1;
		if(ad_huandeng_click_i<0)
			{ad_huandeng_click_i=0;}		
		jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
	//锟斤拷锟斤拷锟斤拷掳锟脚ナ�
	jQuery(".ad_small_box .bottom_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i+1;
		if(ad_huandeng_click_i>=ad_size)
			{
				ad_huandeng_click_i=ad_size;
				jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");
				jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":(ad_huandeng_click_i-2)*-146},{duration:animate_time,queue:false});
			}
		
		jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
}
function lunbo1(){
	//alert("bulunbo")
	var animate_time=200;//锟斤拷锟斤拷时锟戒：0.3锟斤拷
	var interval_time=5000;//锟斤拷锟脚硷拷锟绞憋拷洌�锟斤拷
	var ad_size=jQuery(".ad_position .limit .ad_small_box ul li").size()-1;//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	var ad_huandeng_click_i = 0;//锟斤拷始锟斤拷
	
	//循锟斤拷锟斤拷锟斤拷
	function ad_huandeng_play(){
		
		ad_huandeng_click_i++;

		if(ad_huandeng_click_i<=ad_size)
			{jQuery(".ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");}
		else
			{jQuery(".ad_small_box ul li").eq(0).trigger("dblclick");ad_huandeng_click_i = 0}
	}
	//锟斤拷锟斤拷循锟斤拷时锟戒，锟皆讹拷锟斤拷始循锟斤拷
	var ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time); 
	
	//锟斤拷停锟斤拷锟斤拷锟斤拷锟绞憋拷锟斤拷锟酵Ｖ�
	jQuery(".ad_position").hover(function(){clearInterval(ad_huandeng_setInterval);}, function(){ad_huandeng_setInterval = setInterval(ad_huandeng_play,interval_time);});
	//小图锟斤拷锟绞憋拷锟斤拷锟绞硷拷锟斤拷锟�
	jQuery(".ad_position .limit .ad_small_box ul li").dblclick(function(){
		ad_huandeng_click_i=jQuery(".ad_position .limit .ad_small_box ul li").index(jQuery(this));
		jQuery(".ad_position .limit .ad_left_big").animate({"margin-top":0},{duration:animate_time,queue:false});
		/* jQuery(".ad_position .limit .ad_left_big").animate({"margin-top":ad_huandeng_click_i*-474},{duration:animate_time,queue:false}); *///锟斤拷图锟斤拷锟斤拷
		if(ad_huandeng_click_i<ad_size)//锟斤拷小图锟斤拷锟斤拷锟斤拷锟斤拷锟绞撅拷锟斤拷锟绞憋拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
			{
				if(ad_huandeng_click_i==0||ad_huandeng_click_i==1)
					{jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":"0px"},{duration:animate_time,queue:false});}
				else
					{
						/* jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":(ad_huandeng_click_i-1)*-138},{duration:animate_time,queue:false}); */
					    jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":"0px"},{duration:animate_time,queue:false});
					}
			}		
		if(ad_huandeng_click_i==0)//锟斤拷始锟叫讹拷指示锟斤拷图片锟斤拷位锟斤拷
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","0px");}
		else if(ad_huandeng_click_i==ad_size)
			{/* jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","288px"); */
			jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","0px");
			}
		else
			{/* jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","144px"); */
			jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","0px");
			}
		//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
		//jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).css("opacity","1");
		//锟叫讹拷锟斤拷锟铰帮拷钮锟角凤拷傻锟斤拷
		if(ad_huandeng_click_i==0)
			{
				jQuery(".ad_small_box .top_button").addClass("off");
//				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
		else if(ad_huandeng_click_i==ad_size)
			{
//				jQuery(".ad_small_box .top_button").removeClass("off");
				jQuery(".ad_small_box .bottom_button").addClass("off");
			}
		else 
			{
//				jQuery(".ad_small_box .top_button").removeClass("off");
//				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
	});
	
	//锟斤拷锟斤拷锟叫⊥硷拷锟斤拷锟酵Ｊ憋拷锟斤拷锟斤拷锟狡讹拷
	jQuery(".ad_position .limit .ad_small_box ul li").mouseover(function(){		
		var small_ad_hover_i = jQuery(".ad_position .limit .ad_small_box ul li").index(jQuery(this));
		var this_ad_top=jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top");
		this_ad_top=parseInt(this_ad_top);
		jQuery(".ad_position .limit .ad_left_big").animate({"margin-top":small_ad_hover_i*-474},{duration:animate_time,queue:false});if(small_ad_hover_i!=ad_huandeng_click_i); 
		if(small_ad_hover_i==0)
			{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top","0px");}
		else if(small_ad_hover_i<ad_huandeng_click_i)
			{
				if(ad_huandeng_click_i-small_ad_hover_i==1)
					{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top-146);}
				else
					{{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top-296);}}
			}
		else if(small_ad_hover_i>ad_huandeng_click_i)
			{
				if(small_ad_hover_i-ad_huandeng_click_i==1)
					{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top+146);}
				else
					{{jQuery(".ad_position .limit .ad_small_box .small_right_limit .this_ad").css("top",this_ad_top+296);}}
			}
		ad_huandeng_click_i=small_ad_hover_i;
		//锟叫讹拷锟斤拷锟铰帮拷钮锟角凤拷傻锟斤拷
		if(ad_huandeng_click_i==0)
			{
				jQuery(".ad_small_box .top_button").addClass("off");
//				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
		else if(ad_huandeng_click_i==ad_size)
			{
//				jQuery(".ad_small_box .top_button").removeClass("off");
				jQuery(".ad_small_box .bottom_button").addClass("off");
			}
		else
			{
//				jQuery(".ad_small_box .top_button").removeClass("off");
//				jQuery(".ad_small_box .bottom_button").removeClass("off");
			}
		//jQuery(".ad_position .limit .ad_small_box ul li").css("opacity","0.5");
		//jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).css("opacity","1");
	});	
	
	//锟斤拷锟斤拷锟斤拷习锟脚ナ�
	jQuery(".ad_small_box .top_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i-1;
		if(ad_huandeng_click_i<0)
			{ad_huandeng_click_i=0;}		
		jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
	//锟斤拷锟斤拷锟斤拷掳锟脚ナ�
	jQuery(".ad_small_box .bottom_button").click(function(){
		ad_huandeng_click_i=ad_huandeng_click_i+1;
		if(ad_huandeng_click_i>=ad_size)
			{
				ad_huandeng_click_i=ad_size;
				jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");
				jQuery(".ad_position .limit .ad_small_box ul").animate({"margin-top":(ad_huandeng_click_i-2)*-146},{duration:animate_time,queue:false}); 
			}
		
		jQuery(".ad_position .limit .ad_small_box ul li").eq(ad_huandeng_click_i).trigger("dblclick");
	});
}

$(function(){
	
	var vedioUrl = "${vedio}";
	lunbo();
	 player = new YKU.Player('youkuplayer1',{
		styleid: '0',
		client_id: '6e97509b4cd3378b',
		vid: 'XOTUxNDk2NDQ0',
		events:{
		/* onPlayerReady: function(){ 
			//alert("zhunbei");
			lunbo();
		}, */  
		onPlayStart: function(){
			playVideo();
			lunbo1();
		},
		onPlayEnd: function(){ location.reload();}  
		} 
		});
		function playVideo(){
		player.playVideo();
		alert("kaishi");
		}
		function pauseVideo(){
		player.pauseVideo();
			alert("zanting")
		} 
	//lunbo(); 
	
	//锟矫碉拷片锟斤拷娌ワ拷锟�
});

var imgdir="<%=application.getInitParameter("imagedir")%>";
function compute(){
var a=$('#select1').find("option:selected").val();
var b=$('#select2').find("option:selected").val();
var c=$('#select3').find("option:selected").val();
var d=$('#input1').val();
var e=$('#input2').val();
}




</script>		
		
	</head>
	<body onload="getIndexMap();" style="background:rgb(232, 233, 234);">
	<%! int Judge = 0; %>
	<%
            String username = null;
       		if(request.getSession().getAttribute("username")!=null){
       			out.println("ffffffffff");
       			Judge = 1;   //用户登录
       		}
%>    
		<jsp:include page="head4index.jsp" />
		<div class="c-fix f-l bkg" style="background-image:url(images/header_bkg.jpg)">
			<img src="images/header.jpg" class="c-fix f-l p_header"></img>
		</div>
		<div class="c-fix f-l bkg" style="background-color:rgb(21,63,101);">
			<div class="c-fix p_nav" style="margin:0 auto;">
				<a href="#loc_js" class="c-fix f-l p_nav_btn p_nav_btn_sel f-yahei s-14 cp">项目介绍</a>
				<a href="#loc_hx" class="f-l p_nav_btn f-yahei s-14 cp">户型和价格</a>
				<a class="f-l p_nav_line f-yahei s-14"></a>
				<a href="#loc_wz" class="f-l p_nav_btn f-yahei s-14 cp">项目位置</a>
				<a class="f-l p_nav_line f-yahei s-14"></a>
				<a href="#loc_pt" class="f-l p_nav_btn f-yahei s-14 cp">配套及周边</a>
				<a class="f-l p_nav_line f-yahei s-14"></a>
				<a href="#loc_fy" class="f-l p_nav_btn f-yahei s-14 cp">购房费用</a>
				<a class="f-l p_nav_line f-yahei s-14"></a>
				<a href="#loc_tz" class="f-l p_nav_btn f-yahei s-14 cp">投资分析</a>
			</div>
		</div>
        
 		<div class="c-fix f-l bkg2" style="height: 477px;">
			<div class="c-fix p_intro">
				<!-- <img class="c-fix f-l p_img_big" src="images/tmp_img.jpg"></img>
				<div class="f-r p_img_nav">
					<img class="c-fix f-l p_img_sml cp" src="images/tmp_img_sml.jpg" style="margin-top:5px;"></img>
					<img class="c-fix f-l p_img_sml cp" src="images/tmp_img_sml.jpg"></img>
					<img class="c-fix f-l p_img_sml cp" src="images/tmp_img_sml.jpg"></img>
				</div> -->
				<div style="margin-top:-37px;">
    <div class="ad_position" style="height:447px;/* background-color:white; */">

        <div class="limit" style="height:474px;width:1100px;margin-left:-40px;">
            <div style="float:left;width:750px;display:inline;">
				<input type="hidden" id="Control" value='0'>
                <table class="ad_left_big" width="750" border="0" cellpadding="0" cellspacing="0" style="margin-top: 0px;">
                    <!--  <tr><td><div id="youkuplayer" style="width:750px;height:474px"></div></td>
                    </tr> -->
                    <c:choose>
	                    <c:when test="${empty vedio}">
		                    <c:forEach var="item"  items="${imageList}"   varStatus="status">
		                    <%-- <c:if test="${status.index<2 }"> --%>
		                    	<tr><td><img src="<%=application.getInitParameter("imagedir")%>/${item.image_name}" width="750" height="474" /></td></tr>
		                   <%--  </c:if> --%>
		                    </c:forEach>
	                    </c:when>
	                    <c:otherwise>
	                    	 
		                
			      
			                 	<tr><td><div id="youkuplayer1" style="width:750px;height:474px"></div></td> </tr>
			               
                   
                    			 <c:forEach var="item"  items="${imageList}"   varStatus="status">
			                     <%-- <c:if test="${status.index>0}"> --%>
			                    	<tr><td><img src="<%=application.getInitParameter("imagedir")%>/${item.image_name}" width="750" height="474" /></td></tr>
			                    <%--  </c:if> --%>
			                 </c:forEach>
	                    </c:otherwise>
	                   
		            </c:choose>
                 </table>
            </div>

            <div class="ad_small_box" style="width:224px;height:474px;margin-left:20px;">
                <div class="top_button off"></div>
                <div class="small_right_limit" style="padding:0px;">
                    <ul>
                    <c:choose>
                    	<c:when test="${empty vedio}">
		                    <c:forEach var="item"  items="${imageList}"   varStatus="status">
		                    
				            	<li style="margin-top:6px"><img src="<%=application.getInitParameter("imagedir")%>/${item.image_name}" width="210" height="140"/></li>
				             </c:forEach>
		                    
	                    </c:when>
                    
                    	
                    	<c:otherwise>
                    		<%-- <c:forEach var="item"  items="${imageList}"   varStatus="status">
			            		<c:if test="${status.index==0}">
			            			<li style="margin-top:6px"><img src="<%=application.getInitParameter("imagedir")%>/${item.image_name}" width="210" height="140"/></li>
			            		</c:if>
			         		</c:forEach> --%>
			         		<li style="margin-top:6px"><img src="<%=application.getInitParameter("imagedir")%>/au3000_xm_1.jpg" width="210" height="140"/></li>
                     		<c:forEach var="item"  items="${imageList}"   varStatus="status">
			            		<%-- <c:if test="${status.index>0}"> --%>
			            			<li style="margin-top:6px"><img src="<%=application.getInitParameter("imagedir")%>/${item.image_name}" width="210" height="140"/></li>
			            		<%-- </c:if> --%>
			         		</c:forEach>
                    
                    
                    	</c:otherwise>
                    	</c:choose>
                        <%-- <c:forEach var="item"  items="${imageList}"   varStatus="status">
                        <c:if test="${status.index<3}">
                    		<li><img src="<%=application.getInitParameter("imagedir")%>/${item.image_name}" width="210" height="140"/></li>
                    	</c:if>
                    	</c:forEach> --%>
                       
                    </ul>
                    <div class="this_ad" style="top:0px;"><img style="border:blue 2px solid;width:210px;height:140px;margin-left:10px;margin-top:7px;"/></div>
                </div>
                <div class="bottom_button off"></div>
            </div>


        </div>




    </div>
</div>
				
			</div>
		</div> 
		
		<div class="c-fix bkg3" style="margin:0 auto;height:140px;width:990px">
			<div class="c-fix p_panel">
				<div class="c-fix f-l p_panel_left">
					<a class="c-fix f-l p_lab f-arial s-14">${project.developer_id_name}</a>
					<a class="c-fix f-l p_lab f-arial s-16 fw" style="font-size:20px;">${project.project_name}</a>
					<a class="c-fix f-l p_lab f-yahei s-14">价格区间：$${project.project_min_price}-$${project.project_high_price}</a>
					<div class="f-l p_btn_get cp" onclick="pop3()"></div>
				</div>
				<!-- <div class="f-r p_btn_return">返现金额：$${project.return_money}</div> -->
				<input type="hidden" id="projectNum" value="${proNum}">
				<div class="f-r" style="height:30px;width:100px;margin-top:20px">
				<%--  <c:if test="${isCollected=='0'}">
				<button id="shoucang" style="font-size:13px;" onclick="addcollect()" >点击收藏</button>
				</c:if>
				 <c:if test="${isCollected=='1'}">
			    <button id="quxiaoshoucang" style="font-size:13px;background-color:red" onclick="delcollect()" >已收藏</button>
			    </c:if> --%>
			    <input type="button" id="shoucang" style="font-size:13px;" onclick="collect()" ></button>
				</div>
			</div>
		</div>
		<div class="c-fix  bkg3" style="margin:0 auto;height:405px;width:990px">
			<div class="c-fix p_panel">
				<div class="c-fix f-l p_panel_1">
					<a class="c-fix f-l f-yahei s-14 p_panel_title fw">基本信息</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con" style="margin-top:20px;">位置：<span style="font-size:12px;" title="${HouseProject.project_address}">
					         <c:choose> 
								     <c:when test="${fn:length(HouseProject.project_address) > 40}"> 
								      <c:out value="${fn:substring(HouseProject.project_address, 0, 40)}......" /> 
								     </c:when> 
								     <c:otherwise> 
								      <c:out value="${HouseProject.project_address}" /> 
								     </c:otherwise>
							 </c:choose>
							
					   </span>
					</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">类型：${HouseProject.project_type}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">国家：${HouseProject.project_nation}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">州/省：${HouseProject.project_zhou}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">城市：${HouseProject.project_city}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">区域：${HouseProject.project_area}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">面积：${HouseProject.min_area}${HouseProject.mianji}-${HouseProject.max_area}${HouseProject.mianji}</a>
					<!-- <a class="c-fix f-l f-yahei s-14 p_panel_con" id="qimoney">起价：$${HouseProject.project_price_int_qi}</a>  -->
					<a class="c-fix f-l f-yahei s-14 p_panel_con" id="qimoney">起价：$<f:formatNumber value="${HouseProject.project_price_int_qi}" pattern="#,#00.#"/>/平米</a> 
					
					
					<a class="c-fix f-l f-yahei s-14 p_panel_con">户型：${HouseProject.project_house_type}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">层数：${HouseProject.project_high}</a>
					<%-- <a class="c-fix f-l f-yahei s-14 p_panel_con">预计交房期：${timeResule}</a> --%>
					<a class="c-fix f-l f-yahei s-14 p_panel_con">预计交房期：${HouseProject.project_finish_time}</a>
				</div>
				<div class="f-l p_panel_1">
					<a class="c-fix f-l f-yahei s-14 p_panel_title2 fw">开发商信息：${HouseProject.developer_id_name}</a>
					<img class="c-fix f-l p_panel_logo" src="<%=application.getInitParameter("imagedir")%>/${DeveloperInfo.developer_logo }" style="width:110px;height:50px;"></img>
					<a class="c-fix f-l p_panel_intro f-yahei s-14">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${DeveloperInfo.developer_desc}</a>
				</div>
				<div class="f-l p_panel_2" style="height:390px">
					<a class="c-fix f-l f-yahei s-16 p_panel_lab fw" style="-margin-top:30px;margin-left:10px;">想要了解更多？</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_lab fw" style="margin-top:5px;margin-left:10px;">填写信息我们会有专业人士一对一服务</a>
				<c:if test="${!empty userList }">
                  <c:forEach items="${userList}"  var="item">
					<input type="text" class="c-fix f-l p_inp" style="margin-top:20px;" placeholder="姓名"  id="name2" value=${item.nick_name}></input>
					<input type="text" class="c-fix f-l p_inp" placeholder="邮箱" id="email2"value=${item.email}></input>
					<input type="text" class="c-fix f-l p_inp" placeholder="电话" id="tel2" value=${item.tel}></input>
					<!-- <input type="text" class="c-fix f-l p_inp" style="margin-top:10px;" id="message_content2" placeholder="需求"></input> -->
					<textarea class="c-fix f-l p_txt s-14" style="margin-top:10px;" id="message_content2" placeholder="留言"></textarea>
					<button type="button" class="f-l p_btn_submit cp" value="提交"  onclick="submitXuqiuMessage()">提交</button>
				</c:forEach>
				</c:if>
				<c:if test="${empty userList }">
              
					<input type="text" class="c-fix f-l p_inp" style="margin-top:20px;" placeholder="姓名"  id="name2" ></input>
					<input type="text" class="c-fix f-l p_inp" placeholder="邮箱" id="email2"></input>
					<input type="text" class="c-fix f-l p_inp" placeholder="电话" id="tel2" ></input>
					<!-- <input type="text" class="c-fix f-l p_inp" style="margin-top:10px;" placeholder="需求"></input> -->
					<textarea class="c-fix f-l p_txt s-14" style="margin-top:10px;" placeholder="留言"></textarea>
					<button type="button" class="f-l p_btn_submit cp" value="提交" >提交</button>

				</c:if>
					
				</div>
			</div>
		</div>
		<div class="c-fix  bkg3" name="loc_js" id="loc_js" style="margin:0 auto;height:355px;width:990px">
			<div class="c-fix p_panel">
				<div class="c-fix f-l p_panel_3">
					<a class="c-fix f-l f-yahei s-14 p_panel_title3 fw">项目详情</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_name fw">${HouseProject.project_name}</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_content" style="  word-break: break-all;">${HouseProject.project_desc}</a>
					<div class="f-l p_btn_get my_center" onclick="popInfo()"><img src="images/index/proinfobtn.png"></img></div>
				</div>
				<!-- <img class="f-r p_adv" src="images/ad1.png"></img> -->
				<img class="f-r p_adv" src="images/index/proinfo.png"></img>
			</div>
		</div>
		<c:if test="${!empty HouseInfoList }">
		
		
		<div class="c-fix  bkg3"  name="loc_hx" id="loc_hx" style="margin:0 auto;height:365px;width:990px">
			<div class="c-fix p_panel">
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw">户型及价格</a>
				<c:forEach var="obj" items="${HouseInfoList}" varStatus="stat"> 
				<c:if test="${stat.index<4 }">
				<div class="c-fix f-l p_struct_node" <c:if test="${stat.index==0}">style="margin-top:20px;"</c:if>>
				
					<a class="c-fix f-l p_struct_name f-arial s-18 fw">${obj.house_name}</a>
					<div class="f-l p_struct_attr">
						<a class="c-fix f-l attr1 f-yahei s-14 fw">${obj.house_room_num}</a>
						<a class="c-fix f-l attr2 f-yahei s-12 fw">卧室</a>
					</div>
					<div class="f-l p_struct_attr">
						<a class="c-fix f-l attr1 f-yahei s-14 fw">${obj.house_toilet_num}</a>
						<a class="c-fix f-l attr2 f-yahei s-12 fw">卫生间</a>
					</div>
					<c:choose>
						<c:when test="${HouseProject.project_type =='公寓'}">
							<div class="f-l p_struct_attr">
								<a class="c-fix f-l attr1 f-yahei s-14 fw">${obj.house_size_in}</a>
								<a class="c-fix f-l attr2 f-yahei s-12 fw">室内面积</a>
							</div>
							<div class="f-l p_struct_attr">
								<a class="c-fix f-l attr1 f-yahei s-14 fw">${obj.house_size_out}</a>
								<a class="c-fix f-l attr2 f-yahei s-12 fw">室外面积</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="f-l p_struct_attr">
								<a class="c-fix f-l attr1 f-yahei s-14 fw">>${obj.tudi_area}</a>
								<a class="c-fix f-l attr2 f-yahei s-12 fw">土地面积</a>
							</div>
							<div class="f-l p_struct_attr">
								<a class="c-fix f-l attr1 f-yahei s-14 fw">${obj.jianzhu_area}</a>
								<a class="c-fix f-l attr2 f-yahei s-12 fw">建筑面积</a>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="f-l p_struct_attr2">
						<a class="c-fix f-l attr3 f-yahei s-14 fw">$${obj.house_price}</a>
						<a class="c-fix f-l attr4 f-yahei s-12 fw">房价</a>
					</div>
					<img src="images/btn_get_struct.jpg" class="f-l btn_get_struct cp" onclick="pop6('${obj.house_type}','<%=application.getInitParameter("imagedir")%>/${obj.house_img}')"></img>
				</div>
				</c:if>
				</c:forEach>
				<div class="c-fix f-r btn_full cp" onclick="pop2()"></div>
				<div class="f-r btn_price cp" onclick="pop1()"></div>
				<a class="c-fix f-r p_update f-yahei">最近更新时间:${fn:substring(timeResule,0,10)}</a>
			</div>
		</div>
		</c:if>
		
		
<!-- 				 <div class="succesny">
            <div class="control">
                <ul class="change">
                </ul>
            </div>
            <div class="thumbWrap">
                <div class="thumbCont">
                    <ul>
                        img属性, url=url, text=描述, bigimg=大图, alt=标题 
                       <li>
                            <div><img src="images/s1.jpg" url="url" bigImg="images/1.jpg" alt="标题1"></div>
                        </li>
                        <li>
                            <div><img src="images/s2.jpg" url="url"  bigImg="images/2.jpg" alt="标题2"></div>
                        </li>
                        <li>
                            <div><img src="images/s3.jpg" url="url"  bigImg="images/3.jpg" alt="标题3"></div>
                        </li>
                        <li>
                            <div><img src="images/s4.jpg" url="url"  bigImg="images/4.jpg" alt="标题4"></div>
                        </li>

                    </ul>
                </div>
            </div>
        </div> -->
        
        <c:if test="${!empty ProjectPeitaoImage }">
		 <div class="c-fix  bkg3"  name="loc_pt" id="loc_pt" style="margin:0 auto;height:560px;width:990px">
			<div class="c-fix p_intro" style="margin-top:-20px">
			
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw">项目配套</a>
				
	<div style="margin-top:16px;background-color:white;">
<div class="panel panel-default">

    <div class="ad_position_p" style="height:487px;/* background-color:white; */">
        <div class="limit_p" style="height:487px;width:1100px;margin-top: -22px;">
        
            <div style="float:left;width:720px;display:inline;">
                <table class="ad_left_big_p" width="720" border="0" cellpadding="0" cellspacing="0" style="margin-top: 0px;">
                    <c:forEach items="${ProjectPeitaoImage}" var="item" varStatus="status">
                   <%--  <c:if test="${status.index<3 }"> --%>
                    	<tr><td><img src="<%=application.getInitParameter("imagedir")%>/${item.image_name}" width="720" height="487" /></a></td></tr>
                  <%--  </c:if> --%>
                    </c:forEach>
                    
                </table>
            </div>
            <div class="ad_small_box_p" style="width:224px;height:487px;margin-left:20px;">
                <div class="top_button off"></div>
                <div class="small_right_limit_p" style="padding:0px;">
                    <ul>
                    	<c:forEach items="${ProjectPeitaoImage}" var="item" varStatus="status">
                    	<%-- <c:if test="${status.index<3 }"> --%>
                    		<li style="margin-top:10px;"><img src="<%=application.getInitParameter("imagedir")%>/${item.image_name}" width="210" height="140"/></li>
                    	<%-- </c:if> --%>
                    </c:forEach>
                    	
                    </ul>
                    <div class="this_ad_p" style="top:0px;"><img style="border:blue 2px solid;width:210px;height:140px;margin-left:10px;margin-top:10px;"/></div>
                </div>
                <div class="bottom_button off"></div>
            </div>
        </div>

</div>


    </div>
</div> 

			</div>
		</div> 
		</c:if> 
		<div class="c-fix  bkg3"  name="loc_wz" id="loc_wz" style="margin:0 auto;height:474px;width:990px">
			<div class="c-fix p_panel_4">
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:930px;">项目位置</a>
				
				<div  class="c-fix f-l p_map">
					<div id="indexMap" style="position:relative; width:490px; height:490px;"></div>
				</div>
				<div class="f-r p_real_time">
					<div id="eyeMap" style="position:relative; width:490px; height:490px;"></div>
				</div>
			</div>
		</div>
		<div class="c-fix  bkg3"  style="margin:0 auto;height:520px;width:990px">
			<div class="c-fix p_panel_4">
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:930px;">学校和周边</a>
				<div class="c-fix f-l p_left">
					<img src="images/walk_score.jpg" class="c-fix f-l icon_walk"></img>
					<a class="c-fix f-l walk_lab f-yahei s-14" style="margin-top:20px;">步行指数：${HouseProject.walk_num }</a>
					<a class="c-fix f-l walk_lab f-arial s-14">Walk Score</a>
					<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:445px;margin-left:0px;">附近学校</a>
					<c:forEach items="${nearSchoolList}" var="item" begin="0" end="2" step="1" varStatus="var">
					<div class="c-fix f-l p_school_node">
						<div class="c-fix f-l p_school_inner">
							<a class="c-fix f-l p_school_lab f-yahei s-14">${item.school_type}</a>	
							<a class="f-r p_school_lab f-yahei s-14" style="margin-right:20px;">${item.school_name}</a>	
						</div>
						<a class="c-fix f-r p_school_distance f-yahei s-14" style="margin-right:20px;">${item.school_distance}m</a>	
					</div>
					</c:forEach>
					
				</div>
				<div class="f-l p_right" style="margin-left:35px">
					<img class="c-fix f-l score_board" src="images/score_board.jpg"></img>
				</div>
				<a class="f-l f-yahei s-14 p_panel_title4 fw" style="width:455px;margin-left:60px;margin-top:-8px;">附近配套</a>
				<div class="f-l p_right_bottom" style="margin-left:35px;">
				<c:forEach items="${nearSchoolFacility}" var="item" begin="0" end="2" step="1" varStatus="var">
					<div class="c-fix f-l p_school_node">
						<div class="c-fix f-l p_school_inner">
							<a class="c-fix f-l p_school_lab f-yahei s-14">${item.market_type}</a>	
							<a class="f-r p_school_lab f-yahei s-14" style="margin-right:20px;">${item.market_name}</a>	
						</div>
						<a class="c-fix f-r p_school_distance f-yahei s-14" style="margin-right:20px;">${item.market_distance}m</a>	
					</div>
				</c:forEach>
					
				</div>
			</div>
		</div>
	
		<c:if test="${!empty houseTaxStr && !empty housetaxdata && !empty holdingTaxStr && !empty holdingdata}">
		<div class="c-fix bkg3"  name="loc_fy" id="loc_fy"  style="margin:0 auto;height:346px;width:990px">
			<div class="c-fix p_panel_4">
			
			
				<ul class="nav nav-tabs" id="costTabs">
      <li class="active"><a href="#home" data-toggle="tab" style="font-weight:bold;">购房税费</a></li>
      <li><a href="#profile" data-toggle="tab" style="font-weight:bold;">持有成本</a></li>
      <li class="navbar-text navbar-right">&nbsp;&nbsp;&nbsp;&nbsp;</li>
      <p class="navbar-text navbar-right"><b>以总价50万澳币估算</b></p>
      
    </ul>
    
    <div class="tab-content">
      <div class="tab-pane active" id="home">
      	<div style="padding-top:10px;padding-bottom:10px;">
      		<div style="float:left;margin-right:20px;margin-left:20px;">
      			<p>估计总购房税费</p>
      		</div>
      		<div>
      			<b>约${houseTaxSum}澳元</b>
      		</div>
      	</div>
      	<div>
      		<div id="GouFang_pie" style="height:200px"></div>
      	</div>
      </div> 
      <div class="tab-pane" id="profile">
      	<div style="padding-top:10px;padding-bottom:10px;">
      		<div style="float:left;margin-right:20px;margin-left:20px;">
      			<p>预估每年持有成本</p>
      		</div>
      		<div style="float:left;">
      			<b>约${holdingTaxSunm}澳元</b>
      			
      		</div>
      		
      	</div>
      	<div>
      		<div id="ChengBen_pie" style="height:200px">
      			</div>
      	</div>
      </div> 
      
  	</div>
  	
			</div>
			</div>
		</c:if>
		<div class="c-fix  bkg4" id="loc_tz"  style="margin:0 auto;height:317px;width:990px">
			<div class="c-fix p_panel_4">
				<a class="c-fix f-l fw que_title f-yahei">贷款每月</a>
				<a class="c-fix f-l fw que_title2 f-yahei">还款是多少</a>
				<a class="c-fix f-l fw que_icon f-arial">?</a>
				<div class="f-r que_div">
					<a class="c-fix f-l s-14 que_lab f-yahei fw" id="input1">房款总额</a>	
					<a class="f-l s-14 que_lab f-yahei fw" id="input2">税率</a>	
					<a class="f-l s-14 que_lab f-yahei fw">贷款方式</a>	
					<input type="text" class="c-fix f-l que_inp" placeholder="$400,000"></input>
					<input type="text" class="f-l que_inp" placeholder="2.48%"></input>
					<select class="f-l que_inp" id="select1">
						<option>只还利息</option>
					    <option>无息贷款</option>
					    <option>连本带利</option>
					
					
					</select>
					<a class="c-fix f-l s-14 que_lab f-yahei fw">首付比例</a>	
					<a class="f-l s-14 que_lab f-yahei fw">贷款年限</a>	
					<select class="c-fix f-l que_inp" id="select2">
						<option>20%</option>
					    <option>25%</option>
					    <option>30%</option>
					</select>
					<select class="f-l que_inp" id="select3">
						<option>25年</option>
					    <option>30年</option>
					    <option>35年</option>
					
					</select>
					<div class="col-md-3 col-lg-3">
<button type="button" onclick="compute()" class="btn btn-default" style="margin-left:-20px;width:180px;font-size:15px;">计算</button>
</div>
					<div class="c-fix f-l que_inner">
						<a class="c-fix f-l que_inner_lab f-yahei s-14">首付金额</a>
						<input type="text" class="f-l que_inner_inp"></input>
					</div>
					<div class="f-l que_inner2">
						<a class="c-fix f-l que_inner_lab f-yahei s-14">首付金额</a>
						<input type="text" class="f-l que_inner_inp"></input>
						<a class="f-l que_inner_lab f-yahei s-14">/月</a>
					</div>
				</div>
			</div>
		</div>
		<div class="c-fix  bkg3"  style="margin:0 auto;height:280px;width:990px">
			<div class="c-fix p_panel_4">
				<%-- <a class="c-fix f-l p_inves_name f-yahei s-18 fw">${HouseProject.project_area}${HouseProject.project_type}投资数据</a> --%>
				<a class="c-fix f-l p_inves_name f-yahei s-18 fw">${area_name}${HouseProject.project_type}投资数据</a>
				<a class="c-fix f-l p_inves_name f-yahei s-14" style="border-bottom:1px solid #999;padding-bottom:20px;">投资数据参考 公寓房产</a>
				<div class="c-fix f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">年增长率</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.year_increment_rate}</a>
				</div>
				<div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">中位数价格</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.middle_price}</a>
				</div>
				<div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">中位数租金</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.middle_zu_price}</a>
				</div>
				 <div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">租金回报率</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.zu_house_rate}</a>
				</div>
				<div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">租赁需求</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.zu_xuqiu_1}</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-12 fw" style="margin-top:10px;">${data.zu_xuqiu_2}</a>
				</div>
				<div class="f-l p_inves_div">
					<a class="c-fix f-l p_inves_lab f-yahei s-14 fw">现金回报</a>
					<a class="c-fix f-l p_inves_lab f-yahei s-18" style="color:rgb(21,63,101);margin-top:10px;">${data.price_review}</a>
				</div>
				<a class="c-fix f-r p_inves_source f-yahei s-12">数据来源：${data.touzi_datasource }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;更新日期：${fn:substring(data.touzi_date, 0, 10)}</a>
			</div>
		</div>
 		<div class="c-fix  bkg3"  style="margin:0 auto;height:426px;width:990px">
			<div class="c-fix p_panel_4">
				<%-- <a class="c-fix f-l p_inves_name f-yahei s-18 fw">${HouseProject.project_area} ${HouseProject.project_type}中位数房价</a> --%>
				<a class="c-fix f-l p_inves_name f-yahei s-18 fw">${area_name} ${HouseProject.project_type}中位数房价</a>
				<div class="c-fix f-l middle_bkg">
					<a class="c-fix f-l f-yahei fw middle_lab1">$${buy_price}</a>
					<a class="f-l f-yahei fw middle_lab2">$${zu_price}/周</a>
				</div>
				<div class="c-fix f-l middle_inner" style="margin-left:80px;">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw">${middlePrice.buy_one_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${buy_one_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:25px">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw">${middlePrice.buy_two_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${buy_two_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:20px;">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw">${middlePrice.buy_three_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${buy_three_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:27px;">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:rgb(21,63,101)">${middlePrice.zu_one_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${zu_one_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:25px">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:rgb(21,63,101)">${middlePrice.zu_two_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${zu_two_price}</a>
				</div>
				<div class="f-l middle_inner" style="margin-left:20px;">
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:rgb(21,63,101)">${middlePrice.zu_three_name}</a>
					<a class="c-fix f-l f-yahei s-14 middle_lab3 fw" style="color:#333;margin-top:5px;">$${zu_three_price}</a>
				</div>
				<a class="c-fix f-r p_inves_source f-yahei s-12">数据来源：${middlePrice.middle_datasource }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;更新日期${fn:substring(middlePrice.middle_date,0,10) }</a>
			</div>
		</div>
		
		<c:if test="${fn:length(areaMiddleList) > 0 && fn:length(areaZujinList) > 0 && fn:length(areaZhikongList) > 0}">
		<div class="c-fix  bkg3"  style="margin:0 auto;height:450px;width:990px">
			<div class="c-fix p_panel_4">
			
<ul class="nav nav-tabs nav-justified" id="trendTabs">
      <li class="active"><a href="#price" data-toggle="tab"><b>${area_name}区域中位数房价走势</b></a></li>
      <li><a href="#rent" data-toggle="tab"><b>${area_name}区域租金走势</b></a></li>
      <li><a href="#emptypercent" data-toggle="tab"><b>${area_name}区域租金回报率走势</b></a></li>
     <!-- <p class="navbar-text navbar-right">Signed in as Mark Otto</p>-->
    </ul>
    
    
    <div class="tab-content">
      <div class="tab-pane active" id="price">
      	<div>
      		<div id="price_line" style="height:350px"></div>
      		<div style="width:100%;padding-left:30px;padding-right:30px;"><font size="1">投资数据参考：2卧室房产</font><span style="float:right;"><font size="1">数据来源：${middle_zoushi_datasource } 更新日期：${fn:substring(middle_zoushi_date,0,10)} </font></span></div>
      	</div>
      </div> 
      <div class="tab-pane" id="rent">
      	<div>
      		<div id="rent_line" style="height:350px">
      			</div>
      		<div style="width:100%;padding-left:30px;padding-right:30px;"><font size="1">投资数据参考：2卧室房产</font><span style="float:right;"><font size="1">数据来源：${zujin_datasource }  更新日期：${fn:substring(zujin_date,0,10)} </font></span></div>
      	</div>
      </div> 
      <div class="tab-pane" id="emptypercent">
      	<div>
      		<div id="emptypercent_line" style="height:350px">
      			</div>
      		<div style="width:100%;padding-left:30px;padding-right:30px;"><font size="1">投资数据参考：2卧室房产</font><span style="float:right;"><font size="1">数据来源：${zujin_huibao_datasource } 更新日期：${fn:substring(zujin_huibao_date,0,10)}</font></span></div>
      	</div>
      </div> 
  	</div>
</div>
			</div>
	</c:if>
	<c:if test="${fn:length(featureList) > 0}">
		<div class="c-fix  bkg3"  style="margin:0 auto;height:188px;width:990px">
			<div class="c-fix p_panel_4" style="padding-top:0px;">
				

				
					<div class="c-fix f-l p_left2">
						<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:690px;margin-bottom:10px;">${area_name} 地区特点</a>
						<c:forEach items="${featureList}" var="item" varStatus="var" begin="0" end="9" step="5">
						<a class="f-l f-yahei s-14 p_spec">${item}</a>
						
						</c:forEach>
						<c:forEach items="${featureList}" var="item" varStatus="var" begin="1" end="9" step="5">
						<a class="f-l f-yahei s-14 p_spec">${item}</a>
						
						</c:forEach>
						<c:forEach items="${featureList}" var="item" varStatus="var" begin="2" end="9" step="5">
						<a class="f-l f-yahei s-14 p_spec">${item}</a>
						
						</c:forEach>
						<c:forEach items="${featureList}" var="item" varStatus="var" begin="3" end="9" step="5">
						<a class="f-l f-yahei s-14 p_spec">${item}</a>
						
						</c:forEach>
						<c:forEach items="${featureList}" var="item" varStatus="var" begin="4" end="9" step="5">
						<a class="f-l f-yahei s-14 p_spec">${item}</a>
						
						</c:forEach>
						
						<a class="c-fix f-l p_header3 f-yahei s-14 fw" style="width:721px;margin-top: 97px;">${area_name} 区域人口分布<span style="float:right;padding-right:20px;" class="s-12">数据来源：${people_datasource } 更新日期：${fn:substring(people_date,0,10)}</span></a>
						<div class="c-fix f-l p_tab2" style="width:721px;">
						<table class="table table-striped">
						 <tbody style="font-size:12px;">
			    		<c:forEach items="${list}" var="item" varStatus="var" begin="0" end="0">
				    		<tr class="row">
				    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1 }</td>
				    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2 }</td>
				    		<td class="col-md-4" style="background:rgb(224,238,218)">${item.column3 }</td>
				    		</tr>
			    		</c:forEach>
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="1" end="1">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td>${item.column2}</td>
			    			<td>${item.column3}</td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
			  	 <table class="table table-striped">
				  	
			    	<tbody style="font-size:12px;">
			    		<c:forEach items="${list}" var="item" varStatus="var" begin="2" end="2">
			    		<tr class="row">
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column3}</td>
			    		</tr>
			    		</c:forEach> 
			    	
			    	
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="3" end="3">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td>${item.column2}<span></span></td>
			    			<td>${item.column3}<span></span></td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
			  	  <table class="table table-striped">
				  	
			    	<tbody style="font-size:12px;">
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="4" end="4">
			    		<tr class="row">
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2}</td>
			    		<td class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column3}</td>
			    		</tr>
			    		</c:forEach>
			    	
			    	
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="5" end="9">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td>${item.column2}<span></span></td>
			    			<td>${item.column3}<span></span></td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
			  	  <table class="table table-striped">
				  	
			    	<tbody style="font-size:12px;">
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="10" end="10">
			    		<tr class="row">
			    		<td  class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column1}</td>
			    		<td  class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column2}</td>
			    		<td  class="col-md-4" style="background:rgb(224,238,218);margin-right:5px;">${item.column3}</td>
			    		</tr>
			    		</c:forEach>
			    	
			    	
			    	
			    	<c:forEach items="${list}" var="item" varStatus="var" begin="11" end="11">
						<tr class="row">
			    			<td>${item.column1}</td>
			    			<td><span>$</span>${item.column2}</td>
			    			<td><span>$</span>${item.column3}</td>
			    		</tr>
					</c:forEach> 
			    	</tbody>
			  	  </table>
						</div>
					</div>
					<img class="f-r p_adv" src="images/ad1.png"></img>
				<img class="f-r p_adv2" src="images/adv.jpg"></img>
				</c:if>
				</div>
						</div>
				<c:if test="${!empty dulirateVo && !empty youngfamilyVo && !empty oldfamilyVo}">
				<div class="c-fix bkg3" style="margin:0 auto;height:265px;width:990px;position:relative;">
				<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:950px;margin-bottom:10px;">${area_name} 区域家庭情况构成</a>
				<div class="c-fix f-l p_family" style="margin-left:72px;-margin-top:20px;height:184px">
					<a class="c-fix f-l family_lab f-yahei s-14 fw">${dulirateVo}</a>
				</div>
				<div class=" f-l p_family2" style="margin-left:144px;-margin-top:20px;height:184px">
					<a class="c-fix f-l family_lab f-yahei s-14 fw">${youngfamilyVo}</a>
				</div>
				<div class="f-l  p_family3" style="margin-left:144px;-margin-top:20px;height:184px">
					<a class="c-fix f-l family_lab f-yahei s-14 fw">${oldfamilyVo}</a>
				</div>
				<div class="c-" style="margin-right:20px;float:rgiht;height:20px">
					<span class="c-fix f-yahei s-12 fw f-r">数据来源：${family_datasource }&nbsp;&nbsp; 更新日期：${fn:substring(family_date,0,10)}</span>
				</div>
				<div style="position:absolute; width:100%;height:233px" id="zonefamily_pie">
				</div>
				</div> 
				</c:if>
			<!-- </div>
		</div> -->
		
		<c:if test="${not empty newsList}">
		<div class="c-fix bkg3" style="margin:0 auto;height:350px;width:990px">
			<div class="c-fix f-l p_panel_5">
			
				<div class="c-fix p_inner bgc" style="padding-bottom:30px;">
					<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:950px;margin-bottom:10px;">新闻报道</a>
					<div class="c-fix f-l p_news_node" style="margin-left:15px;">
					    <a href="/Detail?id=${item.id}&type=1">
						<img src="<%=application.getInitParameter("imagedir")%>/${newsInfo_one.news_image}" class="c-fix f-l news_img" style="width:315px;height:200px"></img>
						</a>
						<a href="/Detail?id=${item.id}&type=1" class="c-fix f-l f-yahei s-16 fw news_title">新闻标题：${newsInfo_one.news_title}</a>
						<div class="p_foot">
						<a class="c-fix f-l f-yahei s-14 news_type">分类：${newsInfo_one.news_fenlei}</a>
						<a class="f-l f-yahei s-14 news_time">时间：${timeResuleOne}</a>
						</div>
					</div>
			
					 <div class="f-l p_news_node" style="margin-left:5px;">
						<img src="<%=application.getInitParameter("imagedir")%>/${newsInfo_two.news_image}" class="c-fix f-l news_img" style="width:315px;height:200px"></img>
						<a class="c-fix f-l f-yahei s-16 fw news_title">新闻标题：${newsInfo_two.news_title}</a>
						<a class="c-fix f-l f-yahei s-14 news_type">分类：${newsInfo_two.news_fenlei}</a>
						<a class="f-l f-yahei s-14 news_time">时间：${timeResuleTwo}</a>
					</div>
					<div class="f-l p_news_node" style="margin-left:5px;">
						<img src="<%=application.getInitParameter("imagedir")%>/${newsInfo_three.news_image}" class="c-fix f-l news_img" style="width:315px;height:200px"></img>
						<a class="c-fix f-l f-yahei s-16 fw news_title">新闻标题：${newsInfo_three.news_title}</a>
						<a class="c-fix f-l f-yahei s-14 news_type">分类：${newsInfo_three.news_fenlei}</a>
						<a class="f-l f-yahei s-14 news_time">时间：${timeResuleThree}</a>
					</div>
				</div>
			</div>
		</div>
		</c:if>
		<!-- 通过项目推荐经纪人 -->
		<c:if test="${!empty recommendBroker}">
		
		<div class="c-fix bkg3" style="margin:0 auto;height:222px;width:990px">
			<div class="c-fix f-l p_panel_5" style="padding-bottom:0px">
				<c:choose>
					<c:when test="${fn:length(recommendBroker)==1}">
						<div class="c-fix p_inner" style="height:191px;">
					</c:when>
					<c:when test="${fn:length(recommendBroker)==2}">
						<div class="c-fix p_inner" style="height:350px;">
					</c:when>
					<c:otherwise>
						<div class="c-fix p_inner" style="height:530px;">
					</c:otherwise>
					
				</c:choose>
				
				
					<div class="c-fix f-l p_left3">
						<a class="c-fix f-l p_ask f-yahei fw">你是否需要房产经纪人</a>
						<a class="f-l p_ask fw f-yahei" style="font-size:65px;height:70px;line-height:70px;">?</a>
					</div>
					<div class="f-r p_right2">
					<c:forEach var="item" items="${recommendBroker}" varStatus="stat">
						<c:if test="${stat.index<3}">
							<div class="c-fix f-l agent_node" <c:if test="${stat.index!=0 }">style="margin-top:10px;"</c:if>>
								<%-- <img src="<%=application.getInitParameter("imagedir")%>/${item.broker_img}" height="143" class="c-fix f-l agent_avatar"></img> --%>
								<a href="Service?brokerId=${item.id}"><img src="<%=application.getInitParameter("imagedir")%>/${item.broker_img}" height="143" class="c-fix f-l agent_avatar"></img></a>
								<a class="f-l agent_name f-yahei s-16 fw">${item.broker_name }</a>
								<a class="f-l agent_lab f-yahei s-14" style="margin-top:15px;">从业经验：${item.broker_experience }年</a>
								<a class="f-l agent_lab f-yahei s-14">语言：${item.broker_language }</a>
								<a class="f-l agent_lab f-yahei s-14">区域：${item.broker_region }</a>
								<div class="f-l icon1 cp"></div>
								<div class="f-l icon2 cp"></div>
								<div class="f-l icon3 cp"></div>
							</div>
						</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		</c:if>
		<c:if test="${!empty recommentList }">
		
		<div class="c-fix  bkg3" style="margin:0 auto;height:284px;width:990px">
			<div class="c-fix f-l p_panel_5" style="background-color:#fff;">
				<div class="c-fix p_inner bgc" style="padding-bottom:30px;">
					<a class="c-fix f-l f-yahei s-14 p_panel_title4 fw" style="width:950px;margin-bottom:10px;">推荐项目</a>
					<div class="c-fix f-l p_project_node">
						<a href="Index?proNum=${RecommendProject1.project_num}"><img src="<%=application.getInitParameter("imagedir")%>/${RecommendProject1.project_img}" class="c-fix f-l project_img" width="300px" height="187px"></img></a>
						<a href="Index?proNum=${RecommendProject1.project_num}" class="c-fix f-l f-yahei s-14 project_desc fw">${RecommendProject1.project_name}<br/><div style="height:40px;font-size:13px;overflow: hidden;text-overflow: ellipsis;">${RecommendProject1.project_desc}</div></a>
					</div>
					<div class="f-l p_project_node" style="margin-left:25px;">
						<a href="Index?proNum=${RecommendProject2.project_num}"><img src="<%=application.getInitParameter("imagedir")%>/${RecommendProject2.project_img}" class="c-fix f-l project_img" width="300px" height="187px"></img></a>
						<a href="Index?proNum=${RecommendProject2.project_num}" class="c-fix f-l f-yahei s-14 project_desc fw">${RecommendProject2.project_name}<br/><div style="height:40px;font-size:13px;overflow: hidden;text-overflow: ellipsis;">${RecommendProject2.project_desc}</div></a>
					</div>
					<div class="f-l p_project_node" style="margin-left:25px;">
						<a href="Index?proNum=${RecommendProject3.project_num}"><img src="<%=application.getInitParameter("imagedir")%>/${RecommendProject3.project_img}" class="c-fix f-l project_img" width="300px" height="187px"></img></a>
						<a href="Index?proNum=${RecommendProject3.project_num}" class="c-fix f-l f-yahei s-14 project_desc fw">${RecommendProject3.project_name}<br/><div style="height:40px;font-size:13px;overflow: hidden;text-overflow: ellipsis;">${RecommendProject3.project_desc}</div></a>
					</div>
				</div>
			</div>
		</div>
		</c:if>
		<div class="c-fix f-l bottom_bkg">
			<div class="c-fix f-l triangle"></div>
			<a class="c-fix f-l bottom_lab f-yahei fw">为您提供最好的海外购房服务</a>
			<a id="xiangmuZhuce" class="c-fix f-l bottom_reg f-yahei cp">注册</a>
		</div>
		<jsp:include page="foot4index.jsp" />
		<!-- <div style="display:block;width:100%;min-height:40px;background-color:rgb(228,229,231);float:left;clear:both">
			<div class="row" style="background-color:rgb(228,229,231);min-height:20px;width:1000px;position:relative;left:50%;margin-left:-455px;">
				<div style="display:block;width:810px;float:left;min-height:40px;margin-top:30px;">
					<img src="images/footer_icon.png" style="display:block;width:200px;float:left"></img>
					<div style="display:block;height:50px;float:left">
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">关于我们</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">商务合作</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">服务协议</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">隐私条款&隐私政策</a>
						<a style="display:block;width:110px;height:50px;line-height:50px;text-align:center;color:#666;font-size:12px;cursor:pointer;float:left">加入我们</a>
					</div>
					<div style="display:block;width:98%;height:1px;background-color:#333;clear:both"></div>
					<div style="display:block;width:660px;min-height:20px;float:left;clear:both">
						<a style="display:block;width:100%;text-align:center;line-height:40px;color:#666;">热线：400-810-9685&nbsp;&nbsp;邮箱：Business@5zfang.com</a>
						<a style="display:block;width:100%;text-align:center;line-height:40px;color:#666;">c2014-2015北京胜义行有限公司 . All rights reserved. 京ICP备1234567</a>
					</div>
					<div style="display:block;width:150px;float:right;min-height:30px;position:relative;left:-80px;"> 
						<div style="display:block;width:20px;height:26px;background-image:url(images/footer_mini.png);float:left;margin-top:10px;cursor:pointer;"></div>
						<div style="display:block;width:33px;height:26px;background-image:url(images/footer_mini.png);background-position:-20px 0px;float:left;margin-top:10px;margin-left:10px;cursor:pointer"></div>
						<div style="display:block;width:26px;height:26px;background-image:url(images/footer_mini.png);background-position:-53px 0px;float:left;margin-top:10px;margin-left:10px;cursor:pointer"></div>
					</div>
				</div>
				<div style="display:block;width:90px;float:left;margin-top:30px;">
					<img src="images/footer_qr.png" style="display:block;width:90px;"></img>
				</div>
			</div>
		</div> -->
		
<!-- 索取完整价格单模态框start-->
<div class="modal fade" id="demandprice" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               索取完整价格单
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
       <%--      <form class="form-horizontal" role="form" action="/indexSuoJia/MessageSubmit" method="post">  --%>
            <c:forEach items="${userList}"  var="item">
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
		<input type="text" class="form-control" name="name1"  id="name1" value=${item.nick_name}>
		<input type="hidden" class="form-control" name="userid" placeholder=${item.id}>
	  </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" >
      <div class="col-sm-10 col-sm-offset-1">

         <input type="text" class="form-control" name="email1"  id="email1"
            value=${item.email}>



      </div>
      <div class="col-sm-1"></div>
      
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
       <input type="text" class="form-control" name="allprice" 
            placeholder="索取完整价格单"/>      
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" >
      <div class="col-sm-10 col-sm-offset-1">

         <input type="text" class="form-control" name="tel1" id="tel1" value=${item.tel}>


      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" >
      <div class="col-sm-10 col-sm-offset-1">

         <textarea type="text" rows="5" cols="20" class="form-control" name="message_content1"  id="message_content1" placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="padding-bottom:40px;">
   	   <div class="col-sm-7"></div>
      <div class="col-sm-5">
       <!--   <button type="submit" class="btn btn-default" style="width:105px;background-color:red;color:white;" type="submit" id="submit">提交</button> -->
        <button type="button" class="btn btn-default" style="width:105px;background-color:red;color:white;"  onclick="submitMessageForPrice()">提交</button>

      </div>
     
   </div>
 </c:forEach>
 
<%-- </form> --%>

         </div>
   
      </div>
</div>
</div>
<!-- 索取完整价格单模态框end -->

<!-- house style1模态框start-->
<div class="modal fade" id="housestyle" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:-230px;height:700px;width:1030px;">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <div class="modal-title" id="title">
               
            </div>
         </div>
         <div class="modal-body">
            <img src="" width="1000" height="600" id="image"/>
         </div>
   
      </div>
</div>
</div>
<!-- house style模态框end -->

<!-- 最新价格模态框start-->
<div class="modal fade" id="recentquotation" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" >
               最新价格
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
         <%--    <form class="form-horizontal" role="form" action="/UserInfo/AddNewestPrice" method="post"> --%>
   <c:forEach items="${userList}"  var="item">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="nick_name4"  id="nick_name4"
            value=${item.nick_name}>
      </div>
      <div class="col-sm-1"></div>
   </div>
  <!--  <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="pwd" 
            placeholder=${item.pwd}>
      </div>
      <div class="col-sm-1"></div>
   </div> -->
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="tel4"  id="tel4"
            value=${item.tel}>
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="email4" id="email4"
            value=${item.email}>
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
        <input type="text" class="form-control" name="newestprice" 
            placeholder="最新价格"/>     
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" name="msg4"  id="msg4"
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default" onclick="submitForLatestPrice()">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
   </c:forEach>
<%-- </form> --%>

         </div>
   
      </div>
</div>
</div>
<!-- 最新价格模态框end -->


<!-- 完整户型模态框start-->
<div class="modal fade" id="completehouse" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               完整户型
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
           <%--  <form class="form-horizontal" role="form" action="/UserInfo/AddHouseType" method="post"> --%>
    <c:forEach items="${userList}"  var="item">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="nick_name5" id="nick_name5" 
            value=${item.nick_name}>
      </div>
      <div class="col-sm-1"></div>
   </div>
  <!--  <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="pwd" 
            placeholder=${item.pwd}>
      </div>
      <div class="col-sm-1"></div>
   </div> -->
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="tel5" id="tel5"  
            value=${item.tel}>
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="email5" id="email5"
            value5=${item.email}>
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
       <input type="text" class="form-control" name="housetype"
            placeholder="完整户型">      
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" name="msg5"  id="msg5"
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="button" class="btn btn-default" onclick="submitForHuxing()">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
   </c:forEach>
<%-- </form> --%>

         </div>
   
      </div>
</div>
</div>
<!-- 完整户型模态框end -->
<!-- <!-- 详情咨询模态框start-->
<div class="modal fade" id="projectInfo" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:495px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title" id="myModalLabel">
              	   详情咨询
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
           <%--  <form class="form-horizontal" role="form" action="/UserInfo/AddAsk" method="post"> --%>
            <c:forEach items="${userList}"  var="item">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="nick_name3"  id="nick_name3"
            value=${item.nick_name}>
      </div>
      <div class="col-sm-1"></div>
   </div>
   <!-- <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="pwd" 
            value=${item.pwd}>
      </div>
      <div class="col-sm-1"></div>
   </div> -->
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="tel3" id="tel3" 
            value=${item.tel}>
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="email3"  id="email3"
            value=${item.email}>
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
        <input type="text" class="form-control" name="ask" 
            placeholder="项目咨询" disabled="disabled">     
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" name="msg3"  id="msg3"
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="button" class="btn btn-default"  onclick="submitForInfo()">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
   </c:forEach>
<%-- </form> --%>

         </div>
   
      </div>
</div>
</div>
<!--详情咨询模态框end  -->
 <!-- 项目位置模态框start-->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:-300px;height:600px;width:1210px;">
         <div class="modal-header">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
               Bing Maps
            </h4>
         </div>
         <div class="modal-body">
            <div id='popMap' style="position:relative; width:1170px; height:500px;"></div>
         </div>
   
      </div>
</div>
</div>
<!-- 项目位置模态框end -->

<!-- register start -->
<div class="modal fade" id="registernewPro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:270px;width:355px;">
         <div class="modal-header" style="background-color:rgb(55,52,67);padding:0px 10px;height:10px;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true" style="font-size:18px;color:white;">
                  &times;
            </button>
         </div>
         <div class="modal-body">
  <div style="text-align:center;margin-top:5px;"><div style="font-size:20px;font-weight:bold;">用户注册</div>
  <form method="post" action="/Register" name="fm1">
  <div  style="padding-top:15px;">
         <input type="text"  id="telemailnew" name="telemailnew" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
   <input type="hidden" name="url" value="<%=request.getRequestURL() + "?" + request.getQueryString()%>">
   </div>
   <div>
         <input type="password" id="pwdnew" name="pwdnew" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
   </div>
   <div style="padding-top:15px;padding-left:26px;float:left;font-size:12px;">
   
   <img src="images/register.png" id="regnew" style="width:120px;height:30px;cursor:pointer;"><span style="padding-left:20px;"><a id="cancelnew" href="#">取消</a></span>
   </div>
</form>
<div style="float:left;margin-top:60px;margin-left:-165px;font-size:12px;"><span>已有账户？<a href="javascript:void(0);" id="login2RePro">登录</a></span></div>
<div style="float:left;margin-top:85px;margin-left:-165px;font-size:12px;font-weight:bold;"><span><input type="checkbox" checked="true">我已阅读并接受<a href="/ServiceProtocol.jsp" style="color:black;">《用户服务协议》</a></span></div>
</div>
   
      </div>
</div>
</div>
</div>
<!-- register end -->


<input type="hidden" id="Control" value='0'>
	</body>
	<script>
	
	 
	</script>
	
	<!--  <script type="text/javascript" src="http://player.youku.com/jsapi">
		flag=0;
		player = new YKU.Player('youkuplayer',{
			styleid: '0',
			client_id: '6e97509b4cd3378b',
			vid: 'XOTUxNDk2NDQ0',
			events:{
				onPlayerReady: function(document){
					alert(flag);
					alert("kaishi") ;
					alert("zhunbei");
                    alert(t+"aaaaaaaaaaaaaaaaaaaaaaaaaa");
					alert("kaishi") ;
					alert("zhunbei") },
			onPlayStart: function(){ alert("kaishi");alert("flag"+flag); },
			onPlayEnd: function(){ alert("jieshu") }
			}
			});
			function playVideo(){
			player.playVideo();
				alert("kaishi");
			}
			function pauseVideo(){
			player.pauseVideo();
				alert("zanting")
			}
	</script> -->
		<input type="hidden" id= "url" name="url" value="<%=request.getRequestURL() + "?" + request.getQueryString()%>">
</html>

<script type="text/javascript">
var url = window.location.href;
var resultUrl = url.substring(url.lastIndexOf('/'));

var kk = <%= Judge%>;
//alert(kk)

$(function() {
	$("#xiangmuZhuce").click(function(){
		$('#registernewPro').modal('show');
	})

	 $("#login2RePro").click(function(){
		   	$('#login').modal('show');
		   	$('#registernewPro').modal('hide');
  })   
})

function pop(type,img){
	
 if(kk==0){
	 $('#registernewPro').modal('show');
 }
 else{
	 $('#title').empty();	
	  $('#title').append("<h4>户型"+type+"</h4>");
	  $('#image').attr("src",img);
	  $('#housestyle').modal('show');
 }
  
   
}
function pop6(type,img){
	$('#title').empty();	
	  $('#title').append("<h4>户型"+type+"</h4>");
	  $('#image').attr("src",img);
	  $('#housestyle').modal('show');
}
function pop1(){
  $('#recentquotation').modal('show');
}
function pop2(){
  $('#completehouse').modal('show');
}
function pop3(){
  $('#demandprice').modal('show');
}

function popInfo(){
	//alert("fewfw")
 if(kk==0){
	 $('#registernewPro').modal('show');
 }
 else{
	 $('#projectInfo').modal('show');
 }
  
}


/*   var qimoney=$("#qimoney").val();
  var value=$.formatNumber(qimoney,{format:"#,###", locale:"cn"});
  $("#qimoney").val(value); */

  var houseTaxStr=${houseTaxStr};
  var housetaxdata=${housetaxdata};
  var holdingTaxStr=${holdingTaxStr};
  var holdingdata=${holdingdata};
 </script>
 <script  type="text/javascript">
  var family={num1:"${fn:replace(dulirateVo,'%','')}",num2:"${fn:replace(youngfamilyVo,'%','')}",num3:"${fn:replace(oldfamilyVo,'%','')}"};
  
  var trend_areamiddle_year="${areaMiddleYeatList}";
  var trend_areamiddle_rate="${areaMiddleRateList}";
  var areaZujinYeatList="${areaZujinYeatList}";
  var areaZujinRateList="${areaZujinRateList}";
  var areaZhikongYeatList="${areaZhikongYeatList}";
  var areaZhikongRateList="${areaZhikongRateList}";

  

 </script>
 <!-- <script src="/js/familyStatus.js" charset="GBK"></script> -->
 <c:if test="${fn:length(areaMiddleList) > 0 && fn:length(areaZujinList) > 0 && fn:length(areaZhikongList) > 0}">
 <script src="/js/trend.js" charset="utf-8"></script>
 </c:if>
 <script src="/js/cost.js" charset="utf-8"></script>
 <script src="/js/news.js"></script>
  <script src="/js/familyStatus.js"></script>
 <script type="text/javascript">
 	$(function () {
  		$('[data-toggle="popover"]').popover()
	});
	
 	
 	 $("#regnew").click(function() {
     	var user = $("#telemailnew").val();
     	var pass = $("#pwdnew").val();
     	var temp;
     	temp = judgeRe(user,pass);
     	//alert(temp)             	
     	 if(temp==true){	                	
             //document.fm1.submit();  //fm为form表单name
     		$.ajax({
    			type:'post',
    			url:'/Register2',
    			dateType:'json',
    			data:{"telemail":user,"pwd":pass},
    			success:function(data){
    				if(data.flag == -1){
    					alert("注册失败！");    
    					
    				}
    				else{
    					alert("注册成功！");
    					window.location.href = resultUrl;  					
    				}

    			},
    			error:function(){
      			}
    		});
     	}
     	else{               	
     		return false;
     	}  
     	
     });

     $("#cancelnew").click(function() {
       	$("#telemailnew").val("").focus();
       	$("#pwdnew").val("");
       }); 

     function judgeRe(username, password){
      	 var result = false;
      	 if(username==""){
      	 alert("请输入用户名");
      		 return false;
      	 }
      	 else if(username!=""&&password==""){
      	 alert("请输入密码");
      		 return false;
      	 }
      	else{
       		$.ajax({
       			type:'GET',
       			url:'/registerPanduan?username='+username+'&password='+password,
       			dataType:'json',
       			async: false, 
       			success:function(data){
       	  		  	if(data.user==0){
       				  alert("用户名已存在，请直接登录！");
       				}
       				
       				else if(data.user==-1){
       				   alert("请输入正确格式！");
       	  			}
       	  			else{
       					result=true;
       				}
       	  				
       			},
       			error:function(){
       			}
       		});
        
       	 }
       if(result == true){
      	 return true;
       }
     }

 	
 	
 </script>
  <script type="text/javascript">
  function submitMessageForPrice()
  {
	  var username=$("#name1").val();
	  var email1=$("#email1").val();
	  var tel=$("#tel1").val();
	  var message_content=$("#message_content1").val();
	  //alert(username);
	  //alert(message_content);
	  $.ajax({
 			type:'GET',
 			dataType:'json',
 			data:{"type":"1","username":username,"email":email1,"tel":tel,"message_content":message_content},
 			url:'/SubmitMessage',
 			async: false, 
 			success:function(data){
 	  		  	if(data.flag==1){
 				  alert("留言成功");
 				 $('#demandprice').modal('hide');
 				}
 	  			else{
 	  				alert("留言失败");
 	  			 $('#demandprice').modal('hide');
 				}
 	  				
 			},
 			error:function(){
 			}
 		});
	  
	  
  }
  
  function submitXuqiuMessage()
  {
	  var username=$("#name2").val();
	  var email1=$("#email2").val();
	  var tel=$("#tel2").val();
	  var message_content=$("#message_content2").val();
	 // alert(username);
	  //alert(message_content);
	  $.ajax({
 			type:'GET',
 			dataType:'json',
 			data:{"type":"2","username":username,"email":email1,"tel":tel,"message_content":message_content},
 			url:'/SubmitMessage',
 			async: false, 
 			success:function(data){
 	  		  	if(data.flag==1){
 				  alert("留言成功");
 				/*  $('#demandprice').modal('hide'); */
 				 $("#message_content2").val("");
 				}
 	  			else{
 	  				alert("留言失败");
 	  			/*  $('#demandprice').modal('hide'); */
 				}
 	  				
 			},
 			error:function(){
 			}
 		});
	  
	  
  }
  function submitForInfo()
  {
	  var username=$("#nick_name3").val();
	  var email1=$("#email3").val();
	  var tel=$("#tel3").val();
	  var message_content=$("#msg3").val();
	  //alert(username);
	  //alert(message_content);
	  $.ajax({
 			type:'GET',
 			dataType:'json',
 			data:{"type":"3","username":username,"email":email1,"tel":tel,"message_content":message_content},
 			url:'/SubmitMessage',
 			async: false, 
 			success:function(data){
 	  		  	if(data.flag==1){
 				  alert("留言成功");
 				 $('#projectInfo').modal('hide'); 
 				/*  $("#message_content2").val(""); */
 				}
 	  			else{
 	  				alert("留言失败");
 	  			/*  $('#demandprice').modal('hide'); */
 				}
 	  				
 			},
 			error:function(){
 			}
 		});
	  
	  
  }
 
  function submitForLatestPrice()
  {
	  var username=$("#nick_name4").val();
	  var email1=$("#email4").val();
	  var tel=$("#tel4").val();
	  var message_content=$("#msg4").val();
	  //alert(username);
	  //alert(message_content);
	  $.ajax({
 			type:'GET',
 			dataType:'json',
 			data:{"type":"4","username":username,"email":email1,"tel":tel,"message_content":message_content},
 			url:'/SubmitMessage',
 			async: false, 
 			success:function(data){
 	  		  	if(data.flag==1){
 				  alert("留言成功");
 				 $('#recentquotation').modal('hide'); 
 				/*  $("#message_content2").val(""); */
 				}
 	  			else{
 	  				alert("留言失败");
 	  			 $('#recentquotation').modal('hide'); 
 				}
 	  				
 			},
 			error:function(){
 			}
 		});
	  
	  
  }
  
  
  function submitForHuxing()
  {
	  var username=$("#nick_name5").val();
	  var email1=$("#email5").val();
	  var tel=$("#tel5").val();
	  var message_content=$("#msg5").val();
	  //alert(username);
	  //alert(message_content);
	  $.ajax({
 			type:'GET',
 			dataType:'json',
 			data:{"type":"5","username":username,"email":email1,"tel":tel,"message_content":message_content},
 			url:'/SubmitMessage',
 			async: false, 
 			success:function(data){
 	  		  	if(data.flag==1){
 				  alert("留言成功");
 				 $('#completehouse').modal('hide'); 
 				/*  $("#message_content2").val(""); */
 				}
 	  			else{
 	  				alert("留言失败");
 	  			 $('#completehouse').modal('hide'); 
 				}
 	  				
 			},
 			error:function(){
 			}
 		});
  }
 /*  //点击收藏
  function addcollect(){
	  var projectNum=$("#projectNum").val();
	   alert("点击收藏");
	  $.ajax({
			type: "POST",  
 			 dataType: "json",  
 			 url: '/AddCollect',      //提交到一般处理程序请求数据   
  		     data: { proNum :projectNum},           
  		     success: function(data) {
  		          if(data.user==0){
  			          $('#login').modal('show');
  		         }else if(data.flag==1){
  			         alert("收藏成功");
  			        
  			         //$("#star0").addClass("btn_star_sel");//白星变黄
  			         $("#shoucang").css("background-color","red");
  			         $("#shoucang").html("已收藏");
  			         window.location.reload();
  		         }
  		      }  //success
		  });//ajax
  }
  //取消收藏
  function delcollect(){
	  var projectNum=$("#projectNum").val();
	   alert("取消收藏");
	  $.ajax({
			type: "POST",  
 			 dataType: "json",  
 			 url: '/DelCollect',      //提交到一般处理程序请求数据   
  		     data: { proNum :projectNum},           
  		     success: function(data) {
  		          if(data.user==0){
  			          $('#login').modal('show');
  		         }else if(data.flag==1){
  			         alert("取消收藏成功");
  			         //$("#star0").addClass("btn_star_sel");//白星变黄
  			          $("#quxiaoshoucang").css("background-color","rgb(226,226,226)"); 
  			          $("#quxiaoshoucang").html("点击收藏");
  			        window.location.reload();
  		         }
  		      }  //success
		  });//ajax
  } */
  $(function () {
	  var isCollect=${isCollected};
	//  alert("isCollect "+isCollect);
	  if(isCollect=="1"){
		  $("#shoucang").css("background-color","red");
	      $("#shoucang").val("已收藏");
	  }else{
		  $("#shoucang").css("background-color","rgb(226,226,226)"); 
	      $("#shoucang").val("点击收藏");
	  }
	 // alert($("#shoucang").val())
	  $("#shoucang").on('click',function(event){
		  var projectNum=$("#projectNum").val();
		 // alert(isCollect);
		/*   if(isCollect=="0"){//0表示要进行收藏 */
			if($("#shoucang").val()=="点击收藏"){
			 // alert("收藏");
			  $.ajax({
					type: "POST",  
		 			 dataType: "json",  
		 			 url: '/AddCollect',      //提交到一般处理程序请求数据   
		  		     data: { proNum :projectNum},           
		  		     success: function(data) {
		  		          if(data.user==0){
		  			          $('#login').modal('show');
		  		         }else if(data.flag==1){
		  			         alert("收藏成功");
		  			        
		  			         //$("#star0").addClass("btn_star_sel");//白星变黄
		  			         $("#shoucang").css("background-color","red");
		  			        /*  $("#shoucang").html("已收藏"); */
		  			        $("#shoucang").val("已收藏");
		  			        /*  window.location.reload(); */
		  		         }
		  		      }  //success
				  });//ajax
		  }//if
		  else{
			  //alert("取消收藏");
			  $.ajax({
					type: "POST",  
		 			 dataType: "json",  
		 			 url: '/DelCollect',      //提交到一般处理程序请求数据   
		  		     data: { proNum :projectNum},           
		  		     success: function(data) {
		  		          if(data.user==0){
		  			          $('#login').modal('show');
		  		         }else if(data.flag==1){
		  			         alert("取消收藏成功");
		  			         //$("#star0").addClass("btn_star_sel");//白星变黄
		  			          $("#shoucang").css("background-color","rgb(226,226,226)"); 
		  			          $("#shoucang").val("点击收藏");
		  			       /*  window.location.reload(); */
		  		         }
		  		      }  //success
				  });//ajax
		  }
	  })
	  
	});
  
  </script>

