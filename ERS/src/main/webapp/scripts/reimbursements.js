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
	var table = "<tr><th>Submitted</th><th>Amount</th><th>Description</th><th>Status</th><th>Type</th><th>Resolver</th></tr>";
	for (var i=0; i<reimbursements.length; i++) {
		table += "<tr><td>" + reimbursements[i].rSubmitted +"</td>";
		table += "<td>$" + reimbursements[i].rAmount +"</td>";
		table += "<td>" + reimbursements[i].rDescription +"</td>";
		table += "<td>" + reimbursements[i].rtStatus +"</td>";
		table += "<td>" + reimbursements[i].rtType +"</td>";
		table += "<td>" + reimbursements[i].uIDResolver +"</td></tr>";
	}
	document.getElementById("reimbursementsTable").innerHTML = table;
};

document.getElementById("reimbursementRequest").addEventListener("click", function(){
	sendAjax("reimbursementRequest",reimbursementRequest);
});

function reimbursementRequest(r){
	document.getElementById("reimbursementForm").innerHTML = r.responseText;
};

