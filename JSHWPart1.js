var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
	var first = 0;
	var second = 1;
	var num;

	if(n == 0){
		return 0;
	}else if (n == 1){
		return 1;
	}else{
		for(i = 2; i <= n; i++){
			num = first + second;
			first = second;
			second = num;
		}
		return num;
	}


};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
	for(i = 0; i < array.length; i++){
		for(j = 0; j < array.length-1; j++){
			var temp;
			if(array[j] > array[j+1]){
				temp = array[j+1];
				array[j+1] = array[j];
				array[j] = temp;
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

	if(n == 0){
		return 1;
	}else if(n == 1){
		return 1;
	}else{
		for(i = 1; i <= n; i++){
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

	var temp;
	var slice;
	for(i = 0; i < n; i++){
		temp = array[0];
		slice = array.slice(1);
		array = slice.concat(temp);
	}
	return array;

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

	//bracketsString has an odd number of brackets
	//therefore it is not balanced
	if(bracketsString.length%2 == 1){
		return false;
	}else{
		var split = bracketsString.length / 2;
		var str1 = bracketsString.slice(0,split);
		var str2 = bracketsString.slice(split);

		var len = str1.length - 1;

		for(i = 0; i < str1.length; i++){
			c2 = str2.charAt(i);
			c1 = str1.charAt(len);

			switch (c2){
				case '(':
					if(c1 !=')'){
						return false;
					}
					break;

				case ')':
					if(c1 !='('){
						return false;
					}
					break;

				case '[':
					if(!c1 !=']'){
						return false;
					}
					break;

				case ']':
					if(c1 !='['){
						return false;
					}
					break;

				case '{':
					if(c1 !='}'){
						return false;
					}
					break;

				case '}':
					if(c1 !='{'){
						return false;
					}
					break;
			}

			len -=1;
		}

		return true;
	}

};



