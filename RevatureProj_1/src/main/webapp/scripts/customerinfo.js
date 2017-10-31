function getCustomer() {
	
  var xhttp; 
    
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    document.getElementById("customer_table").innerHTML = this.responseText;
    }
  };
  xhttp.open("POST", "../ShowCustomerServlet?=", true);
  xhttp.send();
}

getCustomer();

