function getResolved(xhr){
	
	var resolved = JSON.parse(xhr.responseText);
	var table = document.getElementById("resolved");
	var i;
	console.log("got data");
	console.log(resolved);
	for(i = 0; i < resolved.length; i++){
		table.innerHTML +=  "<tr><td>"+resolved[i].r_id+
		"</td><td>"+resolved[i].amount1+"</td><td>"+resolved[i].description+"</td><td>"+resolved[i].receipt+"</td><td>"
		+resolved[i].submitted+"</td><td>"+resolved[i].resolved+"</td><td>"+resolved[i].resolver+"</td><td>"
		+resolved[i].type1+"</td><td>"+resolved[i].status1+"</td></tr>";
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
	sendAJAX("http://localhost:8082/ERSProject/empResolved", getResolved);
}