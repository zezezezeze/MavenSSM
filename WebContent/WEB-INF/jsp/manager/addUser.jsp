<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@taglib prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add user</title>
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
					<h2>Add User</h2>
					<div class="panel panel-default">

						<div class="panel-heading">User</div>
						<div id="message">
							<div class="form-group">
								<label>User Name</label> <input id="userName"
									class="form-control" name="userName">
								<p class="help-block">requird.</p>
							</div>
							<div class="form-group">
								<label>Real Name</label> <input id="realName"
									class="form-control" nama="realName">
								<p class="help-block">requird.</p>
							</div>
							<div class="form-group">
								<label>User Type</label>
								<div class="radio">
									<label> <input type="radio" name="roleId"
										id="optionsRadios1" value="2" checked="">学生
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="roleId"
										id="optionsRadios2" value="3">教师
									</label>
								</div>
								<div class="radio">
									<label> <input type="radio" name="roleId"
										id="optionsRadios3" value="4">管理员

									</label>
								</div>
							</div>
							<div class="form-group">
								<label>学生班级</label> <select class="form-control" id="sss" >
									<c:forEach items="${tbGroupList}" var="um">
										<tr class="odd gradeX">
											<option value="${um.id}">专业：${um.classType}-年级：${um.classYear}-班级：${um.classNum} </option>
									</c:forEach>
								</select>
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
			var class1=$("#sss").val();
			var username1 = $("#userName").val();
			var realname1 = $("#realName").val();
			var usertype = document.getElementsByName("roleId");
			var type1;
			for (var i = 0; i < usertype.length; i++) {
				if (usertype[i].checked) {
					type1 = usertype[i].value;
				}
			}

			if (username1 == "") {
				return;
			}
			if (realname1 == "") {
				return;
			}
			if (usertype == "") {
				return;
			}
			if(type1==2){
				if(class1==3){
					swal("waring", "请选择学生的班级！");
					return;
				}
			}else{
				if(class1!=3){
					swal("waring", "请选择管理员项！");
					return;
				}
				
			}
			swal({
				title : "您确定要添加该用户吗",
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
						url : "/MavenSSMJack1/manager/addUser.do",
						dataType : "json",
						data : {
							userName : username1,
							realName : realname1,
							userType : type1
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