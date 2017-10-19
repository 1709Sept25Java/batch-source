var bearText = '{"bears":[{"name":"Magnus","age":4,"cave":{"id":3,"name":"Manhattan"}},'+
'{"name":"Gwen","age":2,"cave":{"id":7,"name":"Cardiff"}},'+
'{"name":"Cedric","age":100,"cave":{"id":3,"name":"Manhattan"}}]}';
var bearObj = JSON.parse(bearText);
window.onload = function(){
	var count = getCount();
	var appleCount = getCount("apple");
	var pearCount = getCount("pear");
	console.log(bearObj);
}
function showBears(){
	var bearDiv = document.getElementById("bearDiv");
	var bears = bearObj.bears; 
	//console.log(bears);
	for (var i = 0; i<bears.length; i++){
		console.log(bears[i]);
		var newDiv = document.createElement("div");
		newDiv.setAttribute("class","displayDiv");
		newDiv.innerHTML="name: "+bears[i].name+
		"; age: "+bears[i].age+"; cave: "+bears[i].cave.name;
		bearDiv.appendChild(newDiv);
	}
	
	/*
	document.getElementById("bear1").innerHTML="name: "+bearObj.bears[0].name+
	"; age: "+bearObj.bears[0].age+"; cave: "+bearObj.bears[0].cave.name;
	document.getElementById("bear2").innerHTML="name: "+bearObj.bears[1].name+
	"; age: "+bearObj.bears[1].age+"; cave: "+bearObj.bears[1].cave.name;
	document.getElementById("bear3").innerHTML="name: "+bearObj.bears[2].name+
	"; age: "+bearObj.bears[2].age+"; cave: "+bearObj.bears[2].cave.name;
	*/
}