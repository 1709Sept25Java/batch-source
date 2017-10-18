/**
 * JS Homework Part 1
 */

var homework = {};
/*
	1. Return the nth fibonacci number
*/
homework.fibonacci = function(n){
	var fib = 0;
	var fib2 = 1;
	if(n===0){
		console.log(fib);
		return fib;
	} else if(n===1){
		console.log(fib2);
		return fib2;
	}
	for(var i=0;i<n-1;i++){
		var tmp = fib2;
		fib2 = fib + fib2;
		fib = tmp;
	}
	console.log(fib2);
	return fib2;
};

/*
	2. Sort the array of integers
	f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
*/
homework.sort = function(array){
	
};

/*
	3. Return the factorial of n
*/
homework.factorial = function(n){
	var fact = 1;
	for(var i=1;i<=n;i++){
		fact = fact * i;
	}
	console.log(fact);
	return fact;
};

/*
	4. Rotate left
	f([1,2,3,4,5],3) = [4,5,1,2,3]
*/
homework.rotateLeft = function(array,n){
	
};

