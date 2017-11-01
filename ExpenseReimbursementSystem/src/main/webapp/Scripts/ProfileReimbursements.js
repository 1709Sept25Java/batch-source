window.addEventListener("load", init);

function sendAjaxGet(url, func) {
	xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

function sendAjaxGetWithArg(url, func, arg) {
	xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this, arg);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

function link(idInput) {
	console.log("we are in link");
	window.location.href = "Reimbursement.html?id=" + idInput;
	console.log("we are in link");
}

function getReimbursements(xhr, employeeId) {
	pendingTable = document.getElementById("pending-table");
	resolvedTable = document.getElementById("resolved-table");
	reimb = JSON.parse(xhr.responseText);
	reimbursementIds = Object.keys(reimb);
	for (i = 0; i < reimbursementIds.length; i++) {
		reId = reimbursementIds[i];
		if (reimb[reId].author == employeeId) {
			if (reimb[reId].status == "pending") {
				row = pendingTable.insertRow();
				console.log(reId);
				row.setAttribute("data-href", "Reimbursement.html?id="+reId);
				idCell = row.insertCell(0);
				idCell.setAttribute("class", "id-cell");
				idCell.innerHTML = reId;
				idCell.setAttribute("href", "Reimbursement.html?id="+reId);
				amountCell = row.insertCell(1);
				amountCell.setAttribute("class", "amount-cell");
				amountCell.innerHTML = "$" + reimb[reId].amount;
				amountCell.setAttribute("href", "Reimbursement.html?id="+reId);
				descriptionCell = row.insertCell(2);
				descriptionCell.setAttribute("class", "description-cell");
				descriptionCell.innerHTML = reimb[reId].description;
				descriptionCell.setAttribute("href", "Reimbursement.html?id="+reId);
				timeCell = row.insertCell(2);
				timeCell.setAttribute("class", "time-cell");
				timeCell.innerHTML = reimb[reId].timeSubmitted;
				timeCell.setAttribute("href", "Reimbursement.html?id="+reId);
			} else {
				row = resolvedTable.insertRow();
				row.setAttribute("data-href", "Reimbursement.html?id="+reId);
				idCell = row.insertCell(0);
				idCell.setAttribute("class", "id-cell");
				idCell.innerHTML = reId;
				console.log(reId);
				amountCell = row.insertCell(1);
				amountCell.setAttribute("class", "amount-cell");
				amountCell.innerHTML = "$" + reimb[reId].amount;
				descriptionCell = row.insertCell(2);
				descriptionCell.setAttribute("class", "description-cell");
				descriptionCell.innerHTML = reimb[reId].description;
				statusCell = row.insertCell(3);
				statusCell.setAttribute("class", "status-cell");
				statusCell.innerHTML = reimb[reId].status;
			}
		}
	}
		
//	window.setTimeout( function () {
//		rows = document.getElementsByTagName("tr");
//		console.log(rows);
//		for (k = 0; k<rows.length; k++){
//			num = rows[k].firstChild.innerHTML;
//			rows[k].onclick = function () { window.location.href = "Reimbursement.html?id="+num; }
//		}
//	}, 2000);
}

function setAlerts(xhr, employeeRes) {
	managerRes = JSON.parse(xhr.responseText);
	managerId = managerRes.managerId;
	ptRows = document.getElementById("pending-table")
			.getElementsByTagName("tr");
	for (i = 0; i < ptRows.length; i++) {
		currentId = ptRows[i].getElementsByClassName("id-cell")[0].innerHTML;
		for (j = 0; j < Object.keys(employeeRes).length; j++) {
			objId = Object.keys(employeeRes)[j];
			if (employeeRes[objId].managerId == managerId) {
				ptRows[i].insertCell().innerHTML = "<span class=\"glyphicon glyphicon-alert\"></span>";
				break;
			}
		}
	}
}

function getCurrent(xhr) {
	employeeRes = JSON.parse(xhr.responseText);
	url = window.location.href
	employeeEmail = url.substring(url.indexOf("=") + 1);
	for (i = 0; i < Object.keys(employeeRes).length; i++) {
		if (employeeRes[Object.keys(employeeRes)[i]].email == employeeEmail) {
			employeeObject = employeeRes[Object.keys(employeeRes)[i]];
		}
	}
	employeeId = employeeObject.employeeId;
	sendAjaxGetWithArg(
			"http://localhost:8082/ExpenseReimbursementSystem/reimbursements",
			getReimbursements, employeeId);
	sendAjaxGetWithArg(
			"http://localhost:8082/ExpenseReimbursementSystem/GetIsManagerServlet",
			setAlerts, employeeRes);
}

function init() {
	document.getElementById("pending").style.display = "block";
	sendAjaxGet("http://localhost:8082/ExpenseReimbursementSystem/employees",
			getCurrent)
}

function changeTab(thisTab, tabName) {
	tabcontent = document.getElementsByClassName("tab-content");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}

	tablinks = document.getElementsByClassName("tab-name");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}

	document.getElementById(tabName).style.display = "block";
	thisTab.className += "active";
}
