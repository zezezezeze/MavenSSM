<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<meta charset="utf-8">

	<link rel="shortcut icon" href="<%=request.getContextPath()%>/static/images/gt_favicon.png">
	
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/font-awesome.min.css">

	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/bootstrap-theme.css" media="screen" >
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/main.css">

	




	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	    <script src="<%=request.getContextPath()%>/static/js/jquery-1.10.2.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/headroom.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/jQuery.headroom.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/js/template.js"></script>

</head>
<body>
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom">
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
				<a class="navbar-brand" href="viewMain.do"><img src="<%=request.getContextPath()%>/static/images/logo.png" alt="Progressus HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<li><a href="viewMain.do">Home</a></li>
					<li><a href="viewAbout.do">About</a></li>
					<li><a href="viewSidebar.do">viewSidebar</a></li>	
					<li><a href="viewContact.do">Contact</a></li>
					<li>
						     <%
                    Object name = session.getAttribute("userName");
                    String type;
                    String aa = "";
                    if (name != null) {
                        type = "SIGN OUT";
                        aa = name.toString();
                    } else {
                        type = "SIGN IN";
                    }
                %>
                <div style="color:write">
              
					
				<a>  <%=aa%><div class="btn"><span class="user" onclick="user()" ><%=type%></span></a></li>
					  </div>  
           </div>
           
        </div>
     
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
   <script>
            function user() {
                var a = $(".user").html();
                if (a == "SIGN OUT") {
                    location.href = "tuichu.do";
                } else if (a == "SIGN IN") {
                    location.href = "login.do";

                }
            }
        </script>


</body>
</html>