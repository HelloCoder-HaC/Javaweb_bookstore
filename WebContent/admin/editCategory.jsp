<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			 ;
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑分类信息</title>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
</head>
<body>
	<script type="text/javascript" src="js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<div>
		<p style="font-size: 25px; margin-top: 20px; margin-left: 42px">编辑书籍分类信息</p>
	</div>
	<hr
		style="height: 10px; border: none; border-top: 10px groove skyblue;" />
	<div style="margin-top: 200px; margin-left: 430px">
		<form action="<%=basePath%>/admin/ManagerServlet?op=editCategory"
			method="post">
			<div class="form-group">
				<input type="hidden" class="form-control" id="category_id"
					name="category_id" value="${category.category_id}"
					style="width: 700px">
			</div>
			<div class="form-group">
				<label>书籍分类名称：</label> <input type="text" class="form-control"
					id="category_name" name="category_name"
					value="${category.category_name}" style="width: 700px">
			</div>
			<div class="form-group">
				<label>书籍分类描述：</label> <input type="text" class="form-control"
					id="category_desc" name="category_desc"
					value="${category.category_desc}" style="width: 700px">
			</div>
			<br>
			<button type="submit" class="btn btn-default"
				onclick="window.location='manager/ManagerServlet?op=editCategory'">提交</button>
			<button type="button" class="btn btn-default" data-dismiss="modal"
				style="margin-left: 100px" onclick="javascript :history.go(-1);">关闭</button>
		</form>
	</div>
</body>
</html>