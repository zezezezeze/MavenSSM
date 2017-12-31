<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
<!-- BOOTSTRAP STYLES-->
<link href="<%=request.getContextPath()%>/static/css/bootstrap.css"
	rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="<%=request.getContextPath()%>/static/css/font-awesome.css"
	rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="<%=request.getContextPath()%>/static/css/custom.css"
	rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

</head>
<body>
	<%
		String addUrl = request.getContextPath() + "/manager/loginyz.do";
	%>
	<div class="container">
		<div class="row text-center ">
			<div class="col-md-12">
				<br />
				<br />
				<h2>Binary Admin : Login</h2>

				<h5>( Login yourself to get access )</h5>
				<br />
			</div>
		</div>
		<div class="row ">

			<div
				class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> Enter Details To Login </strong>
					</div>
					<div class="panel-body">
						<form action="<%=addUrl%>" method="post"
							enctype="multipart/form-data">
							<br />
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-tag"></i></span>
								<input type="text" class="form-control"
									placeholder="Your Username " id="userName" name="userName" />
							</div>
							<div class="form-group input-group">
								<span class="input-group-addon"><i class="fa fa-lock"></i></span>
								<input type="password" class="form-control"
									placeholder="Your Password" id="password" name="password" />
							</div>
							<div class="form-group">
								<label class="checkbox-inline"> <input type="checkbox" />
									Remember me
								</label> <span class="pull-right"> <a href="#">Forget
										password ? </a>
								</span>
							</div>

							<button type="submit" class="btn btn-primary ">Login Now</button>
							<hr />
						</form>
					</div>

				</div>
			</div>


		</div>
	</div>


	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="<%=request.getContextPath()%>/static/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/static/js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="<%=request.getContextPath()%>/static/js/custom.js"></script>

</body>
</html>