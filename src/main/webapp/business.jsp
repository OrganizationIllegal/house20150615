<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>商务合作-海房优选-海外房产优选</title> 
   <meta name="description" content="商务合作-海房优选-海外房产优选" />
   <meta name="keywords" content="海外买房,澳洲买房,海外房产投资新工具" />
<!-- core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
     <link rel="stylesheet" href="css/chosen.css">
   <script type="text/javascript">
   function reLoad(){
       var wid=document.documentElement.clientWidth ;
       if(wid<1190){
           $("#container").css("width","1190px");
       }
       else{
           $("#container").css("width","100%");
       }
       //alert(wid);
   }
   </script>
     <style>
    body{
        font: 16px/1.25 Microsoft YaHei,Tahoma,arial,\5b8b\4f53;
    }
    /* .divf1{
        width:110px;
        height:40px;
    }
    .divf2{
        width:300px;
        height:50px;
    }
    .divf3{
        width:470px;
        height:100px;
    } */
    #content{
        margin: 0px auto; 
        background-color: rgb(232, 233, 234);
        width: 100%;
    }
    #header{
        height: 360px;
        width: 100%;
       /*  position: relative; */
       /*  background-image: url(images/business/logo.jpg) */
        background:url(images/business/logo1.png);
        filter:"progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale')";
        -moz-background-size:100% 100%;
        background-size:100% 100%;
    }
    #header .loginf{
        width:275px;
        font-size: 12px;
        float:right;
        margin-right:-10px;
        margin-top:-190px;
 /*        -text-align: center; */
    }

    #header .word{
       /*  text-align: center; */
        vertical-align: middle; 
        padding-top: 150px; 
        font-size: 40px;
        font-weight:bolder;
        color: #fff;   

    }
    .control-group{
        margin-bottom: 20px;
    }
    .btn.blue {
   color: white;
   text-shadow: none;
   background-color: #4d90fe;
}
    .con{
        width:100% !important;
        padding:0px;
        margin:0px auto;
    }
    .tender{
        padding-bottom: 60px !important;
    }

.portlet.box.blue .portlet-title {
  background-color: #4b8df8;
}

.portlet.box .portlet-title {
    height: 35px;
  padding: 8px 10px 2px 10px;
  border-bottom: 1px solid #eee;
  color: #fff !important;
}
.portlet-title .caption {
  float: left;
  display: inline-block;
  font-weight: 400;
  margin: 0;
  padding: 0;
  margin-bottom: 7px;
}
.portlet.box .portlet-body {
  background-color: #fff;
  padding: 10px;
}

#feature {
  background-color: rgb(237, 238, 238);
}
.center {
  text-align: center;
  padding-bottom: 30px;
}
.center h2 {
  font-size: 36px;
  margin-top: 20px;
  margin-bottom: 20px;
}

.features {
  padding: 0;
}
.text-center {
  /* text-align: center; */
}

.text-center img{
  margin:10px auto;
}
h3 {
  font-size: 16px;
  color: #787878;
  font-weight: 400;
  width:80%;
  margin:0 auto;
  line-height: 24px;
   font: 16px Microsoft YaHei,Tahoma,arial,\5b8b\4f53;
}
.row {
  margin-right: 0px !important;
  margin-left: 0px !important;
}

.item_left{
  padding-left:160px; padding-top:60px;text-align:left;
}
.item_right{
padding-left:40px; text-align:left;
}
.login_bot{
        font-size: 12px;
       /*  text-align: center; */
}
    </style>
</head>
<body onresize="reLoad()">
<jsp:include page="head4index.jsp" />
<div id="container" class="" style="width:100%;margin:0 auto; padding-top:10px; background:#fff;">
<div class="con">
    <div id="content">
        <div id="header">
        <div style="width:1160px;margin:0 auto;position: relative;">
            <div class="word">开启中国人海外置业服务</div>
            <div class="loginf">



            <div class="portlet box blue">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-reorder"></i>成为我们的合作伙伴</div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                          <!--  <form action="http://localhost/MytoonPHP/index.php/agent/agent_save" method="post" accept-charset="utf-8">         -->                      
                               
                            
                                
                                <div class="control-group span12">
                                        <!-- <select class="control" style="width:100%">
                                            <option value="选择">选择</option>
                                        </select> -->
                                     <span>
                                        <select data-placeholder="请选择..." class="chosen-select" id="hezuo1" name="hezuo1" style="width:255px;text-align:left;" tabindex="4">
 	                                         <option value=""></option>
  	                                          <option value="房产经纪">房产经纪</option>
                                              <option value="贷款经纪">贷款经纪</option>
                                              <option value="会计师">会计师</option>
                                              <option value="购房律师">购房律师</option>
                                        </select>
                                     </span>
                                        
                                    
                                </div>
                                
<c:if test="${empty userList}">
                                <div class="control-group span12">
                                    <div class="controls">
                                        <input type="text"  style="width:100%" placeholder="姓名:">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" placeholder="电子邮件:" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="联系电话:" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="留言:" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                    <button type="submit" style="width:100%;height:25px;font-size:13px;" class="btn blue" onclick="pop1()"><i class="icon-ok"></i>提交</button>
     </c:if>
<c:if test="${!empty userList}">
      <c:forEach items="${userList}"  var="item">
                                <div class="control-group span12">
                                    <div class="controls">
                                        <input type="text"  style="width:100%" placeholder="姓名:" id="name" value="${item.nick_name}">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" placeholder="电子邮件:" id="email" value="${item.email}">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="联系电话:" id="tel" value="${item.tel}" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="留言:" id="message_content">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                    <button type="submit" style="width:100%;height:25px;font-size:13px;" class="btn blue" onclick="tijiao()"><i class="icon-ok"></i>提交</button>
     </c:forEach>
     </c:if>

                                <div style="padding-top:5px;font-weight:bold;">或拨打电话400-810-9685</div>  
                                <div>我们尊重你的隐私。请参阅我们的<span style="color:#4d90fe;">隐私政策</span></div>
                                
                          <!--   </form>  -->                      
                             </div>

                            
                            <!-- END FORM-->
                        </div>




           
            </div>
            </div>
        </div>


        <section id="feature">
        <div style="width:1190px;margin:0 auto;padding-left:20px;padding-right:20px">
           <div class="" style="text-align:center;">
                <div style="font-size:35px;padding-top:20px;">互联网海外置业</div>
</div>
            <div class="row">
                <div class="features" style="-width:80%; -margin:0 auto;">
                    <div class="col-md-4 wow fadeInDown animated" >
                        <div class="text-center">
                            <img src="images/business/1-1.png" alt="" style="height:90px;">
                            <div class="divf2" style="font-size:15.5px;padding-bottom:30px;text-align:left;line-height:150%">应用互联网技术，促成你与成千上万的潜在买家直接联系。</div>
                        </div>
                   </div>

                   <div class="col-md-4 wow fadeInDown animated" >
                        <div class="text-center">
                            <img src="images/business/1-2.png" alt="" style="height:90px;">
                            <div class="divf2" style="font-size:15.5px;padding-bottom:30px;text-align:left;line-height:150%">成熟的技术能够让你快速便捷的管理房源信息</div>
                        </div>
                   </div>

                   <div class="col-md-4 wow fadeInDown animated" >
                        <div class="text-center">
                            <img src="images/business/1-3.png" alt="" style="height:90px;">
                            <div class="divf2" style="font-size:15.5px;padding-bottom:30px;text-align:left;line-height:150%">海房优选的平台连接，让你更容易，更简单的与你的客户沟通</div>
                        </div>
                   </div>

                                   
                </div><!--/.services-->
            </div><!--/.row-->  
            </div>  
       </section>

       <section id="feature">
           <div class="center tender" style="background:#fff; padding-top:60px">
               
            <div style="width:1190px;margin:0 auto;padding-left:35px;padding-right:35px">
            <div class="row">
                <div class="col-md-6 item_left" style="-padding-left:150px;padding-left:0px; padding-top:50px;text-align:left;padding-right:10px;">
                     <h2 class="divf1">经纪人</h2>
                     <div class="divf3" style="font-size:16px;">
                     	您将可获得海外优选合作海外新盘代理权，进行新盘销售，海房优选聚集了大批普通购房者，与海房优选合作，您将获得更为丰富的客户资源！
                     <!-- 您将可获得海外优选合作海外新盘代理权，进行新盘销售，获取销售佣金提成；并通过海房优选电子化佣金结算系统，更智能、更快捷、更高效地进行佣金结算；海房优选聚集了大批普通购房者，与海房优选合作，您将获得更为丰富的客户资源！ --></div>
                </div>
                <div class="col-md-6 item_right" style="padding-left:40px; text-align:left;">
                    <img src="images/business/2.png" style="width:540px;height:360px"/>
                </div>
            </div><!--/.row-->  
            </div> </div> 
       </section>

        <section id="feature">
           <div class="center tender">
               
            <div style="width:1190px;margin:0 auto;padding-left:35px;padding-right:35px">
            <div class="row">
                
                <div class="col-md-6 item_left"  style="padding-left:0px" >
                    <img src="images/business/4.png" style="-padding-left:130px;width:540px;height:360px">
                </div>

                <div class="col-md-6 item_right" style="-padding-right:135px; padding-top:110px;text-align:left;padding-left:20px;">
                     <h2 style="text-align:left" class="divf1">开发商</h2>
                     <div style="text-align:left;font-size:16px;">成为海房优选签约开发商，您将获得全新的线上推广平台，拓展推广渠道；同时您将可以利用海房优选优质的信息展示平台，全方位提升品牌形象；</div>
                </div>
            </div><!--/.row--> 
            </div></div>   
       </section>

       <section id="feature">
           <div class="center tender" style="background:#fff; padding-top:50px">
               
           <div style="width:1190px;margin:0 auto;padding-left:35px;padding-right:35px">
            <div class="row">
                <div class="col-md-6 item_left" style="-padding-left:150px;padding-left:0px; padding-top:50px;text-align:left;padding-right:12px;">
                     <h2 class="divf1">服务商</h2>
                     <div style="font-size:16px;">
                     	海房优选聚集了大批直接购房者，成为海外优选签约服务商，您将获得更多优质的潜在用户，并能够和购房者直接联系，高效服务
                     <!-- 海房优选聚集了大批有海外生活服务需求的会员用户，成为海外优选签约服务商，您将获得更多优质的潜在用户；成为海房优选签约服务商，您将可获得海房优选客户直接的需求派单；并在抢单后通过海房优选电子化佣金结算系统，更智能、更便捷、更高效地进行佣金结算； --></div>
                </div>
                <div class="col-md-6 item_right" style="padding-left:40px; text-align:left;">
                    <img src="images/business/5.png" style="width:540px;height:360px"/>
                </div>
            </div><!--/.row-->  
            </div> </div> 
       </section>




       <section id="feature">
               
            <div  class="login_bot" style="width:270px; margin:0px auto;padding:40px 0px;">
             <div class="portlet box blue">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-reorder"></i>成为我们的合作伙伴</div>
                        </div>
                        <div class="portlet-body form">
                            <!-- BEGIN FORM-->
                          <!--  <form action="http://localhost/MytoonPHP/index.php/agent/agent_save" method="post" accept-charset="utf-8">        -->                       
                               
                       
                                
                                <div class="control-group span12">
                                       <!--  <select class="control" style="width:100%">
                                            <option value="选择">选择</option>
                                        </select> -->
                                          <span>
                                        <select data-placeholder="请选择..." class="chosen-select" id="hezuo2" name="hezuo2" style="width:255px;" tabindex="4" style="float:left;text-align:left;">
 	                                          <option value=""></option>
  	                                          <option value="房产经纪">房产经纪</option>
                                              <option value="贷款经纪">贷款经纪</option>
                                              <option value="会计师">会计师</option>
                                              <option value="购房律师">购房律师</option>
                                        </select>
                                     </span>
                                        
                                    
                                </div>
                                

                              <!--   <div class="control-group span12">
                                    <div class="controls">
                                        <input type="text"  style="width:100%" placeholder="姓名:">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" placeholder="电子邮件:" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="联系电话:" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="留言:" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                    <button type="submit" style="width:100%;height:25px;font-size:13px;" class="btn blue"><i class="icon-ok"></i>提交</button> -->
                                    <c:if test="${empty userList}">
                                <div class="control-group span12">
                                    <div class="controls">
                                        <input type="text"  style="width:100%" placeholder="姓名:">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" placeholder="电子邮件:" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="联系电话:" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="留言:" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                    <button type="submit" style="width:100%;height:25px;font-size:13px;" class="btn blue" onclick="pop1()"><i class="icon-ok"></i>提交</button>
     </c:if>
<c:if test="${!empty userList}">
      <c:forEach items="${userList}"  var="item">
                                <div class="control-group span12">
                                    <div class="controls">
                                        <input type="text"  style="width:100%" placeholder="姓名:" id="name2" value="${item.nick_name}">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" placeholder="电子邮件:" id="email2" value="${item.email}">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="联系电话:" id="tel2" value="${item.tel}" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="留言:" id="message_content2">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                    <button type="submit" style="width:100%;height:25px;font-size:13px;" class="btn blue" onclick="tijiao2()"><i class="icon-ok"></i>提交</button>
     </c:forEach>
     </c:if>

                                <div style="padding-top:5px;font-weight:bold;">或拨打电话400-810-9685</div>  
                                <div>我们尊重你的隐私。请参阅我们的<span style="color:#4d90fe;">隐私政策</span></div>
                                
                           <!--  </form>        -->                
                             </div>

                            
                            <!-- END FORM-->
                        </div>
            
                
               <!--  <div class="portlet box blue">
                        <div class="portlet-title">
                            <div class="caption"><i class="icon-reorder"></i>成为我们的合作伙伴</div>
                        </div>
                        <div class="portlet-body form">
                            BEGIN FORM
                           <form action="http://localhost/MytoonPHP/index.php/agent/agent_save" method="post" accept-charset="utf-8">                              
                               
                       
                                
                                <div class="control-group span12">
                                        <select class="control" style="width:100%">
                                            <option value="地级市">地级市</option>
                                        </select>                                                                
                                </div>
                                

                                <div class="control-group span12">
                                    <div class="controls">
                                        <input type="text"  style="width:100%" placeholder="姓名">
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" placeholder="邮箱" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="联系电话" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <input type="text" style="width:100%" class="span12" placeholder="留言" >
                                        <span class="help-inline"></span>
                                    </div>
                                </div>

                                    <button type="submit" style="width:100%" class="btn blue"><i class="icon-ok"></i>提交</button>
                                
                            </form>    

                            <div>或拨打电话400-810-9685</div>  
                            <div>我们尊重你的隐私，请参阅我们的隐私政策</div>                   
                        </div>

                            
                </div>
 -->
            </div><!--/.row-->    
       </section>




   </div>
</div>
</div>

<!-- register start -->
<div class="modal fade" id="registernewPro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:285px;width:355px;">
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
	

<jsp:include page="foot4index.jsp" />
<script type="text/javascript">
function pop1(){
		  $('#registernewPro').modal('show');

}
$(function() {
	$("#xiangmuZhuce").click(function(){
		$('#registernewPro').modal('show');
	})

	 $("#login2RePro").click(function(){
		   	$('#login').modal('show');
		   	$('#registernewPro').modal('hide');
  })   


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
		   
})

function tijiao(){
	var  username=$("#name").val();
	var message_content=$("#message_content").val();
	var hezuo1=$("#hezuo1").val();
	 $.ajax({  
         type: "POST",  
         dataType: "json",  
         data:{username:username,message_content:message_content,hezuo:hezuo1},
         url: '/hezuoMessageSubmit',           
         success: function(data) {
        	 if(data.flag==1){
        	 alert("提交成功");
        	 $("#message_content").val("");
        	 }
         }
      		});
}
function tijiao2(){
	var  username=$("#name2").val();
	var message_content=$("#message_content2").val();
	var hezuo2=$("#hezuo2").val();
	 $.ajax({  
         type: "POST",  
         dataType: "json",  
         data:{username:username,message_content:message_content,hezuo:hezuo2},
         url: '/hezuoMessageSubmit',           
         success: function(data) {
        	 if(data.flag==1){
        	 alert("提交成功");
        	 $("#message_content2").val("");
        	 }
         }
      		});
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
