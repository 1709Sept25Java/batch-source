
function listRequests(xhr){
	var reqs = JSON.parse(xhr.responseText);
	var table = document.getElementById("requests");
	
	if(reqs.length>0){
		document.getElementById("empName").innerHtml+=reqs[0].empName;
		console.log(reqs[0].empName);
	}
	
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
	
	var currUrl = window.location.href;
	var start = currUrl.indexOf("eid");
	var eid = currUrl.substring(start,currUrl.length);
	//console.log(eid);
	
	xhr.open("POST",url+"?"+eid);
	
	xhr.send(eid);
}

window.onload = function() {
	
	sendAJAX("http://localhost:8082/EmployeeRepaymentSystem/emppending",listRequests)
	
}
