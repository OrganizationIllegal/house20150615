<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <title>HousePurchasing</title>
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
   <link href="/css/pagination.css" rel="stylesheet">
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
   <script src="/js/jquery.bootpag.min.js"></script>
      	
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
		#panel-left .panel-body{
			padding-right:0px;
			padding-left:0px;
		}
   </style>
</head>
<body style="/* padding-top: 150px; */margin:0 auto;background-color:rgb(232, 233, 234);">
<jsp:include page="head4index.jsp" />
		<div id="head_title" class="row" style="background-color:white;height:102px;border:1px solid #FFE4E1;margin-left: auto;margin-right:auto;width:1190px;">
            <div class="col-md-1"  style="width:142px;float:left;padding-left:0px;padding-right:0px;"></div>
            <div class="" style="font-size:24px;height:100%;padding-left:0px;">
            <div style="margin-top: 25px; margin-left:142px;">
            <c:choose>
            	<c:when test="${type==0}">
            		<div style="font-family:微软雅黑; font-size:22px;color:black;font-weight:normal; ">${zhiYeDetail.title }</div>
            		<div style="padding-left: 0px;font-size:12px;color:grey;width:300px;padding-top:5px;">添加时间：${fn:substring(zhiYeDetail.fabu_time,0,10)}</div>
            	</c:when>
            	<c:otherwise>
            		<div style="font-family:微软雅黑; font-size:22px;color:black;font-weight:normal; ">${newsBokeDetail.news_title }</div>
            		<div style="padding-left: 0px;font-size:12px;color:grey;width:300px;padding-top:5px;">添加时间：${fn:substring(newsBokeDetail.news_time,0,10)}</div>
            	</c:otherwise>
            </c:choose>
            </div>
            </div>
        </div>
          
        <div class="row" style="padding-top:25px;margin-left: auto;margin-right:auto;width:1190px;background-color:rgb(247,248,250)">
            <div class="col-md-1" style="width:142px;float:left;padding-left:0px;padding-right:0px;"></div>
            <div class="col-md-7" style="width:601px;float:left;">
                <div class="row">
                    <div id="panel-left" class="main">
                        <div class="panel-heading" id="leftpanel" style="font-weight: bold;display:none;">1-${pageCount}的${total}篇文章</div>
                      <div class="panel-body">
                        <ul class="media-list" id="mainlist">

                        
                          <li class="media">
                          <c:choose>
            	<c:when test="${type==0}">
            		<img src="<%=application.getInitParameter("imagedir")%>/${zhiYeDetail.image}" width="601px" height="373px">
            	</c:when>
            	<c:otherwise>
            		<img src="<%=application.getInitParameter("imagedir")%>/${newsBokeDetail.news_image}" width="601px" height="373px">
            	</c:otherwise>
            </c:choose>
                            
                          
                          </li>
                        
                        <li class="media" style="margin-top:30px;font-size:13px;">
                           <span>
	                            <c:choose>
			                        <c:when test="${type==0}">
			            				${zhiYeDetail.detail}
			            			</c:when>
			            			<c:otherwise>
			            				${newsBokeDetail.news_detail}
			            			</c:otherwise>
			            		</c:choose>
                           	</span>
                          
                          </li>
                         </li><li class="media">
                           <a href="/BlogList?type='退税技巧'" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1); font-size: 13px;padding-right: 10px;text-decoration: underline;">退税技巧</span></a>
                            <a href="/BlogList?type='房地产'" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1); font-size: 13px;padding-right: 10px;text-decoration: underline;">个人投资</span></a>
                         		<a href="/BlogList?type='市场'" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1);font-size: 13px;padding-right: 10px;text-decoration: underline; ">房地产</span></a>
                         <a href="/BlogList?type=''" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1); font-size: 13px;padding-right: 10px;text-decoration: underline;">市场</span></a>
                          </li>
                        
                         </li><li class="media" style="margin-top:15px;">
                         
                          <!--  <a href="/BlogList" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1);font-size:12px; ">←返回到所有博客文章</span></a> -->
                          <c:choose>
            	<c:when test="${type==0}">
            		<a href="/ZhiYeInfo" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1);font-size:12px; ">←返回到所有置业指导</span></a>
            	</c:when>
            	<c:otherwise>
            		<a href="/BlogList" target="_blank"><span style="font-family:微软雅黑; color:rgba(140, 181, 225, 1);font-size:12px; ">←返回到所有博客文章</span></a>
            	</c:otherwise>
            </c:choose>
                          </li>
                        
                        
                        
                        </ul>
                        <div id="page-selection"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3" style="width:410px;float:left;  border-left: 1px solid #D0DADB;margin-left: 15;font-family:'微软雅黑'">
            <div class="" style="padding-left: 0px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
              	<div style="padding-bottom: 5px;font-size:13px;font-family:'微软雅黑';">置业<span style="width: 230px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;margin-left:30px;"></span></div>
	               	<div style="padding-bottom: 5px;font-size:13px;font-family:'微软雅黑';padding-top:5px;"><a href="/ZhiYeInfo" style="display:block;">置业指导</a></div>
	                <div style="font-size:13px;font-family:'微软雅黑';"><a href="/BlogList">新闻博客</a></div>
              </div>
            </div>
            <div class="" style="padding-left: 0px;padding-top: 30px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
				<div style="padding-bottom: 9px;padding-top: 9px;">分类浏览&nbsp;<span style="width: 230px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <select id="type" style="  width: 283px;height: 30px;">
                    <option>请选择一个类别</option>
                    <c:choose>
                        <c:when test="${type==0}">
            				<c:forEach items="${zhiye_fenleiList}" var="item">
		                    	<option>${item}</option>
		                    </c:forEach>
            			</c:when>
            			<c:otherwise>
            				<c:forEach items="${new_fenleiList}" var="item">
		                    	<option>${item}</option>
		                    </c:forEach>
            			</c:otherwise>
            		</c:choose>
                    

                </select>
              </div>
            </div>
            <div class="" style="padding-top: 58px;padding-left: 0px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
              	<div style="padding-bottom: 11px;">最新新闻博客&nbsp;<span style="width: 205px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <ul class="media-list">

                <c:forEach items="${newsList}" var="item" varStatus="status">
                		 <li class="media">
                             <div class="media-left" style="float:left;">
                                <a href="/Detail?id=${item.id}&type=1">
                                  <img class="media-object" src="<%=application.getInitParameter("imagedir")%>/${item.news_image}" alt=""  width="62px" height="46px">
                                </a>
                              </div>
                              <div class="media-body" style="padding-left:10px;padding-top:5px;">
                                <a href="/Detail?id=${item.id}&type=1"><div class="media-heading" style="font-size:13px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">${item.news_title}</div></a>
                                <div style="font-size:11px;">${item.news_people}</div>
                                
                              </div>
                          </li>
                
                </c:forEach>
                         
                         

                        </ul>
              </div>
            </div>
            
            <div class="" style="  padding-top: 41px;padding-left: 0px;font-size:13px;font-family:'微软雅黑';">
              
              <div class=""> 
              	<div style="padding-bottom: 11px;">最新置业指导&nbsp;<span style="width: 259px;height: 1px;background-color: rgb(229, 216, 216);display: inline-block;margin-bottom: 5px;"></span></div>
                <ul class="media-list">

                	 <c:forEach items="${lastestList}" var="item" varStatus="status">
                	 	 <li class="media">
                             <div class="media-left" style="float:left;">
                               <a href="/Detail?id=${item.id}&type=0">
                                  <img class="media-object" src="<%=application.getInitParameter("imagedir")%>/${item.image}" alt=""  width="62px" height="46px">
                                </a>
                              </div>
                              <div class="media-body" style="padding-left:10px;padding-top:5px;">
                                <a href="/Detail?id=${item.id}&type=0"> <div class="media-heading" style="font-size:13px;white-space: nowrap;overflow: hidden;text-overflow: ellipsis;">${item.title}</div></a>
                                <div style="font-size:11px;">${item.fenlei}</div>
                                
                              </div>
                          </li>
                	 </c:forEach>
                         
                        
                        </ul>
              </div>
            </div>
            </div>
        </div>
        
    </div>
   
   


  <jsp:include page="zhucefoot.jsp" />
  	<jsp:include page="foot4index.jsp" />
  
   
</body>

</html>



<script type="text/javascript">

var typeInfo = "${type}";
	    // init bootpag
	    var category="";
   		$(function(){
   			var titleHtml = "<div style='width:980px;font-size:24px;line-height:70px;height:100%;font-weight:bold;margin:0 auto;'>置业指导</div>";
   			var titleHtml1 = "<div style='width:980px;font-size:24px;line-height:70px;height:100%;font-weight:bold;margin:0 auto;'>新闻博客</div>";
   			//$("#leftpanel").show();
   			//$(".main").attr("id","mainlist");
  			$('#type').change(function(){ 
  				$("#leftpanel").show();
  				var html = "";
	  			category=$(this).children('option:selected').val();
				$.ajax({
                        type: "POST",  
                        dataType: "json",  
                        url: '/DetailFenYe',      //提交到一般处理程序请求数据   
                        data: { pageIndex : 1,type:category, typeInfo:typeInfo},
                        success: function(data) {
                        	
                        	if(typeInfo==0){
                        		$("#head_title").html(titleHtml);
                        	}
                        	else{
                        		$("#head_title").html(titleHtml1);
                        	}
                        	
                            $("#leftpanel").text("1-"+data.pageCount+"的"+data.total+"篇文章");
                            
                        	
                        	if(typeInfo==0){
                        		html = getHtml(data.List);
                        		
                        	}
                        	else{
                        		html = getHtml1(data.List);
                        	}
                        	$("#mainlist").html(html);
                        	$('#page-selection').bootpag({
                            	total: data.pageCount,
                            	next:'下一页>',
                            	prev:'<上一页',
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
                        error:function(a,b,c){
								/* alert(a);
								alert(b);
								alert(c); */
                            }  
                    }); 
			
			});
	    });
	    
	    $('#page-selection').bootpag({
	        total: "${pageCount}",
	        next:'下一页>',
        	prev:'<上一页',
        	page:1
	    }).on("page", function(event, num){
	    
	         $.ajax({   
                        type: "POST",  
                        dataType: "json",  
                        url: '/ZhiYeFenYe',      //提交到一般处理程序请求数据   
                        data: { pageIndex : num},
                        //data: "pageIndex=" + (pageIndex) + "&pageSize=" + pageSize,          //提交两个参数：pageIndex(页面索引)，pageSize(显示条数)                   
                        success: function(data) {
	                        count = data.total;
	                 		var html = getHtml(data.List);
	                        $("#mainlist").html(html);
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
	    
	    
	    function getHtml(items){      //职业指导
                var html="";
                if(items!=null){
                	for(var j=0;j<items.length;j++){
                	    html+="<li class='media'><div class='media-left'><a href='/Detail?id="+items[j].id+"&type=0'>";
                	    html+="<img class='media-object' src='<%=application.getInitParameter("imagedir")%>/"+items[j].image+"' alt='' width='180px' height='134px'>";
 						html+="</a></div><div class='media-body' style='padding-left:20px;'><div class='media-heading' style='font-size:20px;color:rgb(147,181,219);'><a href='/Detail?id="+items[j].id+"&type=0'>"+items[j].title;
 						html+="</a></div><p style='font-size:12px;'>"+items[j].fenlei;
 						html+="&nbsp;&nbsp;&nbsp;&nbsp;"+items[j].fabu_time;
 						html+="</p><p style='font-size:12px;'>"+items[j].zhiye_abstract;			
 						html+="</p><a href='/Detail?id="+items[j].id+"&type=0'>全文></a></div></li>";
 						
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
            	    html+="<li class='media'><div class='media-left'><a href='/Detail?id="+items[j].id+"&type=1'>";
            	    html+="<img class='media-object' src='<%=application.getInitParameter("imagedir")%>/"+items[j].image+"' alt='' width='180px' height='134px'>";
						html+="</a></div><div class='media-body' style='padding-left:20px;'><div class='media-heading' style='font-size:20px;color:rgb(147,181,219);'><a  href='/Detail?id="+items[j].id+"&type=1'>"+items[j].title;
						html+="</a></div><p style='font-size:12px;'>"+items[j].news_fenlei;
						html+="&nbsp;&nbsp;&nbsp;&nbsp;"+items[j].newstime;
						html+="</p><p style='font-size:12px;'>"+items[j].news_abstract;
						html+="</p><a href='/Detail?id="+items[j].id+"&type=1'>全文></a></div></li>";
            	}
            }
            else{
            	html="";
            }
          	return html;
    }
	    
	</script>
	
	
	