<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add class</title>
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
					<h2>Add Class</h2>
					<div class="panel panel-default">

						<div class="panel-heading">Class</div>
						<div id="message">
							<div class="form-group">
								<label>Class Year</label> <input id="classYear"
									class="form-control" name="classYear">
								<p class="help-block">requird.</p>
							</div>
							<div class="form-group">
								<label>Class Num</label> <input id="classNum"
									class="form-control" nama="classNum">
								<p class="help-block">requird.</p>
							</div>
							<div class="form-group">
								<label>Class Type</label> <input id="classType"
									class="form-control" nama="classType">
								<p class="help-block">requird.</p>
							</div>
							
							<a class="btn btn-danger btn-lg" onclick="save()">SAVE</a>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/static/js/jquery-1.10.2.js"></script>
	<script>
		function save() {
			var classNum1=$("#classNum").val();
			var classType1 = $("#classType").val();
			var classYear1 = $("#classYear").val();
			
			if (classNum1 == "") {
				return;
			}
			if (classType1 == "") {
				return;
			}
			if (classYear1 == "") {
				return;
			}
			swal({
				title : "您确定要添加该班级吗",
				text : "请谨慎操作！",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "是的，我要添加！",
				cancelButtonText : "让我再考虑一下…",
				closeOnConfirm : false,
				closeOnCancel : false
			}, function(isConfirm) {
				if (isConfirm) {
					$.ajax({
						type : "POST",
						url : "/MavenSSMJack1/manager/addClass.do",
						dataType : "json",
						data : {
							classYear : classYear1,
							classNum : classNum1,
							classType : classType1
						},
						async : false,
						success : function(data) {
							var obj = eval(data);
							if (obj) {
								swal("true", "添加成功！");
								location.reload();
							} else {
								swal("false", "添加失败！");
							}
						}

					});
				} else {
					swal({
						title : "已取消",
						text : "您取消了该操作！",
						type : "error"
					})
				}
			})
		}
	</script>
</body>
</html>