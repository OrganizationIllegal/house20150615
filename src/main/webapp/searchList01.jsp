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
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/list.css" />
		<!-- <script type="text/javascript" src="/js/jquery.js"></script>  -->
		<script type="text/javascript" src="/js/jquery-1.11.2.js"></script> 
		<!-- <script type="text/javascript" src="/js/list.js"></script> -->
		<!--  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
  		 <link href="/css/pagination.css" rel="stylesheet">
   	<!-- 	<script src="/bootstrap/js/bootstrap.min.js"></script> -->
   	<!-- 	<script src="js/jquery.pagination.js"></script> -->
   		<style>
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
   		</style>
   	
	</head>
	<body>
<jsp:include page="head4index.jsp" />
		<div class="c-fix list_bkg">
			<div class="c-fix f-l list_left">
				<a class="c-fix f-l f-yahei s-14 btn cp hover" style="padding:4px 6px;border:2px solid rgb(245,161,27)" href="/BingMap">地图找房</a>
				<a class="f-l f-yahei s-14 btn cp btn_sel hover" style="margin-left:1px;padding:4px 6px;" href="#">列表找房</a>
				<div class="c-fix f-l" style="color:#617c97;font-size:16px;font-weight:bold;margin-bottom:10px;margin-top:20px;">进一步搜索</div>
				<a class="c-fix f-l f-yahei s-14" style="color:#333;margin-top:10px;">类型</a>
				<select style="width:100%;height:30px;line-height:30px;margin-top:3px;">
					<option>1</option>
					<option>2</option>
					<option>3</option>
				</select>
				<div class="c-fix f-l f-yahei s-14" style="display:block;width:100%;min-height:20px;margin-top:20px;">
					<a style="display:block;color:#333;font-size:14px;float:left;">总价</a>
					<a style="display:block;color:#ff6600;font-size:14px;float:right">100k-2M+</a>
					<input type="range" class="c-fix f-l" style="display:block;width:100%;margin-top:5px;margin-left:0px;"></input>
				</div> 
				<div class="c-fix f-l f-yahei s-14" style="display:block;width:100%;min-height:20px;margin-top:20px;">
					<a style="display:block;color:#333;font-size:14px;float:left;">单价</a>
					<a style="display:block;color:#ff6600;font-size:14px;float:right">0k-20,000+</a>
					<input type="range" class="c-fix f-l" style="display:block;width:100%;margin-top:5px;margin-left:0px;"></input>
				</div> 
				<div class="c-fix f-l f-yahei s-14" style="display:block;width:100%;min-height:20px;margin-top:20px;">
					<a style="display:block;color:#333;font-size:14px;float:left;">卧室</a>
					<a style="display:block;color:#ff6600;font-size:14px;float:right">0k-4+</a>
					<input type="range" class="c-fix f-l" style="display:block;width:100%;margin-top:5px;margin-left:0px;"></input>
				</div> 
				<div style="display:block;width:100%;min-height:20px;margin-top:10px;float:left;clear:both">
					<a style="display:block;color:#333;font-size:14px;float:left;">用途</a>
					<div style="display:block;width:100%;height:1px;background-color:#666;clear:both;float:left;margin-top:3px;margin-bottom:3px"></div>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">新开盘</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">热门项目</a>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">优秀学区</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">城市中心</a>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">包租项目</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">华人区</a>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">最新项目</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">大学附近</a>

					<input style="display:block;clear:both;float:left;height:30px;margin-left:0px" type="checkbox"/>
					<a style="display:block;width:60px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">城市中心</a>
					<input style="display:block;float:left;height:30px" type="checkbox"/>
					<a style="display:block;width:50px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">轨道交通</a>

					<a class="c-fix f-r btn_search f-yahei s-14 cp">搜索</a>
				</div> 
			</div>
			<div class="f-r list_right">
				<div class="c-fix f-l nav_panel" id="page" style="margin-bottom:35px">
				   <div id="Pagination" class="pagination"  style="margin:0 0;height:40px;"></div>
					 <div style="float:right;margin-top:20px">
					<select class="f-l sel_order" style="background-color:rgb(220,220,220);padding-left:5px;" onchange="paixu(this)">
						<option value="0">排序</option>
						<option value="1">推荐度</option>
						<!-- <option value="2">热门度</option> -->
					</select></div> 
					
				</div>
				<div id="list"></div>
				<!--<div><div id="Pagination1" class="pagination"  style="margin:0 0;height:40px;"></div></div>-->
		</div>
		
	</div>
		<jsp:include page="foot4index.jsp" />
		<script src="/js/jquery.pagination.js"></script>
   <script type="text/javascript">
         var pageIndex = 0;     //页面索引初始值   
         var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
         var total = 100;
         $(function () {
              total = InitTable(0);    //Load事件，初始化表格数据，页面索引为0（第一页）
                //分页，PageCount是总条目数，这是必选参数，其它参数都是可选
                $("#Pagination").pagination(total,{
                    callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                    prev_text: "«",
                    next_text: "»",
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
                        url: '/IndexSearchPage',      //提交到一般处理程序请求数据   
                        data: { pageIndex : pageIndex, pageSize : 5},
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

    function paixu(v){
		   							  var pageIndex = 0;     //页面索引初始值   
							          var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
							          var total = 100;
							          total = InitTable(0); 
		   					$("#Pagination").pagination(total,{
                   						 callback: PageCallback,  //PageCallback() 为翻页调用次函数。
                   						 prev_text: "«",
                   						 next_text: "»",
                   						 items_per_page:pageSize,
                    					num_edge_entries: 1,       //两侧首尾分页条目数
                   						 num_display_entries: 5,    //连续分页主体部分分页条目数
                    					current_page: pageIndex,   //当前页索引
               				 });
               				   function PageCallback(index, jq) {    
                   				   
                   					 InitTable(index);  
                				}  
		   						  function InitTable(pageIndex) { 
						                	pageIndex = pageIndex+1;   
						                	var count = 0; 
						                	       
						                    $.ajax({   
						                        type: "POST",  
						                        async: false,
						                        dataType: "json",  
						                        url: '/OrderPage',      //提交到一般处理程序请求数据   
						                        data: { pageIndex : pageIndex, pageSize : 5},
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
                	for(var j=0;j<items.length;j++){
                		html+="<div class='c-fix f-r list_node' style='margin-top:15px;margin-bottom:15px'>";
                		html+="<div class='c-fix f-l list_node_header'>";
                		html+="<a class='c-fix f-l f-arial s-16 list_node_name fw'>"+items[j].Project_name+"</a>";
                		html+="<a class='f-l f-arial s-12 list_node_address'>"+items[j].project_address+"</a>";
                		//html+="<div class='f-r btn_star cp' id='star' onclick=a(\""+items[j].project_num+"\")></div>";
                		if(items[j].isCollected==0)//未收藏 星星显示白色
                		{
                		 	html+="<div class='f-r btn_star cp'  id='star"+j+"' data-proNum="+items[j].project_num+"></div>";	
                		}
                		else{
                			 html+="<div class='f-r btn_star cp btn_star_sel'  id='star"+j+"' data-proNum="+items[j].project_num+"></div>";
                		}
                	   
                		html+="</div>";
                		html+="<div class='c-fix f-l list_node_body'>";
                		html+="<a href='/Index?proNum="+items[j].project_num+"'><img class='c-fix f-l list_node_img' src='http://101.200.174.253:9090/all/"+items[j].Project_img+"'></img></a>";
                		html+="<div class='f-l list_node_middle'>";
                		html+="<a class='c-fix f-l list_node_inner_name f-yahei s-14'  style='font-weight:bolder'>"+items[j].Project_name+"</a>";
                		html+="<a class='c-fix f-l list_node_desc f-yahei s-13'>"+items[j].project_lan_cn+"</a>";
                		html+="<div class='c-fix f-l list_node_tag_div' style='margin-bottom:10px;margin-top:10px;'>";
                		if(items[j].remen!=null){
                			html+="<div style='border:1px solid rgb(254,254,230); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >热门项目</div>";
                		}
                		if(items[j].xuequ!=null){
                			html+="<div style='border:1px solid rgb(228,253,224); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >优秀学区</div>";
                		}
                		if(items[j].baozu!=null){
                			html+="<div style='border:1px solid rgb(248,235,255); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >包租项目</div>";
                		}
                		if(items[j].huaren!=null){
                			html+="<div style='border:1px solid rgb(227,252,223);text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >华人区</div>";
                		}
                		if(items[j].maidi!=null){
                			html+="<div style='border:1px solid rgb(251,227,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >最新项目</div>";
                		}
                		if(items[j].daxue!=null){
                			html+="<div style='border:1px solid rgb(229,254,225);text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >大学附近</div>";
                		}
                		if(items[j].center!=null){
                			html+="<div style='border:1px solid rgb(229,254,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >城市中心</div>";
                		}
                		if(items[j].traffic!=null){
                			html+="<div style='border:1px solid rgb(229,254,225); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >轨道交通</div>";
                		}
                		if(items[j].xianfang!=null){
                			html+="<div style='border:1px solid rgb(253,227,227); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >现房项目</div>";
                		}
                		if(items[j].xinkaipan!=null){
                			html+="<div style='border:1px solid rgb(253,227,227); text-align:center;margin-left:5px;margin-right:5px;margin-bottom:10px;font-size:10px;width:54px;float:left;'  >新开盘</div>";
                		}
                		html+="</div>";
                		//html+="<img class='c-fix f-l list_node_logo' src='res/images/node_img.jpg'></img>";
                		if(items[j].developer_id_name!=null)
   	       				{
   	       					html+="<span style='margin-top:20px;font-family:微软雅黑;color:rgb(170,16,25);font-style:italic;font-size:20px'>"+items[j].developer_id_name+"</span>";
   	       				}
                		html+="</div>";
                		html+="<div class='f-l list_node_right'>";
                		html+="<a class='c-fix f-l list_node_inner_lab f-yahei s-12'></a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>最多：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].MaxPrice+"</a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>最少：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].MinPrice+"</a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>面积：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].MinArea+"<span>-</span>"+items[j].MaxArea+"</a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>起价：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].project_price_int_qi+"</a>";
                		html+="<a class='f-l list_node_title fw f-yahei s-12 c-fix'>返现：</a>";
                		html+="<a class='f-r list_node_val f-yahei s-12'>"+items[j].Fanxian+"</a>";
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
		//alert("前一页");
	});

	$(".next").click(function(){
		//alert("后一页");
	});
	
	

					$("#star0").on('click',function(event){
						//alert("currentstar"+currentstar);
						var proNum=this.getAttribute('data-proNum');
						//alert(proNum);
						if($("#star0").attr("class").indexOf("btn_star_sel") != -1){//删除
							$.ajax({
				 				type: "POST",  
                       			 dataType: "json",  
                       			 url: '/DelCollect',      //提交到一般处理程序请求数据   
                        		data: { proNum :proNum},           
                        		success: function(data) {
                        		if(data.user==0){
                        			//alert("请登录");
                        			//$('#loginxing2').modal('show');
                        			
                        		}else if(data.flag==1){
                        			alert("删除收藏夹成功");
                        			$("#star0").removeClass("btn_star_sel");//黄星变白
                        		}
                        		}  //success
							});//ajax
							
						}else{//添加
							$.ajax({
				 				type: "POST",  
                       			 dataType: "json",  
                       			 url: '/AddCollect',      //提交到一般处理程序请求数据   
                        		data: { proNum :proNum},           
                        		success: function(data) {
                        		if(data.user==0){
                        			//alert("请登录");
                        			//$('#loginxing2').modal('show');
                        			
                        		}else if(data.flag==1){
                        			alert("收藏成功");
                        			$("#star0").addClass("btn_star_sel");//白星变黄
                        		}
                        		}  //success
							});//ajax
						}//else
					});//click
					
					$("#star1").on('click',function(event){
						//alert("currentstar"+currentstar);
						var proNum=this.getAttribute('data-proNum');
						//alert(proNum);
						if($("#star1").attr("class").indexOf("btn_star_sel") != -1){
							$.ajax({
				 				type: "POST",  
                       			 dataType: "json",  
                       			 url: '/DelCollect',      //提交到一般处理程序请求数据   
                        		data: { proNum :proNum},           
                        		success: function(data) {
                        		if(data.user==0){
                        			//alert("请登录");
                        			//$('#loginxing2').modal('show');
                        			
                        		}else if(data.flag==1){
                        			alert("删除收藏夹成功");
                        			$("#star1").removeClass("btn_star_sel");//黄星变白
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
                        			//$('#loginxing2').modal('show');
                        		}else if(data.flag==1){
                        			alert("收藏成功");
                        			$("#star1").addClass("btn_star_sel");//白星变黄
                        		}
                        		}  //success
							});//ajax
						}//else
					});//click
					$("#star2").on('click',function(event){
						//alert("currentstar"+currentstar);
						var proNum=this.getAttribute('data-proNum');
						//alert(proNum);
						if($("#star2").attr("class").indexOf("btn_star_sel") != -1){
							$.ajax({
				 				type: "POST",  
                       			 dataType: "json",  
                       			 url: '/DelCollect',      //提交到一般处理程序请求数据   
                        		data: { proNum :proNum},           
                        		success: function(data) {
                        		if(data.user==0){
                        			//alert("请登录");
                        			//$('#loginxing2').modal('show');
                        			
                        		}else if(data.flag==1){
                        			alert("删除收藏夹成功");
                        			$("#star2").removeClass("btn_star_sel");//黄星变白
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
                        				//$('#loginxing2').modal('show');
                        		}else if(data.flag==1){
                        			alert("收藏成功");
                        			$("#star2").addClass("btn_star_sel");//白星变黄
                        		}
                        		}  //success
							});//ajax
						}//else
					});//click
					$("#star3").on('click',function(event){
						//alert("currentstar"+currentstar);
						var proNum=this.getAttribute('data-proNum');
						//alert(proNum);
						if($("#star3").attr("class").indexOf("btn_star_sel") != -1){
							$.ajax({
				 				type: "POST",  
                       			 dataType: "json",  
                       			 url: '/DelCollect',      //提交到一般处理程序请求数据   
                        		data: { proNum :proNum},           
                        		success: function(data) {
                        		if(data.user==0){
                        			//alert("请登录");
                        			//$('#loginxing2').modal('show');
                        			
                        		}else if(data.flag==1){
                        			alert("删除收藏夹成功");
                        			$("#star3").removeClass("btn_star_sel");//黄星变白
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
                        			//$('#loginxing2').modal('show');
                        		}else if(data.flag==1){
                        			alert("收藏成功");
                        			$("#star3").addClass("btn_star_sel");//白星变黄
                        		}
                        		}  //success
							});//ajax
						}//else
					});//click
					$("#star4").on('click',function(event){
						//alert("currentstar"+currentstar);
						var proNum=this.getAttribute('data-proNum');
						//alert(proNum);
						if($("#star4").attr("class").indexOf("btn_star_sel") != -1){
							$.ajax({
				 				type: "POST",  
                       			 dataType: "json",  
                       			 url: '/DelCollect',      //提交到一般处理程序请求数据   
                        		data: { proNum :proNum},           
                        		success: function(data) {
                        		if(data.user==0){
                        			//alert("请登录");
                        			//$('#loginxing2').modal('show');
                        			
                        		}else if(data.flag==1){
                        			alert("删除收藏夹成功");
                        			$("#star4").removeClass("btn_star_sel");//黄星变白
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
                        			//$('#loginxing2').modal('show');
                        		}else if(data.flag==1){
                        			alert("收藏成功");
                        			$("#star4").addClass("btn_star_sel");//白星变黄
                        		}
                        		}  //success
							});//ajax
						}//else
					});//click
				
				
					
					
					
				
});

    </script>
    <!-- login start -->
<div class="modal fade" id="loginxing2" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:270px;width:355px;">
         <div class="modal-header" style="background-color:rgb(55,52,67);padding:0px 10px;height:10px;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true" style="font-size:18px;color:white;">
                  &times;
            </button>
         </div>
         <div class="modal-body">
  <div style="text-align:center;margin-top:5px;"><div style="font-size:20px;font-weight:bold;">欢迎登录海外房产优选</div>
  <form method="post" name="fmxing" action="/login2">
  <div  style="padding-top:25px;">
         <input type="text"  id="usernamexing"
            name="usernamexing" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
         <input type="hidden" id="usernamexing1" 
            name="usernamexing1" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
        <input type="hidden" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;width:270px;padding-left:35px;height:32px;background-color:rgba(246, 245, 245, 1);" id="rolexing" 
            name="rolexing" placeholder="用户角色">
       <div id="user" style="margin-left:20px;"></div>
      
   </div>
   <div>
         <input  type="password" id="passwordxing" 
            name="passwordxing1" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
         <input type="hidden" id="passwordxing1" 
            name="passwordxing1" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:32px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
       <div id="pass" style="margin-left:20px;"></div>
   </div>
   
   <div style="padding-top:20px;padding-left:20px;float:left;font-size:12px;">
      <span><input type="checkbox">记住我 <a href="/changePass.jsp" style="padding-left:160px;color:black;">忘记密码？</a></span>  
   </div>
   <div style="padding-top:15px;padding-left:20px;float:left;">
   <img src="images/3.png" id="loginxing" style="width:120px;height:30px;cursor:pointer;">   
   </div>
</form>
         </div>
   
      </div>
</div>
</div>
</div>
<!-- login end -->
<script>

var role;
 $(function() {
                $("#loginxing").click(function() {
                    
                	var user = $("#usernamexing").val();
                	var pass = $("#passwordxing").val();
                	var temp;
                	temp = judge(user,pass);
                    alert(temp)
                	if(temp==true){
	                	var usernamexing = encode64($("#usernamexing").val());
	                	var passwordxing = encode64($("#passwordxing").val());
	                	//alert("用户名加密后的结果:"+usernamexing+"密码加密后的结果:"+passwordxing);
	                	$("#usernamexing1").val(usernamexing);
	                    $("#passwordxing1").val(passwordxing);
	                    alert("usernamexing"+usernamexing);
	                    alert("passwordxing"+passwordxing);
	                    //alert(role);
	                    $("#rolexing").val(role);
	                    document.fmxing.submit();  //fm为form表单name
                	}
                	else{
                		return false;
                	}
                })
                
                /* $("#reg").click(function() {
                  	var user = $("#telemail").val();
                  	var pass = $("#pwd").val();
                  	var temp;
                  	temp = judgeRe(user,pass);
                  	alert(temp)             	
                  	if(temp==true){	                	
  	                    document.fm1.submit();  //fm为form表单name
                  	}
                  	else{               	
                  		return false;
                  	} 
                  });

                  $("#cancel").click(function() {
                    	$("#telemail").val("").focus();
                    	$("#pwd").val("");
                    });    */
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
/* function judgeRe(username, password){
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
  				else if(data.user==1){
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
 } */
 
   
  
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

    
	</body>
</html>
