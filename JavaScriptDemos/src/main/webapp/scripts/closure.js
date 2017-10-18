function getCount(noun) {
	var count = 0;
	return function(){	//self invoking function
		count += 0;
		console.log(noun+" count is: "+count);
		return count;
	}
}