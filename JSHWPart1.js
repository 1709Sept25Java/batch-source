/*
Part 1:

Fill in the functions with your solutions and submit them in a file called JSHWPart1.js by 5pm Friday, October 20.
*/

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
  if (typeof n !== 'number'){
    return "Function input is not a number"
  }
  if ( n === 0 ){
    return 1;
  }
  if (n === 1 ){
    return 1;
  }
  return homework.fibonacci(n-2)+homework.fibonacci(n-1);
};


// function test(){
// console.log(homework.fibonacci(0));
// console.log(homework.fibonacci(1));
// console.log(homework.fibonacci(2));
// console.log(homework.fibonacci(3));
// console.log(homework.fibonacci(4));
// console.log(homework.fibonacci(5));
// console.log(homework.fibonacci("d"));
// };


/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
  if (Array.isArray(array)===false){
      return "Function input is not an array"
  }
  if (array.length === 1 ){
    return array;
  }
  for(j = 0; j<array.length-1; j++){
      if (typeof array[j] !== 'number'){
        return "Not all array arguments are numbers";
      }
      for(i = 0; i<array.length-1; i++){
          if(array[i]>array[i+1]){
              var placeholder = array[i];
              array[i] = array[i+1];
              array[i+1] = placeholder;
          }
      }
  }
  return array;
};

// function test(){
// console.log(homework.sort([3,2,5,8,2,5,1]));
// console.log(homework.sort([74,0,1,74,23,8,1]));
// console.log(homework.sort([1,2,0,0,0,1,7]));
// console.log(homework.sort([9,8,7,6,5,4,3,2,1,0]));
// console.log(homework.sort([9]));
// console.log(homework.sort('string'));
// console.log(homework.sort([1,2,0,0,'string',1,7]));
// };

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
  if (typeof n !== 'number'){
    return "Function input is not a number"
  }
    if ( n === 0 ){
      return 1;
    }
    if (n === 1 ){
      return 1;
    }
    return n*homework.factorial(n-1);
};

// function test(){
// console.log(homework.factorial('s'));
// console.log(homework.factorial(0));
// console.log(homework.factorial(1));
// console.log(homework.factorial(2));
// console.log(homework.factorial(3));
// console.log(homework.factorial(4));
// console.log(homework.factorial(5));
// };

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    if (typeof n !== 'number'){
        return "Number of rotations argument is not a number"
    }
    if (Array.isArray(array)===false){
        return "Array to rotate argument is not an array"
    }
    if (array.length === 1){
      return array;
    }
    for (i = 0; i < n; i++){
        var tailElement = array[0];
        for(j = 0; j < array.length-1; j++){
            array[j] = array[j+1];
        }
        array[array.length-1] = tailElement;
    }
    return array;
};

// function test(){
// console.log(homework.rotateLeft([1,2,3,4,5], 1));
// console.log(homework.rotateLeft([1,2,3,4,5], 6));
// console.log(homework.rotateLeft([1,2,3,4,5], 3));
// console.log(homework.rotateLeft([1,2,3,4,5], 3));
// console.log(homework.rotateLeft([1,2,3,4,5], 'x'));
// console.log(homework.rotateLeft('x', 3));
// console.log(homework.rotateLeft([4], 3));
// }

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 "("
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
homework.balancedBrackets = function(bracketsString){
  if ((bracketsString.length)%2 != 0){
    return false;
  }
  else{
    for(i = 0; i < bracketsString.length/2; i++){
          var bracketArray = ['{','}','[',']','(',')'];
          if (!(bracketArray.includes(bracketsString.charAt(i))) | !bracketArray.includes(bracketsString.charAt(bracketsString.length-1-i))){
            return false;
          }
          if (bracketsString.charAt(i) !== flip(bracketsString.charAt(bracketsString.length-1-i))){
            return false;
          }
    }
    return true;
  }
};

function flip(a){
  if(a == '('){
    a = ')';
  }
  else if(a == ')'){
    a = '(';
  }
  else if(a == '{'){
    a = '}';
  }
  else if(a == '}'){
    a = '{';
  }
  else if(a == ']'){
    a = '[';
  }
  else if(a == '['){
    a = ']';
  }
  return a;
}

// function test(){
//   console.log(homework.balancedBrackets("({[]})"));
//   console.log(homework.balancedBrackets("()"));
//   console.log(homework.balancedBrackets("()()"));
//   console.log(homework.balancedBrackets("(())"));
//   console.log(homework.balancedBrackets("("));
//   console.log(homework.balancedBrackets(")"));
//   console.log(homework.balancedBrackets("(()"));
//   console.log(homework.balancedBrackets("([)]"));
// }

/*
YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)
*/
