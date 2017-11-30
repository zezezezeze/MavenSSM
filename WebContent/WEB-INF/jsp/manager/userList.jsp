<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#messagetable{
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
					<h2>User List</h2>
					<hr />
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">User</div>
						<div id="messagetable">
								<div class="btn-group">
									<button data-toggle="dropdown"
										class="btn btn-default dropdown-toggle" aria-expanded="false">
										查看用户类型 <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#">All</a></li>
										<li><a href="#">学生</a></li>
										<li><a href="#">老师</a></li>
										<li><a href="#">管理员</a></li>
									</ul>
							</div>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">

									<thead>
										<tr>
											<th>Name</th>
											<th>RealName</th>
											<th>Type</th>
											<th>update</th>
											<th>delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${userList}" var="um">
											<tr class="odd gradeX">
												<td>${um.userName }</td>
												<td>${um.realName }</td>
												<td>${um.roleId }</td>
												<td class="center"><button class="btn btn-primary" onclick="message('${um.userName }')"><i class="fa fa-edit "></i> Edit</button></td>
												<td class="center"><button class="btn btn-danger" onclick="deletea('${um.userName }')"><i class="fa fa-pencil"></i> Delete</button></td>
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
		function message(name){
			
			location.href="/MavenSSMJack1/manager/userMessage.do?name="+name;
		}
		function deletea(id){
			location.herf="";
		}
	</script>

</body>
</html>