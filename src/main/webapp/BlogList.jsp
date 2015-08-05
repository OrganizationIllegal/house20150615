
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 
    prefix="fn" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>海外新闻-海房优选-海外房产优选</title> 
   <meta name="description" content="海外新闻-海房优选-海外房产优选" />
   <meta name="keywords" content="海外买房,澳洲买房,海外房产投资新工具" />
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="/css/pagination.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <script src="/js/jquery.bootpag.min.js"></script>
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <!-- <script src="/js/jquery.pagination.js"></script> -->
    <style>
    	body{
    		font-family:"Microsoft YaHei"!important;
    	}
   		.row{
   			  margin-right: 0px;
  				margin-left: 0px;
  			
   		}
   		.panel-heading {
  			padding: 14px 15px!important;
  		}
  		.media{
  			/* width:140px!important; */
  		}
  		#page-selection .next{position:absolute;right:40px;}
  		#page-selection .prev{position:absolute;left:40px;}
  		#page-selection{background-color: rgb(241,241,241);height: 48px;}
  		#mainlist .media-body,#mainlist  .media-left,#mainlist  .media-right {
		  display: table-cell;
		  vertical-align: middle;
		  height: 165px;
		}
		#mainlist{
			margin-bottom: 15px;
		}
		#mainlist .media-left{
			height:165px;
		}
		#mainlist  .media-body{
			height:134px;	
		}
		#mainlist li{
			margin-top:0px;
			border-bottom-width: 1px;
		  border-bottom-style: solid;
		  border-bottom-color: #FFE1FF;
		}
		.col-md-7{
			padding-right: 0px; 
   			padding-left: 0px; 
		}
		#panel-left .panel-body{
			padding-top:0px;
		}
		#leftpanel{background-color: white;}
		.panel{
			font-family:'微软雅黑';
		}
		.pagination{	
			display: block!important;
  			padding-left: 0!important; 
  			margin: 0px 0!important; 
			padding-top: 9px;
		}  
		.media-list li{
			margin-top:10px;
		}
		#panel-left{
			margin-bottom: 8px;
		}
   </style>
   <script>
		$().ready(function(){
			var li = $(".pagination").find("li");
			li.each(function(index, Element){
					if(index!=0 && index!=li.length-1){
						$(this).hide();
					}
				});
			
		})
function reLoad(){
       var wid=document.documentElement.clientWidth ;
       if(wid<1190){
           $("#container").css("width","1190px");
       }
       else{
           $("#container").css("width","100%");
       }
       //alert(wid);
   }
	
   </script>
  
</head>
<body style="/* padding-top: 105px; */margin:0 auto;background-color:rgb(232, 233, 234);" onresize="reLoad()">
<%
String flag = null;
if(request.getSession().getAttribute("flag")!=null){
	flag = request.getSession().getAttribute("flag").toString();
}
%>
<jsp:include page="head4index.jsp" />
<div id="container" class="" style="width:100%;margin:0 auto; padding-top:10px; background:#fff;">
 <a name="wintop"></a>
	<div class="" style="-margin-top:61px;">
       <!-- <div class="row" style="height:36px;background-color:rgb(20,51,82);width:1190px;  margin: 0 auto;">
            <div class="col-md-1"  style="width:142px;float:left;"></div>
            <div class="col-md-3" style="width:340px;height:100%;line-height:37px;color:white;"><a href="/index01" style="color: #FFE4B5;padding-right: 10px;">首页</a><a href="/BlogList" style="color: white;padding-right: 10px;">新闻博客 </a><a href="/ZhiYeInfo" style="color: #FFE4B5;padding-right: 10px;">置业指导</a></div>
        </div> -->
        <div  style="height:82px;border:1px solid #FFE4E1;width:100%; margin: 0 auto;background-color: white;margin-top:-10px;position:relative;">
            <div class="" style="width:980px;font-size:24px;line-height:70px;height:100%;font-weight:bold;margin:0 auto;">海外新闻</div>
        </div>
        <div style="padding-top: 35px;width:100%; margin: 0 auto;background-color:rgb(247,248,250);">
        <div class="row" style="width:980px; margin: 0 auto;position:relative;">
            <!-- <div class="col-md-1" style="width:142px;float:left;"></div> -->
            <div class="col-md-7"  style="width:600px;float:left;">
                <div class="row">
                    <div class="panel panel-default" id="panel-left">
                      <div class="panel-heading" id="leftpanel" style="font-weight:bold;">
					  1-
                      <c:choose>
                      	<c:when test="${total<10}">
                      	${total}
                      </c:when>
                      <c:otherwise>
                      	10
                      </c:otherwise>
                      </c:choose>
                      的${total}篇文章</div>
                      <div class="panel-body">
                        <ul class="media-list" id="mainlist">
                        <c:forEach items="${newsList}" var="item" varStatus="status">
                        	<c:if test="${status.index < 10}">
                        		<li class="media" >
                             <div class="media-left">
                                <a href="/Detail?id=${item.id}&type=1" target='_blank'>
                                  <img class="media-object" src="<%=application.getInitParameter("imagedir")%>/${item.news_image}" alt="" width="180px" height="134px">
                                </a>
                              </div>
                              <div class="media-body" style="padding-left:20px;">
                                <div class="media-heading" style="font-size:20px;color:rgb(147,181,219);"><a  href="/Detail?id=${item.id}&type=1" target='_blank'>${item.news_title}</a></div>
                                <p style="font-size:12px;">${item.news_fenlei}&nbsp;&nbsp;&nbsp;&nbsp;${fn:substring(item.news_time,0,10)}</p>
                                <p style="font-size:12px;">
                                	<c:choose> 
								     <c:when test="${fn:length(item.news_abstract) > 60}"> 
								      <c:out value="${fn:substring(item.news_abstract, 0, 60)}......" /> 
								     </c:when> 
								     <c:otherwise> 
								      <c:out value="${item.news_abstract}" /> 
								     </c:otherwise>
								    </c:choose>
                                </p>
                                <a href="/Detail?id=${item.id}&type=1" target='_blank'>全文></a>
                              </div>
                              
                              
                          </li>
                        	</c:if>
                        	
                        </c:forEach>
                        </ul>
                       <div id="page-selection"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3"  style="width:350px;float:right;  border-left: 1px solid #D0DADB;margin-left: 15;font-family:'微软雅黑'">
            <div class="" style="padding-left: 10px;font-size:13px;font-family:'微软雅黑';">
              
               <div class=""> 
              	<div style="padding-bottom: 5px;font-size:13px;font-family:'微软雅黑';">置业<span style="width:283px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;/* margin-left:30px; */"></span></div>
	               	<div style="padding-bottom: 5px;font-size:13px;font-family:'微软雅黑';padding-top:5px;"><a href="/ZhiYeInfo" style="display:block;">置业指导</a></div>
	                <div style="font-size:13px;font-family:'微软雅黑';"><a href="/BlogList">新闻博客</a></div>
              </div>
            </div>
            <div class="" style="padding-left: 10px;padding-top: 30px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
				<div style="padding-bottom: 9px;padding-top: 9px;">分类浏览&nbsp;<span style="width: 253px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <select id="type" style="  width: 283px;height: 30px;">
                    <option>请选择一个类别</option>
                    <c:forEach items="${fenleiList}" var="item">
                    	<option <c:if test="${fenlei == item}">selected="selected"</c:if> >${item}</option>
                    </c:forEach>

                </select>
              </div>
            </div>
            <div class="" style="padding-top: 58px;padding-left: 9px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
              	<div style="padding-bottom: 11px;">最新博客文章&nbsp;<span style="width: 228px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <ul class="media-list">

                <c:forEach items="${newslastestList}" var="item" varStatus="status">
                		 <li class="media">
                             <div class="media-left" style="float:left;">
                                <a href="/Detail?id=${item.id}&type=1" target='_blank'>
                                  <img class="media-object" src="<%=application.getInitParameter("imagedir")%>/${item.news_image}" alt="" width="62px" height="46px">
                                </a>
                              </div>
                              <div class="media-body" style="padding-left:10px;padding-top:5px;">
                                <a href="/Detail?id=${item.id}&type=1" target='_blank'><div class="media-heading" style="font-size:13px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">${item.news_title}</div></a>
                                <div style="font-size:11px;">${item.news_people}</div>
                                
                              </div>
                          </li>
                
                </c:forEach>
                         
                         

                        </ul>
              </div>
            </div>
        	<div class="" style="  padding-top: 41px;padding-left: 9px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
              	<div style="padding-bottom: 11px;">置业指导&nbsp;<span style="width: 252px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <ul class="media-list">

                	 <c:forEach items="${lastestList}" var="item" varStatus="status">
                	 	 <li class="media">
                             <div class="media-left" style="float:left;">
                               <a href="/Detail?id=${item.id}&type=0" target='_blank'>
                                  <img class="media-object" src="<%=application.getInitParameter("imagedir")%>/${item.image}" alt=""  width="62px" height="46px">
                                </a>
                              </div>
                              <div class="media-body" style="padding-left:10px;padding-top:5px;">
                                <a href="/Detail?id=${item.id}&type=0" target='_blank'> <div class="media-heading" style="font-size:13px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">${item.title}</div></a>
                                <div style="font-size:11px;">${item.fenlei}</div>
                                
                              </div>
                          </li>
                	 </c:forEach>
                         
                        
                        </ul>
              </div>
            </div>
            <%-- <div class="" style="  padding-top: 41px;padding-left: 9px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
             <div style="padding-bottom: 11px;">置业指导&nbsp;<span style="width: 259px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <ul class="media-list">

                	 <c:forEach items="${lastestList}" var="item" varStatus="status">
                	 	 <li class="media">
                             <div class="media-left" style="float:left;">
                               <a href="/Detail?id=${item.id}&type=0">
                                  <img class="media-object" src="<%=application.getInitParameter("imagedir")%>/${item.image}" alt=""  width="62px" height="46px">
                                </a>
                              </div>
                              <div class="media-body" style="padding-left:10px;padding-top:5px;">
                                <a href="/Detail?id=${item.id}&type=0"> <div class="media-heading" style="font-size:13px;">${item.title}</div></a>
                                <div style="font-size:11px;">${item.fenlei}</div>
                                
                              </div>
                          </li>
                	 </c:forEach>
                         
                        
                        </ul>
              </div>
            </div> --%>
        </div>
        
    </div>
    </div>
    </div>
   <script type="text/javascript">
   var item = <%=flag%>
	    // init bootpag
	    
	    var category="";
   		$(function(){
   			
  			$('#type').change(function(){ 
  				
	  			category=$(this).children('option:selected').val();
	  			
				$.ajax({
                        type: "POST",  
                        dataType: "json", 
                        url: '/NewsBokeFenYe',      //提交到一般处理程序请求数据   
                        data: { pageIndex : 1,type:category},
                        success: function(data) {
                        	/* alert(data) */
                            $("#leftpanel").text(data.start+1+"-"+data.end+"的"+data.total+"篇文章");
                            
                        	var html = getHtml(data.List);
                        	$("#mainlist").html(html);
                        	$('#page-selection').bootpag({
                            	total: data.pageCount,
                            	next:'下一页>',
                            	prev:'<上一页',
                            	/* maxVisible: 0, */
                            	leaps: true    
						    });
                        	scroll(0,0);
                        	var li = $(".pagination").find("li");
                			li.each(function(index, Element){
                					if(index!=0 && index!=li.length-1){
                						$(this).hide();
                					}
                				});
                        },
                        error:function( jqXHR, textStatus,  errorThrown ){
                        	/* alert(jqXHR.status)

                        	alert(jqXHR);
                        	alert(textStatus);
                        	alert(errorThrown); */
                        }
                    }); 
			
			});
	    });
	    
	    $('#page-selection').bootpag({
	    	
	        total: "${pageCount}",
	        next:'下一页',
        	prev:'上一页',
        	/* maxVisible: 0, */
        	leaps: true  
	    }).on("page", function(event, num){
	    	var type = $('#type').val();
	         $.ajax({   
                        type: "POST",  
                        dataType: "json",  
                        url: '/NewsBokeFenYe',      //提交到一般处理程序请求数据   
                        data: { pageIndex : num, type:type},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
                        	alert("feffqwefwe")
	                        count = data.total;
	                        alert(count+"ffff")
	                        $("#leftpanel").text(data.start+1+"-"+data.end+"的"+data.total+"篇文章");
	                 		var html = getHtml(data.List);
	                 		$("#mainlist").html(html);
	                 		scroll(0,0);
	                 		var li = $(".pagination").find("li");
	            			li.each(function(index, Element){
	            					if(index!=0 && index!=li.length-1){
	            						$(this).hide();
	            					}
	            				});
	            			
                     },
                        error:function(data){
                        	alert("fewqeeeeeeeeeeee")
                        }
                        
                  }); 
	         location.hash="#";  
	    });
	    
	    
	    function getHtml(items){
                var html="";
                if(items!=null){
                	for(var j=0;j<items.length;j++){
                	    html+="<li class='media'><div class='media-left'><a href='/Detail?id="+items[j].id+"&type=1' target='_blank'>";
                	    html+="<img class='media-object' src='<%=application.getInitParameter("imagedir")%>/"+items[j].image+"' alt='' width='180px' height='134px'>";
 						html+="</a></div><div class='media-body' style='padding-left:20px;'><div class='media-heading' style='font-size:20px;color:rgb(147,181,219);'><a  href='/Detail?id="+items[j].id+"&type=1' target='_blank'>"+items[j].title;
 						html+="</a></div><p style='font-size:12px;'>"+items[j].news_fenlei;
 						html+="&nbsp;&nbsp;&nbsp;&nbsp;"+items[j].newstime;
 						html+="</p><p style='font-size:12px;'>"+items[j].news_abstract;
 						html+="</p><a href='/Detail?id="+items[j].id+"&type=1' target='_blank'>全文></a></div></li>";
                	}
                }
                else{
                	html="";
                }
              	return html;
        }
	    
	    
	</script>
	<!-- <div class="row" style="width:1190px; margin: 0 auto;height:310px;background-color:rgb(20,51,82);vertical-align:middle;text-align:center;position:relative;">
        <div>
        	<img src="/pic/whiteangle.jpg"></img>
        </div>
        <div style="top: 50%; position: relative;margin-top: -54px;">
            <font style="font-size:25px;font-weight:bold;color:#FFFFFF;">为您提供最好的海外购房服务</font><br><br>
            <div style="  position: relative;left: 50%;margin-left: -43px;background-color: red;height:54px;width:86px;">
            <div style="padding-top: 9%;"><a class="buttton" style="margin-top: 6px;color:white;font-size:25px;font-weight:bold;">注册</a></div>
            </div>
        </div>
        </div>
    </div> -->
	<jsp:include page="zhucefoot.jsp" />
		<jsp:include page="foot4index.jsp" />
    <!--<div class="row" style="height:20px;"></div>-->
   
</body>

</html>
