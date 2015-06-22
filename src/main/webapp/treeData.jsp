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
   <script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
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
		            color: '#ffffff', 
		            backColor:'rgb(59,94,132)',
		            //href:'/areaLuru.jsp',            
		            nodes: [
		              {
		                text: '区域信息',
			            href:'#areainfo'	                
		              },
		              {
		                text: '投资数据',
		                href:'#invest'	                
		              },
		              {
			            text: '区域家庭构成'	,
			            href:'#family'                
			          },
		              {
		                text: '区域中位数房价',
		                href:'#midprice' 	                
		              },
		              {
		                text: '区域房价中位数走势',
		                href:'#pricetrend' 	                
		              },
		              {
		                text: '区域租金走势'	,
		                href:'#zujintrend'                 
		              },
		              {
		                text: '区域资金回报率走势',
		                href:'#huibaotrend' 	                
		              },
		              {
		                text: '区域特点',
		                href:'#tedian' 	                
		              },
		              {
		                text: '区域人口分布',
		                href:'#people'                 
		              },
		              {
		                text: '经纪人信息',
		                href:'#broker'	               
		              },
		              {
		                text: '推荐项目',
		                href:'#project'
		              }
		              
		            ]
		          },
		          {
			            text: '经纪人录入',	
			            color: '#ffffff', 
			            backColor:'rgb(59,94,132)',           
			            nodes: [
			              {
			                text: '经纪人信息',
				            href:'#brokerinfo'	                
			              },
			              {
			                text: '擅长类型',
			                href:'#shanchang'	                
			              },
			              {
				            text: '经纪人服务区域'	,
				            href:'#fuwu'                
				          },
			              {
			                text: '经纪人擅长类型',
			                href:'#shanchangtype' 	                
			              }
			              
			            ]
			          }
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
	          enableLinks:true,
	         onNodeSelected: function(event, node) {
	           if(node.text=="项目信息"){
	           $("#showlist").load("ProjectInput.jsp");
	           }
	           if(node.text=="区域录入"){
		           $("#showlist").load("areaLuru.jsp");
		           }
	           if(node.text=="经纪人录入"){
		           $("#showlist").load("brokerLuru.jsp");
		           }
	          } 
	        });
 });
 </script>
</body>
</html>