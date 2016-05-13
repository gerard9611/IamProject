<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
		<script src="js/main.js"></script>
	
</head>
<body>
	<div class="container">
		<h1 class="text-center">Create New User</h1>
		<form action="CreateUser" id="mainForm" method="post">
			<input type="hidden" name="id" id="id" />
			<div style="visibility: visible;"
				class="form-group col-md-6 col-sm-6 col-xs-12 wow"
				data-wow-delay=".2s">
				<input value="" name="fname" class="form-control" id="fname"
					placeholder="First Name" type="text">
			</div>
			<div style="visibility: visible;"
				class="form-group col-md-6 col-sm-6 col-xs-12 wow"
				data-wow-delay=".2s">
				<input value="" name="lname" class="form-control" id="lname"
					placeholder="Last Name" type="text">
			</div>
			<div style="visibility: visible;"
				class="form-group col-md-6 col-sm-6 col-xs-12 wow"
				data-wow-delay=".2s">
				<input value="" name="date" class="form-control" id="date"
					placeholder="Date" type="text">
			</div>
			<div style="visibility: visible;"
				class="form-group col-md-6 col-sm-6 col-xs-12 wow"
				data-wow-delay=".2s">
				<input value="" name="email" class="form-control" id="email"
					placeholder="Email" type="text">
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit
				data</button>
		</form>


	</div>

	<script>
		gerardSpace.parsexml("user");
	</script>
</body>
<script>
	$(function() {
		$("#date").datepicker({
			dateFormat : 'yy-mm-dd',
			changeYear : true,
			yearRange : '1920:2016'
		});
	});
</script>
</html>
