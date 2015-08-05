<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>海外经纪人-购房律师-海外购房服务-海房优选-海外房产优选</title> 
   <meta name="description" content="海外经纪人-购房律师-海外购房服务-海房优选-海外房产优选" />
   <meta name="keywords" content="海外买房,澳洲买房,海外房产投资新工具" />
  <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"> 
   <link href="/css/pagination.css" rel="stylesheet">
    <script src="/js/jquery.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script> 
   <script src="/js/jquery.bootpag.min.js"></script>
   <link rel="stylesheet" type="text/css" href="/css/base.css" />
   <link rel="stylesheet" type="text/css" href="/css/list.css" />
   <link rel="stylesheet" href="/css/chosen.css">
   <script src="/js/chosen.jquery.js" type="text/javascript"></script>
        <style>
       		#page-selection .next{-position:absolute;float:right;margin-right:15px}
  			#page-selection .prev{-position:absolute;-left:131px; float:left;margin-left:15px;}
  			#page-selection{background-color: rgb(241,241,241);height: 48px;} 
  			.pagination  {width:502px;height:48px;margin-top:9px!important;display:block!important;padding-top:9px;!important}
  			.prev {margin-left:40px;}
  			.next {margin-right:40px;}
       </style>
       <style>
       		.chosen-container {			    
			    zoom: 1.25 !important;
			    font-size: 12px !important;
			}
       </style>
       
       <style style="text/css">		
	.suglist{
	width:233px;
	list-style:none;
	font-size:14px;
	padding:4px 0;
	float:left;
	margin:0px;
}
.suglist li{
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
.nobg , .suglist{width:200px;}   /*宽度修改*/

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
.chengshi a:hover{color:white}
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
			 	 	 <!-- <input type="text" class="form-control" name="suozaiarea" id="suozai" placeholder="所在区域"  autocomplete="off" >
			 	 	 <div id="_suggestion" class="suggestion nobg" style="position:absolute;left: 538px; top: 296px; display: none; z-index:999;">			                
						<div class="suginner">
			                    <ul class="suglist"></ul>
			                </div>
                		</div> -->
			 	 	  <select name="suozaiarea" style="  width: 161px;height: 32px; " class="chosen-select">
         					<option>所在区域</option>
        					 <c:forEach items="${liveregionlist}" var="item">
        					 <option value="${item}">${item}</option>
       					    </c:forEach>
                     </select>
			 	 </div>
			 	 
			 	 <div style="width:200px;height:32px;float:left;margin-right:10px;" >
			 	 	<!-- <input type="text" class="form-control" name="fuwuarea" id="fuwu" placeholder="服务区域"  autocomplete="off" >
			 	 	<div id="_suggestion1" class="suggestion nobg" style="position:absolute;left: 753px; top: 296px; display: none; z-index:999;">			                
						<div class="suginner">
			                    <ul class="suglist"></ul>
			                </div>
                		</div> -->
                		
			 	 	 <select name="fuwuarea" style="  width: 161px;height: 32px; " class="chosen-select">
         					<option>服务区域</option>
         					
        					 <c:forEach items="${serviceregionlist}" var="item">
        					<option  value="${item}">${item}</option>
       					   </c:forEach>
       					  
                     </select>
			 	 </div>
			 	 
			 	 
			 	 <div style="width:210px;height:32px;float:left;margin-right:10px;">
			 	 		<!--<input type="text" class="form-control" name="lang" placeholder="语言">-->
			 	 		 <select id="type" name="lang" value="" class="form-control" style="height:32px;">
         					<option>语言</option>
        					<%--  <c:forEach items="${languageList}" var="item">
        					<option>${item}</option> --%>
        					<option value="中文">中文</option>
        					<option value="英文">英文</option>
        					<option value="中英文">中英文</option>
       					  <%--  </c:forEach> --%>
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
				<c:forEach items="${resultListQuyu}"  var="item">
					 <div id="item1" style="width:502px;height:162px;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(207,201,201)">
                	  <div style="float:left">
                	  <a href="Service?brokerId=${item.id}" target="_blank"><img src="<%=application.getInitParameter("imagedir")%>/${item.broker_img }" style="width:126px;height:124px;"/></a>
                	  </div>
                	   <div style="width:354px;float:left;font-family:微软雅黑;padding-left:15px">
                	   <div style="font-size:18px;font-weight:bolder"><a href="Service?brokerId=${item.id}" target="_blank">${item.broker_name}</a></div>
                	  <div style="font-size:13px;"><img  src="/images/serviceteam/b2.jpg"/><span style="padding-left:10px">${item.broker_type }</span></div>
                	 <%--   <div style="font-size:13px; width:314px; height:20px; overflow:hidden;"><span style="padding-left:32px;font-style: italic;">${item.introduction}</span></div> --%>
                	  <!--  <hr style="height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;"/> -->
                	    <img src="/images/serviceteam/b5.jpg">
                	  <div style="font-size:13px;">
                	     <div style="float:left"> 
                	         <img  src="/images/serviceteam/b3.png"/>
                	         <span style="padding-left:10px">${item.broker_region}</span>
                	     </div>
                	  </div>
                	    <img src="/images/serviceteam/b5.jpg">
                	  <c:if test="${!empty item.areaList}">
                	     <div style="float:right">
                	         <img  src="/images/area11.png" style="width:17px;height:23px;margin-left:4px"/>
                	         <c:forEach var="item1" items="${item.areaList }"  varStatus="stat">
                	         <c:if test="${stat.index<2}">
                	   	        <span style="padding-left:5px">${item1}</span>
                             </c:if>
                	         </c:forEach> 
                	         <img src="/images/serviceteam/b5.jpg">
                	     </div>
                	   </c:if>
                	  
                	   <!-- <hr style="height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;"/> -->
                	 
                	   <div style="font-size:13px;"><div style="float:left;width:235px"><img  src="/images/serviceteam/b4.png"/>

                	   <span style="padding-left:10px;height:20px;width:50px;">${item.broker_language}</span></div>
                	   <span style="height:20px;width:50px;">
                	   <c:forEach var="item2" items="${item.leixingInfo }"  varStatus="stat"> 
                	   	  <img  src="<%=application.getInitParameter("imagedir")%>/${item2.leixingImg }" width=26px height=30px/>

                	   </c:forEach>
                	   
                	   </span></div>
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
					 	  <button type="button" class="btn btn-default" style="width:87px;height:38px;background-color:rgb(192,59,72);color:white;margin-left:262px" id="submit" onclick="pop1()">提交</button>
					 </div>
				</c:if>
				 <c:forEach items="${userList}"  var="item">
				 		<div class="form-group" style="padding:15px 15px;paddign-top:0px">
					 	<input type="text" class="form-control" id="name" name="name" placeholder="姓名    ${item.nick_name}" value= "${item.nick_name}" style="margin-bottom:15px">
					 	<input type="text" class="form-control" id="email" name="email" placeholder="邮箱     ${item.email}" value="${item.email}" style="margin-bottom:15px">
					 	 <input type="text" class="form-control" id="tel" name="tel" placeholder="电话    ${item.tel}" value="${item.tel}" style="margin-bottom:15px">
					 	 <textarea type="text" rows="5" cols="20" class="form-control" id="message_content" name="message_content"  placeholder="留言" style="height:108px;margin-bottom:15px"></textarea>
					 	 <!--  <button type="submit" class="btn btn-default" style="width:87px;height:38px;background-color:rgb(192,59,72);color:white;margin-left:262px" type="submit" id="submit">提交</button> -->
						<button type="button" class="btn btn-default" style="width:87px;height:38px;background-color:rgb(192,59,72);color:white;margin-left:262px"  id="submit" onclick="tijiao()">提交</button>					
			</div>
				 </c:forEach>
			  <!--   </form> -->
				</div>
				  <!-- <img src="/images/book.PNG" style="height:138px;width:380px;margin-top:10px"> -->
				  <a href="http://${adhref}" target="_blank"><img src="<%=application.getInitParameter("imagedir")%>/${ad}" style="height:138px;width:380px;margin-top:10px"></img></a>
				</div>
		<!--右侧end -->
		</div>
		</div>
	<jsp:include page="foot4index.jsp" />
	
	
	<!-- register start -->
<div class="modal fade" id="registernewPro" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" style="margin-left:100px;height:285px;width:355px;">
         <div class="modal-header" style="background-color:rgb(55,52,67);padding:0px 10px;height:10px;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true" style="font-size:18px;color:white;">
                  &times;
            </button>
         </div>
         <div class="modal-body">
  <div style="text-align:center;margin-top:5px;"><div style="font-size:20px;font-weight:bold;">用户注册</div>
  <form method="post" action="/Register" name="fm1">
  <div  style="padding-top:15px;">
         <input type="text"  id="telemailnew" name="telemailnew" style="background-image:url(images/0.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="手机号/邮箱" autocomplete="off">
   <input type="hidden" name="url" value="<%=request.getRequestURL() + "?" + request.getQueryString()%>">
   </div>
   <div>
         <input type="password" id="pwdnew" name="pwdnew" style="background-image:url(images/2.png);background-repeat:no-repeat;background-position:left;padding-left:35px;width:270px;height:34px;background-color:rgba(246, 245, 245, 1);" placeholder="密码" autocomplete="off">
   </div>
   <div style="padding-top:15px;padding-left:26px;float:left;font-size:12px;">
   
   <img src="images/register.png" id="regnew" style="width:120px;height:30px;cursor:pointer;"><span style="padding-left:20px;"><a id="cancelnew" href="#">取消</a></span>
   </div>
</form>
<div style="float:left;margin-top:60px;margin-left:-165px;font-size:12px;"><span>已有账户？<a href="javascript:void(0);" id="login2RePro">登录</a></span></div>
<div style="float:left;margin-top:85px;margin-left:-165px;font-size:12px;font-weight:bold;"><span><input type="checkbox" checked="true">我已阅读并接受<a href="/ServiceProtocol.jsp" style="color:black;">《用户服务协议》</a></span></div>
</div>
   
      </div>
</div>
</div>
</div>
<!-- register end -->
	
			
<script type="text/javascript">
function pop1(){
		  $('#registernewPro').modal('show');

}
$(function() {
	$("#xiangmuZhuce").click(function(){
		$('#registernewPro').modal('show');
	})

	 $("#login2RePro").click(function(){
		   	$('#login').modal('show');
		   	$('#registernewPro').modal('hide');
  })   


  $("#regnew").click(function() {
   	var user = $("#telemailnew").val();
   	var pass = $("#pwdnew").val();
   	var temp;
   	temp = judgeRe(user,pass);
   	//alert(temp)             	
   	 if(temp==true){	                	
           //document.fm1.submit();  //fm为form表单name
   		$.ajax({
  			type:'post',
  			url:'/Register2',
  			dateType:'json',
  			data:{"telemail":user,"pwd":pass},
  			success:function(data){
  				if(data.flag == -1){
  					alert("注册失败！");    
  					
  				}
  				else{
  					alert("注册成功！");
  					window.location.href = resultUrl;  					
  				}

  			},
  			error:function(){
    			}
  		});
   	}
   	else{               	
   		return false;
   	}  
   	
   });


	  $("#cancelnew").click(function() {
	       	$("#telemailnew").val("").focus();
	       	$("#pwdnew").val("");
	       }); 
		   
})

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
        	 $("#message_content").val("");
        	 }
         }
      		});
}
</script>

<script type="text/javascript">

var num = 1;
var totleSize = "${count}"

var pageNum1 = totleSize % 10 == 0 ? totleSize / 10 : Math.floor(totleSize / 10) + 1;

/* var num = 1; */
var totleSize = "${count}";


var pageNum = (totleSize+9)/10;



	    // init bootpag
	    $("#page-selection").bootpag({
	        total: "${total}",
	        next:'下一页',
        	prev:'上一页',
        	/* maxVisible: 0, */
        	leaps: true  
	    }).on("page", function(event, num){

	    	if(num <=pageNum1){
			
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

	                 		//var pageNum = totalSize % 10 == 0 ? totleSize / 10 : Math.floor(totleSize / 10) + 1;
	                 		
	                 		if(num == pageNum1){

	                 			  $.ajax({   
				                        type: "POST",  
				                        dataType: "json",  
				                        url: '/brokerinfoPage',      //提交到一般处理程序请求数据   
				                        data: { pageIndex : num},
				                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
				                        success: function(data) {
					                        count = data.total;
					                       
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
	    	 }
	
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
                	  html+="<a href='Service?brokerId="+items[j].id+"' target='_blank'><img src='<%=application.getInitParameter("imagedir")%>/"+items[j].broker_img+"' style='width:126px;height:149px;'/></a>";
                	   html+="</div>";
                	   html+="<div style='width:354px;float:left;font-family:微软雅黑;padding-left:15px'>";
                	   html+="<div style='font-size:18px;font-weight:bolder' >"+items[j].broker_name+"</div>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b2.jpg'/><span style='padding-left:10px'>"+items[j].broker_type+"</span></div>";
                	/*    html+="<div style='font-size:13px;' ><span style='padding-left:32px;font-style:italic'>"+items[j].introduction+"</span></div>"; */
                	    //html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	   html+="<img src='/images/serviceteam/b5.jpg'>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b3.png'/><span style='padding-left:10px'>"+items[j].broker_region+"</span></div>";
                	   
                	   // html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	    html+"  <div style='float:right'><img  src='/images/area11.png' style='width:17px;height:23px'/>";
                	    for(var k = 0; k < items[j].areaList.length; k++){
                	    	html+="<span style='padding-left:5px'>"+items[j].areaList[k]+"</span>";
                	    } 
                	  
                	    html+"<img  src='/images/serviceteam/b5.jpg'/></div>" 
                	    /* html+="<div style='float:right'>"; */
                	    html+="<div style='font-size:13px;' ><div style='float:left;width:235px'><img  src='/images/serviceteam/b4.png'/><span style='padding-left:10px'>"+items[j].broker_language+"</span></div><span >";
      	    for(var k = 0; k < items[j].leixing_list.length; k++){
                	    	html+="<img  src='<%=application.getInitParameter("imagedir")%>/"+items[j].leixing_list[k].leixingImg+"' width=26px height=30px/>";
                	    }  
                	    
                		html+="</span></div></div>";
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
                	   html+="<div id='item1' style='width:502px;height:162px;padding:15px 10px;margin-top:10px;margin-bottom:10px;border:1px solid rgb(207,201,201)'>";
                	   html+="<div style='float:left'>";
                	  html+="<a href='Service?brokerId="+items[j].id+"' target='_blank'><img src='<%=application.getInitParameter("imagedir")%>/"+items[j].broker_img+"' style='width:126px;height:124px;'/></a>";
                	   html+="</div>";
                	   html+="<div style='width:354px;float:left;font-family:微软雅黑;padding-left:15px'>";
                	   html+="<div style='font-size:18px;font-weight:bolder' >"+items[j].broker_name+"</div>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b2.jpg'/><span style='padding-left:10px'>"+items[j].broker_type+"</span></div>";
                	  /*  html+="<div style='font-size:13px; width:314px; height:20px; overflow:hidden;' ><span style='padding-left:32px;font-style: italic;'>"+items[j].introduction+"</span></div>"; */
                	    //html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	   html+="<div style='font-size:13px;' ><img  src='/images/serviceteam/b3.png'/><span style='padding-left:10px'>"+items[j].broker_region+"</span></div>";
                	   // html+="<hr style='height:1px;border:none;border-top:2px dashed #666666;margin-top:0px;margin-bottom:0px;' />";
                	    html+="<img src='/images/serviceteam/b5.jpg'>";
                	    html+="  <div ><img  src='/images/area11.png'/>";
                	    for(var k = 0; k < items[j].areaList.length; k++){
                	    	html+="<span style='padding-left:5px'>"+items[j].areaList[k]+"</span>";
                	    } 
                	  
                	    html+="<img  src='/images/serviceteam/b5.jpg'/></div>" ;
                	    html+="<div style='font-size:13px;' ><div style='float:left;width:235px'><img  src='/images/serviceteam/b4.png'/><span style='padding-left:10px'>"+items[j].broker_language+"</span></div><span>";
                	    for(var k = 0; k < items[j].leixing_list.length; k++){
                	    	html+="<img  src='<%=application.getInitParameter("imagedir")%>/"+items[j].leixing_list[k].leixingImg+"' width=26px height=30px/>";
                	    } 
                	  
                		html+="</span></div></div>";
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
					
					/* $(function(){
	if(num>=pageNum1){
		
		$(".next").removeClass().addClass("next disabled");
		alert(num+"fasdfadfadsf111111111111")
	}
	
}); */
				$("#page-selection").bootpag({
			        total: "${count}",
			        next:'下一页',
		        	prev:'上一页',
		        	leaps: true  
			    });
			    if(Size<=9){
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
<%--   <jsp:include page="footlong.jsp" /> --%>
</body>
</html>


<script>

var value = $("#suozai").val();
var value1 = $("#fuwu").val();		 
 
   		$(document).ready(function(){
   			
   		
	   		$('.carousel').carousel({
	     		interval: 2000
	    	})
		    if($('#suozai').val()==""){
		    	$('#suozai').focus();
		    	$("#_suggestion").hide();
		    }
	   	 if($('#fuwu').val()==""){
		    	$('#fuwu').focus();
		    	$("#_suggestion1").hide();
		    }
		    	

})


//IE和firefox
if(navigator.userAgent.toLowerCase().indexOf('msie')>0 || navigator.userAgent.toLowerCase().indexOf('firefox')>0){
    $('#suozai').bind('keyup',function(event){
        if(event.keyCode != "9" && event.keyCode != "38" && event.keyCode!='40') {
            input_suggest();
        }
    });
}else{
    $("#suozai").on('input',function(e){
    	
    
        input_suggest();
    });
}

   		
   	//IE和firefox
   		if(navigator.userAgent.toLowerCase().indexOf('msie')>0 || navigator.userAgent.toLowerCase().indexOf('firefox')>0){
   		    $('#fuwu').bind('keyup',function(event){
   		        if(event.keyCode != "9" && event.keyCode != "38" && event.keyCode!='40') {
   		            input_suggest();
   		        }
   		    });
   		}else{
   		    $("#fuwu").on('input',function(e){
   		    	input_suggest_fuwu();
   		    });
   		}
   	
   	
$("#suozai").on('focus',function(e){
	 if($('#suozai').val()==""){
	 	
		 $("#_suggestion").hide();
		 
	 }
	 else{
		input_suggest();
	 }
});

$("#fuwu").on('focus',function(e){
	 if($('#fuwu').val()==""){
	 	
		 $("#_suggestion1").hide();
		 
	 }
	 else{
		input_suggest_fuwu();
	 }
});



$("#suozai").on('click',function(e){
	 if($('#suozai').val()==""){
		 //input_suggest_recommend();
	 }
	 
});

$("#fuwu").on('click',function(e){
	 if($('#fuwu').val()==""){
		 //input_suggest_recommend();
	 }
	 
});



$("#suozai").on('blur',function(e){      //焦点 
    if(e.target.id!='query' && e.target.className.indexOf("slide")<0){
        //$("#_suggestion").hide();
    }
});

$("#fuwu").on('blur',function(e){      //焦点 
    if(e.target.id!='query' && e.target.className.indexOf("slide")<0){
        //$("#_suggestion").hide();
    }
});


var input_suggest = function(){
	value = $('#suozai').val();
    $.ajax({
        type:"get",
        url:"/getSuggestionSuozai",
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
               //alert(_text.indexOf(value))
                    _html += "<li>";
                    /* var arr=new Array();   
                    arr = _text.split(',');
               
                    for(var i=0; i<arr.length; i++){
                    	var item = $.trim(arr[i]);  
                    	if(item.indexOf(value)==0){
                    		_html += "<strong>"+arr[i]+"</strong>";
                    	}
                    	else{
                    		_html += arr[i];
                    	}
                    		
                    } */
                    //var txt=$.trim(_text);  
                    //alert(txt.indexOf(value));
                   if(_text.indexOf(value)==0){
                	   
                        _text = _text.substring(value.length,_text.length);
                        _html += value+"<strong>"+_text+"</strong>";
                   }/* else if(_text.indexOf(value)==_text.length-4){
                	   var tempText = _text.substring(_text.indexOf(value),_text.length);
                       _html += "<strong>"+_text.substring(0,_text.indexOf(value))+"</strong>"+tempText;
                   } */
                   
                   else{
                        _html += _text;
                   }
                    _html += "</li>"; 
                }
                $("#_suggestion div ul").html(_html);
                
				
                $("#_suggestion div ul li").each(function(){
                
					$(this).on('click',function(event){
						var info = $(this).text();
						$('#searchTerritory').val(info);
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


var input_suggest_fuwu = function(){
	value = $('#fuwu').val();
    $.ajax({
        type:"get",
        url:"/getSuggestionFuwu",
        dataType:"json",
        async:true,
        data:{},
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
               //alert(_text.indexOf(value))
                    _html += "<li>";
                    
                   if(_text.indexOf(value)==0){
                	   
                        _text = _text.substring(value.length,_text.length);
                        _html += value+"<strong>"+_text+"</strong>";
                   }/* else if(_text.indexOf(value)==_text.length-4){
                	   var tempText = _text.substring(_text.indexOf(value),_text.length);
                       _html += "<strong>"+_text.substring(0,_text.indexOf(value))+"</strong>"+tempText;
                   } */
                   
                   else{
                        _html += _text;
                   }
                    _html += "</li>"; 
                }
                $("#_suggestion1 div ul").html(_html);
                
				
                $("#_suggestion1 div ul li").each(function(){
                
					$(this).on('click',function(event){
						var info = $(this).text();
						$('#fuwu').val(info);
						//window.open("/IndexSearch?searchcity="+encodeURIComponent($(this).text()),"_blank");
					});
                }); 
                $("#_suggestio1n").show();
               
                suggLis = $("#_suggestion1 div ul li");
                highlight_li = -1;
                hoverFunc('#_suggestion1 div ul li', 'cur');
            }else{
                $("#_suggestion1").hide();
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
       $("#_suggestion1").hide();
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
        
        if($("#_suggestion1").css("display")=="block"){
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
                $("#_suggestion1").show();
            }
        }
        
    }
}
$(document).click(function(e){
    if(e.target.id!='suozai' && e.target.className.indexOf("slide")<0){
        $("#_suggestion").hide();
    }
});

$(document).click(function(e){
    if(e.target.id!='fuwu' && e.target.className.indexOf("slide")<0){
        $("#_suggestion1").hide();
    }
});


$(document).bind('keydown',function(event){
    keydown(event);
});


function highlight(){
    clearHighlight();
    if(highlight_li>=0){
        suggLis[highlight_li].className="cur";
        $("#suozai").val($(suggLis[highlight_li]).text());
        $("#fuwu").val($(suggLis[highlight_li]).text());
       
    }else{
        $("#suozai").val(default_query);
        $("#fuwu").val(default_query);
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
        var _input=$("#suozai").val();
        if(_input.length>40){
            _input = _input.substring(0,40);
            $("#suozai").val(_input);
        }
        
        var _input1=$("#fuwu").val();
        if(_input1.length>40){
            _input1 = _input1.substring(0,40);
            $("#fuwu").val(_input1);
        }
        
    }
    
    $(function(){
    	$("#search").click(function(){
    		
    		document.searchForm.submit();
    	})
	/* $('#_suggestion >.suginner > .suglist').on('click', 'li', function () {
		window.location.href="/IndexSearch"+encodeURIComponent($(this).text());
				}); */
	/* /* $('#_suggestion .suginner ').delegate('ul', 'click', function () {
    	alert("ok"); */
	//}); */
});
    </script>

  
