<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>Service Protocol</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet" type="text/css" href="css/projectLuru.css" />
<link rel="stylesheet" type="text/css" href="uploadify/uploadify.css" />
<script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<script src="uploadify/jquery.uploadify.js"></script>

<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
</style>

</head>
<body>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:项目录入</div>
<!-- ****************************************************项目信息start***************************************************** -->
<form action="/AddprojectInfo">
<div class="area_bkg2" id="projectinfo">项目信息</div>
<div class="area_left">
<span class="area_span">项目编号</span><span><input type="text" id="project_code" name="project_code" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">项目名称</span><span><input type="text" id="project_name" name="project_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">项目视频链接</span><span><input type="text" id="project_video" name="project_video" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">开发商编号</span><span><input type="text" id="develop_id" name="develop_id" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">项目所在国家</span><span><input type="text" id="project_nation" name="project_nation" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">项目所在州/省</span><span><input type="text" id="project_zhou" name="project_zhou" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">项目所在城市</span><span><input type="text" id="project_city" name="project_city" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">项目所在地区</span><span><input type="text" id="project_area" name="project_area" class="area_input"></span>
</div>
<div class="duoarea_left">
<span class="duoarea_span" >项目所在地址</span><span><textarea id="project_address" name="project_address" class="duoarea_input"></textarea></span>
</div>
<div class="area_right">
<span class="area_span">项目类型</span>
<span>
<select class="area_select" id="project_type" name="project_type">
  <option >公寓</option>
  <option >别墅</option>
  <option>联合别墅</option>
</select>
</span>
</div>
<div class="area_right">
<span class="area_span">户型</span><span><input type="text" id="house_type" name="house_type" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">项目完成时间</span><span><input type="text" id="finish_time" name="finish_time" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">可售套数</span><span><input type="text" id="keshou" name="keshou" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">步行指数</span><span><input type="text" id="walk_num" name="walk_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">层数</span><span><input type="text" id="ceng" name="ceng" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">推荐度</span><span><input type="text" id="tuijian" name="tuijian" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">面积单位</span><span><input type="text" id="mianji" name="mianji" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">最小单位</span><span><input type="text" id="minarea" name="minarea" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">最大单位</span><span><input type="text" id="maxarea" name="maxarea" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">单价（起价）</span><span><input type="text" id="danjia" name="danjia" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">返利</span><span><input type="text" id="return_money" name="return_money" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">最低价格</span><span><input type="text" id="minprice" name="minprice" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">最高价格</span><span><input type="text" id="maxprice" name="maxprice" class="area_input"></span>
</div>
<div class="duoarea_left">
<span class="duoarea_span">项目一句话（中文）</span><span><textarea id="project_lan_an" name="project_lan_an" class="duoarea_input"></textarea></span>
</div>
<div class="duoarea_right">
<span class="duoarea_span">项目一句话（英文）</span><span><textarea id="project_lan_en" name="project_lan_en" class="duoarea_input"></textarea></span>
</div>
<div class="duoarea_left2">
<span class="duoarea_span">项目描述</span><span><textarea id="project_desc" name="project_desc" class="duoarea_input2"></textarea></span>
</div>
<div class="area_left">
<span class="area_span">项目GPS</span><span><input type="text" id="GPS" name="GPS" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新时间</span><span><input type="text" id="update_time" name="update_time" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">购房税费说明</span><span><input type="text" id="buyTaxInfo" name="buyTaxInfo" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">持有成本说明</span><span><input type="text" id="holdCostInfo" name="holdCostInfo" class="area_input"></span>
</div>

<!-- ****************************************************项目信息end***************************************************** -->

<!-- ****************************************************开发商信息start***************************************************** -->


<div class="area_bkg2" style="clear:both;" id="developerinfo">开发商信息</div>
<div class="area_left" style="width:900px">
<span class="area_span">开发商编号及名称</span>
<span>
<select class="area_select" id=developer_code name="developer_code" style="width:670px">
         <c:forEach items="${codeAndNameSet}" var="item">
        		 <option>${item}</option>
       	 </c:forEach>
</select>
</span>
</div>
<!-- <div class="area_right">
<span class="area_span">开发商名称</span><span><input type="text" id="developer_name" name="developer_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">开发商logo</span><span><input type="text" id="developer_logo" name="developer_logo" class="area_input"></span>
</div>
<div class="duoarea_left2">
<span class="area_span">开发商介绍</span><span><textarea id="developer_desc" name="developer_desc" class="duoarea_input2"></textarea></span>
</div> -->


<!-- ****************************************************开发商信息end***************************************************** -->

<!-- ****************************************************户型及价格start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="housetypeinfo">户型及价格</div>
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
 <input type="file" name="houseimg" id="houseimg" style="width:700px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#">上传</a>
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

<!-- ****************************************************开发商信息end***************************************************** -->

<!-- ****************************************************项目配套start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="projectpeitao">项目配套</div>
<div class="area_left"  style="width:900px">
 <input type="file" name="projectimage" id="projectimage" style="width:700px;border:1px solid rgb(239,235,242);float:left;margin-right:20px;"/><a href="#">上传</a>
</div>

<!-- ****************************************************项目配套end***************************************************** -->

<!-- ****************************************************附近配套start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="nearpeitao">附近配套</div>
<div class="area_left">
<span class="area_span">配套类型</span><span><input type="text" id="peitao_type" name="peitao_type" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">配套名称</span><span><input type="text" id="peitao_name" name="peitao_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">配套距离</span><span><input type="text" id="peitao_distance" name="peitao_distance" class="area_input"></span>
</div>

<!-- ****************************************************附近配套end***************************************************** -->

<!-- ****************************************************附近学校start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="nearschool">附近学校</div>
<div class="area_left">
<span class="area_span">学校名称</span>
<span>
<select class="area_select" id="school_name" name="school_name">
  <option >学校1</option>
  <option >学校2</option>
  <option>学校3</option>
</select>
</span>
<!-- <span><input type="text" id="school_name" name="school_name" class="area_input"></span> -->
</div>
<div class="area_right">
<span class="area_span">学校距离</span><span><input type="text" id="school_distance" name="school_distance" class="area_input"></span>
</div>


<!-- ****************************************************附近学校end***************************************************** -->

<!-- ****************************************************持有成本start***************************************************** -->

<div class="area_bkg2" style="clear:both;" id="holdcost">持有成本</div>
<div class="area_left">
<span class="area_span">类型</span><span><input type="text" id="holdcosttype" name="holdcosttype" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">价格</span><span><input type="text" id="holdcostprice" name="holdcostprice" class="area_input"></span>
</div>
<div class="chang_left2">
<span class="area_span">描述</span><span><input type="text" id="holdcostdesc" name="holdcostdesc" class="chang_input2"></span>
</div>
<div class="area_left">
<span class="area_span">户型名称</span><span><input type="text" id="holdcost_housename" name="holdcost_housename" class="area_input"></span>
</div>

<!-- ****************************************************持有成本end***************************************************** -->

<!-- ****************************************************购房税费start***************************************************** -->
<div class="area_bkg2" style="clear:both;" id="housetax">购房税费</div>
<div class="area_left">
<span class="area_span">类型</span><span><input type="text" id="houseTaxtype" name="houseTaxtype" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">价格</span><span><input type="text" id="houseTaxprice" name="houseTaxprice" class="area_input"></span>
</div>
<div class="chang_left2">
<span class="area_span">描述</span><span><input type="text" id="houseTaxdesc" name="houseTaxdesc" class="chang_input2"></span>
</div>
<div class="area_left">
<span class="area_span">户型名称</span><span><input type="text" id="houseTax_housename" name="houseTax_housename" class="area_input"></span>
</div>
<!-- ****************************************************购房税费end***************************************************** -->
<!-- <div style="width:900px;clear:both;margin:20px auto;text-align:center;">
<button type="submit" >提交</button>
<button type="reset" >重置</button>
</div> -->
<div style="float:left;">
<div class="area_left4"><button type="submit" class="btn" >提交</button></div>
<div class="area_right4"><button type="reset" class="btn">重置</button></div>
</div>
</form>
</div>


</body>
</html>