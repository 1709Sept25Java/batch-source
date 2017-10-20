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
		//console.log(fib);
		return fib;
	} else if(n===1){
		//console.log(fib2);
		return fib2;
	}
	for(var i=0;i<n-1;i++){
		var tmp = fib2;
		fib2 = fib + fib2;
		fib = tmp;
	}
	//console.log(fib2);
	return fib2;
};

/*
	2. Sort the array of integers
	f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
*/
homework.sort = function(array){
	console.log(array)
	for(var i = 0;i<array.length-1;i++){
		//console.log(i,array[i])
		for(var j=1;j<array.length-i;j++){
			//console.log(j,array[j],j-1,array[j-1]);
			if(array[j]<array[j-1]){
				var tmp = array[j];
				array[j] = array[j-1];
				array[j-1] = tmp;
			}
		}
	}
	//console.log(array);
	return array;
};

/*
	3. Return the factorial of n
*/
homework.factorial = function(n){
	var fact = 1;
	for(var i=1;i<=n;i++){
		fact = fact * i;
	}
	//console.log(fact);
	return fact;
};

/*
	4. Rotate left
	f([1,2,3,4,5],3) = [4,5,1,2,3]
*/
homework.rotateLeft = function(array,n){
	var shift = n%array.length;
	var shiftArr = [];
	
	for(var i=0;i<array.length;i++){
		var j = (i+n)%array.length;
		shiftArr[i] = array[j];
	}
	//console.log(shiftArr);
	return shiftArr;
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
	var check = [];
	
	for(var i=0;i<bracketsString.length;i++){
		var spot = bracketsString.charAt(i);
		if(spot==='('||spot==='{'||spot==='['){
			check.push(spot);
		} else if(spot===')'){
			if(check.pop()!=='('){
				//console.log(false);
				return false;
			}
		} else if(spot==='}'){
			if(check.pop()!=='{'){
				//console.log(false);
				return false;
			}
		} else if(spot===']'){
			if(check.pop()!=='['){
				//console.log(false);
				return false;
			}
		}
	}
	if(check.length>0){
		//console.log(false);
		return false;
	}
	//console.log(true);
	return true;
};
