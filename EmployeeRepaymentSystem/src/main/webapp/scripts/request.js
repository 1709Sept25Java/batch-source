
function readReqData(xhr){
	var data = JSON.parse(xhr.responseText);
	var table = document.getElementById("reqData");
	
	var currUrl = window.location.href;
	var start = currUrl.indexOf("rid");
	var rid = currUrl.substring(start,currUrl.length);
	
	table.innerHTML += "<tr><td>Amount</td><td>"+data.amount+"</td></tr><td>Summary</td><td>"+data.summary+
		"</td></tr><tr><td>Receipt</td><td><img id='receipt' src='receipt?"+rid+"'></td></tr><td>Requester</td><td>"+
		data.empName+"</td></tr><tr><td>Sumbitted</td><td>"+data.submitted+"</td></tr><td>Resolver</td><td>"+
		data.mgrName+"</td></tr><tr><td>Resolved</td><td>"+data.resolved+"</td></tr><td>Type</td><td>"+data.type+
		"</td></tr><tr><td>Status</td><td>"+data.status+"</td></tr>";
}

function statusOptions(xhr){
	var status = JSON.parse(xhr.responseText);
	var group = document.getElementById("approval");
	
	var currUrl = window.location.href;
	var start = currUrl.indexOf("rid");
	var rid = currUrl.substring(start,currUrl.length);
	group.setAttribute("action","request?"+rid);
	
	for(var i=1;i<status.length;i++){
		group.innerHTML += "<button type='submit' class='btn btn-primary' name='status' value='"+status[i].id+"'>"+
			status[i].status+"</button>";
	}
}

function sendAJAX(url,func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			func(this);
		}
	}
	
	var currUrl = window.location.href;
	var start = currUrl.indexOf("rid");
	var rid = currUrl.substring(start,currUrl.length);
	
	xhr.open("GET",url+"?"+rid);
	
	xhr.send();
}

window.onload = function(){
	sendAJAX("http://localhost:8082/EmployeeRepaymentSystem/requestdata",readReqData);
	var buttons = document.getElementById("approval");
	if(buttons){
		sendAJAX("http://localhost:8082/EmployeeRepaymentSystem/statuses",statusOptions);
	}
}