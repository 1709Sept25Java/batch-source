var nuser1= document.getElementById("nUser").innerHTML;
var npass1= document.getElementById("nPass").innerHTML;

var nuser1Style= document.getElementById("userRequired")
var npass1Style= document.getElementById("passRequired")

function redTextRequired(){
	nuser1Style.style.color="red";
};

function redTextRequired2(){
	npass1Style.style.color="red";
};
//ajax reload
if (nuser1==""){
	redTextRequired();
}
if (npass1==""){
	redTextRequired2();
}