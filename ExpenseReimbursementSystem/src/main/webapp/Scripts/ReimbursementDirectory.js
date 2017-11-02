window.addEventListener("load", init);


function sendAjaxGet(url, func) {
	xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

function sendAjaxGetWithArg (url, func, arg) {
	xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			func(this, arg);
		}
	}
	xhr.open("GET", url, true);
	xhr.send();
}

function getReimbursements(xhr) {
	pendingTable = document.getElementById("pending-table");
	resolvedTable = document.getElementById("resolved-table");
	reimb = JSON.parse(xhr.responseText);
	reimbursementIds = Object.keys(reimb);
	for (i = 0; i < reimbursementIds.length; i++) {
		reId = reimbursementIds[i];
		if (reimb[reId].status == "pending"){
			row = pendingTable.insertRow();
			row.addEventListener("click", function link() {
			window.location.href = "Reimbursement.html?id="+reId }); 
			idCell = row.insertCell(0);
			idCell.setAttribute("class", "id-cell");
			idCell.innerHTML = reId;
			authorCell = row.insertCell(1);
			authorCell.setAttribute("class", "authorid-cell");
			authorCell.innerHTML = reimb[reId].author;
			amountCell = row.insertCell(2);
			amountCell.setAttribute("class", "amount-cell");
			amountCell.innerHTML = "$"+reimb[reId].amount;
			descriptionCell = row.insertCell(3);
			descriptionCell.setAttribute("class", "description-cell");
			descriptionCell.innerHTML = reimb[reId].description;
			timeCell = row.insertCell(4);
			timeCell.setAttribute("class", "time-cell");
			timeCell.innerHTML = reimb[reId].timeSubmitted;
		} else {
			row = resolvedTable.insertRow();
			idCell = row.insertCell(0);
			idCell.setAttribute("class", "id-cell");
			idCell.innerHTML = reId;
			authorCell = row.insertCell(1);
			authorCell.setAttribute("class", "authorid-cell");
			authorCell.innerHTML = reimb[reId].author;
			amountCell = row.insertCell(2);
			amountCell.setAttribute("class", "amount-cell");
			amountCell.innerHTML = "$"+reimb[reId].amount;
			descriptionCell = row.insertCell(3);
			descriptionCell.setAttribute("class", "description-cell");
			descriptionCell.innerHTML = reimb[reId].description;
			statusCell = row.insertCell(4);
			statusCell.setAttribute("class", "status-cell");
			statusCell.innerHTML = reimb[reId].status;
		}
	}
	sendAjaxGet("http://localhost:8082/ExpenseReimbursementSystem/employees", getEmployeeName);
	window.setTimeout( function () {
		rows = document.getElementsByTagName("tr");
		rowArr = Array.from(rows);
		idCells = document.getElementsByClassName("id-cell");
		idCellArr = Array.from(idCells);
		for (k = 0; k<rowArr.length; k++){
			rowArr[k].onclick = function () { 
			idNum = event.target.parentElement.firstChild.innerHTML;
			window.location.href = "Reimbursement.html?id="+idNum;
			}
		}
	}, 0);
	
}

function getEmployeeName(xhr) {
	employeeRes = JSON.parse(xhr.responseText);
	sendAjaxGetWithArg("http://localhost:8082/ExpenseReimbursementSystem/GetIsManagerServlet", setAlerts, employeeRes);
	setTimeout(function () {
	authorElements = document.getElementsByClassName("authorid-cell");
	console.log(authorElements[0]);
	console.log(authorElements[1]);
	arr = Array.from(authorElements);
	console.log(authorElements);
	for(j = 0; j<arr.length; j++){
		arr[j].innerHTML = employeeRes[arr[j].innerHTML].name;
		console.log(arr[j].innerHTML);
	}
	},500);
}

function setAlerts(xhr, employeeRes){
	managerRes = JSON.parse(xhr.responseText);
	managerId = managerRes.managerId;
	ptRows = document.getElementById("pending-table").getElementsByTagName("tr");
	for(i = 0; i<ptRows.length; i++){
		currentId = ptRows[i].getElementsByClassName("id-cell")[0].innerHTML;
		for(j=0; j<Object.keys(employeeRes).length; j++){
			objId = Object.keys(employeeRes)[j];
			if(employeeRes[objId].managerId == managerId){
				ptRows[i].insertCell().innerHTML ="<span class=\"glyphicon glyphicon-alert\"></span>";
				break;
			} 
		}
	}	
}

	
function init() {
	document.getElementById("pending").style.display = "block";
	sendAjaxGet(
			"http://localhost:8082/ExpenseReimbursementSystem/reimbursements",
			getReimbursements);
	
}
	
function changeTab(thisTab, tabName){
    tabcontent = document.getElementsByClassName("tab-content");
    for ( i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    tablinks = document.getElementsByClassName("tab-name");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    document.getElementById(tabName).style.display = "block";
    thisTab.className += "active";
}
