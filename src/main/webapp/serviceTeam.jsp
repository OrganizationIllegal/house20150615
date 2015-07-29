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
   <script src="/js/jquery.bootpag.min.js"></script>
   <link rel="stylesheet" type="text/css" href="/css/base.css" />
		<link rel="stylesheet" type="text/css" href="/css/list.css" />
        <style>
       		#page-selection .next{-position:absolute;float:right;margin-right:15px}
  			#page-selection .prev{-position:absolute;-left:131px; float:left;margin-left:15px;}
  			#page-selection{background-color: rgb(241,241,241);height: 48px;} 
  			.pagination  {width:502px;height:48px;margin-top:9px!important;display:block!important;padding-top:9px;!important}
  			.prev {margin-left:40px;}
  			.next {margin-right:40px;}
       </style>
        <!--<style>
      		 .pagination .prev{position:absolute;left:40px;}
  			.pagination .next{position:absolute;right:40px;}
  			.pagination{background-color: rgb(241,241,241);height: 43px;width:502px;margin-top:0px;margin-bottom:0px}
  		</style>-->
  		<script>
		$().ready(function(){
			var li = $(".pagination").find("li");
			li.each(function(index, Element){
					if(index!=0 && index!=li.length-1){
						$(this).hide();
					}
				});
			
		})
		
	
   		</script>
  		
</head>

<body style="width:100%;margin:0 auto">
    <jsp:include page="head4index.jsp" />

    <div style="background-color:rgb(55,52,67);background-repeat:repeat;margin:0 auto;width:1190px;height:187px;">
	<div style="width:1190px;height:187px;background-color:rgb(55,52,67);margin-top: 0px;padding-top:93px;padding-left:77px">

		<div style="color:white;font-size:35px;font-weight:bolder;font-family:黑体;">专业的团队为您提供专业的服务</div>
		<div style="color:white;font-size:15px;font-weight:bold;">持有海外认证资质的房产经纪人、会计师、律师、贷款咨询师为您提供定制化的服务</div>
	</div>
	</div>
	<!-- 上方搜索列start -->
	<div style="width:1190px;margin:0 auto;padding-top:15px;height:60px">
		<div style="">
		<!-- <form class="form-horizontal" role="form" action="/SearchService">	 -->
		 <form class="form-horizontal" role="form" action="/SearchService">		
			 <div class="form-group">
			 	 <div style="margin-left:21px;margin-right:10px;width:200px;height:32px;float:left"><input type="text" class="form-control" name="brokerName" placeholder="经纪姓名"></div>
			 	 <div style="width:200px;height:32px;float:left;margin-right:10px;">
			 	    <!--<input type="text" class="form-control" name="type" placeholder="类型">-->
			 	   
					<select  style="width:200px;height:32px" value="" name="type" class="form-control" >
						<option>类型</option>
        					 <c:forEach items="${typeList}" var="item">
        					 <option>${item}</option>
       					    </c:forEach>
					</select>
			 	 </div>
			 	 <div style="width:200px;height:32px;float:left;margin-right:10px;" >
			 	 	<input type="text" class="form-control" name="suozaiarea" placeholder="所在区域">
			 	 	 <!-- <select id="type" style="  width: 200px;height: 32px; " class="form-control">
         					<option>区域</option>
        					 <c:forEach items="${regionList}" var="item">
        					<option>${item}</option>
       					   </c:forEach>
                     </select> -->
			 	 </div>
			 	 
			 	 <div style="width:200px;height:32px;float:left;margin-right:10px;" >
			 	 	<input type="text" class="form-control" name="fuwuarea" placeholder="服务区域">
			 	 	 <!-- <select id="type" style="  width: 200px;height: 32px; " class="form-control">
         					<option>区域</option>
        					 <c:forEach items="${regionList}" var="item">
        					<option>${item}</option>
       					   </c:forEach>
                     </select> -->
			 	 </div>
			 	 
			 	 
			 	 <div style="width:210px;height:32px;float:left;margin-right:10px;">
			 	 		<!--<input type="text" class="form-control" name="lang" placeholder="语言">-->
			 	 		 <select id="type" name="lang" value="" class="form-control" style="height:32px;">
         					<option>语言</option>
        					 <c:forEach items="${languageList}" var="item">
        					<option>${item}</option>
       					   </c:forEach>
                     	</select>
			 	 </div>
			 	 <div  ><button type="submit" class="btn btn-default" style="margin-right:80px;width:90px;background-color:rgb(192,59,72);color:white;margin-top:0px;  padding-top: 0px;" onclick="shaixuan()">搜索</button></div>

             </div>
		</form>
		</div>
	</div>
	<!-- 上方搜索列end -->
	<div style="width:1190px;margin:0 auto;">
		<img src="pic/hui.jpg"/>
	</div>
	<!--下方主要内容start-->
	<div style="width:915px;margin:0 auto">	
		<div class="row" >
		<!-- 左侧列表页start -->
			<div  style="float:left;margin-right:34px">
				<div id="list">
				<c:forEach items="${resultList}"  var="item">
					 <div id="item1" style="width:502px;height:155px;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(207,201,201)">
                	  <div style="float:left">
                	  <a href="Service?brokerId=${item.id}"><img src="<%=application.getInitParameter("imagedir")%>/${item.broker_img }" style="width:126px;height:124px;"/></a>
                	  </div>
                	   <div style="width:354px;float:left;font-family:微软雅黑;padding-left:15px">
                	   <div style="font-size:18px;font-weight:bolder"><a href="Service?brokerId=${item.id}">${item.broker_name}</a></div>
                	  <div style="font-size:13px;"><img  src="/images/serviceteam/b2.jpg"/><span style="padding-left:10px">${item.broker_type }</span></div>
                	   <div style="font-size:13px; width:314px; height:20px; overflow:hidden;"><span style="padding-left:32px;font-style: italic;">${item.introduction}</span></div>
                	  <!--  <hr style="height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;"/> -->
                	    <img src="/images/serviceteam/b5.jpg">
                	  <div style="font-size:13px;"><img  src="/images/serviceteam/b3.png"/>
                	  <span style="padding-left:10px">${item.broker_region}</span></div>
                	   <!-- <hr style="height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;"/> -->
                	    <img src="/images/serviceteam/b5.jpg">
                	   <div style="font-size:13px;"><div style="float:left;width:235px"><img  src="/images/serviceteam/b4.png"/>
                	   <span style="padding-left:10px">${item.broker_language}</span></div><span>
                	   <img  src="/images/serviceteam/b6.jpg"/></span></div>
                		</div>
                		</div>
			    </c:forEach>
				</div>
				
			 	<!-- <div style="text-align:center"><div id="Pagination" class="pagination"  ></div> </div>  -->  
			 	<div style="height:48px;width:502px;">
			 	<c:if test="${!empty resultList}">
			 	<div id="page-selection" >
			 		
					 	<ul class="pagination bootpag">				 			 
					 	</ul>
					
			 	</div> 
			 	</c:if>
			 	</div>
			</div>
		<!-- 	</div></div> -->
		<!-- 左侧列表页end -->
		<!--右侧start -->
			<div id="youce" style="float:left;width:380px;margin-top:10px">
				<div style="height:140px;background-color:rgb(55,52,67);padding-top:40px">
					<div style="color:white;text-align: center;font-family:微软雅黑;font-weight:bolder;font-size:18px">让我们推荐一个最适合</div>
					<div style="color:white;text-align: center;font-family:微软雅黑;font-weight:bolder;font-size:18px">您的房产经纪</div>
				</div>
				<div style="height:345px;background-color:#d9d2e9;padding:15px 15px;padding-top:0px">
			<!-- 	<form class="form-horizontal" role="form" action="/MessageSubmit" method="post" > -->
				<c:if test="${empty userList}">
					<div class="form-group" style="padding:15px 15px">
					 	<input type="text" class="form-control" id="name" name="name" placeholder="姓名" style="margin-bottom:15px">
					 	<input type="text" class="form-control" id="email" name="email" placeholder="邮箱"  style="margin-bottom:15px">
					 	 <input type="text" class="form-control" id="tel" name="tel" placeholder="电话"  style="margin-bottom:15px">
					 	 <textarea type="text" rows="5" cols="20" class="form-control" id="message_content" name="message_content"  placeholder="留言" style="height:108px;margin-bottom:15px"></textarea>
					 	  <button type="button" class="btn btn-default" style="width:87px;height:38px;background-color:rgb(192,59,72);color:white;margin-left:262px" id="submit" onclick="tijiao()">提交</button>
					 </div>
				</c:if>
				 <c:forEach items="${userList}"  var="item">
				 		<div class="form-group" style="padding:15px 15px;paddign-top:0px">
					 	<input type="text" class="form-control" id="name" name="name" placeholder="姓名    ${item.nick_name} "style="margin-bottom:15px">
					 	<input type="text" class="form-control" id="email" name="email" placeholder="邮箱     ${item.email}" style="margin-bottom:15px">
					 	 <input type="text" class="form-control" id="tel" name="tel" placeholder="电话    ${item.tel}"  style="margin-bottom:15px">
					 	 <textarea type="text" rows="5" cols="20" class="form-control" id="message_content" name="message_content"  placeholder="留言" style="height:108px;margin-bottom:15px"></textarea>
					 	 <!--  <button type="submit" class="btn btn-default" style="width:87px;height:38px;background-color:rgb(192,59,72);color:white;margin-left:262px" type="submit" id="submit">提交</button> -->
						<button type="button" class="btn btn-default" style="width:87px;height:38px;background-color:rgb(192,59,72);color:white;margin-left:262px"  id="submit" onclick="tijiao()">提交</button>					
			</div>
				 </c:forEach>
			  <!--   </form> -->
				</div>
				  <img src="/images/book.PNG" style="height:138px;width:380px;margin-top:10px">
				</div>
		<!--右侧end -->
		</div>
		</div>
	<jsp:include page="foot4index.jsp" />
			
<script type="text/javascript">

function tijiao(){
	var  username=$("#name").val();
	var message_content=$("#message_content").val();
	 $.ajax({  
         type: "POST",  
         dataType: "json",  
         data:{username:username,message_content:message_content},
         url: '/MessageSubmit',           
         success: function(data) {
        	 if(data.flag==1){
        	 alert("提交成功");
        	 }
         }
      		});
}
</script>

<script type="text/javascript">
var num = 1;
var totleSize = "${count}"
var pageNum1 = totleSize % 10 == 0 ? totleSize / 10 : totleSize / 10 + 1;
var pageNum = (totleSize+9)/10;

	    // init bootpag
	    $("#page-selection").bootpag({
	        total: "${total}",
	        next:'下一页',
        	prev:'上一页',
        	/* maxVisible: 0, */
        	leaps: true  
	    }).on("page", function(event, num){
	
	         $.ajax({   
                        type: "POST",  
                        dataType: "json",  
                        url: '/brokerinfoPage',      //提交到一般处理程序请求数据   
                        data: { pageIndex : num},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
	                        count = data.size;
	                        
	                 		var html = getHtml(data.List);
	                 		var totalSize = data.size;
	                 		
	                 		var pageNum = totalSize % 10 == 0 ? totleSize / 10 : Math.floor(totleSize / 10) + 1;
	                 		if(num==pageNum){
	                 			  $.ajax({   
				                        type: "POST",  
				                        dataType: "json",  
				                        url: '/brokerinfoPage',      //提交到一般处理程序请求数据   
				                        data: { pageIndex : num},
				                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
				                        success: function(data) {
					                        count = data.total;
					                        //alert(count)
					                 		var html = getHtml(data.List);
					                 		$("#list").html(html); 
					                 		}
					                 		});
	                 		$(".next").removeClass().addClass("next disabled");
	                 			return false;
	                 		}

	                 		
	                 		
	                 		$("#list").html(html); 
	                 		scroll(0,0);
	                 		var li = $(".pagination").find("li");
								li.each(function(index, Element){
									if(index!=0 && index!=li.length-1){
										$(this).hide();
									}
								});
                     }
                        
                  }); 
	           
	    });
	    
	    //经纪人描述可以是两行
	    function getHtml2(items){
                var html="";
                if(items!=null){
                	 for(var j=0;j<items.length;j++){
                	   //html+="<div id='item1' style='width:502px;height:155px;background-color:red;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(236,235,235)'>";
                	  html+="<div id='item1' style='width:502px;height:180px;background-color:white;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(207,201,201)'>";
                	   html+="<div style='float:left'>";
                	  // html+="<img src='<%=application.getInitParameter("imagedir")%>/"+items[j].broker_img+"' style='width:126px;height:124px;'/>";
                	  html+="<a href='Service?brokerId="+items[j].id+"'><img src='<%=application.getInitParameter("imagedir")%>/"+items[j].broker_img+"' style='width:126px;height:149px;'/></a>";
                	   html+="</div>";
                	   html+="<div style='width:354px;float:left;font-family:微软雅黑;padding-left:15px'>";
                	   html+="<div style='font-size:18px;font-weight:bolder' >"+items[j].broker_name+"</div>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b2.jpg'/><span style='padding-left:10px'>"+items[j].broker_type+"</span></div>";
                	   html+="<div style='font-size:13px;' ><span style='padding-left:32px;font-style:italic'>"+items[j].introduction+"</span></div>";
                	    //html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b3.png'/><span style='padding-left:10px'>"+items[j].broker_region+"</span></div>";
                	   // html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	    html+="<div style='font-size:13px;' ><div style='float:left;width:235px'><img  src='/images/serviceteam/b4.png'/><span style='padding-left:10px'>"+items[j].broker_language+"</span></div><span ><img  src='/images/serviceteam/b6.jpg'/></span></div>";
                		html+="</div>";
                		html+="</div>";
                	}
                	}
                else{
                	html="";
                }
              	return html;
        }
        //经纪人描述是一行
          function getHtml(items){
                var html="";
                if(items!=null){
                	 for(var j=0;j<items.length;j++){
                	   html+="<div id='item1' style='width:502px;height:155px;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(207,201,201)'>";
                	   html+="<div style='float:left'>";
                	  html+="<a href='Service?brokerId="+items[j].id+"'><img src='<%=application.getInitParameter("imagedir")%>/"+items[j].broker_img+"' style='width:126px;height:124px;'/></a>";
                	   html+="</div>";
                	   html+="<div style='width:354px;float:left;font-family:微软雅黑;padding-left:15px'>";
                	   html+="<div style='font-size:18px;font-weight:bolder' >"+items[j].broker_name+"</div>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b2.jpg'/><span style='padding-left:10px'>"+items[j].broker_type+"</span></div>";
                	   html+="<div style='font-size:13px; width:314px; height:20px; overflow:hidden;' ><span style='padding-left:32px;font-style: italic;'>"+items[j].introduction+"</span></div>";
                	    //html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b3.png'/><span style='padding-left:10px'>"+items[j].broker_region+"</span></div>";
                	   // html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	    html+="<div style='font-size:13px;' ><div style='float:left;width:235px'><img  src='/images/serviceteam/b4.png'/><span style='padding-left:10px'>"+items[j].broker_language+"</span></div><span ><img  src='/images/serviceteam/b6.jpg'/></span></div>";
                		html+="</div>";
                		html+="</div>";
                	}
                	}
                else{
                	html="";
                }
              	return html;
        }
	    
	    
	    $(function(){
	     
			/* /* $.ajax({
				 type: "POST",  
                 dataType: "json", 
                 url: '/brokerinfoPage?pageIndex=1&pageSize=4',      //提交到一般处理程序请求数据   
                // data: { pageIndex : 1;},
                 //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                 success: function(data) {
                  count = data.total;
                //  alert(count)
           		  var html = getHtml(data.List);
           		 // alert(data.List);
           		 // alert(html);
           		  $("#list").html(html); 
           		  scroll(0,0); */
           		
				 var Size = "${count}"
			
				/* if(Size<=4){
				
				$(".next").removeClass().addClass("next disabled");
	               
	              
				} */
				/* else{ */
				$("#page-selection").bootpag({
			        total: "${count}",
			        next:'下一页',
		        	prev:'上一页',
		        	leaps: true  
			    });
			    if(Size<=4){
					$(".next").removeClass().addClass("next disabled");
				}
			    var li = $(".pagination").find("li");
					li.each(function(index, Element){
						if(index!=0 && index!=li.length-1){
							$(this).hide();
						}
					});
			 });  
	</script>	
<%--   <jsp:include page="footlong.jsp" /> --%>
</body>
</html>



  
