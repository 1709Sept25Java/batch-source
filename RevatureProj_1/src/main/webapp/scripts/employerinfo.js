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
//onload
getCustomer();

function getSelectedC(field){
	var select=document.getElementById(field).getElementsByTagName("td")[1].innerHTML;
	//document.getElementById("getfield").innerHTML=select;
	document.getElementById("userS").value=select;
}

//hidden field
var select=document.getElementById("getfield").innerHTML;

/*
//get row selected
select.onclick = function(){
	http = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {

	    document.getElementById("select").innerHTML = this.responseText;
	    document.getElementById("subRow").innerHTML = this.responseText;
	    }
	  };
	  xhttp.open("POST", "../GetCustomerServlet?=", true);
	  xhttp.send();
}
//
*/

function addRow() {
    var row = document.createElement('tr');
    row.className = 'cDataTable';
    row.contentEditable = "true"; 
    row.id="select"+getMaxId()+"";
    row.onclick= function(){getSelectedC(this.id)};
    row.type="button";
    row.innerHTML = '<tr><td>'+ getMaxId() +'</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>';

     document.getElementById('getCustomers').appendChild(row);
}
function getMaxId(){
	var id=1;
	nid=document.getElementById("getCustomers").getElementsByTagName("tr");
	for(var i=1;i<nid.length;i++){
		var c=document.getElementById("getCustomers").getElementsByTagName("tr")[i].childNodes[0].innerHTML;	
		if((c==id))
		{
			id++;
		}
	}
	return id;
}


