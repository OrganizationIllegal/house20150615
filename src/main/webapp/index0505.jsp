﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>HouseSale</title>
   <link href="css/style.css" rel="stylesheet" type="text/css" />
   <link href="css/style_project.css" rel="stylesheet" type="text/css" />
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <link href="/css/index.css" rel="stylesheet">  
   <script src="http://echarts.baidu.com/build/dist/echarts-all.js" charset="GBK"></script>
   <script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0"></script>
   <!--<script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0"></script>-->
   <script src="/js/bingMap.js"></script>
   <link href="/css/List-Grid-View.css" rel="stylesheet">
   <script src="/echarts/echarts-all.js"></script>
   <link href="./bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">


<link href="/css/pgwslider.min.css" rel="stylesheet">
<link href="/css/video-js.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="js/jquery-1.5.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/script_p.js"></script>
<script src="js/video.js"></script>
<script>videojs.options.flash.swf = "/js/video-js.swf";</script>
<!-- 计算器 start -->
<script type="text/javascript">
function compute(){
var a=$('#select1').find("option:selected").val();
var b=$('#select2').find("option:selected").val();
var c=$('#select3').find("option:selected").val();
var d=$('#input1').val();
var e=$('#input2').val();
}
</script>
<!-- 计算器end -->
<!-- 锚定位 start -->
<script type="text/javascript">
function offSet(){
	  if(location.hash){
	     var target = $(location.hash);
	     if(target.length==1){
	         var top = target.offset().top-150;
	         if(top > 0){
	             $('html,body').animate({scrollTop:top});
	         }
	     }
	  }
	}
function tab1(){ 
	 location.hash="#info";
	 offSet();
} 
function tab2(){ 
	 location.hash="#price";
	 offSet();
} 
function tab3(){ 
	 location.hash="#position";
	 offSet();
} 
function tab4(){ 
	 location.hash="#round";
	 offSet();
} 
function tab5(){ 
	 location.hash="#purchase";
	 offSet();
} 
function tab6(){ 
	 location.hash="#invest";
	 offSet();
} 
</script>
<!-- 锚定位 end -->
<!-- pop guorui start -->
<script type="text/javascript">
function pop(type,img){
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
</script>
<!-- pop guorui end -->
</head>
<body style="padding-top: 105px;background-color:rgba(233, 243, 248, 1);" onload="getIndexMap();">
<jsp:include page="head.jsp" />
<div class="container" style="">
<!-- 导航标签 -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-top:100px;min-height:30px;margin-bottom: 0px;">
<ul class="nav nav-tabs nav-justified" id="tab">
   <li><a href="#info"  onclick="tab1()">项目介绍</a></li>
   <li><a href="#price"  onclick="tab2()">户型和价格</a></li>
   <li><a href="#position"  onclick="tab3()">项目位置</a></li>
   <li><a href="#round"  onclick="tab4()">配套及周边</a></li>
   <li><a href="#purchase"  onclick="tab5()">购房费用</a></li>
   <li><a href="#invest"  onclick="tab6()">投资分析</a></li>
</ul>
</nav>
<!--项目图片-->
<div style="margin-top:20px;/* background-color:white; */">
    <div class="ad_position" style="height:600px;/* background-color:white; */">

        <div class="limit" style="height:600px;width:1100px;">
            <div style="float:left;width:850px;display:inline;">

                <table class="ad_left_big" width="850" border="0" cellpadding="0" cellspacing="0" style="margin-top: 0px;">
                    <tr><td><img src="images/a.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><video id="example_video_1" class="video-js vjs-default-skin" controls preload="none"  data-setup="{}"width="850" height="600" >
                        <source src="s.mp4" type='video/mp4'/>
                        <track kind="captions" src="demo.captions.vtt" srclang="en" label="English"></track>Tracks need an ending tag thanks to IE9
                        <track kind="subtitles" src="demo.captions.vtt" srclang="en" label="English"></track>Tracks need an ending tag thanks to IE9
                    </video>
                    </td>
                    </tr>
                    <tr><td><img src="images/c.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><img src="images/d.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><img src="images/e.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><img src="images/f.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><img src="images/g.jpg" width="850" height="600" /></a></td></tr>
                </table>
            </div>

            <div class="ad_small_box" style="width:250px;height:600px;">
                <div class="top_button off"></div>
                <div class="small_right_limit">
                    <ul style="margin-top: 0px;">

                        <li><img src="images/a.jpg" width="250" height="140"/></li>
                        <li><img src="images/b.jpg" width="250" height="140"/></li>
                        <li><img src="images/c.jpg" width="250" height="140"/></li>
                        <li><img src="images/d.jpg" width="250" height="140"/></li>
                        <li><img src="images/e.jpg" width="250" height="140"/></li>
                        <li><img src="images/f.jpg" width="250" height="140"/></li>
                        <li><img src="images/g.jpg" width="250" height="140"/></li>
                    </ul>
                    <div class="this_ad" style="top:0px;"><img src="images/this_ad.gif" width="250" height="159" /></div>
                </div>
                <div class="bottom_button"></div>
            </div>


        </div>



    </div>
</div>

<!--关键字-->
<div style="margin-top:20px;background-color:white;">
	<div class="row">
     <div class="col-md-1"></div>
     <div class="col-md-2">
      <div class="checkbox">
      <label>
      <input type="checkbox"> 请打勾
      </label>
   </div>
     </div>
     <div class="col-md-2">
      <div class="checkbox">
      <label>
      <input type="checkbox"> 请打勾
      </label>
   </div>
     </div>
     <div class="col-md-2">
      <div class="checkbox">
      <label>
      <input type="checkbox"> 请打勾
      </label>
   </div>
     </div>
     <div class="col-md-2">
      <div class="checkbox">
      <label>
      <input type="checkbox"> 请打勾
      </label>
   </div>
     </div>
     <div class="col-md-2">
      <div class="checkbox">
      <label>
      <input type="checkbox"> 请打勾
      </label>
   </div>
     </div>
     <div class="col-md-1"></div>
</div>
</div>

<!--The Elements-->
<div style="margin-top:20px;background-color:white;">
<div class="container"  >
<div class="col-md-2" >
				<dl class="fore1">
				<dd>
					<div>
						<span style="font-size:20px;color:black;target="_blank" href="#"">The Elements</span>
						</div>
						<div>
							<span style="font-size:16px;font-family:宋体;color:black;target="_blank" href="#"">IDLand</span>
							</div>
					</dd>
				</dl>
					</div>
				<div class="col-md-2"></div>
				
			<div class="col-md-2" >
				<dl class="fore1">
				<dd>
					<div>
						<span style="font-size:20px;color:black;target="_blank" href="#"">2011.03</span>
						</div>
						<div>
							<span style="font-size:16px;font-family:宋体;color:black;target="_blank" href="#"">首付金额（起价） </span>
							</div>
					</dd>
				</dl>
					</div>
					
					<div class="col-md-2" >
				<dl class="fore1">
				<dd>
					<div>
						<span style="font-size:20px;color:black;target="_blank" href="#"">$5.000</span>
						</div>
						<div>
							<span style="font-size:16px;font-family:宋体;color:black;target="_blank" href="#"">交房日期 </span>
							</div>
					</dd>
				</dl>
					</div>
			
					<div class="col-md-2" >
				<dl class="fore1">
				<dd>
					<div>
						<span style="font-size:20px;color:black;target="_blank" href="#"">$5.000</span>
						</div>
						<div>
							<span style="font-size:16px;font-family:宋体;color:black;target="_blank" href="#"">物业费/每月 </span>
							</div>
					</dd>
				</dl>
					</div>
					
					<div class="col-md-2" >
				<dl class="fore1">
				<dd>
					<div>
						<span style="font-size:20px;color:black;target="_blank" href="#"">$0.37</span>
						</div>
						<div>
							<span style="font-size:16px;font-family:宋体;color:black;target="_blank" href="#"">印花税</span>
							</div>
					</dd>
				</dl>
					</div>
					</div>
</div>

<!--价格区间-->
<div style="margin-top:20px;background-color:white;">
	<div class="row">
		<div class="col-md-2 col-md-offset-1">
		<span style="font-size:20px;color:black;">
					&nbsp;价格区间
		</span>
		<hr style="width:200;height:3;">
			</div>
		</div>
	
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<div>

				<div>
					<span style="font-size:30px;color:black;font-family:"黑体";">$950K-$2.2M</span>
					</div>
					
						<div style="padding-left:35px">
						<button type="button" onclick="pop3()" class="btn dropdown-toggle" data-toggle="dropdown" style="background-color:#EEAD0E;width:150px;margin-left:15px;color:white;"><span class="glyphicon glyphicon-chevron-right"></span>索取完整价格单</button>
						</div>
			</div>
			</div>
			
			<div class="col-md-5 col-md-offset-3">
						<button type="button" class="btn btn-info btn-lg" style="background-color:#EEAD0E;width:400px;height:76px;margin-left:15px;color:white;><span style="font-size:40px;color:white;font-family:"华文彩云";margin-top:30px;position:absolute;bottom:0;">返现金额:${returnPrice}</span></button>
				</div>
	
	</div>
	</div>

<!--价格区间-->

<!--基本信息-->
<div style="margin-top:20px;background-color:white;" id="info">
	<div class="row">
		<div class="col-md-8">
				<div class="row">
					
					<div class="col-md-3 col-md-offset-1" style="height:45px;">
						<span style="font-size:20px;font-family:"宋体";">
								基本信息
							<hr style="width:800px;margin-top:0px;"></hr>
							
					</div>
				</div>
					
					
				<div class="row">
					
					<div class="col-md-3 col-md-offset-1">
							<dl class="fore1">
							<dd>
								<div>
							<span style="font-size:16px;">
								开发商:XXX
							</span>
							</div>
							
							<div>
							<span style="font-size:16px;">
								类型：公寓别墅
							</span>
						</div>
							
							<div>
							<span style="font-size:16px;">
								国家：澳大利亚
							</span>
						</div>
								
							<div>
							<span style="font-size:16px;">
								城市：墨尔本
							</span>
							</div>
							
							<div>
							<span style="font-size:16px;">
								位置：XXX&nbsp;182XXXXX
							</span>
							</div>
							
							<div>
							<span style="font-size:16px;">
								面积：52-170M
							</span>
							</div>
							
							<div>
							<span style="font-size:16px;">
								户型：1局
							</span>
							</div>
							
							<div>
							<span style="font-size:16px;">
								城市：墨尔本
							</span>
							</div>
							
							<div>
							<span style="font-size:16px;">
								价格：$145M
							</span>
							</div>
							
							<div>
							<span style="font-size:16px;">
								预交房日期：2016年第3季度
							</span>
							</div>
							
							<div>
							<span style="font-size:16px;">
								可售房数：6
							</span>
							</div>
							
						</dd>
					</dl>
						</div>
						
					
					
					<div class="col-md-4 col-md-offset-3">
							
							<div class="row">		
								
								<div class="col-md-8">
								<div class="row">
								<span style="font-size:25px;">The Elements</span>
								</div>
								
								<div class="row">
								<button type="button" class="btn btn-info btn-lg" style="background-color:blue;width:180px;height:30px;padding-top:1px;"><span style="font-size:10px;color:white;font-family:"宋体";">AMITY</span></button>
								</div>
				  		
				  		</div>
				  		
				  		<div class="col-md-6"></div>
				  			
				  		</div>	
				  		
				  		<div class="row">
				  			
				  			<p style="font-size:10px;">
				  				${projectdescription}
				  				</p>
				  			
				  			</div>		
				  
				  
				  
				  
				  
				  <div class="col-md-1"></div>
				  
					
				</div>
			</div>
	</div>

					
	<div class="col-md-4" style="background-color:rgba(237, 237, 237, 1);">
		
		<div class="row" style="margin-top:45px;width:80%; margin-left:10%;margin-right:10%;" >
			
			<div>
			<span style="font-size:22px;">想要了解更多吗？</span>
			</div>
			
			<div>
			<span style="font-size:15px;">填写信息我们会有专业人士一对一服务</span>
			</div>
			
			
			</div>
		
		
		<div class="row"	style="width:100%; margin-left:-3%;margin-right:10%;margin-top:20px;"> 
		<div style="padding-left:5px;padding-right:5px;">
	<div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="firstname" 
            placeholder="姓名">
      </div>
      <div class="col-sm-1"></div>
   </div>
   
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="firstname" 
            placeholder="邮件">
      </div>
      <div class="col-sm-1"></div>
   </div>
   
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="firstname" 
            placeholder="电话">
      </div>
      <div class="col-sm-1"></div>
   </div>
   
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="firstname" 
            placeholder="需求">
      </div>
      <div class="col-sm-1"></div>
   </div>
   
		

			
			
		 <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" id="lastname" 
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
			
		
		</div>
		</div>

			</div>
		
		
	</div>


</div>
<!--基本信息-->



<!--项目详情-->
<div style="margin-top:20px;background-color:white;">
	<div class="panel panel-default">
  		<div class="panel-heading">项目详情</div>
  		<div class="panel-body">
  			<div>
  			 <!--  <hr> -->
				<h2>The Elements</h2>
				<p class="lead">世界级的建筑</p>
  			</div>
  			<div id="detail">
  			           正在寻找阿里旺旺官方下载？阿里旺旺买家版2013是阿里巴巴为淘宝买家度身定做的免费网上沟通软件，阿里旺旺还可以让您在购物后随时了解交易状态。直接搜索商品。快速进入淘宝网。阿里旺旺官方下载2013买家版能帮您轻松找客户，发布、管理商业信息；及时把握商机，随时洽谈做生意！
  			<p>
  			正在寻找阿里旺旺官方下载？阿里旺旺买
  			</div>
  			<div class="container">
 				<button type="button" class="btn">详情咨询</button>
  			
			</div>
  		</div>
  		 
  	</div>
</div>
<!--户型及价格-->
<div style="margin-top:20px;background-color:white;" id="price" >
<div class="panel panel-default">
<div class="panel-heading" style="background-color:white;font-weight:bold;padding-left:35px;">户型及价格</div>
<div class="panel-body">
<c:forEach var="obj" items="${HouseInfoList}"> 
<div class="row" style="height:60px;background-color:#DEDEDE;margin:0px 20px;">
<div class="col-md-3" style="color:black;font-weight:900;font-size:23px;font-family:SimHei;padding-top: 15px;">户型 ${obj.house_type}</div>
<div class="col-md-1">
<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;">${obj.house_room_num}</div>
<div style="text-align:center;font-weight:bold;font-family:SimHei;">卧室</div>
</div>
<div class="col-md-1" style="margin-left:40px;">
<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;">${obj.house_toilet_num}</div>
<div style="text-align:center;font-weight:bold;font-family:SimHei;">卫生间</div>
</div>
<div class="col-md-1" style="margin-left:40px;">
<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;">${obj.house_size}</div>
<div style="text-align:center;font-weight:bold;font-family:SimHei;">面积</div>
</div>
<div class="col-md-2" style="margin-left:40px;padding:0px 30px;">
<div style="background-color:white;margin-top: 10px;text-align:center;border-radius:5px;font-weight:bold;">${obj.house_price}</div>
<div style="text-align:center;font-weight:bold;font-family:SimHei;">房价</div>
</div>
<div class="col-md-4" style="width:200px;margin-top:12px;">
<div class="dropdown">
<button type="button" onclick="pop('${obj.house_type}','${obj.house_img}')" class="btn dropdown-toggle" data-toggle="dropdown" style="background-color:#EEAD0E;width:180px;margin: 0 auto;color:white;"><span class="glyphicon glyphicon-chevron-down"></span>&nbsp;&nbsp;&nbsp;点击查看户型图</button>
</div>
</div>
</div>
<hr style="height:1px;border:none;border-top:1px solid #ffffff;margin-top:5px;margin-bottom:0px;" />
 </c:forEach> 	
<div class="row">
<div class="col-md-2 col-md-offset-8" style="margin-top:10px;">
<button type="button" onclick="pop1()" class="btn dropdown-toggle" data-toggle="dropdown" style="background-color:#EEAD0E;width:130px;margin-left:15px;color:white;"><span class="glyphicon glyphicon-chevron-right"></span>&nbsp;&nbsp;&nbsp;最新价格</button>
</div>
<div class="col-md-2" style="margin-top:10px;">
<button type="button" onclick="pop2()" class="btn dropdown-toggle" data-toggle="dropdown" style="background-color:#EEAD0E;width:130px;margin-left:10px;color:white;"><span class="glyphicon glyphicon-chevron-right"></span>&nbsp;&nbsp;&nbsp;完整户型</button>
</div>
</div>	  
</div></div></div>





<div style="margin-top:20px;background-color:white;">
<div class="panel panel-default">
<div class="panel-heading">项目配套</div>
    <div class="ad_position_p" style="height:645px;/* background-color:white; */">
        <div class="limit_p" style="height:600px;width:1100px;">
            <div style="float:left;width:850px;display:inline;">
                <table class="ad_left_big_p" width="850" border="0" cellpadding="0" cellspacing="0" style="margin-top: 0px;">
                    <tr><td><img src="images/a.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><img src="images/c.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><img src="images/d.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><img src="images/e.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><img src="images/f.jpg" width="850" height="600" /></a></td></tr>
                    <tr><td><img src="images/g.jpg" width="850" height="600" /></a></td></tr>
                </table>
            </div>

            <div class="ad_small_box_p" style="width:250px;height:600px;">
                <div class="top_button off"></div>
                <div class="small_right_limit_p">
                    <ul style="margin-top: 0px;">
						<li><img src="images/a.jpg" width="250" height="140"/></li>
                        <li><img src="images/c.jpg" width="250" height="140"/></li>
                        <li><img src="images/d.jpg" width="250" height="140"/></li>
                        <li><img src="images/e.jpg" width="250" height="140"/></li>
                        <li><img src="images/f.jpg" width="250" height="140"/></li>
                        <li><img src="images/g.jpg" width="250" height="140"/></li>
                    </ul>
                    <div class="this_ad_p" style="top:0px;"><img src="images/this_ad.gif" width="250" height="159" /></div>
                </div>
                <div class="bottom_button"></div>
            </div>
        </div>

</div>

    </div>
</div> 
<!--项目位置-->
<div style="margin-top:20px;background-color:white;" id="position">
<div class="panel panel-default">
	  <div class="panel-heading">项目位置</div>
	  <div class="panel-body">
	  	<div class="row">
	  	<div class="col-md-6">
	  	<div id="indexMap" style="position:relative; width:540px; height:370px;"></div>
	  	</div>
	  	<div class="col-md-6">
	  	 <!-- <div><img src="images/streetside.png"></div> -->
	  	 <div id="eyeMap" style="position:relative; width:540px; height:370px;"></div>
	  	 </div>
	  	</div>
      	</div>
	  </div>
	</div>

<!--学校及周边-->
<div style="margin-top:20px;background-color:white;" id="round">
	<div class="panel panel-default">
  		<div class="panel-heading">学校及周边</div>
  		<div class="panel-body">
  			<div class="item  col-xs-6 col-lg-6">
            <div class="thumbnail">
            	<div>
            	<center>
                <img class="group list-group-image" src="/pic/traffic.jpg" alt="" data-trigger="hover" data-container="body" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
                
                </img>
                </center>
                <span style="position: absolute; top: 160; left: 250;font-weight:bold;font-size:22">99</span>
                
                </div>
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        附近学校</h4>
                    
                    <ul class="list-group">
                    	<c:forEach items="${nearSchoolList}" var="item" begin="0" end="4" step="1" varStatus="var">
                    		<li class="list-group-item" style="background-color:#f2eada"><span style="float:right">${item.schoolName}</span>${item.schoolType}</li>
					  		<li class="list-group-item" style="background-color:white"><span style="float:right">${item.schoolDistance}km</span>学校排名 第${item.schoolRank}名</li>
                    	</c:forEach>
					</ul>
                </div>
            </div>
	     </div>
	     <div class="item  col-xs-6 col-lg-6">
	            <div class="thumbnail">
	            	<div>
		            	<center>
		                <img class="group list-group-image" src="/pic/onfoot.jpg" alt="" data-trigger="hover" data-container="body" data-toggle="popover" data-placement="top" data-content="Vivamus sagittis lacus vel augue laoreet rutrum faucibus.">
		                
		                </img>
		                </center>
		                <span style="position: absolute; top: 160; left: 275;font-weight:bold;font-size:22">100</span>
		                
		             </div>
	                
	                <div class="caption">
	                    <h4 class="group inner list-group-item-heading">
	                        附近配套</h4>
	                    
	                    <ul class="list-group">
						  <c:forEach items="${nearSchoolFacility}" var="item" begin="0" end="4" step="1" varStatus="var">
                    		<li class="list-group-item" style="background-color:#f2eada"><span style="float:right">${item.facility_name}</span>${item.facility_type}</li>
					  		<li class="list-group-item" style="background-color:white"><span style="float:right">${item.facility_distance}km</span>学校排名 第${item.facility_rank}名</li>
                    	</c:forEach>
						</ul>
	                </div>
	            </div>
	     </div>
		</div>
  		 
  	</div>
</div>
<!--估计总购房税费-->
<div style="margin-top:20px;background-color:white;" id="purchase">
<ul class="nav nav-tabs" id="costTabs">
      <li class="active"><a href="#home" data-toggle="tab">购房税费</a></li>
      <li><a href="#profile" data-toggle="tab">持有成本</a></li>
      <li class="navbar-text navbar-right">&nbsp;&nbsp;&nbsp;&nbsp;</li>
      <p class="navbar-text navbar-right"><b>以总价50万澳币计算</b></p>
      <!-- <div class="col-md-2 col-md-pull-5"><p><b>以总价50万澳币计算</b></p></div> -->
      <!-- <li class="pull-right"><p><b>以总价50万澳币计算</b></p></li> -->
      <!-- <li class="disabled"><a href="#profile" data-toggle="tab">Web Service</a></li> -->
      <!--<li class="navbar-right">&nbsp;&nbsp;&nbsp;&nbsp;</li> 
      <li class=""><p><b>以总价50万澳币计算</b></p></li>
      <li class="navbar-right">&nbsp;&nbsp;&nbsp;&nbsp;</li> -->
    </ul>
    
    <div class="tab-content">
      <div class="tab-pane active" id="home">
      	<div style="padding-top:10px;padding-bottom:10px;">
      		<div style="float:left;margin-right:20px;margin-left:20px;">
      			<p>估计总购房税费</p>
      		</div>
      		<div>
      			<b>约${houseTaxSum}澳元</b>
      			<!--
      			<select id="MySelect">
				<option>约5万澳元</option>
				<option>约15万澳元</option>
				<option>约115万澳元</option>
				</select>
				-->
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
      			<!--
      			<select id="MySelect1">
				<option value='5'>约5万澳元</option>
				<option value='15'>约15万澳元</option>
				<option value='115'>约115万澳元</option>
				</select>
				-->
      		</div>
      		<!--
      		<div style="margin-left:20px;float:left;">
      			<p>税费范围</p>
      		</div>
      		<div style="margin-left:20px;float:left;">
      			<p>约1万澳元</p>
      		</div>
      		<div style="margin-left:20px;float:left;">
      			<p>约7万澳元</p>
      		</div>
      		-->
      	</div>
      	<div>
      		<div id="ChengBen_pie" style="height:200px">
      			</div>
      	</div>
      </div> 
      
  	</div>
</div>

<!--贷款每月还款多少-->
<div style="margin-top:20px;background-color:#9FB6CD;height:400px;padding:30px 40px;">
<div class="row">
<div class="col-md-3">
<div style="color:white;font-weight:900;font-size:25px;font-family:SimHei;">贷款每月</div>
<div style="color:white;font-weight:900;font-size:25px;font-family:SimHei;">还款是多少</div>
</div>
<div class="col-md-9"></div>
</div>
<hr style="height:1px;border:none;border-top:1px solid #ffffff;margin-top:5px;margin-bottom:5px;opacity:0.5;" />
<div class="row">
<div class="col-md-3" style="margin-top:-30px;padding-left:40px;">
<div style="color:white;font-weight:900;font-size:100px;font-family:SimHei;">?</div>
</div>
<div class="col-md-3">
<div style="color:white;font-weight:900;font-size:16px;font-family:SimHei;">贷款方式</div>
<select class="form-control" style="margin-top:8px;width:220px;" id="select1">
    <option>只还利息</option>
    <option>无息贷款</option>
    <option>连本带利</option>
  </select>      
</div>
<div class="col-md-3" style="padding-left:0px;">
<div style="color:white;font-weight:900;font-size:16px;font-family:SimHei;">首付比例</div>
<select class="form-control" style="margin-top:8px;width:220px;margin-left:15px;" id="select2">
    <option>20%</option>
    <option>25%</option>
    <option>30%</option>
  </select> 
</div>
<div class="col-md-3" style="padding-left:0px;">
<div style="color:white;font-weight:900;font-size:16px;font-family:SimHei;">贷款年限</div>
<select class="form-control" style="margin-top:8px;width:220px;margin-left:15px;" id="select3">
    <option>25年</option>
    <option>30年</option>
    <option>35年</option>
  </select>
</div>
</div>
<div class="row"  >
<div class="col-md-3 col-md-offset-3" style="margin-top:-20px;">
<div style="color:white;font-weight:900;font-size:16px;font-family:SimHei;">房款总额</div>
<div class="input-group" style="width:220px;">
<input type="text" class="form-control" placeholder="$400,000" style="margin-top:8px;" id="input1">
</div>
</div>
<div class="col-md-3" style="margin-top:-20px;">
<div style="color:white;font-weight:900;font-size:16px;font-family:SimHei;">税率</div>
<div class="input-group" style="width:220px;">
<input type="text" class="form-control" placeholder="2.48%" style="margin-top:8px;" id="input2">
</div>
</div>
<div class="col-md-3">
<button type="button" onclick="compute()" class="btn btn-default" style="margin-left:0px;width:220px;">计算</button>
</div>
</div>
<div class="row" style="margin-top:50px;">
<div class="col-md-9 col-md-offset-3" style="margin-top:-20px;background-color:#4682B4;height:60px;margin-left:288px;width:755px;">
<div class="row">
<div class="col-md-2 col-md-offset-2" style="margin-top: 18px;padding-left:0px;">
<div style="color:white;font-weight:900;font-size:18px;font-family:SimHei;">还款金额</div>
</div>
<div class="col-md-7" style="padding-right:0px;width: 425px;">
<input type="text" class="form-control" style="margin-top:13px;width:400px;">
</div>
<div class="col-md-1" style="margin-top: 18px;padding-left:0px;">
<div style="color:white;font-weight:900;font-size:18px;font-family:SimHei;">/月</div>
</div>
</div>
</div>
</div>
</div>

<!--投资数据-->
<div style="margin-top:20px;background-color:white;" id="invest">
<div class="panel panel-default">
	  <div class="heading">South Melbourne投资数据<br>
	 <span id="detail"> 投资数据参考2卧室房产</span>
	  
	  </div>
	  <hr>
	  <div class="panel-body-info">
	  	<table id="MyTable" align="center">
	  	
    <tr> 
        <th>年增长率</td> 
        <th>中位数价格</td> 
        <th>中位数租金</td>
        <th>租房空置率</td>
        <th>租赁需求</td>
        <th>现金回报</td>
    </tr> 
    <tr class="table_tab1"> 
        <td>1.1%</td> 
        <td>$561K</td> 
        <td>S560周</td> 
        <td>5.0%</td> 
        <td>低
        </td> 
        <td>￥129/月</td> 
    </tr> 
    <tr class="table_tab2"> 
        <td></td> 
        <td></td> 
        <td></td> 
        <td></td> 
        <td>每单位102探访</td> 
        <td></td> 
    </tr> 
	  	</table>
      	</div>
	  </div>
	</div>

<!--中位数公寓房价-->
<div style="margin-top:20px;background-color:white;padding:40px 0px;">
<div class="row" style="height:200px;">
<div class="col-md-2"></div>
 <div class="col-md-2" style="padding-left:70px;padding-right:0px;">
 <div><img src="images/buy.png"></div>
 <div style="color:#FF7F00;font-weight:900;font-size:28px;">&nbsp;&nbsp;$561,000</div>
 </div>
 <div class="col-md-3" style="padding-left:50px;width:340px;">
 <div style="color:#000000;font-weight:900;font-size:16px;">South Melbourne中位数公寓房价</div>
 <div style="color:#333;font-size:8px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价格最后更新日期为2015.02.02</div>
 </div>
 <div class="col-md-4">
 <div><img src="images/rent.png"></div>
 <div style="color:#27408B;font-weight:900;font-size:25px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;560/周</div>
 </div>
</div>
<div class="row">
<div class="col-md-5 col-md-offset-1">
 <div class="btn-toolbar btn-group-lg" role="toolbar" aria-label="...">
     <button type="button" class="btn btn-inverse" style="height:100px;width:140px;float:left;">
     <div style="color:#FF7F00;font-weight:900;">1居</div>
     <div style="color:#000000;font-weight:900;">$409,000</div>
     </button>
      <button type="button" class="btn btn-inverse" style="height:100px;width:140px;float:left;">
     <div style="color:#FF7F00;font-weight:900;">2居</div>
     <div style="color:#000000;font-weight:900;">$409,000</div>
     </button>
     <button type="button" class="btn btn-inverse" style="height:100px;width:140px;float:left;">
     <div style="color:#FF7F00;font-weight:900;">3居</div>
     <div style="color:#000000;font-weight:900;">$409,000</div>
     </button>
 </div></div>
 <div class="col-md-6">
 <div class="btn-toolbar btn-group-lg" role="toolbar" aria-label="...">
     <button type="button" class="btn btn-inverse" style="height:100px;width:140px;float:left;">
     <div style="color:#27408B;font-weight:900;">1居</div>
     <div style="color:#000000;font-weight:900;">$409</div>
     </button>
     <button type="button" class="btn btn-inverse" style="height:100px;width:140px;float:left;">
     <div style="color:#27408B;font-weight:900;">2居</div>
     <div style="color:#000000;font-weight:900;">$409</div>
     </button>
     <button type="button" class="btn btn-inverse" style="height:100px;width:140px;float:left;">
     <div style="color:#27408B;font-weight:900;">3居</div>
     <div style="color:#000000;font-weight:900;">$409</div>
     </button>
 </div></div>
</div>
</div>
<!--trend-->
<div  style="margin-top:20px;background-color:white;">
 <ul class="nav nav-tabs nav-justified" id="trendTabs">
      <li class="active"><a href="#price" data-toggle="tab">South MelBourne区域中位数房价走势</a></li>
      <li><a href="#rent" data-toggle="tab">South MelBourne区域租金走势</a></li>
      <li><a href="#emptypercent" data-toggle="tab">South MelBourne区域空置率走势</a></li>
     <!-- <p class="navbar-text navbar-right">Signed in as Mark Otto</p>-->
    </ul>
    
    <div class="tab-content">
      <div class="tab-pane active" id="price">
      	<div>
      		<div id="price_line" style="height:350px"></div>
      	</div>
      </div> 
      <div class="tab-pane" id="rent">
      	<div>
      		<div id="rent_line" style="height:350px">
      			</div>
      	</div>
      </div> 
      <div class="tab-pane" id="emptypercent">
      	<div>
      		<div id="emptypercent_line" style="height:350px">
      			</div>
      	</div>
      </div> 
  	</div>
</div>


<!--近期区域成交情况list-->
<div style="margin-top:20px;background-color:white;">
	<div class="panel panel-default">
	  <div class="panel-heading">South Melbourne近期区域成交情况<div class="pull-right"><font size="1">数据来源：PGData 最近更新时间：11/02/15</font></div></div>
	  <table class="table table-striped">
    	<thead>
    		<tr class="row">
    		<th>地址</th>
    		<th>价格</th>
    		<th>床位</th>
    		<th>销售类型</th>
    		<th>销售时间</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${latestSaleInfoVolist}" var="item" begin="0" end="4" step="1" varStatus="var">
			<tr class="row">
    			<td>${item.address}</td>
    			<td><span>$</span>${item.price}</td>
    			<td>${item.house_type}</td>
    			<td>${item.sale_type}</td>
    			<td>${item.sale_time}</td>
    		</tr>
			 </c:forEach> 
    	</tbody>
  	  </table>
	</div>
</div>

<!--地区特点start-->
<div style="margin-top:20px;">
  <div class="panel panel-default">
  	<div class="panel-heading" style="background-color:white;">Sourth Melbourne 地区特点</div>
  	 <div class="panel-body">
  	     	<div class="col-xs-6">
  	     	<ol>
  	     	<c:forEach items="${featureList}"
			 var="item"
			 begin="0"
			 end="4"
			 step="1"
			 varStatus="var">
				<li>${item}</li>
			 </c:forEach>
  	     		</ol>
  	     	</div>
  	     	<div class="col-xs-6">
  	     		<ol start="6">
  	     			<c:forEach items="${featureList}"
					 var="item"
					 begin="5"
					 end="9"
					 step="1"
					 varStatus="var">
						<li>${item}</li>
					 </c:forEach>
  	     		</ol>
  	     	</div>
     </div>
  </div>
<div>
<!--地区特点end-->
<!--人口分布-->
<div style="margin-top:20px;background-color:white;">
<div class="panel panel-default">
	  <div class="panel-heading">South Melbourne区域人口分布<div class="pull-right"><font size="1">数据来源：PGData 最近更新时间：11/02/15</font></div></div>
	  <table class="table table-striped">
	  	
    	<thead>
    		<tr class="row">
    		<th class="col-md-4">人口总数</th>
    		<th class="col-md-4">区域</th>
    		<th class="col-md-4">城市</th>
    		</tr>
    	</thead>
    	
    	<tbody>
    	<c:forEach items="${peopleInfoList}" var="item" varStatus="var">
			<tr class="row">
    			<td>${item.count}</td>
    			<td>${item.area}</td>
    			<td>${item.city}</td>
    		</tr>
		</c:forEach> 
    	</tbody>
  	  </table>
  	  <table class="table table-striped">
	  	
    	<thead>
    		<tr class="row">
    		<th class="col-md-4">出生国家</th>
    		<th class="col-md-4">区域</th>
    		<th class="col-md-4">城市</th>
    		</tr>
    	</thead>
    	
    	<tbody>
    	<c:forEach items="${peopleNationList}" var="item" varStatus="var">
			<tr class="row">
    			<td>${item.born_nation}</td>
    			<td>${item.area}<span>%</span></td>
    			<td>${item.city}<span>%</span></td>
    		</tr>
		</c:forEach> 
    	</tbody>
  	  </table>
  	  <table class="table table-striped">
	  	
    	<thead>
    		<tr class="row">
    		<th class="col-md-4">海外出生-前${peopleForeignNum}位</th>
    		<th class="col-md-4">区域</th>
    		<th class="col-md-4">城市</th>
    		</tr>
    	</thead>
    	
    	<tbody>
    	<c:forEach items="${peopleForeignList}" var="item" varStatus="var">
			<tr class="row">
    			<td>${item.born_foreign}</td>
    			<td>${item.area}<span>%</span></td>
    			<td>${item.city}<span>%</span></td>
    		</tr>
		</c:forEach> 
    	</tbody>
  	  </table>
  	  <table class="table table-striped">
	  	
    	<thead>
    		<tr class="row">
    		<th  class="col-md-4">平均家庭收入</th>
    		<th  class="col-md-4">区域</th>
    		<th  class="col-md-4">城市</th>
    		</tr>
    	</thead>
    	
    	<tbody>
    	<c:forEach items="${familyIncomeList}" var="item" varStatus="var">
			<tr class="row">
    			<td>${item.family_income}</td>
    			<td><span>$</span>${item.area}</td>
    			<td><span>$</span>${item.city}</td>
    		</tr>
		</c:forEach> 
    	</tbody>
  	  </table>
	</div>
</div>
<!--人口分布end>

<!--区域家庭情况构成pie-->
<div style="margin-top:20px;background-color:white;">
<div class="panel panel-default">
	  <div class="panel-heading">South Melbourne区域家庭情况构成</div>
	  <div class="panel-body">
	  	<div id="zonefamily_pie" style="height:200px">
      	</div>
	  </div>
	</div>
</div>

<!--新闻报道-->
<!--新闻报道-->
<div style="margin-top:20px;background-color:white;">
	<div class="panel panel-default" id="MyPanel">
	<div class="heading1"><strong>新闻报道</strong><br></div>
	<div class="panel-body">
  		<div class="row">
          <div class="news_position">
          		<div class="info" id="left">
                <!-- <div class="scroll" id="left"> -->
                     <!-- <img src="/images/news.jpg" alt="" width=350px height=255px> -->
                     <div class="news_action_left" style="display:none;">
	                     <ul class="list_l" id="list_scroll_left">
							  <li >Cras justo odio</li>
							  <li >span Dapibus ac facilisis in</li>
							  <li >Morbi leo risus</li>
							  <li >Vestibulum at eros</li>
						</ul>
                    
                     </div>
                </div>
                <div class="caption_my" style="height:98px;">
		         <h3 id="title_news" style="font-weight: bold; font-size:20px;">新闻标题：北京信息</h3>
		         <p>新闻来源：北京   &nbsp;&nbsp;&nbsp;&nbsp;时间：2015</p>
		        </div>
           </div>
		   <div class="news_position" id="MyNews">
		      	<div class="info" id="middle">
                     <div class="news_action_middle" style="display:none;">
	                     <ul class="list_m" id="list_scroll_middle">
							  <li >Cras justo odio</li>
							  <li >span Dapibus ac facilisis in</li>
							  <li >Morbi leo risus</li>
							  <li >Vestibulum at eros</li>
						</ul>
                    
                     </div>
                </div>
                <div class="caption_my" style="height:98px;">
		         <h3 style="font-weight: bold; font-size:20px;">新闻标题新闻标题</h3>
		         <p style="font-weight: bold; font-size:20px;">新闻标题新闻标题</p>
		        </div>
		   </div>
		   <div class="news_position">
		   		<div class="info" id="right">
                <!-- <div class="scroll" id="left"> -->
                     <!-- <img src="/images/news.jpg" alt="" width=350px height=255px> -->
                     <div class="news_action_right" style="display:none;">
	                     <ul class="list_r" id="list_scroll_right">
							  <li >Cras justo odio</li>
							  <li >span Dapibus ac facilisis in</li>
							  <li >Morbi leo risus</li>
							  <li >Vestibulum at eros</li>
						</ul>
                    
                     </div>
                </div>
		      <!-- <div class="scroll" id="right">
                     <img src="/images/news.jpg" alt="" width=350px height=255px>
                </div> -->
                <div class="caption_my" style="height:98px;">
		         <h3 class="title_news" style="font-weight: bold; font-size:20px;">新闻标题：北京信息</h3>
		         <p>新闻来源：北京   &nbsp;&nbsp;&nbsp;&nbsp;时间：2015</p>
		        </div>
		   </div>
		   
   </div>
</div>
  		</div>
  		 
  	</div>
</div>

<!--

<!--你是否需要房产经纪人start-->
<div style="margin-top:20px;background-color:rgba(177, 220, 245, 1);" >
<div class="row">
    <!--左边 start-->
	<div class="col-xs-3" >
	  <div  class="col-xs-9">
	   <div id="wenzi" style="margin:20 0 20 20">
	     <span style="color:white;"><h3><strong>你是否需要</strong></h3></span>
	     <span style="color:white"><h3><strong>房产经纪人</strong></h3></span>
	  	 <!--<img alt="image" class="img-responsive" src="pic/as.png">-->
	   </div>
	   </div>
	   <div class="col-xs-3" style="margin:20 0">
	       <img alt="image"  src="pic/wenhao.png">
	   </div>
 	</div>
 	 <!--左边 end-->
 	 <!--中间start线-->
 	<div class="col-xs-1" >
 		<div style="float:right;width: 1px;height: 563px; background: white;margin:20 0"></div>
 	</div>
 	 <!--中间end线-->
 	
 	 <!--右边 start-->
 	<div class="col-xs-8">
 	      <!--列表 start-->
 		 <div id="list"  class="brdr bgc-fff pad-10 box-shad btm-mrg-20 property-listing" style="margin:20 20 20 5">
 		    <!--第一个元素start-->
 		 	 <div id="firstitem" style="border:1px solid #E6E6FA;padding:20 20;background-color:white;margin:10 10;">
           		  <div class="media">
          			  <a class="pull-left" href="#" target="_parent">
              				<img alt="image" class="img-responsive" src="pic/yangkun2.jpg">
           			  </a>
           		 	  <div class="clearfix visible-sm"></div>
           		 	  <div class="media-body fnt-smaller" style="padding:0 0 0 15px">
                		  <h4 class="media-heading"><b>李先生</b></h4>
                		  <h6>从业经验：8年</h6>
                		  <h6>语言：普通话、粤语、英文</h6>
                		  <h6>区域：Sourth Melbourne</h6>
                		  <img alt="image" class="img-responsive" src="pic/houseicon.JPG">
            		 </div>
      			 </div>
     		 </div>
     		 <!--第一个元素end-->
     		 <!--第二个元素start-->
     		  <div id="firstitem" style="border:1px solid #E6E6FA;padding:20 20;background-color:white;margin:10 10;">
           		  <div class="media">
          			  <a class="pull-left" href="#" target="_parent">
              				<img alt="image" class="img-responsive" src="pic/yangkun2.jpg">
           			  </a>
           		 	  <div class="clearfix visible-sm"></div>
           		 	  <div class="media-body fnt-smaller" style="padding:0 0 0 15px">
                		  <h4 class="media-heading"><b>李先生</b></h4>
                		  <h6>从业经验：8年</h6>
                		  <h6>语言：普通话、粤语、英文</h6>
                		  <h6>区域：Sourth Melbourne</h6>
                		  <img alt="image" class="img-responsive" src="pic/houseicon.JPG">
            		 </div>
      			 </div>
     		 </div>
     		 <!--第二个元素end-->
     		 <!--第三个元素start-->
     		  <div id="firstitem" style="border:1px solid #E6E6FA;padding:20 20;background-color:white;margin:10 10;">
           		  <div class="media">
          			  <a class="pull-left" href="#" target="_parent">
              				<img alt="image" class="img-responsive" src="pic/yangkun2.jpg">
           			  </a>
           		 	  <div class="clearfix visible-sm"></div>
           		 	  <div class="media-body fnt-smaller" style="padding:0 0 0 15px">
                		  <h4 class="media-heading"><b>李先生</b></h4>
                		  <h6>从业经验：8年</h6>
                		  <h6>语言：普通话、粤语、英文</h6>
                		  <h6>区域：Sourth Melbourne</h6>
                		  <img alt="image" class="img-responsive" src="pic/houseicon.JPG">
            		 </div>
      			 </div>
     		 </div>
     		 <!--第三个元素end-->
 		 </div>
 		  <!--列表 end-->
 	</div>
 	 <!--右边end-->
 </div>	
</div>



<!--新闻报道-->
<div style="margin-top:20px;background-color:white;">
	<div class="panel panel-default" id="MyPanel">
	<div class="heading1"><strong>推荐项目</strong><br></div>
	<div class="panel-body">
  		<div class="row">
          <div class="news_position">
                <div class="scroll" id="left">
                     <img src="/images/pic.jpg" alt="" width=350px height=255px>
                </div>
                <div class="caption_my" style="height:98px;">
		         <p class="desc"><a href="#">Lorem ipsum dolor sit amet</a> </p>
		         <p>${projectdescription}</p>
		          
		        </div>
           </div>
		   <div class="news_position">
                <div class="scroll" id="left">
                     <img src="/images/pic.jpg" alt="" width=350px height=255px>
                </div>
                <div class="caption_my" style="height:98px;">
		         <p class="desc"><a href="#">Lorem ipsum dolor sit amet</a> </p>
		         <p>${projectdescription}</p>
		          
		        </div>
           </div>
		   <div class="news_position">
		      <div class="scroll" id="right">
                     <img src="/images/pic.jpg" alt="" width=350px height=255px>
                </div>
                <div class="caption_my" style="height:98px;">
		         <p class="desc"><a href="#">Lorem ipsum dolor sit amet</a> </p>
		         <p>${projectdescription}</p>
		          
		        </div>
		   </div>
		   
   </div>
</div>
  		</div>
  		 
  	</div>
</div>




</div>
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
            <form class="form-horizontal" role="form">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="firstname" 
            placeholder="姓名">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="lastname" 
            placeholder="登录密码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="lastname" 
            placeholder="电话号码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="lastname" 
            placeholder="电子邮箱">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
        <input type="text" class="form-control" id="lastname" 
            placeholder="最新价格">
  </select>      
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" id="lastname" 
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>

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
            <form class="form-horizontal" role="form">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="firstname" 
            placeholder="姓名">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="lastname" 
            placeholder="登录密码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="lastname" 
            placeholder="电话号码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="lastname" 
            placeholder="电子邮箱">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
       <input type="text" class="form-control" id="lastname" 
            placeholder="完整户型">      
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" id="lastname" 
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>

         </div>
   
      </div>
</div>
</div>
<!-- 完整户型模态框end -->
<!-- 索取完整价格单模态框start-->
<div class="modal fade" id="demandprice" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
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
            <form class="form-horizontal" role="form">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="firstname" 
            placeholder="姓名">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="lastname" 
            placeholder="登录密码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="lastname" 
            placeholder="电话号码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" id="lastname" 
            placeholder="电子邮箱">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
       <input type="text" class="form-control" id="lastname" 
            placeholder="索取完整价格单">      
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <textarea type="text" rows="5" cols="20" class="form-control" id="lastname" 
            placeholder="留言"></textarea>
            
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">发送</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>

         </div>
   
      </div>
</div>
</div>
<!-- 索取完整价格单模态框end -->
<div>
</div>
 <jsp:include page="foot.jsp" /> 
 <script type="text/javascript">

  var houseTaxStr=${houseTaxStr};
  var housetaxdata=${housetaxdata};

  var holdingTaxStr=${holdingTaxStr};
  var holdingdata=${holdingdata};
 </script>
 <script  type="text/javascript">
  var family={num1:"${dulirateVo}",num2:"${youngfamilyVo}",num3:"${oldfamilyVo}"};

  var trend_areamiddle_year="${areaMiddleYeatList}";
  var trend_areamiddle_rate="${areaMiddleRateList}";
  var areaZujinYeatList="${areaZujinYeatList}";
  var areaZujinRateList="${areaZujinRateList}";
  var areaZhikongYeatList="${areaZhikongYeatList}";
  var areaZhikongRateList="${areaZhikongRateList}";

  

 </script>
 <script src="/js/familyStatus.js" charset="GBK"></script>
 <script src="/js/trend.js" charset="GBK"></script>
 <script src="/js/cost.js" charset="GBK"></script>
 <script src="/js/news.js"></script>
 <script type="text/javascript">
 	$(function () {
  		$('[data-toggle="popover"]').popover()
	});
 </script>
</body>
</html>