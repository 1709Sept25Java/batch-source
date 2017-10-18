window.onload = function(){
	console.log("window had loaded");
	foo();
	function foo(){
		alert("hello");
	}
}

function hoistFunction(){
	var a = 1;
	alert(a+" "+b+" "+c);
	var b = 2;
	var c = 3;	
}