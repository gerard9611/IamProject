<!-- 
This page is used for:
- Login user
- Redirect to create a new User
 -->
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%
	session = request.getSession();
	String id = (String) session.getAttribute("id");
	if (id == null || id.trim().equals("")) {
		//session empty
	} else {
		response.sendRedirect("/iamweb/create.jsp");
	}
	if (request.getParameter("msg") != null && request.getParameter("msg").equals("error")) {
		out.println("<script>alert('Error in Creating User!');</script>");
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<div class="container">
		<div class="row ">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="account-wall">
					<img class="profile-img" src="img/logo.png" alt="">
						<div class="form-signin">
							<input type="text" class="form-control" id="username"
								placeholder="Email" required autofocus> <input
								type="password" class="form-control" id="password"
								placeholder="Password" required>
									<button class="btn btn-lg btn-primary btn-block"
										onclick="gerardSpace.login()">Sign in</button>
						</div>
				</div>
				<a href="/iamweb/createuser.jsp" class="text-center new-account">Create
					an account </a>
			</div>
		</div>
		<div id="text"></div>
	</div>
	<script src="js/main.js"></script>
</body>

</html>

