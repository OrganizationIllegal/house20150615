<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>House Type List</title>
     <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
</head>
  
  <body>
   <div class="container">
    <h1>House Type List</h1>
    <div id="toolbar">
        <button id="remove" class="btn btn-danger" disabled>
            <i class="glyphicon glyphicon-remove"></i> Delete
        </button>
        <button id="add" class="btn btn-danger">
            insertRow 
        </button>
    </div>
    <table id="table"
           data-toolbar="#toolbar"
           data-search="true"
           data-show-refresh="true"
           data-show-toggle="true"
           data-show-columns="true"
           data-show-export="true"
           data-show-pagination-switch="true"
           data-pagination="true"
           data-page-list="[10, 25, 50, 100, ALL]"
           data-show-footer="true"
           data-side-pagination="server"
           data-url="/find/houseInfo"
           data-response-handler="responseHandler">
        <thead>
        <tr>
            <th data-field="state" data-checkbox="true"></th>
            <th data-field="id" data-sortable="true">ID</th>
            <th data-field="house_type" data-sortable="true" data-editable="true">HouseType</th>
            <th data-field="house_room_num" data-sortable="true" data-editable="true">RoomNum</th>
            <th data-field="house_toilet_num" data-sortable="true" data-editable="true">ToiletNum</th>
            <th data-field="house_size" data-sortable="true" data-editable="true">HouseSize</th>
            <th data-field="house_price" data-sortable="true" data-editable="true">HousePrice</th>
            <th data-field="house_img" data-sortable="true" data-editable="true">HouseImg</th>
            <th data-field="project_num" data-sortable="true" data-editable="true">ProjectNum</th>
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
            height: getHeight()
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
       // $table.on('editable-save.bs.table',function(field, row, oldValue,$el){
           // alert(field+row.toString()+oldValue.toString()+$el.toString());
        //});
        $remove.click(function () {
        	var ids = getIdSelections();
            ids = '"'+ids+'"';
            alert(ids);
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
            //alert('You click like action, row: ' + JSON.stringify(row));
           
            var id=row.id;
            if(isNaN(id)){
            $.ajax({
	 	    type: "POST",
	 		data: {house_type: row.house_type, house_room_num: row.house_room_num, house_toilet_num: row.house_toilet_num, house_size: row.house_size,house_price: row.house_price, house_img: row.house_img, project_num: row.project_num},
	 		dateType: "json",
	 		url: "/add/HouseInfo",
	 		
	 		success:function(data){
	 			data=$.parseJSON(data);
	 			if(data.result==0){
	 				alert("项目编号不能为空！")
	 			}
	 			else if(data.result==-1){
	 				alert("项目编号不存在！")
	 			}else if(data.result==-2){
	 				alert("增加失败")
	 			}
	 			else{
	 				alert("增加成功")
	 			}
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
          }
          else{
          //alert("hehe edit")
	           $.ajax({
		 	    type: "POST",
		 		data: {id: row.id, house_type: row.house_type, house_room_num: row.house_room_num, house_toilet_num: row.house_toilet_num, house_size: row.house_size,house_price: row.house_price, house_img: row.house_img, project_num: row.project_num},
		 		dateType: "json",
		 		url: "/edit/HouseInfo",
		 		
		 		success:function(data){
	 			data=$.parseJSON(data);
	 			if(data.result==0){
	 				alert("项目编号不能为空！")
	 			}
	 			else if(data.result==-1){
	 				alert("项目编号不存在！")
	 			}else if(data.result==-2){
	 				alert("修改失败")
	 			}
	 			else{
	 				alert("修改成功")
	 			}
	 		},
		 		error:function(){
		 			alert("error")
		 		}
	 		});
          }
          
            
            
        },
        'click .remove': function (e, value, row, index) {
       
            var id = row.id;
             $.ajax({
		 	    type: "POST",
		 		data: {id: id},
		 		dateType: "json",
		 		url: "/delete/HouseInfo",
		 		
		 		success:function(data){
		 			alert("删除成功！")
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