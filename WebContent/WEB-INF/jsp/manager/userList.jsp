<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user list</title>
</head>
<style>
#messagetable {
	padding-left: 1.5%;
	padding-top: 1%;
}

#adduser {
	margin-left: 74.5%;
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
									<li><a onclick="type11(0)">All</a></li>
									<li><a onclick="type11(2)">学生</a></li>
									<li><a onclick="type11(3)">老师</a></li>
									<li><a onclick="type11(4)">管理员</a></li>
								</ul>
							</div>
							<a id="adduser" href="/MavenSSMJack1/manager/addUser.do"
								class="btn btn-success btn-lg">Add User</a>
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
											<th>updatePwd</th>
											<th>delete</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${userList}" var="um">
											<tr class="odd gradeX">
												<td>${um.userName }</td>
												<td>${um.realName }</td>
												<td>${um.roleId }</td>
												<td class="center"><button class="btn btn-primary"
														onclick="updatePwd('${um.id }')">
														<i class="fa fa-edit "></i> Update
													</button></td>
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
								共${userCount}页
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
		function type11(t) {
			if (t != "0") {
				location.href = "/MavenSSMJack1/manager/userList.do?kw=" + t;
			} else {
				location.href = "/MavenSSMJack1/manager/userList.do";
			}
		}
		function yeyeyexia1() {

			alert(GetQueryString("cp"));

		}
		function yeyeyexia() {
			var ye = GetQueryString("cp");
			var typ = GetQueryString("kw");
			var end = ${userCount};
			if (ye == null) {
				ye = 1;
			}
			if (parseInt(ye) + 1 > end) {
				return;
			}

			if (typ == null) {
				typ = "";
			}
			location.href = "/MavenSSMJack1/manager/userList.do?cp="
					+ (parseInt(ye) + 1) + "&kw=" + typ;
		}
		function yeyeyeshang() {
			var ye = GetQueryString("cp");
			var typ = GetQueryString("kw");
			if (ye == null || ye == 1) {
				ye = 1;
				return;
			}
			if (typ == null) {
				typ = "";
			}
			location.href = "/MavenSSMJack1/manager/userList.do?cp="
					+ (parseInt(ye) - 1) + "&kw=" + typ;
		}
		function deletea(id1) {
			swal({
				title : "您确定要删除该用户吗",
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
						url : "/MavenSSMJack1/manager/deleteUser.do",
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
		function updatePwd(id1) {
			swal({
				title : "你确定要修改该用户的密码吗？",
				text : "请填写新密码:",
				type : "input",
				showCancelButton : true,
				closeOnConfirm : false,
				animation : "slide-from-top",
				inputPlaceholder : "Write something"
			}, function(inputValue) {
				if (inputValue === false)
					return false;

				if (inputValue === "") {
					swal.showInputError("请填写新密码");
					return false
				}
				if (inputValue) {
					$.ajax({
						type : "POST",
						url : "/MavenSSMJack1/user/updatePwd.do",
						data : {
							id : id1,
							pwd : inputValue
						},
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
						},
						error : function() {
							swal("Error", "未知的错误发生了");
						}

					});
				}

			});
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