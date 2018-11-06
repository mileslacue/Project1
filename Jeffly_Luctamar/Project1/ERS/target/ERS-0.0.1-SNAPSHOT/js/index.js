$(document).ready(function() {
	loadLogin();
});

function loginFunctionality (){
	console.log("Successfully inside of loginFunctionality ()")
	//on click of the submit button inside of the login modal, validate the users input
	$("#validateUser").click(validateLogin);
	
	// Get the modal
	var modal = document.getElementById('myModal');

	// Get the button that opens the modal
	var btn = document.getElementById("login");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks the button, open the modal
	btn.onclick = function() {
		modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
}

function loadLogin() {
	// console.log to tell that we are entering this function
	console.log('in loadLogin()');

	// create new Http Request
	let xhr = new XMLHttpRequest();

	// Open the request using a Get method, get the view called login.view and
	// do this asynchronously
	xhr.open('GET', 'login.view', true);

	// send the request
	xhr.send();

	// if the request comes back ok, get the element with the id "view" from the
	// dom and insert the response.
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			loginFunctionality();
		}
	}
}

function validateLogin() {
	// get value from HTML inputs
	var username = $("#username").val();
	var password = $("#password").val();

	// create record called "credentials"
	var credentials = [ username, password ];
	var credentialsJSON = JSON.stringify(credentials);

	// create XHR request
	var xhr = new XMLHttpRequest();

	// open the xhr request, POST method, declare the route||path and set the
	// asynchronous boolean to true
	xhr.open('POST', 'login', true);

	// send the credentials in the XHR request and wait for a response.
	xhr.send(credentialsJSON);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if (user) {
				alert('Login successful!');
				window.localStorage.setItem('user', xhr.responseText);
				console.log(user);
				loadReimb();
				console.log(`User id: ${user.id} login successful`);
			} else {
				$('#login-message').show();
				$('#login-message').html('Invalid credentials');
			}
		}
	}
}

function loadReimb() {
	// console.log to tell that we are entering this function
	console.log('Sucessfully inside of loadReimb()');

	// create new Http Request
	let xhr = new XMLHttpRequest();

	// Open the request using a Get method, get the view called login.view and
	// do this asynchronously
	xhr.open('GET', 'reimbursement.view', true);

	// send the request
	xhr.send();

	// if the request comes back ok, get the element with the id "view" from the
	// dom and insert the response.
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById('view').innerHTML = xhr.responseText;
			
		}
	}
}
