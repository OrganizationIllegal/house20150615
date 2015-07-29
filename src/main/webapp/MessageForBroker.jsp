<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>推荐最合适房产经纪人留言列表</title>
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/css/bootstrap-table.css" rel="stylesheet">

 <script src="/js/jquery.min.js"></script> 
 <script src="/bootstrap/js/bootstrap.min.js"></script> 
<!-- <script src="/bootstrap/js/jquery.base64.js"></script> -->

<!-- 
<script src="/bootstrap/js/bootstrap-table-export.js"></script> -->
<script src="/bootstrap/js/bootstrap-table.js"></script>

<script src="/js/bootstrap-table-export.js"></script>
<script src="/js/tableExport.js"></script> 
<script type="text/javascript">
function pop(content,id,row,index){
    $("#modalcontent").html(content);
    $('#demandprice').modal('show');
   $.ajax({
   		async : false,
	 	    type: "POST",
	 		data: { id : id},
	 		dateType: "json",
	 		url: "/saveView",
	 		success:function(data){
	 			row.viewed="已看";
	 		    $table.bootstrapTable('updateRow', {index: index, row: row}); 
	 		},
	 		error:function(){
	 			alert("error")
	 		}
	 	});
  }
</script>
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
<div class="area_bkg1">当前位置:推荐最合适房产经纪人留言列表</div>
 <!-- data-export-types:"['json', 'xml', 'txt', 'excel']" -->
 <!-- data-toggle='table' -->
 <table id="table"          

        data-toggle='table'
 		data-url="/MessageBrokerPageList"
 		data-striped='true'
 		data-search="true"
           data-show-pagination-switch="true"
           data-pagination="true"
           data-page-list="[10, 20, ALL]"
           data-strict-search="true"
           data-side-pagination="client"
           data-page-size="20"
           data-page-number=1
           data-show-export="true"
          
           >
        <thead>
        <tr>
            <th data-formatter="countFormatter"></th>
            <th data-field="id" data-sortable="true" data-visible="false">ID</th>
            <th data-field="nick_name" data-sortable="true">姓名</th>
            <th data-field="tel" data-sortable="true">电话</th>
            <th data-field="email" data-sortable="true">Email</th>
          <!--   <th data-field="project_num" data-sortable="true">项目编号</th> -->
            <th data-field="message_content_short" id="content"  data-sortable="true"   data-formatter="operateFormatter"  data-events="operateEvents"  >留言内容</th>
            <th data-field="message_content" data-visible="false" data-sortable="true"  >留言内容</th>
            <th data-field="message_time" data-sortable="true">留言时间</th>
            <th data-field="viewed" data-sortable="true">是否查看</th>
        </tr>
        </thead>
    </table>
</div>
<!--model框start-->
 <div class="modal fade" id="demandprice" tabindex="-1" role="dialog" 
   aria-labelledby="myModalLabel" aria-hidden="true">
   <div class="modal-dialog">
      <div class="modal-content" >
         <div class="modal-header" style="background-color:#EEEEE0;">
            <button type="button" class="close" 
               data-dismiss="modal" aria-hidden="true">
                  &times;
            </button>
            <h4 class="modal-title">
              留言内容
            </h4>
         </div>
         <div class="modal-body" style="padding-top:30px;background-color:#EEEEE0;">
            <form class="form-horizontal" role="form">
   <div class="form-group" style="margin-bottom:0px;">
      <div class="col-sm-10 col-sm-offset-1" id="modalcontent" style="height:300px;margin-left:50px;margin-right:50px">
         
      </div>
      <div class="col-sm-1"></div>
   </div>
</form>
         </div>
      </div>
</div>
</div>
 <!--model框end-->

<script>

var item = <%=flag%>
    var $table = $('#table'),
        $remove = $('#remove'),
        $add = $('#add'),
        selections = [];
	var i=0;
	var count=0;
	/* $(function(){
    	$table.bootstrapTable('refreshOptions', {
                exportDataType: 'all',
                exportTypes:['json', 'xml', 'txt', 'excel']
            });
    }) */
    $(function () {
        $('#add').click(function () {
            $table.bootstrapTable('insertRow', {index: 0, row:{id:'x'+(i++)} });
        });
        $table.bootstrapTable({
            height: 500,
           
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
            '<a class="like" href="javascript:void(0)" title="Like">'+row.message_content_short,
            '</a>  '
        ].join('');
    }  
    
    function countFormatter(value, row, index) {
        return [
           ++count
        ].join('');
    }
    
    window.operateEvents = {
        'click .like': function (e, value, row, index) {
           //alert(row.message_content+row.id);
           pop(row.message_content,row.id,row,index);
           
          
        },
       
    };

    function getHeight() {
    	return $(window).height() - $('h1').outerHeight(true);
    }
    
    
</script>
 
</body>
</html>