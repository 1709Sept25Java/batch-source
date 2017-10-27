window.onload = function() {
	console.log("hello from employee page");
	sendAjax("basicinfo",employeeInformation);
	sendAjax("reimbursements", employeeReimbursements);
};

document.getElementById("reimbursementRequest").addEventListener("click", function(){
	sendAjax("reimbursement",reimbursementRequest);
});

document.getElementById("updateEmployeeRequest").addEventListener("click", function(){
	sendAjax("empupdate", updateEmployee);
});

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
//http://tutorials.jenkov.com/java-json/jackson-objectmapper.html
//https://code-maven.com/ajax-request-for-json-data

function employeeInformation(e) {
	//data = JSON.parse(e.responseText);
	//document.getElementById("employeeInformation").innerHTML = data;
	document.getElementById("employeeInformation").innerHTML = e.responseText; 
};


function employeeReimbursements(e){
	document.getElementById("employeeReimbursements").innerHTML = e.responseText; 
};

function reimbursementRequest(r){
	document.getElementById("reimbursementForm").innerHTML = r.responseText;
};

function updateEmployee(e) {
	document.getElementById("updateEmployeeForm").innerHTML = e.responseText;
	console.log("Going to update employee");
};
z