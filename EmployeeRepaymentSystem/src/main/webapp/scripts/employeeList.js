
function empList(xhr){
	var employees = JSON.parse(xhr.responseText);
	
	for(var i = 0;i<employees.length;i++){
		var table = document.getElementById("empTable");
		table.innerHTML += "<tr><td>"+employees[i].id+"</td><td>"+employees[i].fName+"</td><td>"+
			employees[i].lName+"</td><td>"+employees[i].email+"</td></tr>";
	}
}

function sendAJAX(url,func){
	xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			func(this);
		}
	}
	
	xhr.open("GET",url);
	
	xhr.send();
};

window.onload = function(){
	sendAJAX("http://localhost:8082/EmployeeRepaymentSystem/employeelist", empList);
}