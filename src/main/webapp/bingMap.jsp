<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>地图找房-海房优选-海外房产优选</title> 
   <meta name="description" content="地图找房-海房优选-海外房产优选" />
   <meta name="keywords" content="海外买房,澳洲买房,海外房产投资新工具" />
   <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/map.css" />
   <link rel="stylesheet" href="css/chosen.css">
   <script type="text/javascript" src="js/jquery.js"></script>
   <script src="/js/jquery-1.11.1.min.js"></script>  
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="js/map.js"></script>
   <script type="text/javascript" src="http://ecn.dev.virtualearth.net/mapcontrol/mapcontrol.ashx?v=7.0&mkt=zh-cn"></script> 
   <script type="text/javascript" src="/js/bingMap.js"></script>
   <style style="text/css">		
	.suglist {
	width:233px;
	list-style:none;
	font-size:14px;
	padding:4px 0;
	float:left;
	margin:0px;
}
.suglist li {
	padding:0 9px;
	cursor:pointer;
	zoom:1;
	height:27px;
	line-height:27px;
}

.suglist li.cur, .slhover {
	background:#F3F3F3;
	color:#1E8D00;
}

.nobg , .suginner{background:#fff;}
.nobg , .suglist{width:434px;}   /*宽度修改*/

.suginner_nobg {
	background:none;
}
.suginner:after {
	clear:both;
	content:" ";
	visibility:hidden;
	overflow:hidden;
	height:0;
	display:block;
}
</style>
<style type="text/css">
body{
  overflow:hidden;
}
</style>
   <script type="text/javascript">
   $(function(){
	  $("#project_city").prop("disabled", true);
	  var current = $("#house1").val();
	  /* if(current == 0){
		  addPushpin();
	      getMap();
	  } */
	  //alert(current+"neirong")
   });
   </script>
   <script type="text/javascript">
   imgdir="<%=application.getInitParameter("imagedir")%>";
   function housetype(v){
	   var selectedOption=v.options[v.selectedIndex];  
	   switch(selectedOption.value){
	   case "1":
		   addPushpin1();
		   break;
	   case "2":
		   addPushpin2();
		   break;
	   case "3":  
		   addPushpin3();
		   break;
	 /*  default:
		  addPushpin1();
	   	  break; */

	   }
   }
   
   function housetype1(v){
	   var selectedOption=v.options[v.selectedIndex];  
	   switch(selectedOption.value){
	   case "1":    //公寓
		   addPushpin1();
		   break;
	   case "2":
		   addPushpin2();
		   break;
	   case "3":
		   addPushpin3();
		   break;
	  default:
		  addPushpin();
	      getMap();
	  	  break;
	   }
	   
	   }
   </script>
   
   <script>
   $(function(){
	 	 $('#orderasc').click(function () {
	 	       //alert("升序");
	 	      var pageIndex = 0;     //页面索引初始值   
	          var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
	          var total = 100;
	          total = InitTable(0); 
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
	          function InitTable(pageIndex) { 
              	//alert("ppppp");
              	pageIndex = pageIndex+1;   
              	var count = 0;            
                  $.ajax({   
                      type: "POST",  
                      async: false,
                      data:{ order : 1},
                      dataType: "json",  
                      url: '/BingMapOrderPageList?order=1',      //提交到一般处理程序请求数据   
                      data: { pageIndex : pageIndex, pageSize : pageSize},
                      //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                      success: function(data) {
                      count = data.total;
                     // alert(count);
                      var html = getHtml(data.List);
                     // alert(html)
                     		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                          $("#list").html(html);             //将返回的数据追加到表格  
                          
                      }  
                  }); 
                  return count;
              }
	        
	 	 
	 	 });
	 
	 });
	 
	  $(function(){
	 	 $('#orderdesc').click(function () {
	 	      // alert("降序");
	 	      var pageIndex = 0;     //页面索引初始值   
	          var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
	          var total = 100;
	          total = InitTable(0); 
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
	          function InitTable(pageIndex) { 
              	//alert("ppppp");
              	pageIndex = pageIndex+1;   
              	var count = 0;            
                  $.ajax({   
                      type: "POST", 
                      async: false,
                      data:{ order : 2},
                      dataType: "json",  
                      url: '/BingMapOrderPageList?order=2',      //提交到一般处理程序请求数据   
                      data: { pageIndex : pageIndex, pageSize : pageSize},
                      //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                      success: function(data) {
                      count = data.total;
                     // alert(count);
                      var html = getHtml(data.List);
                     // alert(html)
                     		//$("#Result tr:gt(0)").remove();        //移除Id为Result的表格里的行，从第二行开始（这里根据页面布局不同页变）   
                          $("#list").html(html);             //将返回的数据追加到表格  
                          
                      }  
                  }); 
                  return count;
              }
	        
	 	 
	 	 });
	 
	 })
   
   //过滤
   function shaixuan(type){
		 // alert(type);
		  var pageIndex = 0;     //页面索引初始值   
          var pageSize = 5;     //每页显示条数初始化，修改显示条数，修改这里即可  
          var total = 100;
          total = InitTable(0); 
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
          function InitTable(pageIndex) { 
          	//alert("ppppp");
          	pageIndex = pageIndex+1;
          	var count = 0;   
          	//alert(type);
              $.ajax({   
                  type: "POST",  
                  async: false,
                  data:{ house_type : 1},
                  dataType: "json",  
                  url: '/BingMapFilterPageList?house_type='+type,      //提交到一般处理程序请求数据   
                  data: { pageIndex : pageIndex, pageSize : pageSize},
                  //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                  success: function(data) {
                  count = data.total;
                 // alert(count);
                  var html = getHtml(data.List);
                 // alert(html)
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
	                    	html+=" <div id='firsthouse' style='border:1px solid #E6E6FA;padding:0 5 10 5'>"
	                    	html+="<div style='padding-top:11px;padding-left:4px'><span style='font-family:微软雅黑;font-size:13px;font-weight:bolder'>"+items[j].project_address+"</span></div>";
	                		html+="<hr style='margin-top:6px;margin-bottom:8px'/>"
	                    	html+="<div class='media' style='padding-left:4px'> ";
	                    	html+="<a class='pull-left' href='/Index?proNum="+items[j].project_num+"'"+" target='_parent'>";
	                    	html+="<img alt='image' class='img-responsive' src='<%=application.getInitParameter("imagedir")%>/"+items[j].project_img+"' style='width:160px;height:100px' ></a>";
	                    	html+="<div class='clearfix visible-sm'></div>";
	                    	html+="<div class='media-body fnt-smaller' style='padding-left:4px'>";
	                    	html+="<div style='font-family:微软雅黑;font-weight:bolder;font-size:15px' class='media-heading'>"+items[j].project_name+"</div>";
	                    	html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>最多</span><span class='right' style='margin-right:14px'>"+items[j].project_high_price+"</span></div>";
	                    	html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>最少</span><span class='right' style='margin-right:14px'>"+items[j].project_min_price+"</span></div>";
	                    	html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>面积</span><span class='right' style='margin-right:14px'>"+items[j].minArea+"<span>-</span>"+items[j].maxArea+"</span></div>";
	                    	/* html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>返利</span><span class='right'  style='margin-right:14px'>"+items[j].return_money+"</span></div>"; */
	                    	html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>均价</span><span class='right'  style='margin-right:14px'>"+items[j].project_price_int_qi+"</span></div>";
	                    	 html+="<div style='font-family:微软雅黑;font-size:13px'><span style='font-weight:bolder;'>均价</span><span class='right'  style='margin-right:14px'>"+items[j].project_key+"</span></div>";
	                    	html+="</div></div></div>";
	                    	
	                	}
	                }
	                else{
	                	html="";
	                }
	                    
	                	
	                	return html;
	                }
	   
	   function getHtml1(items){
           var html="";
           if(items!=null){
           	for(var j=0;j<items.length;j++){
           		var imgUrl = <%=application.getInitParameter("imagedir")%>/+items[j].project_img; 

               	html+=" <div class='c-fix f-l div_node'><span class='c-fix f-l f-yahei s-12 node_address' title='"+items[j].project_address+"'>"+items[j].project_address_short+"</span>";

               	html+="<a href='/Index?proNum="+items[j].project_num+"'"+" target='_parent'>";
           		
               	html+="<img class='c-fix f-l node_img'  src='"+imgUrl+"' style='width:160px;height:100px' ></img></a>";
               	html+="<div class='f-l node_right' style='width:167px'>";

               	html+="<span class='c-fix f-l f-arial s-12 fw node_name' title='"+items[j].project_name+"'>"+items[j].project_name_short+"</span>";

               	html+="<span class='c-fix f-l f-yahei s-12 node_title' style='margin-top:1px'>最多</span>";
               	html+="<span class='f-r f-yahei s-12 node_val' style='margin-top:1px'>$"+items[j].project_high_price+"</span>";
               	html+="<span class='c-fix f-l f-yahei s-12 node_title'>最少</span>";
               	html+="<span class='f-r f-yahei s-12 node_val'>$"+items[j].project_min_price+"</span>";
               	html+="<span class='c-fix f-l f-yahei s-12 node_title'>面积</span>";
               	html+="<span class='f-r f-yahei s-12 node_val'>"+items[j].minArea+"+"+items[j].maxArea+"</span>";
               /* 	html+="<span class='c-fix f-l f-yahei s-12 node_title'>返利</span>";
               	html+="<span class='f-r f-yahei s-12 node_val'>"+items[j].return_money+"</span>"; */
               	html+="<span class='c-fix f-l f-yahei s-12 node_title'>起价</span>";
               	html+="<span class='f-r f-yahei s-12 node_val'>$"+items[j].project_price_int_qi+"</span>";
            	html+="<div class='c-fix'>";
               	for(var i=0; i<items[j].project_key.length;i++){
               	
               		html+="<span class='f-l f-yahei s-12 node_title'>"+items[j].project_key[i]+"</span>";
               	}
         		html+="</div></div>";
               	
           	}
           }
           else{
           	html="";
           }
               
           	
           	return html;
           }

	
	
	
	 	 
   </script>
 <script type="text/javascript">
 $(function(){
	 var wid=document.documentElement.clientWidth ;
     //var right=wid-350-17;
     var right=wid-350;
     if(wid>350){
         $("#right1").css("width",right);
         $("#right2").css("width",right);
     }
     else{
         $("#right1").css("width",right);
         $("#right2").css("width",right);
     }
     var hei=document.documentElement.clientHeight;
     var bot=hei-100;
     $("#left").css("height",bot);
     $("#right2").css("height",bot);
	 });
 function reLoad(){
     var wid=document.documentElement.clientWidth ;
     //var right=wid-350-17;
     var right=wid-350;
     if(wid>350){
         $("#right1").css("width",right);
         $("#right2").css("width",right);
     }
     else{
         $("#right1").css("width",right);
         $("#right2").css("width",right);
     }
 }
 </script>
</head>
<body onload="getMap();" onresize="reLoad()">
<jsp:include page="head4index.jsp" />
	
		<div class="c-fix map_bkg" style="margin:0 auto;width:100%;">
		
			<div class="c-fix f-l div1">
			

				<select id="house1" onchange="housetype1(this)" class="c-fix f-l sel_type" style="background:none;border:none;font-family:微软雅黑;padding-left:25px">

					<option value="0">类型</option>
					<option value="1">公寓</option>
					<option value="2">别墅</option>
				    <option value="3">联排别墅</option>
				</select>
				
				<!-- <a class="f-l f-yahei s-14 cp sel_price" style="padding-right:0px" href="/BingMap/OrderByPrice?order=1">价格从低到高</a>
				<a class="f-l f-yahei s-14 cp sel_price" style="padding-right:0px" href="/BingMap/OrderByPrice?order=2">价格从高到低</a> -->
				<a class="f-l f-yahei s-14 cp sel_price" style="padding-right:0px" href="/OrderByPrice?order=1">价格从低到高</a>
				<a class="f-l f-yahei s-14 cp sel_price" style="padding-right:0px" href="/OrderByPrice?order=2">价格从高到低</a>
			
			</div>
	
			<div class="f-l div2" id="right1">
				<!-- <input type="text" class="c-fix f-l inp" id="keyWord" placeholder="项目地址" style="color:rgb(213,213,213);font-family:微软雅黑;height:28px;width:434px;" autocomplete="off"></input>	
				<a class="f-l f-yahei s-14 cp btn_search" onclick="addPushpinsearch()">搜索</a>
				<div id="_suggestion" class="suggestion nobg" style="position:absolute;left: 375px; top: 33px; display: none; z-index:999;">			              
				  <div class="suginner">
			                    <ul class="suglist"></ul>
			                </div>
                		</div> -->
                <div class="c-fix f-l f-yahei" style="margin-left:30px;margin-top:8px;">
	               
	                <select data-placeholder="请选择城市..." class="chosen-select" id="project_city" name="project_city" style="width:200px;" tabindex="4">
		 	            <option value="">请选择城市...</option>
		  	            <c:forEach items="${cityNameSet}" var="item">
        		   		<option value="${item}">${item}</option>
   					    </c:forEach>
	                </select>
	                 <select data-placeholder="请选择区域..." class="chosen-select" id="project_area" name="project_area" style="width:200px;" tabindex="4">
		 	            <option value="">请选择区域...</option>
		  	            <c:forEach items="${areaNameSet}" var="item">
        		   		<option value="${item}">${item}</option>
   					    </c:forEach>
	                </select>
	                <select data-placeholder="请选择邮编..." class="chosen-select" id="project_address" name="project_address" style="width:200px;" tabindex="4">
		 	            <option value="">请选择邮编...</option>
		  	            <c:forEach items="${addressNameSet}" var="item">
        		   		<option value="${item}">${item}</option>
   					    </c:forEach>
	                </select>
                </div>
                <div class="f-l f-yahei btn_search cp" onclick="addPushpinsearch()">搜索</div>
				<a class="f-r f-yahei s-14 btn cp hover" style="padding:0px 6px;margin-top:5px;border:2px solid rgb(245,161,27)" href="/SearchList">列表找房</a>
				<a class="f-r f-yahei s-14 btn btn_sel cp hover" style="padding:0px 6px; margin-top:5px;"   href="#">地图找房</a>

			</div>
			<div class="c-fix f-l div3" style="-height:840px;overflow-y:auto;overflow-x:hidden;" id="left">
			 <c:forEach var="item" items="${bingMapList}"> 
				<div class="c-fix f-l div_node">
					<span class="c-fix f-l f-yahei s-12 node_address" title="${item.project_address}">${item.project_address_short}</span>
					<a href="/Index?proNum=${item.project_num}" target="blank">
					<img class="c-fix f-l node_img" src="<%=application.getInitParameter("imagedir")%>/${item.project_img}" style="width:160px;height:100px" ></img>
					</a>
					<div class="f-l node_right" style="width:167px">
						<span class="c-fix f-l f-arial s-12 fw node_name" title="${item.project_name_full}">${item.project_name}</span>
						<span class="c-fix f-l f-yahei s-12 node_title" style="margin-top:1px">最多</span>
						<span class="f-r f-yahei s-12 node_val" style="margin-top:1px">$${item.project_high_price}</span>
						<span class="c-fix f-l f-yahei s-12 node_title">最少</span>
						<span class="f-r f-yahei s-12 node_val">$${item.project_min_price}</span>
						<span class="c-fix f-l f-yahei s-12 node_title">面积</span>
						<span class="f-r f-yahei s-12 node_val">${item.minArea}-${item.maxArea}</span>
						<%-- <a class="c-fix f-l f-yahei s-12 node_title">返利</a>
						<a class="f-r f-yahei s-12 node_val">${item.return_money}</a> --%>
						<span class="c-fix f-l f-yahei s-12 node_title">起价</span>
						<span class="f-r f-yahei s-12 node_val">$${item.project_price_int_qi}</span>
						<%-- <span class="c-fix f-l f-yahei s-12 node_title">${item.project_key}</span> --%>
						   <div class="c-fix ">
						 <c:forEach  var="item3" items="${item.project_key}">
						  
						    <span class=" f-l f-yahei s-12 node_title" style="margin-right:16px;">${item3}</span>
						 
						 </c:forEach>
						    </div>
						<!-- <a class="f-r f-yahei s-12 node_val">$${item.project_price_int_qi}</a> -->
					</div>
				</div>
			 </c:forEach> 
			</div>
			<div class="f-l div4" id="right2">
				<div  id="myMap" style="position:relative;width:100%;height:100%;"></div>
			</div>
		</div>
		
	</body>
</html>
<<script type="text/javascript">
		var value = $("#keyWord").val();
  		
   		
   		$(document).ready(function(){
	   		$('.carousel').carousel({
	     		interval: 2000
	    	})
		    if(value=="" || value == null){
		    	$('#keyWord').focus();
		    	$("#_suggestion").hide();
		    }
})


//IE和firefox
if(navigator.userAgent.toLowerCase().indexOf('msie')>0 || navigator.userAgent.toLowerCase().indexOf('firefox')>0){
    $('#keyWord').bind('keyup',function(event){
        if(event.keyCode != "9" && event.keyCode != "38" && event.keyCode!='40') {
            input_suggest();
        }
    });
}else{
    $("#keyWord").on('input',function(e){
        input_suggest();
    });
}

$("#keyWord").on('focus',function(e){
	 if($('#keyWord').val()==""){
		 $("#_suggestion").hide();
		 
	 }
	 else{
	 	input_suggest();
	 }
    
});

$("#keyWord").on('blur',function(e){      //焦点 
    if(e.target.id!='query' && e.target.className.indexOf("slide")<0){
        //$("#_suggestion").hide();
    }
});

var input_suggest = function(){
	value = $('#keyWord').val();
	
    $.ajax({
        type:"get",
        url:"/getSuggestionMap",
        dataType:"json",
        async:true,
        data:{query:value},
        success:function(data){
       
            if(data.success && data.list.length>0){
           
                var _html = "";
                 
                for(var i = 0 ; i<10 && i < data.list.length;i++){
                    var _text = data.list[i];
                    if(_text=='' || _text==undefined){
                        continue;
                    }
                    if(_text.length>30){
                        _text = _text.substring(0,30);
                    }
                    var _text = data.list[i];
                    _html += "<li>";
                   if(_text.indexOf(value)==0){
                	   
                        _text = _text.substring(value.length,_text.length);
                        _html += value+"<strong>"+_text+"</strong>";
                   }
                   else{
                        _html += _text;
                   }
                    _html += "</li>"; 
                }
                $("#_suggestion div ul").html(_html);
                
				
                $("#_suggestion div ul li").each(function(){
                
					$(this).on('click',function(event){
						var info = $(this).text();
						$('#keyWord').val(info);
						//window.open("/IndexSearch?searchcity="+encodeURIComponent($(this).text()),"_blank");
					});
                }); 
                $("#_suggestion").show();
               
                suggLis = $("#_suggestion div ul li");
                highlight_li = -1;
                hoverFunc('#_suggestion div ul li', 'cur');
            }else{
                $("#_suggestion").hide();
            }
        },
        error:function(){}
    });
};

function stopEvent(evt){
    if(evt.preventDefault){
        evt.preventDefault()
    }
    evt.cancelBubble=true;
    return evt.returnValue=false
}
//keydown的处理
function keydown(evt){
    evt = evt||window.event;
    if (evt.keyCode == 27){ //Esc
       $("#_suggestion").hide();
        return stopEvent(evt);
    }else if(evt.keyCode==0x1){
    	alert("zuojian");
    }
    else if(evt.keyCode == 13){ //Enter
    }else{
        if($("#_suggestion").css("display")=="block"){
            if (evt.keyCode == 38){
                upKey();
                return stopEvent(evt);
            }else if (evt.keyCode == 9 || evt.keyCode == 40){
                downKey();
                return stopEvent(evt);
            }
        }else{
            if ((evt.keyCode == 38)||(evt.keyCode == 40)){
                highlight_li = -1;
                clearHighlight();
                $("#_suggestion").show();
            }
        }
    }
}
$(document).click(function(e){
    if(e.target.id!='searchTerritory' && e.target.className.indexOf("slide")<0){
        $("#_suggestion").hide();
    }
});
$(document).bind('keydown',function(event){
    keydown(event);
});


function highlight(){
    clearHighlight();
    if(highlight_li>=0){
        suggLis[highlight_li].className="cur";
        $("#keyWord").val($(suggLis[highlight_li]).text());
        $("#w").val("2042")
    }else{
        $("#keyWord").val(default_query);
    }
}
function clearHighlight(){
    for(var i=0;i<suggLis.length;i++){
    	suggLis[i].className="";
    }
}

function upKey(){
    clearHighlight();
    highlight_li--;
    if(highlight_li==-2){
        highlight_li=Math.min(suggLis.length,10)-1
    }
    highlight()
}

function downKey(){
    clearHighlight();
    highlight_li++;
    if(highlight_li==Math.min(suggLis.length,10)){
        highlight_li=-1
    }
    highlight()
}
function hoverFunc(select, css){
    $(select).hover(
        function(){
            $(this).addClass(css);
        },
        function(){
            $(this).removeClass(css);
        }
    )
}

function checkForm(){
    var _input=$("#keyWord").val();
    if(_input.length>40){
        _input = _input.substring(0,40);
        $("#keyWord").val(_input);
    }
}
   
</script>
<script src="/js/chosen.jquery.js" type="text/javascript"></script>
 <script src="/docsupport/prism.js" type="text/javascript" charset="utf-8"></script>
 <script type="text/javascript">
    var config = {
      '.chosen-select'           : {},
      '.chosen-select-deselect'  : {allow_single_deselect:true},
      '.chosen-select-no-single' : {disable_search_threshold:10},
      '.chosen-select-no-results': {no_results_text:'Oops, nothing found!'},
      '.chosen-select-width'     : {width:"95%"}
    }
    for (var selector in config) {
      $(selector).chosen(config[selector]);
    }
  </script>
