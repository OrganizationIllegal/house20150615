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
<!-- <link rel="stylesheet" type="text/css" href="css/projectLuru.css" /> -->
<link rel="stylesheet" type="text/css" href="uploadify/uploadify.css" />

<link href="/bootstrap/css/bootstrap-table.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-editable.css" rel="stylesheet">
<link href="/bootstrap/css/examples.css" rel="stylesheet">

<script src="/js/jquery.min.js"></script>
<script src="/bootstrap/js/bootstrap.min.js"></script>



<script src="/bootstrap/js/bootstrap-table.js"></script>
<script src="/bootstrap/js/bootstrap-editable.js"></script>
<script src="/bootstrap/js/bootstrap-table-export.js"></script>
<script src="/bootstrap/js/bootstrap-table-editable.js"></script>
<script src="/bootstrap/js/tableExport.js"></script>
<script src="/bootstrap/js/jquery.base64.js"></script>

<style type="text/css">
body{
	/* background-color:rgb(232, 233, 234)!important; */
	font-family:"Microsoft YaHei"!important;
}
</style>

</head>
<body>
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:区域列表</div>
 <table id="table"          

           data-toggle='table'
 		data-url="/AreaInfoList"
 		data-striped='true'
 		data-search="true"
           data-show-refresh="true"
           data-show-columns="true"
           data-minimum-count-columns="2"
           data-show-pagination-switch="true"
           data-pagination="true"
           data-page-list="[10, 22, ALL]"
           data-strict-search="true"
           data-side-pagination="client"
           data-page-size="10"
           data-page-number=1
           
           >
        <thead>
        <tr>
            <th data-field="state" data-checkbox="true"></th>
            <th data-field="id" data-sortable="true" >ID</th>
            <th data-field="area_num" data-sortable="true">区域编号</th>
            <th data-field="area_name" data-sortable="true">区域名称</th>
            <th data-field="operate"
                data-formatter="operateFormatter"
                data-events="operateEvents">Item Operate</th>
        </tr>
        </thead>
    </table>
</div>


<script>
    var $table = $('#table'),
        $remove = $('#remove'),
        $add = $('#add'),
        selections = [];
	var i=0;
    $(function () {
        $('#add').click(function () {
            $table.bootstrapTable('insertRow', {index: 0, row:{id:'x'+(i++)} });
        });
        $table.bootstrapTable({
            height: 500
        });
        $table.on('check.bs.table uncheck.bs.table ' +
                'check-all.bs.table uncheck-all.bs.table', function () {
            $remove.prop('disabled', !$table.bootstrapTable('getSelections').length);

            // save your data, here just save the current page
            selections = getIdSelections();
            // push or splice the selections if you want to save all data selections
        });
        $table.on('all.bs.table', function (e, name, args) {
            // console.log(name, args);
        });
  
        $remove.click(function () {
        	var ids = getIdSelections();
            ids = '"'+ids+'"';
            /* alert(ids); */
            $.ajax({
	 	    type: "POST",
	 		data: { ids : ids},
	 		dateType: "json",
	 		url: "/touzi/deleteAllData",
	 		
	 		success:function(data){
	 			alert("删除成功")
	 			window.location.reload();
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
	 	
            
            $table.bootstrapTable('remove', {
                field: 'id',
                values: ids
            });
     
            $remove.prop('disabled', true);
        });
        $(window).resize(function () {
            $table.bootstrapTable('resetView', {
                height: getHeight()
            });
        });
    });

    function getIdSelections() {
        return $.map($table.bootstrapTable('getSelections'), function (row) {
            return row.id
        });
    }

    function responseHandler(res) {
        $.each(res.rows, function (i, row) {
            row.state = $.inArray(row.id, selections) !== -1;
        });
        return res;
    }

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
    
    window.operateEvents = {
            'click .like': function (e, value, row, index) {
                var id=row.id;
                window.open ('/Area/editNewsInfo?id='+id)
                
            }},

    window.operateEvents = {
        'click .like': function (e, value, row, index) {
            /* alert('You click like action, row: ' + JSON.stringify(row)); */
            var id=row.id;
            window.open ('/AreaEdit?id='+id);
        },
        'click .remove': function (e, value, row, index) {
            //alert(row.id);
            //alert(row.area_num);
            var id = row.id;
            var area_num=row.area_num;
             $.ajax({
		 	    type: "POST",
		 		data: {id: id,area_num: area_num},
		 		dateType: "json",
		 		url: "/AreaDelete",
		 		
		 		success:function(data){
		 			if(data.flag == 11){
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
        return 500;
    }
</script>
</body>
</html>