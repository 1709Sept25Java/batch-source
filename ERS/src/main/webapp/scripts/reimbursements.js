//Found under the employee home, allows employee to see 
//their own reimbursement requests

window.onload = function() {
	//Load reimbursements for employee
	sendAjax("employeePendingReimbursements", employeeReimbursements);
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

function employeeReimbursements(r){
	var reimbursements = JSON.parse(r.responseText);
	var pending = "";
	var resolved = "";
	for (var i=0; i<reimbursements.length; i++) {
		if (reimbursements[i].rtStatus === 7000) {
			pending += "Submitted:<br>\t" + reimbursements[i].rSubmitted +"<br>";
			pending += "Amount: $" + reimbursements[i].rAmount +"<br>";
			pending += "Description:" + reimbursements[i].rDescription +"<br>";
			pending += "Status: Pending<br>";
			pending += "Type: " + reimbursements[i].rtType +"<br><hr>";
		}
		else {
			resolved += "Submitted: " + reimbursements[i].rSubmitted +"<br>";
			resolved += "Amount: $" + reimbursements[i].rAmount +"<br>";
			resolved += "Description: " + reimbursements[i].rDescription +"<br>";
			if (reimbursements[i].rtStatus === 7007) {
				resolved += "Status: Approved<br>";
			}
			else {
				resolved += "Status: Denied<br>";
			}
			resolved += "Type: " + reimbursements[i].rtType +"<br>";
			resolved += "Resolver: " + reimbursements[i].uIDResolver +"<br><hr>";
		}
	}
	var pendingHeader = "<h3>Pending Reimbursement Requests</h3>";
	var resolvedHeader = "<h3>Resolved Reimbursement Requests</h3>";
	if (pending=="") {
		document.getElementById("pendingReimbursements").innerHTML = pendingHeader + "No pending reimbursements requests";
	}
	else {
		document.getElementById("pendingReimbursements").innerHTML = pendingHeader + pending;
	}
	
	if (resolved=="") {
		document.getElementById("resolvedReimbursements").innerHTML = resolvedHeader + "No resolved reimbursements requests";
	}
	else {
		document.getElementById("resolvedReimbursements").innerHTML = resolvedHeader + resolved;
	}
};

document.getElementById("reimbursementRequest").addEventListener("click", function(){
	this.style.display="none";
	sendAjax("reimbursementRequest",reimbursementRequest);
});

function reimbursementRequest(r){
	document.getElementById("reimbursementForm").innerHTML = r.responseText;
};