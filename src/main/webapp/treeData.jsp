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
   <link href="/css/default.css" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="head4index.jsp" />
 <div class="container">
 <div class="row">
 <div class="col-md-3" style="padding-top:25px;">
 <div id="treeview"></div>
 </div>
 <div class="col-md-9" style="padding-left:0px;">
 <div id="showlist"></div>
 </div>
 </div>
 </div>
 <script src="/bootstrap/js/bootstrap-treeview.js"></script>
 <script type="text/javascript">
 $(function() {
 
	        var defaultData = [
	          {
	            text: '项目录入',	 
	            color: "#ffffff", 
	            backColor:"rgb(59,94,132)",          
	            nodes: [
	              {
	                text: '项目信息'	               
	              },
	              {
	                text: '开发商信息'	               
	              },
	              {
	                text: '户型及价格'	               
	              },
	              {
	                text: '项目配套'	               
	              },
	              {
	                text: '附件配套'	               
	              },
	              {
	                text: '附件学校'	               
	              },
	              {
	                text: '持有成本'	               
	              },
	              {
	                text: '购房税费'	               
	              }
	            ]
	          },
	          {
	            text: '区域录入',	
	            color: "#ffffff", 
	            backColor:"rgb(59,94,132)",
	            //href:"/areaLuru.jsp",            
	            nodes: [
	              {
	                text: '区域信息'	                
	              },
	              {
	                text: '投资数据'	                
	              },
	              {
	                text: '区域中位数房价'	                
	              },
	              {
	                text: '区域房价中位数走势'	                
	              },
	              {
	                text: '区域租金走势'	                
	              },
	              {
	                text: '区域资金回报率走势'	                
	              },
	              {
	                text: '区域特点'	                
	              },
	              {
	                text: '区域人口分布'	                
	              },
	              {
	                text: '区域家庭构成'	                
	              },
	              {
	                text: '经纪人信息'	               
	              },
	              {
	                text: '推荐项目'
	              }
	              
	            ]
	          },
	         /*  {
	           text: '管理员',	
	           color: "#ffffff", 
	           backColor:"rgb(59,94,132)",  
	           nodes: [
	              {
	                text: '管理员查看留言'	                
	              },
	             ]
	          } */
	        ];
	        $("#showlist").load("areaLuru.jsp");
	        $('#treeview').treeview({
	          //color: "#428bca",
	          color: "#000000",
	          data: defaultData,
	         onNodeSelected: function(event, node) {
	           if(node.text=="项目信息"){
	           $("#showlist").load("ProjectInput.jsp");
	           }
	           /* if(node.text=="The Elements"){
	           $("#showlist").load("Elements.jsp");
	           }
	           if(node.text=="价格区间"){
	           $("#showlist").load("Price1.jsp");
	           }
	           if(node.text=="户型及价格"){
	           $("#showlist").load("houseTypeList.jsp");
	           }
	           if(node.text=="投资数据"){
	           $("#showlist").load("investDataList.jsp");
	           }
	           if(node.text=="地区特点"){
	           $("#showlist").load("AreaFeature.jsp");
	           }
	           if(node.text=="新闻报道"){
	           $("#showlist").load("NewsInfo.jsp");
	           }
	           if(node.text=="推荐项目"){
	           $("#showlist").load("recommend_item.jsp");
	           }
	           if(node.text=="服务团队"){
	           $("#showlist").load("BrokerInfoList.jsp");
	           }
	           //区域
	           if(node.text=="区域家庭情况构成"){
	           $("#showlist").load("AreaFamily.jsp");
	           }
	           if(node.text=="区域中位数房价走势"){
	           $("#showlist").load("AreaMiddle.jsp");
	           }
	           if(node.text=="区域空置率走势"){
	           $("#showlist").load("AreaZhikong.jsp");
	           }
	           if(node.text=="区域租金走势"){
	           $("#showlist").load("AreaZujin.jsp");
	           }
	           if(node.text=="地区特点"){
	           $("#showlist").load("AreaFeature.jsp");
	           }
	           if(node.text=="人口总数"){
	           $("#showlist").load("PeopleInfo.jsp");
	           }
	            if(node.text=="出生国家"){
	           $("#showlist").load("PeopleNation.jsp");
	           }
	            if(node.text=="海外出生"){
	           $("#showlist").load("PeopleForeign.jsp");
	           }
	            if(node.text=="平均家庭收入"){
	           $("#showlist").load("FamilyIncome.jsp");
	           }
	            if(node.text=="近期区域成交情况"){
	           $("#showlist").load("SuccessInfo.jsp");
	           }
	            if(node.text=="购房税费"){
	           $("#showlist").load("HouseTax.jsp");
	           }
	            if(node.text=="持有成本"){
	           $("#showlist").load("HoldCost.jsp");
	           }
	            if(node.text=="附近学校"){
	           $("#showlist").load("NearSchool.jsp");
	           }
	            if(node.text=="附近配套"){
	           $("#showlist").load("NearFacility.jsp");
	           }
	            if(node.text=="新闻博客"){
	           $("#showlist").load("NewsBoke.jsp");
	           }
	            if(node.text=="置业指导"){
	           $("#showlist").load("ZhiYeZhiDao.jsp");
	           }
	             if(node.text=="管理员查看留言"){
	           $("#showlist").load("Message.jsp");
	           }*/
	          } 
	        });
 });
 </script>
</body>
</html>