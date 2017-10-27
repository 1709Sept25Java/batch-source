
function typeOptions(xhr){
	var types = JSON.parse(xhr.responseText);
	console.log(types);
	var select = document.getElementById("type");
	
	for(var i=0;i<types.length;i++){
		select.innerHTML += "<option value='"+types[i].id+"'>"+types[i].type+"</option>";
	}
}

function sendAJAX(url,func){
	console.log("in ajax");
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPResponse");
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			console.log("called");
			func(this);
		}
	};
	
	xhr.open("GET",url);
	
	xhr.send();
}

window.onload = function(){
	sendAJAX("http://localhost:8082/EmployeeRepaymentSystem/types",typeOptions);
}