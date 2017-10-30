
function pendingTable(xhr){
	var pending = JSON.parse(xhr.responseText);
	var table = document.getElementById("requests");
	
	for(var i=0;i<pending.length;i++){
		table.innerHTML += "<tr href='request?rid="+pending[i].id+"'><td>"+pending[i].amount+
			"</td><td>"+pending[i].emp+"</td><td>"+pending[i].type+"</td><td>"+pending[i].status+
			"</td><td>"+pending[i].submitted+"</td><tr>";
	}
}

function sendAJAX(url,func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HttpRequest");
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	
	xhr.open("GET",url);
	
	xhr.send();
}

window.onload = function(){
	sendAJAX("http://localhost:8082/EmployeeRepaymentSystem/resolvedlist",pendingTable);
}
