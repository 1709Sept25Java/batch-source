//JavaScript for the employee homepage

function empBasicInfo(xhr){
	var eInfo = JSON.parse(xhr.responseText);
	
	var bio = document.getElementById("empInfo");
	var node = document.createElement("tr");
	bio.innerHTML = "<tr><td>Username: </td> <td>" +eInfo.username+"</td></tr>";
	bio.innerHTML += "<tr><td>First Name: </td> <td>" +eInfo.fName+"</td></tr>";
	bio.innerHTML += "<tr><td>Last Name: </td> <td>" +eInfo.lName+"</td></tr>";
	bio.innerHTML += "<tr><td>Email: </td> <td>" +eInfo.email+"</td></tr>";
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
