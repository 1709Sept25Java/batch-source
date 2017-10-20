window.onload = function(){

document.getElementById("div1").addEventListener("mousemove",trackCursor,false);

function trackCursor(){
	document.getElementById("mouseX").innerHTML = event.clientX;
	document.getElementById("mouseY").innetHTML = event.clientY;
}

window.addEventListener("resize",function(){
	document.getElementById("div3").innerHTML = "you resized the window at "+even.timeStamp;
})

var myEventHandler = function(event){
	console.log("target: "+event.target.id+" and this: "+this.id);
}

var displayDiv = document.getElementsByClassName("displayDiv");
for(var i=0;i<dispalyDivs.length;i++){
	displayDiv[i].addEventListener("click",myEventHandler,false);
}

function stopPropAndRoll(event){
	alert("hello from c2");
	event.stopPropagation();
}

document.getElementById("c2").addEventListener("click",stopPropAndRoll,false);

}