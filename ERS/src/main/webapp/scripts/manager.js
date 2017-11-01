//Ajax calls on the manager page
//The main call is to display pending reimbursements from all employees

window.onload = function() {
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
	var pendingHeader = "<h3>Pending Reimbursements</h3>";
	if (reimbursements.length != 0) {
		var pending = "";
		for (var i=0; i<reimbursements.length; i++) {
			pending += "<div>Employee ID: " + reimbursements[i].uIDAuthor +"<br>";
			pending += "Submitted: " + reimbursements[i].rSubmitted +"<br>";
			pending += "Amount: " + reimbursements[i].rAmount +"<br>";
			pending += "Description: " + reimbursements[i].rDescription +"<br>";
			pending += "Status: Pending<br>";
			pending += "<input id = 'Approved' name=" + reimbursements[i].rID + " type='submit' value='Approve Reimbursement'>";
			pending += "<br><br><input id = 'Denied' name=" + reimbursements[i].rID + " type='submit' value='Deny Reimbursement'>";
			pending += "<hr></div>";
		}
		document.getElementById("reviewReimbursements").innerHTML = pendingHeader + pending;
	}
	else {
		document.getElementById("reviewReimbursements").innerHTML = pendingHeader + "No pending reimbursements";
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
	var resolvedHeader = "<h3>Resolved Reimbursements</h3>"
	if (reimbursements.length != 0) {
		var resolved = "";
		for (var i=0; i<reimbursements.length; i++) {
			resolved += "<div>Employee ID: " + reimbursements[i].uIDAuthor +"<br>";
			resolved += "Submitted: " + reimbursements[i].rSubmitted +"<br>";
			resolved += "Amount: " + reimbursements[i].rAmount +"<br>";
			resolved += "Description: " + reimbursements[i].rDescription +"<br>";
			if (reimbursements[i].rtStatus==7014) {
				resolved += "Status: Denied<br>";
			}
			else {
				resolved += "Status: Approved<br>";
			}
			resolved += "Resolver:"+reimbursements[i].uIDResolver+"<br>";
			resolved += "<hr></div>";
		}
		document.getElementById("resolvedReimbursements").innerHTML = resolvedHeader + resolved;
	}
	else {
		document.getElementById("resolvedReimbursements").innerHTML = resolvedHeader + "No resolved reimbursements";
	}
};

