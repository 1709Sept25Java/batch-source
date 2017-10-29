
function listRequests(xhr){
	var reqs = JSON.parse(xhr.responseText);
	var table = document.getElementById("requests");
	
	for(var i=0;i<reqs.length;i++){
		table.innerHTML+="<tr><td>"+reqs[i].amount+"</td><td>"+reqs[i].type+"</td><td>"+
			reqs[i].status+"</td><td>"+reqs[i].submitted+"</td></tr>";
	}
	
}

function sendAJAX(url,func){
	var xhr = new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.onreadystatechange = function(){
		if(this.readyState ==  4 && this.status == 200){
			func(this);
		}
	};
	
	xhr.open("GET",url);
	
	xhr.send();
}

window.onload = function() {
	
	sendAJAX("http://localhost:8082/EmployeeRepaymentSystem/empresolved",listRequests)
	
}