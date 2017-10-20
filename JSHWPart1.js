/*JSHWPart1.js by 5pm Friday, October 20*/ 

var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0a
 f(1) = 1
 f(10) = 55
*/

function fibonacci(n){
  var x = 1, y = 0, temp;

  while (n >= 0){
    temp = x;
    x = x + y;
    y = temp;
    n--;
  }
  return y;
}

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
 
 lol
 sort(array)
 {
	 array.sort();
 }
*/

array=[15,3,7,2,21]; 
function arraySort(a) {
    var temp;
    do {
        temp = false;
        for (var i=0; i < a.length-1; i++) {
            if (a[i] > a[i+1]) {
                var temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                temp = true;
            }
        }
    } while (temp);
return a;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
function factorial(n) {
  if (n == 0 || n == 0) 
      return 1;
  else {
      return (n * factorial(n-1));
  }
};
//factorial(3);

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/

leftarray=[15,3,7,2,21]; //3,7,2,21,15  //7,2,21,15,3
function rotateLeft(array,n) {
//duplicate first and move to back, remove first
	if(n==0){return a;}
    
      var arraytemp=[];
		for(var i=1;i<a.length;i++){
             arraytemp=a[n-1];
             a=a.concat(arraytemp) 
             return a.slice(n,a.length);  
         }
};


/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()		//+1-1
    ()()	//+1-1+1-1
    (())	//+1+1-1-1
    ({[]})	//+1+3+4  -4-3-1   is reversed
	

 The following are NOT balanced brackets:
 (			+1
 )			+1	
 (()		+1+1-1
 ([)]		+1+2  -1-2    //is not reversed

//need to check symmetry
 
 Return true if balanced
 Return false if not balanced
*/

//please create an array to check for balanced brackets example below
var r=["(",")","(",")"];

function balancedBrackets(a) {
var x=0; var y=0; var t=[];
   
   
   //check to see if types are uneven
   for(var i=0;i<a.length;i++){
     //()
     if(a[i]=="(")
     {x=x+1;}
     else if(a[i]==")")
     {x=x-1;}
     //[]
     if(a[i]=="[")
     {x=x+2;}
     else if(a[i]=="]")
     {x=x-2;}
     //{}
     if(a[i]=="(")
     {x=x+3;}
     else if(a[i]==")")
     {x=x-3;}
   }
   //if even, then x=0, else return a={"("}
   if(x==0)
   {
   	//even types
   }
   else{
   a=["("]}
   //get reversed array and convert to same type
   
   for(var i=0;i<a.length;i++){
   //()
       if(a[i]=="(")
       {
       t[i]=")";
       }
       else if(a[i]==")")
       {
       t[i]="(";
       }
   //[]    
       else if(a[i]=="[")
       {
       t[i]=")";
       }
       else if(a[i]=="]")
       {
       t[i]="(";
       }
   //{}
   	   else if(a[i]=="{")
       {
       t[i]=")";
       }
       else if(a[i]=="}")
       {
       t[i]="(";
       }
	}
    
    //change type for a
    for(var i=0;i<a.length;i++){
   //()
       if(a[i]=="(")
       {
       a[i]="(";
       }
       else if(a[i]==")")
       {
       a[i]=")";
       }
   //[]    
       else if(a[i]=="[")
       {
       a[i]="(";
       }
       else if(a[i]=="]")
       {
       a[i]=")";
       }
   //{}
   	   else if(a[i]=="{")
       {
       a[i]="(";
       }
       else if(a[i]=="}")
       {
       a[i]=")";
       }
	}
    
  //check is symmetrical
  
  
  var half=a.length/2;
  //first half of array
  var arr1=a.slice(0,half);
  //second half of array
  var arr2=a.slice(half,half*2);
  //first half of array reversed
  var arr3=t.slice(0,half);
  //second half of array reversed
  var arr4=t.slice(0,half)
  if(arr1.toString()==arr2.toString())
  {y= true;}
  else if (arr2.toString()==arr3.toString())
  {y= true;}
  else y=false;

  return y;
  //return y +"<br></br>" + arr1 +"<br></br>" + arr2 +"<br></br>" + arr3 +"<br></br>" + arr4 + x;
}; 
//document.getElementById("demo").innerHTML = balancedBrackets(r);