<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
<%
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
<input type="reset" value="重置" />
</form>
</body>
</html>