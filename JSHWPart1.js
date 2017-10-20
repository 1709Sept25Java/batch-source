
var homework = {};


 /*1. Return the nth fibonacci number

 f(0) = 0a
 f(1) = 1
 f(10) = 55

*/
     homework.fibonacci = function(n){
		
		var f = new Array(n);
		f[0]= 0;
		f[1]=1;

		for (var i = 2; i <=n; i++ ){
		f[i] = f[i-1]+ f[i-2];
		}
		return f[n-1];
	}; 
	
/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
			 array = [2,4,5,1,3,1];
			 for(var i=0; i<array.length; i++) {
				 for (var j=0; j< array.length -i-1; j++){
					if (array[j] > array [j+1]) {
						var temp = array[j];
						array[j]=array[j+1];
						array[j+1]=temp;
				 }				 
			}
		}		
	};
	/*3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
		if (n===1 || n===0) {
		return 1; 
		} else {
			for( var i = n -1; i>=1; i--) {
				n = n*i;
			} 
		}
		return n;
    };

 /*4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
			  array = [];
		for (var i =1; i <= n; i++) {
			for (var j = 0; j < array.length - 1; j++) {
				var temp = array[j];
				var[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
	};	
 /*5. Balanced Brackets

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

homework.balancedBrackets = function(bracketsString){
 Return true if balanced
 Return false if not balanced
*/
      homework.balancedBrackets = function(bracketsString){{
		  bracketsString= "";
		var strArray = bracketsString.split("");
		var temp = [];
		var openBrackets = ['(', '{', '['];
		var closeBrackets = [ ')', '}', ']'];
		var result = false;	
		for (var i = 0; i < strArray.length; i ++) {
				
				var chrBracket = strArray[i];  
					
					if( openBrackets.indexOf(chrBracket) >= 0){
								temp.push(chrBracket);
		   
		   }  else if (closeBrackets.indexOf(chrBracket) >= 0){
			         mapBrackets = openBrackets[closeBrackets.indexOf(chrBracket)];
					 
					 if ((temp.length !==0) && (temp.pop() === mapBrackets)) {
						    result = true;
							return result;
								 }
							}	else {
									result= false;
									return result;
								break;}
		}
			
			return result;
			console.log("result");
			 
			
			
  };
  
			

