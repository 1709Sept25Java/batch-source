//Ajax calls on the empoyee homepage
//The main call is to display the employee information

window.onload = function() {
	//Load employee information
	sendAjax("employeeInformation",employeeInformation);
	//Load reimbursements for employee
	//sendAjax("employeeReimbursements", employeeReimbursements);
};

//Function to send ajax request 
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

//Function to load basic employee information
function employeeInformation(e) {
	//JSON response from server
	var employee = JSON.parse(e.responseText);
	
	//Employee information to be displayed
	var header  = "<div id = 'user'> <h3>" + employee.username + "'s Personal Information </h3>"
	var name = "<p>Name: "+employee.firstName + " " + employee.lastName + "</p>"
	var contact = "<p>Contact: <a href='"+employee.email+"'>"+ employee.email +"</a></p>"
	//We change the title of the html page and page header 
	//once we have the employee's username
	document.getElementById("header").innerHTML = employee.username + "'s Employee Home"; 
	document.getElementById("title").innerHTML = employee.username + "'s Home"; 
	
	//We show the employee's information 
	//and also allow them to update their information
	document.getElementById("employeeInformation").innerHTML = header + name + contact + "</div>"; 
};

document.getElementById("updateEmployeeRequest").addEventListener("click", function(){
	sendAjax("employeeUpdate", updateEmployee);
});

function updateEmployee(e) {
	document.getElementById("updateEmployeeForm").innerHTML = e.responseText;
};
