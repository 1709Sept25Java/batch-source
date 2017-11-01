window.addEventListener("load", initProfile);

function initProfile(){
	sendAjaxGet('http://localhost:8082/ExpenseReimbursementSystem/employees', getEmployee);
	document.getElementById("pending").style.display = "block";
	document.getElementById("edit").addEventListener("click",editPage);
}


function sendAjaxGet(url,func){
	xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if (this.readyState  == 4 && this.status == 200 ){
			func(this);
		}
	};
	xhr.open("GET", url, true)
	xhr.send();
};

function getEmployee(xhr){ 
	res = JSON.parse(xhr.responseText);
	url = window.location.href;
	startChar = url.lastIndexOf("=");
	employeeEmail = url.substring(startChar+1);
	for (i = 0; i<Object.keys(res).length; i++){
		if (res[Object.keys(res)[i]].email == employeeEmail){
			employeeObject = res[Object.keys(res)[i]];
		}
	}
	managerId = employeeObject.managerId;
	employeeId = employeeObject.employeeId;
	document.getElementById("name").innerHTML = employeeObject.name;
	document.getElementById("email").innerHTML = employeeObject.email;
	currentUrl = window.location.href;
	endIndex = currentUrl.indexOf("Profile.html");
	urlRoot = currentUrl.substring(0,endIndex);
	if (employeeId == 1 && document.referrer == urlRoot+"AllEmployees.html"){
		document.getElementById("employee-fields").remove();
		document.getElementById("back-link").innerHTML = "<a href=\"AllEmployees.html\">Back to all Employees</a>";
	} else if (employeeId == 1) {
		document.getElementById("employee-fields").remove();
		document.getElementById("back-link").innerHTML = "<a href=\"ManagerHome.html\">Back to Home Page</a>";
	} else {
		document.getElementById("back-link").innerHTML = "<a href=\"EmployeeHome.html\">Back to Home Page</a>";
		sendAjaxGet('http://localhost:8082/ExpenseReimbursementSystem/employees', getManagerName);
	}
	//sendAjaxGet('http://localhost:8082/ExpenseReimbursementSystem/reimbursements', getReimbursements);
}

function getManagerName(xhr) {
	res = JSON.parse(xhr.responseText);
	document.getElementById("manager").innerHTML = res[managerId].name;
}


//////editing profile info//////

function editPage(){
	this.innerHTML = "exit";
	this.removeEventListener("click", editPage);
	this.addEventListener("click", leaveEdit);
	////create form////
	nameElement = document.getElementById("name");
	nameForm = document.createElement("form");
	nameForm.setAttribute('method',"post");
	nameForm.setAttribute('action',"updateName");
	nameElement.appendChild(nameForm);
	nameInput = document.createElement("input");
	nameInput.setAttribute('type',"text");
	nameInput.setAttribute('name',"newName");
	nameForm.appendChild(nameInput);
	submitName = document.createElement("input");
	submitName.setAttribute('type',"submit");
	submitName.setAttribute('value',"Update Name");
	nameForm.appendChild(submitName);
	email = document.getElementById("email");
	emailForm = document.createElement("form");
	emailForm.setAttribute('method',"post");
	emailForm.setAttribute('action',"updateEmail");
	email.appendChild(emailForm);
	emailInput = document.createElement("input");
	emailInput.setAttribute('type',"text");
	emailInput.setAttribute('name',"newEmail");
	emailForm.appendChild(emailInput);
	submitEmail = document.createElement("input");
	submitEmail.setAttribute('type',"submit");
	submitEmail.setAttribute('value',"Update Email");
	emailForm.appendChild(submitEmail);
//	//add sibling for a submit button that will post from servlet namechange to save name
//	document.getElementById("email"); //addSibling form field 
//	//add sibling for a submit button that will post from servlet emailchange to save email
//	document.getElementById("nameSubmit").addEventListener("click", nameChanged);
//	document.getElementById("emailSubmit").addEventListener("click", emailChanged);
}

function nameChanged(){
	//ty name was changed   "glyphicon glyphicon-ok-circle"
}

function emailChanged(){
	//ty email was changed   "glyphicon glyphicon-ok-circle"
}

function leaveEdit(){
	document.getElementsByTagName("form")[0].remove();
	document.getElementsByTagName("form")[0].remove();
	document.getElementById("edit").innerHTML = "edit";
	document.getElementById("edit").removeEventListener("click", leaveEdit);
	document.getElementById("edit").addEventListener("click", editPage);

}