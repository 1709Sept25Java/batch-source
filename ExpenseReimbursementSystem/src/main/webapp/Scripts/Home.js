function sendAjaxGet(url,func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if (this.readyState  == 4 && this.status == 200 ){
			func(this);
		}
	};
	xhr.open("GET", url, true)
	xhr.send();
};

function getUsername(xhr){ 
	var res = xhr.responseText;
	var res = JSON.parse(xhr.responseText);
	name = res.name;
	email = res.email;
	welcome = document.getElementById("welcome");
	welcome.innerHTML = "Welcome "+ name;
	profileLink = document.getElementById("profile-link")
	profileLink.setAttribute("href","Profile.html?email="+email);
}

function removeSubmission(xhr){
	var res = xhr.responseText;
	var res = JSON.parse(xhr.responseText);
	var id = res.managerId;
	if (id == 1){
		document.getElementById("submit-request").remove();
	}
}

window.onload = function() {
	sendAjaxGet('http://localhost:8082/ExpenseReimbursementSystem/isManager', removeSubmission);
	sendAjaxGet('http://localhost:8082/ExpenseReimbursementSystem/home', getUsername);
}

