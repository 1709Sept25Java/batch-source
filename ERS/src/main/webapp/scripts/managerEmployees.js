window.onload = function() {
	console.log("get employees");
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
	var table = "<tr><th>ID</th><th>username</th><th>first name</th><th>last name</th></tr>";
	for (var i=0; i<employees.length; i++) {
		table += "<tr><td>" + employees[i].uID +"</td>";
		table += "<td>" + employees[i].username +"</td>";
		table += "<td>" + employees[i].firstName +"</td>";
		table += "<td>" + employees[i].lastName +"</td></tr>";
	}
	document.getElementById("employeesTable").innerHTML = table;
};