<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>HouseSale</title>
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
   <link href="/css/index.css" rel="stylesheet">
   <script>
   function pop(){
       $('#modal').modal('show');
     }
   </script>
</head>
<body>
<div class="container">
 <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="row" style="background-color:rgba(19, 51, 89, 1);padding-top:10px;padding-bottom: 5px;">
	  <div class="col-md-1"></div>
      <div class="col-md-6" style="padding-right:0px;">
      <span style="font-size:18px;color:yellow;style="text-align:bottom;font-family:SimHei;">海豚会(haitunhui.cn)</span>
      <span style="font-size:8px;color:white;font-family:SimHei;">由《经理人》联合中国商业领袖共同发起的、基于移动互联网技术的智慧型公益组织。</span>
      </div>
      <div class="col-md-2 col-md-offset-1" >
       <span class="glyphicon glyphicon-phone-alt" style="font-size:18px;color:yellow;"></span>
       <span style="font-size:18px;color:yellow;">400&nbsp;810&nbsp;9685</span>
       </div>
       <c:set var="userName" value="张三"/> 
       <%
            
       		if(request.getSession().getAttribute("username")!=null){
       			String role = request.getSession().getAttribute("role").toString();
       %>   
    
	       			<span class="glyphicon glyphicon-user" style="color:white;"></span>
	       			<a href="/UserMessageList" style="color:white;font-size:12px;font-family:SimHei;">欢迎<%
	       				if("0".equals(role)){
	       				
	       			%>管理员${sessionScope.username}
	       			<%
	       				}else{%>
	       				
	       					普通用户${sessionScope.username}<%
	       				}
	       				%></a>
	       			<span class="divider-vertical"></span>
	       			<a href="${pageContext.request.contextPath}/logout.jsp"  style="color:yellow;font-size:12px;font-family:SimHei;">退出</a>
	       		</div>
	       </div>
	       <%
       		}
	         else{
	       %>
       		<%-- </c:when>
       		<c:otherwise> --%>
       				<div class="col-md-2" style="margin-left:-50px;">      
	       		<div>
	       			<span class="glyphicon glyphicon-user" style="color:white;"></span>
	       			<a href="${pageContext.request.contextPath}/login.jsp" style="color:white;font-size:12px;font-family:SimHei;">会员登录</a>
	       			<span class="divider-vertical"></span>
	       			<a href="javasctipr:void(0);" onclick="pop()" style="color:yellow;font-size:12px;font-family:SimHei;">注册</a>
	       		</div>
	       </div>
	       <%
	         }
	       %>
       		<%-- </c:otherwise>
       </c:choose>  --%>
      
       </div>
   <div class="row" style="background-color:white;padding-top:25px; height:64px">
		<div class="col-md-1" style="height:2px;"></div>
		<div class="col-md-2">
		  <!-- <img src="images/logo.PNG" style="margin-top:-20px;"/> -->
		  <img src="http://101.200.174.253:9090/images/logo.PNG" style="margin-top:-20px;"/>
		</div>
       <div class="col-md-7" >
      	<div class="navbar-header" id="headbar">
       			<a href="/index">首页</a>
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/SearchList">海外购房</a>
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/ServiceTeam">服务团队</a>
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/ZhiYeInfo">置业指导</a>
       			<!-- <span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/overseas.jsp">海外新闻</a> -->
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/BlogList">新闻博客</a>
       			<span class="divider-vertical" style="margin-left:20px;"></span>
       			<a href="/AboutUs.jsp">关于我们</a>
       		</div>
       </div>  
       <!-- <div class="col-md-1" >	
       	<div>
       	<span class="glyphicon glyphicon-list-alt" style="color:#9C9C9C;"></span>
       		<a href="#"style="font-size:17px;color:#9C9C9C;font-weight:bold;">Blog</a>
       	</div>
       	</div> -->
       <div class="col-md-2"></div>
   </div>
</nav>
<!--end我们的团队-->
</div>
<!--start注册模态框-->
<div class="modal fade" id="modal" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:300px;width:400px;">
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
             注册
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form" action="/UserInfo/Register" method="post">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="nick_name" 
            placeholder="姓名">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="pwd" 
            placeholder="登录密码">
      </div>
      <div class="col-sm-1"></div>
   </div>
    <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="repwd" 
            placeholder="再次输入登录密码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="tel" 
            placeholder="电话号码">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-10 col-sm-offset-1">
         <input type="text" class="form-control" name="email" 
            placeholder="电子邮箱">
      </div>
      <div class="col-sm-1"></div>
   </div>
   <div class="form-group">
      <div class="col-sm-offset-1 col-sm-10">
         <button type="submit" class="btn btn-default">注册</button>
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>
</div>
 </div>
</div>
</div>
<!--end注册模态框-->
</div>
</body>
</html>
