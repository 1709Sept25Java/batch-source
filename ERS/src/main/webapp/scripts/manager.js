window.onload = function() {
	console.log("hello from manager page");
	sendAjax("pending_reimbursements", viewPendingReimbursements);
};

function sendAjax(url, cFunction) {
	var xhr;
	if (window.XMLHttpRequest) {
		xhr = new XMLHttpRequest();
	}
	else {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			cFunction(this);
		}
	};
	xhr.open("GET",url,true);
	xhr.send();
};

function viewPendingReimbursements(p){
	document.getElementById("pendingReimbursements").innerHTML = p.responseText; 
};
