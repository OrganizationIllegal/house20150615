<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>地图中心点列表</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-table.css" rel="stylesheet">


<!-- <script src="/js/jquery.min.js"></script> -->
<!-- <script src="/bootstrap/js/bootstrap.min.js"></script> -->
<script src="/bootstrap/js/bootstrap-table.js"></script>


<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
</style>

</head>
<body>
<%
String flag = null;
if(request.getSession().getAttribute("flag")!=null){
	flag = request.getSession().getAttribute("flag").toString();
}
%>

<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:地图中心点列表</div>
 <table id="table"
 			data-toggle='table'
           
 		data-url="/MapCenterList"
 		data-striped='true'
 		data-search="true"
           data-show-pagination-switch="true"
           data-pagination="true"
           data-page-list="[10, 20, ALL]"
           data-strict-search="true"
           data-side-pagination="client"
           data-page-size="20"
           data-page-number=1
           >
        <thead>
        <tr>
            <th data-formatter="countFormatter"></th>
            <th data-field="id" data-visible="false">ID</th>
            <th data-field="name" >名称</th>
            <th data-field="type" >类型</th>
            <th data-field="gps" >gps</th>
            <th data-field="operate"
                data-formatter="operateFormatter"
                data-events="operateEvents">Item Operate</th>
        </tr>
        </thead>
    </table>
</div>


<script>
var $table = $('#table'),
selections = [];
var i=0;
$(function () {       
    $table.bootstrapTable({
        height: getHeight()
    });       
});

function operateFormatter(value, row, index) {
    return [
        '<a class="remove" href="javascript:void(0)" title="Remove">',
        '<i class="glyphicon glyphicon-remove"></i>',
        '</a>'
    ].join('');
}

window.operateEvents = {     	 	
    'click .remove': function (e, value, row, index) {
        //alert(row.id);
        var id = row.id;
        var news_id=row.news_id;
         $.ajax({
	 	    type: "POST",
	 		data: {id: id,news_id: news_id},
	 		dateType: "json",
	 		url: "/deleteMapCenter",		 		
	 		success:function(data){
	 			data=eval("("+data+")");
	 			if(data.flag==1){
	 				alert("删除成功！");
	 			}else if(data.flag ==0){
	 				alert("删除失败！");
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
 	});
                 
        
        $table.bootstrapTable('remove', {
            field: 'id',
            values: [row.id]
        });
    }
};
function getHeight() {
    return $(window).height() - $('h1').outerHeight(true);
}
</script>
</body>
</html>