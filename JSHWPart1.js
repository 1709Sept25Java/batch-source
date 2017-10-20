var homework = {};

homework.fibonacci = function(n){
  if(n==0) {
    return 1;
  } else if(n<=2) {
    return 1;
  } else if(n>2) {
    var a = 1;
    var b = 1;
    for(i=2;i<=n-1;i++) {
      c = a + b;
      a = b;
      b = c;
    };
  };
    return c;
};

homework.sort = function(array) {
  var temp;
  for(j=1;j<=array.length-1;j++) {
    isNew = false;
    for(i=0;i<=array.length-1;i++) {
      if(array[i]>array[i+1]) {
        temp = array[i];
        array[i] = array[i+1];
        array[i+1] = temp;
      };
      console.log(array);
    };
  };
};

homework.factorial = function(n){
  if(n<=1) {
    return 1;
  } else if(n>1) {
    for(i=n-1;i>0;i--) {
      n = n*i;
      i*n;
    };
    return n;
  };
};

homework.rotateLeft = function(array,n) {
  for(j=1;j<=n;j++) {
    var firstValue = array[0];
    for(i=1;i<=array.length-1;i++) {
      array[i-1] = array[i];
    };
    array[array.length-1] = firstValue;
    console.log(array);
  };
};


//I know this one doesn't work! I'm still working on the logic. Any suggestions?

homework.balancedBrackets = function(bracketsString){

  var half = bracketsString.length/2;

  if(!bracketsString.includes("[","]","(",")","{","}")) {
    console.log("not a bracket String")
  } else if(!Number.isInteger(half) || half<2) {
    console.log("brackets not balanced");
  } else {

      if(("[" && "]") || ("(" && ")") || ("{" && "}")) {
        isBalanced = true;
      } else {
        isBalanced = false;
      };

      for(i=0;i<bracketsString.length;i++) {
        var x = bracketsString[i] && bracketsString[(bracketsString.length-1)-i].isBalanced;
        break;
      };

      if(x = true) {
          console.log("brackets are balanced");
      } else {
        console.log("brackets are not balanced");

      };
  };
};
