//JavaScript for the employee homepage

function empBasicInfo(xhr){
	var eInfo = JSON.parse(xhr.responseText);
	
	var bio = document.getElementById("empInfo");
	var node = document.createElement("tr");
	bio.innerHTML = "<span class='col-md-4'>Username: </span><span class='col-md-4'>" +eInfo.username+"</span>";
	bio.innerHTML += "<span class='col-md-4'>First Name: </span><span class='col-md-4'>" +eInfo.fName+"</span>";
	bio.innerHTML += "<span class='col-md-4'>Last Name: </span><span class='col-md-4'>" +eInfo.lName+"</span>";
	bio.innerHTML += "<span class='col-md-4'>Email: </span><span class='col-md-4'>" +eInfo.email+"</span>";
}

function sendAJAX(url,func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.onreadystatechange = function(){
		//check that the response is ready and correct
		if(this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	
	//open the request, let it default to async
	xhr.open("GET",url);
	//Get request so no response body
	xhr.send();	
}

window.onload = function(){
	sendAJAX("http://localhost:8082/EmployeeRepaymentSystem/empinfo",empBasicInfo);
}
