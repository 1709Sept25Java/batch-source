window.onload = function() {
	console.log("window has loaded");
	foo();
	var foo = function() {
		alert("hello");
	};
}

function hoistFunction() {
	var a = 1;
	alert(a+" "+b+" "+c);
	var b = 2;
	var c = 3;
}

function notHoistFunction(){
	var a;
	var b;
	var c;
	
	a=1;
	alert(a+" "+b+" "+c);
	b=2;
	c=3;
}