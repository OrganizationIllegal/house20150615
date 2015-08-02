<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<head> 
		<title>HouseSale</title> 
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/list.css" />
		<!-- <script type="text/javascript" src="/js/jquery.js"></script>  -->
		<script type="text/javascript" src="/js/jquery-1.11.2.js"></script> 
		<!-- <script type="text/javascript" src="/js/list.js"></script> -->
		  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
  		 <link href="/css/pagination.css" rel="stylesheet">
   	 	<script src="/bootstrap/js/bootstrap.min.js"></script>
   	<!-- 	<script src="js/jquery.pagination.js"></script> -->
   <script type="text/javascript" src="/ion.rangeSlider-2.0.10/js/ion-rangeSlider/ion.rangeSlider.min.js"></script> 
    <link href="/ion.rangeSlider-2.0.10/css/normalize.css" rel="stylesheet">
     <link href="/ion.rangeSlider-2.0.10/css/ion.rangeSlider.css" rel="stylesheet">
      <link href="/ion.rangeSlider-2.0.10/css/ion.rangeSlider.css" rel="stylesheet">
       <link href="/ion.rangeSlider-2.0.10/css/ion.rangeSlider.skinNice.css" rel="stylesheet">
        <script src="/js/jquery.bootpag.min.js"></script>
     
   
   		<style>
   		.irs .js-irs-0{
   			margin-top:20px;
   		}
   			a{
   				color:black;
   			}
   			.pagination span {
   				min-width:3em;
   				max-width:3em;
   				height:40px;
   				padding:0 0;
   				margin-right:0px;
   			}
   			.pagination a {
   				min-width:3em;
   				max-width:3em;
   				height:40px;
   				padding:0 0;
   				margin-right:0px;
   			}
   			.pagination .current{
   				background:rgb(67,67,67);
   			}
   			.pagination .prev{
   				//font-size:20px;
   			}
   			.btn_star_sel{
   				background-color:yellow;
   			}
   			.shoucang{
   			
   			}
   		</style>
   	
	</head>
	<body>
<%-- <jsp:include page="head4.jsp" /> --%>
   <jsp:include page="head4index.jsp" />
		<div class="c-fix  list_bkg">
			<div class="c-fix f-l list_left">
			<form role="form"  method="get" id="filter">
				<a class="c-fix f-l f-yahei s-14 btn cp hover" style="padding:4px 6px;border:2px solid rgb(245,161,27)" href="/BingMap">地图找房</a>
				<a class="f-l f-yahei s-14 btn cp btn_sel hover" style="margin-left:1px;padding:4px 6px;" href="/searchList.jsp">列表找房</a>
				<!-- <div class="c-fix f-l" style="color:#617c97;font-size:16px;font-weight:bold;margin-bottom:10px;margin-top:45px;font-family:微软雅黑;">进一步搜索</div> -->
				<span class="c-fix f-l f-yahei s-14" style="color:#333;margin-top:60px;">类型</span>
				<select style="width:100%;height:30px;line-height:30px;margin-top:3px;font-family:微软雅黑" id="projecttype" name="projecttype">
					<option value="0">请选择</option>
					<option value="1">公寓</option>
					<option value="2">别墅</option>
					<option value="3">联排别墅</option>
				</select>
				<div class="c-fix f-l f-yahei s-14" style="display:block;width:100%;min-height:20px;margin-top:20px;">
					<div style="margin-bottom:20px"><span style="display:block;color:#333;font-size:14px;float:left;">总价</span></div>
					<!-- <a style="display:block;color:#ff6600;font-size:14px;float:right">100k-2M+</a> -->
					<!-- <input type="range" name="zongjia" id="zongjia" class="c-fix f-l" style="display:block;width:100%;margin-top:5px;margin-left:0px;" min="100000" max="2000000"></input> -->
					<input type="text" id="zongjia" name="zongjia" value="0;5000000" style="margin-top:20px"/>
				</div> 
				<div class="c-fix f-l f-yahei s-14" style="display:block;width:100%;min-height:20px;margin-top:20px;">
					<div style="margin-bottom:20px"><span style="display:block;color:#333;font-size:14px;float:left;">单价</span></div>
					<!-- <a style="display:block;color:#ff6600;font-size:14px;float:right">0k-20,000+</a> -->
					<!-- <input type="range" name="danjia" id="danjia" class="c-fix f-l" style="display:block;width:100%;margin-top:5px;margin-left:0px;" min="0" max="2000"></input> -->
					<input type="text" id="danjia" name="danjia" value="0;200000" style="margin-top:20px"/>
				</div> 
				<div class="c-fix f-l f-yahei s-14" style="display:block;width:100%;min-height:20px;margin-top:20px;">
					<!-- <a style="display:block;color:#333;font-size:14px;float:left;">卧室</a>
					<a style="display:block;color:#ff6600;font-size:14px;float:right">0k-4+</a> -->
					<div style="margin-bottom:20px"><span style="display:block;color:#333;font-size:14px;float:left;">卧室</span></div>
					<!-- <input type="range" name="woshi" class="c-fix f-l" style="display:block;width:100%;margin-top:5px;margin-left:0px;" min="0" max="4"></input> -->
					<input type="text" id="woshi" name="woshi" value="0;6" style="margin-top:20px"/>
				</div> 
				<div style="display:block;width:100%;min-height:20px;margin-top:10px;float:left;clear:both">
					<span style="display:block;color:#333;font-size:14px;float:left;">用途</span>
					<div style="display:block;width:100%;height:1px;background-color:#666;clear:both;float:left;margin-top:3px;margin-bottom:3px"></div>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="xinaipan"  />
					<span style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">新开盘</span>
					<input style="display:block;float:left;height:30px" type="checkbox" name="key" id="remen" />
					<span style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">热门项目</span>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="youxiu"/>
					<span style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">优秀学区</span>
					<input style="display:block;float:left;height:30px" type="checkbox" name="key" id="center" />
					<span style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;" >城市中心</span>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="baozu" />
					<span style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">包租项目</span>
					<input style="display:block;float:left;height:30px" type="checkbox" name="key" id="huaren"/>
					<span style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">华人区</span>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="zuixin" />
					<span style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">最新项目</span>
					<input style="display:block;float:left;height:30px" type="checkbox" name="key" id="daxue" />
					<span style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">大学附近</span>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="xianfang"  />
					<span style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">现房项目</span>
					<input style="display:block;float:left;height:30px" type="checkbox" name="key" id="traffic" />
					<span style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">轨道交通</span>

					<!--<a class="c-fix f-r btn_search f-yahei s-14 cp">搜索</a>-->
					<input type="submit" class="c-fix f-r btn_search f-yahei s-14 cp" value="搜索"/>
				</div> 
			</form>
			</div>
			<div class="f-r list_right">
				<div class="c-fix f-l nav_panel" id="page" style="-margin-bottom:35px;height:80px;">
				    <div id="Pagination" class="pagination"  style="margin:0 0;height:87px;"></div>
				   <!--  <div id="page-selection"></div> -->
					 <div style="float:right;margin-top:22px">
					<select class="f-l sel_order" style="background-color:#eae8e8;padding-left:5px;-margin-top:-40px;" onchange="paixu(this)">
						<option value="0">排序</option>
						<option value="1">推荐度</option>
						<!-- <option value="2">热门度</option> -->
					</select></div> 
					
				</div>
				<div id="list">
			 <c:forEach var="item" items="${searchList}"> 		 
	<div class="c-fix f-r list_node" style="margin-top:15px;margin-bottom:15px">
                		<div class="c-fix f-l list_node_header">
                		<a href="/Index?proNum=${item.project_num}" class="c-fix f-l f-arial s-16 list_node_name fw" style="cursor:pointer;">${item.project_name}</a>
                		<a href="/Index?proNum=${item.project_num}" class="f-l f-arial s-12 list_node_address" style="cursor:pointer;">${item.project_address}</a>
                		<div class="f-r btn_star cp"  id="star" data-proNum=${item.project_num}></div>
                		<span style="margin-right:-58px;float:right;color:white;font-size:13px;font-family:微软雅黑">收藏</span>
                		</div>
                		<div class="c-fix f-l list_node_body">
                		<a href="/Index?proNum=${item.project_num}"><img class="c-fix f-l list_node_img" src="<%=application.getInitParameter("imagedir")%>/${item.project_img}"></img></a>
                		<div class="f-l list_node_middle">
                		<a href="/Index?proNum=${items[j].project_num}" class="c-fix f-l list_node_inner_name f-yahei s-14"  style="font-weight:bolder;cursor:pointer;">${item.project_name}</a>
                		<a href="/Index?proNum=${items[j].project_num}" class="c-fix f-l list_node_desc f-yahei s-13;"  style="height:60px;overflow-y:hidden;cursor:pointer;">${item.project_lan_cn}</a>
                		<div class="c-fix f-l list_node_tag_div" style="margin-bottom:10px;margin-top:10px;height:40px;">
						<div style="border:1px solid rgb(254,254,230); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;"  >热门项目</div>
                		
                		</div>
                	
                	
   	       				<span style="margin-top:20px;font-family:微软雅黑;color:rgb(170,16,25);font-style:italic;font-size:20px;float:left;height: 30px;width:320px;">${item.developer_id_name}</span>
   	       				
                		</div>
                		<div class="f-l list_node_right">
                		<span class="c-fix f-l list_node_inner_lab f-yahei s-12"></span>
                		<span class="f-l list_node_title fw f-yahei s-12 c-fix">最多：</span>
                		<!-- <a class="f-r list_node_val f-yahei s-12">$${item.maxPrice}</a> -->
                		 <span class="f-r list_node_val f-yahei s-12">$<f:formatNumber value="${item.maxPrice}" pattern="#,#00.#"/></span>
                		<span class="f-l list_node_title fw f-yahei s-12 c-fix">最少：</span>
                		<!-- <a class="f-r list_node_val f-yahei s-12">$${item.minPrice}</a> -->
                		 <span class="f-r list_node_val f-yahei s-12">$<f:formatNumber value="${item.minPrice}" pattern="#,#00.#"/></span>
                		<span class="f-l list_node_title fw f-yahei s-12 c-fix">面积：</span>
                		<span class="f-r list_node_val f-yahei s-12">${item.minArea}<span>-</span>${items.maxArea}</span>
                		<span class="f-l list_node_title fw f-yahei s-12 c-fix">起价：</span>
                		<span class="f-r list_node_val f-yahei s-12"><span>$</span><f:formatNumber value="${items.project_price_int_qi}"  pattern="#,#00.#"/></span>
                		<%-- <a class="f-l list_node_title fw f-yahei s-12 c-fix">返现：</a>
						<a class="f-r list_node_val f-yahei s-12">${item.fanxian}</a> --%>
                		</div>
                		</div>
                		</div>
                	</c:forEach> 
				</div>
				
				
		</div>
		
	</div>
		<jsp:include page="foot4index.jsp" />
	<script src="/js/jquery.pagination.js"></script> 
   <script type="text/javascript">
   /*  var qimoney=$("#qimoney").val();
     alert(qimoney); */
     /*  var value=$.formatNumber(qimoney,{format:"#,###", locale:"cn"});
         $("#qimoney").val(qimoney); */
        
     	$("#zongjia").ionRangeSlider({
   			 type: "double",
   			 min: 0,
    		 max: 5000000,
    		 step: 100000
   			 //grid: true
		});
			$("#danjia").ionRangeSlider({
   			 type: "double",
   			 min: 0,
    		max: 20000,
    		step: 500
   			 //grid: true
		});
		$("#woshi").ionRangeSlider({
   			 type: "double",
   			 min: 0,
    		 max: 6,
    		 step: 1
   			 //grid: true
		});
        var pageIndex = 0;     //页面索引初始值   
        var pageSize = 10;     //每页显示条数初始化，修改显示条数，修改这里即可  
         $(function () {
         		//alert("ttttttttttt");
              	var total = InitTable(0);    //Load事件，初始化表格数据，页面索引为0（第一页）
             
                //分页，PageCount是总条目数，这是必选参数，其它参数都是可选
                $("#Pagination").pagination(total,{
                    callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                    prev_text: "«",
                    next_text: "»",
                    items_per_page:pageSize,
                    num_edge_entries: 1,       //两侧首尾分页条目数
                    num_display_entries: 10,    //连续分页主体部分分页条目数
                    current_page: pageIndex,   //当前页索引
                });
                //翻页调用   
                function PageCallback(index, jq) {   
                	 //alert(index+"ffff");
                    InitTable(index);  
                }  
                //请求数据   
                function InitTable(pageIndex,i) { 
                	pageIndex = pageIndex+1;   
                	var count = 0;            
                    $.ajax({   
                        type: "POST",  
                        async: false,
                        dataType: "json",  
                        url: '/SearchListPage',      //提交到一般处理程序请求数据   
                        data: { pageIndex : pageIndex, pageSize : 10},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
                        count = data.total;
                        var html = getHtml(data.List);
                        //alert(html)
                       		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                            $("#list").html(html);             //将返回的数据追加到表格  
                            
                        }  
                    }); 
                    return count;
                }
           }); 
       $("#filter").submit(function(e){
 						 var projecttype=$("#projecttype").val();
 						 
 						var zongjia=$("#zongjia").val();
 						 var danjia=$("#danjia").val();
 						 var woshi=$("#woshi").val();
 						/*  alert(woshi); */
 						 var keylist=document.getElementsByName('key');
 						 for(var i=0;i<keylist.length;i++){
 						 	if(keylist[i].checked==true){
 						 		keylist[i].value=1;
 						 	}else{
 						 		keylist[i].value=0;
 						 	}
 						 }
 						 var xinaipan=$("#xinaipan").val();
 						 var remen=$("#remen").val();
 						 var youxiu=$("#youxiu").val();
 						 var center=$("#center").val();
 						 var baozu=$("#baozu").val();
 						 var huaren=$("#huaren").val();
 						 var zuixin=$("#zuixin").val();
 						 var daxue=$("#daxue").val();
 						 var xianfang=$("#xianfang").val();
						 var traffic=$("#traffic").val();
					
 		 							  var pageIndex2 = 0;     //页面索引初始值   
							          var pageSize2 = 10;     //每页显示条数初始化，修改显示条数，修改这里即可  
							         // var total2 = 100;
							         var total2 = InitTable2(0); 
							        
		   			 	$("#Pagination").pagination(total2,{
                   						 callback: PageCallback2, 
                   						 prev_text: "«",
                   						 next_text: "»",
                   						 items_per_page:pageSize2,
                    					 num_edge_entries: 1,       //两侧首尾分页条目数
                   						 num_display_entries: 10,    //连续分页主体部分分页条目数
                    					 current_page: pageIndex2,   //当前页索引
               				 }); 
               				   function PageCallback2(index, jq) {    
                   				   
                   					 InitTable2(index);  
                				}   
                				return false;
		   						  function InitTable2(pageIndex2) { 
		   							
						                	pageIndex2 = pageIndex2+1;   
						                	var count = 0;   
						                    $.ajax({   
						                        type: "POST",  
						                        async: false,
						                        dataType: "json",  
						                        url: '/FilterList?projecttype='+projecttype+'&zongjia='+zongjia+"&danjia="+danjia+'&xinaipan='+xinaipan+'&remen='+remen+'&youxiu='+youxiu+'&center='+center+'&baozu='+baozu+'&huaren='+huaren+'&zuixin='+zuixin+'&daxue='+daxue+'&xianfang='+xianfang+'&traffic='+traffic+'&woshi='+woshi,      //提交到一般处理程序请求数据   
						                        data: { pageIndex : pageIndex2, pageSize : 10},
						                        success: function(data) {
						                        count = data.total;
						                        var html = getHtml(data.List);
						                       		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
						                       		//$("#list").html(""); 
						                            $("#list").html(html);             //将返回的数据追加到表格  
						                            
						                        }  
						                    }); 
						                    return count;
						                }

		  
		});

    function paixu(v){
		   							  var pageIndex3 = 0;     //页面索引初始值   
							          var pageSize = 10;     //每页显示条数初始化，修改显示条数，修改这里即可  
							         var total3 = InitTable3(0); 
		   					$("#Pagination").pagination(total3,{
                   						 callback: PageCallback3,  //PageCallback() 为翻页调用次函数。
                   						 prev_text: "«",
                   						 next_text: "»",
                   						 items_per_page:pageSize,
                    					num_edge_entries: 1,       //两侧首尾分页条目数
                   						 num_display_entries: 10,    //连续分页主体部分分页条目数
                    					current_page: pageIndex3,   //当前页索引
               				 });
               				   function PageCallback3(index, jq) {    
                   				   
                   					 InitTable3(index);  
                				}  
		   						  function InitTable3(pageIndex3) { 
						                	pageIndex3 = pageIndex3+1;   
						                	var count = 0; 
						                	      
						                    $.ajax({   
						                        type: "POST",  
						                        async: false,
						                        dataType: "json",  
						                        url: '/OrderPage',      //提交到一般处理程序请求数据   
						                        data: { pageIndex : pageIndex3, pageSize : 10},
						                        success: function(data) {
						                        count = data.total;
						                        var html = getHtml(data.List);
						                       		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
						                            $("#list").html(html);             //将返回的数据追加到表格  
						                            
						                        }  
						                    }); 
						                    return count;
						                }
			
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
                		 if(items[j].isCollected==0)//未收藏 星星显示白色
                		{
                		    html+="<span style='float:right;color:white;font-size:13px;font-family:微软雅黑;margin-right:15px'>收藏</span>";
                		 	html+="<div class='f-r btn_star cp shoucang'  style='margin-right:0px' id='"+items[j].id+"' data-proNum="+items[j].project_num+"></div>";	
                		 	
                		}
                		else{
                			 html+="<span style='float:right;color:rgb(255,226,8);font-size:13px;font-family:微软雅黑;margin-right:15px'>已收藏</span>";
                			 html+="<div class='f-r btn_star cp btn_star_sel shoucang'  style='margin-right:0px' id='"+items[j].id+"' data-proNum="+items[j].project_num+"></div>";
                			
                		}
                	   
                		html+="</div>";
                		html+="<div class='c-fix f-l list_node_body'>";
                		html+="<a href='/Index?proNum="+items[j].project_num+"' target='_blank'>";
                		html+="<img class='c-fix f-l list_node_img' src='"+imgUrl+"'></img></a>";
                		html+="<div class='f-l list_node_middle'>";
                		html+="<a href='/Index?proNum="+items[j].project_num+"' target='_blank' class='c-fix f-l list_node_inner_name f-yahei s-14'  style='font-weight:bolder;cursor:pointer;'>"+items[j].Project_name+"</a>";
                		html+="<a href='/Index?proNum="+items[j].project_num+"' target='_blank' class='c-fix f-l list_node_desc f-yahei s-13' style='height:60px;overflow-y:hidden;cursor:pointer;'>"+items[j].project_lan_cn+"</a>";
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
                		html+="<span class='c-fix f-l list_node_inner_lab f-yahei s-12'></span>";
                		html+="<span class='f-l list_node_title fw f-yahei s-12 c-fix'>最多：</span>";
                		html+="<span class='f-r list_node_val f-yahei s-12'>"+"<span>$</span>"+items[j].MaxPrice+"</span>"; 
                		html+="<span class='f-l list_node_title fw f-yahei s-12 c-fix'>最少：</span>";
                		 html+="<span class='f-r list_node_val f-yahei s-12'>"+"<span>$</span>"+items[j].MinPrice+"</span>"; 
                		html+="<span class='f-l list_node_title fw f-yahei s-12 c-fix'>面积(M<sup><span style='font-size:8px'>2</span></sup>)：</span>";
                		html+="<span class='f-r list_node_val f-yahei s-12'>"+items[j].MinArea+"<span>-</span>"+items[j].MaxArea+"</span>";
                		html+="<span class='f-l list_node_title fw f-yahei s-12 c-fix'>起价：</span>";
                		 html+="<span class='f-r list_node_val f-yahei s-12' id='qimoney'>"+"<span>$</span>"+items[j].project_price_int_qi+"</span>"; 
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
   </script>
   <script>
   
   $(function(){
	$(".btn").click(function(){
		$(".btn_sel").removeClass("btn_sel");
		$(this).addClass("btn_sel");
	});
	
	//$(".pagination").not(".current").not(".next").click(function(){
	//	$(".list_page_sel").removeClass("list_page_sel");
	//	$(this).addClass("list_page_sel");
	//});
	
	$(".prev").click(function(){
		alert("前一页");
	});

	$(".next").click(function(){
		alert("后一页");
	});
	//点击收藏
	$(document).on('click','.shoucang',function(event){
		//alert($(this).attr('data-proNum'));
		var proNum=$(this).attr('data-proNum');
		//alert(proNum);
		var _this=$(this);
		if($(this).attr("class").indexOf("btn_star_sel") != -1){
			
			$.ajax({
 				type: "POST",  
       			 dataType: "json",  
       			 url: '/DelCollect',      //提交到一般处理程序请求数据   
        		data: { proNum :proNum},           
        		success: function(data) {
        		if(data.user==0){
        			//alert("请登录");
        			$('#login').modal('show');
        			
        		}else if(data.flag==1){
        			alert("删除收藏夹成功");
        			_this.removeClass("btn_star_sel");//黄星变白
        			/* _this.getElementsByTagName("span").html("收藏"); */
        			_this.prev().html("收藏");
        			_this.prev().css("color","white");
        			
        		}
        		}  //success
			});//ajax
		}else{
			$.ajax({
 				type: "POST",  
       			 dataType: "json",  
       			 url: '/AddCollect',      //提交到一般处理程序请求数据   
        		data: { proNum :proNum},           
        		success: function(data) {
        		if(data.user==0){
        			//alert("请登录");
        			$('#login').modal('show');
        		}else if(data.flag==1){
        			alert("收藏成功");
        			_this.addClass("btn_star_sel");//白星变黄
        			/* _this.getElementsByTagName("span").html("已收藏"); */
        			_this.prev().html("已收藏");
        			_this.prev().css("color","rgb(255,226,8)");
        		}
        		}  //success
			});//ajax
		}//else
		
	});
	
   });

    </script>



    
	</body>
</html>
