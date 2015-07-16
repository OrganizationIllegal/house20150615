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
<div style="width:900px;margin:25px auto;">
<div class="area_bkg1">当前位置:开发商列表</div>
 <table id="table"
 			data-toggle='table'
           
 		data-url="/DeveloperInfoList"
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
            <th data-field="developer_num" >开发商编号</th>
             <th data-field="developer_name" >开发名称</th>
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
    
    function countFormatter(value, row, index) {
        return [
            ++count
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
           // alert('You click like action, row: ' + JSON.stringify(row));
            var id=row.id;
            window.open ('/selectDeveloperInfo?id='+id);
	        /*  $.ajax({
		 	    type: "POST",
		 		//data: {id:row.id,project_num: row.project_num,recommend_project_num1: row.recommend_project_num1, recommend_project_num2: row.recommend_project_num2,recommend_project_num3: row.recommend_project_num3},
		 		dateType: "json",
		 		url: "/editRecoProject",
		 		
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
      */
            
            
        },
        'click .remove': function (e, value, row, index) {
            //alert(row.id);
            var id = row.id;
            if(confirm("是否确认删除？")){
             $.ajax({
		 	    type: "POST",
		 		data: {id: id},
		 		dateType: "json",
		 		url: "/deleteDeveloper",
		 		
		 		success:function(data){
		 			data=eval("("+data+")");
		 			if(data.flag==0){
		 				alert("删除成功");
		 			}else{
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
            }else{
            	
            }
        }
    };

    

    function getHeight() {
        return $(window).height() - $('h1').outerHeight(true);
    }
</script>
</body>
</html>