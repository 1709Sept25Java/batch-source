window.onload = function() {
var colorVar = setInterval(function() {
		setColor();
		
	},3000);
	function setColor() {
		var x = document.body;
		x.style.backgroundColor = x.style.backgroundColor == "cyan" ? "#8a7bc3": "#4583b6";
	}
	function stopColor() {
		clearInterval(colorVar);
	};
	
	function showTime(xhr) {
		var res = JSON.parse(xhr.responseText);
		var time = document.getElementById("time").lastChild.innerHTML = 
			res.hour + ":" + res.minute+":"+res.second;
		
		
	}
}