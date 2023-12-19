<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新华书店图书销售管理系统</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			 ;
%>
<link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css" />
</head>
<body>
	<script type="text/javascript"
		src="<%=basePath%>/js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/bootstrap.min.js"></script>
	<jsp:include page="/header.jsp"></jsp:include>

	<!-- 书籍导航条 -->
	<nav class="navbar navbar-default" style="
    margin-bottom: 0px;
">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=basePath%>/client/ClientServlet?op=category">书籍分类</a>
			</div>
			<div class="collapse navbar-collapse"
				 id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<c:forEach items="${categoryList}" var="c">
						<li><a href="<%=basePath%>/client/ClientServlet?op=category&cid=${c.category_id}">${c.category_name}</a></li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
				</ul>
				<!-- 搜索框 -->
				<div style="float: right; margin-right: 7px">
					<form class="navbar-form navbar-left"
						  action="<%=basePath%>/client/ClientServlet?op=search" method="post">
						<div class="form-group">
							<input type="text" name="search" class="form-control"
								   placeholder="搜索/书籍名称">
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
				</div>
			</div>
		</div>
	</nav>


	<table class="table table-bordered table-hover"
		style="margin-left: 16px; width: 1890px">
		<tr>
			<th style="width: 100px">书籍编号</th>
			<th style="width: 100px">书籍图片</th>
			<th style="width: 200px">书籍名称</th>
			<th style="width: 200px">书籍类型</th>
			<th style="width: 200px">书籍作者</th>
			<th style="width: 300px">书籍出版社</th>
			<th style="width: 200px">书籍价格</th>
			<th style="width: 200px">销量</th>
			<th style="width: 200px">操作</th>
		</tr>
		<c:forEach items="${books}" var="s" varStatus="vs">
			<tr class="active">
				<td>${vs.index+1}</td>
				<td><img style="width: 80px; height: 100px"
					src="${pageContext.request.contextPath}/img/${s.path}/${s.filename}" />
				</td>
				<td>《${s.book_name}》</td>
				<td>${s.category.category_name}</td>
				<td>${s.book_author}</td>
				<td>${s.book_press}</td>
				<td><span style="color: rgb(198, 46, 45); font-weight: bold">￥${s.book_price}</span></td>
				<td>${s.book_xiaonumber}</td>
				<td><a
					href="<%=basePath%>/client/ClientServlet?op=particulars&book_id=${s.book_id}">详情</a></td>
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>