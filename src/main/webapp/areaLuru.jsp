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
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
</style>
</head>
<body>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:区域录入</div>
<div class="area_bkg2" id="areainfo">区域信息</div>
<div class="area_left">
<span class="area_span">区域编号</span><span><input type="text" id="area_num" name="area_num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">区域名称</span><span><input type="text" id="area_name" name="area_name" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">城市名称</span><span><input type="text" id="area_city" name="area_city" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">州/省</span><span><input type="text" id="area_zhou" name="area_zhou" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">国家</span><span><input type="text" id="area_nation" name="area_nation" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">邮政编码</span><span><input type="text" id="area_postcode" name="area_postcode" class="area_input"></span>
</div>
<div class="area_bkg2 c-fix" id="invest">投资数据</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="touzi_datasource" name="touzi_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="touzi_date" name="touzi_date" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">年增长率</span><span><input type="text" id="year_increment_rate" name="year_increment_rate" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">中位数价格</span><span><input type="text" id="middle_price" name="middle_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">中位数租金</span><span><input type="text" id="middle_zu_price" name="middle_zu_price" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">租金回报率</span><span><input type="text" id="zu_house_rate" name="zu_house_rate" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">现金回报</span><span><input type="text" id="price_review" name="price_review" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">租赁需求</span><span><input type="text" id="zu_xuqiu" name="zu_xuqiu" class="area_input"></span>
</div>
<div class="area_bkg2 c-fix" id="family">区域家庭构成</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="family_datasource" name="family_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="family_date" name="family_date" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">家庭1</span><span><input type="text" id="family_one" name="family_one" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">家庭1比例</span><span><input type="text" id="family_one_rate" name="family_one_rate" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">家庭2</span><span><input type="text" id="family_two" name="family_two" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">家庭2比例</span><span><input type="text" id="family_two_rate" name="family_two_rate" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">家庭3</span><span><input type="text" id="family_three" name="family_three" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">家庭3比例</span><span><input type="text" id="family_three_rate" name="family_three_rate" class="area_input"></span>
</div>
<div class="area_bkg2 c-fix" id="midprice">区域中位数房价</div>
<div class="area_left">
<span class="area_span">项目类型</span>
<span>
<select class="area_select" id="project_type" name="project_type">
  <option value ="gongyu">公寓</option>
  <option value ="bieshu">别墅</option>
</select>
</span>
</div>
<div class="area_right"></div>
<div class="area_left">
<span class="area_span">购买价格</span><span><input type="text" id="buy_price" name="buy_price" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">租赁价格</span><span><input type="text" id="zu_price" name="zu_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">买一名称</span><span><input type="text" id="buy_one_name" name="buy_one_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">买一价格</span><span><input type="text" id="buy_one_price" name="buy_one_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">买二名称</span><span><input type="text" id="buy_two_name" name="buy_two_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">买二价格</span><span><input type="text" id="buy_two_price" name="buy_two_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">买三名称</span><span><input type="text" id="buy_three_name" name="buy_three_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">买三价格</span><span><input type="text" id="buy_three_price" name="buy_three_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">租一名称</span><span><input type="text" id="zu_one_name" name="zu_one_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">租一价格</span><span><input type="text" id="zu_one_price" name="zu_one_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">租二名称</span><span><input type="text" id="zu_two_name" name="zu_two_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">租二价格</span><span><input type="text" id="zu_two_price" name="zu_two_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">租三名称</span><span><input type="text" id="zu_three_name" name="zu_three_name" class="area_input"></span>
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
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">$585250</span><span class="area_span">$350</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">别墅</span><span class="area_span">$721250</span><span class="area_span">$385</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_bkg2 c-fix" id="pricetrend">区域房价中位数走势</div>
<div class="area_left">
<span class="area_span">项目类型</span>
<span>
<select class="area_select" id="project_type" name="project_type">
  <option value ="gongyu">公寓</option>
  <option value ="bieshu">别墅</option>
</select>
</span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu" name="view_shunxu" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">横坐标</span><span><input type="text" id="heng" name="heng" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">纵坐标</span><span><input type="text" id="zong" name="zong" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="middle_zoushi_datasource" name="middle_zoushi_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="middle_zoushi_date" name="middle_zoushi_date" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">1</span><span class="area_span">2006</span><span class="area_span6">285</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">2</span><span class="area_span">2007</span><span class="area_span6">332</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_bkg2 c-fix" id="zujintrend">区域租金走势</div>
<div class="area_left">
<span class="area_span">项目类型</span>
<span>
<select class="area_select" id="project_type" name="project_type">
  <option value ="gongyu">公寓</option>
  <option value ="bieshu">别墅</option>
</select>
</span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu" name="view_shunxu" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">横坐标</span><span><input type="text" id="heng" name="heng" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">纵坐标</span><span><input type="text" id="zong" name="zong" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="zujin_datasource" name="zujin_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="zujin_date" name="zujin_date" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">1</span><span class="area_span">2006</span><span class="area_span6">200</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">2</span><span class="area_span">2007</span><span class="area_span6">250</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_bkg2 c-fix" id="huibaotrend">区域租金回报走势</div>
<div class="area_left">
<span class="area_span">项目类型</span>
<span>
<select class="area_select" id="project_type" name="project_type">
  <option value ="gongyu">公寓</option>
  <option value ="bieshu">别墅</option>
</select>
</span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu" name="view_shunxu" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">横坐标</span><span><input type="text" id="heng" name="heng" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">纵坐标</span><span><input type="text" id="zong" name="zong" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="zujin_huibao_datasource" name="zujin_huibao_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="zujin_huibao_date" name="zujin_huibao_date" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">1</span><span class="area_span">2006</span><span class="area_span6">3.6</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">aur0001</span><span class="area_span">公寓</span><span class="area_span">2</span><span class="area_span">2007</span><span class="area_span6">3.9</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_bkg2 c-fix" id="tedian">区域特点</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="data_source" name="data_source" class="area_input"></span>
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
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">Rpdata</span><span class="area_span">2015/5/21</span><span class="area_span">1</span><span class="area_span">本区位于...</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">Rpdata</span><span class="area_span">2015/5/22</span><span class="area_span">2</span><span class="area_span">平均房价...</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_bkg2 c-fix" id="people">区域人口分布</div>
<div class="area_left">
<span class="area_span">列1</span><span><input type="text" id="column1" name="column1" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">列2</span><span><input type="text" id="column2" name="column2" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">列3</span><span><input type="text" id="column3" name="column3" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">显示顺序</span><span><input type="text" id="view_shunxu" name="view_shunxu" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">数据来源</span><span><input type="text" id="people_datasource" name="people_datasource" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">更新日期</span><span><input type="text" id="people_date" name="people_date" class="area_input"></span>
</div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">人口总数</span><span class="area_span">Nunawading</span><span class="area_span">Vic 维多利亚州</span><span class="area_span">1</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">人口</span><span class="area_span">10940</span><span class="area_span">5354042</span><span class="area_span">2</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_bkg2 c-fix" id="broker">推荐经纪人</div>
<div class="area_left">
<span class="area_span">经纪人姓名</span>
<span>
<select class="area_select" id="broker_name" name="broker_name">
  <option value ="broker1">韩嵩</option>
  <option value ="broker2">李海涛</option>
  <option value ="broker3">阎松</option>
  <option value ="broker4">王舒</option>
  <option value ="broker5">张淑媛</option>
  <option value ="broker6">王菲</option>
</select>
</span>
</div>
<div class="area_right"></div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">韩嵩</span><span class="area_span">房产经纪</span><span class="area_span">英文 中文</span><span class="area_span">北京</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">李海涛</span><span class="area_span">贷款经纪</span><span class="area_span">中文</span><span class="area_span">上海</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_bkg2 c-fix" id="project">推荐项目</div>
<div class="area_left">
<span class="area_span">项目名称</span>
<span>
<select class="area_select" id="project_name" name="project_name">
  <option value ="pro1">The Atrium</option>
  <option value ="pro2">Thrive Parkside</option>
  <option value ="pro3">The Moreland</option>
  <option value ="pro4">Regent Residences</option>
  <option value ="pro5">Amber</option>
  <option value ="pro6">Hamilton 853</option>
  <option value ="pro7">Forest Ridge</option>
  <option value ="pro8">Claremont Manor</option>
  <option value ="pro9">Kornhill Gardens</option>
  <option value ="pro10">Evergreen</option>
</select>
</span>
</div>
<div class="area_right"></div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">The Atrium</span><span class="area_span">Nunawading</span><span class="area_span">6300元/平米（起）</span><span class="area_span">公寓</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">Thrive Parkside</span><span class="area_span">Parkville</span><span class="area_span">8000元/平米（起）</span><span class="area_span">公寓</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_bkg2 c-fix" id="news">新闻报道</div>
<div class="area_left">
<span class="area_span">新闻类型</span>
<span>
<select class="area_select" id="project_type" name="project_type">
  <option value ="gongyu">新闻博客</option>
  <option value ="bieshu">置业指导</option>
</select>
</span>
</div>
<div class="area_right">
<span class="area_span">编号</span><span><input type="text" id="num" name="num" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">标题</span><span><input type="text" id="num" name="num" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">发布人</span><span><input type="text" id="zu_price" name="zu_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">发布时间</span><span><input type="text" id="buy_one_name" name="buy_one_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">分类</span><span><input type="text" id="buy_one_price" name="buy_one_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">摘要</span><span><input type="text" id="buy_two_name" name="buy_two_name" class="area_input"></span>
</div>
<div class="area_right">
<span class="area_span">图片</span><span><input type="text" id="buy_two_price" name="buy_two_price" class="area_input"></span>
</div>
<div class="area_left">
<span class="area_span">详情</span>
</div>
<div class="c-fix" style="margin-bottom:15px;"><textarea id="detail" placeholder="详情" name="detail"></textarea></div>
<div class="area_left3"></div>
<div class="area_right3"><span class="area_span5"><a href="#">添加</a></span></div>
<div class="area_left3">
<span class="area_span">澳洲购房指南...</span><span class="area_span">海房优选</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left3">
<span class="area_span">澳各大银行...</span><span class="area_span">亿忆网</span>
</div>
<div class="area_right3">
<span class="area_span4"><a href="#">编辑</a></span><span class="area_span5"><a href="#">删除</a></span>
</div>
<div class="area_left4"><button type="submit" class="btn">提交</button></div>
<div class="area_right4"><button type="reset" class="btn">重置</button></div>
</div>

<script type="text/javascript">
CKEDITOR.replace( 'detail' );
</script>
</body>
</html>