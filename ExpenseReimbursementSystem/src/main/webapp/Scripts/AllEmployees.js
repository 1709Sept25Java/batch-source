function sendAjaxGet(url,func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if (this.readyState  == 4 && this.status == 200 ){
			func(this);
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

function getEmployees(xhr){ 
	var res = xhr.responseText;
	res = JSON.parse(xhr.responseText);
	table = document.getElementById("employeeTable");
	for (var i = 0; i<Object.keys(res).length; i++){
		j = Object.keys(res)[i];
		row = table.insertRow();
		nameCell = row.insertCell(0);
		nameCell.setAttribute("class","name-cell");
		emailCell= row.insertCell(1);
		emailCell.setAttribute("class","email-cell");
		managerCell = row.insertCell(2);
		managerCell.setAttribute("class","manager-cell");
		var link = document.createElement("a");
		link.setAttribute("href","../Views/Profile.html?email="+res[j].email);
		link.innerHTML =  res[j].name;
		nameCell.appendChild(link);
		emailCell.innerHTML = res[j].email;
		if (res[j].managerId != 0) {
			managerCell.innerHTML = res[res[j].managerId].name;	
		} else {
			managerCell.innerHTML = "Upper Management";
		}
	}
}
//	for all keys in JSON text put res.first, res.last, res.email, res.lineManager(first/last) in a table 	
//	find keys for where res.id = this employee's res.lineManager
//	get key.first and key.last
//	EXTRA: make person and manager clickable, to redirect to employee page that can is populated by that employee's info




window.onload = sendAjaxGet('http://localhost:8082/ExpenseReimbursementSystem/employees', getEmployees);