<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/test.css" />
   
<body>
	<%
		String addUrl = request.getContextPath() + "/user/addUser.do";
	%>
	<%-- <form action="<%=addUrl%>" method="post" enctype="multipart/form-data">
	照片：<input type="file" name="photoFile" id="photoFile"><br>
	<input type="submit" value="提交">
</form> --%>
<h1 id="h1">添加用户</h1>
	<form action="<%=addUrl%>" method="post" enctype="multipart/form-data">
		用户名：<input type="text" name="userName" id="userName" /><br> 
		真实名字：<input type="text" name="realName" id="realName" /><br> 
		班级代码<input type="text" name="groupId" id="groupId" /><br>
		<input type="submit" value="提交">
	</form>
	<script src="<%=request.getContextPath()%>/static/js/jquery-2.1.0.js"></script>
 
	<script>
	 	function tijiao(){
	 		alert("tijiao");
	 	}
	</script>
</body>
</html>