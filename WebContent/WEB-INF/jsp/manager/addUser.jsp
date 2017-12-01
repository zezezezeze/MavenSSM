<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#message {
	padding-left: 3%;
	padding-top: 2%;
	width: 80%;
	margin-bottom: 3%
}
</style>
<body>
	<jsp:include page="managerLayout.jsp" flush="true"></jsp:include>
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
				<h2>User Message</h2>
					<div class="panel panel-default">
					
						<div class="panel-heading">User</div>
						<div id="message">
							<div class="form-group">
								<label for="disabledSelect">Disabled input</label> <input
									class="form-control" id="disabledInput" type="text"
									placeholder="Disabled input" disabled="">
							</div>
							<div class="form-group">
								<label for="disabledSelect">Disabled input</label> <input
									class="form-control" id="disabledInput" type="text"
									placeholder="Disabled input" disabled="">
							</div>
							<div class="form-group">
								<label>Text Input</label> <input class="form-control">
								<p class="help-block">Help text here.</p>
							</div>
							<div class="form-group">
								<label>User Type</label>
								<div class="radio">
									<label> <input type="radio" name="optionsRadios"
										id="optionsRadios1" value="1" checked="">学生
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="optionsRadios"
										id="optionsRadios2" value="2">教师
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="optionsRadios"
										id="optionsRadios3" value="3">管理员

									</label>
								</div>
							</div>
							<div class="form-group">
								<label>Select Example</label> <select class="form-control">
									<option>One Vale</option>
									<option>Two Vale</option>
									<option>Three Vale</option>
									<option>Four Vale</option>
								</select>
							</div>
							<a href="#" class="btn btn-danger btn-lg">SAVE</a>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- /. PAGE WRAPPER  -->
</body>
</html>