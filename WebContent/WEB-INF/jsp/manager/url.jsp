<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>url</title>
</head>
<style>
#messagetable {
	padding-left: 1.5%;
	padding-top: 1%;
}
</style>
<body>
	<%-- <%@include file="managerLayout.jsp"%> --%>
	<jsp:include page="managerLayout.jsp" flush="true"></jsp:include>
	<!-- /. NAV SIDE  -->
	<div id="page-wrapper">
		<div id="page-inner">
			<div class="row">
				<div class="col-md-12">
					<h2>Url List</h2>
					<hr />
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">Url</div>
						<div id="messagetable">
							<div class="btn-group">
						
							</div>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">

									<thead>
										<tr>
											<th>Id</th>
											<th>Name</th>
											<th>Url</th>
											<th>Descripe</th>
											<th>updateName</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${urlList}" var="um">
											<tr class="odd gradeX">
												<td>${um.id }</td>
												<td>${um.name }</td>
												<td>${um.url }</td>
												<td>${um.descripe }</td>
												<td class="center"><button class="btn btn-danger"
														onclick="updateName('${um.id }')">
														<i class="fa fa-pencil"></i> Update
													</button></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

						</div>
					</div>
					<!--End Advanced Tables -->

				</div>

			</div>

			<hr />

		</div>

	</div>
	<!-- /. PAGE WRAPPER  -->
	<!-- JQUERY SCRIPTS -->
	<!-- DATA TABLE SCRIPTS -->
	<script
		src="<%=request.getContextPath()%>/static/js/dataTables/jquery.dataTables.js"></script>
	<script
		src="<%=request.getContextPath()%>/static/js/dataTables/dataTables.bootstrap.js"></script>
	<script>
		$(document).ready(function() {
			$('#dataTables-example').dataTable();
		});

		function updateName(id) {
					swal({
						title : "你确定要修改该模块名字吗？",
						text : "请填写新名称:",
						type : "input",
						showCancelButton : true,
						closeOnConfirm : false,
						animation : "slide-from-top",
						inputPlaceholder : "Write something"
					}, function(inputValue) {
						if (inputValue === false)
							return false;

						if (inputValue === "") {
							swal.showInputError("请填写新名称");
							return false
						}
						if (inputValue) {
							$.ajax({
								type : "POST",
								url : "/MavenSSMJack1/manager/updateUrlName.do",
								data:{id: id, name : inputValue},
								dataType : "json",
								async : false,
								success : function(data) {
									var obj = eval(data);
									if (obj) {
										swal("好的!", "修改成功");
										location.reload();
									} else {
										swal("Error", "修改失败");
									}
								}

							});
						}
						
					});
				}
	</script>

</body>
</html>