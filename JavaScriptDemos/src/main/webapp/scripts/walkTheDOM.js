/**
 * 
 */
window.onload = function(){
	document.getElementById("p1").innerHTML = "new text";
	var p2 = document.getElementById("p2").firstChild.nodeValue;
	console.log(p2);
	var alsoP2 = document.getElementById("p2").innerHTML;
	console.log(alsoP2);
	var p3 = document.createElement("p");
	var node = document.createTextNode("this is new");
	p3.appendChild(node);
	var div5 = document.getElementById("div5");
	var p1 = document.getElementById("p1");
	div5.insertBefore(p3,p1);
	var node2 = document.createTextNode("this is also new");
	p3.appendChild(node2);
}