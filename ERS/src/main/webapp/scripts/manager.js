//Ajax calls on the manager page
//The main call is to display pending reimbursements from all employees

window.onload = function() {
//	sendAjax("viewEmployees", viewEmployees);
	sendAjax("pendingReimbursements", viewPendingReimbursements);
	sendAjax("resolvedReimbursements", resolvedReimbursements);
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


function viewPendingReimbursements(r){
	var reimbursements = JSON.parse(r.responseText);
	if (reimbursements.length != 0) {
		var div = "<div>";
		for (var i=0; i<reimbursements.length; i++) {
			div += "Employee ID: " + reimbursements[i].uIDAuthor +"<br>";
			div += "Submitted: " + reimbursements[i].rSubmitted +"<br>";
			div += "Amount: " + reimbursements[i].rAmount +"<br>";
			div += "Description: " + reimbursements[i].rDescription +"<br>";
			div += "Status: Pending<br>";
			div += "<input id = 'Approved' name=" + reimbursements[i].rID + " type='submit' value='Approve Reimbursement'>";
			div += "<input id = 'Denied' name=" + reimbursements[i].rID + " type='submit' value='Deny Reimbursement'>";
			div += "<hr></div>";
		}
		document.getElementById("reviewReimbursements").innerHTML = div;
	}
	else {
		document.getElementById("reviewReimbursements").innerHTML = "No pending reimbursements";
	}
};



document.getElementById("reviewReimbursements").addEventListener("click",function(){
	var xhr;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	}
	else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			reviewReimbursements(this);
		}
	};
	
	var rID=encodeURIComponent(event.target.name);
	var status=encodeURIComponent(event.target.id);
	xhr.open("GET", "reviewReimbursement?rID="+rID+"&status="+event.target.id, true)
	xhr.send(null);
	false;
});

function reviewReimbursements(r) {
	sendAjax("pendingReimbursements", viewPendingReimbursements);
};

function viewEmployees(e) {
	document.getElementById("viewEmployees").innerHTML = e.responseText;
};

function resolvedReimbursements(r) {
	var reimbursements = JSON.parse(r.responseText);
	if (reimbursements.length != 0) {
		var div = "<div>";
		for (var i=0; i<reimbursements.length; i++) {
			div += "Employee ID: " + reimbursements[i].uIDAuthor +"<br>";
			div += "Submitted: " + reimbursements[i].rSubmitted +"<br>";
			div += "Amount: " + reimbursements[i].rAmount +"<br>";
			div += "Description: " + reimbursements[i].rDescription +"<br>";
			if (reimbursements[i].rtStatus==7014) {
				div += "Status: Denied<br>";
			}
			else {
				div += "Status: Approved<br>";
			}
			div += "Resolver:"+reimbursements[i].uIDResolver+"<br>";
			div += "<hr></div>";
		}
		document.getElementById("resolvedReimbursements").innerHTML = div;
	}
	else {
		document.getElementById("resolvedReimbursements").innerHTML = "No resolved reimbursements";
	}
};

