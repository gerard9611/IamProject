var gerardSpace = {
		login:function ()
		{
			var username = document.getElementById("username").value;
			var password = document.getElementById("password").value;
			var params = "username=" + username+"&password=" + password;
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					var text = xhttp.responseText;
					var identities = JSON.parse(text);

					if(identities == true)
					{

						window.location.replace("create.jsp");
					}
					else
					{
						alert("Wrong username or password!");
					}

				}
			};
			xhttp.open("POST", "/iamweb/Login", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send(params);
		},
		deleteIdentity:function (id)
		{

			var params = "id=" + id;
			var xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4 && xhttp.status == 200) {
					var text = xhttp.responseText;
					var identities = JSON.parse(text);

					if(identities == true)
					{

						window.location.reload(); 
					}
				}
			};
			xhttp.open("POST", "/iamweb/DeleteIdentity", true);
			xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhttp.send(params);
		},
		editIdentity:function (id)
		{
			var requestObj = false;
			if (window.XMLHttpRequest) 
			{
				requestObj = new XMLHttpRequest();
			} else if (window.ActiveXObject) 
			{
				requestObj = new ActiveXObject("Microsoft.XMLHTTP");
			}
			if (requestObj) 
			{
				requestObj.open("GET", "/iamweb/ReadIdentity?searchText=" + id);
				requestObj.onreadystatechange = function ()
				{
					if (requestObj.readyState == 4 && requestObj.status == 200) 
					{
						var text = requestObj.responseText;
						var identities = JSON.parse(text);
						if(identities.length == 0)
						{
							alert("Something went wrong. Please Try Again");
						}
						else
						{
							for( var i=0; i<identities.length; i++) 
							{ 
								var obj = identities[i];
								document.getElementById("id").value=obj.id;
								document.getElementById("fname").value=obj.firstName;
								document.getElementById("lname").value=obj.lastName;
								document.getElementById("email").value=obj.email;
								document.getElementById("date").value=obj.birthDate;
							}
						}
					}
				}
				requestObj.send(null);
			}

		},

		getIdentities:function ()
		{
			var requestObj = false;
			if (window.XMLHttpRequest) 
			{
				requestObj = new XMLHttpRequest();
			} else if (window.ActiveXObject) 
			{
				requestObj = new ActiveXObject("Microsoft.XMLHTTP");
			}
			var searchText = document.getElementById('searchInput').value;
			if (requestObj) 
			{
				requestObj.open("GET", "/iamweb/ReadIdentity?searchText=" + searchText);
				requestObj.onreadystatechange = function ()
				{
					if (requestObj.readyState == 4 && requestObj.status == 200) 
					{
						var text = requestObj.responseText;
						var identities = JSON.parse(text);
						if(identities.length == 0)
						{
							var tbody = document.createElement('tbody');
							var oldTbody = document.getElementById("searchResultsTableBody");
							tbody.setAttribute("id","searchResultsTableBody");
							tbody.setAttribute("class","fade");
							oldTbody.parentNode.replaceChild(tbody,oldTbody);
							tbody.setAttribute("class","fade in");

						}
						else
						{
							var tbody = document.createElement('tbody');
							for( var i=0; i<identities.length; i++) 
							{ 
								var obj = identities[i];

								var row = tbody.insertRow(i);
								var cell1 = row.insertCell(0);
								var cell2 = row.insertCell(1);
								var cell3 = row.insertCell(2);
								var cell4 = row.insertCell(3);
								var cell5 = row.insertCell(4);
								var cell6 = row.insertCell(5);
								cell1.innerHTML = obj.firstName;
								cell2.innerHTML = obj.lastName;
								cell3.innerHTML = obj.email;
								cell4.innerHTML=obj.birthDate;
								cell5.innerHTML="<button class='btn btn-lg btn-warning btn-block btnDelete' onclick='gerardSpace.deleteIdentity(" + obj.id + ")'>Delete</button>";
								cell6.innerHTML="<button class='btn btn-lg btn-warning btn-block btnEdit' onclick='gerardSpace.editIdentity(" + obj.id + ")'>Edit</button>";
							}

							var oldTbody = document.getElementById("searchResultsTableBody");
							tbody.setAttribute("id","searchResultsTableBody");
							tbody.setAttribute("class","fade");
							oldTbody.parentNode.replaceChild(tbody,oldTbody);
							tbody.setAttribute("class","fade in");
						}
					}
				}
				requestObj.send(null);
			}
		},

		/*
		 * This is how to parse XML in JS..I left it as an example
		 */
//		function parsexml(filename)
//		{
//		if (window.XMLHttpRequest)
//		{// code for IE7+, Firefox, Chrome, Opera, Safari
//		xmlhttp=new XMLHttpRequest();
//		}
//		else
//		{// code for IE6, IE5
//		xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//		}



//		xmlhttp.onload = function() 
//		{
//		var xmlDoc = new DOMParser().parseFromString(xmlhttp.responseText,'text/xml');
//		var form = document.getElementById("mainForm");
//		var x=xmlDoc.getElementsByTagName("field");
//		var content = "";
//		for (i=0;i<x.length;i++)
//		{ 

//		var elem = "";

//		if(x[i].getAttribute("type") === "hidden")
//		{
//		elem += '<input value="" name="'+x[i].getAttribute("name")+'" class="'+x[i].getAttribute("class")+'" id="'+x[i].getAttribute("id")+'" placeholder="'+x[i].getAttribute("placeholder")+'" type="'+x[i].getAttribute("type")+'">';
//		}
//		else
//		{
//		elem += '<div style="visibility: visible;" class="form-group col-md-6 col-sm-6 col-xs-12 wow" data-wow-delay=".2s">';
//		if(x[i].getAttribute("required") === "true")
//		{
//		elem += '<input value="" name="'+x[i].getAttribute("name")+'" class="'+x[i].getAttribute("class")+'" id="'+x[i].getAttribute("id")+'" placeholder="'+x[i].getAttribute("placeholder")+'" type="'+x[i].getAttribute("type")+'" required>';
//		}
//		else
//		{
//		elem += '<input value="" name="'+x[i].getAttribute("name")+'" class="'+x[i].getAttribute("class")+'" id="'+x[i].getAttribute("id")+'" placeholder="'+x[i].getAttribute("placeholder")+'" type="'+x[i].getAttribute("type")+'">';
//		}
//		elem += '</div>';
//		}
//		content += elem;
//		}
//		content += '<button class="btn btn-lg btn-success btn-block" type="submit">Submit</button>';
//		form.innerHTML = content;
//		}


//		xmlhttp.open("GET",filename+".xml",false);
//		xmlhttp.send();
//		}
		parsexml:function (fileName)
		{
			if (window.XMLHttpRequest)
			{// code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp=new XMLHttpRequest();
			}
			else
			{// code for IE6, IE5
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}



			xmlhttp.onload = function()
			{
				document.getElementById("mainForm").innerHTML=xmlhttp.responseText;
			}


			xmlhttp.open("GET","Forms?filename="+fileName,false);
			xmlhttp.send();
		}


};

function btnLogout()
{
	window.location = "/iamweb/Logout";
}
