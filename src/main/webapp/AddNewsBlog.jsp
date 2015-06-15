<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="//cdn.ckeditor.com/4.4.7/full/ckeditor.js"></script>
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
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row"><h2 align="center">新闻博客添加</h2></div>
	<form role="form" action="/Area/AddNewsBoke">
	  <div class="form-group">
	    <label for="title">编号</label>
	    <input type="text" class="form-control" id="news_num" placeholder="编号" name="news_num">
	  </div>
	  <div class="form-group">
	    <label for="title">标题</label>
	    <input type="text" class="form-control" id="news_title" placeholder="标题" name="news_title">
	  </div>
	  <div class="form-group">
	    <label for="publisher">发布人</label>
	    <input type="text" class="form-control" id="news_people" placeholder="发布人" name="news_people">
	  </div>
	  <div class="form-group">
	    <label for="type">分类</label>
	    <input type="text" class="form-control" id="news_fenlei" placeholder="分类" name="news_fenlei">
	  </div>
	  <div class="form-group">
	    <label for="abstract">摘要</label>
	    <input type="text" class="form-control" id="news_abstract" placeholder="摘要" name="news_abstract">
	  </div>
	  <div class="form-group">
	    <label for="pic">图片</label>
	    <input type="text" class="form-control" id="news_image" placeholder="图片" name="news_image">
	  </div>
	  <div class="form-group">
	    <label for="detail">详情</label>
	    <textarea  class="form-control" id="news_detail" placeholder="详情" name="news_detail"></textarea>
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
</div>

<script type="text/javascript">
CKEDITOR.replace( 'news_detail' );
</script>
</body>
</html>