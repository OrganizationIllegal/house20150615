<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
   <title>HouseSale</title>
  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <script src="/bootstrap/js/bootstrap.min.js"></script>   
</head>

<body style="font-family:Microsoft YaHei;background-color:rgb(232, 233, 234);">
	<jsp:include page="head4index.jsp" />
<div style="width:1190px;height:1000px;padding:20px 50px;margin:0px auto;background-color:white;">
<div style="width:1060px;height:200px;padding:15px;background-color:rgba(245, 244, 244, 1);margin:0px auto;">
<div style="width:168px;height:168px;-border:5px solid white;float:left;"><img alt="经纪人图片" src="<%=application.getInitParameter("imagedir")%>/${brokerInfo.broker_img}" style="width:168px;height:168px;"></div>
<div style="width:500px;height:110px;float:left;margin-left:20px;margin-top:40px;">
<div style="font-size:20px;font-weight:bold;">${brokerInfo.broker_name}</div>
<div style="margin-top:10px;height:20px;">
	<img alt="house" src="images/service/house.png" style="float:left;">
	<div style="font-size:15px;margin-top:-2px;float:left;">${brokerInfo.broker_type}</div>
</div>
<div style="margin-top:10px;"><!-- <img alt="btn" src="images/service/btn1.png"> -->
	<c:if test="${not empty brokerInfo.phone}">
	  <div style="width:50%;float:left;font-weight:bold"><img src="images/tel.png">${brokerInfo.phone}</div>
	</c:if>
	<c:if test="${not empty brokerInfo.email}">
	  <div style="width:50%;float:left;font-weight:bold"><img src="images/email.png">${brokerInfo.email}</div>
	</c:if>
	<c:if test="${not empty brokerInfo.wechat}">
	  <div style="width:50%;float:left;font-weight:bold"><img src="images/weixin.png">${brokerInfo.wechat}</div>
	</c:if>
	<c:if test="${not empty brokerInfo.qq}">
	  <div style="width:50%;float:left;font-weight:bold"><img src="images/qq.png">${brokerInfo.qq}</div>
	</c:if>
</div>
</div>
<div style="width:340px;height:180px;margin-left:720px;">
<div style="width:310px;height:85px;background-color:rgba(55, 52, 67, 1);padding:15px;">
	<div style="width:65px;height:65px;color:white;">
	<div style="font-size:15px;">房产经验</div>
	<div style="font-size:40px;font-weight:bolder;">${brokerInfo.broker_experience}</div>
	</div>
	<div style="width:50px;height:100px;float:right;margin-top:-60px;"><img alt="star" src="images/service/star.png"></div>
</div>
<div style="width:310px;height:85px;background-color:rgba(191, 59, 72, 1);margin-top:10px;padding:15px;">
	<div style="width:80px;height:65px;color:white;font-size:15px;">
	<div>语言</div>
	<div style="margin-top:10px;">${brokerInfo.broker_language}</div>
	</div>
	<div style="width:50px;height:50px;float:right;margin-top:-60px;margin-right:10px;"><img alt="star" src="images/service/rili.png"></div>
</div>
</div>
</div>
<%-- <c:if test="${! empty  brokerInfo.areaList}"> --%>
	<div style="width:205px;height:100px;margin-top:30px;margin-left:15px;">
	<div style="font-size:20px;font-weight:bold;">服务区域</div>
	<c:forEach var="item" items="${areaList}" varStatus="stat">
	<div style="width:190px;height:30px;background-color:rgba(246, 241, 238, 1);margin-top:10px;padding-left:15px;">
	
		<img alt="shu" src="images/service/pic1.png" style="float:left;">
		<div style="float:left;font-size:13px;margin-top:5px;margin-left:5px;">${item}</div>
	</div>
	</c:forEach>

	 <div style="font-size:20px;font-weight:bold;">所在区域</div>
	<div style="width:190px;height:30px;background-color:rgba(246, 241, 238, 1);margin-top:10px;padding-left:15px;">
		<img alt="shu" src="images/service/pic1.png" style="float:left;">
		<div style="float:left;font-size:13px;margin-top:5px;margin-left:5px;">${brokerInfo.broker_region}</div>
	</div> 

	
	
	</div>
<%-- </c:if> --%>
<c:if test="${! empty  brokerInfo.leixingInfo}">
<div style="width:470px;height:70px;margin-left:250px;margin-top:-20px;">
<div style="font-size:20px;font-weight:bold;float:left;margin-top:-78px;">擅长类型</div>
<img alt="jiantou" src="images/service/pic2.png" style="float:left;margin-top:-75px;margin-left:80px;">
<c:forEach items="${ brokerInfo.leixingInfo}" var="item" varStatus="stat">
<c:if test="${fn:length(brokerInfo.leixingInfo)==1}">
          <img alt="house1" src="images/service/h1.png" style="float:left;margin-top:-40px;">
			<div style="font-size:15px;float:left;margin-top:-35px;margin-left:30px;">${item.leixing }</div>


</c:if>
<c:if test="${fn:length(brokerInfo.leixingInfo)==1}">
          <img alt="house1" src="<%=application.getInitParameter("imagedir")%>/${item.leixingImg }" width="26px" height="30px" style="float:left;margin-top:-40px;">
		 <div style="font-size:15px;float:left;margin-top:-35px;margin-left:30px;">${item.leixing }</div>
</c:if>
<c:if test="${fn:length(brokerInfo.leixingInfo)==2}">
<c:choose>
		<c:when test="${stat.index==0 }">
			<img alt="house1" src="<%=application.getInitParameter("imagedir")%>/${item.leixingImg }" width="26px" height="30px" style="float:left;margin-top:-40px;">
			<div style="font-size:15px;float:left;margin-top:-35px;margin-left:30px;">${item.leixing }</div>
		</c:when>
		
		<c:otherwise>
			<img alt="house2" src="<%=application.getInitParameter("imagedir")%>/${item.leixingImg }" width="26px" height="30px" style="float:left;margin-top:-40px;margin-left:150px;">
	        <div style="font-size:15px;float:left;margin-top:-35px;margin-left:200px;">${item.leixing }</div>
		</c:otherwise>
	
	
	</c:choose>
</c:if>
<c:if test="${fn:length(brokerInfo.leixingInfo)==3}">

		<c:choose>
		<c:when test="${stat.index==0 }">
			<img alt="house1" src="<%=application.getInitParameter("imagedir")%>/${item.leixingImg }" width="26px" height="30px" style="float:left;margin-top:-40px;">
			<div style="font-size:15px;float:left;margin-top:-35px;margin-left:30px;">${item.leixing }</div>
		</c:when>
		<c:when test="${stat.index==1 }">
			<img alt="house2" src="<%=application.getInitParameter("imagedir")%>/${item.leixingImg }" width="26px" height="30px" style="float:left;margin-top:-40px;margin-left:150px;">
	        <div style="font-size:15px;float:left;margin-top:-35px;margin-left:200px;">${item.leixing }</div>
		</c:when>
		<c:otherwise>
			<img alt="house3" src="<%=application.getInitParameter("imagedir")%>/${item.leixingImg }" width="26px" height="30px" style="float:left;margin-top:-40px;margin-left:310px;">
	        <div style="font-size:15px;float:left;margin-top:-35px;margin-left:365px;">${item.leixing }</div>
		</c:otherwise>
	
	
	</c:choose>
</c:if>


	
</c:forEach>


	
	
	
	
</div>
</c:if>




<div style="width:470px;height:70px;margin-left:250px;margin-top:-40px;">
<div style="font-size:20px;font-weight:bold;float:left;margin-top:0px;">专业资质</div>
<img alt="jiantou" src="images/service/pic2.png" style="float:left;margin-top:5px;">
<div style="font-size:15px;float:left;margin-top:40px;margin-left:-114px;">${brokerInfo.broker_zizhi}</div>
<div style="font-size:15px;float:left;margin-top:40px;margin-left:80px;">${brokerInfo.office}</div>
</div>
<div style="width:470px;-height:160px;margin-left:250px;margin-top:40px;">
	<div style="font-size:20px;font-weight:bold;float:left;margin-top:0px;">自我描述</div>
	<img alt="jiantou" src="images/service/pic2.png" style="float:left;margin-top:5px;">
	<div style="font-size:15px;float:left;margin-top:20px;">${brokerInfo.introduction}</div>
</div>
<div style="width:240px;height:375px; float:right; margin-top:-160px; margin-right:15px;">
	<div style="width:240px;height:100px;background-color:rgba(88, 79, 63, 1);text-align:center;font-size:18px;color:white;">
	<div style="padding-top:30px;">让我们推荐一个最适合</div>
	<div>您的房产经纪</div>
	</div>
	<div style="width:240px;height:280px;background-color:rgba(233, 232, 231, 1);">
	<c:if test="${empty userList}">
	<input type="text" id="name" name="name" placeholder="姓名" style="width:200px;height:28px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;">
	<input type="text" id="email" name="email" placeholder="邮箱" style="width:200px;height:28px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;">
	<input type="text" id="tel" name="tel" placeholder="电话" style="width:200px;height:28px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;">
	<textarea type="text" rows="5" cols="20" id="liuyan" name="liuyan" placeholder="留言" style="width:200px;height:60px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;padding-top:10px;"></textarea>
	<img alt="submit" src="images/service/tijiao.png" style="float:right;margin-right:10px;margin-top:5px;cursor:pointer;" onclick="pop1()">
	</c:if>
	 <c:forEach items="${userList}"  var="item">
	 <input type="text" id="name" name="name"  value="${item.nick_name}" placeholder="姓名" style="width:200px;height:28px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;">
	<input type="text" id="email" name="email" value="${item.email}" placeholder="邮箱" style="width:200px;height:28px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;">
	<input type="text" id="tel" name="tel" value="${item.tel}"  placeholder="电话" style="width:200px;height:28px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;">
	<textarea type="text" rows="5" cols="20" id="liuyan" name="liuyan" placeholder="留言" style="width:200px;height:60px;margin-left:15px;margin-top:15px;font-size:15px;padding-left:10px;padding-top:10px;"></textarea>
	<img alt="submit" src="images/service/tijiao.png" onclick="tijiao()" style="float:right;margin-right:10px;margin-top:5px;cursor:pointer;">
	 </c:forEach>
	
	</div>
</div>
</div>
<jsp:include page="foot4index.jsp" />
</body>
</html>


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
	var message_content=$("#liuyan").val();
	 $.ajax({  
         type: "POST",  
         dataType: "json",  
         data:{username:username,message_content:message_content},
         url: '/MessageSubmit',           
         success: function(data) {
        	 if(data.flag==1){
        	 alert("提交成功");
        	 $("#liuyan").val("");
        	 }
         }
      		});
}
</script>
