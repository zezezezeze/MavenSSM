<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
.col-sm-4 {
	margin-top: 1%;
}
</style>
</head>
<body id="top">

	<jsp:include page="viewLayout.jsp" flush="true"></jsp:include>
	<!-- /.navbar -->

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="viewMain.do">Home</a></li>
			<li class="active">About</li>
		</ol>

		<div class="row">

			<!-- Article main content -->
			<article class="col-sm-9 maincontent"> <header
				class="page-header">
			<h1 class="page-title">Contact us</h1>
			</header> <input type="hidden" id="id" value="${user.id}" />
			<p>${user.realName} message</p>
			<br>
			<div class="row">

				<br>
				<div class="col-sm-4">
					<input class="form-control" type="text" placeholder="userName"
						disabled="disabled" value="${user.userName}">
				</div>
				<div class="col-sm-4">
					<input class="form-control" type="text" placeholder="classYear"
						disabled="disabled" value="${group.classYear} 级 ">
				</div>
				<div class="col-sm-4">
					<input class="form-control" type="text" placeholder="classType"
						disabled="disabled" value="${group.classType} 专业">
				</div>
				<div class="col-sm-4">
					<input class="form-control" type="text" placeholder="classNum"
						disabled="disabled" value="${group.classNum} 班">
				</div>
				<div class="col-sm-4">
					<input class="form-control" type="text" placeholder="roleName"
						disabled="disabled" value="${role.roleName}">
				</div>
			</div>
			<br>
			<br>
			<div class="row">
				<div class="col-sm-6">
					<label class="checkbox"><input type="checkbox">
						Sign up for newsletter</label>
				</div>
				<div class="col-sm-6 text-right">
					<input class="btn btn-action" type="submit" value="Save">
				</div>
			</div>

			</article>
			<!-- /Article -->

			<!-- Sidebar -->
			<aside class="col-sm-3 sidebar sidebar-right">

			<div class="widget">
				<h4>Image</h4>
				<img src="${user.image}" width="250" height="280" />
				<%
					String addUrl = request.getContextPath() + "/user/add.do";
				%>
				<form action="<%=addUrl%>" method="post"
					enctype="multipart/form-data">
					<input type="hidden" id="id" name="id" value="${user.id}" />
					照片：<input type="file" name="photoFile" id="photoFile"><br>
					<input type="submit" value="提交">
				</form>
			</div>

			</aside>
			<!-- /Sidebar -->

		</div>
	</div>
	<!-- /container -->

	<section class="container-full top-space">
	<div id="map"></div>
	</section>

	<div class="copyrights">
		Collect from <a href="">Jack</a>
	</div>

	<footer id="footer" class="top-space">

	<div class="footer1">
		<div class="container">
			<div class="row">

				<div class="col-md-3 widget">
					<h3 class="widget-title">Contact</h3>
					<div class="widget-body">
						<p>
							+123456789<br> <a href="mailto:#">ningzhang_mail@163.com</a><br>
							<br> ShanDong QingDao
						</p>
					</div>
				</div>

				<div class="col-md-3 widget">
					<h3 class="widget-title">Follow me</h3>
					<div class="widget-body">
						<p class="follow-me-icons">
							<a href=""><i class="fa fa-twitter fa-2"></i></a> <a href=""><i
								class="fa fa-dribbble fa-2"></i></a> <a href=""><i
								class="fa fa-github fa-2"></i></a> <a href=""><i
								class="fa fa-facebook fa-2"></i></a>
						</p>
					</div>
				</div>

				<div class="col-md-6 widget">
					<h3 class="widget-title">Text widget</h3>
					<div class="widget-body">
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Excepturi, dolores, quibusdam architecto voluptatem amet fugiat
							nesciunt placeat provident cumque accusamus itaque voluptate modi
							quidem dolore optio velit hic iusto vero praesentium repellat
							commodi ad id expedita cupiditate repellendus possimus unde?</p>
						<p>Eius consequatur nihil quibusdam! Laborum, rerum, quis,
							inventore ipsa autem repellat provident assumenda labore soluta
							minima alias temporibus facere distinctio quas adipisci nam sunt
							explicabo officia tenetur at ea quos doloribus dolorum voluptate
							reprehenderit architecto sint libero illo et hic.</p>
					</div>
				</div>

			</div>
			<!-- /row of widgets -->
		</div>
	</div>

	<div class="footer2">
		<div class="container">
			<div class="row">

				<div class="col-md-6 widget">
					<div class="widget-body">
						<p class="simplenav">
							<a href="viewMain.do">Home</a> | <a href="viewAbout.do">About</a>
							| <a href="viewSidebar.do">Sidebar</a> | <a href="viewcontact.do">Contact</a>
							| <b><a href="login.do">Sign up</a></b>
						</p>
					</div>
				</div>

				<div class="col-md-6 widget">
					<div class="widget-body">
						<p class="text-right">
							Copyright &copy; 2017, java10. ZhangNing ...<a href=""
								target="_blank" title="aa">Jack</a>
					</div>
				</div>

			</div>
			<!-- /row of widgets -->
		</div>
	</div>

	</footer>

</body>
</html>