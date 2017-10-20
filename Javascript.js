function fibonacci(fb){
	var fb;
	var f = [];
	f[0] = 0;
	f[1] = 1;
	
	for(var i = 2; i<=fb;i++){
		f[i]=f[i-1]+f[i-2];
	}
	for(var i = 0; i<=fb;i++){
		console.log(f[i]+" ");
	}
}
	
function sort(f){
	var f;
	var a = f.length;
	var temp;
	for(var i = 0; i< a; i++)
	{
		for(var j = 1; j< a; j++) 
		{
			if(f[j] < f[j-1])
			{
				temp = f[j];
				f[j] = f[j-1];
				f[j-1] = temp; 
			}
		}
	}
	for(var i = 0; i<a; i++) {
		console.log(f[i] + " ");
	}		
}
function factorial(factorial){
	var factorial;
	var n = 1;
	for (var i = 1; i <= factorial; i++) {
		n = n * i;
		console.log(n);
	}
}
function rotateLeft(f,y){
	while(y--){
	var temp = f.shift();
	f.push(temp)
	console.log(f);
	}
}
function balancedBrackets(br) {
	var lpcount = 0;
	var rpcount = 0;
	var lbcount = 0;
	var rbcount = 0;
	var rccount = 0;
	var lccount = 0;
	for (var i = 0; i <= br; i++) {
		if (br[i] == '(') {
			lpcount++
		} else if (br[i] == ')') {
			rpcount++;
		} else if (br[i] == '[') {
			lbcount++;
		} else if (br[i] == ']') {
			rbcount++;
		} else if (br[i] == '{') {
			lccount++;
		} else if (br[i] == '}') {
			rccount++;
		}
	}
	if(lpcount == rpcount && lbcount == rbcount && lccount == rccount){
		return true;
	}else{
		return false;
	}
}