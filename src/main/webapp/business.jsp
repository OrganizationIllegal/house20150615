<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Business Cooperation</title>
<!-- core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
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
        text-align: center;
    }

    #header .word{
        text-align: center;
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
  text-align: center;
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
        text-align: center;
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
                           <form action="http://localhost/MytoonPHP/index.php/agent/agent_save" method="post" accept-charset="utf-8">                              
                               
                       
                                
                                <div class="control-group span12">
                                        <select class="control" style="width:100%">
                                            <option value="选择">选择</option>
                                        </select>
                                        
                                    
                                </div>
                                

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

                                    <button type="submit" style="width:100%;height:25px;font-size:13px;" class="btn blue"><i class="icon-ok"></i>提交</button>

                                <div style="padding-top:5px;font-weight:bold;">或拨打电话400-810-9685</div>  
                                <div>我们尊重你的隐私。请参阅我们的<span style="color:#4d90fe;">隐私政策</span></div>
                                
                            </form>                       
                             </div>

                            
                            <!-- END FORM-->
                        </div>




           
            </div>
            </div>
        </div>


        <section id="feature">
        <div style="width:930px;margin:0 auto;">
           <div class="" style="text-align:center;">
                <div style="font-size:35px;padding-top:20px;">互联网海外置业</div>
</div>
            <div class="row">
                <div class="features" style="-width:80%; -margin:0 auto;">
                    <div class="col-md-4 wow fadeInDown animated" >
                        <div class="text-center">
                            <img src="images/business/1-1.png" alt="">
                            <div class="divf2" style="font-size:15.5px;padding-bottom:30px;">应用互联网技术，促成你与成千上万的潜在买家直接联系。</div>
                        </div>
                   </div>

                   <div class="col-md-4 wow fadeInDown animated" >
                        <div class="text-center">
                            <img src="images/business/1-2.png" alt="">
                            <div class="divf2" style="font-size:15.5px;padding-bottom:30px;">成熟的技术能够让你快速便捷的管理房源信息</div>
                        </div>
                   </div>

                   <div class="col-md-4 wow fadeInDown animated" >
                        <div class="text-center">
                            <img src="images/business/1-3.png" alt="" style="height:90px;">
                            <div class="divf2" style="font-size:15.5px;padding-bottom:30px;">海房优选的平台连接，让你更容易，更简单的与你的客户沟通</div>
                        </div>
                   </div>

                                   
                </div><!--/.services-->
            </div><!--/.row-->  
            </div>  
       </section>

       <section id="feature">
           <div class="center tender" style="background:#fff; padding-top:60px">
               
            <div style="width:930px;margin:0 auto;">
            <div class="row">
                <div class="col-md-6 item_left" style="-padding-left:150px; padding-top:50px;text-align:left;padding-right:10px;">
                     <h2 class="divf1">经纪人</h2>
                     <div class="divf3" style="font-size:16px;">您将可获得海外优选合作海外新盘代理权，进行新盘销售，获取销售佣金提成；并通过海房优选电子化佣金结算系统，更智能、更快捷、更高效地进行佣金结算；海房优选聚集了大批普通购房者，与海房优选合作，您将获得更为丰富的客户资源！</div>
                </div>
                <div class="col-md-6 item_right" style="padding-left:40px; text-align:left;">
                    <img src="images/business/2.png"/>
                </div>
            </div><!--/.row-->  
            </div> </div> 
       </section>

        <section id="feature">
           <div class="center tender">
               
            <div style="width:930px;margin:0 auto;">
            <div class="row">
                
                <div class="col-md-6 item_left"  >
                    <img src="images/business/4.png"/ style="-padding-left:130px;">
                </div>

                <div class="col-md-6 item_right" style="-padding-right:135px; padding-top:110px;text-align:left;padding-left:20px;">
                     <h2 style="text-align:right" class="divf1">开发商</h2>
                     <div style="text-align:left;font-size:16px;">成为海房优选签约开发商，您将获得全新的线上推广平台，拓展推广渠道；同时您将可以利用海房优选优质的信息展示平台，全方位提升品牌形象；</div>
                </div>
            </div><!--/.row--> 
            </div></div>   
       </section>

       <section id="feature">
           <div class="center tender" style="background:#fff; padding-top:50px">
               
           <div style="width:930px;margin:0 auto;">
            <div class="row">
                <div class="col-md-6 item_left" style="-padding-left:150px; padding-top:50px;text-align:left;padding-right:12px;">
                     <h2 class="divf1">服务商</h2>
                     <div style="font-size:16px;">海房优选聚集了大批有海外生活服务需求的会员用户，成为海外优选签约服务商，您将获得更多优质的潜在用户；成为海房优选签约服务商，您将可获得海房优选客户直接的需求派单；并在抢单后通过海房优选电子化佣金结算系统，更智能、更便捷、更高效地进行佣金结算；</div>
                </div>
                <div class="col-md-6 item_right" style="padding-left:40px; text-align:left;">
                    <img src="images/business/5.png"/>
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
                           <form action="http://localhost/MytoonPHP/index.php/agent/agent_save" method="post" accept-charset="utf-8">                              
                               
                       
                                
                                <div class="control-group span12">
                                        <select class="control" style="width:100%">
                                            <option value="选择">选择</option>
                                        </select>
                                        
                                    
                                </div>
                                

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

                                    <button type="submit" style="width:100%;height:25px;font-size:13px;" class="btn blue"><i class="icon-ok"></i>提交</button>

                                <div style="padding-top:5px;font-weight:bold;">或拨打电话400-810-9685</div>  
                                <div>我们尊重你的隐私。请参阅我们的<span style="color:#4d90fe;">隐私政策</span></div>
                                
                            </form>                       
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
<jsp:include page="foot4index.jsp" />
</body>
</html>