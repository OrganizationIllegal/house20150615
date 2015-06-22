<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>CRUD</title>
     <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
     <link href="/bootstrap/css/bootstrap-table.css" rel="stylesheet">
     <link href="/bootstrap/css/bootstrap-editable.css" rel="stylesheet">
     <link href="/bootstrap/css/examples.css" rel="stylesheet">
     <link href="/css/ProjectInput.css" rel="stylesheet">
     <script src="/js/jquery.min.js"></script>
   <!--   <script src="/bootstrap/js/bootstrap.min.js"></script>
     <script src="/bootstrap/js/bootstrap-table.js"></script>
     <script src="/bootstrap/js/bootstrap-editable.js"></script>
     <script src="/bootstrap/js/bootstrap-table-export.js"></script>
     <script src="/bootstrap/js/bootstrap-table-editable.js"></script>
     <script src="/bootstrap/js/tableExport.js"></script>
     <script src="/bootstrap/js/jquery.base64.js"></script> -->
</head>
  
 <body style="width:900px;margin:0 auto">
 	<div  style="float:left;-background-color:black;width:900px">
 		<div id="current" class="current"><span >当前位置：项目录入 </span>
 		</div>
 		<div id="title" class="title" ><span >项目信息 </span>
 		</div>
 		<div id="xiangmu" class="xiangmu">
 			<div id="zuo" class="zuo" ><span class="name">项目编号</span><input type="text" class="shurukuang"/></div>
 			<div id="you" class="you"><span class="name">项目名称</span><input type="text" class="shurukuang"/></div>
 			<div id="zuo1" class="zuo" ><span class="name">项目编号</span><input type="text" class="shurukuang"/></div>
 			<div id="you1" class="you"><span class="name">项目名称</span><input type="text" class="shurukuang"/></div>
 		</div>
 	</div>
		
 </body>
</html>