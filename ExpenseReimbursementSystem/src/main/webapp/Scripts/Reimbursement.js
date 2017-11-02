function sendAjaxGet(url, func) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

function sendAjaxGetWithArg(url, func, arg) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this, arg);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

sendAjaxGet("http://localhost:8082/ExpenseReimbursementSystem/reimbursements",
		getReimbursement);

function getReimbursement(xhr) {
	url = window.location.href
	index = url.lastIndexOf("=");
	id = url.substring(index + 1);
	reimb = JSON.parse(xhr.responseText);
	document.getElementById("id").innerHTML = "Reimbursement #"+id;
	document.getElementById("amount").innerHTML = "$"+reimb[id].amount;
	document.getElementById("author").innerHTML = reimb[id].author;

	sendAjaxGet("http://localhost:8082/ExpenseReimbursementSystem/employees",
			createResolveForm);
	setTimeout( function() { sendAjaxGet("http://localhost:8082/ExpenseReimbursementSystem/employees",
			mapAuthorName); }, 500);

	document.getElementById("description").innerHTML = reimb[id].description;
	document.getElementById("timeSubmitted").innerHTML = reimb[id].timeSubmitted;
	document.getElementById("status").innerHTML = reimb[id].status;
	if (reimb[id].status != "pending") {
		document.getElementById("timeResolved").innerHTML = reimb[id].timeResolved;
		document.getElementById("resolver").innerHTML = reimb[id].resolver;
	} else {
		document.getElementById("resolvedContent").remove();
	}
}

function createResolveForm(xhr) {
	employeeJSON = JSON.parse(xhr.responseText);
	thisManagerId = employeeJSON[reimb[id].author].managerId;
	sendAjaxGetWithArg(
			"http://localhost:8082/ExpenseReimbursementSystem/isManager",
			isManager, thisManagerId);
}

function isManager(xhr, thisManagerId) {
	idJSON = JSON.parse(xhr.responseText);
	sessionId = idJSON.managerId;
	appendedId = (window.location.href).substring((window.location.href).indexOf("=")+1);
	console.log(document.getElementById("status").innerHTML);
	if (sessionId == thisManagerId && document.getElementById("status").innerHTML == "pending") {
		form = document.getElementById("resolveForm");
		form.innerHTML = "<br><select class=\"width-auto\" id = \"resolveSelect\" name = \"resolveStatus\">"+
			"<option>Approved</option>"+
			"<option>Denied</option>" +
			"<input id=\"reimbursementId\" type=\"hidden\" name=\"reimbursementId\" value ="+appendedId+">"+ 
			"<input type=\"submit\" value=\"Resolve Request\"></select>";
		//create link to all reimbursements
	} else {
		//create back link to profile
	}
}

function mapAuthorName(xhr) {
	employeeJSON = JSON.parse(xhr.responseText);
	for (var i = 0; i<Object.keys(employeeJSON).length; i++){
		j = Object.keys(employeeJSON)[i];
		id = document.getElementById("author").innerHTML;
		if(j == id){
			document.getElementById("author").innerHTML = employeeJSON[j].name;
		}
		resolverId = document.getElementById("resolver").innerHTML;
		if(j == resolverId){
			document.getElementById("resolver").innerHTML = employeeJSON[j].name;
		}
	}
}


