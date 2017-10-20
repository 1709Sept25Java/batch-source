var toggle = setInterval(function() {
	console.log("called interval");
	setColor();
}, 3000);

function setColor() {
	console.log("called setColor");
	var x = document.body;
	x.style.backgroundColor = x.style.backgroundColor == "cyan" ? "#48972b"
			: "cyan";
};

function stopColor() {
	clearInterval(toggle);
};

function showTime(xhr) {
	var res = JSON.parse(xhr.responseText);
	var time = document.getElementById("time").lastChild.innerHTML = res.hour
			+ ":" + res.minute + ":" + res.second;
};

function getPokemon(xhr){
	var res = JSON.parse(xhr.responseText);
	var html = "<h4>Chosen pokemon has name: "+res.name+"</h4>";
	document.getElementById("pokeResult").innerHTML = html;
};

function sendAjaxGet(url,func){
	var xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		//console.log(this.readyState);
		if (this.readyState == 4 && this.status == 200){
			func(this);
		}
	};
	xhr.open("GET",url,true);
	xhr.send();
};

window.onload = function(){
	//set up initial time data 
	var initTime = document.getElementById("time");
	var d = new Date();
	var html = initTime.innerHTML;
	html += "<h4>"+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+"</h4>";
	initTime.innerHTML = html;
	setInterval(function(){
					sendAjaxGet('http://localhost:8082/JavaScriptDemos/time',showTime);
				},10000);
	document.getElementById("pokeButton").addEventListener("click",function(){
		sendAjaxGet('https://pokeapi.co/api/v2/pokemon/'+document.getElementById("pokeId").value,getPokemon);
	});
}