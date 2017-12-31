<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>class list</title>
</head>
<style>
#messagetable {
	padding-left: 1.5%;
	padding-top: 1%;
}

#adduser {
	margin-left: 87%;
}

#yema {
	margin-left: 41%;
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
					<h2>Class List</h2>
					<hr />
					<!-- Advanced Tables -->
					<div class="panel panel-default">
						<div class="panel-heading">Class</div>
						<div id="messagetable">
							<div class="btn-group">
							
								
							</div>
							<a id="adduser" href="/MavenSSMJack1/manager/addClass.do"
								class="btn btn-success btn-lg">Add Class</a>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables-example">
									<thead>
										<tr>
											<th>Id</th>
											<th>classType</th>
											<th>classYear</th>
											<th>classNum</th>
											<th>delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${classList}" var="um">
											<tr class="odd gradeX">
												<td class="center">${um.id }</td>
												<td>${um.classType }</td>
												<td>${um.classYear }</td>
												<td>${um.classNum }</td>
												
												<td class="center"><button class="btn btn-danger"
														onclick="deletea('${um.id }')">
														<i class="fa fa-pencil"></i> Delete
													</button></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div id="yema">
								<a onclick="yeyeyeshang()" class="btn btn-default btn-sm">上一页</a>
								<a onclick="yeyeyexia()" class="btn btn-default btn-sm">下一页</a>
								共${classCount}页
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
		function yeyeyexia() {
			var ye = GetQueryString("cp");
			var end = ${classCount};
			if (ye == null) {
				ye = 1;
			}
			if (parseInt(ye) + 1 > end) {
				return;
			}
			location.href = "/MavenSSMJack1/manager/classList.do?cp="
					+ (parseInt(ye) + 1);
		}
		function yeyeyeshang() {
			var ye = GetQueryString("cp");
			if (ye == null || ye == 1) {
				ye = 1;
				return;
			}
			location.href = "/MavenSSMJack1/manager/classList.do?cp="
					+ (parseInt(ye) - 1);
		}
		function deletea(id1) {
			swal({
				title : "您确定要删除该班级吗",
				text : "删除后无法恢复,请谨慎操作！",
				type : "warning",
				showCancelButton : true,
				confirmButtonColor : "#DD6B55",
				confirmButtonText : "是的，我要删除！",
				cancelButtonText : "让我再考虑一下…",
				closeOnConfirm : false,
				closeOnCancel : false
			}, function(isConfirm) {
				if (isConfirm) {

					$.ajax({
						type : "GET",
						url : "/MavenSSMJack1/manager/deleteClass.do",
						dataType : "json",
						data : {
							id : id1
						},
						async : false,
						success : function(data) {
							var obj = eval(data);
							if (obj) {
								swal("true", "删除成功！");
								location.reload();
							} else {
								swal("false", "删除失败！");
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
		
		

		function GetQueryString(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			var r = window.location.search.substr(1).match(reg);
			if (r != null)
				return unescape(r[2]);
			return null;
		}
	</script>

</body>
</html>