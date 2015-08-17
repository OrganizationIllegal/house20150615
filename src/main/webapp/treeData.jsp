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
   <script src="/js/jquery-2.1.4.js"></script>
   <script src="/bootstrap/js/bootstrap.js"></script>
   <script src="/ckeditor/ckeditor.js"></script>
   <!-- <script src="/bootstrap/js/bootstrap-table.js"></script> -->


</head>
<body>
<%
            String username = null;
			String role = null;
       		if(request.getSession().getAttribute("username")==null){
       			out.print("<script>alert('用户请登录。');window.location.href='/index'</script>");
}else{
	
	if(request.getSession().getAttribute("role")!=null){
		role = request.getSession().getAttribute("role").toString();
	}
	if("1".equals(role)){
		out.print("<script>alert('您没有权限。');window.location.href='/index'</script>");
	}
}
       		
       		String flag = null;
       		if(request.getSession().getAttribute("flag")!=null){
       			flag = request.getSession().getAttribute("flag").toString();
       		}
       		
  
       		
%>
<input type="hidden" id="top"/>
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
 var item = <%=flag%>;
 $(function() {
 
	        var defaultData = [
	          {
	            text: '项目录入',	 
	            color: "#ffffff", 
	            backColor:"rgb(59,94,132)",          
	            nodes: [
	              {
	                text: '项目信息',
	                href:'#projectinfo'
	              },
	              {
	                text: '开发商信息',	
	                href:'#developerinfo'
	              },
	              {
	                text: '户型及价格',
	                href:'#housetypeinfo'
	              },
	              {
	                text: '项目配套',
	                href:'#projectpeitao'
	              },
	              {
	                text: '附近配套',
	                href:'#nearpeitao'
	              },
	              {
	                text: '附件学校',
	                href:'#nearschool'
	              },
	              {
	                text: '持有成本',
	                href:'#holdcost'
	              },
	              {
	                text: '购房税费',
	                href:'#housetax'
	              }
	            ]
	          },
	          {
		            text: '项目列表',	
		            color: '#ffffff', 
		            backColor:'rgb(59,94,132)',      
		            href:'#title',       
		            nodes: [
		              {
		                text: '项目列表',
			            href:'#title'	                
		              },
		              
		            ]
		          },
	          {
		            text: '区域录入',	
		            color: '#ffffff', 
		            backColor:'rgb(59,94,132)',
		            href:'#title',            
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
			            text: '区域列表',	
			            color: '#ffffff', 
			            backColor:'rgb(59,94,132)',   
			            href:'#title',          
			            nodes: [
			              {
			                text: '区域列表',
				            href:'#title'	                
			              },
			              
			            ]
			          },
		          {
			            text: '经纪人录入',	
			            color: '#ffffff', 
			            backColor:'rgb(59,94,132)',   
			            href:'#title',          
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
			          },
			          {
				            text: '经纪人列表',	
				            color: '#ffffff', 
				            backColor:'rgb(59,94,132)', 
				            href:'#title',            
				            nodes: [
				              {
				                text: '经纪人列表',
					            href:'#title'	                
				              },
				              
				            ]
				          },
			          {
				            text: '新闻博客录入',	
				            color: '#ffffff', 
				            backColor:'rgb(59,94,132)', 
				            href:'#title',            
				            nodes: [
				              {
				                text: '新闻博客',
					            href:'#title'	                
				              },
				              
				            ]
				          },
				          {
					            text: '新闻博客列表',	
					            color: '#ffffff', 
					            backColor:'rgb(59,94,132)', 
					            href:'#title',            
					            nodes: [
					              {
					                text: '新闻博客列表',
						            href:'#title'	                
					              },
					              
					            ]
					          },
				          {
					            text: '置业指导录入',	
					            color: '#ffffff', 
					            backColor:'rgb(59,94,132)', 
					            href:'#title',            
					            nodes: [
					              {
					                text: '置业指导',
						            href:'#title'	                
					              },
					              
					            ]
					          },
					          {
						            text: '置业指导列表',	
						            color: '#ffffff', 
						            backColor:'rgb(59,94,132)', 
						            href:'#title',            
						            nodes: [
						              {
						                text: '置业指导列表',
							            href:'#title'	                
						              },
						              
						            ]
						          },
			          {
				            text: '学校信息录入',	
				            color: '#ffffff', 
				            backColor:'rgb(59,94,132)', 
				            href:'#title',            
				            nodes: [
				              {
				                text: '学校信息录入',
					            href:'#title'	                
				              },
				              
				            ]
				          },
				          {
					            text: '学校信息列表',	
					            color: '#ffffff', 
					            backColor:'rgb(59,94,132)', 
					            href:'#title',            
					            nodes: [
					              {
					                text: '学校信息列表',
						            href:'#title'	                
					              },
					              
					            ]
					          },
				          {
					            text: '开发商信息录入',	
					            color: '#ffffff', 
					            backColor:'rgb(59,94,132)',  
					            href:'#title',           
					            nodes: [
					              {
					                text: '开发商信息录入',
						            href:'#title'	                
					              },
					              
					            ]
					          },
					          {
						            text: '开发商信息列表',	
						            color: '#ffffff', 
						            backColor:'rgb(59,94,132)',  
						            href:'#title',           
						            nodes: [
						              {
						                text: '开发商信息列表',
							            href:'#title'	                
						              },
						              
						            ]
						          },
						          {
							            text: '用户列表',	
							            color: '#ffffff', 
							            backColor:'rgb(59,94,132)',   
							            href:'#title',          
							            nodes: [
							              {
							                text: '用户列表',
								            href:'#title'	                
							              },
							              
							            ]
							          },
						          {
							            text: '地图中心点录入',	
							            color: '#ffffff', 
							            backColor:'rgb(59,94,132)',   
							            href:'#title',          
							            nodes: [
							              {
							                text: '地图中心点录入',
								            href:'#title'	                
							              },
							              
							            ]
							          },
							          {
								            text: '地图中心点列表',	
								            color: '#ffffff', 
								            backColor:'rgb(59,94,132)',   
								            href:'#title',          
								            nodes: [

										              {
										                text: '地图中心点列表',
											            href:'#title'	                
										              },
							                  ]
							          },
							          {
								            text: '项目页广告管理',	
								            color: '#ffffff', 
								            backColor:'rgb(59,94,132)',   
								            href:'#title',          
								            nodes: [

										              {
										                text: '项目页广告管理',
											            href:'#title'	                
										              },
							                  ]
							          },
							          {
								            text: '首页项目推荐管理',	
								            color: '#ffffff', 
								            backColor:'rgb(59,94,132)',   
								            href:'#title',          
								            nodes: [

										              {
										                text: '首页项目推荐管理',
											            href:'#title'	                
										              },
							                  ]
							          },

								          {
									            text: '留言列表',	
									            color: '#ffffff', 
									            backColor:'rgb(59,94,132)',   
									            href:'#title',          
									            nodes: [
									              
									            	  {
											                text: '索取完整价格单留言列表',
												            href:'#message1'	                
											              },
											              {
											                text: '需求留言',
											                href:'#message2'	                
											              },
											              {
												            text: '项目详情咨询留言'	,
												            href:'#message3'                
												          },
											              {
											                text: '最新价格留言',
											                href:'#message4' 	                
											              },
											              {
												                text: '完整户型留言',
												                href:'#message5' 	                
												              },
												              {
													                text: '合适房产经纪人留言',
													                href:'#message6' 	                
													              },
													              {
														                text: '合作伙伴留言',
														                href:'#message7' 	                
														              }

									            ]
									          },
									          {
										            text: '联动国家录入',	
										            color: '#ffffff', 
										            backColor:'rgb(59,94,132)',   
										            href:'#title',          
										            nodes: [

												              {
												                text: '联动国家录入',
													            href:'#title'	                
												              },
									                  ]
									          },
									          {
										            text: '联动国家列表',	
										            color: '#ffffff', 
										            backColor:'rgb(59,94,132)',   
										            href:'#title',          
										            nodes: [

												              {
												                text: '联动国家列表',
													            href:'#title'	                
												              },
									                  ]
									          },
									          {
										            text: '联动城市录入',	
										            color: '#ffffff', 
										            backColor:'rgb(59,94,132)',   
										            href:'#title',          
										            nodes: [

												              {
												                text: '联动城市录入',
													            href:'#title'	                
												              },
									                  ]
									          },
									          {
										            text: '联动城市列表',	
										            color: '#ffffff', 
										            backColor:'rgb(59,94,132)',   
										            href:'#title',          
										            nodes: [

												              {
												                text: '联动城市列表',
													            href:'#title'	                
												              },
									                  ]
									          },
									          {
										            text: '联动区域录入',	
										            color: '#ffffff', 
										            backColor:'rgb(59,94,132)',   
										            href:'#title',          
										            nodes: [

												              {
												                text: '联动区域录入',
													            href:'#title'	                
												              },
									                  ]
									          },
									          {
										            text: '联动区域列表',	
										            color: '#ffffff', 
										            backColor:'rgb(59,94,132)',   
										            href:'#title',          
										            nodes: [

												              {
												                text: '联动区域列表',
													            href:'#title'	                
												              },
									                  ]
									          }
							        ]

	      /*   $("#showlist").load("areaLuru.jsp"); */
	        $("#showlist").load("/ProjectInput");
	        $('#treeview').treeview({
	          //color: "#428bca",
	          levels: 1,
	          color: "#000000",
	          data: defaultData,
	          enableLinks:true,
	          onNodeSelected: function(event, node) {
	           if(node.text=="项目录入"){
	           		$("#showlist").load("/ProjectInput");
	           }
	           else if(node.text=="区域录入"){
		           /* $("#showlist").load("areaLuru.jsp"); */
		           $("#showlist").load("/AreaInput");
		           
		           }
	           else if(node.text=="经纪人录入"){
		           $("#showlist").load("brokerLuru.jsp");
		           }
	           else if(node.text=="经纪人列表"){
		           $("#showlist").load("brokerList.jsp");
		           }
	           else if(node.text=="新闻博客录入"){
		           $("#showlist").load("/NewsInput");
		           }
	           else if(node.text=="新闻博客列表"){
		           $("#showlist").load("newsList.jsp");
		           }
	           else if(node.text=="置业指导录入"){
		           $("#showlist").load("zhiyeLuru.jsp");
		           }
	           else if(node.text=="置业指导列表"){
		           $("#showlist").load("zhiyeList.jsp");
		           }
	           else if(node.text=="学校信息录入"){
		           $("#showlist").load("SchoolInfoInput.jsp");
		           }
	           else if(node.text=="学校信息列表"){
		           $("#showlist").load("SchoolList.jsp");
		           }
	           else if(node.text=="开发商信息录入"){
		           $("#showlist").load("DeveloperInfoInput.jsp");
		           }
	           else if(node.text=="开发商信息列表"){
		           $("#showlist").load("DeveloperList.jsp");
		           }
	           else if(node.text=="项目列表"){
		           $("#showlist").load("ProjectList.jsp");
		           }
	           else if(node.text=="区域列表"){
		           $("#showlist").load("areaList.jsp");
		           }
	           else if(node.text=="区域列表"){
		           $("#showlist").load("areaList.jsp");
		       }
	           else if(node.text=="项目页广告管理"){
	        	   window.open("/adEdit","项目页广告管理");
		       }
	           else if(node.text=="首页项目推荐管理"){
	        	   window.open("/IndexRecoEdit","首页项目推荐管理");
		       }
	           else if(node.text=="用户列表"){
	        	   if(item==2){
	        		   //$("#showlist").load("userList.jsp");
	        		   window.open("userList.jsp","用户列表");
	        	   }
	        	   else{
	        		   alert("您没有权限查看用户列表！");
	        	   }
	        	   
		           
		        }
	         
	           else if(node.text=="地图中心点录入"){
		           $("#showlist").load("/MapCenterInput");
		       }
	           else if(node.text=="地图中心点列表"){
		           $("#showlist").load("/GpsCenterList.jsp");
	           }
	           else if(node.text=="索取完整价格单留言列表"){
			        /*    $("#showlist").load("MessageForPrice.jsp"); */
		        	   window.open("MessageForPrice.jsp","索取完整价格单留言列表");
		           }
	           else if(node.text=="需求留言"){
		          /*  $("#showlist").load("Message.jsp"); */
	        	   window.open("Message.jsp","需求留言");
		       }
	           else if(node.text=="项目详情咨询留言"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("MessageForInfo.jsp","项目详情留言");
			       }
	           else if(node.text=="最新价格留言"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("MessageForLatestPrice.jsp","最新价格留言");
			       }
	           else if(node.text=="完整户型留言"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("MessageForHuxing.jsp","完整户型留言");
			       }
	           else if(node.text=="合适房产经纪人留言"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("MessageForBroker.jsp","合适房产经纪人留言");
			       }
	           else if(node.text=="合作伙伴留言"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("MessageForHeZuo.jsp","合作伙伴留言");
			       }
	           else if(node.text=="联动国家录入"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("AddNation.jsp","联动国家录入");
			       }
	           else if(node.text=="联动国家列表"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("NationList.jsp","联动国家列表");
			       }
	           else if(node.text=="联动城市录入"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("/CityAdd","联动城市录入");
			       }
	           else if(node.text=="联动城市列表"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("CityList.jsp","联动城市列表");
			       }
	           else if(node.text=="联动区域录入"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("/LiandongAreaAdd","联动区域录入");
			       }
	           else if(node.text=="联动区域列表"){
			          /*  $("#showlist").load("Message.jsp"); */
		        	   window.open("LiandongAreaList.jsp","联动区域列表");
			       }
	          } 
	        });
 });
 </script>
 
</body>
</html>