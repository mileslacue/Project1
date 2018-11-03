$(document).ready(function(){

    $("#login").click(validateLogin);
});


function validateLogin(){

	
	//get value from HTML inputs
    var username = $("#username").val();
    var password = $("#password").val();
    
    
    //create record called "credentials"
    var credentials = [username, password];
	var credentialsJSON = JSON.stringify(credentials);
    console.log(credentialsJSON);
    //create XHR request
	var xhr = new XMLHttpRequest();

    //open the xhr request, POST method, declare the route||path and set the asynchronous boolean to true
    xhr.open('POST', 'login', true);

    //send the credentials in the XHR request and wait for a response.
	xhr.send(credentialsJSON);
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
			let user = JSON.parse(xhr.responseText);
			if(user) {
				alert('Login successful!');
				window.localStorage.setItem('user', xhr.responseText);
				loadHome();
				console.log(`User id: ${user.id} login successful`);
			} else {
				$('#login-message').show();
				$('#login-message').html('Invalid credentials');
			}
		}
		
	}

}