<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
 <script src="/bootstrap/js/bootstrap.min.js"></script>  -->

 
    <style>
   #info1{
   	  background-color: rgb(255, 255, 255);
	  width: 100px;
	  z-index: 101;
	  border:1px solid #999;
	  top:60px;
	  right:10px;
   }
   #info3{}
   #mouse{}
   #info3 li{list-style-type:none; text-align:center; padding-top:3px;}
   #info3 li a{color:#7c7c7c;}
  #info3 li a:hover{text-decoration:none; color:#337ab7;}
  
  #haiwai{
   	  background-color: rgb(255, 255, 255);
	  width: 80px;
	  z-index: 101;
	  border:1px solid #999;
	  top:60px;
	  left:280px;
	  text-align:center;
	  font-family:Microsoft YaHei;
	  font-size:13px;
   }
</style>

<script type="text/javascript">
  $(function(){		
	  $("#t2").hover(function(){		       
	     	$("#haiwai").show();		   
		});
	   $("#haiwai").mouseleave(function(){
		  $("#haiwai").hide();		 
		  });
	  });	  
</script>
<script type="text/javascript">
   $().ready(function() {
  $("#login2").click(function(){
   	$('#login').modal('show');
  })
  $("#login2Re").click(function(){
   	$('#login').modal('show');
   	$('#register').modal('hide');
  })
   $("#register2").click(function(){
   	$('#register').modal('show');
  })
  $("#forget2").click(function(){
	//$('#login').modal('hide');
   	$('#forget').modal('show');
  })
  
   /* function poplogin(){
      
       $('#login').modal('show');
	}
	function poplogin1(){
       $('#register').modal('show');
	} */
  	var username = $("#username").val(); 
  
	  $("li").css("text-decoration","");
	 
	  $(".my").hover(function(){	    
	     	$("#info1").show();		   
		});
	   $("#info1").mouseleave(function(){
		  $("#info1").hide();
		 
		  });
	});
   function pop(){
       $('#modal').modal('show');
     }
     </script>
<body>     
<div style="width:auto; background:#fff url(../pic/indexbg3.png) repeat-x 0 -666px; -border-bottom:1px solid rgb(30,52,66);">     
		

     <div class="main_header" style="background-color:white; width:1190px; margin:0 auto; border:0; border-bottom:1px solid rgba(238, 238, 238, 1);">
			<div class="c-fix f-l main_header_div" id="title" style="left:0; margin-left:0;">
				<img src="images/LOGO2.png" class="c-fix f-l main_logo"></img>
				<a id="t1" href="/index01" class="f-l f-yahei s-14 main_nav cp fw ">首页</a>
				<div>
				<a id="t2" href="/SearchList" class="f-l f-yahei s-14 main_nav cp fw">房源列表</a>
				<!-- <div style="position:relative;">
				<div id="haiwai" style="position:absolute;display:none;">
<div><a href="/overseas.jsp">海外购房</a></div>
<div><a href="/SearchList">项目一览</a></div>
</div> 
				</div> --></div>
				<a id="t3" href="/SearchService" class="f-l f-yahei s-14 main_nav cp fw">服务团队</a>
				<a id="t4" href="/ZhiYeInfo" class="f-l f-yahei s-14 main_nav cp fw">置业百科</a>
				<a id="t5" href="/BlogList" class="f-l f-yahei s-14 main_nav cp fw">海外新闻</a>
				<a id="t6" href="/AboutUs.jsp" class="f-l f-yahei s-14 main_nav cp fw">关于我们</a>
				
<%
            String username = null;
       		if(request.getSession().getAttribute("username")!=null){    //判断用户是否已经登录
       			String role = request.getSession().getAttribute("role").toString();   //得到用户的角色
       			username = request.getSession().getAttribute("username").toString();
       		
%>              <div>
				<a class="f-r s-14 f-yahei main_login fw cp my"  style="margin-right:30px;">
				<%
	       			if("0".equals(role)){
	       				
	       		%>      管理员${sessionScope.username}
	       		<%
	       			}else{
	       		%>
	       				普通用户${sessionScope.username}
	       		<%
	       			}
	       		%></a>
	       		<div style="position:relative;">
<div id="info1"  style="position:absolute;display:none;">
	 <ul id="info3" style="padding-left:0px;font-size:13px;font-family:Microsoft YaHei;">
		<li><a href="/Collect.jsp">我的收藏</a></li>
		<li><a href="/changePass.jsp">更改密码</a></li>
		<%
	       	 if("0".equals(role)){   //角色是管理员
	       				
	    %><li><a href="/treeData.jsp">后台管理</a></li>
	    <%
	       	 }
	    %>
	    
		
		<li><a href="<%-- ${pageContext.request.contextPath}/logout.jsp --%>" id="logout">退出登录</a></li>
	</ul> 
</div>
	       		</div></div>
	       		<%
       			}
	         	else{
	         		
	      		%>
					<a class="f-r s-14 f-yahei main_reg fw cp" id="register2" style="margin-right:30px;">注册</a>
					<a class="f-r s-14 f-yahei main_sep fw cp">/</a>
					<a class="f-r s-14 f-yahei main_login fw cp"  id="login2" >登录</a>
					
				<%
	       			}
	       		%>
				
				

				
				
				<div class="f-r nav_icon2"></div>
				<span class="f-r s-14 f-arial fw main_phone">400 606 1935</span>
				<div class="f-r nav_icon1"></div>
			</div>	
</div>
</div>


<!-- login start -->
<div class="modal fade" id="login" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="margin-top:100px;">
     <!--  <div class="modal-content" style="margin-left:100px;height:270px;width:355px;"> -->
    <div class="modal-content" style="margin:0 auto;height:270px;width:355px;">
         <div class="modal-header" style="background-color:rgb(55,52,67);padding:0px 10px;height:10px;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true" style="font-size:18px;color:white;">
                  &times;
            </button>
         </div>
         <div class="modal-body">
  <div style="text-align:center;margin-top:5px;"><div style="font-size:20px;font-weight:bold;">欢迎登录海外房产优选</div>
  <form method="post" name="fm" action="/login" autocomplete="off" >
  <input type="hidden" id="urlInfoLog" name="urlInfoLog" value="">
  <div  style="padding-top:25px;">
         <input type="text"  id="username"
            name="username" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off"  disableautocomplete />
         <input type="hidden" id="username1" 
            name="username1" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
        <input type="hidden" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" id="role" 
            name="role" placeholder="用户角色">
       <div id="user" style="margin-left:20px;"></div>
      
   </div>
   <div>
         <input  type="password" id="password" 
            name="password" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
         <input type="hidden" id="password1" 
            name="password1" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
       <div id="pass" style="margin-left:20px;"></div>
   </div>
   
   <div style="padding-top:20px;padding-left:20px;float:left;font-size:12px;">
      <span><input type="checkbox" checked="true">记住我 <a href="javacript:void(0);" id="forget2" style="padding-left:160px;color:black;">忘记密码？</a></span>  
   </div>
   <div style="padding-top:15px;padding-left:20px;float:left;">
   <img src="images/3.png" id="login1" style="width:120px;height:30px;cursor:pointer;">   
   </div>
</form>
         </div>
   
      </div>
</div>
</div>
</div>
<!-- login end -->

<!-- register start -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="margin-top:100px;">
     <!--  <div class="modal-content" style="margin-left:100px;height:290px;width:355px;"> -->
     <div class="modal-content" style="margin:0 auto;height:290px;width:355px;">
         <div class="modal-header" style="background-color:rgb(55,52,67);padding:0px 10px;height:10px;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true" style="font-size:18px;color:white;">
                  &times;
            </button>
         </div>
         <div class="modal-body">
  <div style="text-align:center;margin-top:5px;"><div style="font-size:20px;font-weight:bold;">用户注册</div>
  <form method="post" action="/Register" name="fm2">
  <input type="hidden" id="urlInfoReg" name="urlInfoReg" value="">
  <div  style="padding-top:15px;">
         <input type="text"  id="telemail" name="telemail" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
   
   </div>
   <div>
         <input type="password" id="pwd" name="pwd" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
   </div>
   <div style="padding-top:15px;padding-left:26px;float:left;font-size:12px;">
   
   <img src="images/register.png" id="reg" style="width:120px;height:30px;cursor:pointer;"><span style="padding-left:20px;"><a id="cancel" href="#">取消</a></span>
   </div>
</form>
<div style="float:left;margin-top:60px;margin-left:-165px;font-size:12px;"><span>已有账户？<a href="javascript:void(0);" id="login2Re">登录</a></span></div>
<div style="float:left;margin-top:85px;margin-left:-165px;font-size:12px;font-weight:bold;"><span><input type="checkbox" checked="true">我已阅读并接受<a href="/ServiceProtocol.jsp" style="color:black;">《用户服务协议》</a></span></div>
</div>
   
      </div>
</div>
</div>
</div>
<!-- register end -->


<!-- forget start -->
<div class="modal fade" id="forget" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog" style="margin-top:100px;">
    <div class="modal-content" style="margin:0 auto;height:270px;width:355px;">
         <div class="modal-header" style="background-color:rgb(55,52,67);padding:0px 10px;height:10px;">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true" style="font-size:18px;color:white;">
                  &times;
            </button>
         </div>
         <div class="modal-body">
  			<div style="text-align:center;margin-top:5px;">
  			<div style="font-size:20px;font-weight:bold;">欢迎登录海外房产优选</div>
  			<form method="post" name="fm1" action="/login" autocomplete="off" >
  <div  style="padding-top:25px;">
         <input type="text"  id="userEmail"
            name="userEmail" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off"  disableautocomplete />
         <input type="hidden" id="userEmail1" 
            name="userEmail1" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
        <input type="hidden" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" id="role" 
            name="role" placeholder="用户角色">
       <div id="user" style="margin-left:20px;"></div>
      
   </div>
   
       
   
   <div style="padding-top:15px;padding-left:20px;float:left;">
   		<a href="javacript:void(0);" id="forgetSend" style="padding-left:105px;color:black;">确认发送</a>    
   </div>
</form>
         </div>
   
      </div>
</div>
</div>
</div>
<!-- forget end -->


</body>

<script>
var href = window.location.href;




var role;
 $(function() {
	
                $("#login1").click(function() {
                	$("#urlInfoLog").val(href);
                	var user = $("#username").val();
                	var pass = $("#password").val();
                	var temp;
                	temp = judge(user,pass);
                	
                	if(temp==true){
	                	var username = encode64($("#username").val());
	                	var password = encode64($("#password").val());
	                	//alert("用户名加密后的结果:"+username+"密码加密后的结果:"+password);
	                	$("#username1").val(username);
	                    $("#password1").val(password);
	                    $("#role").val(role);
	                    document.fm.submit();  //fm为form表单name
                	}
                	else{
                		return false;
                	}
                })
                
                $("#reg").click(function() {
                	$("#urlInfoReg").val(href);
                	var user = $("#telemail").val();
                  	var pass = $("#pwd").val();
                  	var temp;
                  	temp = judgeRe(user,pass);
                   
                  	if(temp==true){	 
  	                    document.fm2.submit();  //fm为form表单name
                  	}
                  	else{               	
                  		return false;
                  	} 
                  });

                  $("#cancel").click(function() {
                    	$("#telemail").val("").focus();
                    	$("#pwd").val("");
                    });  
                  
                  $("#logout").click(function(){
                	  $.ajax({
                		  type:'GET',
                		  url:'/logout?url='+href,
                		  dataType:'json',
                		  success:function(data){
                			  if(data.flag==1){
                				  window.location.href= href;
                			  }
                		  }
                		  
                	  });
                })
                  
        })

function judge(username, password){
	 var result = false;
	 if(username==""){
	 alert("请输入用户名");
		 //$("#user").html("请输入用户名");
		 return false;
	 }
	 else if(username!=""&&password==""){
	 alert("请输入密码");
		 /* $("#pass").html("请输入密码");
		 $("#user").html(""); */
		 return false;
	 }
	 else{
		$.ajax({
			type:'GET',
			url:'/loginPanduan?username='+username+'&password='+password,
			dataType:'json',
			async: false, 
			success:function(data){
				if(data.user==0){
				alert("用户名不存在");
					//$("#user").html("用户名不存在");
				}
				else if(data.user==2){
				alert("用户名和密码不符");
					/* $("#pass").html("用户名和密码不符");
					$("#user").html(""); */
				}
				else if(data.user==1){
					//alert(data.role)
					if(data.role==0){
						role = 0;
					}
					else{
						role = 1;
					}
					result=true;
				}
			},
			error:function(){
				
			}
		})
 
	 }
	
 if(result == true){
	 return true;
 }
 }
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
  	  			//alert("ffff")
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
 
$("#forgetSend").click(function(){
	if($("#userEmail").val()==""){
 	     alert("请输入用户名");
 	 }
	else{
		var userEmail = $("#userEmail").val();
		$.ajax({
			type:'post',
			url:'/sendEmail',
			dateType:'json',
			data:{"userEmail":userEmail},
			success:function(data){
				var result = JSON.parse(data);
				if(result.flag == -1){
					alert("您填写的邮箱错误！");
				}
				else{
					alert("密码已经发送您的邮箱，请注意查收！");
					window.location.href = '/index01';
				}

			},
			error:function(){
  			}
		});
	}
})
  
var keyStr = "ABCDEFGHIJKLMNOP" + "QRSTUVWXYZabcdef" + "ghijklmnopqrstuv"
+ "wxyz0123456789+/" + "=";

function encode64(input) {

var output = "";
var chr1, chr2, chr3 = "";
var enc1, enc2, enc3, enc4 = "";
var i = 0;
do {
chr1 = input.charCodeAt(i++);
chr2 = input.charCodeAt(i++);
chr3 = input.charCodeAt(i++);
enc1 = chr1 >> 2;
enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
enc4 = chr3 & 63;
if (isNaN(chr2)) {
        enc3 = enc4 = 64;
} else if (isNaN(chr3)) {
        enc4 = 64;
}
output = output + keyStr.charAt(enc1) + keyStr.charAt(enc2)
                + keyStr.charAt(enc3) + keyStr.charAt(enc4);
chr1 = chr2 = chr3 = "";
enc1 = enc2 = enc3 = enc4 = "";
} while (i < input.length);

return output;
}
</script>

