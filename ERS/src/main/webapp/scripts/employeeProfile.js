window.onload = function() {
	sendAjax("employeeReimbursementsProfile", employeeReimbursements);
}

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
	var pendingHeader = "<h3>Pending Reimbursements</h3>"
	var resolvedHeader = "<h3>Resolved Reimbursements</h3>";
	var pending = "";
	var resolved = "";
	for (var i=0; i<reimbursements.length; i++) {
		if (reimbursements[i].rtStatus === 7000) {
			pending += "<div>Employee ID: " + reimbursements[i].uIDAuthor +"<br>";
			pending += "Submitted: " + reimbursements[i].rSubmitted +"<br>";
			pending += "Amount: " + reimbursements[i].rAmount +"<br>";
			pending += "Description: " + reimbursements[i].rDescription +"<br>";
			pending += "Status: Pending<br>";
			pending += "<br><input id = 'Approved' name=" + reimbursements[i].rID + " type='submit' value='Approve Reimbursement'>";
			pending += "<br><input id = 'Denied' name=" + reimbursements[i].rID + " type='submit' value='Deny Reimbursement'>";
			pending += "</div><hr>";
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
			resolved += "Resolved: " + reimbursements[i].rResolved +"<br>";
			resolved += "Resolver: " + reimbursements[i].uIDResolver +"<br><hr>";

		}
	}
	if (pending=="") {
		document.getElementById("pendingReimbursements").innerHTML = pendingHeader + "No pending reimbursements requests<hr>";
	}
	else {
		document.getElementById("pendingReimbursements").innerHTML = pendingHeader + pending;
	}
	
	if (resolved=="") {
		document.getElementById("resolvedReimbursements").innerHTML = resolvedHeader + "No resolved reimbursements requests<hr>";
	}
	else {
		document.getElementById("resolvedReimbursements").innerHTML = resolvedHeader + resolved;
	}	
};



document.getElementById("pendingReimbursements").addEventListener("click",function(){
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
	sendAjax("employeeReimbursementsProfile", employeeReimbursements);
};
