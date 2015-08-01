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
   <link href="/css/pagination.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <script src="/js/jquery.pagination.js"></script>
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <link rel="stylesheet" type="text/css" href="/css/list.css" />
   
</head>
<body style="">
<%-- <jsp:include page="head3.jsp" /> --%>
<jsp:include page="head4index.jsp" /> 
 <div class="container" style="width:980px">
		 <div style="width:948px;height:93px;border:1px solid rgb(236,235,235);margin-right:0px;-margin-top:61px">
		 	<div style="padding-left:43px;padding-top:39px;font-family:微软雅黑;font-size:18px;font-weight:bolder">收藏夹</div>
		 </div>
		<!--  <div  style="width:948px;">
		
		 <div > -->
		 <!--start item1-->
		<!--  <table id="Result" cellspacing="0" cellpadding="0" style="width:948px">
		  <tr><th id="ee"> -->
		  <div id="dd" >
		  
		  </div>
		<!--   </th></tr></table> -->
		  <!--end item1-->
		<!--  </div> -->
		 
		<!-- <div > -->
		
		 <div style="margin:0 auto;text-align:center" > 
		        <div id="Pagination" class="pagination"  style="margin-top:5px;"></div>
		 </div>
		
		<!--  </div> -->
		 
		 <!-- </div> -->
</div>
  <jsp:include page="foot4index.jsp" />
   <script src="/js/jquery.pagination.js"></script>
   <script type="text/javascript">
   function aa( proNum){
   	alert(proNum);
   }
         var pageIndex = 0;     //页面索引初始值   
         var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
         var total = 100;
         $(function () {
              total = InitTable(0);    //Load事件，初始化表格数据，页面索引为0（第一页）
                //分页，PageCount是总条目数，这是必选参数，其它参数都是可选
                $("#Pagination").pagination(total,{
                    callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                    prev_text: "« 上一页",
                    next_text: "下一页 »",
                    items_per_page:pageSize,
                    num_edge_entries: 1,       //两侧首尾分页条目数
                    num_display_entries: 5,    //连续分页主体部分分页条目数
                    current_page: pageIndex,   //当前页索引
                });
                //翻页调用   
                function PageCallback(index, jq) {    
                   
                    InitTable(index);  
                }  
                //请求数据   
                function InitTable(pageIndex) { 
                	pageIndex = pageIndex+1;   
                	var count = 0;            
                    $.ajax({   
                        type: "POST",  
                        async: false,
                        dataType: "json",  
                        url: '/ColloectListPage',      //提交到一般处理程序请求数据   
                        data: { pageIndex : pageIndex, pageSize : pageSize},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
                        count = data.total;
                        var html = getHtml(data.List);
                        //alert(html)
                       		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                            $("#dd").html(html);             //将返回的数据追加到表格  
                            
                        }  
                    }); 
                    return count;
                }
               function getHtml(items){
                	
                    
                	
                    var html="";
                  
                    if(items!=null){
                    /* 	int i=0; */
                    	for(var j=0;j<items.length;j++){
                    		var imgUrl = <%=application.getInitParameter("imagedir")%>/+items[j].Project_img; 
                    		//alert(imgUrl)
                    		html+="<div class='c-fix f-r list_node' style='margin-top:15px;margin-bottom:15px'>";
                    		html+="<div class='c-fix f-l list_node_header'>";
                    		html+="<a href='/Index?proNum="+items[j].project_num+"' target='_blank' class='c-fix f-l f-arial s-16 list_node_name fw' style='cursor:pointer;'>"+items[j].Project_name+"</a>";
                    		html+="<a href='/Index?proNum="+items[j].project_num+"' target='_blank' class='f-l f-arial s-12 list_node_address' style='cursor:pointer'>"+items[j].project_address+"</a>";
                    		//html+="<div class='f-r btn_star cp' id='star' onclick=a(\""+items[j].project_num+"\")></div>";
                    		/* if(items[j].isCollected==0)//未收藏 星星显示白色
                    		{
                    		 	html+="<div class='f-r btn_star cp shoucang'  style='margin-right:45px' id='"+items[j].id+"' data-proNum="+items[j].project_num+"></div>";	
                    		 	html+="<span style='margin-right:-72px;float:right;color:white;font-size:13px;font-family:微软雅黑'>收藏</span>";
                    		}
                    		else{
                    			 html+="<div class='f-r btn_star cp btn_star_sel shoucang'  style='margin-right:45px' id='"+items[j].id+"' data-proNum="+items[j].project_num+"></div>";
                    			 html+="<span tyle='margin-right:-72px;float:right;color:rgb(255,226,8);font-size:13px;font-family:微软雅黑'>已收藏</span>";
                    		} */
                    		
                    		    html+="<span style='float:right;color:white;font-size:13px;font-family:微软雅黑;margin-right:15px' onclick=shanchu('"+items[j].project_num+"')>删除</span>";
                    		 	html+="<div class='f-r btn_star  btn_star_sel cp shoucang'  style='margin-right:0px' id='"+items[j].id+"' data-proNum="+items[j].project_num+" onclick=shanchu('"+items[j].project_num+"')></div>";	
                    		html+="</div>";
                    		html+="<div class='c-fix f-l list_node_body'>";
                    		html+="<a href='/Index?proNum="+items[j].project_num+"' target='_blank'>";
                    		html+="<img class='c-fix f-l list_node_img' src='"+imgUrl+"'></img></a>";
                    		html+="<div class='f-l list_node_middle'>";
                    		html+="<a href='/Index?proNum="+items[j].project_num+"' target='_blank' class='c-fix f-l list_node_inner_name f-yahei s-14' style='color:black'  style='font-weight:bolder;cursor:pointer;'>"+items[j].Project_name+"</a>";
                    		html+="<a href='/Index?proNum="+items[j].project_num+"' target='_blank' class='c-fix f-l list_node_desc f-yahei s-13' style='color:black' style='height:60px;overflow-y:hidden;cursor:pointer;'>"+items[j].project_lan_cn+"</a>";
                    		html+="<div class='c-fix f-l list_node_tag_div' style='margin-bottom:20px;margin-top:10px;height:40px'>";
                    		if(items[j].remen==1){
                    			html+="<div style='border:1px solid rgb(254,254,230); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >热门项目</div>";
                    		}
                    		if(items[j].xuequ==1){
                    			html+="<div style='border:1px solid rgb(228,253,224); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >优秀学区</div>";
                    		}
                    		if(items[j].baozu==1){
                    			html+="<div style='border:1px solid rgb(248,235,255); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >包租项目</div>";
                    		}
                    		if(items[j].huaren==1){
                    			html+="<div style='border:1px solid rgb(227,252,223);text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >华人区</div>";
                    		}
                    		if(items[j].maidi==1){
                    			html+="<div style='border:1px solid rgb(251,227,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >最新项目</div>";
                    		}
                    		if(items[j].daxue==1){
                    			html+="<div style='border:1px solid rgb(229,254,225);text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >大学附近</div>";
                    		}
                    		if(items[j].center==1){
                    			html+="<div style='border:1px solid rgb(229,254,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >城市中心</div>";
                    		}
                    		if(items[j].traffic==1){
                    			html+="<div style='border:1px solid rgb(229,254,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >轨道交通</div>";
                    		}
                    		if(items[j].xianfang==1){
                    			html+="<div style='border:1px solid rgb(253,227,227); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >现房项目</div>";
                    		}
                    		if(items[j].xinkaipan==1){
                    			html+="<div style='border:1px solid rgb(253,227,227); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >新开盘</div>";
                    		}
                    		html+="</div>";
                    		//html+="<img class='c-fix f-l list_node_logo' src='res/images/node_img.jpg'></img>";
                    		if(items[j].developer_id_name!=null)
       	       				{
       	       					html+="<span style='font-family:微软雅黑;color:rgb(170,16,25);font-style:italic;font-size:20px;height:50px;float:left;width:320px;'>"+items[j].developer_id_name+"</span>";
       	       				}
                    		html+="</div>";
                    		html+="<div class='f-l list_node_right'>";
                    		html+="<a class='c-fix f-l list_node_inner_lab f-yahei s-12'></a>";
                    		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>最多：</a>";
                    		html+="<a class='f-r list_node_val f-yahei s-12'>"+"<span>$</span>"+items[j].MaxPrice+"</a>"; 
                    		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>最少：</a>";
                    		 html+="<a class='f-r list_node_val f-yahei s-12'>"+"<span>$</span>"+items[j].MinPrice+"</a>"; 
                    		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>面积(M<sup><span style='font-size:8px'>2</span></sup>)：</a>";
                    		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].MinArea+"<span>-</span>"+items[j].MaxArea+"</a>";
                    		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>起价：</a>";
                    		 html+="<a class='f-r list_node_val f-yahei s-12' id='qimoney'>"+"<span>$</span>"+items[j].project_price_int_qi+"</a>"; 
                    		/* html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>返现：</a>";
                    		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].Fanxian+"</a>"; */
                    		html+="</div>";
                    		html+="</div>";
                    		html+="</div>";
                    		
                    	}
                    }
                    else{
                    	html="";
                    }
                    	return html;
                    }
         });
               
            <%--   function getHtml(items){
                var html="";
                if(items!=null){
                	for(var j=0;j<items.length;j++){
                		 html+="<div class='panel panel-default' style='margin-bottom:30px'><div class='panel-heading' style='background-color:rgb(21,63,101);padding-left:45px;padding-right:33px;height:37px;'>";
                 	    // html+="<span><span style='color:white;font-family:微软雅黑;font-size:14px'>"+items[j].Project_name+"</span><span style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px'>"+items[j].project_address+"</span></span><span style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px'><a  style='color:white' href='DelCollect?proNum="+items[j].project_num+"'>删除</a></span><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></div>";
                 	  // html+="<span><span style='color:white;font-family:微软雅黑;font-size:14px'>"+items[j].Project_name+"</span><span style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px'>"+items[j].project_address+"</span></span><span style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px'><a  style='color:white' href='#' data-pronum='"+items[j].project_num+"'>删除</a></span><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></div>";
                 	   //html+="<span><span style='color:white;font-family:微软雅黑;font-size:14px'>"+items[j].Project_name+"</span><span style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px'>"+items[j].project_address+"</span></span><span style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px'><a  style='color:white' href='#' onclick=shanchu('"+items[j].project_num+"')>删除</a><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></span></div>";
                 	   html+="<div ><div style='color:white;font-family:微软雅黑;font-size:14px;float:left;width:155px';>"+items[j].Project_name+"</div><div style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px;float:left;width:610px;margin-left:26px'>"+items[j].project_address+"</div></div><div style='font-family:微软雅黑;font-size:12px;color:white;float:left'><a  style='color:white;margin-right:10px' href='#' onclick=shanchu('"+items[j].project_num+"')>删除</a><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></div></div>";
                 	   // html+="<div style='float:left'><div style='color:white;font-family:微软雅黑;font-size:14px;float:left'>"+items[j].Project_name+"</div><div style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px;float:left'>"+items[j].project_address+"</div></div><div style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px;float:left'><a  style='color:white' onclick='aa("+items[j].project_num+")' href=''>删除</a></div><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></div>";
  						//html+="<span style='float:left'><span style='color:white;font-family:微软雅黑;font-size:14px;float:left'>"+items[j].Project_name+"</span><span style='color:white;font-family:微软雅黑;font-size:12px;margin-left:20px;float:left'>"+items[j].project_address+"</span></span><span style='font-family:微软雅黑;font-size:12px;color:white;margin-left:367px;float:left'><a  style='color:white' onclick='aa("+items[j].project_num+")' href=''>删除</a></span><img src='pic/xing.jpg' style='float:right;margin-top:-9px'/></span>";
  						html+="<div class='panel-body' style='padding-top:5px;padding-bottom:11px;padding-left:13px'><div id='item'><div class='media'><div >";
  						html+="<a class='pull-left' href='/Index?proNum="+items[j].project_num+"'"+" target='_parent'>";
  						html+="<img  style='height:227px;width:366px' src='<%=application.getInitParameter("imagedir")%>/"+items[j].Project_img+"'></a>";
  						html+="<div class=media-body fnt-smaller' style='padding:0 0 0 15px'><div class='col-xs-8' style='margin-top:15px'>";
   	                    html+="<span style='font-family:微软雅黑;font-size:14px;font-weight:bolder'>"+items[j].Project_name+"</span><hr style='margin-top:8px;margin-bottom:8px'/>";
   	       				html+="<span  style='font-family:微软雅黑;font-size:12px'><span>"+items[j].project_lan_cn+"</span>";
   	       				//html+="<div class='row' style='margin-top:20px'><div class='col-md-2' style='padding-left:0px;padding-right:0px;' ><div style ='border:solid 1px rgb(254,254,241);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px'>热门项目</div></div><div class='col-md-1'></div><div class='col-md-2' style='padding-left:0px;padding-right:0px;' ><div  style ='border:solid 1px rgb(247, 254, 246);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px''>优秀学区</div></div><div class='col-md-1'></div><div class='col-md-2' style='padding-left:0px;padding-right:0px;' ><div style ='border:solid 1px rgb(253,249,255);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:3px;padding-right:3px'>包租项目</div ></div><div class='col-md-1'></div><div class='col-md-2' style='padding-left:0px;padding-right:0px;' ><div style ='border:solid 1px rgb(247,254,246);font-family:微软雅黑;font-size:12px;opacity:50%;padding-left:8px;padding-right:8px'>华人区</div></div></div>";
   	       			   html+="<div  style='padding-left:0px;padding-right:0px;margin-top:20px' >";
   	       			if(items[j].remen==1){
            			html+="<div style='border:1px solid rgb(254,254,230); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >热门项目</div>";
            		}
            		if(items[j].xuequ==1){
            			html+="<div style='border:1px solid rgb(228,253,224); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >优秀学区</div>";
            		}
            		if(items[j].baozu==1){
            			html+="<div style='border:1px solid rgb(248,235,255); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >包租项目</div>";
            		}
            		if(items[j].huaren==1){
            			html+="<div style='border:1px solid rgb(227,252,223);text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >华人区</div>";
            		}
            		if(items[j].maidi==1){
            			html+="<div style='border:1px solid rgb(251,227,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >最新项目</div>";
            		}
            		if(items[j].daxue==1){
            			html+="<div style='border:1px solid rgb(229,254,225);text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >大学附近</div>";
            		}
            		if(items[j].center==1){
            			html+="<div style='border:1px solid rgb(229,254,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >城市中心</div>";
            		}
            		if(items[j].traffic==1){
            			html+="<div style='border:1px solid rgb(229,254,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >轨道交通</div>";
            		}
            		if(items[j].xianfang==1){
            			html+="<div style='border:1px solid rgb(253,227,227); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >现房项目</div>";
            		}
            		if(items[j].xinkaipan==1){
            			html+="<div style='border:1px solid rgb(253,227,227); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >新开盘</div>";
            		}
            		html+="</div>";
   	       				//html+="<div class='row' style='margin-top:20px'><img alt='image' class='img-responsive' style='width:121px;height:50px;margin-top:8px' src='<%=application.getInitParameter("imagedir")%>/"+items[j].project_logo+"'></div></div>";
   	       				if(items[j].developer_id_name!=null)
   	       				{
   	       					html+="<div><div  style='margin-top:20px;font-family:微软雅黑;color:rgb(170,16,25);font-style:italic;font-size:20px;'>"+items[j].developer_id_name+"</div></div></div>";
   	       				}
   	       				else{
   	       				html+="<div class='row' style='margin-top:20px'></div></div>";
   	       				}
   	       				html+="<div class='col-xs-4' style='margin-top:20px;padding-top:30px'>";
            		  		html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>最多:</span><span style='float:right;font-family:微软雅黑;font-size:14px'><span>$</span>"+items[j].MaxPrice+"</span><br/>";
            		      	html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>最少:</span><span style='float:right;font-family:微软雅黑;font-size:14px'><span>$</span>"+items[j].MinPrice+"</span><br/>";
            		      	html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>面积(M2):</span><span style='float:right;font-family:微软雅黑;font-size:14px'>"+items[j].MinArea+"<span>-</span>"+items[j].MaxArea+"</span><br/>";
            		      	html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>起价:</span><span style='float:right;font-family:微软雅黑;font-size:14px'>"+items[j].project_price_int_qi+"</span><br/>";
             			   /*  html+="<span style='font-family:微软雅黑;font-weight:bolder;font-size:14px'>返现:</span><span style='float:right;font-family:微软雅黑;font-size:14px'>"+items[j].Fanxian+"</span><br/>"; */
             			    html+="</div></div></div></div></div></div>";
                	}
                }
                else{
                	html="";
                }
                    
                	
                	return html;
                }
            });  --%>

          
            function shanchu(proNum){
             // alert(proNum);
              $.ajax({
					type:'GET',
					url:'/DelCollect?proNum='+proNum,
					dataType:'json',
					async: false, 
			success:function(data){
				if(data.flag==0){
					alert("删除失败");
					
				}
				else if(data.flag==1){
				 alert("删除成功");
				 window.location.reload();
				}
			},
			error:function(){
				
			}
		})
            }
            $(function(){
            	$("#dd .panel .panel-heading span").on('click','a',function(){
            		var proNum=$(this).attr('data-pronum');
            		alert(proNum);
            		 $.ajax({
						type:'GET',
						url:'/DelCollect?proNum='+proNum,
						dataType:'json',
						async: false, 
						success:function(data){
							if(data.flag==0){
								alert("删除失败");
							}
							else if(data.flag==1){
							$(this).parent().parent().parent().remove();
							 alert("删除成功");
							}
						},
						error:function(){
							
						}
					})
            	});
            });
   </script>
   
</body>

</html>