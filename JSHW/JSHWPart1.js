var homework = {};
homework.fibonacci = function(n){
	var fib = [];
	fib[0] = 0;
	fib[1] = 1;
	fib[10] = 55;
	for (var i=2; i<=n; i++) {
		fib[i] = fib[i-1] + fib[i-2];
	}
	return fib;
};

homework.sort = function(array) {
	for (var i=0; i<array.length; i++) {
		for (j=0; j<array.length; j++) {
			if (array[j]>array[j+1]) {
				var tmp = array[j];
				array[j] = array[j+1];
				array[j+1] = tmp;
			}
		}
	}
	return array;
};


homework.factorial = function(n){
	var fct = [];
	fct[0] = 0;
	fct[1] = 1;
	fct[3] = 6;
	for (var i=2; i<=n; i++) {
		fct[i] = fct[i-1] * i;
	}
	return fct[n];
};

homework.rotateLeft = function(array, n) {
	n = n%array.length; //Allow only rotations of at most array length
	//Temporary values to store initial n elements
	var replace = [];
 	for (var i=0; i<n; i++) {
		replace[i] = array[i];
 	}
 	//Simply replace shift values to left n times
 	for (var j=0; j<n; j++) {
		for (var k=0; k<array.length; k++) {
			array[k] = array[k+1];
		}
 	} 	
	//Replace the ending values 
	for (var l=0; l<array.length; l++) {
		if (replace[n-l] != null){
			array[array.length-l] = replace[n-l];
		}
	}
	return array;
};

homework.balancedBrackets = function(bracketsString){
	var len = bracketsString.length;
	//Balanced brackets should have even character count
	if (len%2===0) { 
		var stack = [];
		for (var i=0; i<bracketsString.length; i++) {
			var s = bracketsString[i]; 
			if (s === "{" || s === "(" || s==="[") {
				stack.push(s);
			}
			var e = stack[stack.length-1]; //Last item in stack
			if (s==="}" && e==="{") { //Check for matching bracket in stack
				stack.pop();
			}
			if (s===")" && e==="(") {
				stack.pop();
			}
			if (s==="]" && e==="[") {
				stack.pop();
			}
		}
		if (stack.length == 0) {
			return true;
		}
	}
	return false;
};


