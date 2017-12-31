<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style type="text/css">
</style>
</head>
<body id="top">
	<jsp:include page="viewLayout.jsp" flush="true"></jsp:include>
	 <%
	String addUrl = request.getContextPath() + "/view/loginyz.do";
	String createImg = request.getContextPath() + "/view/createImg.do";
%>
	<%-- <%
	String addUrl = request.getContextPath() + "/view/loginyz.do";
	String createImg = request.getContextPath() + "/view/createImg.do";
%>
<form action="<%=addUrl%>" method="post" enctype="multipart/form-data">
<label>账号：</label>
<input type="text" id="userName" name="userName" placeholder="请输入用户名" /><br/>
<label>密码：</label>
<input type="password" id="password" name="password" placeholder="请输入密码" /><br/>
				
                    验证码：<input name="yzm" type="text" class="width70" />
                   <img src="<%=createImg%>" onclick="this.src='/MavenSSMJack1/view/createImg.do?x='+Math.random();" alt="验证码" title="点击更换"/>
                   <br>
<input type="submit" value="提交" />
<input type="reset" value="重置" /> --%>
	<!-- /.navbar -->

	<header id="head" class="secondary"></header>

	<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<li><a href="viewMain.do">Home</a></li>
			<li class="active">User access</li>
		</ol>

		<div class="row">

			<!-- Article main content -->
			<article class="col-xs-12 maincontent"> <header
				class="page-header">
			<h1 class="page-title">Sign in</h1>
			</header>

			<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="panel panel-default">
					<div class="panel-body">
						<h3 class="thin text-center">Sign in to your account</h3>
						<p class="text-center text-muted">
							Lorem ipsum dolor sit amet, <a href="">no Register</a>
							adipisicing elit. Quo nulla quibusdam cum doloremque incidunt
							nemo sunt a tenetur omnis odio.
						</p>
						<hr>

						<form action="<%=addUrl%>" method="post" enctype="multipart/form-data">
							<div class="top-margin">
								<label>Username <span class="text-danger">*</span></label> <input
									type="text" class="form-control" id="userName" name="userName">
							</div>
							<div class="top-margin">
								<label>Password <span class="text-danger">*</span></label> <input
									type="password" class="form-control" id="password"
									name="password">
							</div>
							<div class="top-margin">
								<label>验证码(区分大小写) <span class="text-danger">*</span></label> <input
									type="text" name="yzm" class="width70" class="form-control"> <img
									src="<%=createImg%>"
									onclick="this.src='/MavenSSMJack1/view/createImg.do?x='+Math.random();"
									alt="验证码" title="点击更换" /> <br>
							</div>
							<hr>

							<div class="row">
								<div class="col-lg-8">
									<b><a href="">Forgot password?</a></b>
								</div>
								<div class="col-lg-4 text-right">
									<button class="btn btn-action" type="submit">Sign in</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>

			</article>
			<!-- /Article -->

		</div>
	</div>
	<!-- /container -->
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