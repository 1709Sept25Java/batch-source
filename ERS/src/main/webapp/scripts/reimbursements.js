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
	var pendingTable = "<h3>Pending reimbursements</h3><tr><th>Submitted</th><th>Amount</th><th>Description</th><th>Status</th><th>Type</th></tr>";
	var resolvedTable = "<h3>Resolved reimbursements</h3><tr><th>Submitted</th><th>Amount</th><th>Description</th><th>Status</th><th>Type</th><th>Resolver</th></tr>";

	for (var i=0; i<reimbursements.length; i++) {
		
		if (reimbursements[i].rtStatus === 7000) {
			pendingTable += "<tr><td>" + reimbursements[i].rSubmitted +"</td>";
			pendingTable += "<td>$" + reimbursements[i].rAmount +"</td>";
			pendingTable += "<td>" + reimbursements[i].rDescription +"</td>";
			pendingTable += "<td>Pending</td>";
			pendingTable += "<td>" + reimbursements[i].rtType +"</td>";
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
	document.getElementById("pendingTable").innerHTML = pendingTable;
	document.getElementById("resolvedTable").innerHTML = resolvedTable;

	
};

document.getElementById("reimbursementRequest").addEventListener("click", function(){
	sendAjax("reimbursementRequest",reimbursementRequest);
});

function reimbursementRequest(r){
	document.getElementById("reimbursementForm").innerHTML = r.responseText;
};

