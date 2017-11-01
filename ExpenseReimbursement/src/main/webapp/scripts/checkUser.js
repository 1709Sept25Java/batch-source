function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest() || new ActiveXObject("MICROSOFT.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function popularUser(xhr){
	var res = JSON.parse(xhr.responseText);
	if(res.username != "null"){
		document.getElementById("user").innerHTML = " you are logged in as" +res.username;
	}else{
		window.location = "http://localhost:8082/ExpenseReimbursement/login";
	}
}

window.onload = function(){
	sendAjaxGet("http://localhost:8082/ExpenseReimbursement/session",populateUser);
}