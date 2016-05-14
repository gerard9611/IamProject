<!-- 
This Page is used to:
- Create Identity
- Edit Identity
- List Identities
- Search for Identity
- Delete Identity
 -->

<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>IAm</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<%
			session = request.getSession();
			String id = (String)session.getAttribute("id");  
			if (id == null || id.trim().equals(""))
			{
				//session empty
				String redirectURL = "index.jsp";
			    response.sendRedirect(redirectURL);
			}
			if(request.getParameter("msg") != null && request.getParameter("msg").equals("error"))
			{
				out.println("<script>alert('Error in Creating Identity!');</script>");
			}
		%>
<script src="js/main.js"></script>
</head>
<body>
	<div class="container">
		<button class="btn btn-danger" onclick="btnLogout();" type="submit">Logout</button>
		<h1 class="text-center">Create New Identity</h1>
		<form action="CreateIdentity" id="mainForm" method="post"></form>

		<h1 class="text-center">Identities</h1>
		<input type="text" id="searchInput" placeholder="Search" />
		<button class="btn btn-info" onclick="gerardSpace.getIdentities()">Search</button>
		<table class="table">
			<thead>
				<tr>
					<th>First Name</th>

					<th>Last Name</th>

					<th>Email</th>

					<th>Birth date</th>
				</tr>
			</thead>
			<tbody id="searchResultsTableBody">

			</tbody>

		</table>
	</div>

	<script>gerardSpace.getIdentities();</script>
	<script>gerardSpace.parsexml("form");</script>
</body>
<script>
		  $(function() {
		    $( "#date" ).datepicker({ 
			    dateFormat: 'yy-mm-dd', 
			    changeYear:true,
			    yearRange: '1920:2016' 
		    });
		  });
  		</script>
</html>
