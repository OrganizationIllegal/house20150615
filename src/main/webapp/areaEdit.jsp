<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>区域录入</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/areaLuru.css" />
<script src="/ckeditor/ckeditor.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/chosen.css">
<link rel="stylesheet" type="text/css" href="/bootstrap-datepicker-1.4.0-dist/css/bootstrap-datepicker.min.css" />
  <script src="/bootstrap-datepicker-1.4.0-dist/js/bootstrap-datepicker.min.js"></script>
<script src="/bootstrap-datepicker-1.4.0-dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>
<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
</style>
</head>
<body>

	<%
            String username = null;
       		if(request.getSession().getAttribute("username")==null){
       			out.print("<script>alert('用户请登录。');window.location.href='/index01'</script>");
}
       		
%>


<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:区域录入</div>
<form id="area">


<div class="area_bkg2" id="areainfo">区域信息</div>
<div class="area_left">
<input type="text" id="id1" name="id1" style="display:none;" value="${AreaInfo.id}">
<span class="area_span">区域编号</span><span><input type="text" id="area_num" name="area_num" class="area_input" value="${AreaInfo.area_num}"></span>
</div>
<div class="area_right">
<span class="area_span">区域名称</span><span><input type="text" id="area_name" name="area_name" class="area_input" value="${AreaInfo.area_name}"></span>
</div>
<div class="area_left">
<span class="area_span">国家</span>
<span>
<%-- <input type="text" id="area_nation" name="area_nation" class="area_input" value="${AreaInfo.area_nation}"> --%>
<select data-placeholder="请选择..." class="chosen-select" id="area_nation" name="area_nation" style="width:220px;" tabindex="4">
 	 <option value=""></option>
      <c:choose>
	    <c:when test="${AreaInfo.area_nation eq 'Australia 澳大利亚'}">
	      <option value="Australia 澳大利亚" selected="selected">Australia 澳大利亚</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Australia 澳大利亚">Australia 澳大利亚</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${AreaInfo.area_nation eq 'Canada 加拿大'}">
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
<span class="area_span">州/省</span>
<span>
<%-- <input type="text" id="area_zhou" name="area_zhou" class="area_input" value="${AreaInfo.area_zhou}"> --%>
<select data-placeholder="请选择..." class="chosen-select" id="area_zhou" name="area_zhou" style="width:220px;" tabindex="4">
 	 <option value=""></option>
      <c:choose>
	    <c:when test="${AreaInfo.area_zhou eq 'VIC 维多利亚州'}">
	      <option value="VIC 维多利亚州" selected="selected">VIC 维多利亚州</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="VIC 维多利亚州">VIC 维多利亚州</option>
	   </c:otherwise>
  	  </c:choose>
  	  <c:choose>
	    <c:when test="${AreaInfo.area_zhou eq 'QLD 昆士兰州'}">
	      <option value="QLD 昆士兰州" selected="selected">QLD 昆士兰州</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="QLD 昆士兰州">QLD 昆士兰州</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${AreaInfo.area_zhou eq 'NSW 新南威尔士州'}">
	      <option value="NSW 新南威尔士州" selected="selected">NSW 新南威尔士州</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="NSW 新南威尔士州">NSW 新南威尔士州</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${AreaInfo.area_zhou eq 'WA 西澳大利亚'}">
	      <option value="WA 西澳大利亚" selected="selected">WA 西澳大利亚</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="WA 西澳大利亚">WA 西澳大利亚</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${AreaInfo.area_zhou eq 'SA 南澳大利亚'}">
	      <option value="SA 南澳大利亚" selected="selected">SA 南澳大利亚</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="SA 南澳大利亚">SA 南澳大利亚</option>
	   </c:otherwise>
  	  </c:choose>
  	    <c:choose>
	    <c:when test="${AreaInfo.area_zhou eq 'TAS 塔斯马尼亚州'}">
	      <option value="TAS 塔斯马尼亚州" selected="selected">TAS 塔斯马尼亚州</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="TAS 塔斯马尼亚州">TAS 塔斯马尼亚州</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${AreaInfo.area_zhou eq 'CAN 堪培拉'}">
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
<span class="area_span">城市名称</span>
<span>
<input type="text" id="area_city" name="area_city" class="area_input" value="${AreaInfo.area_city}">
<%-- <select data-placeholder="请选择..." class="chosen-select" id="area_city" name="area_city" style="width:220px;" tabindex="4">
 	 <option value=""></option>
       <c:choose>
	    <c:when test="${AreaInfo.area_city eq 'Sydney 悉尼'}">
	      <option value="Sydney 悉尼" selected="selected">Sydney 悉尼</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Sydney 悉尼">Sydney 悉尼</option>
	   </c:otherwise>
  	  </c:choose>
  	    <c:choose>
	    <c:when test="${AreaInfo.area_city eq 'Melbourne 墨尔本'}">
	      <option value="Melbourne 墨尔本" selected="selected">Melbourne 墨尔本</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Melbourne 墨尔本">Melbourne 墨尔本</option>
	   </c:otherwise>
  	  </c:choose>
  	    <c:choose>
	    <c:when test="${AreaInfo.area_city eq 'Brisbane 布里斯班'}">
	      <option value="Brisbane 布里斯班" selected="selected">Brisbane 布里斯班</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Brisbane 布里斯班">Brisbane 布里斯班</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${AreaInfo.area_city eq 'Perth 珀斯'}">
	      <option value="Perth 珀斯" selected="selected">Perth 珀斯</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Perth 珀斯">Perth 珀斯</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${AreaInfo.area_city eq 'Canberra 堪培拉'}">
	      <option value="Canberra 堪培拉" selected="selected">Canberra 堪培拉</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Canberra 堪培拉">Canberra 堪培拉</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${AreaInfo.area_city eq 'Adelaide 阿德莱得'}">
	      <option value="Adelaide 阿德莱得" selected="selected">Adelaide 阿德莱得</option>
	    </c:when>
	   <c:otherwise>  
	      <option value="Adelaide 阿德莱得">Adelaide 阿德莱得</option>
	   </c:otherwise>
  	  </c:choose>
  	   <c:choose>
	    <c:when test="${AreaInfo.area_city eq 'Cairns 凯恩斯'}">
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
<span class="area_span">邮政编码</span><span><input type="text" id="area_postcode" name="area_postcode" class="area_input" value="${AreaInfo.area_postcode}"></span>
</div>
<div class="area_bkg2 c-fix" id="invest">投资数据</div>
<div class="area_left">
<input type="text" id="id2" name="id2" style="display:none;" value="${Invest.id}">
<span class="area_span">数据来源</span><span><input type="text" id="touzi_datasource" name="touzi_datasource" class="area_input" value="${Invest.touzi_datasource}"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="touzi_date" name="touzi_date" class="area_input" value="${Invest.touzi_date.toString().length()>10?Invest.touzi_date.toString().substring(0,10):Invest.touzi_date.toString()}"></span>
</div>
<div class="area_left">
<span class="area_span">年增长率</span><span><input type="text" id="year_increment_rate" name="year_increment_rate" class="area_input"  value="${Invest.year_increment_rate}"></span>
</div>
<div class="area_right">
<span class="area_span">中位数价格</span><span><input type="text" id="middle_price" name="middle_price" class="area_input"  value="${Invest.middle_price}"></span>
</div>
<div class="area_left">
<span class="area_span">中位数租金</span><span><input type="text" id="middle_zu_price" name="middle_zu_price" class="area_input" value="${Invest.middle_zu_price}"></span>
</div>
<div class="area_right">
<span class="area_span">租金回报率</span><span><input type="text" id="zu_house_rate" name="zu_house_rate" class="area_input" value="${Invest.zu_house_rate}"></span>
</div>
<div class="area_left">
<span class="area_span">现金回报</span><span><input type="text" id="price_review" name="price_review" class="area_input"  value="${Invest.price_review}"></span>
</div>
<div class="area_right">
<span class="area_span">租赁需求</span><span><input type="text" id="zu_xuqiu" name="zu_xuqiu" class="area_input"  value="${Invest.zu_xuqiu}"></span>
</div>
<div class="area_left">
<span class="area_span">项目类型</span><span><input type="text" id="pro_type" name="pro_type" class="area_input"  value="${Invest.area_type}"></span>
</div>

<div class="area_bkg2 c-fix" id="invest">投资数据</div>
<div class="area_left">
<input type="text" id="id21" name="id21" style="display:none;" value="${Invest1.id}">
<span class="area_span">数据来源</span><span><input type="text" id="touzi_datasource1" name="touzi_datasource1" class="area_input" value="${Invest1.touzi_datasource}"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="touzi_date1" name="touzi_date1" class="area_input" value="${Invest1.touzi_date.toString().length()>10?Invest1.touzi_date.toString().substring(0,10):Invest1.touzi_date.toString()}"></span>
</div>
<div class="area_left">
<span class="area_span">年增长率</span><span><input type="text" id="year_increment_rate1" name="year_increment_rate1" class="area_input"  value="${Invest1.year_increment_rate}"></span>
</div>
<div class="area_right">
<span class="area_span">中位数价格</span><span><input type="text" id="middle_price1" name="middle_price1" class="area_input"  value="${Invest1.middle_price}"></span>
</div>
<div class="area_left">
<span class="area_span">中位数租金</span><span><input type="text" id="middle_zu_price1" name="middle_zu_price1" class="area_input" value="${Invest1.middle_zu_price}"></span>
</div>
<div class="area_right">
<span class="area_span">租金回报率</span><span><input type="text" id="zu_house_rate1" name="zu_house_rate1" class="area_input" value="${Invest1.zu_house_rate}"></span>
</div>
<div class="area_left">
<span class="area_span">现金回报</span><span><input type="text" id="price_review1" name="price_review1" class="area_input"  value="${Invest1.price_review}"></span>
</div>
<div class="area_right">
<span class="area_span">租赁需求</span><span><input type="text" id="zu_xuqiu1" name="zu_xuqiu1" class="area_input"  value="${Invest1.zu_xuqiu}"></span>
</div>
<div class="area_left">
<span class="area_span">项目类型</span><span><input type="text" id="pro_type1" name="pro_type1" class="area_input"  value="${Invest1.area_type}"></span>
</div>


<div class="area_bkg2 c-fix" id="family">区域家庭构成</div>
<div class="area_left">
<input type="text" id="id3" name="id3" style="display:none;" value="${Family.id}">
<span class="area_span">数据来源</span><span><input type="text" id="family_datasource" name="family_datasource" class="area_input" value="${Family.family_datasource}"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="family_date" name="family_date" class="area_input"  value="${Family.family_date.toString().length()>10?Family.family_date.toString().substring(0,10):Family.family_date.toString()}"></span>
</div>
<div class="area_left">
<span class="area_span">家庭1</span><span><input type="text" id="family_one" name="family_one" class="area_input" value="${Family.family_one}"></span>
</div>
<div class="area_right">
<span class="area_span">家庭1比例</span><span><input type="text" id="family_one_rate" name="family_one_rate" class="area_input"  value="${Family.family_one_rate}"></span>
</div>
<div class="area_left">
<span class="area_span">家庭2</span><span><input type="text" id="family_two" name="family_two" class="area_input" value="${Family.family_two}"></span>
</div>
<div class="area_right">
<span class="area_span">家庭2比例</span><span><input type="text" id="family_two_rate" name="family_two_rate" class="area_input"  value="${Family.family_two_rate}"></span>
</div>
<div class="area_left">
<span class="area_span">家庭3</span><span><input type="text" id="family_three" name="family_three" class="area_input" value="${Family.family_three}"></span>
</div>
<div class="area_right">
<span class="area_span">家庭3比例</span><span><input type="text" id="family_three_rate" name="family_three_rate" class="area_input" value="${Family.family_three_rate}"></span>
</div>
</form>


<div class="area_bkg2 c-fix" id="midprice">区域中位数房价</div>
<form id="middleprice">
<div class="area_left">
<span class="area_span">项目类型</span>
<span>
<!-- <select class="area_select" id="project_type" name="project_type">
  <option value ="公寓">公寓</option>
  <option value ="别墅">别墅</option>
</select>  -->
<select data-placeholder="请选择..." class="chosen-select" id="project_type" name="project_type" style="width:220px;" tabindex="1">
 	 <option value=""></option>
 	 <option  value="公寓">公寓</option>
 	  <option  value="别墅">别墅</option>
 	   <option  value="联排别墅">联排别墅</option>
  	 <!-- <option  value="1居室">1居室</option>
  	  <option  value="2居室">2居室</option>
  	   <option  value="3居室">3居室</option>
  	    <option  value="4居室">4居室</option>
  	     <option  value="5居室">5居室</option>
  	      <option  value="6居室">6居室</option> -->
 </select>

</span>
</div>
<div class="area_right"></div>
<div class="area_left">
<span class="area_span">购买价格</span><span><input type="text" id="buy_price" name="buy_price" class="area_input"></span>
<input type="hidden" id="id" name="id" class="area_input">
</div>
<div class="area_right">
<span class="area_span">租赁价格</span><span><input type="text" id="zu_price" name="zu_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">买一名称</span>
<span>
<!-- <input type="text" id="buy_one_name" name="buy_one_name" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="buy_one_name" name="buy_one_name" style="width:220px;" tabindex="1">
 	 <option value=""></option>
  	 <option  value="1居室">1居室</option>
  	  <option  value="2居室">2居室</option>
  	   <option  value="3居室">3居室</option>
  	    <option  value="4居室">4居室</option>
  	     <option  value="5居室">5居室</option>
  	      <option  value="6居室">6居室</option> 
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">买一价格</span><span><input type="text" id="buy_one_price" name="buy_one_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">买二名称</span><span>
<!-- <input type="text" id="buy_two_name" name="buy_two_name" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="buy_two_name" name="buy_two_name" style="width:220px;" tabindex="1">
 	 <option value=""></option>
  	 <option  value="1居室">1居室</option>
  	  <option  value="2居室">2居室</option>
  	   <option  value="3居室">3居室</option>
  	    <option  value="4居室">4居室</option>
  	     <option  value="5居室">5居室</option>
  	      <option  value="6居室">6居室</option> 
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">买二价格</span><span><input type="text" id="buy_two_price" name="buy_two_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">买三名称</span><span>
<!-- <input type="text" id="buy_three_name" name="buy_three_name" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="buy_three_name" name="buy_three_name" style="width:220px;" tabindex="1">
 	 <option value=""></option>
  	 <option  value="1居室">1居室</option>
  	  <option  value="2居室">2居室</option>
  	   <option  value="3居室">3居室</option>
  	    <option  value="4居室">4居室</option>
  	     <option  value="5居室">5居室</option>
  	      <option  value="6居室">6居室</option> 
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">买三价格</span><span><input type="text" id="buy_three_price" name="buy_three_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">租一名称</span><span>
<!-- <input type="text" id="zu_one_name" name="zu_one_name" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="zu_one_name" name="zu_one_name" style="width:220px;" tabindex="1">
 	 <option value=""></option>
  	 <option  value="1居室">1居室</option>
  	  <option  value="2居室">2居室</option>
  	   <option  value="3居室">3居室</option>
  	    <option  value="4居室">4居室</option>
  	     <option  value="5居室">5居室</option>
  	      <option  value="6居室">6居室</option> 
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">租一价格</span><span><input type="text" id="zu_one_price" name="zu_one_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">租二名称</span><span>
<!-- <input type="text" id="zu_two_name" name="zu_two_name" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="zu_two_name" name="zu_two_name" style="width:220px;" tabindex="1">
 	 <option value=""></option>
  	 <option  value="1居室">1居室</option>
  	  <option  value="2居室">2居室</option>
  	   <option  value="3居室">3居室</option>
  	    <option  value="4居室">4居室</option>
  	     <option  value="5居室">5居室</option>
  	      <option  value="6居室">6居室</option> 
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">租二价格</span><span><input type="text" id="zu_two_price" name="zu_two_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">租三名称</span><span>
<!-- <input type="text" id="zu_three_name" name="zu_three_name" class="area_input"> -->
<select data-placeholder="请选择..." class="chosen-select" id="zu_three_name" name="zu_three_name" style="width:220px;" tabindex="1">
 	 <option value=""></option>
  	 <option  value="1居室">1居室</option>
  	  <option  value="2居室">2居室</option>
  	   <option  value="3居室">3居室</option>
  	    <option  value="4居室">4居室</option>
  	     <option  value="5居室">5居室</option>
  	      <option  value="6居室">6居室</option> 
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">租三价格</span><span><input type="text" id="zu_three_price" name="zu_three_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="middle_datasource" name="middle_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="middle_date" name="middle_date" class="area_input"></span>
</div>
</form>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addmiddleprice">添加</a></span></div>
<div id="middlepricelist">
 
 <c:forEach items="${middlepricebackendlist}" var="middleprice" varStatus="status">
<div>
	<div class='area_left3'>
	<span style='display:none;'>${status.index + 1}</span>
	<span class='area_span'>${AreaInfo.area_num}</span>
	<span class='area_span'>${middleprice.project_type}</span>
	<span class='area_span'>${middleprice.zu_price}</span>
	<span class='area_span'>${middleprice.buy_price}</span>
	</div>
	<div class='area_right3'>
	<span class='area_span4'><a href='#' class='editmiddleprice'>编辑</a></span>
	<span class='area_span5'><a href='#' class='deletemiddleprice'>删除</a></span>
	</div>
</div>
</c:forEach> 


<!-- <div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">$585250</span><span class="area_span">$350</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div>
<div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">别墅</span><span class="area_span">$721250</span><span class="area_span">$385</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div> -->
</div>

<div class="area_bkg2 c-fix" >区域房价中位数走势</div>
<form id="middletrend">
<div class="area_left">
<span class="area_span">项目类型</span>
<span>
<!-- <select class="area_select" id="project_type2" name="project_type2">
  <option value ="公寓">公寓</option>
  <option value ="别墅">别墅</option>
</select> -->
<select data-placeholder="请选择..." class="chosen-select" id="project_type2" name="project_type2" style="width:220px;" tabindex="2">
 	 <option value=""></option>
  	 <option value="公寓">公寓</option>
     <option value="别墅">别墅</option>
     <option value="联排别墅">联排别墅</option>
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu2" name="view_shunxu2" class="area_input"></span>
<input type="hidden" id="id" name="id" class="area_input">
</div>
<div class="area_left">
<span class="area_span">横坐标</span><span><input type="text" id="heng2" name="heng2" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">纵坐标</span><span><input type="text" id="zong2" name="zong2" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="middle_zoushi_datasource" name="middle_zoushi_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="middle_zoushi_date" name="middle_zoushi_date" class="area_input"></span>
</div>
</form>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addmiddletrend">添加</a></span></div>
<div id="middletrendlist">
<c:forEach items="${areamiddlelist}" var="areamiddle" varStatus="status">
<div>
	<div class='area_left3'>
	<span style='display:none;'>${status.index + 1}</span>
	<span class='area_span'>${AreaInfo.area_num}</span>
	<span class='area_span'>${areamiddle.project_type2}</span>
	<span class='area_span'>${areamiddle.view_shunxu2}</span>
	<span class='area_span'>${areamiddle.heng2}</span>
	<span class='area_span6'>${areamiddle.zong2}</span>
	</div>
	<div class='area_right3'>
	<span class='area_span4'><a href='#' class='editmiddletrend'>编辑</a></span>
	<span class='area_span5'><a href='#' class='deletemiddletrend'>删除</a></span>
	</div>
</div>
</c:forEach>

<!-- 
<div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">1</span><span class="area_span">2006</span><span class="area_span6">285</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div>
<div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">2</span><span class="area_span">2007</span><span class="area_span6">332</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div> 
</div>
-->
</div>

<div class="area_bkg2 c-fix" >区域租金走势</div>
<form id="zujintrend">
<div class="area_left">
<span class="area_span">项目类型</span>
<span>
<!-- <select class="area_select" id="project_type3" name="project_type3">
  <option value ="公寓">公寓</option>
  <option value ="别墅">别墅</option>
</select> -->
<select data-placeholder="请选择..." class="chosen-select" id="project_type3" name="project_type3" style="width:220px;" tabindex="3">
 	 <option value=""></option>
  	 <option >公寓</option>
     <option >别墅</option>
     <option>联排别墅</option>
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu3" name="view_shunxu3" class="area_input"></span>
<input type="hidden" id="id" name="id" class="area_input">
</div>
<div class="area_left">
<span class="area_span">横坐标</span><span><input type="text" id="heng3" name="heng3" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">纵坐标</span><span><input type="text" id="zong3" name="zong3" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="zujin_datasource" name="zujin_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="zujin_date" name="zujin_date" class="area_input"></span>
</div>
</form>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addzujintrend">添加</a></span></div>

<div id="zujintrendlist">
<c:forEach items="${zujinlist}" var="zujin" varStatus="status">
<div>
	<div class='area_left3'>
	<span style='display:none;'>${status.index + 1}</span>
	<span class='area_span'>${AreaInfo.area_num}</span>
	<span class='area_span'>${zujin.project_type3}</span>
	<span class='area_span'>${zujin.view_shunxu3}</span>
	<span class='area_span'>${zujin.heng3}</span>
	<span class='area_span6'>${zujin.zong3}</span>
	</div>
	<div class='area_right3'>
	<span class='area_span4'><a href='#' class='editzujintrend'>编辑</a></span>
	<span class='area_span5'><a href='#' class='deletezujintrend'>删除</a></span>
	</div>
</div>
</c:forEach>
<!-- <div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">1</span><span class="area_span">2006</span><span class="area_span6">200</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div>
<div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">2</span><span class="area_span">2007</span><span class="area_span6">250</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div> -->


</div>


<div class="area_bkg2 c-fix" >区域租金回报走势</div>
<form id="huibaotrend">
<div class="area_left">
<span class="area_span">项目类型</span>
<span>
<!-- <select class="area_select" id="project_type4" name="project_type4">
  <option value ="公寓">公寓</option>
  <option value ="别墅">别墅</option>
</select> -->
<select data-placeholder="请选择..." class="chosen-select" id="project_type4" name="project_type4" style="width:220px;" tabindex="4">
 	 <option value=""></option>
  	 <option >公寓</option>
     <option >别墅</option>
     <option>联排别墅</option>
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu4" name="view_shunxu4" class="area_input"></span>
<input type="hidden" id="id" name="id" class="area_input">
</div>
<div class="area_left">
<span class="area_span">横坐标</span><span><input type="text" id="heng4" name="heng4" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">纵坐标</span><span><input type="text" id="zong4" name="zong4" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="zujin_huibao_datasource" name="zujin_huibao_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="zujin_huibao_date" name="zujin_huibao_date" class="area_input"></span>
</div>
</form>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addhuibaotrend">添加</a></span></div>


<div id="huibaotrendlist">
<c:forEach items="${huibaolist}" var="huibao" varStatus="status">
	<div>
		<div class='area_left3'>
		<span style='display:none;'>${status.index + 1}</span>
		<span class='area_span'>${AreaInfo.area_num}</span>
		<span class='area_span'>${huibao.project_type4}</span>
		<span class='area_span'>${huibao.view_shunxu4}</span>
		<span class='area_span'>${huibao.heng4}</span>
		<span class='area_span6'>${huibao.zong4}</span>
		</div>
		<div class='area_right3'>
		<span class='area_span4'><a href='#' class='edithuibaotrend'>编辑</a></span>
		<span class='area_span5'><a href='#' class='deletehuibaotrend'>删除</a></span>
		</div>
	</div>
</c:forEach>
</div>

<div class="area_bkg2 c-fix">区域特点</div>
<form id="tedian">
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="data_source" name="data_source" class="area_input"></span>
<input type="hidden" id="id" name="id" class="area_input">
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="update_time" name="update_time" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu" name="view_shunxu" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">区域特点</span><span><input type="text" id="area_character" name="area_character" class="area_input"></span>
</div>
</form>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addtedian">添加</a></span></div>

<div id="tedianlist">
<c:forEach items="${tedianlist}" var="tedian" varStatus="status">

<div>
	<div class='area_left3'>
	<span style='display:none;'>${status.index + 1}</span>
	<%-- <span class='area_span'>${AreaInfo.area_num}</span> --%>
	<%-- <span class='area_span'>${tedian.data_source}</span> --%>
	<%-- <span class='area_span'>${tedian.update_time }</span> --%>
	<span class='area_span'>${tedian.view_shunxu }</span>
	<span class='area_input'>${tedian.area_character}</span>
	</div>
	<div class='area_right3'>
	<span class='area_span4'><a href='#' class='edittedian'>编辑</a></span>
	<span class='area_span5'><a href='#' class='deletetedian'>删除</a></span>
	</div>
</div>
</c:forEach>

<!-- 
<div>
<div class="area_left3">
<span class="area_span">Rpdata</span><span class="area_span">2015/5/21</span><span class="area_span">1</span><span class="area_span">本区位于...</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div>

<div>
<div class="area_left3">
<span class="area_span">Rpdata</span><span class="area_span">2015/5/22</span><span class="area_span">2</span><span class="area_span">平均房价...</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div> -->

</div>


<div class="area_bkg2 c-fix">区域人口分布</div>
<form id="people">
<div class="area_left">
<span class="area_span">列1</span><span><input type="text" id="column1" name="column1" class="area_input"></span>
<input type="hidden" id="id" name="id" class="area_input">
</div>
<div class="area_right">
<span class="area_span">列2</span><span><input type="text" id="column2" name="column2" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">列3</span><span><input type="text" id="column3" name="column3" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu_people" name="view_shunxu_people" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="people_datasource" name="people_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="people_date" name="people_date" class="area_input"></span>
</div>
</form>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addpeople">添加</a></span></div>

<div id="peoplelist">
<c:forEach items="${peoplelist}" var="people" varStatus="status">

<div>
	<div class='area_left3'>
	<span style='display:none;'>${status.index + 1}</span>
	<span class='area_span'>${people.column1}</span>
	<span class='area_span'>${people.column2}</span>
	<span class='area_span'>${people.column3 }</span>
	<span class='area_span'>${people.view_shunxu_people}</span>
	</div>
	<div class='area_right3'>
	<span class='area_span4'><a href='#' class='editpeople'>编辑</a></span>
	<span class='area_span5'><a href='#' class='deletepeople'>删除</a></span>
	</div>
</div>
</c:forEach>
<!-- <div>
<div class="area_left3">
<span class="area_span">人口总数</span><span class="area_span">Nunawading</span><span class="area_span">Vic 维多利亚州</span><span class="area_span">1</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div>

<div>
<div class="area_left3">
<span class="area_span">人口</span><span class="area_span">10940</span><span class="area_span">5354042</span><span class="area_span">2</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div> -->

</div>




<div class="area_bkg2 c-fix">推荐经纪人</div>
<form id="broker">
<div class="area_left">
<span class="area_span">经纪人姓名</span>
<span>
<%-- <select class="area_select" id="broker_name" name="broker_name">
 <!--  <option value ="broker1">韩嵩</option>
  <option value ="broker2">李海涛</option>
  <option value ="broker3">阎松</option>
  <option value ="broker4">王舒</option>
  <option value ="broker5">张淑媛</option>
  <option value ="broker6">王菲</option> -->
   <c:forEach items="${brokerSet}" var="item">
        		 <option value="${item.id}">${item.broker_name}</option>
   </c:forEach>
</select> --%>
<select data-placeholder="请选择..." class="chosen-select" id="broker_name" name="broker_name" style="width:220px;" tabindex="5">
 	 <option value=""></option>
  	 <c:forEach items="${brokerSet}" var="item">
        		 <option value="${item.id}">${item.broker_name}</option>
    </c:forEach>
 </select>
</span>
</div>
<div class="area_right"></div>
</form>

<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addbroker">添加</a></span></div>

<div id="brokerlist">
<c:forEach items="${brokerlist}" var="broker" varStatus="status">
<div>
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
</div>
</c:forEach>
<!-- <div>
<div class="area_left3">
<span class="area_span">韩嵩</span><span class="area_span">房产经纪</span><span class="area_span">英文 中文</span><span class="area_span">北京</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div>
<div>
<div class="area_left3">
<span class="area_span">李海涛</span><span class="area_span">贷款经纪</span><span class="area_span">中文</span><span class="area_span">上海</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div> -->

</div>


<div class="area_bkg2 c-fix">推荐项目</div>
<form id="project">
<div class="area_left">
<span class="area_span">项目名称</span>
<span>

<select data-placeholder="请选择..." class="chosen-select" id="project_name" name="project_name" style="width:220px;" tabindex="6">
 	 <option value=""></option>
  	 <c:forEach items="${projectSet}" var="item">
        		 <option value="${item.id}">${item.project_name}</option>
   </c:forEach>
 </select>
</span>
</div>
<div class="area_right"></div>
</form>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addproject">添加</a></span></div>

<div id="projectlist">
<c:forEach items="${projectlist}" var="project" varStatus="status">
<!-- <div> -->
	<%-- <div class='area_left3'>
	<span style='display:none;'>${status.index + 1}</span>
	<span class='area_span' style='width: 340px;'>${project.project_name}</span>
	<span class='area_span'>${project.project_area}</span>
	<span class='area_span'>${project.project_price_qi}</span>
	<span class='area_span' style='width: 40px;'>${project.project_type}</span>
	</div>
	<div class='area_right3'>
	<span class='area_span5'><a href='#' class='deleteproject'>删除</a>
	</span>
	</div> --%>
	<div><div class='area_left3'>
	<span style='display:none;'>${status.index + 1}</span>
	<span class='area_span'  style='width: 336px;'>${project.project_name}</span>
	<span class='area_span'>${project.project_area}</span>
	<span class='area_span'>${project.project_price_qi}</span>
	<span class='area_span'  style='width: 40px;'>${project.project_type}</span>
	</div>
	<div class='area_right3'>
	<span class='area_span5'><a href='#' class='deleteproject'>删除</a></span>
	</div>
	</div>
<!-- </div> -->
</c:forEach>
<!-- <div>
<div class="area_left3">
<span class="area_span">The Atrium</span><span class="area_span">Nunawading</span><span class="area_span">6300元/平米（起）</span><span class="area_span">公寓</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div>

<div>
<div class="area_left3">
<span class="area_span">Thrive Parkside</span><span class="area_span">Parkville</span><span class="area_span">8000元/平米（起）</span><span class="area_span">公寓</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div> -->

</div>

<div class="area_bkg2 c-fix">新闻报道</div>
<form id="news">
<div class="area_left">
<span class="area_span">新闻类型</span>
<span>
<!-- <select class="area_select" id="news_type" name="news_type">
  <option value ="newsboke">新闻博客</option>
  <option value ="zhiyezhidao">置业指导</option>
</select> -->
<select data-placeholder="请选择..." class="chosen-select" id="news_type" name="news_type" style="width:220px;" tabindex="7">
 	 <option value=""></option>
  	 <option value ="newsboke">新闻博客</option>
     <option value ="zhiyezhidao">置业指导</option>
 </select>
</span>
</div>
<div class="area_right">
<span class="area_span">新闻标题</span>
<span>
<!-- <select class="area_select" id="news_title" name="news_title">
</select> -->
<select data-placeholder="请选择..." class="chosen-select" id="news_title" name="news_title" style="width:220px;" tabindex="8">
 	 <option value=""></option>
 </select>
</span>
</div>
</form>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#" class="addnews">添加</a></span></div>

<div id="newslist">
<c:forEach items="${newszhiyelist}" var="news" varStatus="status">
<div>
	<div class='area_left3'>
	<span style='display:none;'>${status.index + 1}</span>
	<span class='area_span' style='width:400px;'>${news.title}</span>
	<span class='area_span'>${news.people}</span>
	</div>
	<div class='area_right3'>
	<span class='area_span5'>
	<a href='#' class='deletenews'>删除</a>
	</span>
	</div>
</div>
</c:forEach>
<!-- <div>
<div class="area_left3">
<span class="area_span">澳洲购房指南...</span><span class="area_span">海房优选</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div>

<div>
<div class="area_left3">
<span class="area_span">澳各大银行...</span><span class="area_span">亿忆网</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
</div> -->
</div>

<div class="area_left4"><button type="submit" class="btn" onclick="savepro()">提交</button></div>
<div class="area_right4"><button type="reset" class="btn">重置</button></div>
</div>

<script type="text/javascript">
$('#touzi_date').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
$('#touzi_date1').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
$('#family_date').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
$('#middle_date').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
$('#middle_zoushi_date').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
$('#zujin_date').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
$('#zujin_huibao_date').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
$('#update_time').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
$('#people_date').datepicker({
    language: "zh-CN",
    format: "yyyy-mm-dd"
});
var newstitlelist1='${newsbokelist}';
var newstitlelist2='${zhiyelist}';
newstitlelist1=eval("("+newstitlelist1+")");
newstitlelist2=eval("("+newstitlelist2+")");

$(function(){
	$("#news_type").change(function(){
			
			if($(this).val()=="newsboke"){
				var optstr="";
				$.each(newstitlelist1,function(indexInArray,value){
						optstr+="<option value='"+value.id+"'>"+value.news_title+"</option>";
					});
				$("#news_title").html(optstr);
				$("#news_title").trigger("chosen:updated");
			}
			else if($(this).val()=="zhiyezhidao"){
				var optstr="";
				$.each(newstitlelist2,function(indexInArray,value){
					optstr+="<option value='"+value.id+"'>"+value.title+"</option>";
				});
				$("#news_title").html(optstr);
				$("#news_title").trigger("chosen:updated");
			}
		});
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
var middlepricelist='${middlepricebackendlistjson}';
middlepricelist=eval("("+middlepricelist+")");
var middlepriceedit=100;
var middlepriceedititem;
var middlepricecount=middlepricelist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addmiddleprice").click(function(){
		//alert(middlepriceedit);
		if(middlepriceedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var middleprice={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			middleprice=DataDeal.formToJson(data= decodeURIComponent($("#middleprice").serialize(),true));
			middleprice=middleprice.replace(/\+/g," ");
			middleprice=eval("("+middleprice+")");
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
			middlepricelist.push(middleprice);
			/* $("#middlepricelist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++middlepricecount)+"</span><span style='padding-right:10px;'>"+middlepricelist[middlepricecount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+middlepricelist[middlepricecount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+middlepricelist[middlepricecount-1].houseTaxdesc+"</span><span style='padding-right:10px;'>"+middlepricelist[middlepricecount-1].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>"); */
			$('#middlepricelist').append("<div><div class='area_left3'><span style='display:none;'>"+(++middlepricecount)+"</span><span class='area_span'>"+$("#area_num").val()+"</span><span class='area_span'>"+middlepricelist[middlepricecount-1].project_type+"</span><span class='area_span'>"+middlepricelist[middlepricecount-1].zu_price+"</span><span class='area_span'>"+middlepricelist[middlepricecount-1].buy_price+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editmiddleprice'>编辑</a></span><span class='area_span5'><a href='#' class='deletemiddleprice'>删除</a></span></div></div>");
			/* UpladFile("houseimg"); */
			$("#middleprice input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			middlepriceedititem=DataDeal.formToJson(data= decodeURIComponent($("#middleprice").serialize(),true));
			middlepriceedititem=middlepriceedititem.replace(/\+/g," ");
			middlepriceedititem=eval("("+middlepriceedititem+")");
			/* middlepriceedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#middleprice input").each(function(){
				$(this).val("");
				});
			middlepriceedititem.id=middlepricelist[middlepriceedit].id;
			middlepricelist[middlepriceedit]=middlepriceedititem;
			//alert($("#middlepricelist").children().eq(middlepriceedit));
			/* $("#middlepricelist").children().eq(middlepriceedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(middlepriceedit+1)+"</span><span style='padding-right:10px;'>"+middlepricelist[middlepriceedit].houseTaxtype+"</span><span style='padding-right:10px;'>"+middlepricelist[middlepriceedit].houseTaxprice+"</span><span style='padding-right:10px;'>"+middlepricelist[middlepriceedit].houseTaxdesc+"</span><span style='padding-right:10px;'>"+middlepricelist[middlepriceedit].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show(); */
			$("#middlepricelist").children().eq(middlepriceedit).html("<div class='area_left3'><span style='display:none;'>"+(middlepriceedit+1)+"</span><span class='area_span'>"+$("#area_num").val()+"</span><span class='area_span'>"+middlepricelist[middlepriceedit].project_type+"</span><span class='area_span'>"+middlepricelist[middlepriceedit].buy_price+"</span><span class='area_span'>"+middlepricelist[middlepriceedit].zu_price+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editmiddleprice'>编辑</a></span><span class='area_span5'><a href='#' class='deletemiddleprice'>删除</a></span></div>").show();

			middlepriceedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#middlepricelist").on("click",".deletemiddleprice",function(){
		middlepricelist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().parent().empty();
		middlepricecount--;
		});
	$("#middlepricelist").on("click",".editmiddleprice",function(){
		
		/* var index=$(this).parent().parent().parent().children().eq(0).children().eq(0).text()-1; */
		var index=$(this).parent().parent().parent().prevAll().length;
		//alert(index);
		middlepriceedititem=middlepricelist[index];
		$(this).parent().parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		middlepriceedit=index;
		var selectCount = document.getElementById("project_type");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==middlepriceedititem.project_type){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#project_type').trigger('chosen:updated');
		 $("#project_type").val(middlepriceedititem.project_type); 
		$("#buy_price").val(middlepriceedititem.buy_price);
		$("#zu_price").val(middlepriceedititem.zu_price);
		var selectCount = document.getElementById("buy_one_name");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==middlepriceedititem.buy_one_name){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#buy_one_name').trigger('chosen:updated');
		$("#buy_one_name").val(middlepriceedititem.buy_one_name);
		$("#buy_one_price").val(middlepriceedititem.buy_one_price);
		var selectCount = document.getElementById("buy_two_name");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==middlepriceedititem.buy_two_name){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#buy_two_name').trigger('chosen:updated');
		$("#buy_two_name").val(middlepriceedititem.buy_two_name);
		$("#buy_two_price").val(middlepriceedititem.buy_two_price);
		var selectCount = document.getElementById("buy_three_name");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==middlepriceedititem.buy_three_name){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#buy_three_name').trigger('chosen:updated');
		$("#buy_three_name").val(middlepriceedititem.buy_three_name);
		$("#buy_three_price").val(middlepriceedititem.buy_three_price);
		var selectCount = document.getElementById("zu_one_name");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==middlepriceedititem.zu_one_name){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#zu_one_name').trigger('chosen:updated');
		$("#zu_one_name").val(middlepriceedititem.zu_one_name);
		$("#zu_one_price").val(middlepriceedititem.zu_one_price);
		var selectCount = document.getElementById("zu_two_name");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==middlepriceedititem.zu_two_name){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#zu_two_name').trigger('chosen:updated');
		$("#zu_two_name").val(middlepriceedititem.zu_tow_name);
		$("#zu_two_price").val(middlepriceedititem.zu_two_price);
		var selectCount = document.getElementById("zu_three_name");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==middlepriceedititem.zu_three_name){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#zu_three_name').trigger('chosen:updated');
		$("#zu_three_name").val(middlepriceedititem.zu_three_name);
		$("#zu_three_price").val(middlepriceedititem.zu_three_price);
		$("#middle_datasource").val(middlepriceedititem.middle_datasource);
		$("#middle_date").val(middlepriceedititem.middle_date.length>=10?middlepriceedititem.middle_date.substr(0,10):middlepriceedititem.middle_date);
		}); 
	
});

var middletrendlist='${areamiddlelistjson}';
middletrendlist=eval("("+middletrendlist+")");
var middletrendedit=100;
var middletrendedititem;
var middletrendcount=middletrendlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addmiddletrend").click(function(){
		//alert(middletrendedit);
		if(middletrendedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var middletrend={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			middletrend=DataDeal.formToJson(data= decodeURIComponent($("#middletrend").serialize(),true));
			middletrend=middletrend.replace(/\+/g," ");
			middletrend=eval("("+middletrend+")");
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
			middletrendlist.push(middletrend);
			/* $("#middletrendlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++middletrendcount)+"</span><span style='padding-right:10px;'>"+middletrendlist[middletrendcount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+middletrendlist[middletrendcount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+middletrendlist[middletrendcount-1].houseTaxdesc+"</span><span style='padding-right:10px;'>"+middletrendlist[middletrendcount-1].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>"); */
			$('#middletrendlist').append("<div><div class='area_left3'><span style='display:none;'>"+(++middletrendcount)+"</span><span class='area_span'>"+$("#area_num").val()+"</span><span class='area_span'>"+middletrendlist[middletrendcount-1].project_type2+"</span><span class='area_span'>"+middletrendlist[middletrendcount-1].view_shunxu2+"</span><span class='area_span'>"+middletrendlist[middletrendcount-1].heng2+"</span><span class='area_span6'>"+middletrendlist[middletrendcount-1].zong2+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editmiddletrend'>编辑</a></span><span class='area_span5'><a href='#' class='deletemiddletrend'>删除</a></span></div></div>");
			/* UpladFile("houseimg"); */
			$("#middletrend input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			middletrendedititem=DataDeal.formToJson(data= decodeURIComponent($("#middletrend").serialize(),true));
			middletrendedititem=middletrendedititem.replace(/\+/g," ");
			middletrendedititem=eval("("+middletrendedititem+")");
			/* middletrendedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#middletrend input").each(function(){
				$(this).val("");
				});
			middletrendlist[middletrendedit]=middletrendedititem;
			//alert($("#middletrendlist").children().eq(middletrendedit));
			/* $("#middletrendlist").children().eq(middletrendedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(middletrendedit+1)+"</span><span style='padding-right:10px;'>"+middletrendlist[middletrendedit].houseTaxtype+"</span><span style='padding-right:10px;'>"+middletrendlist[middletrendedit].houseTaxprice+"</span><span style='padding-right:10px;'>"+middletrendlist[middletrendedit].houseTaxdesc+"</span><span style='padding-right:10px;'>"+middletrendlist[middletrendedit].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show(); */
			$("#middletrendlist").children().eq(middletrendedit).html("<div class='area_left3'><span style='display:none;'>"+(middletrendedit+1)+"</span><span class='area_span'>"+$("#area_num").val()+"</span><span class='area_span'>"+middletrendlist[middletrendedit].project_type2+"</span><span class='area_span'>"+middletrendlist[middletrendedit].view_shunxu2+"</span><span class='area_span'>"+middletrendlist[middletrendedit].heng2+"</span><span class='area_span6'>"+middletrendlist[middletrendedit].zong2+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editmiddletrend'>编辑</a></span><span class='area_span5'><a href='#' class='deletemiddletrend'>删除</a></span></div>").show();

			middletrendedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#middletrendlist").on("click",".deletemiddletrend",function(){
		middletrendlist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().parent().remove();
		middletrendcount--;
		});
	$("#middletrendlist").on("click",".editmiddletrend",function(){
		
		var index=$(this).parent().parent().parent().prevAll().length;
		//alert(index);
		middletrendedititem=middletrendlist[index];
		$(this).parent().parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		middletrendedit=index;
		/* $("#project_type2").val(middletrendedititem.project_type2||middletrendedititem.project_type);
		$("#view_shunxu2").val(middletrendedititem.view_shunxu2||middletrendedititem.view_shunxu); */
		var selectCount = document.getElementById("project_type2");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==middletrendedititem.project_type2){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#project_type2').trigger('chosen:updated');
		$("#view_shunxu2").val(middletrendedititem.view_shunxu2);
		$("#heng2").val(middletrendedititem.heng2||middletrendedititem.heng);
		$("#zong2").val(middletrendedititem.zong2||middletrendedititem.zong);
		$("#middle_zoushi_datasource").val(middletrendedititem.middle_zoushi_datasource);
		$("#middle_zoushi_date").val(middletrendedititem.middle_zoushi_date.length>=10?middletrendedititem.middle_zoushi_date.substr(0,10):middletrendedititem.middle_zoushi_date);
		}); 
	
});


var zujintrendlist='${zujinlistjson}';
zujintrendlist=eval("("+zujintrendlist+")");
var zujintrendedit=100;
var zujintrendedititem;
var zujintrendcount=zujintrendlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addzujintrend").click(function(){
		//alert(zujintrendedit);
		if(zujintrendedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var zujintrend={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			zujintrend=DataDeal.formToJson(data= decodeURIComponent($("#zujintrend").serialize(),true));
			zujintrend=zujintrend.replace(/\+/g," ");
			zujintrend=eval("("+zujintrend+")");
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
			zujintrendlist.push(zujintrend);
			/* $("#zujintrendlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++zujintrendcount)+"</span><span style='padding-right:10px;'>"+zujintrendlist[zujintrendcount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+zujintrendlist[zujintrendcount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+zujintrendlist[zujintrendcount-1].houseTaxdesc+"</span><span style='padding-right:10px;'>"+zujintrendlist[zujintrendcount-1].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>"); */
			$('#zujintrendlist').append("<div><div class='area_left3'><span style='display:none;'>"+(++zujintrendcount)+"</span><span class='area_span'>"+$("#area_num").val()+"</span><span class='area_span'>"+zujintrendlist[zujintrendcount-1].project_type3+"</span><span class='area_span'>"+zujintrendlist[zujintrendcount-1].view_shunxu3+"</span><span class='area_span'>"+zujintrendlist[zujintrendcount-1].heng3+"</span><span class='area_span6'>"+zujintrendlist[zujintrendcount-1].zong3+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editzujintrend'>编辑</a></span><span class='area_span5'><a href='#' class='deletezujintrend'>删除</a></span></div></div>");
			/* UpladFile("houseimg"); */
			$("#zujintrend input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			zujintrendedititem=DataDeal.formToJson(data= decodeURIComponent($("#zujintrend").serialize(),true));
			zujintrendedititem=zujintrendedititem.replace(/\+/g," ");
			zujintrendedititem=eval("("+zujintrendedititem+")");
			/* zujintrendedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#zujintrend input").each(function(){
				$(this).val("");
				});
			zujintrendlist[zujintrendedit]=zujintrendedititem;
			//alert($("#zujintrendlist").children().eq(zujintrendedit));
			/* $("#zujintrendlist").children().eq(zujintrendedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(zujintrendedit+1)+"</span><span style='padding-right:10px;'>"+zujintrendlist[zujintrendedit].houseTaxtype+"</span><span style='padding-right:10px;'>"+zujintrendlist[zujintrendedit].houseTaxprice+"</span><span style='padding-right:10px;'>"+zujintrendlist[zujintrendedit].houseTaxdesc+"</span><span style='padding-right:10px;'>"+zujintrendlist[zujintrendedit].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show(); */
			$("#zujintrendlist").children().eq(zujintrendedit).html("<div class='area_left3'><span style='display:none;'>"+(zujintrendedit+1)+"</span><span class='area_span'>"+$("#area_num").val()+"</span><span class='area_span'>"+zujintrendlist[zujintrendedit].project_type3+"</span><span class='area_span'>"+zujintrendlist[zujintrendedit].view_shunxu3+"</span><span class='area_span'>"+zujintrendlist[zujintrendedit].heng3+"</span><span class='area_span6'>"+zujintrendlist[zujintrendedit].zong3+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editzujintrend'>编辑</a></span><span class='area_span5'><a href='#' class='deletezujintrend'>删除</a></span></div>").show();

			zujintrendedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#zujintrendlist").on("click",".deletezujintrend",function(){
		zujintrendlist.splice($(this).parent().parent().parent().prevAll().length,1);
		$(this).parent().parent().parent().remove();
		zujintrendcount--;
		});
	$("#zujintrendlist").on("click",".editzujintrend",function(){
		
		var index=$(this).parent().parent().parent().prevAll().length;
		//alert(index);
		zujintrendedititem=zujintrendlist[index];
		$(this).parent().parent().parent().hide();
		/* //alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		zujintrendedit=index;
		var selectCount = document.getElementById("project_type3");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==zujintrendedititem.project_type3){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#project_type3').trigger('chosen:updated');
		$("#project_type3").val(zujintrendedititem.project_type3||zujintrendedititem.project_type);
		$("#view_shunxu3").val(zujintrendedititem.view_shunxu3||zujintrendedititem.view_shunxu);
		$("#heng3").val(zujintrendedititem.heng3||zujintrendedititem.heng);
		$("#zong3").val(zujintrendedititem.zong3||zujintrendedititem.zong);
		$("#zujin_datasource").val(zujintrendedititem.zujin_datasource||zujintrendedititem.zujin_datasource);
		$("#zujin_date").val(zujintrendedititem.zujin_date.length>=10?zujintrendedititem.zujin_date.substr(0,10):zujintrendedititem.zujin_date);
		}); 
	
});



var huibaotrendlist='${huibaolistjson}';
huibaotrendlist=eval("("+huibaotrendlist+")");
var huibaotrendedit=100;
var huibaotrendedititem;
var huibaotrendcount=huibaotrendlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addhuibaotrend").click(function(){
		//alert(huibaotrendedit);
		if(huibaotrendedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var huibaotrend={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			huibaotrend=DataDeal.formToJson(data= decodeURIComponent($("#huibaotrend").serialize(),true));
			huibaotrend=huibaotrend.replace(/\+/g," ");
			huibaotrend=eval("("+huibaotrend+")");
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
			huibaotrendlist.push(huibaotrend);
			/* $("#huibaotrendlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++huibaotrendcount)+"</span><span style='padding-right:10px;'>"+huibaotrendlist[huibaotrendcount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+huibaotrendlist[huibaotrendcount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+huibaotrendlist[huibaotrendcount-1].houseTaxdesc+"</span><span style='padding-right:10px;'>"+huibaotrendlist[huibaotrendcount-1].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>"); */
			$('#huibaotrendlist').append("<div><div class='area_left3'><span style='display:none;'>"+(++huibaotrendcount)+"</span><span class='area_span'>"+$("#area_num").val()+"</span><span class='area_span'>"+huibaotrendlist[huibaotrendcount-1].project_type4+"</span><span class='area_span'>"+huibaotrendlist[huibaotrendcount-1].view_shunxu4+"</span><span class='area_span'>"+huibaotrendlist[huibaotrendcount-1].heng4+"</span><span class='area_span6'>"+huibaotrendlist[huibaotrendcount-1].zong4+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='edithuibaotrend'>编辑</a></span><span class='area_span5'><a href='#' class='deletehuibaotrend'>删除</a></span></div></div>");
			/* UpladFile("houseimg"); */
			$("#huibaotrend input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			huibaotrendedititem=DataDeal.formToJson(data= decodeURIComponent($("#huibaotrend").serialize(),true));
			huibaotrendedititem=huibaotrendedititem.replace(/\+/g," ");
			huibaotrendedititem=eval("("+huibaotrendedititem+")");
			/* huibaotrendedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#huibaotrend input").each(function(){
				$(this).val("");
				});
			huibaotrendlist[huibaotrendedit]=huibaotrendedititem;
			//alert($("#huibaotrendlist").children().eq(huibaotrendedit));
			/* $("#huibaotrendlist").children().eq(huibaotrendedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(huibaotrendedit+1)+"</span><span style='padding-right:10px;'>"+huibaotrendlist[huibaotrendedit].houseTaxtype+"</span><span style='padding-right:10px;'>"+huibaotrendlist[huibaotrendedit].houseTaxprice+"</span><span style='padding-right:10px;'>"+huibaotrendlist[huibaotrendedit].houseTaxdesc+"</span><span style='padding-right:10px;'>"+huibaotrendlist[huibaotrendedit].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show(); */
			$("#huibaotrendlist").children().eq(huibaotrendedit).html("<div class='area_left3'><span style='display:none;'>"+(huibaotrendedit+1)+"</span><span class='area_span'>"+$("#area_num").val()+"</span><span class='area_span'>"+huibaotrendlist[huibaotrendedit].project_type4+"</span><span class='area_span'>"+huibaotrendlist[huibaotrendedit].view_shunxu4+"</span><span class='area_span'>"+huibaotrendlist[huibaotrendedit].heng4+"</span><span class='area_span6'>"+huibaotrendlist[huibaotrendedit].zong4+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='edithuibaotrend'>编辑</a></span><span class='area_span5'><a href='#' class='deletehuibaotrend'>删除</a></span></div>").show();

			huibaotrendedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#huibaotrendlist").on("click",".deletehuibaotrend",function(){
		huibaotrendlist.splice($(this).parent().parent().parent().prevAll().length,1);
		$(this).parent().parent().parent().remove();
		huibaotrendcount--;
		});
	$("#huibaotrendlist").on("click",".edithuibaotrend",function(){
		
		var index=$(this).parent().parent().parent().prevAll().length;
		//alert(index);
		huibaotrendedititem=huibaotrendlist[index];
		$(this).parent().parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		huibaotrendedit=index;
		var selectCount = document.getElementById("project_type4");
		for(var i = 0 ; i<selectCount.length;i++){
			if(selectCount.options[i].value==huibaotrendedititem.project_type4){			
				selectCount.options[i].selected=true;				
			}
		}
		$('#project_type4').trigger('chosen:updated');
		$("#project_type4").val(huibaotrendedititem.project_type4||huibaotrendedititem.project_type);
		$("#view_shunxu4").val(huibaotrendedititem.view_shunxu4||huibaotrendedititem.view_shunxu);
		$("#heng4").val(huibaotrendedititem.heng4||huibaotrendedititem.heng);
		$("#zong4").val(huibaotrendedititem.zong4||huibaotrendedititem.zong); 
		$("#zujin_huibao_datasource").val(huibaotrendedititem.zujin_huibao_datasource||huibaotrendedititem.zujin_huibao_datasource);
		$("#zujin_huibao_date").val(huibaotrendedititem.zujin_huibao_date.length>=10?huibaotrendedititem.zujin_huibao_date.substr(0,10):huibaotrendedititem.zujin_huibao_date);
		}); 
	
});




var tedianlist='${tedianlistjson}';
tedianlist=eval("("+tedianlist+")");
var tedianedit=100;
var tedianedititem;
var tediancount=tedianlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addtedian").click(function(){
		//alert(tedianedit);
		if(tedianedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var tedian={};
			tedian=DataDeal.formToJson(data= decodeURIComponent($("#tedian").serialize(),true));
			tedian=tedian.replace(/\+/g," ");
			tedian=eval("("+tedian+")");
			tedianlist.push(tedian);
			/* $("#tedianlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++tediancount)+"</span><span style='padding-right:10px;'>"+tedianlist[tediancount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+tedianlist[tediancount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+tedianlist[tediancount-1].houseTaxdesc+"</span><span style='padding-right:10px;'>"+tedianlist[tediancount-1].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>"); */
			$('#tedianlist').append("<div><div class='area_left3'><span style='display:none;'>"+(++tediancount)+"</span><span class='area_span'>"+tedianlist[tediancount-1].view_shunxu+"</span><span class='area_input'>"+tedianlist[tediancount-1].area_character+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='edittedian'>编辑</a></span><span class='area_span5'><a href='#' class='deletetedian'>删除</a></span></div></div>");
			/* UpladFile("houseimg"); */
			$("#tedian input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			tedianedititem=DataDeal.formToJson(data= decodeURIComponent($("#tedian").serialize(),true));
			tedianedititem=tedianedititem.replace(/\+/g," ");
			tedianedititem=eval("("+tedianedititem+")");
			$("#tedian input").each(function(){
				$(this).val("");
				});
			tedianlist[tedianedit]=tedianedititem;
			//alert($("#tedianlist").children().eq(tedianedit));
			/* $("#tedianlist").children().eq(tedianedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(tedianedit+1)+"</span><span style='padding-right:10px;'>"+tedianlist[tedianedit].houseTaxtype+"</span><span style='padding-right:10px;'>"+tedianlist[tedianedit].houseTaxprice+"</span><span style='padding-right:10px;'>"+tedianlist[tedianedit].houseTaxdesc+"</span><span style='padding-right:10px;'>"+tedianlist[tedianedit].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show(); */
			$("#tedianlist").children().eq(tedianedit).html("<div class='area_left3'><span style='display:none;'>"+(tedianedit+1)+"</span><span class='area_span'>"+tedianlist[tedianedit].view_shunxu+"</span><span class='area_input'>"+tedianlist[tedianedit].area_character+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='edittedian'>编辑</a></span><span class='area_span5'><a href='#' class='deletetedian'>删除</a></span></div>").show();

			tedianedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#tedianlist").on("click",".deletetedian",function(){
		tedianlist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().parent().remove();
		tediancount--;
		});
	$("#tedianlist").on("click",".edittedian",function(){
		
		var index=$(this).parent().parent().parent().prevAll().length;
		//alert(index);
		tedianedititem=tedianlist[index];
		$(this).parent().parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		tedianedit=index;
		$("#data_source").val(tedianedititem.data_source);
		$("#update_time").val(tedianedititem.update_time.length>=10?tedianedititem.update_time.substr(0,10):tedianedititem.update_time);
		$("#view_shunxu").val(tedianedititem.view_shunxu);
		$("#area_character").val(tedianedititem.area_character);
		}); 
	
});



var peoplelist='${peoplelistjson}';
peoplelist=eval("("+peoplelist+")");
var peopleedit=100;
var peopleedititem;
var peoplecount=peoplelist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addpeople").click(function(){
		//alert(peopleedit);
		if(peopleedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var people={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			people=DataDeal.formToJson(data= decodeURIComponent($("#people").serialize(),true));
			people=people.replace(/\+/g," ");
			people=eval("("+people+")");
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
			peoplelist.push(people);
			/* $("#peoplelist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peoplecount)+"</span><span style='padding-right:10px;'>"+peoplelist[peoplecount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+peoplelist[peoplecount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+peoplelist[peoplecount-1].houseTaxdesc+"</span><span style='padding-right:10px;'>"+peoplelist[peoplecount-1].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>"); */
			$('#peoplelist').append("<div><div class='area_left3'><span style='display:none;'>"+(++peoplecount)+"</span><span class='area_span'>"+peoplelist[peoplecount-1].column1+"</span><span class='area_span'>"+peoplelist[peoplecount-1].column2+"</span><span class='area_span'>"+peoplelist[peoplecount-1].column3+"</span><span class='area_span'>"+peoplelist[peoplecount-1].view_shunxu_people+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editpeople'>编辑</a></span><span class='area_span5'><a href='#' class='deletepeople'>删除</a></span></div></div>");
			/* UpladFile("houseimg"); */
			$("#people input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			peopleedititem=DataDeal.formToJson(data= decodeURIComponent($("#people").serialize(),true));
			peopleedititem=peopleedititem.replace(/\+/g," ");
			peopleedititem=eval("("+peopleedititem+")");
			/* peopleedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#people input").each(function(){
				$(this).val("");
				});
			peoplelist[peopleedit]=peopleedititem;
			alert($("#peoplelist").children().eq(peopleedit));
			/* $("#peoplelist").children().eq(peopleedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(peopleedit+1)+"</span><span style='padding-right:10px;'>"+peoplelist[peopleedit].houseTaxtype+"</span><span style='padding-right:10px;'>"+peoplelist[peopleedit].houseTaxprice+"</span><span style='padding-right:10px;'>"+peoplelist[peopleedit].houseTaxdesc+"</span><span style='padding-right:10px;'>"+peoplelist[peopleedit].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show(); */
			$("#peoplelist").children().eq(peopleedit).html("<div class='area_left3'><span style='display:none;'>"+(peopleedit+1)+"</span><span class='area_span'>"+peoplelist[peopleedit].column1+"</span><span class='area_span'>"+peoplelist[peopleedit].column2+"</span><span class='area_span'>"+peoplelist[peopleedit].column3+"</span><span class='area_span'>"+peoplelist[peopleedit].view_shunxu_people+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editpeople'>编辑</a></span><span class='area_span5'><a href='#' class='deletepeople'>删除</a></span></div>").show();

			peopleedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#peoplelist").on("click",".deletepeople",function(){
		peoplelist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().parent().remove();
		peoplecount--;
		});
	$("#peoplelist").on("click",".editpeople",function(){
		
		var index=$(this).parent().parent().parent().prevAll().length;
		//alert(index);
		peopleedititem=peoplelist[index];
		$(this).parent().parent().parent().hide();
		/* alert(huxingedititem.name); */
		//$("#projectimage").val(edititem.name+"");
		//alert(index+"index");
		peopleedit=index;
		$("#column1").val(peopleedititem.column1);
		$("#column2").val(peopleedititem.column2);
		$("#column3").val(peopleedititem.column3);
		$("#view_shunxu_people").val(peopleedititem.view_shunxu_people);
		$("#people_datasource").val(peopleedititem.people_datasource);
		$("#people_date").val(peopleedititem.people_date.length>=10?peopleedititem.people_date.substr(0,10):peopleedititem.people_date);
		}); 
	
});


var brokerlist='${brokerlistjson}';
brokerlist=eval("("+brokerlist+")");
var brokeredit=100;
var brokeredititem;
var brokercount=brokerlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addbroker").click(function(){
		//alert(brokeredit);
		if(brokeredit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var broker={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			broker=DataDeal.formToJson(data= decodeURIComponent($("#broker").serialize(),true));
			broker=broker.replace(/\+/g," ");
			broker=eval("("+broker+")");
			$.ajax({
				  url: "/getjingjireninfo",
				  method: "POST",
				  data: {id : broker.broker_name},
				  dataType: "json",
				  success:function (data,textStatus,jqXHR){
					  brokerlist.push(data);
					  $('#brokerlist').append("<div><div class='area_left3'><span style='display:none;'>"+(++brokercount)+"</span><span class='area_span'>"+brokerlist[brokercount-1].broker_name+"</span><span class='area_span'>"+brokerlist[brokercount-1].broker_type+"</span><span class='area_span'>"+brokerlist[brokercount-1].broker_language+"</span><span class='area_span'>"+brokerlist[brokercount-1].broker_region+"</span></div><div class='area_right3'><span class='area_span5'><a href='#' class='deletebroker'>删除</a></span></div></div>");
					  }
				});
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
			/* brokerlist.push(broker); */
			/* $("#brokerlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++brokercount)+"</span><span style='padding-right:10px;'>"+brokerlist[brokercount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+brokerlist[brokercount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+brokerlist[brokercount-1].houseTaxdesc+"</span><span style='padding-right:10px;'>"+brokerlist[brokercount-1].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>"); */
			/* $('#brokerlist').append("<div><div class='area_left3'><span style='display:none;'>"+(++brokercount)+"</span><span class='area_span'>"+brokerlist[brokercount-1].column1+"</span><span class='area_span'>"+brokerlist[brokercount-1].column2+"</span><span class='area_span'>"+brokerlist[brokercount-1].column3+"</span><span class='area_span'>"+brokerlist[brokercount-1].view_shunxu_broker+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editbroker'>编辑</a></span><span class='area_span5'><a href='#' class='deletebroker'>删除</a></span></div></div>"); */
			/* UpladFile("houseimg"); */
			$("#broker input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			brokeredititem=DataDeal.formToJson(data= decodeURIComponent($("#broker").serialize(),true));
			brokeredititem=brokeredititem.replace(/\+/g," ");
			brokeredititem=eval("("+brokeredititem+")");
			/* brokeredititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#broker input").each(function(){
				$(this).val("");
				});
			brokerlist[brokeredit]=brokeredititem;
			alert($("#brokerlist").children().eq(brokeredit));
			/* $("#brokerlist").children().eq(brokeredit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(brokeredit+1)+"</span><span style='padding-right:10px;'>"+brokerlist[brokeredit].houseTaxtype+"</span><span style='padding-right:10px;'>"+brokerlist[brokeredit].houseTaxprice+"</span><span style='padding-right:10px;'>"+brokerlist[brokeredit].houseTaxdesc+"</span><span style='padding-right:10px;'>"+brokerlist[brokeredit].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show(); */
			$("#brokerlist").children().eq(brokeredit).html("<div class='area_left3'><span style='display:none;'>"+(brokeredit+1)+"</span><span class='area_span'>"+brokerlist[brokeredit].column1+"</span><span class='area_span'>"+brokerlist[brokeredit].column2+"</span><span class='area_span'>"+brokerlist[brokeredit].column3+"</span><span class='area_span'>"+brokerlist[brokeredit].view_shunxu_broker+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editbroker'>编辑</a></span><span class='area_span5'><a href='#' class='deletebroker'>删除</a></span></div>").show();

			brokeredit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#brokerlist").on("click",".deletebroker",function(){
		brokerlist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().parent().remove();
		brokercount--;
		});
});



var projectlist='${projectlistjson}';
projectlist=eval("("+projectlist+")");
var projectedit=100;
var projectedititem;
var projectcount=projectlist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addproject").click(function(){
		//alert(projectedit);
		if(projectedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var project={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			project=DataDeal.formToJson(data= decodeURIComponent($("#project").serialize(),true));
			project=project.replace(/\+/g," ");
			project=eval("("+project+")");
			$.ajax({
				  url: "/getprojectinfo",
				  method: "POST",
				  data: {id : project.project_name},
				  dataType: "json",
				  success:function (data,textStatus,jqXHR){
					  projectlist.push(data);
					  $('#projectlist').append("<div><div class='area_left3'><span style='display:none;'>"+(++projectcount)+"</span><span class='area_span'  style='width: 340px;'>"+projectlist[projectcount-1].project_name+"</span><span class='area_span'>"+projectlist[projectcount-1].project_area+"</span><span class='area_span'>"+projectlist[projectcount-1].project_price_qi+"</span><span class='area_span'  style='width: 40px;'>"+projectlist[projectcount-1].project_type+"</span></div><div class='area_right3'><span class='area_span5'><a href='#' class='deleteproject'>删除</a></span></div></div>");
					  }
				});
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
			/* projectlist.push(project); */
			/* $("#projectlist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++projectcount)+"</span><span style='padding-right:10px;'>"+projectlist[projectcount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+projectlist[projectcount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+projectlist[projectcount-1].houseTaxdesc+"</span><span style='padding-right:10px;'>"+projectlist[projectcount-1].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>"); */
			/* $('#projectlist').append("<div><div class='area_left3'><span style='display:none;'>"+(++projectcount)+"</span><span class='area_span'>"+projectlist[projectcount-1].column1+"</span><span class='area_span'>"+projectlist[projectcount-1].column2+"</span><span class='area_span'>"+projectlist[projectcount-1].column3+"</span><span class='area_span'>"+projectlist[projectcount-1].view_shunxu_project+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editproject'>编辑</a></span><span class='area_span5'><a href='#' class='deleteproject'>删除</a></span></div></div>"); */
			/* UpladFile("houseimg"); */
			$("#project input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			projectedititem=DataDeal.formToJson(data= decodeURIComponent($("#project").serialize(),true));
			projectedititem=projectedititem.replace(/\+/g," ");
			projectedititem=eval("("+projectedititem+")");
			/* projectedititem["houseimg"]=filename; */
			/* var filenames=$('#projectimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#project input").each(function(){
				$(this).val("");
				});
			projectlist[projectedit]=projectedititem;
			//alert($("#projectlist").children().eq(projectedit));
			/* $("#projectlist").children().eq(projectedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(projectedit+1)+"</span><span style='padding-right:10px;'>"+projectlist[projectedit].houseTaxtype+"</span><span style='padding-right:10px;'>"+projectlist[projectedit].houseTaxprice+"</span><span style='padding-right:10px;'>"+projectlist[projectedit].houseTaxdesc+"</span><span style='padding-right:10px;'>"+projectlist[projectedit].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show(); */
			$("#projectlist").children().eq(projectedit).html("<div class='area_left3'><span style='display:none;'>"+(projectedit+1)+"</span><span class='area_span'>"+projectlist[projectedit].column1+"</span><span class='area_span'>"+projectlist[projectedit].column2+"</span><span class='area_span'>"+projectlist[projectedit].column3+"</span><span class='area_span'>"+projectlist[projectedit].view_shunxu_project+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editproject'>编辑</a></span><span class='area_span5'><a href='#' class='deleteproject'>删除</a></span></div>").show();

			projectedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#projectlist").on("click",".deleteproject",function(){
		projectlist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().parent().remove();
		projectcount--;
		});
});


var newslist='${newszhiyelistjson}';
newslist=eval("("+newslist+")");
var newsedit=100;
var newsedititem;
var newscount=newslist.length;
$(function(){
	$.ajaxSetup({  
	    contentType: "application/x-www-form-urlencoded; charset=utf-8"  
	});  
	$(".addnews").click(function(){
		//alert(newsedit);
		if(newsedit==100){
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			var news={};
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			news=DataDeal.formToJson(data= decodeURIComponent($("#news").serialize(),true));
			news=news.replace(/\+/g," ");
			news=eval("("+news+")");
			$.ajax({
				  url: "/getnewsinfo",
				  method: "POST",
				  data: {id : news.news_title,type:news.news_type},
				  dataType: "json",
				  success:function (data,textStatus,jqXHR){
					  newslist.push(data);
					  if(data.title){
						  $('#newslist').append("<div><div class='area_left3'><span style='display:none;'>"+(++newscount)+"</span><span class='area_span' style='width:400px;'>"+newslist[newscount-1].title+"</span><span class='area_span'>"+newslist[newscount-1].fabu_people+"</span></div><div class='area_right3'><span class='area_span5'><a href='#' class='deletenews'>删除</a></span></div></div>");
					  }
					  else{
						  $('#newslist').append("<div><div class='area_left3'><span style='display:none;'>"+(++newscount)+"</span><span class='area_span' style='width:400px;'>"+newslist[newscount-1].news_title+"</span><span class='area_span'>"+newslist[newscount-1].news_people+"</span></div><div class='area_right3'><span class='area_span5'><a href='#' class='deletenews'>删除</a></span></div></div>");
					  		}
					  }
				});
			/* huxing["houseimg"]=filename *//* $('#newsimage').val() */;
			/* peitao.shunxu=peitaocount+1; */
			/* peitao.view= */
			/* alert($("#huxingjiage").serializeArray()); */
			/* huxing.housename=$("#housename").val();
			huxing.houseprice=$("#houseprice").val();
			huxing.room_num=$("#room_num").val();
			huxing.tudi_mianji=$("#tudi_mianji").val();
			huxing.jianzhu_mianji=$("#jianzhu_mianji").val();
			huxing.shinei_mianji=$("#") */
			/* newslist.push(news); */
			/* $("#newslist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++newscount)+"</span><span style='padding-right:10px;'>"+newslist[newscount-1].houseTaxtype+"</span><span style='padding-right:10px;'>"+newslist[newscount-1].houseTaxprice+"</span><span style='padding-right:10px;'>"+newslist[newscount-1].houseTaxdesc+"</span><span style='padding-right:10px;'>"+newslist[newscount-1].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>"); */
			/* $('#newslist').append("<div><div class='area_left3'><span style='display:none;'>"+(++newscount)+"</span><span class='area_span'>"+newslist[newscount-1].column1+"</span><span class='area_span'>"+newslist[newscount-1].column2+"</span><span class='area_span'>"+newslist[newscount-1].column3+"</span><span class='area_span'>"+newslist[newscount-1].view_shunxu_news+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editnews'>编辑</a></span><span class='area_span5'><a href='#' class='deletenews'>删除</a></span></div></div>"); */
			/* UpladFile("houseimg"); */
			$("#news input").each(function(){
				$(this).val("");
				});
			/* $("#huxingjiage").reset();  */
			/* <a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a> */
			}
		else{
			/* if($('#houseimg').val()==""){
				alert("请选择文件！");
				return false;} */
			//alert("edit");
			/* var huxing={}; */
			/* var filenames=$('#houseimg').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			newsedititem=DataDeal.formToJson(data= decodeURIComponent($("#news").serialize(),true));
			newsedititem=newsedititem.replace(/\+/g," ");
			newsedititem=eval("("+newsedititem+")");
			/* newsedititem["houseimg"]=filename; */
			/* var filenames=$('#newsimage').val().split("\\");
			var filename=filenames[filenames.length-1]; */
			/* UpladFile("houseimg"); */
			$("#news input").each(function(){
				$(this).val("");
				});
			newslist[newsedit]=newsedititem;
			//alert($("#newslist").children().eq(newsedit));
			/* $("#newslist").children().eq(newsedit).html("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(newsedit+1)+"</span><span style='padding-right:10px;'>"+newslist[newsedit].houseTaxtype+"</span><span style='padding-right:10px;'>"+newslist[newsedit].houseTaxprice+"</span><span style='padding-right:10px;'>"+newslist[newsedit].houseTaxdesc+"</span><span style='padding-right:10px;'>"+newslist[newsedit].houseTax_housename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>").show(); */
			$("#newslist").children().eq(newsedit).html("<div class='area_left3'><span style='display:none;'>"+(newsedit+1)+"</span><span class='area_span'>"+newslist[newsedit].column1+"</span><span class='area_span'>"+newslist[newsedit].column2+"</span><span class='area_span'>"+newslist[newsedit].column3+"</span><span class='area_span'>"+newslist[newsedit].view_shunxu_news+"</span></div><div class='area_right3'><span class='area_span4'><a href='#' class='editnews'>编辑</a></span><span class='area_span5'><a href='#' class='deletenews'>删除</a></span></div>").show();

			newsedit=100;
			//$("#peitaolist").append("<div style='float:left;padding-left:40px;'><span style='padding-right:10px;'>"+(++peitaocount)+"</span><span class=''>"+filename+"</span><span style='padding-left: 30px;padding-right: 40px;'><a href='#' style='padding-right:10px;' class='editpeitao'>编辑</a><a href='#' class='deletepeitao'>删除</a></span></div>");
			/*peitao.view= */
			
			}
		});
	$("#newslist").on("click",".deletenews",function(){
		newslist.splice($(this).parent().parent().prevAll().length,1);
		$(this).parent().parent().parent().remove();
		newscount--;
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

function savepro(){

	var area;
	area=DataDeal.formToJson(data= decodeURIComponent($("#area").serialize(),true));
	area=area.replace(/\+\"\,\"\+/, " & ").replace(/\+/," ");
	/* area=area; */
	/* alert(area); */
	area=eval("("+area+")");
	//alert("ff1")
	/* area.family_datasource=$("#family_datasource").val(); */
	/* alert(JSON.stringify(area)); */
	var id1=$("#id1").val();
	var id2=$("#id2").val();
	var id3=$("#id3").val();
	var id21=$("#id21").val();
    $.ajax({
	    type: "POST",
 		async:false, 
		dateType: "json",
		data:{"id":id1.toString(),"id2":id2.toString(),"id21":id21.toString(),"id3":id3.toString(),"area":JSON.stringify(area),"middleprice":JSON.stringify(middlepricelist),"middletrend":JSON.stringify(middletrendlist),"zujintrendlist":JSON.stringify(zujintrendlist),"huibaotrendlist":JSON.stringify(huibaotrendlist),"tedianlist":JSON.stringify(tedianlist),"peoplelist":JSON.stringify(peoplelist),"brokerlist":JSON.stringify(brokerlist),"projectlist":JSON.stringify(projectlist),"newslist":JSON.stringify(newslist)},
		url: "/EditAreaInfo",
		success:function(data){
			data=eval("("+data+")");
			/* if(data.isDuplicate==1){
				alert("区域编号已存在！");
			} */
			if(data.flag==1)
			{
				alert("更新成功");
			}
			else if(data.flag==0){
				alert("更新失败");
			}
		},
		error:function(a,b,c){
			/* alert(a);
			alert(b);
			alert(c); */
			alert("error");
		}
    });
}
	
</script>
<script type="text/javascript">
CKEDITOR.replace( 'detail' );
</script>
<script type="text/javascript">
function addMiddlePrice(){
	  var buy_price=$("#buy_price").val();
	  var zu_price=$("#zu_price").val();
	  var buy_one_name=$("#buy_one_name").val();
	  var buy_one_price=$("#buy_one_price").val();
	  var buy_two_name=$("#buy_two_name").val();
	  var buy_two_price=$("#buy_two_price").val();
	  var buy_three_name=$("#buy_three_name").val();
	  var buy_three_price=$("#buy_three_price").val();
	  var zu_one_name=$("#zu_one_name").val();
	  var zu_one_price=$("#zu_one_price").val();
	  var zu_two_name=$("#zu_two_name").val();
	  var zu_two_price=$("#zu_two_price").val();
	  var zu_three_name=$("#zu_three_name").val();
	  var zu_three_price=$("#zu_three_price").val();
	  var project_type=$("#project_type").val();
	  var area_quyu=$("#area_quyu").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { buy_price : buy_price,zu_price : zu_price,buy_one_name : buy_one_name,buy_one_price : buy_one_price,buy_two_name : buy_two_name,buy_two_price : buy_two_price,buy_three_name : buy_three_name,buy_three_price : buy_three_price,zu_one_name : zu_one_name,zu_one_price : zu_one_price,zu_two_name : zu_two_name,zu_two_price : zu_two_price,zu_three_name : zu_three_name,zu_three_price : zu_three_price,project_type : project_type,area_quyu : area_quyu}, 
	 		dataType: "json",
	 		url: "/addMiddlePrice",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("添加成功！");
	 			}else if(data.flag ==0){
	 				alert("添加失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	  }

function addMidTrend(){
	  var heng=$("#heng2").val();
	  var zong=$("#zong2").val();
	  var view_shunxu=$("#view_shunxu2").val();
	  var project_type=$("#project_type2").val();
	  var area_code=$("#area_code").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { heng : heng,zong : zong,view_shunxu : view_shunxu,project_type : project_type,area_code : area_code}, 
	 		dataType: "json",
	 		url: "/addMidTrend",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("添加成功！");
	 			}else if(data.flag == 0){
	 				alert("添加失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	  }
function addZujinTrend(){
	  var heng=$("#heng3").val();
	  var zong=$("#zong3").val();
	  var view_shunxu=$("#view_shunxu3").val();
	  var project_type=$("#project_type3").val();
	  var area_code=$("#area_code").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { heng : heng,zong : zong,view_shunxu : view_shunxu,project_type : project_type,area_code : area_code}, 
	 		dataType: "json",
	 		url: "/addZujinTrend",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("添加成功！");
	 			}else if(data.flag == 0){
	 				alert("添加失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	  }
function addHuibaoTrend(){
	  var heng=$("#heng4").val();
	  var zong=$("#zong4").val();
	  var view_shunxu=$("#view_shunxu4").val();
	  var project_type=$("#project_type4").val();
	  var area_code=$("#area_code").val();
	  $.ajax({
	 	    type: "POST",
	 		data: { heng : heng,zong : zong,view_shunxu : view_shunxu,project_type : project_type,area_code : area_code}, 
	 		dataType: "json",
	 		url: "/addHuibaoTrend",
	 		success:function(data){
	 			if(data.flag == 1){
	 				alert("添加成功！");
	 			}else if(data.flag == 0){
	 				alert("添加失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
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