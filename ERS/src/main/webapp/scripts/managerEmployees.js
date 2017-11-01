//Ajax call under the manager link to view employees
//Shows employees and allows manager to click on an employee 
//to view profile
window.onload = function() {
	sendAjax("viewEmployees", viewEmployees);
};

function sendAjax(url, cFunction) {
	var xhr;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	}
	else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			cFunction(this);
		}
	};
	xhr.open("GET",url,true);
	xhr.send();
};

function viewEmployees(e) {
	var employees = JSON.parse(e.responseText);
	var employeeDiv = "<h3>Employees</h3>";
	for (var i=0; i<employees.length; i++) {
		employeeDiv += "Name: " + employees[i].firstName;
		employeeDiv += " " + employees[i].lastName +"<br>";
		employeeDiv += "ID: " + employees[i].uID +"<br>";
		employeeDiv += "Username: " + employees[i].username +"<br>";
		employeeDiv += "<br><form action = 'employeeProfile' method = 'POST' > <input type = hidden name=eID value='" +employees[i].uID + "'> <input type='submit' value='Employee Profile'></form>";
		employeeDiv += "<hr>";
	}
	document.getElementById("viewEmployees").innerHTML = employeeDiv;
};


