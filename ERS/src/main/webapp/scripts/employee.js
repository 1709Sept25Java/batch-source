window.onload = function() {
	console.log("hello from employee page");
	viewBasicInfo();
	viewReimbursements();
};

function viewBasicInfo() {
	var xhttp;
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("basic_info").innerHTML = this.responseText; 
		}
	};
	xhttp.open("GET", "basicinfo");
	xhttp.send();
};

function viewReimbursements(){
	console.log("Calling reimbursements");
	var xhttp;
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("reimbursements").innerHTML = this.responseText; 
		}
	};
	xhttp.open("GET", "reimbursements");
	xhttp.send();
};