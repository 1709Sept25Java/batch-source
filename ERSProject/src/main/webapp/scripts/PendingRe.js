function getPending(xhr){
	
	var pending = JSON.parse(xhr.responseText);
	var table = document.getElementById("pending");
	var i;
	console.log("got data");
	console.log(pending);
	for(i = 0; i < pending.length; i++){
		table.innerHTML +=  "<tr><td>"+pending[i].r_id+
		"</td><td>"+pending[i].amount1+"</td><td>"+pending[i].description+"</td><td>"+pending[i].receipt+"</td><td>"
		+pending[i].submitted+"</td><td>"+pending[i].author+"</td><td>"
		+pending[i].type1+"</td></tr>";
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
	sendAJAX("http://localhost:8082/ERSProject/pending", getPending);
}