function fibonacci(n) {
	var fib = [];
	fib[0] = 0;
	fib[1] = 1;
	fib[10] = 55;
	for (var i=2; i<=n; i++) {
		fib[i] = fib[i-1] + fib[i-2];
		console.log("Fib: " + fib[i]);
	}
	console.log("End fib: " + fib[n]);
}


function sortArray() {
	console.log("something");

	var n = [2,4,5,1,3,1];
	for (var i=0; i<n.length; i++) {
		for (j=0; j<n.length; j++) {
			if (n[j]>n[j+1]) {
				var tmp = n[j];
				n[j] = n[j+1];
				n[j+1] = tmp;
			}
		}
	}
	for (var k=0; k<n.length; k++) {
		console.log(k + " " + n[k]);
	}
}

function factorial(n) {
	var fct = [];
	fct[0] = 0;
	fct[1] = 1;
	fct[3] = 6;
	for (var i=2; i<=n; i++) {
		fct[i] = fct[i-1] * i;
	}
	
	console.log("End factorial: " + fct[n]);
}


function rotate(n) {
	//When n = 1 
	//           0 1 2 3 4
	//			 1 2 3 4 5
	//n = 1 
 	var array = [1,2,3,4,5];
	for (var i=0; i<n; i++ ) {
		var tmp = array[i];
		for (var j=i; j<array.length; j++) {
			console.log(array[j] + " " + array[j+1]);
			array[j] = array[j+1];
		}
		array[array.length] = tmp;
	}
	for (var i=n; i<array.length; i++ ) {
		console.log(array[i]);
	}
}

//https://stackoverflow.com/questions/14860498/reverse-array-index-of-ints
//function check(bracketsString){
//	var stck = [];
//	console.log(bracketsString.length);
//	var size = bracketsString.length;
//	if (size%2 === 0) {
//		console.log('Valid input, length: ' + size);
//		size = (size/2)-1;
//		console.log('Valid input, length: ' + size);
//		
//		for (var i = bracketsString.length-1; i>= 0; i--) {}
//			console.log(bracketsString[i]);
//		}
//
//	}
//	else {
//		console.log("false");
//	}
//};
//

