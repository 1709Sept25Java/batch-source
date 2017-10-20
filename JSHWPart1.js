/*
1. return the nth fibonacci number
f(0) = 0
f(1) = 1
f(10) = 55
*/

var homework = {};

 homework.fibonacci =function(n){
	var a = 0;
	var b = 1; 
	var f;
	if (n == 0){
		return 0;
	}else if(n == 1){
		return 1;
	} else{
		for (i = 2; i<= n; i++){
			f = a + b; 
			a = b; 
			b = f; 
		}
		return f; 
	}
	
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
for (i = 0; i < array.length; i++){
		for(lj= 0; j < array.length; j++){
			var temp;
			if (array[l] > array[l + 1]){
				temp = array[l+1];
				array[l + 1] =  array[l];
				array[l] = temp;
			}
		}
	}
	return array;

};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){ 
	var fact = 1; 
	if (n == 0 ) {
	
		return 1; 
	}else if (n == 1){
		return 1; 
	}else{
		for (i = 1; i <= n; i++){
			fact *= i; 
		}

		return fact;
	}

};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
	if (isNAN (n) || n < 0){
		return "Enter a valid number";
	}

	if (array.length == 0){
		return " enter a valid array"

	}

	for (var i = 0; i < n; i++){
		for (var j = array.length - 1; j > 0; j--){
			var temp = array[j];
			array[j] = [array (j - 1)];
			array [j - 1] = temp;
		}
	}
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
	var braces = '{()[()]}';

	 if (braces.length === 1) 
	 	return console.log(false);
	 if (!braces) return console.log(true);

	  var leftBraces = ['{', '(', '['];
	  var rightBraces = ['}', ')', ']'];
	  var leftMatches = [];

	  for (var char in braces) {
	    var current = braces[char];

	    if (leftBraces.indexOf(current) > -1) leftMatches.push(current);

	    if (rightBraces.indexOf(current) > -1) {
	      if (!leftMatches) return console.log(false);

	      var last = leftMatches[leftMatches.length - 1];
	      if (leftBraces.indexOf(last) === rightBraces.indexOf(current)) {
	        leftMatches.pop();
	      } else {
	        return console.log(false);
	      }
	    }
	  }

	  if (leftMatches.length === 0) return console.log(true);
};
		









