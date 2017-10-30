function getCustomer() {
	
  var xhttp; 
    
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    document.getElementById("getCustomers").innerHTML = this.responseText;
    }
  };
  xhttp.open("POST", "../GetCustomerServlet?=", true);
  xhttp.send();
}

getCustomer(); 
