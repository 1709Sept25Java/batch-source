var homework = {};

homework.fibonacci = function(n){
	
	if (n == 0) {
		return 0;
	} else {
	var a = 0, b = 1, c = 1;
	    for(var i = 2; i <= n; i++) {
	        a = b;
	        b = c;
	        c = a + b; 
	    }
	    return c; 
	}
}; 



homework.sort = function(array) {
	
	for (i = 0; i < array.length; i++) {
		
		for (j = 0; j < array.length; j++) {
		
			if (array[j] > array[j+1]) {
				var temp = array[j];
				array[j] = array[j+1];
				array[j+1] = temp
			}
		}
	}
	
	return array;
};





homework.factorial = function(n){
     var result = n;
	
     if (n == 0 || n == 1) {
       return 1; }
     
	 while (n > 1) { 
       n--;
       result *= n;
     } 
   
   return result;
}; 



homework.rotateLeft = function(array, n){
	var array; 
	var n;
	var a = array.shift(); 
	
	for (i = 1; i < n; i++) {
		for (i = 1; i < array.length; i++) {
			array[i-1] = array[i];
		}		
	}
	
	array[array.length - 1] = a; 
	return array;
}; 





homework.balancedBrackets = function(bracketsString){
     var temp = [];
     var open = { '{': '}', '[': ']', '(': ')' };
     var close = { '}': true, ']': true, ')': true };
  
     
	 for (var i = 0; i < bracketsString.length; i ++) {
       var chr = bracketsString[i];
      
	   if (open[chr]) {
		   
		   temp.push(chr); 
      
	   } else if (close[chr]) {
        
		 if (open[temp.pop()] !== chr) return false;
       }
	   
     }
  
     return true; 

};