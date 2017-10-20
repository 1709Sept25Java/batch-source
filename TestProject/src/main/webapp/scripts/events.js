window.onload = function() {

	document.getElementById("div1").addEventListener("mousemove", trackCursor,
			false);

	function trackCursor() {
		document.getElementById("mouseX").innerHTML = event.clientX;
		document.getElementById("mouseY").innerHTML = event.clientY;
	}
	;

	window
			.addEventListener(
					"resize",
					function() {
						document.getElementById("div3").innerHTML = "you resized the window at "
								+ event.timeStamp;
					});

	var myEventHandler = function(event) {
		console.log("target: " + event.target.id + " and this: " + this.id);
	};

	var displayDivs = document.getElementsByClassName("displayDiv");
	// console.log(displayDivs);
	for (var i = 0; i < displayDivs.length; i++) {
		// console.log(displayDivs[i]);
		displayDivs[i].addEventListener("click", myEventHandler, true);
	};
	
	function stopPropAndRoll(event) {
		alert("hello from c2");
		event.stopPropagation();
	};
	
	document.getElementById("c2").addEventListener("click",stopPropAndRoll,false);
}