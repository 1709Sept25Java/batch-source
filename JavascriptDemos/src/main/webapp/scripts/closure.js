function getCount(noun) {
	var count = 0;
	return function() {
		count+=1;
		console.log(noun+" count is: "+count);
		return count;
	}
};

//var appleCount = new getCount("apple");