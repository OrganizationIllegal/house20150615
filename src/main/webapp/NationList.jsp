<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>国家列表</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-table.css" rel="stylesheet">


<!-- <script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script> --> 
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
String username = null;
	if(request.getSession().getAttribute("username")==null){
		out.print("<script>alert('用户请登录。');window.location.href='/index'</script>");
}
	
String flag = null;
if(request.getSession().getAttribute("flag")!=null){
	flag = request.getSession().getAttribute("flag").toString();
}
%>

<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:国家列表</div>
 <table id="table"
           data-url="/nationList"
            data-toggle='table'
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
            <th data-field="id" data-sortable="true" data-visible="false">ID</th>
            <th data-field="nation_name" data-sortable="true">国家名称</th>
            <th data-field="center_gps" data-sortable="true">中心gps</th>
            <th data-field="operate"
                data-formatter="operateFormatter"
                data-events="operateEvents">Item Operate</th>
        </tr>
        </thead>
    </table>
</div>


<script>
var item = <%=flag%>
    var $table = $('#table'),
        $add = $('#add'),
        selections = [];
	var i=0;
	var count=0;

    function operateFormatter(value, row, index) {
        return [
            '<a class="like" href="javascript:void(0)" title="Like">',
            '<i class="glyphicon glyphicon-heart"></i>',
            '</a>  ',
            '<a class="remove" href="javascript:void(0)" title="Remove">',
            '<i class="glyphicon glyphicon-remove"></i>',
            '</a>'
        ].join('');
    }
    
    function countFormatter(value, row, index) {
        return [
            ++count
        ].join('');
    }

    window.operateEvents = {
        'click .like': function (e, value, row, index) {
            var id=row.id;
            window.open ('/selectNation?id='+id);
	       
            
        },
        'click .remove': function (e, value, row, index) {
        	if(item!=2){
        		alert("您没有权限删除！");
        	}else{
        		var id = row.id;
                if(confirm("是否确认删除？")){
                 $.ajax({
    		 	    type: "POST",
    		 		data: {id: id},
    		 		dateType: "json",
    		 		url: "/deleteNation",
    		 		
    		 		success:function(data){
    		 			data=eval("("+data+")");
    		 			//alert(data.flag);
    		 			if(data.flag==true){
    		 				alert("删除成功");
    		 			}
    		 			else{
    		 				alert("删除失败");
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
                else{
                	
                }
        	}
            
        }
    };
    function getHeight() {
        return $(window).height() - $('h1').outerHeight(true);
    }
</script>
</body>
</html>