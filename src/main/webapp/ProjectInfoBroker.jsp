<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Service Protocol</title>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />  -->
<!-- <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/projectLuru.css" />
<!-- <link rel="stylesheet" type="text/css" href="uploadify/uploadify.css" /> -->

<script src="/js/jquery.min.js"></script>
<!-- <script src="/bootstrap/js/bootstrap.min.js"></script> -->
<!-- <script src="uploadify/jquery.uploadify.js"></script> -->


<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <link href="/css/default.css" rel="stylesheet">
   <link rel="stylesheet" type="text/css" href="css/base.css" />
   <link rel="stylesheet" type="text/css" href="css/main.css" />
  
    <!-- <script src="/js/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script> -->
<script src="/ckeditor/ckeditor.js"></script>
  <link rel="stylesheet" href="css/chosen.css">
  <link rel="stylesheet" type="text/css" href="/bootstrap-datepicker-1.4.0-dist/css/bootstrap-datepicker.min.css" />
  <script src="/bootstrap-datepicker-1.4.0-dist/js/bootstrap-datepicker.min.js"></script>
  <script src="/bootstrap-datepicker-1.4.0-dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>

<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
.imageselect{
	width:700px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;
}
</style>

</head>
<body>
<!-- action="/projectinput" method="post"  enctype="multipart/form-data" -->
<div>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:项目录入</div>
<!-- ****************************************************项目信息start***************************************************** -->

<form id="project">
<div class="area_bkg2" id="projectinfo">项目信息</div>
<div class="area_left">
<span class="area_span">项目编号</span><span><input type="text" id="project_code" name="project_code" class="area_input" value="${houseProject.project_num}"  readonly="readonly">
<input type="hidden" id="id" name="id" class="area_input" value="${houseProject.id}"></span>
</div>
<div class="area_right">
<span class="area_span">项目名称</span><span><input type="text" id="project_name" name="project_name" class="area_input" value="${houseProject.project_name}"></span>
</div>
<div class="area_left">
<span class="area_span">项目视频链接</span><span><input type="text" id="project_video" name="project_video" class="area_input" value="${houseProject.project_vedio}"></span>
</div>
<div class="area_right">
<span class="area_span">项目GPS</span><span><input type="text" id="GPS" name="GPS" class="area_input" value="${houseProject.gps}"></span>
</div>
<div class="area_left">
<span class="area_span">项目所在国家</span>
<span>
<%-- <input type="text" id="project_nation" name="project_nation" class="area_input" value="${houseProject.project_nation}"> --%>
<select data-placeholder="请选择..." class="chosen-select" id="project_nation" name="project_nation" style="width:220px;" tabindex="4">
 	 <option value=""></option>
      <c:choose>
	    <c:when test="${houseProject.project_nation eq 'Australia 澳大利亚'}">
	      <option value="Australia 澳大利亚" selected="selected">Australia 澳大利亚</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Australia 澳大利亚">Australia 澳大利亚</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_nation eq 'Canada 加拿大'}">
	      <option value="Canada 加拿大" selected="selected">Canada 加拿大</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Canada 加拿大">Canada 加拿大</option>
	   </c:otherwise>
  	  </c:choose>
 </select>
</span>
</div>

<div class="area_right">
<span class="area_span">项目所在州/省</span>
<span>
<%-- <input type="text" id="project_zhou" name="project_zhou" class="area_input" value="${houseProject.project_zhou}"> --%>
<select data-placeholder="请选择..." class="chosen-select" id="project_zhou" name="project_zhou" style="width:220px;" tabindex="4">
 	 <option value=""></option>
      <c:choose>
	    <c:when test="${houseProject.project_zhou eq 'VIC 维多利亚州'}">
	      <option value="VIC 维多利亚州" selected="selected">VIC 维多利亚州</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="VIC 维多利亚州">VIC 维多利亚州</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${houseProject.project_zhou eq 'QLD 昆士兰州'}">
	      <option value="QLD 昆士兰州" selected="selected">QLD 昆士兰州</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="QLD 昆士兰州">QLD 昆士兰州</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_zhou eq 'NSW 新南威尔士州'}">
	      <option value="NSW 新南威尔士州" selected="selected">NSW 新南威尔士州</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="NSW 新南威尔士州">NSW 新南威尔士州</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_zhou eq 'WA 西澳大利亚'}">
	      <option value="WA 西澳大利亚" selected="selected">WA 西澳大利亚</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="WA 西澳大利亚">WA 西澳大利亚</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_zhou eq 'SA 南澳大利亚'}">
	      <option value="SA 南澳大利亚" selected="selected">SA 南澳大利亚</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="SA 南澳大利亚">SA 南澳大利亚</option>
	   </c:otherwise>
  	  </c:choose>
  	    <c:choose>
	    <c:when test="${houseProject.project_zhou eq 'TAS 塔斯马尼亚州'}">
	      <option value="TAS 塔斯马尼亚州" selected="selected">TAS 塔斯马尼亚州</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="TAS 塔斯马尼亚州">TAS 塔斯马尼亚州</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_zhou eq 'CAN 堪培拉'}">
	      <option value="CAN 堪培拉" selected="selected">CAN 堪培拉</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="CAN 堪培拉">CAN 堪培拉</option>
	   </c:otherwise>
  	  </c:choose>
 </select>
</span>
</div>
<div class="area_left">
<span class="area_span">项目所在城市</span>
<span>
 <input type="text" id="project_city" name="project_city" class="area_input" value="${houseProject.project_city}"> 
<%-- <select data-placeholder="请选择..." class="chosen-select" id="project_city" name="project_city" style="width:220px;" tabindex="4">
 	 <option value=""></option>
       <c:choose>
	    <c:when test="${houseProject.project_city eq 'Sydney 悉尼'}">
	      <option value="Sydney 悉尼" selected="selected">Sydney 悉尼</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Sydney 悉尼">Sydney 悉尼</option>
	   </c:otherwise>
  	  </c:choose>
  	    <c:choose>
	    <c:when test="${houseProject.project_city eq 'Melbourne 墨尔本'}">
	      <option value="Melbourne 墨尔本" selected="selected">Melbourne 墨尔本</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Melbourne 墨尔本">Melbourne 墨尔本</option>
	   </c:otherwise>
  	  </c:choose>
  	    <c:choose>
	    <c:when test="${houseProject.project_city eq 'Brisbane 布里斯班'}">
	      <option value="Brisbane 布里斯班" selected="selected">Brisbane 布里斯班</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Brisbane 布里斯班">Brisbane 布里斯班</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_city eq 'Perth 珀斯'}">
	      <option value="Perth 珀斯" selected="selected">Perth 珀斯</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Perth 珀斯">Perth 珀斯</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_city eq 'Canberra 堪培拉'}">
	      <option value="Canberra 堪培拉" selected="selected">Canberra 堪培拉</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Canberra 堪培拉">Canberra 堪培拉</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_city eq 'Adelaide 阿德莱得'}">
	      <option value="Adelaide 阿德莱得" selected="selected">Adelaide 阿德莱得</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Adelaide 阿德莱得">Adelaide 阿德莱得</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_city eq 'Cairns 凯恩斯'}">
	      <option value="Cairns 凯恩斯" selected="selected">Cairns 凯恩斯</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Cairns 凯恩斯">Cairns 凯恩斯</option>
	   </c:otherwise>
  	  </c:choose>
 </select> --%>
</span>
</div>
<div class="area_right">
<span class="area_span">项目所在地区</span><span><input type="text" id="project_area" name="project_area" class="area_input" value="${houseProject.project_area}"></span>
</div>
<div class="duoarea_left">
<span class="duoarea_span" >项目所在地址</span><span><textarea id="project_address" name="project_address" class="duoarea_input">${houseProject.project_address}</textarea></span>
</div>
<div class="area_right">
<span class="area_span">项目类型</span>
<span>
<%-- <select class="area_select" id="project_type" name="project_type">
  <option >${houseProject.project_type}</option>
</select> --%>
<select data-placeholder="请选择..." class="chosen-select"  id="project_type" name="project_type" style="width:220px;" tabindex="4">
	 <%-- <option value="${houseProject.project_type}">${houseProject.project_type}</option> --%>
	<!--   <option value=""></option>
  	 <option value="公寓">公寓</option>
     <option value="別墅">别墅</option>
     <option value="聯排別墅">联排别墅</option> -->
     <option value=""></option>
     <c:choose>
	    <c:when test="${houseProject.project_type eq '公寓'}">
	      <option value="公寓" selected="selected">公寓</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="公寓">公寓</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${houseProject.project_type eq '别墅'}">
	      <option value="别墅" selected="selected">别墅</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="别墅">别墅</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${houseProject.project_type eq '联排别墅' }">
	      <option value="联排别墅" selected="selected">联排别墅</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="联排别墅">联排别墅</option>
	   </c:otherwise>
  	  </c:choose>
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">户型</span><span><input type="text" id="house_type" name="house_type" class="area_input" value="${houseProject.project_house_type}"></span>
</div>
<div class="area_left">
<span class="area_span">项目完成时间</span>
<span>
<%-- <c:if test="${empty houseProject.project_finish_time }"> <input type="text" id="finish_time" name="finish_time" class="area_input"  value="待定"></c:if>
<c:if test="${not empty houseProject.project_finish_time}"><input type="text" id="finish_time" name="finish_time" class="area_input"  value="${houseProject.project_finish_time.length()>7?houseProject.project_finish_time.toString().substring(0,7):Invest.touzi_date.toString()}"></c:if> --%>
<input type="text" id="finish_time" name="finish_time" class="area_input"  value="${houseProject.project_finish_time}">
</span>
</div>
<div class="area_right">
<span class="area_span">可售套数</span><span><input type="text" id="keshou" name="keshou" class="area_input" value="${houseProject.project_sales_remain}"></span>
</div>
<div class="area_left">
<span class="area_span">步行指数</span><span><input type="text" id="walk_num" name="walk_num" class="area_input" value="${houseProject.walk_num}"></span>
</div>
<div class="area_right">
<span class="area_span">层数</span><span><input type="text" id="ceng" name="ceng" class="area_input" value="${houseProject.project_high}"></span>
</div>
<div class="area_left">
<span class="area_span">推荐度</span><span><input type="text" id="tuijian" name="tuijian" class="area_input" value="${houseProject.tuijiandu}"></span>
</div>
<div class="area_right">
<span class="area_span">面积单位</span><span><%-- <input type="text" id="mianji" name="mianji" class="area_input" value="${houseProject.mianji}"></span> --%>
<select data-placeholder="请选择..." class="chosen-select" id="mianji" name="mianji" style="width:220px;" tabindex="4">
    <option value=""></option>
     <c:choose>
	    <c:when test="${houseProject.mianji eq '平米'}">
	      <option value="平米" selected="selected">平米</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="平米">平米</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${houseProject.mianji eq '英尺'}">
	      <option value="英尺" selected="selected">英尺</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="英尺">英尺</option>
	   </c:otherwise>
  	  </c:choose>
 </select>
</div>
<div class="area_left">
<span class="area_span">最小面积</span><span><input type="text" id="minarea" name="minarea" class="area_input" value="${houseProject.min_area}"></span>
</div>
<div class="area_right">
<span class="area_span">最大面积</span><span><input type="text" id="maxarea" name="maxarea" class="area_input" value="${houseProject.max_area}"></span>
</div>
<div class="area_left">
<span class="area_span">单价（起价）</span><span><input type="text" id="danjia" name="danjia" class="area_input" value="${houseProject.project_price_int_qi}"></span>
</div>
<div class="area_right">
<span class="area_span">返利</span><span><input type="text" id="return_money" name="return_money" class="area_input" value="${houseProject.return_money}"></span>
</div>
<div class="area_left">
<span class="area_span">最低价格</span><span><input type="text" id="minprice" name="minprice" class="area_input" value="${houseProject.project_min_price}"></span>
</div>
<div class="area_right">
<span class="area_span">最高价格</span><span><input type="text" id="maxprice" name="maxprice" class="area_input" value="${houseProject.project_high_price}"></span>
</div>
<div class="duoarea_left">
<span class="duoarea_span">项目一句话（中文）</span><span><textarea id="project_lan_an" name="project_lan_an" class="duoarea_input">${houseProject.project_lan_cn}</textarea></span>
</div>
<div class="duoarea_right">
<span class="duoarea_span">项目一句话（英文）</span><span><textarea id="project_lan_en" name="project_lan_en" class="duoarea_input">${houseProject.project_lan_en}</textarea></span>
</div>
<div class="duoarea_left2">
<span class="duoarea_span">项目描述</span><span><textarea id="project_desc" name="project_desc" class="duoarea_input2">${houseProject.project_desc}</textarea></span>
</div>

<div class="area_left">
<span class="area_span">更新时间</span><span><input type="text" id="update_time" name="update_time" class="area_input"  value="${houseProject.housePrice_update_time.toString().length()>10?houseProject.housePrice_update_time.toString().substring(0,10):houseProject.housePrice_update_time.toString()}"></span>
</div>
<div class="area_right">
<span class="area_span">所属区域</span><span><input type="text" id="area_num" name="area_num" class="area_input" value="${houseProject.area_num}"></span>
</div>
<%-- <div class="area_left">
<span class="area_span">购房税费说明</span><span><input type="text" id="buyTaxInfo" name="buyTaxInfo" class="area_input" value="${houseProject.buytaxInfo}"></span>
</div>
<div class="area_right">
<span class="area_span">持有成本说明</span><span><input type="text" id="holdCostInfo" name="holdCostInfo" class="area_input" value="${houseProject.holdInfo}"></span>
</div>
 --%>
 </form> 
<!-- ****************************************************项目信息end***************************************************** -->

<!-- ****************************************************开发商信息start***************************************************** -->

<form id="developer">
<div class="area_bkg2" style="clear:both;" id="developerinfo">开发商信息</div>
<div class="area_left" style="width:900px">
<span class="area_span">开发商编号</span>
<span>
<%-- <select class="area_select" id="developer_code" name="developer_code" style="width:670px">
				 <option value="${houseProject.developer_id_name}"></option>
				 <option value="请选择">请选择</option>
         <c:forEach items="${codeAndNameSet}" var="item">
        		 <option>${item}</option>
       	      </c:forEach>
</select> --%>
 <select data-placeholder="请选择..." class="chosen-select" id="developer_code" name="developer_code" style="width:670px;" tabindex="4">
   <option value=""></option>
  	<c:forEach items="${codeAndNameSet}" var="item">
	  <c:choose>
	    <c:when test="${item == houseProject.developer_id_name}">
	      <option value="${item}" selected="selected">${item}</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="${item}">${item}</option>
	   </c:otherwise>
  	  </c:choose>
    </c:forEach>
 </select>
</span>
</div>
</form>


<!-- ****************************************************开发商信息end***************************************************** -->

<!-- ****************************************************户型及价格start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="housetypeinfo">户型及价格</div>
<form id="huxingjiage">
<div class="area_left">
<span class="area_span">户型名称</span><span><input type="text" id="housename" name="housename" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">户型价格</span><span><input type="text" id="houseprice" name="houseprice" class="area_input"></span>
</div>
<!-- <div class="chang_left2">
<span class="area_span">户型图片</span><span><input type="text" id="houseimg" name="houseimg" class="chang_input2"></span>
</div> -->
<div class="area_left"  style="width:900px">
 <!-- <input type="file" name="houseimg" id="houseimg" style="width:700px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#">上传</a> -->
	<input type="text" id="file1" style="float:left;width:580px;border:1px solid rgb(239,235,242);"><input type="button" id="file2" value="浏览">
	<input type="file" name="houseimg" id="houseimg"  style="width:620px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;display:none;"/><!-- <a href="#"  onclick="upload()">上传</a> -->
	
</div>
<div class="area_left">
<span class="area_span">卧室数量</span><span><input type="text" id="room_num" name="room_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">土地面积</span><span><input type="text" id="tudi_mianji" name="tudi_mianji" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">建筑面积</span><span><input type="text" id="jianzhu_mianji" name="jianzhu_mianji" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">室内面积</span><span><input type="text" id="shinei_mianji" name="shinei_mianji" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">室外面积</span><span><input type="text" id="shiwai_mianji" name="shiwai_mianji" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">卫生间数量</span><span><input type="text" id="wc_num" name="wc_num" class="area_input"></span>
</div>
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addhuxing">添加</a></div>
</form>
<div id="huxingjiagelist">

<c:forEach items="${houseInfoList}" var="houseinfo" varStatus="status">
<div>
<span >${status.index + 1}</span>
<input type="hidden" value="${houseinfo.id} "/>
<span>${houseinfo.housename}</span>
<span>${houseinfo.houseprice}</span>
<span>${houseinfo.houseimg}</span>
<span>
<a href="#" style="padding-right:10px;" class="editpeitao">编辑</a><a href="#" class="deletepeitao">删除</a>
</span>
</div>		
</c:forEach>

</div>
<!-- ****************************************************项目图片start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="projectimages">项目图片</div>

<div class="area_left"  style="width:900px;height:auto;">
<div id="some_queue" style="width:700px;height:auto;"></div>
 <input type="file" name="oneimage" id="oneimage"  multiple  style="width:700px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#" class="addimage">添加</a>
 
<div id="imagelist">
 <c:forEach items="${projectImageList}" var="projectImage" varStatus="status">
<div style='float:left;padding-left:40px;'>
<span style='padding-right:10px;'>${status.index + 1}</span>
<input type="hidden" value="${projectImage.id} "/>
<span class=''>${projectImage.name}</span>
<span style='padding-left: 30px;padding-right: 40px;'><a href='#' class='deletepeitao'>删除</a></span>
</div>
</c:forEach>
</div>
</div>


<!-- ****************************************************项目图片end***************************************************** -->

<!-- ****************************************************项目配套start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="projectpeitao">项目配套</div>

<div class="area_left"  style="width:900px;height:auto;">
<div id="some_queue" style="width:700px;height:auto;"></div>
 <input type="file" name="projectimage" id="projectimage"  multiple  style="width:700px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#" class="addpeitao">添加</a>
 
<div id="peitaolist">
 <c:forEach items="${projectPeitaoList}" var="projectpeitao" varStatus="status">
<div style='float:left;padding-left:40px;'>
<span style='padding-right:10px;'>${status.index + 1}</span>
<input type="hidden" value="${projectpeitao.id} "/>
<span class=''>${projectpeitao.name}</span>
<span style='padding-left: 30px;padding-right: 40px;'><a href='#' class='deletepeitao'>删除</a></span>
</div>
</c:forEach>
</div>
 </div>



<!-- ****************************************************项目配套end***************************************************** -->

<!-- ****************************************************附近配套start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="nearpeitao">附近配套</div>
<form id="fujin">
<div class="area_left">
<span class="area_span">配套类型</span><span><input type="text" id="peitao_type" name="peitao_type" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">配套名称</span><span><input type="text" id="peitao_name" name="peitao_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">配套距离</span><span><input type="text" id="peitao_distance" name="peitao_distance" class="area_input"></span>
</div>
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addfujin">添加</a></div>
</form>
<div id="fujinlist">
<c:forEach items="${fujinPeitaoList}" var="fujinPeiTao" varStatus="status">
<div style='float:left;padding-left:40px;'>
<span style='padding-right:10px;'>${status.index + 1}</span>
<input type="hidden" value="${fujinPeiTao.id} "/>
<span style='padding-right:10px;'>${fujinPeiTao.peitao_type}</span>
<span style='padding-right:10px;'>${fujinPeiTao.peitao_name.toString().replace("+"," ")}</span>
<span style='padding-right:10px;'>${fujinPeiTao.peitao_distance}</span>
<span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span>
</div>
</c:forEach>
</div>
<!-- ****************************************************附近配套end***************************************************** -->

<!-- ****************************************************附近学校start***************************************************** -->
<div class="area_bkg2" style="clear:both;" id="nearschool">附近学校</div>
<form id="school">
<div class="area_left">
<span class="area_span">学校名称</span>
<span>
<select data-placeholder="请选择..." class="chosen-select"  style="width:220px;" tabindex="4" id="school_name" name="school_name">
	<option value=""></option>
 	  <c:forEach items="${schoolList}" var="item">
        		 <option value="${item}">${item}</option>
      </c:forEach> 
</select> 
</span>
<!-- <span><input type="text" id="school_name" name="school_name" class="area_input"></span> -->
</div>
<div class="area_right">
<span class="area_span">学校距离</span><span><input type="text" id="school_distance" name="school_distance" class="area_input"></span>
</div>
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addschool">添加</a></div>
</form>
<div id="schoollist">

 <c:forEach items="${fujinSchoolList}" var="fujinSchool" varStatus="status">
 <div style='float:left;padding-left:40px;'>
<span style='padding-right:10px;'>${status.index + 1}</span>
<input type="hidden" value="${fujinSchool.id} "/>
<span style='padding-right:10px;'>${fujinSchool.school_name}</span>
<span style='padding-right:10px;'>${fujinSchool.school_distance}</span>
<span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span>
</div>
</c:forEach>

<!-- <div style='float:left;padding-left:40px;'>
<span style='padding-right:10px;'>"+(++schoolcount)+"</span>
<span style='padding-right:10px;'>"+schoollist[schoolcount-1].school_name+"</span>
<span style='padding-right:10px;'>"+schoollist[schoolcount-1].school_distance+"</span>
<span style='padding-left: 30px;padding-right: 40px;'>
<a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a>
<a href='#' class='deletepeitao'>删除</a>
</span>
</div> -->

</div>

<!-- ****************************************************附近学校end***************************************************** -->

<!-- ****************************************************持有成本start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="holdcost">持有成本</div>
<form id="holdingcost">
<div class="area_left">
<span class="area_span">类型</span>
<span>
<!-- <input type="text" id="holdcosttype" name="holdcosttype" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="holdcosttype" name="holdcosttype" style="width:220px;" tabindex="4">
 	 <option value=""></option>
  	 <option value="物业费">物业费</option>
     <option value="市政费">市政费</option>
     <option value="污水费">污水费</option>
      <option value="租赁管理费">租赁管理费</option>
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">价格</span><span><input type="text" id="holdcostprice" name="holdcostprice" class="area_input"></span>
</div>
<div class="chang_left2">
<span class="area_span">描述</span><span><input type="text" id="holdcostdesc" name="holdcostdesc" class="chang_input2"></span>
</div>
<!-- <div class="area_left">
<span class="area_span">户型名称</span><span><input type="text" id="holdcost_housename" name="holdcost_housename" class="area_input"></span>
</div> -->
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addholdingcost">添加</a></div>
</form>
<div id="holdingcostlist">
 <c:forEach items="${holdCostList}" var="holdCost" varStatus="status">
<div style='float:left;padding-left:40px;'>
<span style='padding-right:10px;'>${status.index + 1}</span>
<input type="hidden" value="${holdCost.id} "/>
<span style='padding-right:10px;'>${holdCost.holdcosttype}</span>
<span style='padding-right:10px;'>${holdCost.holdcostprice}</span>
<span style='padding-right:10px;'>${holdCost.holdcostdesc}</span>
<span style='padding-left: 30px;padding-right: 40px;'>
<a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a>
<a href='#' class='deletepeitao'>删除</a>
</span>
</div>
</c:forEach>




</div>
<!-- ****************************************************持有成本end***************************************************** -->

<!-- ****************************************************购房税费start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="housetax">购房税费</div>
<form id="housetaxform">
<div class="area_left">
<span class="area_span">类型</span><span><!-- <input type="text" id="houseTaxtype" name="houseTaxtype" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="houseTaxtype" name="houseTaxtype" style="width:220px;" tabindex="4">
 	 <option value=""></option>
  	 <option value="印花税">印花税</option>
     <option value="律师费">律师费</option>
     <option value="交割费">交割费</option>
     <option value="保险费">保险费</option>
     <option value="土地税">土地税</option>
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">价格</span><span><input type="text" id="houseTaxprice" name="houseTaxprice" class="area_input"></span>
</div>
<div class="chang_left2">
<span class="area_span">描述</span><span><input type="text" id="houseTaxdesc" name="houseTaxdesc" class="chang_input2"></span>
</div>
<!-- <div class="area_left">
<span class="area_span">户型名称</span><span><input type="text" id="houseTax_housename" name="houseTax_housename" class="area_input"></span>
</div> -->
<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addhousetaxform">添加</a></div>
</form>
<div id="housetaxformlist">
 <c:forEach items="${houseTaxList}" var="houseTax" varStatus="status">
<div style='float:left;padding-left:40px;'>
<span style='padding-right:10px;'>${status.index + 1}</span>
<input type="hidden" value="${houseTax.id} "/>
<span style='padding-right:10px;'>${houseTax.houseTaxtype}</span>
<span style='padding-right:10px;'>${houseTax.houseTaxprice}</span>
<span style='padding-right:10px;'>${houseTax.houseTaxdesc}</span>
<span style='padding-left: 30px;padding-right: 40px;'>
<a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a>
<a href='#' class='deletepeitao'>删除</a>
</span>
</div>
</c:forEach>

</div>
<!-- ****************************************************项目关键字start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="projectkey11">项目关键字</div>
<form id="projectkey">
<div class="area_left" style="margin-left:150px;width:550px">
<input type="hidden" id="keyid" value="${key.id}"/>
<c:if test="${key.xinkaipan=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="xinkaipan"  checked="true"/>
</c:if>
<c:if test="${key.xinkaipan=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="xinkaipan" />
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">新开盘</a>

<c:if test="${key.remen=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="remen"  checked="true"/>
</c:if>
<c:if test="${key.remen=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="remen" />
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">热门项目</a>

<c:if test="${key.xuequ=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="xuequ"  checked="true"/>
</c:if>
<c:if test="${key.xuequ=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="xuequ"/>
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">优秀学区</a>

<c:if test="${key.center=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="center" checked="true" />
</c:if>
<c:if test="${key.center=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="center"  />
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">城市中心</a>

<c:if test="${key.baozu=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="baozu"  checked="true"/>
</c:if>
<c:if test="${key.baozu=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="baozu"  />
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">包租项目</a>
</div>
<div class="area_left" style="margin-left:150px;width:550px">
<c:if test="${key.huaren=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="huaren"  checked="true"/>
</c:if>
<c:if test="${key.huaren=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="huaren" />
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">华人区</a>

<c:if test="${key.maidi=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="maidi"   checked="true"/>
</c:if>
<c:if test="${key.maidi=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="maidi"/>
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">最新项目</a>

<c:if test="${key.daxue=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="daxue"  checked="true"/>
</c:if>
<c:if test="${key.daxue=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="daxue"  />
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">大学附近</a>

<c:if test="${key.xianfang=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="xianfang"  checked="true"/>
</c:if>
<c:if test="${key.xianfang=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="xianfang"  />
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">现房项目</a>

<c:if test="${key.traffic=='1'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="traffic"  checked="true"/>
</c:if>
<c:if test="${key.traffic=='0'}">
<input style="display:block;float:left;height:30px;margin-left:0px" type="checkbox" name="key" id="traffic"/>
</c:if>
<a style="display:block;width:80px;color:#333;float:left;line-height:35px;height:35px;margin-left:2px;font-size:12px;">轨道交通</a>
</div>
</form>
<!-- ****************************************************项目关键字end***************************************************** -->
<!-- ****************************************************购房税费end***************************************************** -->

<form id="broker">
<div class="area_bkg2" style="clear:both;" id="housetax">推荐经纪人</div>
<div class="area_left">
<span class="area_span">经纪人姓名</span>
<span>
	<select data-placeholder="请选择..." class="chosen-select" id="broker_name" name="broker_name" style="width:220px;" tabindex="5">
	 	 <option value=""></option>
	  	 <c:forEach items="${brokerSet}" var="item">
	        		 <option value="${item.id}">${item.broker_name}</option>
	    </c:forEach>
	 </select>
 </span>
</div>
</form>
<div class="area_right">

<div style="clear: both;float: right;padding-right: 55px;"><a href="#" class="addbroker">添加</a></div>

</div>
<div id="brokerlist">
<c:forEach items="${brokerlist}" var="broker" varStatus="status">
<%-- <div>
	<div class='area_left3'>
	<span style='display:none;'>${status.index + 1}</span>
	<span class='area_span'>${broker.broker_name}</span>
	<span class='area_span'>${broker.broker_type}</span>
	<span class='area_span'>${broker.broker_language}</span>
	<span class='area_span'>${broker.broker_region}</span>
	</div>
	<div class='area_right3'>
	<span class='area_span5'>
	<a href='#' class='deletebroker'>删除</a>
	</span>
	</div>
</div> --%>
<div style='float:left;padding-left:40px;'>
<span style='padding-right:10px;'>${status.index + 1}</span>
<input type="hidden" value="${houseTax.id} "/>
<span style='padding-right:10px;'>${broker.broker_name}</span>
<span style='padding-right:10px;'>${broker.broker_type}</span>
<span style='padding-right:10px;'>${broker.broker_language}</span>
<span style='padding-right:10px;'>${broker.broker_region}</span>
<span style='padding-left: 30px;padding-right: 40px;'>
<a href='#' class='deletebroker'>删除</a>
</span>
</div>
</c:forEach>
</div>




<div style="float:left;">

<div class="area_left4"><button  class="btn" onClick="savepro()">提交</button></div>
<div class="area_right4"><button class="btn" onClick="clearAllInput()">重置</button></div>
</div>

</div>
</div>
<script type="text/javascript">
$("#finish_time").datepicker({
    language: "zh-CN",
    format: "yyyy-mm" ,
    startView: 1,
    minViewMode: 1 
});
$('#danjia').blur(function() {
	if(isNaN($('#danjia').val())){
		alert("请输入数字！");
		$("#danjia").focus();
		return false;
	}
	});
$('#keshou').blur(function() {
	if(isNaN($('#keshou').val())){
		alert("请输入数字！");
		$("#keshou").focus();
		return false;
	}
	});
$('#walk_num').blur(function() {
	if(isNaN($('#walk_num').val())){
		alert("请输入数字！");
		$("#walk_num").focus();
		return false;
	}
	});
$('#tuijian').blur(function() {
	if(isNaN($('#tuijian').val())){
		alert("请输入数字！");
		$("#tuijian").focus();
		return false;
	}
	});
$('#minarea').blur(function() {
	if(isNaN($('#minarea').val())){
		alert("请输入数字！");
		$("#minarea").focus();
		return false;
	}
	});
$('#maxarea').blur(function() { 
	if(isNaN($('#maxarea').val())){
		alert("请输入数字！");
		$("#maxarea").focus();
		return false;
	}
	});
$('#room_num').blur(function() {
	if(isNaN($('#room_num').val())){
		alert("请输入数字！");
		$("#room_num").focus();
		return false;
	}
	});
$('#wc_num').blur(function() {
	if(isNaN($('#wc_num').val())){
		alert("请输入数字！");
		$("#wc_num").focus();
		return false;
	}
	});
$('#holdcostprice').blur(function() {
	if(isNaN($('#holdcostprice').val())){
		alert("请输入数字！");
		$("#holdcostprice").focus();
		return false;
	}
	});
$('#houseTaxprice').blur(function() {
	if(isNaN($('#houseTaxprice').val())){
		alert("请输入数字！");
		$("#houseTaxprice").focus();
		return false;
	}
	});
$('#update_time').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
})

        function UpladFile(imageid) {
            var fileObj = document.getElementById(imageid).files[0]; // 获取文件对象

            var FileController = "/imageupload";                    // 接收上传文件的后台地址 

            // FormData 对象

            var form = new FormData();

            /* form.append("author", "hooyes");    */                     // 可以增加表单数据

            form.append("file", fileObj);                           // 文件对象



            // XMLHttpRequest 对象

            var xhr = new XMLHttpRequest();

            xhr.open("post", FileController, true);

            xhr.onload = function () {

                alert("上传完成!");

            };

            xhr.send(form);
        }

</script>
<script type="text/javascript">
var peitaolist='${projectPeitaoListJson}';
peitaolist=eval("("+peitaolist+")"); 
var isedit=100;
var edititem;
var peitaocount=peitaolist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addpeitao").click(function(){
		//alert(isedit);
		if(isedit==100){
			if($('#projectimage').val()==""){
				alert("请选择文件！");
				return false;}
			var peitao={};
			var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1];
			peitao["name"]=filename/* $('#projectimage').val() */;
			peitao.shunxu=peitaocount+1;
			/* peitao.view= */
			peitaolist.push(peitao);
			UpladFile("projectimage");
			$("#projectimage").val("");
			$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' class='deletepeitao'>删除</a></span></div>")
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			//alert("edit");
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			edititem.name=$('#projectimage').val();
			UpladFile("projectimage");
			$("#projectimage").val("");
			//alert($("#peitaolist").children().eq(isedit));
			$("#peitaolist").children().eq(++isedit).show();
			isedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#peitaolist").on("click",".deletepeitao",function(){
		peitaolist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().empty();
		peitaocount--;
		});
	$("#peitaolist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().prevAll().length;
		//alert(index);
		edititem=peitaolist[index];
		$(this).parent().parent().hide();
		//alert(edititem.name);
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		isedit=index;
		}); 
	
});
var imagelist='${projectImageListJson}';
imagelist=eval("("+imagelist+")"); 
var imageisedit=100;
var imageedititem;
var imagecount=imagelist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addimage").click(function(){
		//alert(isedit);
		if(imageisedit==100){
			if($('#oneimage').val()==""){
				alert("请选择文件！");
				return false;}
			var image={};
			var filenames=$('#oneimage').val().split("\\");
			var filename=filenames[filenames.length-1];
			image["name"]=filename;
			image.shunxu=imagecount+1;
			imagelist.push(image);
			UpladFile("oneimage");
			$("#oneimage").val("");
			$("#imagelist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++imagecount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' class='deletepeitao'>删除</a></span></div>")
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			//alert("edit");
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			imageedititem.name=$('#oneimage').val();
			UpladFile("oneimage");
			$("#oneimage").val("");
			//alert($("#peitaolist").children().eq(isedit));
			$("#imagelist").children().eq(++isedit).show();
			imageisedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#imagelist").on("click",".deletepeitao",function(){
		imagelist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().remove();
		imagecount--;
		});
	$("#imagelist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().prevAll().length;
		//alert(index);
		imageedititem=imagelist[index];
		$(this).parent().parent().hide();
		//alert(edititem.name);
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		imageisedit=index;
		}); 
	
});
var huxinglist='${houseInfoListJson}';
 huxinglist=eval("("+huxinglist+")"); 
var ishuxingedit=100;
var huxingedititem;
var huxingcount=huxinglist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addhuxing").click(function(){
		//alert(ishuxingedit);
		if(ishuxingedit==100){
			if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;}
			var huxing={};
			var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1];
			/* huxing=DataDeal.formToJson(data= decodeURIComponent($("#huxingjiage").serialize(),true));
			huxing=eval("("+huxing+")"); */
			huxing.housename=$("#housename").val();
			huxing.houseprice=$("#houseprice").val();
			huxing.room_num=$("#room_num").val();
			huxing.houseimg=$("#file1").val();
			huxing.tudi_mianji=$("#tudi_mianji").val();
			huxing.jianzhu_mianji=$("#jianzhu_mianji").val();
			huxing.shinei_mianji=$("#shinei_mianji").val();
			huxing.shiwai_mianji=$("#shiwai_mianji").val();
			huxing.wc_num=$("#wc_num").val();
			huxing["houseimg"]=filename/* $('#projectimage').val() */;
			huxing["houseimg"]=$('#file1').val();/* 
			huxing["houseimg"]=filename */
			huxinglist.push(huxing);
			$("#huxingjiagelist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++huxingcount)+"</span><span style='padding-right:10px;'>"+huxinglist[huxingcount-1].houseimg+"</span>"+"<span style='padding-right:10px;'>"+huxinglist[huxingcount-1].housename+"</span><span >"+huxinglist[huxingcount-1].houseprice+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			UpladFile("houseimg");
			$("#huxingjiage input").each(function(){
				$(this).val("");
				});
			$("#file2").val("浏览");
			}
		else{
			if($('#file1').val()==""){
				alert("请选择文件！");
				return false;}
			var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1];
			/* huxingedititem=DataDeal.formToJson(data= decodeURIComponent($("#huxingjiage").serialize(),true));
			huxingedititem=eval("("+huxingedititem+")"); */
			huxingedititem.housename=$("#housename").val();
			huxingedititem.houseprice=$("#houseprice").val();
			huxingedititem.room_num=$("#room_num").val();
			huxingedititem.houseimg=$("#file1").val();
			huxingedititem.tudi_mianji=$("#tudi_mianji").val();
			huxingedititem.jianzhu_mianji=$("#jianzhu_mianji").val();
			huxingedititem.shinei_mianji=$("#shinei_mianji").val();
			huxingedititem.shiwai_mianji=$("#shiwai_mianji").val();
			huxingedititem.wc_num=$("#wc_num").val();
			huxingedititem["houseimg"]=filename/* $('#projectimage').val() */;
			huxingedititem["houseimg"]=$('#file1').val();
			UpladFile("houseimg");
			$("#huxingjiage input").each(function(){
				$(this).val("");
				});
			$("#file2").val("浏览");
			huxingedititem.id=huxinglist[ishuxingedit].id;
			huxinglist[ishuxingedit]=huxingedititem;
			$("#huxingjiagelist").children().eq(ishuxingedit).html("<span style='padding-right:10px;'>"+(ishuxingedit+1)+"</span><span style='padding-right:10px;'>"+huxinglist[ishuxingedit].houseimg+"</span><span style='padding-right:10px;'>"+huxinglist[ishuxingedit].housename+"</span><span style='padding-right:10px;'>"+huxinglist[ishuxingedit].houseprice+"</span>"+"<span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span>").show();
			ishuxingedit=100;
			
			}
		});
	$("#huxingjiagelist").on("click",".deletepeitao",function(){
		huxinglist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().remove();

		huxingcount--;

		});
	$(function(){
		$("#file2").click(
				function(){
					$("#houseimg").click();
					$("#houseimg").change(function(){
						var filenames=$('#houseimg').val().split("\\");
						var filename=filenames[filenames.length-1];
						$("#file1").val(filename);
						});
				});
	});
	$("#huxingjiagelist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().prevAll().length;
		//alert(index);
		huxingedititem=huxinglist[index];
		$(this).parent().parent().hide();
		
	/*  <input type="text" id="file1" style="float:left;width:580px;border:1px solid rgb(239,235,242);"><input type="button" id="file2" value="浏览...">
		<input type="file" name="houseimg" id="houseimg"  style="width:620px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;display:none;"/><a href="#"  onclick="upload()">上传</a>
 */
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		ishuxingedit=index;
		$("#housename").val(huxingedititem.housename.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		 /* $("#houseimg").val(huxingedititem.houseimg); */
		 $("#file1").val(huxingedititem.houseimg.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#houseprice").val(huxingedititem.houseprice.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#room_num").val(huxingedititem.room_num.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#tudi_mianji").val(huxingedititem.tudi_mianji.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#jianzhu_mianji").val(huxingedititem.jianzhu_mianji.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#shinei_mianji").val(huxingedititem.shinei_mianji.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#shiwai_mianji").val(huxingedititem.shiwai_mianji.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#wc_num").val(huxingedititem.wc_num.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		}); 
	
});

var fujinlist='${fujinPeitaoListJson}'; 
/* var fujinlist='${fujinPeitaoListJson}'; */
/* var fujinlist='${fujinPeitaoListJson}'.replace("\'", "&#39;");  */
 //fujinlist.replace("\'", "&#39;");
 
/* fujinlist=fujinlist.replace(/ad/g,"000"); */
/* var fujinlist=eval("("+'${fujinPeitaoListJson}'+")").replace("\'", "&#39;"); */
 fujinlist=eval("("+fujinlist+")"); 
var fujinedit=100;
var fujinedititem;
var fujincount=fujinlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addfujin").click(function(){
		//alert(fujinedit);
		if(fujinedit==100){
			var fujin={};
			//fujin=DataDeal.formToJson(data= decodeURIComponent($("#fujin").serialize(),true));
			fujin.peitao_type=$("#peitao_type").val();
			fujin.peitao_name=$("#peitao_name").val();
			fujin.peitao_distance=$("#peitao_distance").val();
			/* fujin=eval("("+fujin+")"); */
			fujinlist.push(fujin);
			$("#fujinlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++fujincount)+"</span><span style='padding-right:10px;'>"+fujinlist[fujincount-1].peitao_type+"</span><span style='padding-right:10px;'>"+fujinlist[fujincount-1].peitao_name+"</span><span style='padding-right:10px;'>"+fujinlist[fujincount-1].peitao_distance+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			/* UpladFile("houseimg"); */
			$("#fujin input").each(function(){
				$(this).val("");
				});
		
			}
		else{
			
			//fujinedititem=DataDeal.formToJson(data= decodeURIComponent($("#fujin").serialize(),true));
			fujinedititem.peitao_type=$("#peitao_type").val();
			fujinedititem.peitao_name=$("#peitao_name").val();
			fujinedititem.peitao_distance=$("#peitao_distance").val();
			//fujinedititem=eval("("+fujinedititem+")");

			$("#fujin input").each(function(){
				$(this).val("");
				});
			fujinedititem.id=fujinlist[fujinedit].id;
			fujinlist[fujinedit]=fujinedititem;
			
			$("#fujinlist").children().eq(fujinedit).html("<span style='padding-right:10px;'>"+(fujinedit+1)+"</span><span style='padding-right:10px;'>"+fujinlist[fujinedit].peitao_type+"</span><span style='padding-right:10px;'>"+fujinlist[fujinedit].peitao_name+"</span><span style='padding-right:10px;'>"+fujinlist[fujinedit].peitao_distance+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span>").show();
			fujinedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#fujinlist").on("click",".deletepeitao",function(){
		fujinlist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().remove();
		fujincount--;
		});
	$("#fujinlist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().prevAll().length;
		//alert(index);
		fujinedititem=fujinlist[index];
		$(this).parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		fujinedit=index;
		$("#peitao_type").val(fujinedititem.peitao_type.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#peitao_name").val(fujinedititem.peitao_name.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#peitao_distance").val(fujinedititem.peitao_distance.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		}); 
	
});


var schoollist='${fujinSchoolListJson}';
schoollist=eval("("+schoollist+")");
var schooledit=100;
var schooledititem;
var schoolcount=schoollist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addschool").click(function(){
		//alert(schooledit);
		if(schooledit==100){

			var school={};
			/* school=DataDeal.formToJson(data= decodeURIComponent($("#school").serialize(),true));
			school=school.replace(/\+/g," ");
			school=eval("("+school+")"); */
			school.school_distance=$("#school_distance").val();
			school.school_name=$('#school_name').val();
			schoollist.push(school);
			$("#schoollist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++schoolcount)+"</span><span style='padding-right:10px;'>"+schoollist[schoolcount-1].school_name+"</span><span style='padding-right:10px;'>"+schoollist[schoolcount-1].school_distance+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			/* UpladFile("houseimg"); */
			$("#school input").each(function(){
				$(this).val("");
				});
			}
		else{
			/* schooledititem=DataDeal.formToJson(data= decodeURIComponent($("#school").serialize(),true));
			schooledititem=schooledititem.replace(/\+/g," "); */
			schooledititem.school_distance=$("#school_distance").val();
			schooledititem.school_name=$('#school_name').val();
			//schooledititem=eval("("+schooledititem+")");
			$("#school input").each(function(){
				$(this).val("");
				});
			schoollist[schooledit]=schooledititem;
			$("#schoollist").children().eq(schooledit).html("<span style='padding-right:10px;'>"+(schooledit+1)+"</span><span style='padding-right:10px;'>"+schoollist[schooledit].school_name+"</span><span style='padding-right:10px;'>"+schoollist[schooledit].school_distance+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span>").show();
			schooledit=100;
	
			
			}
		});
	$("#schoollist").on("click",".deletepeitao",function(){
		
		schoollist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().remove();
		schoolcount--;
		});
	$("#schoollist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().prevAll().length;
		schooledititem=schoollist[index];
		$(this).parent().parent().hide();
		schooledit=index;
		var selectCount = document.getElementById("school_name");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==schooledititem.school_name){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#school_name').trigger('chosen:updated');
		/* $("#school_name").val(schooledititem.school_name); */
		/*  $("#school_name").find("option[text=schooledititem.school_name]").attr("selected",true); */
		/*  $('#school_name').trigger('chosen:updated'); */
		$("#school_distance").val(schooledititem.school_distance.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		}); 
	
});

var holdingcostlist='${holdCostListJson}';
holdingcostlist=eval("("+holdingcostlist+")");
var holdingcostedit=100;
var holdingcostedititem;
var holdingcostcount=holdingcostlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addholdingcost").click(function(){
		//alert(holdingcostedit);
		if(holdingcostedit==100){
			if($("#holdcosttype").val()=="" || $("#holdcostprice").val()=="" ||$("#holdcostdesc").val()==""){
				alert("请输入完整持有成本的类型、价格、描述！");
				return false;
			}
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var holdingcost={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* holdingcost=DataDeal.formToJson(data= decodeURIComponent($("#holdingcost").serialize(),true));
			holdingcost=holdingcost.replace(/\+/g," ");
			holdingcost=eval("("+holdingcost+")"); */
			holdingcost.holdcosttype=$("#holdcosttype").val();
			holdingcost.holdcostprice=$("#holdcostprice").val();
			holdingcost.holdcostdesc=$("#holdcostdesc").val();
			/* huxing["houseimg"]=filename *//* $('#projectimage').val() */;
			/* peitao.shunxu=peitaocount+1; */
			/* peitao.view= */
			/* alert($("#huxingjiage").serializeArray()); */
			/* huxing.housename=$("#housename").val();
			huxing.houseprice=$("#houseprice").val();
			huxing.room_num=$("#room_num").val();
			huxing.tudi_mianji=$("#tudi_mianji").val();
			huxing.jianzhu_mianji=$("#jianzhu_mianji").val();
			huxing.shinei_mianji=$("#") */
			holdingcostlist.push(holdingcost);
			$("#holdingcostlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++holdingcostcount)+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostcount-1].holdcosttype+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostcount-1].holdcostprice+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostcount-1].holdcostdesc+"</span>"+"<span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			/* UpladFile("houseimg"); */
			$("#holdingcost input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			if($("#holdcosttype").val()=="" || $("#holdcostprice").val()=="" ||$("#holdcostdesc").val()==""){
				alert("请输入完整持有成本的类型、价格、描述！");
				return false;
			}
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* holdingcostedititem=DataDeal.formToJson(data= decodeURIComponent($("#holdingcost").serialize(),true));
			holdingcostedititem=holdingcostedititem.replace(/\+/g," ");
			holdingcostedititem=eval("("+holdingcostedititem+")"); */
			holdingcostedititem.holdcosttype=$("#holdcosttype").val();
			holdingcostedititem.holdcostprice=$("#holdcostprice").val();
			holdingcostedititem.holdcostdesc=$("#holdcostdesc").val();
			/* holdingcostedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#holdingcost input").each(function(){
				$(this).val("");
				});
			holdingcostedititem.id=holdingcostlist[holdingcostedit].id;
			holdingcostlist[holdingcostedit]=holdingcostedititem;
			//alert($("#holdingcostlist").children().eq(holdingcostedit));
			$("#holdingcostlist").children().eq(holdingcostedit).html("<span style='padding-right:10px;'>"+(holdingcostedit+1)+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostedit].holdcosttype+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostedit].holdcostprice+"</span><span style='padding-right:10px;'>"+holdingcostlist[holdingcostedit].holdcostdesc+"</span>"+"<span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span>").show();
			holdingcostedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});

	$("#holdingcostlist").on("click",".deletepeitao",function(){
		holdingcostlist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().remove();
		holdingcostcount--;
		});
	$("#holdingcostlist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().prevAll().length;
		//alert(index);
		holdingcostedititem=holdingcostlist[index];

		$(this).parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");

		holdingcostedit=index;
		var selectCount = document.getElementById("holdcosttype");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==holdingcostedititem.holdcosttype){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#holdcosttype').trigger('chosen:updated');
		$("#holdcosttype").val(holdingcostedititem.holdcosttype.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#holdcostprice").val(holdingcostedititem.holdcostprice.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#holdcostdesc").val(holdingcostedititem.holdcostdesc.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#holdcost_housename").val(holdingcostedititem.holdcost_housename.replace(/\$nbsp;/g," ").replace("&#39;","'"));

		}); 
	
});



var housetaxformlist='${houseTaxListJson}';
housetaxformlist=eval("("+housetaxformlist+")");
var housetaxformedit=100;
var housetaxformedititem;
var housetaxformcount=housetaxformlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addhousetaxform").click(function(){
		//alert(housetaxformedit);
		if(housetaxformedit==100){
			if($("#houseTaxtype").val()=="" || $("#houseTaxprice").val()=="" ||$("#houseTaxdesc").val()==""){
				alert("请输入完整购房税费的类型、价格、描述！");
				return false;
			}
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var housetaxform={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* housetaxform=DataDeal.formToJson(data= decodeURIComponent($("#housetaxform").serialize(),true));
			housetaxform=eval("("+housetaxform+")"); */
			housetaxform.houseTaxtype=$("#houseTaxtype").val();
			housetaxform.houseTaxprice=$("#houseTaxprice").val();
			housetaxform.houseTaxdesc=$("#houseTaxdesc").val();
			/* huxing["houseimg"]=filename *//* $('#projectimage').val() */;
			/* peitao.shunxu=peitaocount+1; */
			/* peitao.view= */
			/* alert($("#huxingjiage").serializeArray()); */
			/* huxing.housename=$("#housename").val();
			huxing.houseprice=$("#houseprice").val();
			huxing.room_num=$("#room_num").val();
			huxing.tudi_mianji=$("#tudi_mianji").val();
			huxing.jianzhu_mianji=$("#jianzhu_mianji").val();
			huxing.shinei_mianji=$("#") */
			housetaxformlist.push(housetaxform);
			$("#housetaxformlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++housetaxformcount)+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformcount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformcount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformcount-1].houseTaxdesc+"</span>"+"<span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			
			/* UpladFile("houseimg"); */
			$("#housetaxform input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			if($("#houseTaxtype").val()=="" || $("#houseTaxprice").val()=="" ||$("#houseTaxdesc").val()==""){
				alert("请输入完整购房税费的类型、价格、描述！");
				return false;
			}
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* housetaxformedititem=DataDeal.formToJson(data= decodeURIComponent($("#housetaxform").serialize(),true));
			housetaxformedititem=eval("("+housetaxformedititem+")"); */
			housetaxformedititem.houseTaxtype=$("#houseTaxtype").val();
			housetaxformedititem.houseTaxprice=$("#houseTaxprice").val();
			housetaxformedititem.houseTaxdesc=$("#houseTaxdesc").val();
			/* housetaxformedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#housetaxform input").each(function(){
				$(this).val("");
				});
			housetaxformedititem.id=housetaxformlist[housetaxformedit].id;
			housetaxformlist[housetaxformedit]=housetaxformedititem;
			//alert($("#housetaxformlist").children().eq(housetaxformedit));
			$("#housetaxformlist").children().eq(housetaxformedit).html("<span style='padding-right:10px;'>"+(housetaxformedit+1)+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformedit].houseTaxtype+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformedit].houseTaxprice+"</span><span style='padding-right:10px;'>"+housetaxformlist[housetaxformedit].houseTaxdesc+"</span>"+"<span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span>").show();
			housetaxformedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#housetaxformlist").on("click",".deletepeitao",function(){
		housetaxformlist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().empty();
		housetaxformcount--;
		});
	$("#housetaxformlist").on("click",".editpeitao",function(){
		
		var index=$(this).parent().parent().prevAll().length;
		//alert(index);
		housetaxformedititem=housetaxformlist[index];
		$(this).parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		housetaxformedit=index;
		var selectCount = document.getElementById("houseTaxtype");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==housetaxformedititem.houseTaxtype){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#houseTaxtype').trigger('chosen:updated');
		/* $("#houseTaxtype").val(housetaxformedititem.houseTaxtype); */
		$("#houseTaxprice").val(housetaxformedititem.houseTaxprice.replace(/\$nbsp;/g," ").replace("&#39;","'"));
		$("#houseTaxdesc").val(housetaxformedititem.houseTaxdesc.replace(/\$nbsp;/g," ").replace("&#39;","'"));
	/* 	$("#houseTax_housename").val(housetaxformedititem.houseTax_housename); */
		}); 
	
});


var brokerlist='${brokerlistJson}';
brokerlist=eval("("+brokerlist+")");
var brokeredit=100;
var brokeredititem;
var brokercount=brokerlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addbroker").click(function(){
		if(brokeredit==100){
			var broker={};
			/* broker=DataDeal.formToJson(data= decodeURIComponent($("#broker").serialize(),true));
			broker=broker.replace(/\+/g," ");
			broker=eval("("+broker+")"); */
			broker.broker_name=$("#broker_name").val().replace(/\+/g," ");
			$.ajax({
				  url: "/getjingjireninfo",
				  method: "POST",
				  data: {id : broker.broker_name},
				  dataType: "json",
				  success:function (data,textStatus,jqXHR){
					  brokerlist.push(data);
					  //$('#brokerlist').append("<div><div class='area_left3'><span style='display:none;'>"+(++brokercount)+"</span><span class='area_span'>"+brokerlist[brokercount-1].broker_name+"</span><span class='area_span'>"+brokerlist[brokercount-1].broker_type+"</span><span class='area_span'>"+brokerlist[brokercount-1].broker_language+"</span><span class='area_span'>"+brokerlist[brokercount-1].broker_region+"</span></div><div class='area_right3'><span class='area_span5'><a href='#' class='deletebroker'>删除</a></span></div></div>");
					  $('#brokerlist').append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++brokercount)+"</span><span style='padding-right:10px;'>"+brokerlist[brokercount-1].broker_name+"</span><span style='padding-right:10px;'>"+brokerlist[brokercount-1].broker_type+"</span><span style='padding-right:10px;'>"+brokerlist[brokercount-1].broker_language+"</span><span style='padding-right:10px;'>"+brokerlist[brokercount-1].broker_region+"</span>"+"<span style='padding-left: 30px;padding-right: 40px;'><a href='#' class='deletebroker'>删除</a></span></div>");
				  }
				});
			
			$("#broker input").each(function(){
				$(this).val("");
				});
			}
		else{
			brokeredititem=DataDeal.formToJson(data= decodeURIComponent($("#broker").serialize(),true));
			 brokeredititem=brokeredititem.replace(/\+/g," "); 
			 brokeredititem=eval("("+brokeredititem+")");
			$("#broker input").each(function(){
				$(this).val("");
				});
			brokerlist[brokeredit]=brokeredititem;
			alert($("#brokerlist").children().eq(brokeredit));
			$("#brokerlist").children().eq(brokeredit).html("<div class='area_left3'><span style='display:none;'>"+(brokeredit+1)+"</span><span class='area_span'>"+brokerlist[brokeredit].column1+"</span><span class='area_span'>"+brokerlist[brokeredit].column2+"</span><span class='area_span'>"+brokerlist[brokeredit].column3+"</span><span class='area_span'>"+brokerlist[brokeredit].view_shunxu_broker+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editbroker'>编辑</a></span><span class='area_span5'><a href='#' class='deletebroker'>删除</a></span></div>").show();
			brokeredit=100;
			}
		});
	$("#brokerlist").on("click",".deletebroker",function(){
		brokerlist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().remove();
		brokercount--;
		});
});


window.onload=function(){
}
$.ajaxSetup({  
    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
});  
var DataDeal = {  
		//将从form中通过$('#form').serialize()获取的值转成json  
		           formToJson: function (data) {  
		               data=data.replace(/&/g,"\",\"");  
		               data=data.replace(/=/g,"\":\"");  
		               data="{\""+data+"\"}";  
		               return data;  
		            },  
		};  


	

</script>


<script>

function savepro(){
	
	//alert(JSON.stringify(housetaxformlist));
	/* var list=[];
	var obj={};
	obj.peitao_type="alue1";
	obj.peitao_name="value2";
	obj.peitao_distance="value3";
	list.push(obj);
	var obj1={};
	obj1.peitao_type="aa";
	obj1.peitao_name="bb";
	obj1.peitao_distance="aa";
	list.push(obj1);
	alert("list:"+list); */
	//项目id
	var id=$("#id").val();
	//项目
	var projectlist=[];
	var project = {};
	project.project_name=$("#project_name").val();
	project.project_type=$("#project_type").val();
	project.project_nation=$("#project_nation").val();
	project.project_address=$("#project_address").val();
	project.project_area=$("#project_area").val();
	project.project_price_int_qi=$("#danjia").val();
	project.project_sales_remain=$("#keshou").val();
	project.project_finish_time=$("#finish_time").val();
	project.project_desc=$("#project_desc").val();
	project.project_city=$("#project_city").val();
	project.project_house_type=$("#house_type").val();
	project.project_high=$("#ceng").val();
	project.project_lan_en=$("#project_lan_en").val();
	project.project_num=$("#project_code").val();
	project.project_vedio=$("#project_video").val();
	project.project_zhou=$("#project_zhou").val();
	project.project_lan_cn=$("#project_lan_an").val();
	project.gps=$("#GPS").val();
	project.return_money=$("#return_money").val();
	project.walk_num=$("#walk_num").val();
	project.mianji=$("#mianji").val();
	project.project_min_price=$("#minprice").val();
	project.project_high_price=$("#maxprice").val();
	project.tuijiandu=$("#tuijian").val();
	project.housePrice_update_time=$("#update_time").val();
	project.developer_id_name=$("#developer_code").val();
	project.min_area=$("#minarea").val();
	project.max_area=$("#maxarea").val();
	project.buytaxInfo=$("#buyTaxInfo").val();
	project.holdInfo=$("#holdCostInfo").val();	
	project.area_num=$("#area_num").val();		
	projectlist.push(project);
    //接收项目编号
    var project_num=$("#project_code").val();
    
	var keylist2=document.getElementsByName('key');
	 for(var i=0;i<keylist2.length;i++){
	 	if(keylist2[i].checked==true){
	 		keylist2[i].value=1;
	 	}else{
	 		keylist2[i].value=0;
	 	}
	 }
	var keylist=[];
	var key = {};
	key.id=$("#keyid").val();
	key.xinkaipan=$("#xinkaipan").val();
	key.remen=$("#remen").val();
	key.maidi=$("#maidi").val();
	key.center=$("#center").val();
	key.baozu=$("#baozu").val();
	key.huaren=$("#huaren").val();
	key.xuequ=$("#xuequ").val();
	key.daxue=$("#daxue").val();
	key.xianfang=$("#xianfang").val();
	key.traffic=$("#traffic").val();
	keylist.push(key);

    $.ajax({
	    type: "POST",
 		async:false, 
		dateType: "json",
		data:{id:id,"project":JSON.stringify(projectlist),"keylist":JSON.stringify(keylist),"huxinglist":JSON.stringify(huxinglist),"imagelist":JSON.stringify(imagelist),"peitaolist":JSON.stringify(peitaolist),"fujinlist":JSON.stringify(fujinlist),"schoollist":JSON.stringify(schoollist),"holdingcostlist":JSON.stringify(holdingcostlist),"housetaxformlist":JSON.stringify(housetaxformlist),"brokerlist":JSON.stringify(brokerlist)},
		url: "/EditProject2",
		success:function(data){
			data=eval("("+data+")");
		/* 	if(data.isDuplicate==1){
				alert("区域编号已存在！");
			} */
			if(data.flag==1)
			{
				alert("更新成功");
			}
			else if(data.flag==0){
				alert("更新失败");
			}
			window.close();
		},
		error:function(){
			alert("error");
			window.close();
		}
    });
}

function clearAllInput(){
	$("input").val("");
	housetaxformlist=[];
	holdingcostlist=[];
	schoollist=[];
	fujinlist=[];
	huxinglist=[];
	peitaolist=[];
	$("#housetaxformlist").empty();
	$("#holdingcostlist").empty();
	$("#schoollist").empty();
	$("#fujinlist").empty();
	$("#peitaolist").empty();
	$("#huxingjiagelist").empty();
	return false;
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
</body>
</html>
