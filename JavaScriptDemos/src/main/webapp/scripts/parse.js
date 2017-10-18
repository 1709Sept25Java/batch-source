var bearText = '{"bears":[{"name":"Magnus","age":4,"cave":{id:"3",name:"Manhattan"}},'+
'{"name":"Cedric,"age":100,"cave":{id:"3",name:"Manhattan"}},'+
'{"name":"Gwen","age":2,"cave":{id:"7",name:"Cardiff"}}]}'
var bearObj = JSON.parse(bearText);
window.onload = function(){
	var count = getCount();
	var apples = getCount("apple");
	var pears = getCount("pear");
	console.log(bearObj);
}
function showBears(){
	var bearDiv = document.getElementById("bearDiv");
	var bears = bearObj.bears;
	for(var i=0;i<bears.length;i++){
		console.log(bears[i]);
		var newDiv = document.createElement("div");
		newDiv.setAttribute("class","displayDiv");
		newDiv.innerHTML="name: "+bearObject.bears[i].name+
		"; age: "+bearObject.bears[i].age+" cave: "+bearObject.bears[i].cave.name;
		bearDiv.appendChild(newDiv);
	}
	
	
	/*
	document.getElementById("bear1").innerHTML="name: "+bearObject.bears[0].name+
	"; age: "+bearObject.bears[0].age+" cave: "+bearObject.bears[0].cave.name;
	document.getElementById("bear2").innerHTML="name: "+bearObject.bears[1].name+
	"; age: "+bearObject.bears[1].age+" cave: "+bearObject.bears[1].cave.name;
	document.getElementById("bear3").innerHTML="name: "+bearObject.bears[2].name+
	"; age: "+bearObject.bears[2].age+" cave: "+bearObject.bears[2].cave.name;
	*/
}