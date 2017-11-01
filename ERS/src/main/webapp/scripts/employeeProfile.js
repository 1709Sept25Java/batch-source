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
	var div = "<h3>Pending reimbursements</h3>"
	var resolvedTable = "<h3>Resolved reimbursements</h3><tr><th>Submitted</th><th>Amount</th><th>Description</th><th>Status</th><th>Type</th><th>Resolver</th></tr>";
	for (var i=0; i<reimbursements.length; i++) {
		if (reimbursements[i].rtStatus === 7000) {
			div += "Employee ID: " + reimbursements[i].uIDAuthor +"<br>";
			div += "Submitted: " + reimbursements[i].rSubmitted +"<br>";
			div += "Amount: " + reimbursements[i].rAmount +"<br>";
			div += "Description: " + reimbursements[i].rDescription +"<br>";
			div += "Status: Pending<br>";
			div += "<input id = 'Approved' name=" + reimbursements[i].rID + " type='submit' value='Approve Reimbursement'>";
			div += "<input id = 'Denied' name=" + reimbursements[i].rID + " type='submit' value='Deny Reimbursement'>";
			div += "<hr></div>";
		}
		else if (reimbursements[i].rtStatus === 7007) {
			resolvedTable += "<tr><td>" + reimbursements[i].rSubmitted +"</td>";
			resolvedTable += "<td>$" + reimbursements[i].rAmount +"</td>";
			resolvedTable += "<td>" + reimbursements[i].rDescription +"</td>";
			resolvedTable += "<td>Approved</td>";
			resolvedTable += "<td>" + reimbursements[i].rtType +"</td>";
			resolvedTable += "<td>" + reimbursements[i].uIDResolver +"</td></tr>";
		}
		else {
			resolvedTable += "<tr><td>" + reimbursements[i].rSubmitted +"</td>";
			resolvedTable += "<td>$" + reimbursements[i].rAmount +"</td>";
			resolvedTable += "<td>" + reimbursements[i].rDescription +"</td>";
			resolvedTable += "<td>Denied</td>";
			resolvedTable += "<td>" + reimbursements[i].rtType +"</td>";
			resolvedTable += "<td>" + reimbursements[i].uIDResolver +"</td></tr>";
		}
		
	}
	document.getElementById("pendingReimbursements").innerHTML = div;
	document.getElementById("resolvedTable").innerHTML = resolvedTable;

	
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
