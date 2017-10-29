function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		// console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function userInfo(xhr){
	var res = JSON.parse(xhr.responseText);
	console.log(res.user_id);
	if(res.user_id != "null"){
		document.getElementById("u_id").innerHTML = res.user_id;
	}else{
		document.getElementById("u_id").innerHTML = "N/A";
	}
	if(res.username != "null"){
		document.getElementById("u_name").innerHTML = res.username;
	}else{
		document.getElementById("u_name").innerHTML = "N/A";
	}
	if(res.password != "null"){
		document.getElementById("u_pw").innerHTML = res.password;
	}else{
		document.getElementById("u_pw").innerHTML = "N/A";
	}
	if(res.firstname != "null"){
		document.getElementById("fname").innerHTML = res.firstname;
	}else{
		document.getElementById("fname").innerHTML = "N/A";
	}
	if(res.lastname != "null"){
		document.getElementById("lname").innerHTML = res.lastname;
	}else{
		document.getElementById("lname").innerHTML = "N/A";
	}
	if(res.email != "null"){
		document.getElementById("email").innerHTML = res.email;
	}else{
		document.getElementById("email").innerHTML = "N/A";
	}	
}
window.onload = function(){
	sendAjaxGet("http://localhost:8082/ERSProject/session", userInfo);
}