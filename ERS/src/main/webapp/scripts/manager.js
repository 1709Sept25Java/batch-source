window.onload = function() {
//	sendAjax("viewEmployees", viewEmployees);
	sendAjax("pendingReimbursements", viewPendingReimbursements);
	console.log("change!");
//	sendAjax("resolvedReimbursements", resolvedReimbursements);
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
			div += "Employee ID: " + reimbursements[i].rUIDAuthor +"<br>";
			div += "Submitted: " + reimbursements[i].rSubmitted +"<br>";
			div += "Amount: " + reimbursements[i].rAmount +"<br>";
			div += "Description: " + reimbursements[i].rDescription +"<br>";
			div += "Status:" + reimbursements[i].rtStatus +"<br>";
			div += "<input id = 'Approved' name=" + reimbursements[i].rID + " type='submit' value='Approve Reimbursement'>";
			div += "<input id = 'Denied' name=" + reimbursements[i].rID + " type='submit' value='Deny Reimbursement'>";
			div += "<hr></div>";
		}
		document.getElementById("reviewReimbursements").innerHTML = div;
	}
	else {
		document.getElementById("reviewReimbursements").innerHTML = "No pending reimbursements";
	}
	console.log(div);
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
	console.log("reviewReimbursement?rID="+rID+"&status="+event.target.id);
	false;
});

function reviewReimbursements(r) {
	sendAjax("pendingReimbursements", viewPendingReimbursements);
};

function viewEmployees(e) {
	document.getElementById("viewEmployees").innerHTML = e.responseText;
};

function resolvedReimbursements(r) {
	document.getElementById("resolvedReimbursements").innerHTML = r.responseText;
};

document.getElementById("employeeReimbursements").addEventListener("click",function(){
	console.log("emp clicked");
	var xhr;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	}
	else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			employeeReimbursements(this);
		}
	};
	var eID=encodeURIComponent(3000)
	xhr.open("GET", "employeeReimbursements?eID="+eID, true)
	xhr.send(null);
});
function employeeReimbursements(r) {
	document.getElementById("employeeReimbursements").innerHTML = r.responseText;
};
