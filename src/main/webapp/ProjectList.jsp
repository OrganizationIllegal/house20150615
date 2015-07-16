<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>项目列表</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-table.css" rel="stylesheet">


<!-- <script src="/jquery.min.js"></script> -->
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
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:项目列表</div>
 <table id="table" 
 		data-toggle='table'
 		data-url="/ProjectInfoList"
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
            <!-- <th data-field="state" data-checkbox="true"></th> -->
            <th data-formatter="countFormatter"
                ></th>
            <th data-field="id" data-sortable="true" data-visible="false">ID</th>
            <th data-field="project_num"  data-searchable="true">项目编号</th>
            <th data-field="project_name"  data-searchable="true">项目名称</th>
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
	var count=0;
    $(function () {
        $table.bootstrapTable({
            /* url:'/ProjectInfoList', */
            height: getHeight()
            /* striped:true, */
            /* pagination:true, */
            /* sidePagination:'client', */
            /* responseHandler:responseHandler(), */
            /* search:true, */
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
    
    function countFormatter(value, row, index) {
        return [
            ++i
        ].join('');
    }
    
    window.operateEvents = {
            'click .like': function (e, value, row, index) {
                var id=row.id;
                alert("id"+id);
                window.open ('/Area/editNewsInfo?id='+id)
                
            }},

    window.operateEvents = {
        'click .like': function (e, value, row, index) {
            //alert('You click like action, row: ' + JSON.stringify(row));
            var id=row.id;
            window.open ('/selectProject?id='+id);
        },
        'click .remove': function (e, value, row, index) {
            var id = row.id;
            if(confirm("是否确认删除？")){
             $.ajax({
		 	    type: "POST",
		 		data: {id: id},
		 		dateType: "json",
		 		url: "/deleteProject",
		 		
		 		success:function(data){
		 			alert("删除成功")
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
    };

    function getHeight() {
        return $(window).height() - $('h1').outerHeight(true);
    }
</script>
</body>
</html>