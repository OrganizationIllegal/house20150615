<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
$(function() {
$("#register2new").click(function(){
   	$('#registernew').modal('show');
  })

   $("#login2ReFooter").click(function(){
   	$('#login').modal('show');
   	$('#registernew').modal('hide');
  })
  
  $("#regnew").click(function() {
    	var user = $("#telemailnew").val();
    	var pass = $("#pwdnew").val();
    	var temp;
    	temp = judgeRe(user,pass);
    	//alert(temp)             	
    	if(temp==true){	                	
            document.fm1.submit();  //fm为form表单name
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
});
</script>
<div class="row" style="width:100%; margin: 0 auto;height:310px;vertical-align:middle;text-align:center;position:relative;">
        <!-- <img  src="../images/button4.png" height=310 width="100%"> -->
        <div class="main_bkg" style="background:url(images/海房_index_top.jpg) no-repeat;width: 100%;/* background-attachment: fixed; */
    background-position: center 0;height:310px;background-position-y: 0px;"></div>
        <!-- <div>
        	<img src="/pic/whiteangle.jpg"></img>
        </div> -->
        <div style="top: -50%; position: relative;margin-top: -54px;/* left:7px; */">
            <font style="font-size:32px;font-weight:normal;color:#FFFFFF;font-family:'微软雅黑'">聪明海外置业</font><br><br>
            <div style="position: relative;left: 48%;margin-left: -43px;height:54px;width:86px;">
            <div style="padding-top: 6%;">
            <img  src="../images/00.png" id="register2new">
           <!--  <a class="buttton" style="margin-top: 6px;color:white;font-size:32px;font-weight:normal;cursor:pointer;" id="register2new"
          >注册</a> -->
          </div>
            </div>
        </div>
</div>
  
<!-- register start -->
<div class="modal fade" id="registernew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
   
   </div>
   <div>
         <input type="password" id="pwdnew" name="pwdnew" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
   </div>
   <div style="padding-top:15px;padding-left:26px;float:left;font-size:12px;">
   
   <img src="images/register.png" id="regnew" style="width:120px;height:30px;cursor:pointer;"><span style="padding-left:20px;"><a id="cancelnew" href="#">取消</a></span>
   </div>
</form>
<div style="float:left;margin-top:60px;margin-left:-165px;font-size:12px;"><span>已有账户？<a href="javascript:void(0);" id="login2ReFooter">登录</a></span></div>
<div style="float:left;margin-top:85px;margin-left:-165px;font-size:12px;font-weight:bold;"><span><input type="checkbox" checked="true">我已阅读并接受<a href="/ServiceProtocol.jsp" style="color:black;">《用户服务协议》</a></span></div>
</div>
   
      </div>
</div>
</div>
</div>
<!-- register end -->