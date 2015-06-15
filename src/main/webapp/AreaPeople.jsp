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
    
    <title>CRUD</title>
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
    <h1> AreaPeople <a href="https://github.com/wenzhixin/bootstrap-table-examples" class="btn btn-primary" role="button" target="_blank">Learn more &raquo;</a></h1>
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
           data-url="/Area/ListAreaPeople"
           data-response-handler="responseHandler">
        <thead>
        <tr>
            <th data-field="state" data-checkbox="true"></th>
            <th data-field="id" data-sortable="true">ID</th>
            <th data-field="column1" data-sortable="true" data-editable="true">column1</th>
            <th data-field="column2" data-sortable="true" data-editable="true">column2</th>
            <th data-field="column3" data-sortable="true" data-editable="true">column3</th>
             <th data-field="view_shunxu" data-sortable="true" data-editable="true">view_shunxu</th>
             <th data-field="area_code" data-sortable="true" data-editable="true">area_code</th>
            
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
	 		url: "/Area/DelFamilyIncome",
	 		
	 		success:function(data){
	 			alert("删锟斤拷晒锟�")
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
            if(isNaN(id)){
            	$.ajax({
	 	    type: "POST",
	 		data: {column1:row.column1,column2:row.column2,column3:row.column3,view_shunxu:row.view_shunxu, area_code:row.area_code},
	 		dateType: "text json",
	 		url: "/Area/AddAreaPeople",
	 		success:function(data){
	 			data=$.parseJSON(data);
	 			if(data.area_id==0){
	 			  alert("area_id不存在")
	 			}
	 			else
	 			{
	 			if(data.flag==false){
	 			    alert("添加失败")
	 			}
	 			else{
	 				alert("添加成功")
	 				window.location.reload()
	 			}
	 			}
	 			
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
          }
          else{
	           $.ajax({
		 	    type: "POST",
		 		data: {id: row.id,column1:row.column1,column2:row.column2,column3:row.column3,view_shunxu:row.view_shunxu, area_code:row.area_code},
		 		url: "/Area/UpdateAreaPeople",
		 		success:function(data){
		 			data=$.parseJSON(data);
	 			if(data.area_id==0){
	 			  alert("area_id不存在")
	 			}
	 			else
	 			{
	 			if(data.flag==false){
	 			  	alert("更新失败")
	 			}
	 			else{
	 				alert("更新成功")
	 				window.location.reload()
	 			}
	 			}
		 		},
		 		error:function(){
		 			alert("error")
		 		}
	 		});
          }
          
            
            
        },
        'click .remove': function (e, value, row, index) {
             $.ajax({
		 	    type: "POST",
		 		data: {id: row.id},
		 		dateType: "json",
		 		url: "/Area/DeleteAreaPeople",
		 		success:function(data){
		 			data=$.parseJSON(data);
		 			if(data.flag==false){
		 			    alert("删除失败")
		 			}else{
		 			   alert("删除成功")
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