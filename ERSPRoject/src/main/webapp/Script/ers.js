function sendAjaxGet(url) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("viewStatus").innerHTML= this.responseText;
		}
	};
	xhr.open("GET", url, true);
	xhr.send();
};

document.getElementById("btn1").onclick = function() {
	sendAjaxGet("http://localhost:8082/ERSPRoject/SubmittedRequest");
}

/*function sendAjaxmail(url2, fun) {
	var xhr = new XMLHttpRequest()
			|| new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			document.getElementById("viewStatus").innerHTML= this.responseText;
		}
	};
	xhr.open("Post", url, true);
	xhr.send("message");
};

function sendEmail(){
	var name = document.getElementByName("username");
	var email= document.getElementByName("email");
	var messg = 'Thank you for submitting your request.'
		
		var data = JASON.parse('{"name" : name, "email":email, "message": mesg}');
}
*/
document.getElementById("reimb").addEventListener('click', function(){
	alert("Your request was submitted");}, false);