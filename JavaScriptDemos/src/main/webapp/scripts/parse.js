var bearText = '{"bears":[{"name":"Magnus","age":4,"cave":{id:"3",name:"Manhattan"}},'+
'{"name":"Cedric,"age":100,"cave":{id:"3",name:"Manhattan"}},'+
'{"name":"Gwen","age":2,"cave":{id:"7",name:"Cardiff"}}]}'
var bearObj = JSON.parse(bearText);
window.onload = function(){
	console.log(bearObj);
}
function showBears(){
	document.getElementById("bear1").innerHTML="name: "+bearObject.bears[0].name+
	"; age: "+bearObject.bears[0].age+" cave: "+bearObject.bears[0].cave.name;
	document.getElementById("bear2").innerHTML="name: "+bearObject.bears[1].name+
	"; age: "+bearObject.bears[1].age+" cave: "+bearObject.bears[1].cave.name;
	document.getElementById("bear3").innerHTML="name: "+bearObject.bears[2].name+
	"; age: "+bearObject.bears[2].age+" cave: "+bearObject.bears[2].cave.name;
}