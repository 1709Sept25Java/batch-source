//JavaScript for the employee homepage

function empBasicInfo(xhr){
	var eInfo = JSON.parse(xhr.responseText);
	
	document.getElementById("uname").setAttribute("value",eInfo.username);
	document.getElementById("fname").setAttribute("value",eInfo.fName);
	document.getElementById("lname").setAttribute("value",eInfo.lName);
	document.getElementById("email").setAttribute("value",eInfo.email);
};


document.getElementById("editInfo").addEventListener("click",function(){
	console.log("Clicked");
	document.getElementById("uname").removeAttribute('disabled');
	document.getElementById("pw").removeAttribute('disabled');
	document.getElementById("fname").removeAttribute('disabled');
	document.getElementById("lname").removeAttribute('disabled');
	document.getElementById("email").removeAttribute('disabled');
	
	var bio = document.getElementById("empInfo");
	bio.innerHTML += "<button type='submit' class='btn btn-default'>Submit</button>"
	
	this.setAttribute("disabled",true);
});

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
