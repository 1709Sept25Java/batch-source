function getEmployees(xhr){
	
	var emp = JSON.parse(xhr.responseText);
	var table = document.getElementById("allEmp");
	var i;
	console.log("got data");
	for(i = 0; i < emp.length; i++){
		table.innerHTML +=  "<tr><td>"+emp[i].u_id+
		"</td><td>"+emp[i].username+"</td><td>"+emp[i].firstname+"</td><td>"+emp[i].lastname+"</td><td>"+
		emp[i].email+"</td></tr>";
	}
}

function sendAJAX(url, func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HttpRequest");
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	
	xhr.open("GET", url);
	xhr.send();
}
	
window.onload = function(){
	sendAJAX("http://localhost:8082/ERSProject/emp", getEmployees);
}